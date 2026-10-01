# Installer advanced reference synchronization

Date: 2026-10-02. Source documentation commit:
`695f21a0b9cec6c60ce94c504cb5b8f4a517bb40`, content version 6.8.0, versionCode 87.
Offline Docs remains version 6.8.5 with build 68 for this synchronization.

The source reference now documents the five V3 options, explicit false/none versus omission,
platform and authorizer limits, optimizing and optional updateOwner/dexopt observations.
Owner null is scoped to the calling identity's Android response, not proof of global absence.
Dexopt accepted includes a platform skip. Confirmed installation is not rolled back by a failed
follow-up operation. Local signature checks, exact package/shared-UID blacklists, selected-split
permission declarations and the non-overridable cross-user uncertainty boundary are described.
No source-profile feature or completed P9 device matrix is claimed.

Validation:

- All 144 Markdown modules pass normalization, full generation and freshness checks; the
  offline search index passes its JavaScript syntax check.
- Canonical sync dry-run and `--verify-offline` pass, with four changed bundled files.
- After pinning the committed source in both provenance files and README metadata, Debug and
  Release APK content gates pass again. The existing two JVM tests pass without failures/skips.
- All 200 official files match the bundled tree after the documented LF normalization.
  Total bytes: 11,737,025. Canonical content SHA-256:
  `5007ae8d62dfb04a242af4ac6be646b42b3c1a49c12c335c6c492cfe8bb22811`.
- All 25 generated multilingual history/README artifacts pass their freshness check.

This is a local content update. No remote publication, tags or user-device changes were made.
