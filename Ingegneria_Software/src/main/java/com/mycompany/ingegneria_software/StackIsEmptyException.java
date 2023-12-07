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
public class StackIsEmptyException extends RuntimeException{

    /**
     * Creates a new instance of <code>StackIsEmptyException</code> without
     * detail message.
     */
    public StackIsEmptyException() {
    }

    /**
     * Constructs an instance of <code>StackIsEmptyException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public StackIsEmptyException(String msg) {
        super(msg);
    }
}
