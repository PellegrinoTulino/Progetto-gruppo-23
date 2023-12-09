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
public class StackException extends RuntimeException{

    /**
     * Creates a new instance of <code>StackException</code> without detail
     * message.
     */
    public StackException() {
    }

    /**
     * Constructs an instance of <code>StackException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public StackException(String msg) {
        super(msg);
    }
}
