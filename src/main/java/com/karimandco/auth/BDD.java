/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karimandco.auth;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Damien F, Pawel R, Théo M
 */
public class BDD {

    private String AdresseBDD;
    private String PortBDD;
    private String NomBDD;
    private String UtilisateurBDD;
    private String MdpBDD;

    public Connection connexion;

    /**
     * Ce constructeur permet d'initialiser les propriétés contenant les
     * informations de connexion à la base de données.
     */
    public BDD() {
        this.AdresseBDD = "www.cnadal.fr";
        this.PortBDD = "3306";
        this.NomBDD = "sio2_cv";
        this.UtilisateurBDD = "sio2_cv";
        this.MdpBDD = "formation2020";
    }

    /**
     * Cette méthode permet de se connecter à la base de données.
     */
    public void ConnexionBDD() {
        if (this.connexion == null) {
            try {
                String ChaineConnexion = "jdbc:mysql://" + this.AdresseBDD + ":" + this.PortBDD + "/" + this.NomBDD;
                this.connexion = (Connection) DriverManager.getConnection(ChaineConnexion, this.UtilisateurBDD, this.MdpBDD);
//                if (this.connexion != null) {
//                    System.out.println("Connecté à la bdd");
//                } else {
//                    System.out.println("Non connecté à la bdd");
//                }
            } catch (SQLException ex) {
                Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.connexion = null;
        }
    }

    /**
     * Cette méthode permet d'exécuter une requête SQL de type INSERT pour
     * ajouter les informations saisies du formulaire inscription dans la base
     * de données.
     *
     * @param nom String nom
     * @param prenom String prenom
     * @param identifiant String identifiant
     * @param courriel String courriel
     * @param numeroTelephone String numéro de téléphone
     * @param dateNaissance String date de naissance
     * @param mdp String mot de passe
     * @return Boolean true or false
     */
    public Boolean InsertFormInscription(String nom, String prenom, String identifiant, String courriel, String numeroTelephone, String dateNaissance, String mdp) {
        Boolean requeteOK = false;
        if (this.connexion != null) {
            Boolean error_connexion = false;

            while (error_connexion == false) {
                try {
                    Statement maRequete = this.connexion.createStatement();
                    if (maRequete.executeUpdate("INSERT INTO utilisateurs (nom, prenom, identifiant, courriel, num_telephone, date_de_naissance, mot_de_passe, photo) VALUES ('" + nom + "', '" + prenom + "', '" + identifiant + "', '" + courriel + "', '" + numeroTelephone + "', '" + dateNaissance + "', '" + mdp + "', '')") == 1) {
                        requeteOK = true;
                    }
                    error_connexion = true;
                } catch (SQLException ex) {
                    if (ex.toString().contains("com.mysql.jdbc.exceptions.jdbc4.CommunicationsException: Communications link failure")) {
                        error_connexion = false;
                        this.connexion = null;
                        this.ConnexionBDD();
                    } else {
                        Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
                        error_connexion = true;
                    }
                }
            }
        }
        return requeteOK;
    }

    /**
     * Cette méthode permet d'exécuter une requête SQL de type SELECT pour
     * comparer les informations de connexion saisies dans le formulaire
     * connexion avec ceux de la base de données.
     *
     * @param identifiant String identifiant
     * @param mdp String mot de passe
     * @return Boolean true or false
     */
    public Boolean SelectFormConnexion(String identifiant, String mdp) {
        Boolean requeteOK = false;
        if (this.connexion != null) {
            Boolean error_connexion = false;

            while (error_connexion == false) {
                try {
                    Statement maRequete = this.connexion.createStatement();

                    ResultSet lesTuples = maRequete.executeQuery("SELECT * FROM utilisateurs WHERE identifiant='" + identifiant + "' AND mot_de_passe='" + mdp + "'");
                    if (lesTuples.next()) {
                        requeteOK = true;
                    }
                    error_connexion = true;
                } catch (SQLException ex) {
                    if (ex.toString().contains("com.mysql.jdbc.exceptions.jdbc4.CommunicationsException: Communications link failure")) {
                        error_connexion = false;
                        this.connexion = null;
                        this.ConnexionBDD();
                    } else {
                        Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
                        error_connexion = true;
                    }
                }
            }
        }

        return requeteOK;
    }

    /**
     * Cette méthode permet d'exécuter une requête SQL de type SELECT pour
     * recupérer la date depuis le serveur de base de données.
     *
     * @return String date
     */
    public String SelectTimeServer() {
        String resultat = null;
        if (this.connexion != null) {
            Boolean error_connexion = false;

            while (error_connexion == false) {
                try {
                    Statement maRequete = this.connexion.createStatement();

                    ResultSet lesTuples = maRequete.executeQuery("SELECT CURRENT_DATE");
                    if (lesTuples.next()) {
                        resultat = lesTuples.getString("CURRENT_DATE");
                    }
                    
                    error_connexion = true;
                } catch (SQLException ex) {
                    if (ex.toString().contains("com.mysql.jdbc.exceptions.jdbc4.CommunicationsException: Communications link failure")) {
                        error_connexion = false;
                        this.connexion = null;
                        this.ConnexionBDD();
                    } else {
                        Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
                        error_connexion = true;
                    }
                }
            }
        }

        return resultat;
    }

}
