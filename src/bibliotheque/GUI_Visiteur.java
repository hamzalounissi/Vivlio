/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotheque;

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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import static javafx.application.Application.launch;
import static javafx.application.Application.launch;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import management.MVisiteur;
import model.Ouvrage;

/**
 *
 * @author 6
 */
public class GUI_Visiteur extends Application{
    Scene scene;
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        ArrayList<String> livres  = new ArrayList<>();
        livres.add("livre 1");
        livres.add("livre 2");
        StackPane root = new StackPane();
        VBox horizontal_box_sidebar = new VBox();
        VBox logo_profil = new VBox();
        VBox horizontal_box_wrapper = new VBox();
        HBox mainBox = new HBox();
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
            if(newValue.toString().equals("S'authentifier")){
                GUI_Authentification auth  = new GUI_Authentification();
                try {
                    //listView.getSelectionModel().clearSelection();
                    auth.start(primaryStage);
                   
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                
                
                
            }
         });

        data.addAll("S'inscrire","S'authentifier");
        
        listView.setItems(data);
        File file = new File("C:\\Users\\6\\Desktop/VivlioLogo.png");
        System.out.println(file.getName()+" "+file.getCanonicalPath());
        
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

        
        listView.getStylesheets().addAll(GUI_Visiteur.class.getResource("css.css").toExternalForm());
        
        primaryStage.setTitle("Vivlio - Gestion des Bibliothèques");
        
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    public VBox wrapper(ArrayList<String> livres){
        VBox verticalBox = new VBox();
        VBox headBox = new VBox();
        VBox contentBox = new VBox();
        
        
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
        search.getStylesheets().addAll(GUI_Visiteur.class.getResource("css.css").toExternalForm());
        ObservableList<String> data = FXCollections.observableArrayList();
        ListView<String> listView = new ListView<String>(data);
        listView.setPrefWidth(680);
        
        headBox.getChildren().add(search);
        
        
        
        verticalBox.getChildren().addAll(headBox,contentBox);
        verticalBox.setAlignment(Pos.CENTER_RIGHT);
        verticalBox.setMaxWidth(680);
        verticalBox.setPadding(new Insets(0,0,0,30));
        return verticalBox;
    }
    public VBox livreBox(String l_titre,String auth){
        VBox livre = new VBox();
        HBox options = new  HBox();
        HBox data = new HBox();
        
        Label livretitre = new Label(l_titre);  
        livretitre.setFont(new Font("Calibri",16));
        Label autheur = new Label(auth);
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
        livre.getStylesheets().addAll(GUI_Assistant.class.getResource("css.css").toExternalForm());
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
            VBox livre = this.livreBox(ouvrage.getTitre(),ouvrage.getAuteur());
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

