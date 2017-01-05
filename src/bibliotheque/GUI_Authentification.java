/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotheque;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
import javafx.stage.WindowEvent;
import static javafx.application.Application.launch;
import static javafx.application.Application.launch;
import static javafx.application.Application.launch;
import javafx.scene.layout.Border;
import management.MAdherent;
import management.MAssistant;
import management.MBibliothecaire;

/**
 *
 * @author 6
 */
public class GUI_Authentification extends Application {
    
    
    Scene scene;
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, IOException {
        
       
        
        System.out.println("fff");
        File file = new File("/Images/logo-vivlio.png");
        System.out.println(file.getName()+" "+file.getCanonicalPath());
        
        Image img = new Image(new FileInputStream("C:\\Users\\6\\Desktop/VivlioLogo.png"));
        
        ImageView imgview_1 = new ImageView(img);
        ImageView imgview_2 = new ImageView(img);

        Button btn2 = new Button("CONNEXION");
        TextField txt = new TextField("EMAIL");
        PasswordField pwd = new PasswordField();
        Label pas_inscrit = new Label("Pas inscrit encore ?");
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
           
                MAdherent ma = new MAdherent();
                MAssistant massistant = new MAssistant();
                MBibliothecaire mb = new MBibliothecaire();
                if(ma.authentifier(txt.getText(),pwd.getText())){
                    System.err.println("auth");
                    GUI_Adherent aa = new GUI_Adherent();
                    try {
                        primaryStage.setUserData(txt.getText());
                         //System.out.println("Adherent : "+txt.getText());
                        aa.start(primaryStage);
                    } catch (Exception ex) {
                        Logger.getLogger(GUI_Authentification.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else if(massistant.authentifier(txt.getText(),pwd.getText())){
                    System.err.println("auth");
                    GUI_Assistant aa = new GUI_Assistant();
                    try {
                        primaryStage.setUserData(txt.getText());
                         //System.out.println("Adherent : "+txt.getText());
                        aa.start(primaryStage);
                    } catch (Exception ex) {
                        Logger.getLogger(GUI_Authentification.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else if(mb.authentifier(txt.getText(),pwd.getText())){
                    System.err.println("auth");
                    GUI_Bibliothecaire aa = new GUI_Bibliothecaire();
                    try {
                        primaryStage.setUserData(txt.getText());
                         //System.out.println("Adherent : "+txt.getText());
                        aa.start(primaryStage);
                    } catch (Exception ex) {
                        Logger.getLogger(GUI_Authentification.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else {
                            txt.getStylesheets().addAll(GUI_Authentification.class.getResource("error.css").toExternalForm(),GUI_Bibliothecaire.class.getResource("button.css").toExternalForm());
                            txt.setId("error");
                }
                    
                
            }
        });
        System.out.println(btn2.getHeight());
        pwd.setMaxWidth(200);
        txt.setMaxWidth(200);
        btn2.setMaxWidth(200);
        
        VBox auth_hori_box = new VBox();
        VBox insc_hori_box = new VBox();
        
        Button btn = new Button("Inscription");
        TextField nom_prenom = new TextField("NOM ET PRENOM");
        TextField university = new TextField("UNIVERSITE");
        TextField email = new TextField("EMAIL");
        PasswordField password = new PasswordField();
        Label deja = new Label("deja inscrit");
        Label visiter = new Label("Juste une visite  :)");
        
        visiter.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                    GUI_Visiteur visiteur = new GUI_Visiteur();
                    try{
                        //primaryStage.set
                        visiteur.start(primaryStage);


                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
            }
            
        });
        // CLOSING FRAME EVENT
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                
                GUI_Visiteur visiteur = new GUI_Visiteur();
                try{
                    //primaryStage.set
                    visiteur.start(primaryStage);
                    
                
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                
            
            }
        });
        
        
        
        auth_hori_box.getChildren().addAll(imgview_1,txt,pwd,btn2,pas_inscrit,visiter);
        auth_hori_box.setSpacing(5);
        
        insc_hori_box.getChildren().addAll(imgview_2,nom_prenom,university,email,password,btn,deja);
        insc_hori_box.setSpacing(5);
        

        pwd.setMaxWidth(200);
        txt.setMaxWidth(200);
        btn2.setMaxWidth(200);
        btn.setMaxWidth(200);
        nom_prenom.setMaxWidth(200);
        university.setMaxWidth(200);
        email.setMaxWidth(200);
        password.setMaxWidth(200);
        
        
        StackPane root = new StackPane();
        root.setLayoutX(75);
        root.setLayoutY(130);
        root.setStyle("-fx-background-color: rgba(0,0,0,0.0);");
        root.getChildren().add(auth_hori_box);
        
        
        
       
        
        scene = new Scene(root, 350,400,Color.DEEPSKYBLUE);
        
        pas_inscrit.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                   root.getChildren().clear();
                   root.getChildren().add(insc_hori_box);
                   scene.setRoot(root);
            }
            
        });
        deja.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                root.getChildren().clear();
                root.getChildren().add(auth_hori_box);
                scene.setRoot(root);
            }
            
        });
        primaryStage.setTitle("Vivlio - Gesti des Bibliothèques");
        //primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }
    
    public void getStage(){
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}


