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
fileCount=200
totalBytes=11713370
contentSha256=032eaf17fb2bad281d4594e91f1e0d5b2ced4c83c85e6b2cb7221d3c0488f8ec
sourceRepository=SuperMonster003/AutoJs6-Documentation
sourceBaseCommit=f9ed7afe41f2cdf2603dc281323be33869ced6d7
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

# v6.8.5

###### 2026/10/01

* `Amélioration` Documentation AI Agent 1.2.0: Outils MCP de serveurs locaux ou externes choisis, avec un niveau de risque par serveur et le groupe mcp désactivé par défaut
* `Amélioration` Synchronisation de la connexion à la demande de 3-Stove Agent: centre de plugins comme unique interrupteur, activation initiale automatique et désactivation respectée, attente synchrone sur un thread de travail, requêtes asynchrones, status en lecture seule et aucune reprise de tâches
* `Amélioration` API de script installer / $installer, installation synchrone et asynchrone, événements de session, inspection des sources, désinstallation et autorisations, avec interaction par défaut et annulation

# v6.8.4

###### 2026/09/26

* `Amélioration` Documente le groupe script_dynamic de la version de développement AI Agent 1.1.0, la confirmation de chaque source, son historique privé et la sauvegarde des scripts enregistrés via le sélecteur de fichiers système

# v6.8.3

###### 2026/09/25

* `Amélioration` Documenter les exigences Android et hôte de Agent 1.0.0, le catalogue de modèles 3-Stone AI et les observations texte/OCR; conserver le contenu en 6.8.0 avec une version distincte du plugin
* `Amélioration` Synchronisation des groupes globaux, du mode prudent, des budgets et limites du protocole Agent, et des restrictions par profil et tâche
* `Amélioration` Synchroniser la mémoire des préférences Agent, les confirmations individuelles, les requêtes par portée, les imports/exports JSON et la distinction entre injection automatique et outils de mémoire
* `Amélioration` Synchronisation des préréglages Agent nommés, des choix par défaut et du modèle, de la fusion du contexte fixe et des restrictions des outils, budgets, confirmations, dossiers de scripts et portées mémoire
* `Amélioration` Synchronisation des API ai.agent, du cycle de vie AgentRun, des réponses et confirmations, budgets, résultats des scripts, trois exemples et index de recherche hors ligne
* `Amélioration` Synchronisation de la référence EPUB et de l'index de recherche hors ligne, couvrant le global epub du plugin Readium EPUB Reader, les membres d'EpubBook pour les métadonnées, la table des matières, l'ordre de lecture, l'extraction de texte, l'export de la couverture et des ressources et la recherche plein texte, les événements, commandes et préférences de lecture d'EpubReaderSession, l'objet de position EpubLocator et les codes EpubError
* `Amélioration` Synchronisation de la référence EPUB et de l'index de recherche hors ligne avec les surlignages et notes du plugin Readium EPUB Reader 1.1.0 (contrat EPUB version 2) : EpubBook#annotations et la couche de commodité epub.annotations, l'événement highlight d'EpubReaderSession et les porteurs d'EpubLocator

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


[16 KB page alignment and build verification](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/docs/16kb.md)
