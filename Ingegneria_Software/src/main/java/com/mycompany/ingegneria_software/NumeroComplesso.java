/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ingegneria_software;
import static java.lang.Math.atan;
import static java.lang.Math.pow;
import static java.lang.Math.PI;
import static java.lang.Math.sqrt;

/**
 *
 * @author marco
 */
  /*Questa classe rappresenta l'entità di un Numero Complesso*/
public class NumeroComplesso {
    
    private double realPart; //indica parte reale di un numero complesso
    private double imPart; //indica parte immaginaria di un numero complesso
    
    public NumeroComplesso(double realPart, double imPart){
        this.realPart=realPart;
        this.imPart=imPart;
    }

    public double getRealPart() {
        return realPart;
    }

    public double getImPart() {
        return imPart;
    }

    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    public void setImPart(double imPart) {
        this.imPart = imPart;
    }

    public double module(){
        /*Questo metodo calcola il modulo di un numero complesso*/
        return (double)sqrt((double)pow(realPart,2) + (double)pow(imPart,2));
    }
    
    public double phase() throws PhaseOfZeroException{
        /*Questo metodo calcola la fase di un numero complesso per tutti i casi possibili*/
        
        //Caso in cui sia parte reale che parte immaginaria sono nulle
        if((realPart==0.0d) && (imPart==0.0d)){
            throw new PhaseOfZeroException("Fase del numero complesso 0+0i non definita");
        }
        
        //Caso in cui la parte reale è nulla
        if(realPart==0.0d){
            return (imPart > 0.0d) ? (double) PI/2.0d : (double) -PI/2.0d;
        }
        
        //La parte reale non è nulla --> Caso in cui la parte reale è positiva
        else if(realPart > 0.0d){
            return atan((double)(imPart/realPart));
        }
        //la parte reale è negativa
        //caso in cui la parte reale è negativa e la parte immaginaria è positiva o nulla
        else if (imPart >= 0.0d)
            return (PI + atan((double)(imPart/realPart)));
        
        //caso in cui la parte reale è negativa e la parte immaginaria è negativa
        return (atan((double)(imPart/realPart)) - PI);
    }
    
    @Override
    public String toString() {
        /*Questo metodo calcola il formato stringa del numero complesso (a+ib)*/
        
        //controllo se sono nulle sia parte reale che parte immaginaria
        if((realPart==0.0d) && (imPart==0.0d))
            return Double.toString(0.0d);
        
        //caso in cui la parte immaginaria è nulla
        if (imPart==0.0d) return Double.toString(realPart);
        
        //caso in cui la parte reale è nulla
        if(realPart==0.0d){
            if(imPart == 1.0d) return "j" ;
            if(imPart == -1.0d) return "-j";
            return Double.toString(imPart) + "j";
        }
        
        //parte immaginaria positiva
        if(imPart>0.0d)
            return (imPart == 1.0d) ? Double.toString(realPart) + "+" + "j" : 
                    Double.toString(realPart) + "+" + Double.toString(imPart) + "j";
        
        //parte immaginaria negativa
        else
            return (imPart == -1.0d)? Double.toString(realPart) + "-" + "j" : 
                    Double.toString(realPart) + Double.toString(imPart)+ 'j';
        
    }
}
