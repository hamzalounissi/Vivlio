/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;



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

    public Personne() {
     super();
    }
    
    public Personne(int id, String nom) {
        this.idp = id;
        this.nom = nom;
    }

    public Personne(String nom, String prenom, String email, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
    }
    
    public Personne(int id, String nom, String prenom, String email, String adresse) {
        this.idp = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
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


    @Override
    public String toString() {
        return "id : " + idp + ", nom : " + nom + ", prenom : " + prenom + ", email : " + 
                email + ", adresse : " + adresse;
    }
    
    
    
}
