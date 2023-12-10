package com.mycompany.ingegneria_software;

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
 * JavaFX CalcView
 */
public class CalcView extends Application {

    @Override
    public void start(Stage stage) {
        //proprietà Stage
        stage.setTitle("Calcolatrice gruppo23");
        stage.setMinWidth(280);
        stage.setMaxWidth(500);
        stage.setMinHeight(380);
        stage.setMaxHeight(400);
        
        
        //inizializza contenuto delle labels
        Label valSalvati = new Label("TEST VAL Salvati");
        Label inputOutput = new Label("TEST INPUTOUTPUt");
       
        
        //inizializza contenuto del tastierino numerico----------
        int NUMTASTIERINO = 12;
        int NUMCOLTASTIERINO = 3;
        
        String[] nums={
            "1", "2", "3",
            "4", "5", "6",
            "7", "8", "9",
            "0",".","j"
        };
        
        Button[] numeri;
        numeri = new Button[NUMTASTIERINO ];
        
        for(int i=0;i<NUMTASTIERINO-2;i++){
            numeri[i]=new Button(nums[i]);
            numeri[i].setMinWidth(30);
        }
        numeri[NUMTASTIERINO-2] = new Button(nums[NUMTASTIERINO-2]);
        numeri[NUMTASTIERINO-2].setMinWidth(30);
        numeri[NUMTASTIERINO-1] = new Button(nums[NUMTASTIERINO-1]);
        numeri[NUMTASTIERINO-1].setMinWidth(30);
        
        
        //Inserimento Pulsanti in un GridPane
        GridPane TastNum = placeGrid(numeri,NUMTASTIERINO ,NUMCOLTASTIERINO);
        buttonStyle(numeri); //associa stile
        
        //inzializzo contenuto tasti operatori---------------
        int NUMOPERATORI = 8;
        Button[] operatori = new Button[NUMOPERATORI];
        
        String[] operatoriSign={
            "+", "-", "±",
            "x", "÷", "√",
            "<", ">"
        };
        
        for(int i=0;i<NUMOPERATORI;i++){
            operatori[i]= new Button(operatoriSign[i]);
        }
        
        //Inserimento primi 6 Operatori in GridPane; e ultimi 2 in Hbox centrato
        //Tutto in Vbox
        
        /*
            +  -  ±
            x  ÷  √
             >   <
        */
        
        VBox TastOperatori;
        TastOperatori = placeOperator( placeGrid(operatori,6,3), placeHBoxButton( new Button[] {operatori[NUMOPERATORI-2], operatori[NUMOPERATORI-1]}));
        buttonStyle(operatori); //associa stile
        
        //inizializzo contenuto pulsanti di alterazione dello stack---------
        int NUMCDMSTACKBUTTONS = 5;
        Button[] cmdStack = new Button[NUMCDMSTACKBUTTONS ];
        
        String[] cmsStackSign={
            "clear", "drop","dup",
            "swap","over"
        };
        
        for(int i=0;i<NUMCDMSTACKBUTTONS;i++){
            cmdStack[i]= new Button(cmsStackSign[i]);
        }
        
        //Disponi CmdStackButton in una linea
        HBox TastCmdStack = placeHBoxButton(cmdStack);
        buttonStyle(cmdStack); //associa stile
        
        //inizializzo contenuto pulsanti aggiuntivi----------------
            //HELP, LETTERS, SEND, CANC, ESEGUI 
        int NUMPULSANTIAGGIUNTIVI = 5;
        Button[] pulsantiAggiuntivi = new Button[NUMPULSANTIAGGIUNTIVI];
        
        String[] pulsantiAggiuntiviSign={
            "HELP", "a-z", "↪","CANC" , "="
        };
        
        for(int i=0;i<NUMPULSANTIAGGIUNTIVI;i++){
           pulsantiAggiuntivi[i]= new Button(pulsantiAggiuntiviSign[i]);
        }
        buttonStyle(pulsantiAggiuntivi); //associa stile
        
        
        //Posizione gli elementi nella GUI
        VBox GUI = placeElements(valSalvati, inputOutput, TastNum,TastOperatori,TastCmdStack,pulsantiAggiuntivi);
        //Associa ad ogni elementi i suoi handlers
        
        
        
        
        Scene scene = new Scene(GUI, 250, 360);
        scene.setFill(Color.GRAY);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    
    //Determina la posizione delle labels nell'interfaccia grafica
    public void placeLabels(){
        //valSalvati + inpiutOutpu in VBOX=LABELS
    }
    
    //assoccia ad ogni gruppo di elementi, il suo handler
    public void initElements(){
        
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
    
    //Dispone un gruppo di bottoni in una griglia
    public GridPane placeGrid(Button[] btn,int NUM , int COL){
        GridPane TastNum = new GridPane();
        TastNum.setPadding( new Insets (10,10,10,10));
        TastNum.setVgap(5);
        TastNum.setHgap(5);
        
        for(int i=0;i<NUM;i++){
            GridPane.setConstraints(btn[i], i%COL, (int) i/COL);
        }
        TastNum.getChildren().addAll(btn);
        return TastNum;
    }
    
    //Raggruppa i bottoni operatori
    public VBox placeOperator(GridPane grid, HBox line){
        VBox vertical = new VBox();
        vertical.getChildren().addAll(grid, line);
        
        return vertical;
    }
    
    //Dispone un array di bottoni in una linea
    public HBox placeHBoxButton( Button[] btn){
        HBox line = new HBox();
        
        for(int i=0;i<btn.length;i++){ 
            line.getChildren().addAll(btn[i]);
        }
        
        line.setAlignment(Pos.CENTER);
        line.setSpacing(5);
        return line;
    }
    
    
    //Dipone gli elementi della GUI nella posizione corretta
    
    public VBox placeElements(Label valSalvati, Label output, GridPane TastNum, VBox operatori, HBox cmdStack, Button[] aggiuntivi){
        /*  aggiuntivi[0]=HELP, aggiuntivi[1]= PULSANTE LETTER, 
            aggiuntivi[2]=SEND,aggiuntivi[3]=CANC , aggiuntivi[4]= ESEGUI */
        
        
        //parte alta calcolatrice-------------
        /*
            |               HELP |
            |         valSalvati |
            |            Output  |
            |                    |
        
        */
        
        
        VBox upperPart = new VBox();
        
        //le labels appaiono su uno sfondo squadrato nero
        VBox labelBox = new VBox();
        valSalvati.setStyle("-fx-text-fill: white; -fx-font-size: 9px;");
        output.setStyle("-fx-text-fill: white;");
        labelBox.setStyle("-fx-background-color: black"); 
        labelBox.getChildren().addAll(valSalvati, output);
        
        labelBox.setAlignment(Pos.CENTER_RIGHT);
        labelBox.setSpacing(5);
        labelBox.setPadding(new Insets(5,5,5,5));
        
        upperPart.getChildren().addAll( aggiuntivi[0], labelBox);
        upperPart.setAlignment(Pos.CENTER_RIGHT);
        upperPart.setSpacing(5);
        upperPart.setPadding(new Insets(10,10,10,10));
        
        //parte bassa calcolatrice---------------
        /*
            |     |CMD STACK|      |
            |  LETTER        CANC  |
            |  _____     _________ |
            | |TAST |   |Operatori||
            | |NUM__|   |_________||
            |             ESEGUI   |
        
        */
        VBox bottomPart = new VBox();
        
        //sezione Lettere e Canc
        BorderPane lettCanc = new BorderPane();
        lettCanc.setPadding( new Insets(10,10,10,10));
        lettCanc.setLeft(aggiuntivi[1]);
        lettCanc.setRight(aggiuntivi[3]);
        
        //sezione operatori ed Esegui
        VBox opEsegui = new VBox();
        HBox esegui = new HBox (aggiuntivi[4]);
                esegui.setAlignment(Pos.CENTER);
        opEsegui.getChildren().addAll(operatori, esegui);
        opEsegui.setSpacing(5);
        
        aggiuntivi[4].setMinWidth(100);
        
        bottomPart.getChildren().addAll(cmdStack, lettCanc, new BorderPane(null,null,opEsegui, null, TastNum)); //opEsegui a destra, TastNum a sinistra
        bottomPart.setSpacing(5);
        
        //Unione parte inferiore e superiore------------
        VBox GUI = new VBox(upperPart, bottomPart);
        GUI.setSpacing(10);
        return GUI;
    }
}