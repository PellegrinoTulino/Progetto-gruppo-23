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
public interface OperazioniStack {
    public void stackClear();
    public void stackDrop();
    public void stackDup();
    public void stackSwap();
    public void stackOver();
}
