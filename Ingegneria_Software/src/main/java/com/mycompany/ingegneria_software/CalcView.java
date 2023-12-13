/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ingegneria_software;

import java.util.Arrays;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author ANDREA
 */
public class CalcView extends VBox{
    
    //Elementi grafici-----------
       public Label valSalvati;       //labels
       public Label inputOutput;
        
       public int NUMTASTIERINO;      //Tastierino numerico
       public Button[] numeri;
        
       public int NUMOPERATORI; //Operatori
       public Button[] operatori;
        
       public int NUMCDMSTACKBUTTONS; //Alterazione dello stack
       public Button[] cmdStack;
        
       public int NUMPULSANTIAGGIUNTIVI;  //Altri pulanti (HELP, Lettere, SEND, CANC, ESEGUI)
       public Button[] pulsantiAggiuntivi;
        
       
       public CalcView(){
        //inizializza contenuto delle labels
        valSalvati = new Label("TEST VAL Salvati");
        inputOutput = new Label("TEST INPUTOUTPUt");
        
        //inizializza contenuto del tastierino numerico----------
        NUMTASTIERINO = 12;
        int NUMCOLTASTIERINO = 3;
        
        String[] nums={
            "1", "2", "3",
            "4", "5", "6",
            "7", "8", "9",
            "0",".","j"
        };
        
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
        NUMOPERATORI = 8;
        operatori = new Button[NUMOPERATORI];
        
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
        NUMCDMSTACKBUTTONS = 5;
        cmdStack = new Button[NUMCDMSTACKBUTTONS ];
        
        String[] cmsStackSign={
            "clear", "drop","dup",
            "swap","over"
        };
        
        for(int i=0;i<NUMCDMSTACKBUTTONS;i++){
            cmdStack[i]= new Button(cmsStackSign[i]);
        }
        
        //Disponi CmdStackButton in una linea
        HBox TastCmdStack = placeHBoxButton(cmdStack);
        TastCmdStack.setAlignment(Pos.CENTER);
        buttonStyle(cmdStack); //associa stile
        
        //inizializzo contenuto pulsanti aggiuntivi----------------
            //HELP, LETTERS, SEND, CANC, ESEGUI 
        NUMPULSANTIAGGIUNTIVI = 6;
        pulsantiAggiuntivi = new Button[NUMPULSANTIAGGIUNTIVI];
        
        String[] pulsantiAggiuntiviSign={
            "HELP", "a-z", "↪","CANC" , "=", "DEL"
        };
        
        for(int i=0;i<NUMPULSANTIAGGIUNTIVI;i++){
           pulsantiAggiuntivi[i]= new Button(pulsantiAggiuntiviSign[i]);
        }
        buttonStyle(pulsantiAggiuntivi); //associa stile
        pulsantiAggiuntivi[2].setMinWidth(50);//aumenta larghezza pulsante SEND
        
        
        //Posizione gli elementi nella GUI-------------
        VBox GUI = placeElements(valSalvati, inputOutput, TastNum,TastOperatori,TastCmdStack,pulsantiAggiuntivi);
        this.getChildren().add(GUI);
       }
       
       
    //aggiunge lo stile a un gruppo di bottoni passati
        //sfondo nero testo bianco
    public void buttonStyle(Button[] btn){
        for (Button btn1 : btn) {
            btn1.setStyle("-fx-background-color: black; -fx-text-fill: white;"
                    + "-fx-border-color: lightgray;-fx-border-width: 2px;"
                    + "-fx-font-weight: bold");
            btn1.setMinWidth(30);
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
        line.setAlignment(Pos.CENTER);
        vertical.getChildren().addAll(grid, line);
        
        return vertical;
    }
    
    //Dispone un array di bottoni in una linea
    public HBox placeHBoxButton( Button[] btn){
        HBox line = new HBox();
        
        line.getChildren().addAll(Arrays.asList(btn));
        
        line.setSpacing(5);
        return line;
    }
    
    
    //Dispone gli elementi della GUI nella posizione corretta
    public VBox placeElements(Label valSalvati, Label output, GridPane TastNum, VBox operatori, HBox cmdStack, Button[] aggiuntivi){
        /*  aggiuntivi[0]=HELP, aggiuntivi[1]= PULSANTE LETTER, 
            aggiuntivi[2]=SEND,aggiuntivi[3]=CANC , aggiuntivi[4]= ESEGUI 
            aggiuntivi [5]=DELETE*/
        
        
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
        
        //unione blocco labels e di HELLP in upper part
        upperPart.getChildren().addAll( aggiuntivi[0], labelBox); //aggiuntivi[0]=HELP
        upperPart.setAlignment(Pos.CENTER_RIGHT);
        upperPart.setSpacing(5);
        upperPart.setPadding(new Insets(10,10,10,10));
        
        //parte bassa calcolatrice---------------
        /*
            |  LETTER        SEND  |
            |     |CMD STACK|      |
            |           DEL  CANC  |
            |  _____     _________ |
            | |TAST |   |Operatori||
            | |NUM__|   |_________||
            |             ESEGUI   |
        
        */
        VBox bottomPart = new VBox();
        
        //sezione Lettere e Send
        BorderPane lettSend = new BorderPane();
        lettSend.setPadding( new Insets(10,10,10,10));
        lettSend.setLeft(aggiuntivi[1]); //aggiuntivi[1]=pulsante lettere
        lettSend.setRight(aggiuntivi[2]); //aggiuntivi[2]=pulsante Send
        
        //sezione operatori ed Esegui
        VBox OpEsegui = new VBox();
        aggiuntivi[4].setMinWidth(100); //aggiuntivi[4]=Esegui
        HBox esegui = new HBox (aggiuntivi[4]);  //aggiuntivi[4]=Esegui
                esegui.setAlignment(Pos.CENTER);
        OpEsegui.getChildren().addAll(operatori, esegui);
        OpEsegui.setSpacing(5);
        
        //sezione CANC e DEL
        HBox delCanc = new HBox (aggiuntivi[5], aggiuntivi[3]);  //aggiuntivi[3]=CANC. aggiuntivi[5]=CANC
                delCanc.setAlignment(Pos.CENTER_RIGHT);
                delCanc.setSpacing(5);
                delCanc.setPadding(new Insets(10,10,10,10));
        
        //unione vari elementi in bottomPart
        bottomPart.getChildren().addAll(lettSend, cmdStack, delCanc, new BorderPane(null,null,OpEsegui, null, TastNum)); //OpEsegui a destra, TastNum a sinistra
        bottomPart.setSpacing(5);
        
        //Unione parte inferiore e superiore------------
        VBox GUI = new VBox(upperPart, bottomPart);
        GUI.setSpacing(10);
        return GUI;
    }
}
