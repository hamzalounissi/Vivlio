/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import java.sql.ResultSet;
import java.sql.SQLException;
import dataBaseInteraction.DBInteraction;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Adherent;
import model.FicheAdherent;
import model.Ouvrage;

/**
 *
 * @author lounissi
 */
public class MBibliothecaire extends MAssistant implements IBibliothecaire{

     @Override
    public boolean ajouterOuvrage(Ouvrage o) {
         boolean fait=false;
            String sql1,sql;
            int ido=-1,idcat,ideta,idn=-1;
            ResultSet rs;
            DBInteraction.connect();
            sql1="INSERT INTO `ouvrage` (`idOuvrage`, `titre`, `auteur`, `fond`, `idCategorie`, `idNotice`, `idEtat`, `idBibliothecaire`) "
                    + "VALUES (NULL, '"+o.getTitre()+"', '"+o.getAuteur()+"', '"+o.getFond()+"', NULL, NULL, NULL, NULL);";
            DBInteraction.Maj(sql1);
           
            // -------------------------------------
            sql="SELECT MAX(idOuvrage) FROM ouvrage";
            rs = DBInteraction.select(sql);
                try {
                    if(rs.next())
                        {
                            ido=rs.getInt(1);
                        }  

                    } catch (SQLException ex) {}
                
                sql="INSERT INTO notice (`idNotice`, `idOuvrage`, `idAssistant`) VALUES  (NULL,'"+ido+"',1)";
                DBInteraction.Maj(sql);
                
                
                sql="SELECT MAX(idNotice) FROM notice";
                rs = DBInteraction.select(sql);
                try {
                    if(rs.next())
                        {
                            idn=rs.getInt(1);
                        }  

                    } catch (SQLException ex) {}
                try {
                    rs.close();
                    } catch (SQLException ex) {}
                
                
                idcat=savoirIdCategorie(String.valueOf(o.getCategorieOuvrage().getLibelle()));
                ideta=savoirIdEtat(String.valueOf(o.getEtat().getEtatO()));
                System.err.println("\t "+ido+" "+idcat+" "+ideta+" "+idn);
             DBInteraction.disconnect();
             DBInteraction.connect();
         try {
             PreparedStatement ps = DBInteraction.getConnection().prepareStatement
        ("UPDATE ouvrage SET idCategorie = ?, idNotice = ?, idEtat = ?, "
                + "idBibliothecaire = ? WHERE idOuvrage = ?");
             ps.setInt(1, idcat);
             ps.setInt(2, idn);
             ps.setInt(3, ideta);
             ps.setInt(4, 1);
             ps.setInt(5, ido);
             ps.executeUpdate();
             ps.close();
         } catch (SQLException ex) {}
                
              
                
                DBInteraction.disconnect();
                 
        return fait;
    }

    
   

    @Override
    public boolean modifierFond(String desc, int ido) {
       boolean var=false;
       DBInteraction.connect();
       DBInteraction.Maj("UPDATE ouvrage SET fond = '"+desc+"' WHERE idOuvrage = '"+ido+"' ");
       DBInteraction.disconnect();
       return var;
    }

    @Override
    public ArrayList<FicheAdherent> verifierRetour() {
        ArrayList<FicheAdherent> lesFichesAdherentsNonRetourne = new ArrayList<>();
        SimpleDateFormat date= new SimpleDateFormat("yyyy-MM-dd");
	Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date()); 
        String dCourant = date.format(calendar.getTime());
        String dRetour;
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
                String[] dateCourant,dateRetour; 
                
                dRetour = rs.getString(3);
                dateCourant = dCourant.split("-");
                dateRetour = dRetour.split("-");
                
                if (
                      (
                        Integer.parseInt(dateCourant[0]) == Integer.parseInt(dateRetour[0])  && 
                        Integer.parseInt(dateCourant[1]) == Integer.parseInt(dateRetour[1])  && 
                        Integer.parseInt(dateCourant[2]) == Integer.parseInt(dateRetour[2]) 
                      )
                        || 
                      (
                        
                        Integer.parseInt(dateCourant[0]) > Integer.parseInt(dateRetour[0])  ||
                        Integer.parseInt(dateCourant[1]) > Integer.parseInt(dateRetour[1])  ||
                        Integer.parseInt(dateCourant[2]) > Integer.parseInt(dateRetour[2])
                       )
                    )
                {   
                 fa=new FicheAdherent();
                 fa.setIdFicheAd(rs.getInt(1));
                 fa.setDatePret(rs.getDate(2));
                 fa.setDateRetour(rs.getString(3));
                 fa.setOuvrage(new Ouvrage(rs.getInt(4), rs.getString(5)));
                 fa.setAdherent(new Adherent(rs.getInt(6),rs.getString(7)));
                 lesFichesAdherentsNonRetourne.add(fa);
                }
            }
        } catch (SQLException ex) { }
        DBInteraction.disconnect();
        return lesFichesAdherentsNonRetourne;
    }
    
    
    
     public int savoirIdCategorie(String libelle) {
        int id=-1;
        ResultSet rs;
        String sql="SELECT idCategorie FROM categorie WHERE libelle='"+libelle+"'";
        DBInteraction.connect();
        rs=DBInteraction.select(sql);
        try {
                    if(rs.next())
                        {
                            id=rs.getInt(1);
                            rs.close();
                        }  

                    } catch (SQLException ex) {}
        DBInteraction.disconnect();
        return id;
    }

   
    public int savoirIdEtat(String etat) {
        int id=-1;
        ResultSet rs;
        String sql="SELECT idEtat FROM etat WHERE etatLivre='"+etat+"'";
        DBInteraction.connect();
        rs=DBInteraction.select(sql);
        try {
                    if(rs.next())
                        {
                            id=rs.getInt(1);
                            rs.close();
                        }  

                    } catch (SQLException ex) {}
        DBInteraction.disconnect();
        return id;
    }
    
    public boolean authentifier(String email,String pwd){
        ResultSet rs;
        DBInteraction.connect();
          rs =  DBInteraction.select("SELECT email,motPasse FROM bibliothecaire WHERE email='"+email+"' AND motPasse='"+pwd+"' ");
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
    
    
}
