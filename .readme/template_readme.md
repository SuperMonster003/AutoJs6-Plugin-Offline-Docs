<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <img src="{{ repo_url }}/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="{{ icon_alt }}" border="0" width="128" />
    </picture>
  </p>

  <p>{{ text_plugin_synopsis }}</p>

  <p>
    <a href="{{ repo_url }}/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/{{ repo_slug }}?label=Release"/></a>
    <a href="{{ repo_url }}/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/{{ repo_slug }}?color=A24232&label=Issues"/></a>
    <a href="{{ license_url }}"><img alt="GitHub License" src="https://img.shields.io/github/license/{{ repo_slug }}?color=534BAE&label=License"/></a>
  </p>
</div>

******

### {{ h3_languages_with_ascii }}

******

{{ p_languages_all_supported_for_readme }}:

{{ placeholder_ul_languages_all_supported }}

******

### {{ h3_introduction }}

******

{{ p_introduction }}

******

### {{ h3_contract }}

******

```text
applicationId={{ plugin_application_id }}
pluginId={{ plugin_id }}
engine={{ plugin_engine }}
variant={{ plugin_variant }}
contractVersion={{ plugin_contract_version }}
requiredHostVersionCode={{ required_host_version_code }}
contentVersion={{ content_version }}
contentFormat={{ content_format }}
assetRoot={{ asset_root }}
entryPoint={{ entry_point }}
inventoryFile={{ inventory_file }}
fileCount={{ file_count }}
totalBytes={{ total_bytes }}
contentSha256={{ content_sha256 }}
sourceRepository={{ source_repository }}
sourceBaseCommit={{ source_base_commit }}
sourcePath={{ source_path }}
sourceGenerator={{ source_generator }}
discovery=org.autojs.plugin.INFO|org.autojs.plugin.OFFLINE_DOCS
category=offline-docs
```

{{ p_contract }}

******

### {{ h3_content }}

******

{{ p_content }}

******

### {{ h3_build }}

******

{{ p_build }}:

```powershell
.\gradlew.bat :app:testDebugUnitTest :app:verifyOfflineDocsApks
```

{{ p_publishable_release_verification }}:

```powershell
.\gradlew.bat :app:verifyOfflineDocsPublishableApks
```

******

### {{ h3_runtime }}

******

{{ p_runtime }}

******

### {{ h3_release_history }}

******

{{ placeholder_latest_release_history }}

##### {{ h5_for_more_release_history }}

* {{ placeholder_read_more_in_changelog_md }}

******

### {{ h3_license }}

******

{{ p_license }}

{{ p_license_assets }}

******

### {{ h3_resource_layout }}

******

```text
.readme/lang_*.json
.changelog/lang_*.json
.python/normalize_offline_docs.py
.python/generate_markdown.py
app/src/main/res/values-*/strings.xml
app/src/main/res/raw-*/plugin_instruction.md
app/src/main/assets/doc/CHANGELOG-*.md
```

{{ p_resource_layout }}.

******

### {{ h3_links }}

******

- [AutoJs6]({{ autojs6_docs_url }})
- [AutoJs6 Documentation]({{ autojs6_docs_url }})
