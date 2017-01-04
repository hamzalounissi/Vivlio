/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import java.util.ArrayList;
import model.FicheAdherent;



/**
 *
 * @author lounissi
 */
public interface IAdherent {
    public boolean reserverLivre(int ida, int ido);
    public ArrayList<FicheAdherent> savoirEmprunteEncours(int idA);
    public ArrayList<FicheAdherent> savoirReservationEncours(int idA);
}
