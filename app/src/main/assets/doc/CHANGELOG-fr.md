******

### Historique des versions

******

# v6.8.0

###### 2026/08/21

* `Amélioration` Alignement du versionName du plugin sur la version cible de la documentation AutoJs6 et incrémentation automatique de 1 du build/versionCode de chaque projet après une synchronisation réussie de la documentation
* `Amélioration` Mise à jour de la documentation AutoJs6 6.8.0 intégrée et de l'index de recherche hors ligne avec l'API Preview de détection d'objets YOLO, la configuration du fournisseur exact, le profil de modèle, les types de résultat et les codes d'erreur stables
* `Amélioration` Documentation de référence IA intégrée complétée avec la découverte des modèles de plugins, les sélecteurs officiels et de composants exacts, l'historique des messages multirôle, les paramètres de génération, les charges utiles précises d'utilisation et de streaming, ainsi que des exemples de routage complets
* `Amélioration` Référence IA intégrée et index de recherche hors ligne étendus avec l'API Conversation persistante `ai.session`, les paramètres de session fixes, les règles de cycle de vie à un nouveau prompt par tour, la découverte des capacités et la libération explicite des ressources
* `Amélioration` Référence IA intégrée et index hors ligne étendus avec la sortie contrainte par JSON Schema via `structuredJson`/`responseSchema`, un schema fixe pour les sessions persistantes, le retour de texte JSON et les règles d'échec
* `Amélioration` Référence IA intégrée et index hors ligne étendus avec les profils backend CPU/GPU/NPU explicites, la disponibilité par appareil et les raisons stables dans `ai.models`, un backend fixe par session persistante, les limites de compatibilité GPU et le contrat sans repli

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
