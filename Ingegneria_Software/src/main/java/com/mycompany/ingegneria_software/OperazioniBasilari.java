/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ingegneria_software;
import static java.lang.Math.pow;
/**
 *
 * @author marco
 */
public class OperazioniBasilari implements Operazioni{

    @Override
    public NumeroComplesso somma(NumeroComplesso a, NumeroComplesso b) {
        return new NumeroComplesso(a.getRealPart() + b.getRealPart(), a.getImPart() + b.getImPart());
    }

    @Override
    public NumeroComplesso differenza(NumeroComplesso a, NumeroComplesso b) {
        return new NumeroComplesso(a.getRealPart() - b.getRealPart(), a.getImPart() - b.getImPart());
    }

    @Override
    public NumeroComplesso prodotto(NumeroComplesso a, NumeroComplesso b) {
        return new NumeroComplesso(a.getRealPart()*b.getRealPart() - 
                a.getImPart()*b.getImPart(),a.getRealPart()*b.getImPart() + 
                        a.getImPart()*b.getRealPart());
    }

    @Override
    public NumeroComplesso divisione(NumeroComplesso a, NumeroComplesso b) {
         double realPart= (double)((a.getRealPart()*b.getRealPart() + a.getImPart()*b.getImPart())/( (double) pow(b.getRealPart(),2) + (double) pow(b.getImPart(),2)));
         double imPart= (double)((a.getImPart()*b.getRealPart() - a.getRealPart()*b.getImPart())/( (double) pow(b.getRealPart(),2) + (double) pow(b.getImPart(),2)));
         return new NumeroComplesso(realPart,imPart);
    }

    @Override
    public NumeroComplesso sqrt(NumeroComplesso a) {
        double module = Math.sqrt(a.module());
        double phase = (double)(a.phase()/2.0d);
        return new NumeroComplesso(module*Math.cos(phase), module*Math.sin(phase));
    }

    @Override
    public NumeroComplesso invertSign(NumeroComplesso a) {
        return new NumeroComplesso(-(a.getRealPart()), -(a.getImPart()));
    }
    
}
