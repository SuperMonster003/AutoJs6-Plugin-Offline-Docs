"""Keep generated README provenance aligned with the packaged source record."""
import importlib.util
from pathlib import Path
import tempfile
import unittest


SPEC = importlib.util.spec_from_file_location(
    "generate_markdown", Path(__file__).with_name("generate_markdown.py")
)
GENERATOR = importlib.util.module_from_spec(SPEC)
SPEC.loader.exec_module(GENERATOR)


class SourceProvenanceTest(unittest.TestCase):
    def setUp(self):
        self.temporary = tempfile.TemporaryDirectory()
        self.addCleanup(self.temporary.cleanup)
        self.root = Path(self.temporary.name)
        self.paths = (
            self.root / "SOURCE_PROVENANCE.md",
            self.root / "app/src/main/assets/licenses/docs/SOURCE_PROVENANCE.md",
        )
        self.revision = "1234567890abcdef" * 2 + "12345678"
        for path in self.paths:
            path.parent.mkdir(parents=True, exist_ok=True)
            self.write_revision(path, self.revision)

    @staticmethod
    def write_revision(path, revision):
        path.write_text(f"# Source provenance\n\n- Source base commit: `{revision}`\n", encoding="utf-8")

    def test_shared_source_revision_is_used_for_readme(self):
        self.assertEqual(
            {"source_base_commit": self.revision},
            GENERATOR.offline_docs_source_metadata(self.root),
        )

    def test_differing_packaged_source_revision_is_rejected(self):
        self.write_revision(self.paths[1], "a" * 40)
        with self.assertRaisesRegex(ValueError, "source commits differ"):
            GENERATOR.offline_docs_source_metadata(self.root)

    def test_invalid_source_revision_is_rejected_on_either_side(self):
        for path in self.paths:
            with self.subTest(path=path):
                self.write_revision(path, "unknown")
                with self.assertRaisesRegex(ValueError, "Invalid documentation source commit"):
                    GENERATOR.offline_docs_source_metadata(self.root)
                self.write_revision(path, self.revision)


if __name__ == "__main__":
    unittest.main()
