/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ingegneria_software;

/**
 *
 * @author ANDREA
 */
public class Variabili {
    private NumeroComplesso[] var;
    private Operazioni operazioni;
    
    
    public Variabili(){
        var = new NumeroComplesso[26];
        operazioni = new OperazioniBasilari();
    }
    
    //riceve un carattere lettera minuscola rappresentate una variabile,
    //restituisce l'indice della variabile  nell' array di variabili
    private int getIndex(char x){
        
        //codice ASCII di "a" è 97; l'indice della variabile "a" è 0
        return (int) (x-97);
    }
    
    //data una variabile, ne restituisce il valore 
    public NumeroComplesso getVar(char x) throws VariableNotInitializedException{
        int index = getIndex(x);
        if(var[index] == null){
            throw new VariableNotInitializedException("La variabile " + x + " non è stata inizializzata");
        }
        
        return var[index];
    }
    

    public void setVar(char x, NumeroComplesso value){
        int index = getIndex(x);
        var[index] = value;
    }
    
    //data una lettera rappreentate una variabile e un valore
    //aumenta il valore di quella variabile dell valore dato
    public void sommaVar(char x, NumeroComplesso value)  throws VariableNotInitializedException{
        int index = getIndex(x);
        if(var[index] == null){
            throw new VariableNotInitializedException("La variabile " + x + " non è stata inizializzata, impossibile efetturne la somma");
        }
        var[index] = operazioni.somma(var[index],value);
    }
    
    //data una lettera rappreentate una variabile e un valore
    //diminuisce il valore di quella variabile dell valore dato
    public void diffVar(char x, NumeroComplesso value)  throws VariableNotInitializedException{
        int index = getIndex(x);
        if(var[index] == null){
            throw new VariableNotInitializedException("La variabile " + x + " non è stata inizializzata, impossibile efetturne la differenza");
        }
        var[index] = operazioni.differenza(var[index],value);
    }
}
