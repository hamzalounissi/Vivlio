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
public class Notice {
    
    private int idNotice;
    private Ouvrage ouvrage;
    private Assistant assist;

    public Notice() {
    }

    public Notice(Ouvrage ouvrage, Assistant assist) {
        this.ouvrage = ouvrage;
        this.assist = assist;
    }
    
    public Notice(int idNotice, Ouvrage ouvrage, Assistant assist) {
        this.idNotice = idNotice;
        this.ouvrage = ouvrage;
        this.assist = assist;
    }

    public int getIdNotice() {
        return idNotice;
    }

    public void setIdNotice(int idNotice) {
        this.idNotice = idNotice;
    }

    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }

    public Assistant getAssist() {
        return assist;
    }

    public void setAssist(Assistant assist) {
        this.assist = assist;
    }
    
    
    
    
}
