<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-offline-docs-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>Plugin de contenu de documentation hors ligne 6.6.4 pour AutoJs6</p>

  <p>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/SuperMonster003/AutoJs6-Plugin-Offline-Docs?label=Release"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-Offline-Docs?color=A24232&label=Issues"/></a>
    <br>
    <a href="https://developer.android.com/studio/archive"><img alt="Android Studio" src="https://img.shields.io/badge/Android%20Studio-2023.3+-B64FC8"/></a>
    <a href="https://www.jetbrains.com/idea/download/other.html"><img alt="IntelliJ IDEA" src="https://img.shields.io/badge/IntelliJ%20IDEA-2023.3+-EE4677"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/LICENSE"><img alt="GitHub License" src="https://img.shields.io/github/license/SuperMonster003/AutoJs6-Plugin-Offline-Docs?color=534BAE&label=License"/></a>
  </p>
</div>

******

### Langues (Languages)

******

Le README.md actuel prend en charge les langues suivantes:

- [简体中文 [zh-Hans]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-zh-Hans.md)
- [繁體中文 (香港) [zh-Hant-HK]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-zh-Hant-HK.md)
- [繁體中文 (台灣) [zh-Hant-TW]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-zh-Hant-TW.md)
- [English [en]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-en.md)
- Français [fr] # actuel
- [Español [es]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-es.md)
- [日本語 [ja]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-ja.md)
- [한국어 [ko]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-ko.md)
- [Русский [ru]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-ru.md)
- [العربية [ar]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-ar.md)

******

### Introduction

******

Le plugin Offline Documentation d'AutoJs6 fournit le site complet de documentation 6.6.4 sous forme de paquet de contenu installable séparément.

******

### Contrat du plugin

******

```text
applicationId=io.github.supermonster003.autojs6.plugin.offlinedocs
pluginId=offline-docs
engine=offline-docs
variant=6.6.4
contractVersion=1
requiredHostVersionCode=5240
contentVersion=6.6.4
contentFormat=autojs6-static-html-v1
assetRoot=docs
entryPoint=index.html
inventoryFile=offline-docs-inventory-v1.txt
fileCount=161
totalBytes=6996000
contentSha256=3cb93aa2a8228a5566c6fec278f0e625886694f6fc9b57f8a36224d8f030ecf8
sourceRepository=SuperMonster003/AutoJs6
sourceCommit=37190cd9681b9d4bdc8e786f146b1b88f7818dc2
sourcePath=app/src/main/assets-app/docs
discovery=org.autojs.plugin.INFO|org.autojs.plugin.OFFLINE_DOCS
category=offline-docs
```

OfflineDocsPluginInfoService publie PluginInfo via IPluginInfoProvider. L'hôte accepte le paquet fixe uniquement après les contrôles d'activation, de compatibilité, de signature, de métadonnées et d'empreinte du contenu.

******

### Contenu

******

L'APK universal contient 161 fichiers sous `assets/docs/`, pour un total de 6996000 octets. Leur empreinte canonique SHA-256 fait partie du contrat version 1.

******

### Compilation et vérification

******

Compile les deux variantes, exécute les tests JVM et applique les contrôles d'APK unique, d'empreinte, de métadonnées, de liens rompus connus, d'absence de charge `lib/*.so` et de licences:

```powershell
.\gradlew.bat :app:testDebugUnitTest :app:verifyOfflineDocsApks
```

La vérification d'une version publiable exige également le fichier `sign.properties`, ignoré par Git:

```powershell
.\gradlew.bat :app:verifyOfflineDocsPublishableApks
```

******

### Comportement à l'exécution

******

Le plugin ne possède pas d'interface autonome. AutoJs6 le découvre et le valide à la demande, puis sert la documentation directement depuis l'AssetManager du plugin via son chargeur privé de ressources WebView. L'hôte détecte le remplacement ou la désactivation du plugin.

******

### Historique des versions

******

# v1.0.0

###### 2026/07/23

* `Fonctionnalité` Publication du plugin autonome de documentation hors ligne AutoJs6 6.6.4 avec découverte par le contrat version 1 et un seul APK universal
* `Fonctionnalité` Ajout de 161 fichiers de documentation, de métadonnées localisées et des notices complètes Apache-2.0, GPL-3.0, MIT et OFL-1.1
* `Amélioration` Ajout de contrôles JVM et APK pour l'empreinte canonique, les métadonnées du contrat, la base des liens rompus connus, l'unique APK universal, l'absence de charges `lib/*.so` et les licences
* `Amélioration` Enregistrement du commit et du chemin source AutoJs6 exacts du contenu de documentation copié octet par octet

##### Pour plus d'historique des versions

* [CHANGELOG.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/app/src/main/assets/doc/CHANGELOG-fr.md)

******

### Licence

******

La documentation issue d'AutoJs6-Documentation est sous Apache-2.0. Le modèle, les styles et le contenu dérivé de la documentation Node.js sont sous MIT, tout comme medium-zoom, docsify-copy-code et dnt-helper. SHJS est sous GPL-3.0. Lato est sous OFL-1.1.

Chaque APK contient un résumé des attributions et les textes complets Apache-2.0, GPL-3.0, MIT et OFL-1.1 sous `assets/licenses/docs/`.

******

### Structure des ressources

******

```text
.readme/lang_*.json
.changelog/lang_*.json
.python/generate_markdown.py
app/src/main/res/values-*/strings.xml
app/src/main/res/raw-*/plugin_instruction.md
app/src/main/assets/doc/CHANGELOG-*.md
```

`strings.xml` contient les descriptions localisées du plugin; `plugin_instruction.md` contient les instructions d'utilisation affichées par l'hôte. README et CHANGELOG sont générés depuis des sources JSON par `.python/generate_markdown.py`, et la sortie CHANGELOG complète est écrite dans `app/src/main/assets/doc/`.

******

### Liens

******

- [AutoJs6](https://docs.autojs6.com/)
- [AutoJs6 Documentation](https://docs.autojs6.com/)
