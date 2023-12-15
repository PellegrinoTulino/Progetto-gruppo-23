/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ingegneria_software;

import static java.lang.Character.toLowerCase;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author ANDREA
 */
class CalcController {
    CalcView view;
    CalcModule module;
    
    public CalcController(CalcView view){
        this.view=view;
        module= new CalcModule();
        
        //rimozione testo placeholder dalla label di view
        view.inputOutput.setText("");
        view.valSalvati.setText("");
        
        //Associazione dei bottoni alle corrispèttive funzioni
        handlerTastNumerico();
        handlerOperatori();
        initCmdStack();
        initAggiuntivi();
        
    }
    
    //Aggiungi il contenuto del pulsante premuto sulla label inputOutput
    private void buttonPressed(ActionEvent e){
        Button btn = (Button) e.getSource();
        view.inputOutput.setText(view.inputOutput.getText() + btn.getText());
    }

    //aggiunge il numero premuto alla label di input
    private void handlerTastNumerico() {
        for(int i=0;i<view.NUMTASTIERINO;i++){
            
            view.numeri[i].setOnAction(e -> buttonPressed(e));
        }
    }
    
    //aggiunge l'operatore associato al pulsante premuto alla label di input
    private void handlerOperatori() {
        /*Pulsante  : Operatore
            +       :   +           operatori[0]
            -       :   -           operatori[1]
            ±       :   +-           operatori[2]
            x       :   *           operatori[3]
            ÷       :   /           operatori[4]
            √       :   sqrt        operatori[5]
            <       :   <           operatori[6]
            >       :   >           operatori[7]

        */
        
        for(int i=0;i<view.NUMOPERATORI;i++){
            
            view.operatori[i].setOnAction(e -> {
                Button btn = (Button) e.getSource();
                switch(btn.getText()){
                    
                    //questi pulsanti aggiungono il loro contenuto a inputOutput
                    case "+": case "-": case "<": case ">":
                        view.inputOutput.setText(view.inputOutput.getText() + btn.getText());
                        break;
                    
                    //questi pulsanti aggiungo ad inputOutput un simbolo diverso dal loro contenuto
                        
                    case "x":
                        view.inputOutput.setText(view.inputOutput.getText() + "*");
                        break;
                        
                    case "÷":
                        view.inputOutput.setText(view.inputOutput.getText() + "/");
                        break;
                     
                    case "√":
                        view.inputOutput.setText(view.inputOutput.getText() + "sqrt");
                        break;   
                    
                    case "±":
                        view.inputOutput.setText(view.inputOutput.getText() + "+-");
                        break;
                }
            });
        }
    }

    //assoccia ad ogni bottone di alterazione dello stack il suo handler
   private void initCmdStack() {
        
       for(int i=0;i<view.NUMCDMSTACKBUTTONS;i++){
            view.cmdStack[i].setOnAction(e -> handlerCmdStack(e));
       }
    }
   
    //Invia il contenuto del pulsnte premuto al modulo per far eseguire l'operazione associata
    private void handlerCmdStack(ActionEvent e) {
        Button btn = (Button) e.getSource();

        try{
            module.cmdStack(btn.getText().toLowerCase());
            
            //aggiorna i 12valori in valSalv
            numberInStack();
        }
        catch(StackIsEmptyException ex){
            String text = btn.getText();
            
            Alert errorMsg = new Alert(AlertType.ERROR);
            errorMsg.setHeaderText("Stack Vuoto");
            errorMsg.setContentText("Impossibile effettuare l'operazione di " + text +
                    "\n con lo stack vuoto");
            errorMsg.showAndWait();
        }
        catch(NotEnoughElementsException ex){
            String text = btn.getText();
            
            Alert errorMsg = new Alert(AlertType.ERROR);
            errorMsg.setHeaderText("Non Abbastanza Elementi");
            errorMsg.setContentText("Non vi sono abbastanza elementi per effettaure \n"
                    + "l'operazione di " + text);
            errorMsg.showAndWait();
        }
    }

    //associa ad ogni pulasnte aggiuntivo il suo handler
    private void initAggiuntivi() {
        /*  aggiuntivi[0]=HELP, aggiuntivi[1]= PULSANTE LETTER, 
            aggiuntivi[2]=SEND,aggiuntivi[3]=CANC , aggiuntivi[4]= ESEGUI */
        
        view.pulsantiAggiuntivi[0].setOnAction(e -> handlerHelp(e));
        view.pulsantiAggiuntivi[1].setOnAction(e -> handlerLetters(e));
        view.pulsantiAggiuntivi[2].setOnAction(e -> handlerSend(e));
        view.pulsantiAggiuntivi[3].setOnAction(e -> handlerCanc(e));
        view.pulsantiAggiuntivi[4].setOnAction(e -> handlerExecute(e));
        view.pulsantiAggiuntivi[5].setOnAction(e -> handlerDelete(e));
    }

    //Quando il pulsante HELP è premuto fa apparire a schermo un messaggio che riassume il funzionamento della tastiera
    private void handlerHelp(ActionEvent e) {
        Alert errorMsg = new Alert(AlertType.INFORMATION);
            errorMsg.setHeaderText("Informazioni sull'uso");
            errorMsg.setContentText("NUMERI\nComponi un numero complesso e premi INVIO per salvarlo nella calcolatrice."
                    + "\nPuoi inserire anche numeri reali e complessi puri.\n"
                    + " \"j\" non è un numero corretto, cosiccome \".5\" al posto di 0.5\n"
                    + "(NOTA: \"-j\" e \"+j\" non sono numeri corretti, ma operazioni sulla variabila j)\n\n"
                    
                    + "OPERAZIONI\n Salva gli operandi nella calcolatrice, poi premi un operatore e\n schiaccia ESEGUI. "
                    + "Gli operandi veranno rimossi dalla calcolatrice e il risultato salvato.\n\n"
                            
                    + "OPERAZIONI SU VARIABILI\nPremi il pulsante lettere per specificare una variabile.\n"
                    + "Componi un'operazione su una variabile e premi INVIO per eseguirla.\n\n"
                    + ">x: Importazione, salva nella varaibile l'ultimo numero salvato nella calcolatrice\n"
                    + "<x: Esportazione, salva il valore della variabile in calcolatrice\n"
                    + "+x: Somma di Variabile, aumenta dell'ultimo valore salvato il valore della variabile\n"
                    + "-x: Differenza di Variabile, diminuisci dell'ultimo valore salvato il valore della variabile\n\n"
            
                    + "ALTERAZIONE DELLO STACK\n"
                    + "clear: svuota la calcolatrice\n"
                    + "drop: cancella l'ultimo valore salvato dalla calcolatrice\n"
                    + "dup: salva nella calcolatrice una copia delll'ultimo valore salvato\n"
                    + "swap: inverte di posizione gli ultimi due valore salvati\n"
                    + "over: inserisce una copia del penultimo valore salvato in calcolatrice."
            );
            errorMsg.showAndWait();
    }

    //Quando il pulsante Lettere è premuto fa apparire a schermo una LetterView 
    //per l'inserimento di un carattere. Viene effettuato un controllo sul carattere affinché sia una lettera minuscola
    //questa è aggiunta alla label inputOutput
    private void handlerLetters(ActionEvent e) {
        //Apre finestra LetterView----------
        Stage letterWindow = new Stage();
        LetterView GUILetter = new LetterView();
        GUILetter.setAlignment(Pos.CENTER);
        
        letterWindow.setTitle("Lettera gruppo23");
        letterWindow.setMinWidth(500);
        letterWindow.setMaxWidth(800);
        letterWindow.setMinHeight(350);
        letterWindow.setMaxHeight(400);
        
        Scene scene = new Scene(GUILetter, 300, 250);
        scene.setFill(Color.GRAY);
        letterWindow.setScene(scene);
        letterWindow.show();
        //---------------------------------
        
        //Associa azione alla pigiatura di un pulsante
        for(int i=0;i<GUILetter.NUMLETTERS;i++){
            GUILetter.letters[i].setOnAction(ev -> handlerLetterButtons(ev, letterWindow));
       }
        
    }
    
    //appena si preme un pulsante di LetterView, la lettera va aggiunta a inputOutput 
    //subito dopo letterView chiusa
    private void handlerLetterButtons(ActionEvent e, Stage stage){
        Button btn = (Button) e.getSource();
        char text = btn.getText().charAt(0);
        int asciiCode = (int) text;
        
        //se è maiuscola, converti la lettera in minuscola
        if(asciiCode >=65 && asciiCode<=90){
            text=toLowerCase(text);
            asciiCode = (int) text;
        }
        
        //se è una lettera minuscola aggiungila a inputOutput, altrimenti dai errore
        if(asciiCode >=97 && asciiCode <= 122){
            view.inputOutput.setText(view.inputOutput.getText() + text);
        }
        else{
            Alert errorMsg = new Alert(AlertType.ERROR);
            errorMsg.setHeaderText("Input Non Valido");
            errorMsg.setContentText(text + " non è una variabile valida.\n"
                    + "Puoi usare solo lettere latine come input.");
            errorMsg.showAndWait();
        }
        
        //chiusura finestra
        stage.close();
    }

    //Al premere del tasto SEND, invia il contentuo della label inputOutput al modulo per il controllo dell'input
    private void handlerSend(ActionEvent e) {
        try {
            
             //controllo se input vuoto
             if(view.inputOutput.getText().equals("")){
              Alert errorMsg = new Alert(AlertType.ERROR);
                errorMsg.setHeaderText("Input Non Valido");
                errorMsg.setContentText("Inserisci un valore da inviare.");
                errorMsg.showAndWait();
            }
             else{
                 module.inputControl(view.inputOutput.getText());
                //aggiorna i numeri in valSalvati
                numberInStack();
            
                 //svuota inputOutput per dare feedback ad utente che numero è stato inserito/operazione su variabile svolta
                view.inputOutput.setText("");
             
             }
            
        } //lancia messaggio di errore in caso in cui l'input non sia valido
        catch (WrongInputException ex) {
            String text =view.inputOutput.getText();
            
            Alert errorMsg = new Alert(AlertType.ERROR);
            errorMsg.setHeaderText("Input Non Valido");
            errorMsg.setContentText(text + " non è un numero complesso valido o\n"
                    + "un'operazione su variabile valida");
            errorMsg.showAndWait();
        }
        catch(VariableNotInitializedException ex){
            String text =view.inputOutput.getText();
            
            Alert errorMsg = new Alert(AlertType.ERROR);
            errorMsg.setHeaderText("Variaibile non Inizializzata");
            errorMsg.setContentText("La variabile " + text.charAt(1) + " non è stata inizializzata");
            errorMsg.showAndWait();
        }
        catch(StackIsEmptyException ex){
            Alert errorMsg = new Alert(AlertType.ERROR);
            errorMsg.setHeaderText("Stack vuoto");
            errorMsg.setContentText("L'operazione richiesta richiede almeno un valore nello stack");
            errorMsg.showAndWait();
        }
    }

    //Al premete del tasto CANC è rimosso l'ultimo carattere della label inputOutput
    private void handlerCanc(ActionEvent e) {
        String text = view.inputOutput.getText();
        if(! text.equals("")){
            view.inputOutput.setText(text.substring(0, text.length()-1));
        }
    }

    //Al premere del pulsante ESEGUI il contenuto della label inutOutput è inviato al modulo
    //che restituirà il risultato dell'operazione eseguita
    //il risultato va mostranto nella label inputOutput
    private void handlerExecute(ActionEvent e) {
        try{
            
            //controllo se input vuoto
             if(view.inputOutput.getText().equals("")){
              Alert errorMsg = new Alert(AlertType.ERROR);
                errorMsg.setHeaderText("Nessun Operatore Inserito");
                errorMsg.setContentText("Richiedi un'operazione.");
                errorMsg.showAndWait();
            }
             else{
                NumeroComplesso result = module.execute(view.inputOutput.getText());
                view.inputOutput.setText(result.toString()); //mostra risultato a schermo
            
                //aggiorna i numeri in valSalvati
                numberInStack();
             }
        }
        
        //lancia messaggio di errore in cui non è stata richiesta un'operazione supportata
        catch(OperatorNotFoundException ex){
            String text =view.inputOutput.getText();
            
            Alert errorMsg = new Alert(AlertType.ERROR);
            errorMsg.setHeaderText("Operatore Non Valido");
            errorMsg.setContentText(text + " non è un operatore valido.\nQuando premi \"=\", a schermo"
                    + " dev'esserci uno e un solo operatore valido");
            errorMsg.showAndWait();
            
        }
        
        //mostra messaggio di errore se non ci sono abbastanza operandi nello stack
        //per eseguire l'operazione
        catch(NotEnoughElementsException ex){
            String text =view.inputOutput.getText();
            int numOperandi;
            switch(text){
                //operazioni con due operatori
                case "+": case "-" : case "*": case"/":
                    numOperandi=2;
                    break;
                    
                 //operazioni con un solo operando
                default:
                    numOperandi=1;
            }
            
            
            Alert errorMsg = new Alert(AlertType.ERROR);
            errorMsg.setHeaderText("Numero Elementi non sufficiente");
            errorMsg.setContentText("Per eseguire l'operazione richiesta servono almeno " + numOperandi +
                    "\nnumeri salvati in calcolatrice.");
            errorMsg.showAndWait();
        }
        
        //Mostra messaggio errore in caso divisione per zero
        catch(DividedByZeroException ex){
            Alert errorMsg = new Alert(AlertType.ERROR);
            errorMsg.setHeaderText("Divisione per Zero");
            errorMsg.setContentText("Non è possibile dividere per zero.");
            errorMsg.showAndWait();
        }
    }

    //Aggiorna la label valSalvati per farle mostrare gli attuali numeri in cima allo stack
    private void numberInStack() {
        NumeroComplesso[] valori;
        valori = module.extractNElementFromStack(12);
        
        StringBuilder sb = new StringBuilder();
        for(int i = valori.length-1; i>=0;i--){
            sb.append(valori[i].toString()); 
            sb.append("  ");
        }
        
        view.valSalvati.setText(sb.toString());
    }

    
    //svuota la label inputOutput
    private void handlerDelete(ActionEvent e) {
        view.inputOutput.setText("");
    }
    
}
