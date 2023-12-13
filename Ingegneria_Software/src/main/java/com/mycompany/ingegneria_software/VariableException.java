/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ingegneria_software;

/**
 *
 * @author ANDREA
 */
public class VariableException extends RuntimeException{

    /**
     * Creates a new instance of <code>VariableException</code> without detail
     * message.
     */
    public VariableException() {
    }

    /**
     * Constructs an instance of <code>VariableException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public VariableException(String msg) {
        super(msg);
    }
}
