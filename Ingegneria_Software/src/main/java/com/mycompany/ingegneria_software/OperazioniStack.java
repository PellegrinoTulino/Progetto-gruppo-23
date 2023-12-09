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
public interface OperazioniStack {
    public void stackClear();
    public void stackDrop();
    public void stackDup();
    public void stackSwap();
    public void stackOver();
}
