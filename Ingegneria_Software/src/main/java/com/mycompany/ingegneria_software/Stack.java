/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ingegneria_software;

import java.util.ArrayDeque;
import java.util.Deque;
/**
 *
 * @author marco
 */
public class Stack <T> {
    /*Questa classe fornisce una struttura dati di tipo stack (LIFO),
    tramite una collezione autoridimensionabile*/
    private Deque<T> stack;
    private int numElementi; //numero elementi nello stack

    public Stack() {
        this.stack = new ArrayDeque<T>();
        this.numElementi = 0;
    }
    
    public int getNumElementi() {
        return numElementi;
    }
    
    public void push(T elem){
        /*Questo metodo aggiunge l'elemento passatogli come parametro nello stack.*/
        stack.addLast(elem); 
        numElementi=stack.size(); //aggiorno numero elementi
    }
    
    public T pop() throws StackIsEmptyException{
        /*Questo metodo estrae l'ultimo elemento presente nello stack, rimuovendolo dallo stack*/
        if(stack.isEmpty()) throw new StackIsEmptyException("Impossibile eseguire una pop su stack vuoto");
        T elem = stack.removeLast();
        numElementi = stack.size(); 
        return elem;
    }
    
    public T top() throws StackIsEmptyException{
        /*Questo metodo ritorna una copia dell'ultimo elemento presente nello stack*/
        if(stack.isEmpty()) throw new StackIsEmptyException("Impossibile eseguire una top su stack vuoto");
        return stack.getLast();
    }
    
    public boolean isEmpty(){
        /*Questo metodo restituisce true se lo stack è vuoto*/
        return numElementi==0;
    }
}
