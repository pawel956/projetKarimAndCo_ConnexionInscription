<p align="center">
<img src="https://image.flaticon.com/icons/svg/311/311334.svg" width="150">
</p>

<p align="center">
<img src="http://hits.dwyl.io/pawel956/pawel956/projetKarimAndCo_ConnexionInscription.svg">
<img src="https://img.shields.io/github/contributors/pawel956/projetKarimAndCo_ConnexionInscription">
<img src="https://img.shields.io/github/repo-size/pawel956/projetKarimAndCo_ConnexionInscription">
</p>

### ProjetKarimAndCo - composant 1 : connexion et inscription
---

#### Introduction
Dans le cadre de création d'un logiciel de gestion de **curriculum vitae**, ce projet contient un composant permettant l'inscription et la connexion au logiciel.

#### Fonctionnalités
Avec ce composant, on peut :
 + S'inscrire
	 + Vérification du format des informations saisies dans les champs
	 + Vérification si la date de naissance est réelle (via un serveur de date)
 + Se connecter

#### Documentation
Javadoc : [cliquez-ici](https://pawel956.github.io/projetKarimAndCo_ConnexionInscription/)  
Document utilisateur : [cliquez-ici](https://docs.google.com/document/d/1nW1IItZ4RfnRoahEaQirap2QfmtTX6tPgkBLDmhopvI/edit?usp=sharing)

#### Dépendances utilisés
<img src="https://img.shields.io/badge/commons--net-3.6-success">
<img src="https://img.shields.io/badge/mysql--connector--java-5.1.48-success">

#### Informations divers
Le panneau qui contient le formulaire de connexion :  PanneauFormConnexion  
Le panneau qui contient le formulaire d'inscription :  PanneauFormInscription

Pour se connecter à la base de données avec la classe BDD :
```java
// Initiliser la propriété dans la classe
private BDD connexionBDD = new BDD();
...
// Appel de la méthode connexionBDD
connexionBDD.ConnexionBDD();
```