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
/*Questa interfaccia fornisce i metodi per le operazioni basilati*/
public interface Operazioni {
    public NumeroComplesso somma(NumeroComplesso a, NumeroComplesso b);
    public NumeroComplesso differenza(NumeroComplesso a, NumeroComplesso b);
    public NumeroComplesso prodotto(NumeroComplesso a, NumeroComplesso b);

    /**
     *
     * @param a
     * @param b
     * @return
     * @throws DividedByZeroException
     */
    public NumeroComplesso divisione(NumeroComplesso a, NumeroComplesso b) throws DividedByZeroException;
    public NumeroComplesso radiceQuadrata(NumeroComplesso a) throws PhaseOfZeroException;
    public NumeroComplesso invertSign(NumeroComplesso a);
}
