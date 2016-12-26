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
public class Adherent extends Visiteur {
    
    private String login;
    private String mpasse;
    private Bibliothecaire bibliothecaire;

    public Adherent() {
        
    }

    public Adherent(String login, String mpasse, int id, String nom, String prenom, String email, String adresse, int numero, Date dateNaissance) {
        super(id, nom, prenom, email, adresse, numero, dateNaissance);
       
        this.login = login;
        this.mpasse = mpasse;
    }

    public Adherent(String login, String mpasse, Bibliothecaire bibliothecaire, int id, String nom, String prenom, String email, String adresse, int numero, Date dateNaissance) {
        super(id, nom, prenom, email, adresse, numero, dateNaissance);
        this.login = login;
        this.mpasse = mpasse;
        this.bibliothecaire = bibliothecaire;
    }
    
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMpasse() {
        return mpasse;
    }

    public void setMpasse(String mpasse) {
        this.mpasse = mpasse;
    }

    @Override
    public String toString() {
        return super.toString()+"login=" + login + ", mpasse=" + mpasse;
    }
     
    
    
    
}
