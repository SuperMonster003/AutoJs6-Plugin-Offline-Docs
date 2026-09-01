******

### Release History

******

# v6.8.0

###### 2026/09/01

* `Fix` Offline documentation validators no longer treat the public Node bridge method name `callAutoJs` as a legacy bare product name
* `Improvement` Synchronized the MediaInfo reference and offline search index with the legacy `read` versus versioned `snapshot` boundary, plugin snapshot v1/v2 schema negotiation, lightweight `capabilities`, and dynamic v2 track plus engine metadata
* `Improvement` Synchronized the Pinyin reference and offline search index with per-call `customDictionary` reading overrides, completed `compare`/`compact`, and Node.js access through `autojs6:bridge.callAutoJs` with the explicit `pinyin` capability
* `Improvement` Synchronized the Image Quantization v4 reference and offline search index with configurable pixel and working-memory budgets, typed resource-limit diagnostics, accounted peak-memory metrics, and cancellation on explicit requests or script shutdown
* `Improvement` Aligned the plugin versionName with the target AutoJs6 documentation version and automatically incremented each project's build/versionCode by 1 after a successful documentation sync
* `Improvement` Updated the bundled AutoJs6 6.8.0 documentation and offline search index with the YOLO target-detection Preview API, exact-provider setup, model profile, result types, and stable error codes
* `Improvement` Completed the bundled AI reference with plugin model discovery, official and exact-component selectors, multi-role message history, generation controls, precise usage and streaming payloads, and complete routing examples
* `Improvement` Extended the bundled AI reference and offline search index with the persistent `ai.session` Conversation API, fixed session controls, one-prompt-per-turn lifecycle rules, capability discovery, and explicit cleanup semantics
* `Improvement` Extended the bundled AI reference and offline search index with native JSON Schema constrained output through `structuredJson`/`responseSchema`, fixed persistent-session schemas, JSON text return semantics, and failure behavior
* `Improvement` Extended the bundled AI reference and offline search index with explicit CPU/GPU/NPU backend profiles, `ai.catalog` per-device availability and stable unavailable reasons, fixed persistent-session backend selection, GPU compatibility limits, and the no-fallback contract
* `Improvement` Replaced all unpublished AI listing and configuration-probe APIs with the unified `ai.catalog` target directory, exact `target` routing, complete response and session metadata, stable no-fallback failures, and synchronized online/offline assets
* `Improvement` Extended the bundled runtime reference and offline search index with six `loadJarWithR8` overloads for verified mapping/seeds/usage/retrace-metadata export and the protocol 1.1 `retraceR8Stack` API, including provenance binding and fail-closed no-fallback behavior
* `Improvement` Standardize the README layout and Gradle platform version management

# v1.0.1

###### 2026/07/25

* `Improvement` Replaced the fixed content fingerprint baseline with content metadata and an inventory generated automatically from the current documentation assets, allowing the assets to be updated directly
* `Improvement` Generated and synchronized the offline documentation from the official AutoJs6 Markdown sources, keeping the online and offline content aligned
* `Improvement` Aligned the built-in documentation with the AutoJs6 API reference style and standardized the current product name, JavaScript variable declarations, local type links, incomplete-section notices, and ASCII punctuation
* `Improvement` Improved offline documentation navigation with full-text search across titles and content and direct jumps to matching sections

# v1.0.0

###### 2026/07/23

* `Feature` Released the standalone AutoJs6 6.6.4 Offline Documentation content plugin with contract version 1 discovery and one universal APK
* `Feature` Packaged 161 documentation files with localized plugin metadata and complete Apache-2.0, GPL-3.0, MIT, and OFL-1.1 notices
* `Improvement` Added JVM and APK gates for the canonical content fingerprint, contract metadata, known broken-link baseline, single universal artifact, absence of `lib/*.so` payloads, and license assets
* `Improvement` Recorded the exact AutoJs6 source commit and source path for the byte-for-byte documentation payload
