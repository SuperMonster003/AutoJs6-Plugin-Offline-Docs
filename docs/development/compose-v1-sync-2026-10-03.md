# Compose UI V1 documentation synchronization

Date: 2026-10-03. Documentation source commit:
2832a4d13edec60e4c4d126b20bb7599352746ca. Source content version remains 6.8.0;
the wrapper advances its build counter from 89 to 90. This plugin remains 6.8.6
and advances VERSION_BUILD from 70 to the next reachable commit count71.

The synchronized site contains the complete Compose module page and seven
Node/State/Modifier/Session/FloatyWindow/Theme/Components pages. It documents the
actual local V1 runtime, including callback receivers, property read/write
normalization, nullish option boundaries, thread ownership, asynchronous native
disposal, selectors and real packaged-app requirements. It does not claim JSX,
mixed View/Compose content or a standalone compose.dialog entry.

The component region is generated from the host's frozen catalog, covering 30
entries and 114 canonical properties. The same region is checked against the
actual TypeScript declarations. The source repository was clean when the source
commit was pinned in both SOURCE_PROVENANCE copies and .readme/common.json.
The later project.json counter change does not change the recorded API source.

Validation:

- Full generation and freshness: 152 modules, 6543 search entries.
- The required wrapper --dry-run was reviewed before --verify-offline.
- --verify-offline completed the real synchronization, JVM tests and the existing
  debug/release APK-content verification task successfully.
- JVM: 2 tests, zero failures/errors/skips. Repository Python checks: 4 passed.
- Offline Markdown/HTML normalization check: 152 files, changed=0.
- All 208 site assets match the source. Five pre-existing JavaScript/CSS files
  undergo only the documented CRLF-to-LF normalization; binary assets are identical.
- Generated multilingual README/changelog: 25 outputs match their ten sources.
- Resulting debug APK: 5238120 bytes; release APK: 4003309 bytes. These are local
  build outputs, not a public release or a claim of device installation.

The existing snapshot/atomic synchronization path handled the site replacement;
no generated page was hand-edited. New Compose content and its navigation update
145 existing assets and add eight HTML pages. No source API, native library,
permission, Android component or document-viewer behavior was changed.
All changes are committed locally; no push, npm publication or public Release.
