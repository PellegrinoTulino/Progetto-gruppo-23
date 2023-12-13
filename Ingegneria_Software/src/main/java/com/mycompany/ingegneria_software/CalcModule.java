/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ingegneria_software;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author ANDREA
 */
public class CalcModule {
    private Stack<NumeroComplesso> stack;
    private OperazioniStack cmdStack;
    
    private Operazioni operazione;
    private Variabili var;
    
    
    public CalcModule(){
        stack = new Stack();
        cmdStack = new CmdStack<>(stack);
        
        operazione = new OperazioniBasilari();
        var= new Variabili();
    }
    
    /*ricevuto un input dal controller. 
        Verifica se è un numero corretto chiama SaveInStack()
        Altrimenti verifica se sia un'operazione su variabile corretta e chiama OperationOnVariable
        Altrimenti lancia WrognINputException
     */       
    public void  inputControl(String input) throws WrongInputException, VariableNotInitializedException, StackIsEmptyException{
    
        //Numero sintaticamente corretto-------------------------------
        /* esempi di numeri corretti:
            -3.555-j  3+2.5j   -1j    1j  0   +4   4+2j
            0.5         0.5+0.2j
           esempi sbagliati
            .5  0.j  0.9j  -j  +j  (questi ultimi sono operazioni sulla variabile j)
        */
        //numero corretto con parte reale e immaginaria
        if(input.matches("^[\\+\\-]?\\d+(\\.?\\d+)?[\\+\\-]{1}\\d+(\\.?\\d+)?[j]{1}$")){
            //rimuovi "j" dalla stringa
            input = input.substring(0,input.length()-1);
            
            //levo l'eventuale segno (primo carattere) dalla parte reale
            //verificando se è positiva onegativa
            boolean negative=false;
            
            if(input.charAt(0)=='+')
                input = input.substring(1);
            else if(input.charAt(0)=='-'){
                input = input.substring(1);
                negative=true;
            }
            
            //effettuo lo split con delineatore +. se non effettua divisioni
            //allora la parte immaginaria è negativa  (2+2j  -> 2 2j  |  2-2j  ->  2-2j)
            String[] numbers = input.split("\\+");
            if(numbers.length==2){ //parte immmaginaria positiva 
                
                //converti da stringhe a numeri
                double real = Double.parseDouble(numbers[0]);
                if(negative)
                    real *=-1;
                
                double imm = Double.parseDouble(numbers[1]);
                
                //creazione e salvataggio numero complesso
                saveInStack(new NumeroComplesso(real,imm)); 
            }
            else{   //parte immaginaria negativa
                numbers = input.split("-"); // separo parte reale e immaginari
            
                //converti da stringhe a numeri
                double real = Double.parseDouble(numbers[0]);
                if(negative)
                    real *=-1;
                
                double imm = Double.parseDouble(numbers[1]) * (-1);
                
                //creazione e salvataggio numero complesso
                saveInStack(new NumeroComplesso(real,imm));
            }
        }
        //numero corretto senza perte reale
        //può anche essere solo j o -j
        else if(input.matches("^[\\+\\-]?\\d+(\\.?\\d+)?[j]{1}$")){
            //salva nello stack un numero complesso con parte reale nulla e parte immaginaria uguale a input tolto l'ultimo carattere(j)
            saveInStack(new NumeroComplesso(0, Double.parseDouble(input.substring(0, input.length()-1))));
        }
        //numero corretto senza perte immaginaria
        else if(input.matches("^[\\+\\-]?\\d+(\\.?\\d+)?$")){
            //salva nello stack un numero complesso con parte uguale a input e parte immaginaria nulla
            saveInStack(new NumeroComplesso(Double.parseDouble(input), 0));
        }
        
        //opera variabile su variabile sintattivamente corretta
        /*
        esempi:
          >x  <x   +x  -x     con x lettera minuscola qualsiasi
        */
        else if(input.matches("^[\\+\\-<>]{1}[a-z]{1}$")){
                //il primo carattere di input indica l'operazione, il secondo la variabile
                operationOnVariable(input.charAt(0), input.charAt(1));
            }
        
        else{
            //input errato
             throw new WrongInputException("Input non valido");
        }
        
    }
    
    //Salva un numero complesso nello stack
    private void saveInStack(NumeroComplesso num){
        stack.push(num);
    }
    
    //ricevuto un operatore, ne esegue l'operazione associata estraendo gli operandi dallo stack
    public NumeroComplesso execute(String operator) throws OperatorNotFoundException, NotEnoughElementsException, DividedByZeroException{
        NumeroComplesso result;
        //Vedo se operatore è unario o binario
        
        //binario
        if (operator.equals("+") | operator.equals("-") | operator.equals("*")| operator.equals("/")){
            //controlla numero operandi
            if(stack.getNumElementi() <2)
                throw new NotEnoughElementsException("Numero operandi insufficiente");
            
            //prelievo operandi
            NumeroComplesso num1 = stack.pop();
            NumeroComplesso num2 = stack.pop();
            
            //effettua operazione
            switch (operator) {
                case "+":
                    result=operazione.somma(num1,num2);
                    break;
                case "-":
                    result=operazione.differenza(num2,num1);
                    break;
                case "*":
                    result=operazione.prodotto(num1, num2);
                    break;
                default:
                    //divisione
                    try{
                        result=operazione.divisione(num2, num1);
                    }
                    catch(DividedByZeroException ex){   //divisione per zero
                        //reinserisci gli operandi nello stack
                        saveInStack(num2);
                        saveInStack(num1);
                        
                        //rilancia eccezione per il controller
                        throw ex;
                    }   break;
            }
            //salva risultato in stack
            saveInStack(result);
        
            return result;
        }
        
        
        //unario
        else if (operator.equals("sqrt") | operator.equals("+-")){
            //controlla numero operandi
            if(stack.getNumElementi() <1)
                throw new NotEnoughElementsException("Numero operandi insufficiente");
        
            //prelievo operando
            NumeroComplesso num = stack.pop();
            
            //effettua operazione
            if(operator.equals("sqrt"))
                    result=operazione.radiceQuadrata(num);
            else
                    result=operazione.invertSign(num);
            
            //salva risultato in stack
            saveInStack(result);
        
            return result;
        }
        
        
        //operatore non esistente
        else
            throw new OperatorNotFoundException("L'operatore usato non esiste");
    }
    
    //Data una lettere minuscola rapresentate una variabile e un carattere
    //che rappresenta un'operazione su variabile, ne esegue l'operazione associata
    private void operationOnVariable(char operator, char variable){
        switch(operator){    //l'operazione è definita dal primo carattere di input
                                            //il secondo carattere di input è la variabile
                    case '+':   //somma di variabile: aumenta il valore della variabile di un valore preso dallo stack
                        var.sommaVar(variable, stack.top());
                        break;
                    case '-':   //differenza di variabile: diminuisce il valore della variabile di un valore preso dallo stack
                        var.diffVar(variable, stack.top());
                        break;
                    case '>':  //importazione, salva un valore dallo stack nella variabile 
                        var.setVar(variable, stack.top());
                        break;
                    case '<':  //esportazione, salva il valore della variabile nello stack  
                        saveInStack(var.getVar(variable));
                        break;
                }
    }
    
    //riceve una stringa rappresentate un comando di alterazione sullo stack da eseguire
    public void cmdStack(String cmd) throws StackIsEmptyException, NotEnoughElementsException{
        switch(cmd){
            case "clear":
                cmdStack.stackClear();
                break;
            case "dup": 
                cmdStack.stackDup();
                break;
            case "drop":
                cmdStack.stackDrop();
                break;
            case "swap":
                cmdStack.stackSwap();
                break;
            case "over":
                cmdStack.stackOver();
                break;
        
        }
    
    }
    
    //dato N, estrae al massimo N elementi dallo stack (fermandosi se è vuoto)
    //e restituendoli in un array
    public NumeroComplesso[] extractNElementFromStack(int N){
        //lunghezza finale array sconosciuta -> uso lista
        List<NumeroComplesso> valori = new LinkedList();
        
        //estraggo numeri da stack per riempire lista
        int i=0;
        while(!stack.isEmpty() & i<N){
            valori.add(stack.pop());
            i++;
        } 
        
        //reinserimento valori nello stack, rispettando il loro ordine precedente
        for (i = valori.size(); i-- > 0; ) {
            saveInStack(valori.get(i));
        }
        
        
        //converto lista in array e consegno
        NumeroComplesso[] num = valori.toArray(new NumeroComplesso[0]);
        return num;
    }
    
}
