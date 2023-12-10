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
    public void stackClear()  throws StackIsEmptyException{
        /*questo metodo cancella tutti gli elementi dallo stack*/
        while(!stack.isEmpty()){
            stack.pop();
        }
    }

    @Override
    public void stackDrop() throws StackIsEmptyException{
        /*questo metodo cancella l'ultimo elemento presente nello stack*/
        if(stack.isEmpty()){
            throw new StackIsEmptyException("Impossibile effettuare operazione drop su stack vuoto");
        }
        stack.pop();
        
    }

    @Override
    public void stackDup() throws StackIsEmptyException{
        /*Questo metodo inserisce nello stack una copia dell'ultimo elemento*/
        if(stack.isEmpty()){
            throw new StackIsEmptyException("Impossibile effettuare operazione dup su stack vuoto");
        }
        
        T last= stack.top();
        stack.push(last);       
    }

    @Override
     /*Questo metodo scambia di posto i due elementi in cima
        allo stack*/
    public void stackSwap() throws NotEnoughElementException, StackIsEmptyException{ 
        if(stack.getNumElementi()<2){
            throw new NotEnoughElementException("Sono presenti meno di due elementi nello stack. Impossibile effettuare lo swap");
        }
        //estraggo i due elementi
        T last = stack.pop();
        T nextLast= stack.pop();
        //li inserisco in ordine inverso
        stack.push(last);
        stack.push(nextLast);
    
    }

    @Override
    public void stackOver() throws NotEnoughElementException, StackIsEmptyException{
        /*Questo metodo inserisce nello stack una copia del penultimo elemento*/
        if(stack.getNumElementi()<2){
            throw new NotEnoughElementException("Sono presenti meno di due elementi nello stack. Impossibile effettuare l'over");
        }
        //estraggo l'ultimo elemento e copio il penultimo elemento
        T last = stack.pop();
        T nextLast= stack.top();
        //inserisco l'ultimo elemento e una copia del penultimo elemento
        stack.push(last);
        stack.push(nextLast);
    }
    
}
