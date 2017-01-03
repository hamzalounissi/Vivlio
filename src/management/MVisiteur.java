/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import dataBaseInteraction.DBInteraction;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Categorie;
import model.Etat;
import model.EtatOuvrage;
import model.Libelle;
import model.Notice;
import model.Ouvrage;
import model.Visiteur;

/**
 *
 * @author lounissi
 */
public class MVisiteur implements IVisiteur{

    @Override
    public ArrayList<Ouvrage> rechercherOuvrage(String aTitre) {
       ArrayList<Ouvrage> arrOuvrage=new ArrayList<>();
       Ouvrage ov;
       Categorie cat;
       Etat et;
       ResultSet rs;
       DBInteraction.connect();
        rs = DBInteraction.select("select ouvrage.idOuvrage, ouvrage.titre , ouvrage.auteur, ouvrage.fond ,"
                + " etat.idEtat, etat.etatLivre , "
                + "categorie.idCategorie , categorie.libelle, categorie.duree from `ouvrage`"
                + " inner join `Etat`on ouvrage.idEtat=Etat.idEtat"
                + " inner join `Categorie`on ouvrage.idCategorie=Categorie.idCategorie "
                + "AND ouvrage.titre = '"+aTitre+"' ");
        try {
            while(rs.next()){
            
            cat = new Categorie();
            et = new Etat();
            /*
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
            System.out.println(rs.getString(4));
            System.out.println(rs.getInt(5));
            System.out.println(rs.getString(6));
            System.out.println(rs.getInt(7));
            System.out.println(rs.getString(8));
            System.out.println(rs.getInt(9));  
            o.setIdOuv(rs.getInt(1));   
            o.setTitre(rs.getString(2));
            o.setAuteur(rs.getString(3));
            o.setFond(rs.getString(4));
            */
            et.setId(rs.getInt(5));
            et.setEtatO(EtatOuvrage.valueOf(rs.getString(6)));
            cat.setIdcat(rs.getInt(7));
            cat.setLibelle(Libelle.valueOf(rs.getString(8)));
            cat.setDureepret(rs.getInt(9));
            /*
            o.setEtat(et);
            o.setCategorieOuvrage(cat);
            
            System.out.println("From inside");
                System.out.println(et);
                System.out.println(cat);
                System.out.println(o);
            */
            ov = new Ouvrage(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4), et, cat);
            arrOuvrage.add(ov);
            }
            
        } catch (SQLException ex) {}
        DBInteraction.disconnect();
       return arrOuvrage;
    }

    @Override
    public void sinscrire(Visiteur v) {
        DBInteraction.connect();
        DBInteraction.Maj("INSERT INTO `adherent` (`idAdherent`, `nom`, `prenom`, `adresse`, `email`, `motPasse`, `idBibliothecaire`) "
                + "VALUES (NULL, '"+v.getNom()+"', '"+v.getPrenom()+"', '"+v.getAdresse()+"', '"+v.getEmail()+"', '"+v.getMpasse()+"', 1);");
        DBInteraction.disconnect();
    }
    
}
