<p align="center">
<img src="https://image.flaticon.com/icons/svg/311/311334.svg" width="150">
</p>

<p align="center">
<img src="http://hits.dwyl.io/pawel956/pawel956/projetKarimAndCo_ConnexionInscription.svg">
<img src="https://img.shields.io/github/contributors/pawel956/projetKarimAndCo_ConnexionInscription">
<img src="https://img.shields.io/github/repo-size/pawel956/projetKarimAndCo_ConnexionInscription">
<img src="https://img.shields.io/badge/project-maven-red">
</p>

### ProjetKarimAndCo - composant 1 : connexion et inscription
---

#### Introduction
Dans le cadre de création d'un logiciel de gestion de **curriculum vitae**, ce projet contient un composant permettant l'inscription et la connexion au logiciel.

#### Fonctionnalités
Avec ce composant, on peut :
 + S'inscrire
	 + Vérification du format des informations saisies dans les champs
	 + Vérification si la date de naissance est réelle (via un serveur de date et la BDD)
 + Se connecter

#### Documentation
Javadoc : [cliquez-ici](https://pawel956.github.io/projetKarimAndCo_ConnexionInscription/)  
Document utilisateur : [cliquez-ici](https://docs.google.com/document/d/1nW1IItZ4RfnRoahEaQirap2QfmtTX6tPgkBLDmhopvI/edit?usp=sharing)

#### Dépendances utilisées
[<img src="https://img.shields.io/badge/commons--net-3.6-success">](http://mirrors.ircam.fr/pub/apache//commons/net/binaries/commons-net-3.6-bin.zip)  

[<img src="https://img.shields.io/badge/mysql--connector--java-5.1.48-success">](https://repo1.maven.org/maven2/mysql/mysql-connector-java/5.1.48/mysql-connector-java-5.1.48.jar)

#### Pour intégrer ce composant à un projet sur Netbeans
+ 1ère étape, pour télécharger le package :

[cliquez-ici](https://github.com/pawel956/projetKarimAndCo_ConnexionInscription/archive/master.zip) → aller dans le dossier des téléchargements → extraire le package du fichier .zip

+ 2ère étape, pour intégrer le package au nouveau projet :

Ouvrir Netbeans → ouvrir le projet → clique droit sur le package `com.karimandco.auth` → Copy → aller dans le nouveau projet, clique droit sur `Source Packages` → Paste

+ 3ème étape, pour intégrer un composant dans un `JFrame Form` ou `JPanel Form` :

Clique droit sur la classe `PanneauFormConnexion` ou `PanneauFormInscription` → Tools → Add to Palette → choisir une catégorie de Palette → aller dans une classe de type `JFrame Form` ou `JPanel Form` → aller dans l'onglet `Design` → sur la droite, cliquer sur le composant et recliquer dans la fenêtre pour placer le composant

⚠ Ne pas oublier d'intégrer les dépendances dans le projet

#### Pour tester ce composant sur Netbeans
Après avoir télécharger et ouvert le projet :
Cliquer sur `Clean and build` → lancer le projet depuis la classe `TestForm`

#### Informations utiles pour la base de données
Toutes les méthodes en lien avec la base de données sont regroupées dans la classe DaoSIO.  

Pour exécuter une requête de type SELECT, on doit saisir : DaoSIO.getInstance().requeteSelection(`SQL`)  
Pour exécuter une requête de type ACTION, on doit saisir : DaoSIO.getInstance().requeteAction(`SQL`)