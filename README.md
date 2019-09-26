<img src="https://image.flaticon.com/icons/svg/311/311334.svg" width="150">

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
