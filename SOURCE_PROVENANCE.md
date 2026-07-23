# Source provenance

- Source repository: `SuperMonster003/AutoJs6`
- Source commit: `37190cd9681b9d4bdc8e786f146b1b88f7818dc2`
- Source path: `app/src/main/assets-app/docs`
- Documentation version: `6.6.4`
- Content metadata: File count, total bytes, and canonical content SHA-256 are derived from the current `app/src/main/assets/docs` tree at build time and written to the manifest and inventory.

The recorded source identifies the upstream basis for the bundled
documentation. The checked-in tree is then processed by the project-owned
reproducible style normalization pass. That pass standardizes current-product
terminology, JavaScript declaration style, type links, API signature markup,
incomplete-section notices, known text defects, control-character cleanup, and
ASCII punctuation. The resulting files are
therefore not expected to be byte-identical to the upstream tree.

Run `python .python/normalize_offline_docs.py` from the project root to apply
the pass, or add `--check` to verify the checked-in tree without modifying it.

The source commit and documentation version must be updated when the upstream
documentation basis changes. The content metadata always describes the current
normalized `app/src/main/assets/docs` tree that is packaged in the APK.

The canonical digest is SHA-256 over the concatenation of one UTF-8 line per
file. Relative paths use `/`, records are sorted in ordinal ascending order,
and file SHA-256 values are lowercase hexadecimal:

```text
path<TAB>size<TAB>sha256(file)<LF>
```

No separate local documentation worktree is used as source provenance.
