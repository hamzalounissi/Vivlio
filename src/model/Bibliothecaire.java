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
public class Bibliothecaire extends Assistant {

    
    private ArrayList<Ouvrage> ouvrageDansBibliotheque;
    private ArrayList<Adherent> adherentBibliotheque;
    
    public Bibliothecaire() {
        ouvrageDansBibliotheque= new ArrayList<>();
        adherentBibliotheque= new ArrayList<>();
    }

    public Bibliothecaire(int idbib,int idas,String login, String mpasse, int id, String nom,
            String prenom, String email, String adresse) {
       
        super(login, mpasse, id, nom, prenom, email, adresse);
        
    }

    public Bibliothecaire(String login, String mpasse, ArrayList<Notice> lesNotices, 
            int id, String nom, String prenom, String email, String adresse) {
        
        super(login, mpasse, lesNotices, id, nom, prenom, email, adresse);
    }

    public Bibliothecaire(ArrayList<Ouvrage> ouvrageDansBibliotheque, ArrayList<Adherent> adherentBibliotheque, 
            String login, String mpasse, 
            int id, String nom, String prenom, String email, String adresse) {
        
        super(login, mpasse, id, nom, prenom, email, adresse);
        this.ouvrageDansBibliotheque.addAll(ouvrageDansBibliotheque);
        this.adherentBibliotheque.addAll(adherentBibliotheque);
    }

    public Bibliothecaire(ArrayList<Ouvrage> ouvrageDansBibliotheque, ArrayList<Adherent> adherentBibliotheque,
            String login, String mpasse, ArrayList<Notice> lesNotices, 
            int id, String nom, String prenom, String email, String adresse) {
        
        super(login, mpasse, lesNotices, id, nom, prenom, email, adresse);
        this.ouvrageDansBibliotheque.addAll(ouvrageDansBibliotheque);
        this.adherentBibliotheque.addAll(adherentBibliotheque);
    }

    public ArrayList<Ouvrage> getOuvrageDansBibliotheque() {
        return ouvrageDansBibliotheque;
    }

    public ArrayList<Adherent> getAdherentBibliotheque() {
        return adherentBibliotheque;
    }

    public void setOuvrageDansBibliotheque(ArrayList<Ouvrage> ouvrageDansBibliotheque) {
        this.ouvrageDansBibliotheque.addAll(ouvrageDansBibliotheque);
    }

    public void setAdherentBibliotheque(ArrayList<Adherent> adherentBibliotheque) {
        this.adherentBibliotheque.addAll(adherentBibliotheque);
    }
   
}
