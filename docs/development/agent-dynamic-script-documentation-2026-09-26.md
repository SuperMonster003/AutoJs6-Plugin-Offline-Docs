# Agent dynamic script documentation

Development companion for AI Agent 1.1.0, verified on 2026-09-26.
Plugin version: 6.8.4, build 61. Documentation content remains 6.8.0.
No APK release was published.

- Source: AutoJs6-Documentation commit
  `f9ed7afe41f2cdf2603dc281323be33869ced6d7`, versionCode 80.
  Both provenance files and the README source metadata identify this tree.
- Documented the default-off `script_dynamic` group, individual source
  confirmation, private step history, diagnostic export redaction and
  user-initiated registration through the system file picker.
- Documented that generated JavaScript runs with host script capabilities;
  other model tool-group restrictions do not sandbox JavaScript internals.
- Full generation and freshness check passed: 143 modules, 6225 search entries.
  The source search index passed `node --check`.
- Dry-run review found exactly four changed offline assets and no additions or
  removals. Formal synchronization used `--verify-offline`; final build 61 was
  revalidated after fixing the Git-count version and exact source provenance.
- Final debug and signed R8 release APK content, license, metadata and native
  alignment guards passed. The document tree has 199 files and 11601029 bytes.
  Canonical content SHA-256:
  `e2f0ae9fa59b7e569d8e802ee7af40c107b691e30763eb2892866168f2f0308a`.
- The full official and bundled asset inventories match. Five inherited
  JavaScript/CSS files differ only by required LF normalization.
- Python repository tests: 4 passed. JVM tests: 2 passed. Offline normalization
  was a no-op. Ten-language Markdown generation/check passed with 25 artifacts,
  and `git diff --check` passed.

No device installation or Binder runtime test was repeated for this content
update. Earlier companion release runtime evidence remains in `release-6.8.3.md`.
