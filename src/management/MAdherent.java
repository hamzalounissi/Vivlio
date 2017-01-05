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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Adherent;
import model.FicheAdherent;
import model.Ouvrage;


/**
 *
 * @author lounissi
 */
public class MAdherent extends MVisiteur implements IAdherent,I_Authentifier{
    
    
    
    @Override
    public boolean reserverLivre(int ida, int ido) {
        
        boolean var=false;
        int nbOuv=-1;
        ResultSet rs;
        DBInteraction.connect();
        rs = DBInteraction.select("SELECT count(idAdherent) FROM ficheadherent WHERE idAdherent = "+ida);
        try {
            if (rs.next()){ nbOuv=rs.getInt(1); }
        } catch (SQLException ex) { }
        if(nbOuv!=-1 && nbOuv<5 ){
            DBInteraction.Maj("INSERT INTO ficheadherent(idFicheAdherent, dateEmprunte, dateRetour, idAdherent, idOuvrage)"
                    + " VALUES (NULL,NULL,NULL,'"+ida+"','"+ido+"')");
            var=true;
        }
        DBInteraction.disconnect();
        return var;

    }

    @Override
    public ArrayList<FicheAdherent> savoirEmprunteEncours(int idA) {
                                                  
        ArrayList<FicheAdherent> emprunteEncours=new ArrayList<>();
        FicheAdherent fa;
        ResultSet rs;
        DBInteraction.connect();
        rs =  DBInteraction.select("SELECT ficheadherent.idFicheAdherent, ficheadherent.dateEmprunte, ficheadherent.dateRetour, "
                + "ouvrage.idOuvrage, ouvrage.titre,"
                + " adherent.idAdherent, adherent.nom FROM ficheadherent inner join ouvrage on ficheadherent.idOuvrage = ouvrage.idOuvrage "
                + "inner join adherent on ficheadherent.idAdherent = adherent.idAdherent "
                + "where ficheadherent.idAdherent="+idA+""
                + "and ficheadherent.dateEmprunte is not null and ficheadherent.dateRetour is not null");
        try {
            while(rs.next())
            {
                 fa=new FicheAdherent();
                 fa.setIdFicheAd(rs.getInt(1));
                 fa.setDatePret(rs.getDate(2));
                 fa.setDateRetour(rs.getString(3));
                 fa.setOuvrage(new Ouvrage(rs.getInt(4), rs.getString(5)));
                 fa.setAdherent(new Adherent(rs.getInt(6),rs.getString(7)));
                 emprunteEncours.add(fa);
            }
        } catch (SQLException ex) { }
        DBInteraction.disconnect();
        return emprunteEncours;
    }

    @Override
    public ArrayList<FicheAdherent> savoirReservationEncours(int idA) {
        
        ArrayList<FicheAdherent> reservationEncours=new ArrayList<>();
        FicheAdherent fa;
        ResultSet rs;
        DBInteraction.connect();
          rs =  DBInteraction.select("SELECT ficheadherent.idFicheAdherent, ficheadherent.dateEmprunte, ficheadherent.dateRetour,"
                + "ouvrage.idOuvrage, ouvrage.titre, adherent.idAdherent, adherent.nom FROM ficheadherent "
                + "inner join ouvrage on ficheadherent.idOuvrage = ouvrage.idOuvrage "
                + "inner join adherent on ficheadherent.idAdherent = adherent.idAdherent "
                + "where ficheadherent.dateEmprunte is null and ficheadherent.dateRetour is null "
                  + "and ficheadherent.idAdherent="+idA+"");
           try {
            while(rs.next())
            {
                 fa=new FicheAdherent();
                 fa.setIdFicheAd(rs.getInt(1));
                 fa.setDatePret(rs.getDate(2));
                 fa.setDateRetour(rs.getString(3));
                 fa.setOuvrage(new Ouvrage(rs.getInt(4), rs.getString(5)));
                 fa.setAdherent(new Adherent(rs.getInt(6),rs.getString(7)));
                 reservationEncours.add(fa);
            }
        } catch (SQLException ex) { }
        DBInteraction.disconnect();
        return reservationEncours;
    }

    @Override
    public boolean authentifier(String email, String pwd) {

        ResultSet rs;
        DBInteraction.connect();
          rs =  DBInteraction.select("SELECT email,motPasse FROM adherent WHERE email='"+email+"' AND motPasse='"+pwd+"' ");
        try {
            if(rs.next()){
                return true;
            }
            else return false;
        } catch (SQLException ex) {
            Logger.getLogger(MAdherent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public Adherent getAdherent(String email){
        Adherent adh = new Adherent();
        
        ResultSet rs;
        DBInteraction.connect();
          rs =  DBInteraction.select("SELECT * FROM adherent WHERE email='"+email+"'  ");
          System.out.println("cccccccccccc");
        try {
            while(rs.next()){
                adh.setId(rs.getInt(1));
                adh.setNom(rs.getString(2));
                adh.setPrenom(rs.getString(3));
                adh.setAdresse(rs.getString(4));
                adh.setEmail(email);
                adh.setMpasse(rs.getString(6));
                System.out.println(adh.toString());
                return adh;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MAdherent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
    }

    
}
