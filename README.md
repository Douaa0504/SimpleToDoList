📝 SimpleToDoApp - Minimalist Task Manager
SimpleToDoApp est une application Android performante et élégante conçue pour aider les utilisateurs à organiser leur quotidien sans distractions. Ce projet illustre l'implémentation moderne de Jetpack Compose, de la persistance locale avec Room, et du respect strict de l'architecture MVVM (Model-View-ViewModel).

✨ Fonctionnalités clés
Gestion Intelligente des Tâches : Ajouter, éditer, et supprimer des tâches en un clic.

Barre de Progression Dynamique : Visualisez votre productivité quotidienne grâce à un calcul en temps réel du pourcentage de complétion.

Base de Données Locale : Vos données restent sur votre appareil grâce à Room SQLite, garantissant un accès hors-ligne total.

UI Moderne Material 3 : Une interface fluide avec des animations douces, respectant les standards de design de Google.

State Management : Utilisation de StateFlow pour une interface réactive et synchronisée avec la base de données.

🛠 Architecture & Stack Technique
L'application repose sur les bibliothèques Android les plus récentes pour garantir stabilité et performance :

Langage : Kotlin 2.0 (Dernière version)

UI : Jetpack Compose (Composants Material 3)

Persistance : Room Database

Architecture : MVVM + Clean Architecture

Injection de dépendances : Manuelle (optimisée pour la simplicité)

Navigation : Jetpack Compose Navigation (avec passage d'arguments safe)

📂 Structure du Projet
Plaintext
com.example.simpletodoapp/
├── data/           # Configuration Room : Entity, Dao, Database
├── model/          # Data classes (Modèle TodoTask)
├── ui/             # Composants UI (Screens, TaskItem, Theme)
├── viewmodel/      # Gestion de la logique et du flux de données (Uistate)
└── MainActivity.kt # Point d'entrée & Graph de Navigation
🚀 Installation et Lancement
Clonage du projet :

Bash
git clone https://github.com/Douaa0504/SimpleToDoList.git
Configuration :

Ouvrez le projet dans Android Studio Ladybug (ou version plus récente).

Utilisez le JDK 17 ou supérieur.

Compilation :

Synchronisez Gradle (le projet utilise le nouveau plugin Compose de Kotlin 2.0).

Lancez sur un émulateur (API 24+) ou un smartphone physique.

💡 Résolution de problèmes (Défis Techniques)
Pendant le développement, j'ai migré le projet vers Kotlin 2.0. Cela a nécessité :

Le remplacement de kotlinCompilerExtensionVersion par le nouveau plugin Gradle org.jetbrains.kotlin.plugin.compose.

L'ajustement des imports pour résoudre les erreurs de compilation liées au changement de namespace.

La gestion du cycle de vie des données avec collectAsState pour éviter les fuites de mémoire.

🤝 Contribution
Les contributions sont ce qui rend la communauté open source incroyable.

Forkez le projet.

Créez votre branche de fonctionnalité (git checkout -b feature/AmazingFeature).

Commitez vos changements (git commit -m 'Add some AmazingFeature').

Pushez la branche (git push origin feature/AmazingFeature).

Ouvrez une Pull Request.
