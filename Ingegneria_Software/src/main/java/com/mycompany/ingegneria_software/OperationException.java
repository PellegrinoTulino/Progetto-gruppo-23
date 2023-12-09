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
public class OperationException extends RuntimeException{

    /**
     * Creates a new instance of <code>OperationException</code> without detail
     * message.
     */
    public OperationException() {
    }

    /**
     * Constructs an instance of <code>OperationException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public OperationException(String msg) {
        super(msg);
    }
}
