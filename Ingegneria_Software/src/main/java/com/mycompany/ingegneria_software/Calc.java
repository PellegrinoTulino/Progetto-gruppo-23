package com.mycompany.ingegneria_software;

import java.util.Arrays;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * JavaFX Calc
 */
public class Calc extends Application {

    @Override
    public void start(Stage stage) {
        //set controller
        CalcView GUI = new CalcView();
        CalcController controller= new CalcController(GUI); 
        
        //proprietà Stage-------------
        stage.setTitle("Calcolatrice gruppo23");
        stage.setMinWidth(280);
        stage.setMaxWidth(600);
        stage.setMinHeight(450);
        stage.setMaxHeight(500);  
        
        Scene scene = new Scene(GUI, 320, 420);
        scene.setFill(Color.DARKGRAY);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}