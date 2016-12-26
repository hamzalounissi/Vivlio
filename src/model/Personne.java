/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author lounissi
 */
public class Personne {
    
    private int idp;
    private String nom;
    private String prenom;
    private String email;
    private String adresse;
    private int numero;
    private Date dateNaissance;

    public Personne() {
     super();
    }

    public Personne(int id, String nom, String prenom, String email, String adresse, int numero, Date dateNaissance) {
        this.idp = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
        this.numero = numero;
        this.dateNaissance = dateNaissance;
    }

    public int getId() {
        return idp;
    }

    public void setId(int id) {
        this.idp = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Override
    public String toString() {
        return "id : " + idp + ", nom : " + nom + ", prenom : " + prenom + ", email : " + 
                email + ", adresse : " + adresse + ", numero : " + numero + ", dateNaissance : " + dateNaissance;
    }
    
    
    
}
