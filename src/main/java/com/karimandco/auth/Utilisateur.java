/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karimandco.auth;

import com.karimandco.bdd.DaoSIO;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Damien F, Pawel R
 */
public class Utilisateur {

    private static Utilisateur monUtilisateur = null;

    private static String identifiant;

    private Boolean estConnecte = false;

    private Integer id;
    private Integer statut;
    private String nom;
    private String prenom;
    private String numeroTelephone;
    private String courriel;
    private String dateNaissance;
    private Blob photo;

    private Utilisateur() {
        chargerInformationsUtilisateur();
    }

    public static String getIdentifiant() {
        return identifiant;
    }

    public static void setIdentifiant(String identifiant) {
        Utilisateur.identifiant = identifiant;
    }

    /**
     * Cette méthode renvoie la propriété estConnecte.
     *
     * @return Boolean true or false
     */
    public Boolean getEstConnecte() {
        return estConnecte;
    }

    /**
     * Cette méthode permet de définir la propriété estConnecte.
     *
     * @param estConnecte Boolean true or false
     */
    public void setEstConnecte(Boolean estConnecte) {
        this.estConnecte = estConnecte;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatut() {
        return statut;
    }

    public void setStatut(Integer statut) {
        this.statut = statut;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    /**
     * Permet d'obtenir l'objet instancié.
     *
     * @return un Objet Utilisateur
     */
    public static Utilisateur getInstance() {
        if (Utilisateur.monUtilisateur == null) {
            Utilisateur.monUtilisateur = new Utilisateur();
        }
        return Utilisateur.monUtilisateur;
    }

    /**
     * Cette méthode permet d'initialiser les propriétés contenant les
     * informations de l'utilisateur en fesant une requête à la bdd avec
     * l'identifiant de l'utilisateur et de mettre true à la propriété
     * estConnecte.
     */
    public void chargerInformationsUtilisateur() {
        if (Utilisateur.identifiant != null) {
            ResultSet lesResultats = DaoSIO.getInstance().requeteSelection("SELECT * FROM utilisateurs WHERE identifiant='" + Utilisateur.identifiant + "'");

            try {
                if (lesResultats.next()) {
                    this.id = lesResultats.getInt("id");
                    this.statut = lesResultats.getInt("statut");
                    this.nom = lesResultats.getString("nom");
                    this.prenom = lesResultats.getString("prenom");
                    this.numeroTelephone = lesResultats.getString("num_telephone");
                    this.courriel = lesResultats.getString("courriel");
                    String[] date_split = lesResultats.getString("date_de_naissance").split("-");
                    this.dateNaissance = date_split[2] + "/" + date_split[1] + "/" + date_split[0];
                    this.photo = lesResultats.getBlob("photo");

                    this.estConnecte = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Cette méthode permet de mettre à jour les informations de l'utilisateur
     * sur la bdd et renvoie un booléen si la maj a été réussie.
     *
     * @return Boolean true or false
     */
    public Boolean updateInformationsUtilisateurBDD() {
        Boolean resultat = false;
        if (Utilisateur.identifiant != null) {
            String[] date_split = this.getDateNaissance().split("/");
            String data_split_ok = date_split[2] + "-" + date_split[1] + "-" + date_split[0];

            Integer compteur = DaoSIO.getInstance().requeteAction("UPDATE utilisateurs SET nom='" + this.getNom() + "', prenom='" + this.getPrenom() + "', num_telephone='" + this.getNumeroTelephone() + "', courriel='" + this.getCourriel() + "', date_de_naissance='" + data_split_ok + "', photo='" + this.getPhoto() + "' WHERE identifiant='" + Utilisateur.getIdentifiant() + "'");

            if (compteur > 0) {
                resultat = true;
            }
        }
        return resultat;
    }

    /**
     * Cette méthode permet d'afficher toutes les propriétés contenant les
     * informations de l'utilisateur (utile pour débug).
     */
    public void getAll() {
        System.out.println();
        System.out.println("============ Informations de l'utilisateur ============");
        System.out.println("Id : " + this.getId());
        System.out.println("Statut : " + this.getStatut());
        System.out.println("Identifiant : " + Utilisateur.getIdentifiant());
        System.out.println("Nom : " + this.getNom());
        System.out.println("Prénom : " + this.getPrenom());
        System.out.println("Numéro de téléphone : " + this.getNumeroTelephone());
        System.out.println("Courriel : " + this.getCourriel());
        System.out.println("Date de naissance : " + this.getDateNaissance());
        System.out.println("Photo : " + this.getPhoto());
        System.out.println("=======================================================");
        System.out.println();
    }
}
