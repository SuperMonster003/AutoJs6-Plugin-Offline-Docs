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
fileCount=216
totalBytes=13277573
contentSha256=cfebb0216048caf6645971e373b937f05017530bdc5281f50060e8c46deb1e31
sourceRepository=SuperMonster003/AutoJs6-Documentation
sourceBaseCommit=62f55d88843db5a5a38d529de887b756a1d085f0
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

# v6.8.6

###### 2026/10/15

* `Correctif` Le commit source de la documentation indique dans le README pouvait differer de la provenance du contenu inclus
* `Amélioration` Profils Installer par source/préfixe de paquet, priorité des options explicites et trois réinitialisations nullables, sourceDeleteRequested et conservation des sources partagées du lot; hôte 5312+ et plugin compatible requis
* `Amélioration` Documentation et entrées de recherche hors ligne pour les méthodes de sélecteur minDepth/maxDepth/minIndexInParent/maxIndexInParent
* `Amélioration` Référence complète de l'API 3-Block Compose: noeuds et états, modificateurs, thèmes, sessions et fenêtres flottantes, propriétés et événements des composants, threads, accessibilité et applications empaquetées
* `Amélioration` 3-Block Compose TSX: TSX prend en charge `<compose.Column>`, `<compose:Text>`, les références aux fabriques de noeuds, les fragments, les emplacements et les rappels réactifs; un même arbre ne peut pas mélanger Compose et les anciens noeuds XML
* `Amélioration` Référence du module Terminal: sessions synchrones et asynchrones du plugin 3-Shell Terminal, événements de sortie, scripts npm, autorisations et cycle de vie, ainsi que les types TerminalSession, TerminalOpenOptions et TerminalError
* `Amélioration` Référence du module colors: conversions OKLab/OKLCH, ajustement du contraste, harmonies, gammes de tons, couleurs dérivées, variantes de nuit, simulation des déficiences de la vision des couleurs, couleurs dominantes d'une image, algorithme de détection oklab et contrôle de la couleur du thème avec colors.theme
* `Amélioration` Les icônes du centre de plugins utilisent les tailles, positions, images claires et sombres et fonds circulaires réglés dans Icon Studio, avec les sources et paramètres permettant de les reproduire
* `Amélioration` Les icônes des informations d'application Android utilisent les illustrations et les fonds clairs et sombres d'Icon Studio, en conservant les images transparentes du centre de plugins et les choix du lanceur
* `Amélioration` 3-Block Compose: Les conteneurs XML `<compose>` et compose.attach intègrent des sessions Compose indépendantes dans les pages UI ou les fenêtres flottantes existantes; compose.AndroidView affiche une View Android existante ou renvoyée par une fabrique synchrone
* `Amélioration` La référence 3-Block Compose couvre les dialogues indépendants et panneaux inférieurs, les règles de fermeture, la permission de superposition et le cycle de vie des sessions
* `Amélioration` Référence des composants 3-Block Compose V2 avec état contrôlé, événements, commandes de focus et de défilement, conditions d'utilisation et compatibilité
* `Amélioration` Référence de l'API device: device.getAndroidId accepte le booléen useSystemId pour lire la valeur système de l'utilisateur Android de l'application via Shizuku/Root sous Android 8.0+, lève une exception en cas d'échec d'autorisation ou de lecture et ignore ce paramètre sur les anciens systèmes
* `Amélioration` Référence AutoJs4 Runtime: objet du plugin AutoJs4 Runtime, installation et permissions distinctes, l'entrée "Exécuter avec AutoJs4" du gestionnaire de fichiers pour les fichiers .js / .auto et les dossiers de projet, transfert des journaux et arrêt des tâches, limites d'exécution et procédure de signalement des différences
* `Amélioration` Référence AutoJs4 Runtime: mode de comparaison "Exécuter avec AutoJs4 et comparer", avec les deux exécutions, les lignes de cadrage et le préfixe retirés, le résumé et les marqueurs de différence de la page de résultat, la copie du modèle d'issue et le délai de 120 secondes
* `Amélioration` Référence AutoJs4 Runtime: nouvelle section "Classes de compatibilité com.stardust" expliquant comment les noms de classe préfixés com.stardust sont associés aux implémentations AutoJs6 (association complète, partielle et plus fournie), l'effet des associations renommées sur le nom global d'importClass, et le fait que Class.forName n'est pas concerné
* `Amélioration` Référence du Concepteur 3-Block Compose: points d'entrée et fichiers de projet du concepteur visuel intégré au plugin, le canevas / plan / propriétés / état / palette de composants de l'éditeur, sa disposition en portrait et en paysage et ses brouillons, le sous-ensemble de script reconnu et les règles d'aller-retour, le passage bidirectionnel avec l'éditeur AutoJs6, la réécriture vers la source importée et sa réimportation, l'état d'aperçu et l'aperçu interactif avec leurs différences par rapport à une vraie exécution, les projets TSX (analysés par TypeScript Engine, en lecture seule sans lui), l'exécution du script d'un projet JavaScript dans le bac à sable de l'aperçu interactif avec sa console (Android 8.0 ou ultérieur), les projets UI (XML) (depuis 1.6.0: édition sur place des mises en page XML des scripts en mode ui, un canevas dessiné par le service d'aperçu d'AutoJs6, les gabarits de gestionnaires et le panneau des liaisons), et les limites actuelles; à partir de 1.7.0, l'aperçu interactif des projets UI (XML) fait exécuter tout le script par AutoJs6 pour de vrai (Android 13 et ultérieur), avec une nouvelle section sur l'exécution des scripts UI dans l'aperçu: conditions, règles d'arrêt, console et différences avec une exécution réelle
* `Amélioration` [Reference API](https://docs.autojs6.com/#/documentation): membres Files et RootAutomator manquants, tableaux de resultat des couleurs, contextes WebView et surcharges optionnelles, avec correction des parametres d'ajout d'octets, de balayage et des explications de mise a l'echelle des coordonnees; précise que les appels setScaleBases en échec ne modifient ni ne réservent les bases, et décrit la conversion en entier des setters de base
* `Amélioration` Référence du module Gallery: l'objet gallery fourni par le plugin 3-Maple Image (sélecteur, sessions de visionneuse, édition et conversion sans interface), la limite des fichiers lus et écrits par AutoJs6, l'accès aux photos, les codes d'erreur et le type GalleryViewSession
* `Amélioration` Référence de files.batchRename: renommage par lots fourni par le plugin Batch Rename, avec aperçu du plan et exclusion par élément, application, annulation et historique des lots, options et variables de remplacement, politiques de conflit, objets de résultat et codes d'erreur

# v6.8.5

###### 2026/10/02

* `Amélioration` Documentation AI Agent 1.2.0: Outils MCP de serveurs locaux ou externes choisis, avec un niveau de risque par serveur et le groupe mcp désactivé par défaut
* `Amélioration` Synchronisation de la connexion à la demande de 3-Stove Agent: centre de plugins comme unique interrupteur, activation initiale automatique et désactivation respectée, attente synchrone sur un thread de travail, requêtes asynchrones, status en lecture seule et aucune reprise de tâches
* `Amélioration` API de script installer / $installer, installation synchrone et asynchrone, événements de session, inspection des sources, désinstallation et autorisations, avec interaction par défaut et annulation
* `Amélioration` installer P8: autorisation Dhizuku, installation notification, modes par défaut preferred/persistent et limites des capacités du plugin
* `Amélioration` Préciser les valeurs persistantes de l'installateur: Dhizuku API 26-33, identité Root/system pour user 0, sélection automatique des autorisations, reçus locaux et écritures non confirmées
* `Amélioration` Options avancées Installer, observations de propriété et DexOpt, étape optimizing, négociation V3 et limites des règles locales de signature/blocage

# v6.8.4

###### 2026/09/26

* `Amélioration` Documente le groupe script_dynamic de la version de développement AI Agent 1.1.0, la confirmation de chaque source, son historique privé et la sauvegarde des scripts enregistrés via le sélecteur de fichiers système

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
