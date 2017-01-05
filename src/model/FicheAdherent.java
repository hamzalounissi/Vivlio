/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.sql.Date;


/**
 *
 * @author lounissi
 */
public class FicheAdherent {
    
    private int idFicheAd;
    private Adherent adherent;
    private Date datePret;
    private String dateRetour;
    private Ouvrage ouvrage;
    private ArrayList<Ouvrage> ouvrageReserve;
    private ArrayList<Ouvrage> ouvrageEmprunte;

    public FicheAdherent() {
       ouvrageReserve = new ArrayList<>();
       ouvrageEmprunte = new ArrayList<>();
       adherent = new Adherent();
    }

    public FicheAdherent(int idFicheAd, Adherent adherent, Date datePret, String dateRetour, Ouvrage ouvrage) {
        this.idFicheAd = idFicheAd;
        this.adherent = adherent;
        this.datePret = datePret;
        this.dateRetour = dateRetour;
        this.ouvrage = ouvrage;
    }
    
    public FicheAdherent(int id,Adherent ad,ArrayList<Ouvrage> ouvRese,ArrayList<Ouvrage> ouvEmp) {
        idFicheAd=id;
        adherent = ad;
        ouvrageReserve.addAll(ouvRese);
        ouvrageEmprunte.addAll(ouvEmp);
    }

    public FicheAdherent(int id,Adherent ad,ArrayList<Ouvrage> ouvEmp) {
        idFicheAd=id;
        adherent = ad;
        ouvrageEmprunte.addAll(ouvEmp);
    }
    
    
    public int getIdFicheAd() {
        return idFicheAd;
    }

    public void setIdFicheAd(int idFicheAd) {
        this.idFicheAd = idFicheAd;
    }

    public ArrayList<Ouvrage> getOuvrageReserve() {
        return ouvrageReserve;
    }

    public void setOuvrageReserve(ArrayList<Ouvrage> ouvrageReserve) {
        this.ouvrageReserve = ouvrageReserve;
    }

    public Adherent getAdherent() {
        return adherent;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }

    public ArrayList<Ouvrage> getOuvrageEmprunte() {
        return ouvrageEmprunte;
    }

    public void setOuvrageEmprunte(ArrayList<Ouvrage> ouvrageEmprunte) {
        this.ouvrageEmprunte = ouvrageEmprunte;
    }

    public Date getDatePret() {
        return datePret;
    }

    public void setDatePret(Date datePret) {
        this.datePret = datePret;
    }

    public String getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(String dateRetour) {
        this.dateRetour = dateRetour;
    }

    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }
    
    
    
    
    
}
