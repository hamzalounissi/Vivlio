/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author lounissi
 */
public class Assistant extends Personne{
    
    private String login;
    private String mpasse;
    private ArrayList<Notice> lesNotices;

    public Assistant() {
        super();
        lesNotices = new ArrayList<>();
    }

    public Assistant(String login, String mpasse, int id, String nom, String prenom, String email, String adresse) {
        super(id, nom, prenom, email, adresse);
        this.login = login;
        this.mpasse = mpasse;
    }

    public Assistant(String login, String mpasse, ArrayList<Notice> lesNotices, int id, String nom, String prenom, String email, String adresse) {
        super(id, nom, prenom, email, adresse);
        this.login = login;
        this.mpasse = mpasse;
        this.lesNotices.addAll(lesNotices);
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
    
    
    
}
