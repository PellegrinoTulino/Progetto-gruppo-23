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
/*Questa interfaccia fornisce i metodi per la manipolazione di uno stack*/
public interface OperazioniStack{
    public void stackClear()  throws StackIsEmptyException; // può lanciare eccezione di stack vuoto perché chiama stack.pop()
    public void stackDrop() throws StackIsEmptyException;
    public void stackDup()throws StackIsEmptyException;
    
    //possono lanciare eccezione di stack vuoto perché chiama stack.pop()
    public void stackSwap() throws NotEnoughElementsException, StackIsEmptyException;
    public void stackOver() throws NotEnoughElementsException, StackIsEmptyException;
}
