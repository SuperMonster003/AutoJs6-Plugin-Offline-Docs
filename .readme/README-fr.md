<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-offline-docs-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>Plugin de contenu de documentation hors ligne 6.8.0 pour AutoJs6</p>

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

Le plugin Offline Documentation d'AutoJs6 fournit le site complet de documentation 6.8.0 sous forme de paquet de contenu installable séparément.

******

### Contrat du plugin

******

```text
applicationId=io.github.supermonster003.autojs6.plugin.offlinedocs
pluginId=offline-docs
engine=offline-docs
variant=6.8.0
contractVersion=1
requiredHostVersionCode=5240
contentVersion=6.8.0
contentFormat=autojs6-static-html-v1
assetRoot=docs
entryPoint=index.html
inventoryFile=offline-docs-inventory-v1.txt
fileCount=180
totalBytes=9940465
contentSha256=85f4791cf50ec068aa31dad06e621ada3cf82f86e3e08b2f0c37ed4753530544
sourceRepository=SuperMonster003/AutoJs6-Documentation
sourceBaseCommit=8aed22caaa7c1c4dcd3c93389e5f93ce5e18f64c
sourcePath=api
sourceGenerator=generator/auto-generate-for-autojs6.bat
discovery=org.autojs.plugin.INFO|org.autojs.plugin.OFFLINE_DOCS
category=offline-docs
```

OfflineDocsPluginInfoService publie PluginInfo via IPluginInfoProvider. L'hôte accepte le paquet fixe uniquement après les contrôles d'activation, de compatibilité, de signature, de métadonnées, d'inventaire et de cohérence du contenu des fichiers.

******

### Contenu

******

Les métadonnées du contenu et l'inventaire sont dérivés automatiquement des ressources de documentation actuelles sous `assets/docs/`. L'hôte vérifie la cohérence mutuelle des métadonnées, de l'inventaire et du contenu des fichiers. La documentation hors ligne permet une recherche en texte intégral dans les titres et le contenu des pages, avec un accès direct aux sections correspondantes depuis les résultats.

******

### Compilation et vérification

******

Compile les deux variantes, exécute les tests JVM et applique les contrôles APK portant sur les métadonnées de contenu générées dynamiquement, les métadonnées du contrat, les liens rompus, l'unique APK universal, l'absence de charges `lib/*.so` et les licences:

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

# v6.8.0

###### 2026/08/12

* `Amélioration` Actualisation de la documentation API AutoJs6 6.8.0 avec le lancement des fichiers Python locaux via le plugin Python Runtime indépendant et un échec sans repli vers JavaScript
* `Amélioration` Alignement du versionName du plugin sur la version cible de la documentation AutoJs6 et incrémentation automatique de 1 du build/versionCode de chaque projet après une synchronisation réussie de la documentation

# v1.0.1

###### 2026/07/25

* `Amélioration` Remplacement de la base fixe de l'empreinte du contenu par des métadonnées de contenu et un inventaire générés automatiquement à partir des ressources de documentation actuelles, permettant leur mise à jour directe
* `Amélioration` Génération et synchronisation de la documentation hors ligne à partir des sources Markdown officielles d'AutoJs6, afin d'aligner les contenus en ligne et hors ligne
* `Amélioration` Harmonisation de la documentation intégrée avec le style de référence de l'API AutoJs6 et normalisation du nom actuel du produit, des déclarations de variables JavaScript, des liens de types locaux, des avis de sections à compléter et de la ponctuation ASCII
* `Amélioration` Amélioration de la navigation dans la documentation hors ligne avec la recherche en texte intégral dans les titres et le contenu, ainsi que l'accès direct aux sections correspondantes

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
.python/normalize_offline_docs.py
.python/generate_markdown.py
app/src/main/res/values-*/strings.xml
app/src/main/res/raw-*/plugin_instruction.md
app/src/main/assets/doc/CHANGELOG-*.md
```

`strings.xml` contient les descriptions localisées du plugin; `plugin_instruction.md` contient les instructions d'utilisation affichées par l'hôte. `.python/normalize_offline_docs.py` sert de validateur en lecture seule pour la documentation hors ligne générée. README et CHANGELOG sont générés depuis des sources JSON par `.python/generate_markdown.py`, et la sortie CHANGELOG complète est écrite dans `app/src/main/assets/doc/`.

******

### Liens

******

- [AutoJs6](https://docs.autojs6.com/)
- [AutoJs6 Documentation](https://docs.autojs6.com/)
