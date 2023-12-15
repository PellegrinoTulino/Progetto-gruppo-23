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
public class InputException extends RuntimeException{

    /**
     * Creates a new instance of <code>InputException</code> without detail
     * message.
     */
    public InputException() {
    }

    /**
     * Constructs an instance of <code>InputException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public InputException(String msg) {
        super(msg);
    }
}
