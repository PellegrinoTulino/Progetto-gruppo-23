/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ingegneria_software;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.lang.Math.sin;
import static java.lang.Math.cos;
/**
 *
 * @author marco
 */
public class OperazioniBasilari implements Operazioni{
    /*Questa classe fornisce i metodi per le operazioni basilari su numeri complessi*/
    
    @Override
    public NumeroComplesso somma(NumeroComplesso a, NumeroComplesso b) {
        /*questo metodo calcola la somma tra due numeri complessi con la formula
        (a+ib)+(c+id)= (a+c)+i(b+d)*/
        return new NumeroComplesso(a.getRealPart() + b.getRealPart(), a.getImPart() + b.getImPart());
    }

    @Override
    public NumeroComplesso differenza(NumeroComplesso a, NumeroComplesso b) {
        /*questo metodo calcola la differenza tra due numeri complessi con la formula
        (a+ib)-(c+id)= (a-c)+i(b-d)*/
        return new NumeroComplesso(a.getRealPart() - b.getRealPart(), a.getImPart() - b.getImPart());
    }

    @Override
    public NumeroComplesso prodotto(NumeroComplesso a, NumeroComplesso b) {
        /*questo metodo calcola il prodotto tra due numeri complessi con la formula
        (a+ib)*(c+id)= (ac - bd) + i(ad+bc)*/
        double realPart=a.getRealPart()*b.getRealPart() - a.getImPart()*b.getImPart();
        double imPart=a.getRealPart()*b.getImPart()+ a.getImPart()*b.getRealPart();
        if (realPart== -0.0d) realPart=0.0d;
        if (imPart== -0.0d) imPart=0.0d;
        return new NumeroComplesso(realPart,imPart);
    }

    /**
     *
     * @param a
     * @param b
     * @return
     * @throws DividedByZeroException
     */
    @Override
    public NumeroComplesso divisione(NumeroComplesso a, NumeroComplesso b) throws DividedByZeroException{
        /*questo metodo calcola la divisione tra due numeri complessi con la formula
        (a+ib)/(c+id)= (ac + bd)/(c^2+d^2)+ i[(bc - ad)/(c^2+d^2)]*/
        
         if((b.getRealPart()==0.0d) && (b.getImPart()==0.0d))
            throw new DividedByZeroException("Impossibile dividere per 0");
        
         double realPart= (double)((a.getRealPart()*b.getRealPart() + a.getImPart()*b.getImPart())/( (double) pow(b.getRealPart(),2) + (double) pow(b.getImPart(),2)));
         double imPart= (double)((a.getImPart()*b.getRealPart() - a.getRealPart()*b.getImPart())/( (double) pow(b.getRealPart(),2) + (double) pow(b.getImPart(),2)));
         if(realPart==-0.0d) realPart= 0.0d;
         if(imPart==-0.0d) imPart=0.0d;
         return new NumeroComplesso(realPart,imPart);
    }

    @Override
    public NumeroComplesso radiceQuadrata(NumeroComplesso a) throws PhaseOfZeroException{
        /*questo metodo calcola la radice quadrata di un numero complesso utilizzando la formula di 
        De Moivre per k=0*/
        if((a.getRealPart()==0.0d) && (a.getImPart()==0.0d)) return a;
        double module = sqrt(a.module());
        double phase = (double)(a.phase()/2.0d); // (fase di a + 2kπ)/2 
        
        if(phase==Math.PI/2 | phase==-1.0d*Math.PI/2) 
            return new NumeroComplesso(0, module*sin(phase)); //cos(PI/2) in java restituisce un valore leggermente diverso da zero
        
        return new NumeroComplesso(module*cos(phase), module*sin(phase));
    }

    @Override
    public NumeroComplesso invertSign(NumeroComplesso a) {
        /*Questo metodo inverte di segno il numero complesso che ha come parametro*/
        double real = (a.getRealPart() == 0) ? 0 : (-1* a.getRealPart());
        double imm = (a.getImPart() == 0) ? 0 : (-1* a.getImPart());
        
        return new NumeroComplesso(real, imm);
    }
    
}
