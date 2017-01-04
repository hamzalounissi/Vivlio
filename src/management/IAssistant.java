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
public interface IAssistant {
        
        public boolean validerEmprunte(int ida, int ido);
	public ArrayList<Ouvrage> chercherOuvrage();
	public boolean gererRetour(int ida, int ido);
	public ArrayList<FicheAdherent> savoirEmpruntEncours();
        public ArrayList<FicheAdherent> savoirReservationEncours();
}
