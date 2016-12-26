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
public class Visiteur extends Personne {

    public Visiteur() {
    }

    public Visiteur(int id, String nom, String prenom, String email, String adresse, int numero, Date dateNaissance) {
        super(id, nom, prenom, email, adresse, numero, dateNaissance);
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    
    
}
