/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ingegneria_software;

/**
 *
 * @author marco
 */
  /*Questa classe fornisce operazioni di manopolazione su una struttura dati di tipo stack*/
public class CmdStack <T> implements OperazioniStack {
    private Stack<T> stack;
    
    public CmdStack(Stack<T> stack) {
        this.stack = stack;
    }
   
    @Override
    public void stackClear() {
        /*questo metodo cancella tutti gli elementi dallo stack*/
        while(!stack.isEmpty()){
            stack.pop();
        }
    }

    @Override
    public void stackDrop() {
        /*questo metodo cancella l'ultimo elemento presente nello stack*/
        if(stack.isEmpty()){
            throw new StackIsEmptyException("Impossibile effettuare operazione drop su stack vuoto");
        }
        stack.pop();
        
    }

    @Override
    public void stackDup() {
        /*Questo metodo inserisce nello stack una copia dell'ultimo elemento*/
        if(stack.isEmpty()){
            throw new StackIsEmptyException("Impossibile effettuare operazione dup su stack vuoto");
        }
        
        T last= stack.top();
        stack.push(last);       
    }

    @Override
    public void stackSwap() {
        /*Questo metodo scambia di posto gli ultimi due elementi presenti
        nello stack*/
        if(stack.isEmpty()){
            throw new StackIsEmptyException("Impossibile effettuare operazione swap su stack vuoto");
        }
        
        if(stack.getNumElementi()==1){
            throw new NotEnoughElementException("Impossibile effettuare operazione dup su uno stack con un elemento ");
        }
        //estraggo i due elementi
        T last = stack.pop();
        T nextLast= stack.pop();
        //li inserisco in ordine inverso
        stack.push(last);
        stack.push(nextLast);
    
    }

    @Override
    public void stackOver() {
        /*Questo metodo inserisce nello stack una copia del penultimo elemento*/
        if(stack.isEmpty()){
            throw new StackIsEmptyException("Impossibile effettuare operazione over su stack vuoto");
        }
        
        if(stack.getNumElementi()==1){
            throw new NotEnoughElementException("Impossibile effettuare operazione over su uno stack con un elemento ");
        }
        //estraggo l'ultimo elemento e copio il penultimo elemento
        T last = stack.pop();
        T nextLast= stack.top();
        //inserisco l'ultimo elemento e una copia del penultimo elemento
        stack.push(last);
        stack.push(nextLast);
    }
    
}
