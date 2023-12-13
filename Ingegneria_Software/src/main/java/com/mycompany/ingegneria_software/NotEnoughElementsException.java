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
public class NotEnoughElementsException extends StackException{

    /**
     * Creates a new instance of <code>NotEnoughElementException</code> without
     * detail message.
     */
    public NotEnoughElementsException() {
    }

    /**
     * Constructs an instance of <code>NotEnoughElementException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NotEnoughElementsException(String msg) {
        super(msg);
    }
}
