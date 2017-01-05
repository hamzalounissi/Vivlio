/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotheque;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author 6
 */
public class Vivlio extends Application {
    
    
    GUI_Authentification auth;
    GUI_Visiteur visiteur;
    @Override
    public void start(Stage primaryStage) throws Exception {
        
       auth = new GUI_Authentification();
       visiteur = new GUI_Visiteur();
       Scene sc = auth.scene;
       Stage stage =  (Stage) auth.scene.getWindow();
       stage.setScene(sc);
       stage.show();
       //primaryStage.setTitle("cc");
       //primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
