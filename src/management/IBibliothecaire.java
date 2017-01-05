/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import java.util.ArrayList;
import model.FicheAdherent;
import model.Ouvrage;

/**
 *
 * @author lounissi
 */
public interface IBibliothecaire {
        
        public boolean ajouterOuvrage(Ouvrage o);      
        public boolean modifierFond(String desc, int ido);
	public ArrayList<FicheAdherent> verifierRetour();
    
}
