/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import java.util.ArrayList;
import model.Ouvrage;
import model.Visiteur;
/**
 *
 * @author lounissi
 */
public interface IVisiteur {
    public ArrayList<Ouvrage> rechercherOuvrage(String aTitre);
    public void sinscrire(Visiteur v);
}
