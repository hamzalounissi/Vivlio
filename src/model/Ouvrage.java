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
public class Ouvrage {
    private int idOuv;
    private String titre;
    private String auteur;
    private String fond;
    private Etat etat;
    private Notice noticeOuvrage;
    private Categorie categorieOuvrage;
    private Bibliothecaire bibliothecaireResp;

    public Ouvrage() {
        etat=new Etat();
        noticeOuvrage=new Notice();
        categorieOuvrage=new Categorie();
        bibliothecaireResp=new Bibliothecaire();
    }
    
     public Ouvrage(int idOuv,String titre) {
         this.idOuv = idOuv;
         this.titre = titre;
    } 
    
     public Ouvrage(String titre, String auteur, String fond, 
            Etat etatOuvrage, Notice noticeOuvrage, Categorie categorieOuvrage) {
        this.titre = titre;
        this.auteur = auteur;
        this.fond = fond;
        this.etat = etatOuvrage;
        this.noticeOuvrage = noticeOuvrage;
        this.categorieOuvrage = categorieOuvrage;
    } 
    public Ouvrage(int id,String titre, String auteur, String fond, 
            Etat etatOuvrage, Categorie categorieOuvrage) {
        this.idOuv= id;
        this.titre = titre;
        this.auteur = auteur;
        this.fond = fond;
        this.etat = etatOuvrage;
        this.categorieOuvrage = categorieOuvrage;
    } 

    public Ouvrage(String titre, String auteur, String fond, 
            Etat etatOuvrage, Notice noticeOuvrage, Categorie categorieOuvrage, Bibliothecaire bibliothecaireResp) {
        this.titre = titre;
        this.auteur = auteur;
        this.fond = fond;
        this.etat = etatOuvrage;
        this.noticeOuvrage = noticeOuvrage;
        this.categorieOuvrage = categorieOuvrage;
        this.bibliothecaireResp = bibliothecaireResp;
    } 

    public Ouvrage(int idOuv, String titre, String auteur, String fond,
            Etat etatOuvrage, Notice noticeOuvrage, Categorie categorieOuvrage, Bibliothecaire bibliothecaireResp) {
        this.idOuv = idOuv;
        this.titre = titre;
        this.auteur = auteur;
        this.fond = fond;
        this.etat = etatOuvrage;
        this.noticeOuvrage = noticeOuvrage;
        this.categorieOuvrage = categorieOuvrage;
        this.bibliothecaireResp = bibliothecaireResp;
    }

    public int getIdOuv() {
        return idOuv;
    }

    public void setIdOuv(int idOuv) {
        this.idOuv = idOuv;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getFond() {
        return fond;
    }

    public void setFond(String fond) {
        this.fond = fond;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public Notice getNoticeOuvrage() {
        return noticeOuvrage;
    }

    public void setNoticeOuvrage(Notice noticeOuvrage) {
        this.noticeOuvrage = noticeOuvrage;
    }

    public Categorie getCategorieOuvrage() {
        return categorieOuvrage;
    }

    public void setCategorieOuvrage(Categorie categorieOuvrage) {
        this.categorieOuvrage = categorieOuvrage;
    }

    public Bibliothecaire getBibliothecaireResp() {
        return bibliothecaireResp;
    }

    public void setBibliothecaireResp(Bibliothecaire bibliothecaireResp) {
        this.bibliothecaireResp = bibliothecaireResp;
    }

    @Override
    public String toString() {
        return "Ouvrage{" + "idOuv=" + idOuv + ", titre=" + titre + ", auteur=" + auteur + ", fond=" + fond + '}';
    }
    
    
    
}
