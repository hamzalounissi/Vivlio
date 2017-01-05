/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotheque;

import com.sun.javafx.scene.control.skin.DatePickerContent;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import static javafx.application.Application.launch;
import javafx.scene.input.KeyEvent;
import jdk.nashorn.internal.runtime.options.Options;
import management.MAdherent;
import management.MBibliothecaire;
import management.MVisiteur;
import model.Adherent;
import model.FicheAdherent;
import model.Ouvrage;

/**
 *
 * @author 6
 */
public class GUI_Adherent extends Application{
    Scene scene;
    VBox contentBox,headBox,horizontal_box_wrapper;
    HBox mainBox;
    MAdherent MAdherent;
    Adherent adherent;
    VBox[] elements;
    VBox Reservations;
    ScrollPane scroll;
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        String dataUser = (String) primaryStage.getUserData();
        System.out.println("Adherent : "+dataUser);
        adherent = new Adherent();
        MAdherent = new MAdherent();
        adherent = MAdherent.getAdherent(dataUser);
        ArrayList<String> livres  = new ArrayList<>();
        livres.add("livre 1");
        livres.add("livre 2");
        StackPane root = new StackPane();
        VBox horizontal_box_sidebar = new VBox();
        VBox logo_profil = new VBox();
        horizontal_box_wrapper = new VBox();
        mainBox = new HBox();
        VBox vertical_box = new VBox();
        
        horizontal_box_sidebar.setStyle("-fx-background-color:#1d8c97;");
        horizontal_box_sidebar.setMinWidth(200);
        horizontal_box_sidebar.setMaxWidth(200);
        
        
        // Adding A ListView in the Sidebar
        ObservableList<String> data = FXCollections.observableArrayList();
        ListView<String> listView = new ListView<String>(data);
        listView.setPrefSize(200, 250);
        System.out.println(listView.getId());
        listView.setEditable(false);
        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.toString().equals("ACCUEIL")){
                
                //horizontal_box_wrapper.getChildren().clear();
                contentBox.getChildren().clear();
                //contentBox.getChildren().add(this.wrapper(livres));
                horizontal_box_wrapper.setMinWidth(720);
                horizontal_box_wrapper.setMaxWidth(720);
                horizontal_box_wrapper.getChildren().clear();
                horizontal_box_wrapper.getChildren().add(this.wrapper(livres));
                //horizontal_box_wrapper.getChildren().add(contentBox);
            }else if(newValue.equals("MES PREFERENCES")){
                    Label titre = new Label("MES PREFERENCES");
                    Label message = new Label("Page encours de construction");
                    contentBox.getChildren().clear();
                //contentBox.getChildren().add(this.wrapper(livres));
                
                contentBox.getChildren().addAll(titre,message);
                
                    
            }else if(newValue.toString().equals("MES RESERVATIONS")){
                
                //horizontal_box_wrapper.getChildren().clear();
                contentBox.getChildren().clear();
                
                contentBox.getChildren().add(this.ListeDesReservations());
                //horizontal_box_wrapper.getChildren().add(contentBox);
            }else if(newValue.toString().equals("MES EMPRUNTS")){
                
                //horizontal_box_wrapper.getChildren().clear();
                contentBox.getChildren().clear();
                //contentBox.getChildren().add(this.wrapper(livres));
                
                contentBox.getChildren().add(this.ListeDesEmprunts());
                //horizontal_box_wrapper.getChildren().add(contentBox);
            }
                
            
         });

        data.addAll("ACCUEIL","MES RESERVATIONS","MES EMPRUNTS","MES PREFERENCES","","SE DECONNECTER");
        
        listView.setItems(data);
        File file = new File("C:\\Users\\6\\Desktop/VivlioLogo.png");
        System.out.println(file.getName()+" "+file.getCanonicalPath());
        //listView.getSelectionModel().select(0);
        Image img = new Image(new FileInputStream(file));
        ImageView imgview_1 = new ImageView(img);
        logo_profil.getChildren().add(imgview_1);
        logo_profil.setAlignment(Pos.CENTER);
        logo_profil.setPadding(new Insets(40,0,200,0));
        horizontal_box_sidebar.getChildren().add(logo_profil);

        
        // sidebar menu
        horizontal_box_sidebar.getChildren().add(listView);
        
        
        horizontal_box_wrapper.setStyle("-fx-background-color:#EFEFEF;");
        horizontal_box_wrapper.setMinWidth(720);
        horizontal_box_wrapper.setMaxWidth(720);
        horizontal_box_wrapper.getChildren().add(this.wrapper(livres));
        
        //horizontal_box_wrapper.getChildren().add(null);
        
        mainBox.getChildren().addAll(horizontal_box_sidebar,horizontal_box_wrapper);
        
        root.getChildren().add(mainBox);
        root.setStyle("-fx-background-color:rgba(0,0,0,1)");
        scene = new Scene(root,900,600);

        
        listView.getStylesheets().addAll(GUI_Adherent.class.getResource("css.css").toExternalForm());
        
        primaryStage.setTitle("Vivlio - "+dataUser);
        
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    public VBox wrapper(ArrayList<String> livres){
        VBox verticalBox = new VBox();
        headBox = new VBox();
        contentBox = new VBox();
        
        
        headBox.setPadding(new Insets(50,0,100,0));
        //headBox.setStyle("-fx-background-color:rgb(20,20,20)");
        TextField search = new TextField("Chercher un livre..");
        search.setId("search");
        
        search.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                search.setText("");
                
                System.out.println(search.getText());
                
                
            }
            
        });
        search.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                    Label titre = new Label("Resultat de la recherche");
                    titre.setPadding(new Insets(0, 0, 40, 0));
                    ScrollPane resultat = ResultatRecherche(search.getText());
                    contentBox.getChildren().clear();
                    contentBox.getChildren().addAll(titre,resultat);
            }
            
        });
        search.getStylesheets().addAll(GUI_Adherent.class.getResource("css.css").toExternalForm());
        ObservableList<String> data = FXCollections.observableArrayList();
        ListView<String> listView = new ListView<String>(data);
        listView.setPrefWidth(680);
        
        headBox.getChildren().add(search);
        
        /*
        listView.setEditable(false);
        data.addAll(livres);
        listView.setItems(data);
        
        */
        
        HBox statistics = new HBox();
        statistics.setMinSize(640,100);
        
        VBox v1  = this.statisticsValue("RESERVATIONS",3,"-fx-background-color:#0683E2");
        VBox v2  = this.statisticsValue("EMPRUNTS",2,"-fx-background-color:#34F2B9");
        
        javafx.scene.shape.Rectangle r1 = new javafx.scene.shape.Rectangle(20,20);
        javafx.scene.shape.Rectangle r2 = new javafx.scene.shape.Rectangle(20,20);
        r1.setFill(Color.TRANSPARENT);
        r2.setFill(Color.TRANSPARENT);
        
        statistics.getChildren().add(v1);
        statistics.getChildren().add(r1);
        statistics.getChildren().add(v2);
        
        //statistics.getChildren().add(new javafx.scene.shape.Rectangle(10,10));
        //statistics.setStyle("-fx-background-color:rgb(20,29,100)");
        
        
        statistics.setPadding(new Insets(20, 0, 20, 0));
        
        
        
        
        contentBox.getChildren().addAll(statistics);
        verticalBox.getChildren().addAll(headBox,contentBox);
        verticalBox.setAlignment(Pos.CENTER_RIGHT);
        verticalBox.setMaxWidth(680);
        verticalBox.setPadding(new Insets(0,0,0,30));
        return verticalBox;
    }
    
    public VBox statisticsValue(String str,int nombre,String color){
        VBox vertical = new VBox();
        HBox options = new  HBox();
        HBox data = new HBox();
        Label nomValue = new Label(" "+str);
        
        Label nombrevalue = new Label(nombre+"");
        nomValue.setTextFill(Color.web("rgb(255,255,255)"));
        nombrevalue.setTextFill(Color.web("rgb(255,255,255)"));
        nombrevalue.setPadding(new Insets(0,0,0,200));
        nomValue.setPadding(new Insets(0,0,0,0));
        
        data.setPadding(new Insets(0,0,20,0));
        options.setPadding(new Insets(10,30,0,0));
        
        Button list = new Button("");
        list.setMinSize(40,30);
        list.setId("button_list");
        //list.setPadding(new Insets(3,0,0,0));
        Button add = new Button("");
        add.setMinSize(100,30);
        //list.setPadding(new Insets(0,0,0,0));
        add.setId("button_add");
        
        // list event 
        list.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                if(str.equals("EMPRUNTS")){
                    Label titre = new Label("MES EMPRUNTS");
                    
                    titre.setPadding(new Insets(0, 0, 40, 0));
                    ScrollPane livreScroll = ListeDesEmprunts();
                    contentBox.getChildren().clear();
                    contentBox.getChildren().addAll(titre,livreScroll);
                }
                else if(str.equals("RESERVATIONS")){
                    Label titre = new Label("MES RESERVATIONS");
                    
                    titre.setPadding(new Insets(0, 0, 40, 0));
                    ScrollPane livreScroll = ListeDesReservations();
                    contentBox.getChildren().clear();
                    contentBox.getChildren().addAll(titre,livreScroll);
                }
                
            }
            
        });
        list.setStyle("-fx-border-color: transparent;");
        add.setStyle("-fx-border-color: transparent;");
        data.getChildren().addAll(nomValue,nombrevalue);
        options.getChildren().addAll(list,add);
        
        vertical.getChildren().addAll(data,options);
        vertical.setMinWidth(310);
        vertical.setMaxWidth(200);
        vertical.setStyle(color);
        vertical.setId("hbox");
        vertical.getStylesheets().addAll(GUI_Adherent.class.getResource("css.css").toExternalForm());
        return vertical;
    }
    
        public ScrollPane ListeDesEmprunts(){
        VBox emprunts = new VBox();
        int size=0;
        if(MAdherent.savoirEmprunteEncours(adherent.getId()) !=null ){
            size = MAdherent.savoirEmprunteEncours(adherent.getId()).size();
        }
         
        elements = new VBox[size];
        for(int i=0;i<size;i++){
            elements[i] = this.livreBoxFiche(MAdherent.savoirEmprunteEncours(adherent.getId()).get(i));
            emprunts.getChildren().add(elements[i]);
            javafx.scene.shape.Rectangle r2 = new javafx.scene.shape.Rectangle(20,20);
            r2.setFill(Color.TRANSPARENT);
            emprunts.getChildren().add(r2);
        }
        
        ScrollPane scroll = new ScrollPane();
        scroll.setMinHeight(300);
        scroll.setMaxHeight(700);
        
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll.setStyle("-fx-background: #EFEFEF;-fx-border-color: #EFEFEF;");
        
        
        emprunts.setMinSize(640,600);
        emprunts.setId("hbox");
        emprunts.getStylesheets().addAll(GUI_Bibliothecaire.class.getResource("css.css").toExternalForm());
        scroll.setContent(emprunts);
        return scroll;
    }
    
    public ScrollPane ListeDesReservations(){
        Reservations = new VBox();
        MBibliothecaire b = new MBibliothecaire();
        int size = 0;
        if(MAdherent.savoirReservationEncours(adherent.getId()) !=null){
            size = MAdherent.savoirReservationEncours(adherent.getId()).size();
        }
        
        elements = new VBox[size];
        for(int i=0;i<size;i++){
            elements[i] = this.livreBox_reservation(b.savoirReservationEncours().get(i),i);
            Reservations.getChildren().add(elements[i]);
            javafx.scene.shape.Rectangle r2 = new javafx.scene.shape.Rectangle(20,20);
            r2.setFill(Color.TRANSPARENT);
            Reservations.getChildren().add(r2);
        }
        
        scroll = new ScrollPane();
        scroll.setMinHeight(300);
        scroll.setMaxHeight(700);
        
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll.setStyle("-fx-background: #EFEFEF;-fx-border-color: #EFEFEF;");
        
        
        Reservations.setMinSize(640,600);
        Reservations.setId("hbox");
        Reservations.getStylesheets().addAll(GUI_Bibliothecaire.class.getResource("css.css").toExternalForm());
        scroll.setContent(Reservations);
        return scroll;
    }
    
    public VBox livreBoxFiche(FicheAdherent o){
        VBox livre = new VBox();
        HBox options = new  HBox();
        HBox data = new HBox();
        
        Label livretitre = new Label(o.getAdherent().getNom());  
        livretitre.setFont(new Font("Calibri",16));
        Label autheur = new Label(o.getDateRetour());
        autheur.setFont(new Font("Calibri",16));
        livretitre.setTextFill(Color.web("rgb(255,255,255)"));
        autheur.setTextFill(Color.web("rgb(255,255,255)"));
        autheur.setPadding(new Insets(0,0,0,0));
        livretitre.setPadding(new Insets(0,500,0,5));
        
        data.setPadding(new Insets(0,0,0,0));
        options.setPadding(new Insets(0,30,0,0));
        
        Label list = new Label(o.getDateRetour());
        list.setMinSize(40,20);
        //list.setId("button_list");
        //list.setPadding(new Insets(3,0,0,0));
        //Button add = new Button("");
        //add.setMinSize(220,30);
        //list.setPadding(new Insets(0,0,0,0));
        //add.setId("button_add");

        data.getChildren().addAll(livretitre,autheur);
        options.getChildren().addAll(list);
        
        livre.getChildren().addAll(data,options);
         
         
        livre.setStyle("-fx-background-color:#34F2B9");
        livre.setMinSize(600,40);
        livre.setPadding(new Insets(0, 0, 20, 0));
        livre.setId("hbox");
        livre.getStylesheets().addAll(GUI_Bibliothecaire.class.getResource("css.css").toExternalForm());
        return livre;
    }
    public VBox livreBox(Ouvrage o){
        VBox livre = new VBox();
        HBox options = new  HBox();
        HBox data = new HBox();
        
        Label livretitre = new Label(o.getTitre());  
        livretitre.setFont(new Font("Calibri",16));
        Label autheur = new Label(o.getAuteur());
        autheur.setFont(new Font("Calibri",16));
        livretitre.setTextFill(Color.web("rgb(255,255,255)"));
        autheur.setTextFill(Color.web("rgb(255,255,255)"));
        autheur.setPadding(new Insets(0,0,0,0));
        livretitre.setPadding(new Insets(0,500,0,5));
        
        data.setPadding(new Insets(0,0,0,0));
        options.setPadding(new Insets(0,30,0,0));
        
        Label list = new Label("Duree restante : 1 jour");
        list.setMinSize(40,20);
        //list.setId("button_list");
        //list.setPadding(new Insets(3,0,0,0));
        //Button add = new Button("");
        //add.setMinSize(220,30);
        //list.setPadding(new Insets(0,0,0,0));
        //add.setId("button_add");

        data.getChildren().addAll(livretitre,autheur);
        options.getChildren().addAll(list);
        
        livre.getChildren().addAll(data,options);
         
         
        livre.setStyle("-fx-background-color:#34F2B9");
        livre.setMinSize(600,40);
        livre.setPadding(new Insets(0, 0, 20, 0));
        livre.setId("hbox");
        livre.getStylesheets().addAll(GUI_Bibliothecaire.class.getResource("css.css").toExternalForm());
        return livre;
    }
    
    public VBox livreBox_reservation(FicheAdherent o,int v){
        VBox livre = new VBox();
        HBox options = new  HBox();
        HBox data = new HBox();
        
        Label livretitre = new Label(o.getOuvrage().getTitre());  
        livretitre.setFont(new Font("Calibri",16));
        Label autheur = new Label(o.getAdherent().getNom()+" "+o.getAdherent().getPrenom());
        autheur.setFont(new Font("Calibri",16));
        livretitre.setTextFill(Color.web("rgb(255,255,255)"));
        autheur.setTextFill(Color.web("rgb(255,255,255)"));
        autheur.setPadding(new Insets(0,0,0,0));
        livretitre.setPadding(new Insets(0,500,0,5));
        
        data.setPadding(new Insets(0,0,0,0));
        options.setPadding(new Insets(0,30,0,0));
        
        Button validerReservation = new Button("Confirmer reservation");
        validerReservation.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    Reservations.getChildren().remove(elements[v]);
                    MBibliothecaire mb = new MBibliothecaire();
                    System.out.println(o.getAdherent().getId());
                    System.out.println(o.getOuvrage().getIdOuv());
                    if(mb.validerEmprunte(o.getAdherent().getId(),o.getOuvrage().getIdOuv()))
                        System.out.println("c fait :::");
                
                    
            }
        });
        validerReservation.setStyle("-fx-background-color:#0080FF");
        validerReservation.setMinSize(40,20);
        validerReservation.setPadding(new Insets(5,5,5,5));
        validerReservation.setTextFill(Color.WHITE);
        //list.setId("button_list");
        //list.setPadding(new Insets(3,0,0,0));
        //Button add = new Button("");
        //add.setMinSize(220,30);
        //list.setPadding(new Insets(0,0,0,0));
        //add.setId("button_add");
        data.setPadding(new Insets(0, 0,20, 0));
        options.setAlignment(Pos.BASELINE_RIGHT);
        data.getChildren().addAll(livretitre,autheur);
        options.getChildren().addAll(validerReservation);
        
        livre.getChildren().addAll(data,options);
         
         
        livre.setStyle("-fx-background-color:#34F2B9");
        livre.setMinSize(600,40);
        livre.setPadding(new Insets(0, 0, 20, 0));
        livre.setId("hbox");
        livre.getStylesheets().addAll(GUI_Bibliothecaire.class.getResource("css.css").toExternalForm(),GUI_Bibliothecaire.class.getResource("button.css").toExternalForm());
        return livre;
    }
     public ScrollPane ResultatRecherche(String search){
        VBox emprunts = new VBox();
        Random ran = new Random();
        MVisiteur management_visiteur = new  MVisiteur();
        ArrayList<Ouvrage> resultats = management_visiteur.rechercherOuvrage(search);
        VBox[] elements = new VBox[ran.nextInt(6)];
        for(int i=0;i<resultats.size();i++){
            Ouvrage ouvrage = resultats.get(i);
            VBox livre = this.livreBox(ouvrage);
            emprunts.getChildren().add(livre);
            javafx.scene.shape.Rectangle r2 = new javafx.scene.shape.Rectangle(20,20);
            r2.setFill(Color.TRANSPARENT);
            emprunts.getChildren().add(r2);
        }
        
        ScrollPane scroll = new ScrollPane();
        scroll.setMinHeight(300);
        scroll.setMaxHeight(700);
        
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll.setStyle("-fx-background: #EFEFEF;-fx-border-color: #EFEFEF;");
        
        
        emprunts.setMinSize(640,600);
        emprunts.setId("hbox");
        emprunts.getStylesheets().addAll(GUI_Bibliothecaire.class.getResource("css.css").toExternalForm());
        scroll.setContent(emprunts);
        return scroll;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

