/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotheque;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author 6
 */
public class Vivlio_app extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
       
        Button btn = new Button("Inscription");
        Button btn2 = new Button("Connexion");
        TextField txt = new TextField("email");
        PasswordField pwd = new PasswordField();
        
        
        System.out.println(btn2.getHeight());
        pwd.setMaxWidth(200);
        txt.setMaxWidth(200);
        btn2.setMaxWidth(200);
        
        VBox hori_box = new VBox();
        hori_box.setSpacing(5);
        
        hori_box.getChildren().add(txt);
        hori_box.getChildren().add(pwd);
        //hori_box.getChildren().add(btn);
        hori_box.getChildren().add(btn2);
        
        
        
        StackPane root = new StackPane();
        root.setLayoutX(75);
        root.setLayoutY(130);
        root.setStyle("-fx-background-color: rgba(0,0,0,0);");
        root.getChildren().add(hori_box);
        
        
        
       
        
        Scene scene = new Scene(root, 350,300,Color.AZURE);
        scene.setFill(Color.DEEPSKYBLUE);
        
        primaryStage.setTitle("Vivlio - Gesti des Bibliothèques");
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
