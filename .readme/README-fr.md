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
contentVersion=6.8.0
contentFormat=autojs6-static-html-v1
assetRoot=docs
entryPoint=index.html
inventoryFile=offline-docs-inventory-v1.txt
fileCount=181
totalBytes=10058908
contentSha256=f8ce88d1e03a3e8ef0aeac3b616d7ca09b03cc20e8a5b0036418620a9d11b5fa
sourceRepository=SuperMonster003/AutoJs6-Documentation
sourceBaseCommit=e6bded6c8d0dbeb688c26eec2b5a241a4664ecc4
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

###### 2026/09/01

* `Amélioration` Synchronisation de la reference Image Quantization v4 et de l'index de recherche hors ligne avec des budgets configurables de pixels et de memoire de travail, des diagnostics types de limite de ressources, des mesures du pic de memoire comptabilisee et l'annulation sur demande explicite ou arret du script
* `Amélioration` Alignement du versionName du plugin sur la version cible de la documentation AutoJs6 et incrémentation automatique de 1 du build/versionCode de chaque projet après une synchronisation réussie de la documentation
* `Amélioration` Mise à jour de la documentation AutoJs6 6.8.0 intégrée et de l'index de recherche hors ligne avec l'API Preview de détection d'objets YOLO, la configuration du fournisseur exact, le profil de modèle, les types de résultat et les codes d'erreur stables
* `Amélioration` Documentation de référence IA intégrée complétée avec la découverte des modèles de plugins, les sélecteurs officiels et de composants exacts, l'historique des messages multirôle, les paramètres de génération, les charges utiles précises d'utilisation et de streaming, ainsi que des exemples de routage complets
* `Amélioration` Référence IA intégrée et index de recherche hors ligne étendus avec l'API Conversation persistante `ai.session`, les paramètres de session fixes, les règles de cycle de vie à un nouveau prompt par tour, la découverte des capacités et la libération explicite des ressources
* `Amélioration` Référence IA intégrée et index hors ligne étendus avec la sortie contrainte par JSON Schema via `structuredJson`/`responseSchema`, un schema fixe pour les sessions persistantes, le retour de texte JSON et les règles d'échec
* `Amélioration` Référence IA intégrée et index hors ligne étendus avec les profils backend CPU/GPU/NPU explicites, la disponibilité par appareil et les raisons stables dans `ai.catalog`, un backend fixe par session persistante, les limites de compatibilité GPU et le contrat sans repli
* `Amélioration` Toutes les API non publiées de liste et de détection de configuration IA ont été remplacées par le répertoire unifié de cibles `ai.catalog`, le routage exact par `target`, les métadonnées complètes de réponse et de session, les erreurs stables sans repli et les ressources en ligne/hors ligne synchronisées
* `Amélioration` Extension de la référence runtime intégrée et de l'index de recherche hors ligne avec six surcharges de `loadJarWithR8` pour l'export vérifié de mapping/seeds/usage/retrace metadata et l'API `retraceR8Stack` du protocole 1.1, avec liaison de provenance et échec fermé sans repli
* `Amélioration` Uniformiser la mise en page du README et la gestion des versions de la plateforme Gradle

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
