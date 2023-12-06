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
public class Stack {
    private Deque<NumeroComplesso> stack;
    private int numElementi;

    public Stack() {
        this.stack = new ArrayDeque<>();
        this.numElementi = 0;
    }

    public Deque<NumeroComplesso> getStack() {
        return stack;
    }
    
    public int getNumElementi() {
        return numElementi;
    }
    
    public void push(NumeroComplesso num){
        stack.addLast(num);
        numElementi=stack.size();
    }
    
    public NumeroComplesso pop(){
        NumeroComplesso num = stack.removeLast();
        numElementi = stack.size();
        return num;
    }
    
    public NumeroComplesso top(){
        return stack.getLast();
    }
    
    public boolean isEmpty(){
        return stack.size()==0;
    }
}
