# Source provenance

- Source repository: `SuperMonster003/AutoJs6-Documentation`
- Source base commit: `c2e1ced156259ba1f60c46e37802a70b8223119e`
- Source path: `api`
- Source generator: `generator/auto-generate-for-autojs6.bat`
- Documentation version: `6.8.0`
- Content metadata: File count, total bytes, and canonical content SHA-256 are derived from the current `app/src/main/assets/docs` tree at build time and written to the manifest and inventory.

The recorded base commit identifies the Git basis of the official
documentation working tree used for this generation. The bundled HTML, CSS,
JavaScript, and search index are generated from the Markdown sources and
generator assets in that working tree. Documentation style normalization is
applied to the Markdown source before generation.

The synchronization pipeline runs
`python .python/normalize_offline_docs.py --check` as a read-only compatibility
gate. It does not rewrite the generated plugin assets.

The source base commit, source path, generator, and documentation version must
be updated when their basis changes. The content metadata always identifies
the exact generated `app/src/main/assets/docs` tree packaged in the APK,
including working-tree changes relative to the recorded base commit.

The canonical digest is SHA-256 over the concatenation of one UTF-8 line per
file. Relative paths use `/`, records are sorted in ordinal ascending order,
and file SHA-256 values are lowercase hexadecimal:

```text
path<TAB>size<TAB>sha256(file)<LF>
```

The generated HTML in this repository is not an independent documentation
source and should not be edited by hand.
