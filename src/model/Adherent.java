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
public class Adherent extends Visiteur {
    
    private Bibliothecaire bibliothecaire;

    public Adherent() {
        
    }
    
    public Adherent(int id, String nom) {
        super(id, nom);
    }

    public Adherent(String mpasse, String nom, String prenom, String email, String adresse) {
        super(mpasse, nom, prenom, email, adresse);
    }
    
    public Adherent(int id, String nom, String prenom, String email, String adresse, String mpasse) {
        super(id, nom, prenom, email, adresse, mpasse);
    }

    
    
    

    @Override
    public String toString() {
        return super.toString();
    }
     
    
    
    
}
