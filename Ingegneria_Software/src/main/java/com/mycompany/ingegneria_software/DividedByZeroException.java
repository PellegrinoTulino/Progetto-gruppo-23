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
public class DividedByZeroException extends OperationException{

    /**
     * Creates a new instance of <code>DividedByZeroException</code> without
     * detail message.
     */
    public DividedByZeroException() {
    }

    /**
     * Constructs an instance of <code>DividedByZeroException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DividedByZeroException(String msg) {
        super(msg);
    }
}
