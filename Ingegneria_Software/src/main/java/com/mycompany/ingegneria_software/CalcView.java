package com.mycompany.ingegneria_software;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX CalcView
 */
public class CalcView extends Application {

    @Override
    public void start(Stage stage) {
        //inizializza contenuto delle labels
        Label valSalvati = new Label("TEST VAL Salvati");
        Label inputOutput = new Label("TEST INPUTOUTPUt");
       
        
        //inizializza contenuto del tastierino numerico
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
        }
        numeri[NUMTASTIERINO-2] = new Button(nums[NUMTASTIERINO-2]);
        numeri[NUMTASTIERINO-1] = new Button(nums[NUMTASTIERINO-1]);
        
        //inzializzo contenuto tasti operatori
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
        
        //inizializzo contenuto pulsanti di alterazione dello stack
        int NUMCDMSTACKBUTTONS = 5;
        Button[] cmdStack = new Button[NUMCDMSTACKBUTTONS ];
        
        String[] cmsStackSign={
            "clear", "drop","dup",
            "swap","over"
        };
        
        for(int i=0;i<NUMCDMSTACKBUTTONS;i++){
            cmdStack[i]= new Button(cmsStackSign[i]);
        }
        
        //inizializzo contenuto pulsanti aggiuntivi
            //HELP, LETTERS, SEND, ESEGUI 
        int NUMPULSANTIAGGIUNTIVI = 4;
        Button[] pulsantiAggiuntivi = new Button[NUMPULSANTIAGGIUNTIVI];
        
        String[] pulsantiAggiuntiviSign={
            "HELP", "a-z", "↪", "="
        };
        
        for(int i=0;i<NUMPULSANTIAGGIUNTIVI;i++){
           pulsantiAggiuntivi[i]= new Button(pulsantiAggiuntiviSign[i]);
        }
        
        initButtons();
        placeButtons();
        
        initLabels();
        placeLabels();
        
        
        Scene scene = new Scene(new VBox(valSalvati,inputOutput), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    
    public void initLabels(){
        
    }
    
    //Determina la posizione delle labels nell'interfaccia grafica
    public void placeLabels(){
        //valSalvati + inpiutOutpu in VBOX=LABELS
    }
    
    //assoccia ad ogni gruppo di bottoni, il suo handler
    public void initButtons(){
        
    }
    
    //organizza la disposizioni dei bottoni nella GUI
    public void placeButtons(){
        
        //CMDSTACK è HBOX
        
        //OPERATORI in GRIDPANE (con sotto HBOX e tutto in un VBOX??)
        
        //TASTIERINO NUM è GRIDPANE
        //-----------
        //CANC, OPERATORI E ESEGUI in un VBOX= DX
        
       // TASTIERINO + DX in un HBOX = INPUT
       
       //CMDSTACK + INPUT in un VBOX = BASSO
       //------------
        //TASTO LETTERE + SEND in HBOX = UPPER
        
        //HELP + LABLES + UPPER + BASSO in VBOX 
          
    }

}