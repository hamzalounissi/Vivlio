/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import dataBaseInteraction.DBInteraction;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Adherent;
import model.Categorie;
import model.Etat;
import model.EtatOuvrage;
import model.FicheAdherent;
import model.Libelle;
import model.Ouvrage;

/**
 *
 * @author lounissi
 */
public class MAssistant implements IAssistant{

    @Override
    public boolean validerEmprunte(int ida, int ido) {
        boolean var=false;
        
        Categorie cat;
        
        String datefin;
        int duree=0;
        ResultSet rs;
        DBInteraction.connect();
        // Savoir la duree
        rs = DBInteraction.select("select ouvrage.idOuvrage, ouvrage.titre , ouvrage.auteur, ouvrage.fond ,"
                + " etat.idEtat, etat.etatLivre , "
                + "categorie.idCategorie , categorie.libelle, categorie.duree from `ouvrage`"
                + " inner join `Etat`on ouvrage.idEtat=Etat.idEtat"
                + " inner join `Categorie`on ouvrage.idCategorie=Categorie.idCategorie "
                + "AND ouvrage.idOuvrage = '"+ido+"' ");
        try {
            while(rs.next()){
            duree = rs.getInt(9);
        }
            
        } catch (SQLException ex) {}
        // valider reservation 
        DBInteraction.disconnect();
        java.util.Date utilDate = new java.util.Date();
	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        SimpleDateFormat date= new SimpleDateFormat("yyyy-MM-dd");
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, duree);
        datefin= date.format(calendar.getTime());

        DBInteraction.Maj("UPDATE `ficheadherent` SET `dateEmprunte` = '"+sqlDate+"', `dateRetour` = '"+datefin+"' "
                + "WHERE `ficheadherent`.`idAdherent` = "+ida+" AND `ficheadherent`.`idOuvrage` = "+ido+"");
        DBInteraction.disconnect();
        return var;
    }

    @Override
    public ArrayList<Ouvrage> chercherOuvrage() {
        ArrayList<Ouvrage> tousLesLivres = new ArrayList<>();
        Ouvrage ov;
        Categorie cat;
        Etat et;
        ResultSet rs;
        DBInteraction.connect();
        rs = DBInteraction.select("select ouvrage.idOuvrage, ouvrage.titre , ouvrage.auteur, ouvrage.fond ,"
                + " etat.idEtat, etat.etatLivre , "
                + "categorie.idCategorie , categorie.libelle, categorie.duree from `ouvrage`"
                + " inner join `Etat`on ouvrage.idEtat=Etat.idEtat"
                + " inner join `Categorie`on ouvrage.idCategorie=Categorie.idCategorie ");
        try {
            while(rs.next()){
            
            cat = new Categorie();
            et = new Etat();
            et.setId(rs.getInt(5));
            et.setEtatO(EtatOuvrage.valueOf(rs.getString(6)));
            cat.setIdcat(rs.getInt(7));
            cat.setLibelle(Libelle.valueOf(rs.getString(8)));
            cat.setDureepret(rs.getInt(9));
            ov = new Ouvrage(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4), et, cat);
            tousLesLivres.add(ov);
            }
            
        } catch (SQLException ex) {}
        DBInteraction.disconnect();
        
        return tousLesLivres;
    }

    @Override
    public boolean gererRetour(int ida, int ido) {
        int nbl;
        DBInteraction.connect();
        nbl = DBInteraction.Maj("DELETE FROM `ficheadherent` WHERE `ficheadherent`.`idAdherent` ="+ida+" "
                + "AND `ficheadherent`.`idOuvrage` = "+ido+" ");
        DBInteraction.disconnect();
        return nbl != 0;
    }

    @Override
    public ArrayList<FicheAdherent> savoirEmpruntEncours() {
        ArrayList<FicheAdherent> lesFichesAdherents = new ArrayList<>();
        FicheAdherent fa;
        ResultSet rs;
        DBInteraction.connect();
        rs =  DBInteraction.select("SELECT ficheadherent.idFicheAdherent, ficheadherent.dateEmprunte, ficheadherent.dateRetour, "
                + "ouvrage.idOuvrage, ouvrage.titre,"
                + " adherent.idAdherent, adherent.nom FROM ficheadherent inner join ouvrage on ficheadherent.idOuvrage = ouvrage.idOuvrage "
                + "inner join adherent on ficheadherent.idAdherent = adherent.idAdherent ");
        try {
            while(rs.next())
            {
                 fa=new FicheAdherent();
                 fa.setIdFicheAd(rs.getInt(1));
                 fa.setDatePret(rs.getDate(2));
                 fa.setDateRetour(rs.getString(3));
                 fa.setOuvrage(new Ouvrage(rs.getInt(4), rs.getString(5)));
                 fa.setAdherent(new Adherent(rs.getInt(6),rs.getString(7)));
                 lesFichesAdherents.add(fa);
            }
        } catch (SQLException ex) { }
        DBInteraction.disconnect();
        return lesFichesAdherents;
    }

  
    
}
