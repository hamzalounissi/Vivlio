/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import dataBaseInteraction.DBInteraction;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author lounissi
 */
public class MAdherent extends MVisiteur implements IAdherent{

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

    
}
