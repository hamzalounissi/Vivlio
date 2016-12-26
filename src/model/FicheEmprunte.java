/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author lounissi
 */
public class FicheEmprunte {
    
    private ArrayList<Notice> historiqueEmprunte;

    public FicheEmprunte() {
    }

    public FicheEmprunte(ArrayList<Notice> historiqueEmprunte) {
        this.historiqueEmprunte = historiqueEmprunte;
    }

    public ArrayList<Notice> getHistoriqueEmprunte() {
        return historiqueEmprunte;
    }

    public void setHistoriqueEmprunte(ArrayList<Notice> historiqueEmprunte) {
        this.historiqueEmprunte = historiqueEmprunte;
    }
    
    
}
