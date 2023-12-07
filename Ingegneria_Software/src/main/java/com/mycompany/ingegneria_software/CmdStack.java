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
public class CmdStack implements OperazioniStack {
    private Stack stack;
    
    public CmdStack(Stack stack) {
        this.stack = stack;
    }
   
    @Override
    public void stackClear() {
        Deque<NumeroComplesso> s;
        s= stack.getStack();
        if(!s.isEmpty()){
            s.clear();
            stack.setNumElementi(0);
        }
    }

    @Override
    public void stackDrop() {
        if(stack.isEmpty()){
            throw new StackIsEmptyException("Impossibile effettuare operazione drop su stack vuoto");
        }
        NumeroComplesso n= stack.pop();
        
    }

    @Override
    public void stackDup() {
        if(stack.isEmpty()){
            throw new StackIsEmptyException("Impossibile effettuare operazione dup su stack vuoto");
        }
        
        NumeroComplesso last= stack.top();
        stack.push(last);       
    }

    @Override
    public void stackSwap() {
        if(stack.isEmpty()){
            throw new StackIsEmptyException("Impossibile effettuare operazione swap su stack vuoto");
        }
        
        if(stack.getNumElementi()==1){
            throw new NotEnoughElementException("Impossibile effettuare operazione dup su uno stack con un elemento ");
        }
        
        NumeroComplesso last = stack.pop();
        NumeroComplesso nextLast= stack.pop();
        stack.push(last);
        stack.push(nextLast);
    
    }

    @Override
    public void stackOver() {
        if(stack.isEmpty()){
            throw new StackIsEmptyException("Impossibile effettuare operazione over su stack vuoto");
        }
        
        if(stack.getNumElementi()==1){
            throw new NotEnoughElementException("Impossibile effettuare operazione over su uno stack con un elemento ");
        }
        NumeroComplesso last = stack.pop();
        NumeroComplesso nextLast= stack.pop();
        stack.push(nextLast);
        stack.push(last);
        stack.push(nextLast);
    }
    
}
