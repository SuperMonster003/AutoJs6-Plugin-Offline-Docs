# Installer source-profile reference synchronization

Date: 2026-10-02. Official source commit `6bdbdad6aed8d89b854b3489a80ac0a6c7cdf481`, content 6.8.0 / 88.
Offline Docs 6.8.6 / build 69 bundles that committed source. All 200 files match the
full official output after the documented LF normalization: 11,744,511 bytes, canonical SHA-256
`65786402628484d27bb4b59f23646f90477f0306c171ff70b2b99ea3f8ac7ec9`.

The reference covers source/package-prefix matching, first-match precedence, explicit false and
nullable resets, processing-start snapshots and retry behavior. Host integration requires build
5312 plus the negotiated V3 source-profiles feature. Interaction and batch timing remain outside
profiles; successful-but-retained items protect shared sources. Mandatory installation policy,
permission and Android signature checks still apply.

Validation includes Markdown normalization and freshness (144 modules), offline search syntax,
canonical BAT dry-run and --verify-offline (JVM tests plus Debug/Release APK content gates),
followed by exact committed-source provenance and multilingual generation checks. This update
remains local and does not announce a remote release or broader device validation.
