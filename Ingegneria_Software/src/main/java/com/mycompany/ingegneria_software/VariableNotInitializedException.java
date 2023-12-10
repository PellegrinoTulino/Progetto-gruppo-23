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
public class VariableNotInitializedException  extends VariableException{

    /**
     * Creates a new instance of <code>VariableNotInitializedException</code>
     * without detail message.
     */
    public VariableNotInitializedException() {
    }

    /**
     * Constructs an instance of <code>VariableNotInitializedException</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public VariableNotInitializedException(String msg) {
        super(msg);
    }
}
