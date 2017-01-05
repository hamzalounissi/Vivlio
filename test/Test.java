
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import management.MBibliothecaire;
import management.MVisiteur;
import model.Bibliothecaire;
import model.Categorie;
import model.Etat;
import model.EtatOuvrage;
import model.Libelle;
import model.Ouvrage;
import model.Visiteur;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lounissi
 */
public class Test {
    
     public static void main(String[] args) {
        //launch(args);
       // Bibliothecaire bib = new Bibliothecaire();
        MBibliothecaire mb= new MBibliothecaire();
         MVisiteur mv = new MVisiteur();
         ArrayList<Ouvrage> arrr = new ArrayList<>();
        /*    
        Categorie c = new Categorie();
        c.setLibelle(Libelle.BandeDessinee);
        Etat et = new Etat();
        et.setEtatO(EtatOuvrage.Moyen);
        Ouvrage o = new Ouvrage();
        o.setTitre("TitreO");
         System.out.println("Test.main()");
        o.setAuteur("Gr");
        o.setFond("Oui Non Si Sinon");
        o.setCategorieOuvrage(c);
        o.setEtat(et);
        mb.ajouterOuvrage(o);
        */
        //mb.modifierFond("Salut je suis Mr BTB fox qui fume et je suis un data 3alim", 14);
        //arrr.addAll(mv.rechercherOuvrage("ES"));
        /* 
        for (Ouvrage ov : arrr){
            System.err.println("Test.main()");
            System.out.println(ov);
            System.out.println(ov.getEtat().getId());
            System.out.println(ov.getEtat().getEtatO());
            System.out.println(ov.getCategorieOuvrage().getIdcat());
            System.out.println(ov.getCategorieOuvrage().getLibelle());
            System.out.println(ov.getCategorieOuvrage().getDureepret());
           System.out.println("------------------------------");
           
        }
        */
        
         Visiteur v = new Visiteur("nom", "prenom", "email", "adresse", "mpasse");
         mv.sinscrire(v);
    }
    
}
