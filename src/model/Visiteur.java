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
public class Visiteur extends Personne {
    
    private String mpasse;
    
    public Visiteur() {
    }
    
    public Visiteur(int id, String nom) {
        super(id, nom);
    }

    public Visiteur(String mpasse, String nom, String prenom, String email, String adresse) {
        super(nom, prenom, email, adresse);
        this.mpasse = mpasse;
    }
    
    public Visiteur(int id, String nom, String prenom, String email, String adresse,String mpasse) {
        super(id, nom, prenom, email, adresse);
        this.mpasse=mpasse;
    }
    
    

    public String getMpasse() {
        return mpasse;
    }

    public void setMpasse(String mpasse) {
        this.mpasse = mpasse;
    }
    
    

    @Override
    public String toString() {
        return super.toString()+" "+mpasse;
    }
    
    
    
}
