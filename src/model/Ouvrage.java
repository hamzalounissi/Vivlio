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
    private String isbn;
    private String auteur;
    private String editeur;
    private Date dateEdition;
    private Etat etatOuvrage;
    private Notice noticeOuvrage;
    private Categorie categorieOuvrage;
    private Bibliothecaire bibliothecaireResp;

    public Ouvrage() {
        etatOuvrage=new Etat();
        noticeOuvrage=new Notice();
        categorieOuvrage=new Categorie();
        bibliothecaireResp=new Bibliothecaire();
    }

    public Ouvrage(String titre, String isbn, String auteur, String editeur, Date dateEdition, 
            Etat etatOuvrage, Notice noticeOuvrage, Categorie categorieOuvrage, Bibliothecaire bibliothecaireResp) {
        this.titre = titre;
        this.isbn = isbn;
        this.auteur = auteur;
        this.editeur = editeur;
        this.dateEdition = dateEdition;
        this.etatOuvrage = etatOuvrage;
        this.noticeOuvrage = noticeOuvrage;
        this.categorieOuvrage = categorieOuvrage;
        this.bibliothecaireResp = bibliothecaireResp;
    } 

    public Ouvrage(int idOuv, String titre, String isbn, String auteur, String editeur, Date dateEdition,
            Etat etatOuvrage, Notice noticeOuvrage, Categorie categorieOuvrage, Bibliothecaire bibliothecaireResp) {
        this.idOuv = idOuv;
        this.titre = titre;
        this.isbn = isbn;
        this.auteur = auteur;
        this.editeur = editeur;
        this.dateEdition = dateEdition;
        this.etatOuvrage = etatOuvrage;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public Date getDateEdition() {
        return dateEdition;
    }

    public void setDateEdition(Date dateEdition) {
        this.dateEdition = dateEdition;
    }

    public Etat getEtatOuvrage() {
        return etatOuvrage;
    }

    public void setEtatOuvrage(Etat etatOuvrage) {
        this.etatOuvrage = etatOuvrage;
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
    
    
}
