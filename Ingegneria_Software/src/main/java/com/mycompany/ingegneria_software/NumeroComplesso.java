/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ingegneria_software;
import java.lang.Math;
import static java.lang.Math.pow;

/**
 *
 * @author marco
 */
public class NumeroComplesso {
    
    private double realPart;
    private double imPart;
    
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
        return (double)Math.sqrt((double)pow(realPart,2) + (double)pow(imPart,2));
    }
    
    public double phase(){
        if((realPart==0.0d) && (imPart==0.0d)){
            throw new PhaseOfZeroException("Fase del numero complesso 0+0i non definita");
        }
        if((realPart==0.0d) && (imPart!=0.0d)){
            if(imPart > 0.0d) return (double) Math.PI/2.0d;
            if(imPart < 0.0d) return (double) -(Math.PI)/2.0d;
        }
        else if(realPart > 0.0d){
            return Math.atan((double)(imPart/realPart));
        }
        else if (imPart >= 0.0d)
            return (Math.PI + Math.atan((double)(imPart/realPart)));
                  
            return (Math.atan((double)(imPart/realPart)) - Math.PI);
    }
    
    @Override
    public String toString() {
        if((realPart==0.0d) && (imPart==0.0d))
            return Double.toString(0.0d);
        if ((realPart!=0.0d) && (imPart==0.0d)){
            return Double.toString(realPart);
        }
        else if((realPart==0.0d) && (imPart!=0.0d)){
            if(imPart == 1.0d) return "+i" ;
            if(imPart == -1.0d) return "-i";
            return Double.toString(imPart) + "i";
        }
        else {
            if(imPart>0.0d){
                if(imPart == 1.0d) return Double.toString(realPart) + "+i";
                return Double.toString(realPart) + "+" + Double.toString(imPart) + "i";
            }
            else
                if(imPart == -1.0d) return Double.toString(realPart) + "-i";
                return Double.toString(realPart) + Double.toString(imPart)+ 'i';
        }
    }
    
    
    
}
