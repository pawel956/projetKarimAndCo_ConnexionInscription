/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karimandco.auth;

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

    public static String getIdentifiant() {
        return identifiant;
    }

    public static void setIdentifiant(String identifiant) {
        Utilisateur.identifiant = identifiant;
    }

    /**
     * Cette méthode renvoie la propriété estConnecte
     *
     * @return Boolean true or false
     */
    public Boolean getEstConnecte() {
        return estConnecte;
    }

    /**
     * Cette méthode permet de définir la propriété estConnecte
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
     * Permet d'obtenir l'objet instancié
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
                    this.dateNaissance = lesResultats.getString("date_de_naissance");
                    this.photo = lesResultats.getBlob("photo");

                    this.estConnecte = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
