# Installer persistent-default documentation synchronization

Date: 2026-10-02.

Source: AutoJs6-Documentation commit `2ada5142efb29bfb03760d4323147e15dd053504`,
documentation content version 6.8.0, source versionCode 86. The offline plugin remains
6.8.5, with build 67 for this logical synchronization commit.

The installer reference distinguishes current intent resolution from a local persistent
configuration receipt. It documents Dhizuku persistent defaults on API 26-33, rejection before
writes on API 34+, the conditional Root/system transport for user 0, operation-specific automatic
authorizer selection and the limits of rollback after uncertain writes. Script booleans remain
unchanged; a protocol receipt is not exposed as a nonexistent script property.

Validation:

- Markdown normalization and full freshness checks passed for all 144 documentation modules.
- The required sync dry-run changed only the installer, progress, changelog and search assets.
- The canonical BAT `--verify-offline` workflow passed. After committing the source and pinning
  its exact commit in both provenance copies and README metadata, the final JVM/payload gates
  passed again: 2 JVM tests, no failures or skips, and Debug/Release APK content checks.
- All 200 official generated files match the bundled tree after the documented LF normalization.
  Total bytes: 11,726,643. Canonical content SHA-256:
  `ca114b049bcdba1c2c9c0710d4e829865be00ce7317bf75f54e176b8e9eae800`.
- Ten-language changelog and README generation passed the 25-artifact freshness check.

This is a local documentation synchronization, not a remote publication or a new claim of
installer device compatibility. Backend evidence remains in the installer plugin repository.
