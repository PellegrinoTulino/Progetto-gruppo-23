/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ingegneria_software;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author ANDREA
 */
public class LetterView extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //proprietà stage
        primaryStage.setTitle("Lettera gruppo23");
        primaryStage.setMinWidth(500);
        primaryStage.setMaxWidth(800);
        primaryStage.setMinHeight(350);
        primaryStage.setMaxHeight(400);
        
        BorderPane root = new BorderPane();
        //Label "INSERISCI LETTERA"
        Label lb = new Label("INSERISCI LETTERA");
        lb.setStyle("-fx-text-color: black; -fx-font-weight: bold;");
        
        HBox label = new HBox(lb);
        label.setAlignment(Pos.CENTER);
        label.setPadding(new Insets(50,10,10,20));
        root.setTop(label);
        
        //Creazione pulsanti e loro testo
            //i pulsanti contengono lettere latine minuscole
        int NUMLETTERS = 26;
        Button[] letters = new Button[NUMLETTERS];
        for (int i=0; i<NUMLETTERS;i++){
            letters[i] = new Button(Character.toString ((char) (i+97))); // "a" ascii code è 97
        }
        
        //settare lo stile ai bottoni lettere
        buttonStyle(letters);
        
        //Inserimento pulsanti in griglia
        int LETTERSCOL = 10;
        GridPane lettersPad = new GridPane();
        for(int i =0;i<NUMLETTERS;i++){
            GridPane.setConstraints(letters[i], i%LETTERSCOL, (int) i/LETTERSCOL);
        }
        lettersPad.getChildren().addAll(letters);
        
        lettersPad.setVgap(5);
        lettersPad.setHgap(5);
        lettersPad.setAlignment(Pos.CENTER);
        
        root.setCenter(lettersPad);
        
        Scene scene = new Scene(root, 300, 250);
        scene.setFill(Color.GRAY);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
     //aggiunge lo stile a un gruppo di bottoni passati
        //sfondo nero testo bianco
    public void buttonStyle(Button[] btn){
        for( int i=0;i<btn.length;i++){
            btn[i].setStyle("-fx-background-color: black; -fx-text-fill: white;"
                    + "-fx-border-color: lightgray;-fx-border-width: 2px;"
                    + "-fx-font-weight: bold");
        }
    }
    
}
