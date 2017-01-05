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
public class Categorie {
    
    private int idcat;
    private Libelle libelle;
    private int dureepret;
    private ArrayList<Ouvrage> ouvrageCategorie;

    public Categorie() {
        ouvrageCategorie=new ArrayList<>();
    }

    
    public Categorie(Libelle libelle, ArrayList<Ouvrage> ouvCat) {
        this.libelle = libelle;
        ouvrageCategorie.addAll(ouvCat);
    }

    public Categorie(int idcat, Libelle libelle, int dureepret) {
        this.idcat = idcat;
        this.libelle = libelle;
        this.dureepret = dureepret;
    }
    
    
    
    public Categorie(int idcat,Libelle libelle, int dureepret, ArrayList<Ouvrage> ouvCat) {
        this.idcat=idcat;
        this.libelle = libelle;
  
        this.dureepret = dureepret;
        ouvrageCategorie.addAll(ouvCat);
    }

    public int getIdcat() {
        return idcat;
    }

    public void setIdcat(int idcat) {
        this.idcat = idcat;
    }
    
    public Libelle getLibelle() {
        return libelle;
    }

    public void setLibelle(Libelle libelle) {
        this.libelle = libelle;
    }

    public int getDureepret() {
        return dureepret;
    }

    public void setDureepret(int dureepret) {
        this.dureepret = dureepret;
    }

    public ArrayList<Ouvrage> getOuvrageCategorie() {
        return ouvrageCategorie;
    }

    public void setOuvrageCategorie(ArrayList<Ouvrage> ouvrageCategorie) {
        this.ouvrageCategorie.addAll(ouvrageCategorie);
    }

    @Override
    public String toString() {
        return "Categorie{" + "idcat=" + idcat + ", libelle=" + libelle + ", dureepret=" + dureepret + ", ouvrageCategorie=" + ouvrageCategorie + '}';
    }
    
    
}
