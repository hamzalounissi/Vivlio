/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author lounissi
 */
public class Etat {
    
    private int id;
    private EtatOuvrage etat;

    public Etat() {
    }
    
    public Etat(EtatOuvrage etat) {
        this.etat = etat;
    }
    
    public Etat(int id, EtatOuvrage etat) {
        this.id = id;
        this.etat = etat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EtatOuvrage getEtatO() {
        return etat;
    }

    public void setEtatO(EtatOuvrage etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Etat{" + "id=" + id + ", etat=" + etat + '}';
    }

    
    
    
    
}
