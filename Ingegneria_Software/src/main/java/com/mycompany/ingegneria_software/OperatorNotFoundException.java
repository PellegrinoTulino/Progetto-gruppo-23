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
public class OperatorNotFoundException extends OperationException{

    /**
     * Creates a new instance of <code>OperatorNotFoundException</code> without
     * detail message.
     */
    public OperatorNotFoundException() {
    }

    /**
     * Constructs an instance of <code>OperatorNotFoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public OperatorNotFoundException(String msg) {
        super(msg);
    }
}
