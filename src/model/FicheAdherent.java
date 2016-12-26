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
public class FicheAdherent {
    
    private int idFicheAd;
    private ArrayList<Ouvrage> ouvrageReserve;
    private Adherent adherent;
    private ArrayList<Ouvrage> ouvrageEmprunte;

    public FicheAdherent() {
       ouvrageReserve = new ArrayList<>();
       ouvrageEmprunte = new ArrayList<>();
       adherent = new Adherent();
    }
    
    public FicheAdherent(int id,Adherent ad,ArrayList<Ouvrage> ouvRese,ArrayList<Ouvrage> ouvEmp) {
        idFicheAd=id;
        adherent = ad;
        ouvrageReserve.addAll(ouvRese);
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

    
    
    
}
