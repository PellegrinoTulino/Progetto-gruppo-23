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
public class PhaseOfZeroException extends RuntimeException {

    /**
     * Creates a new instance of <code>PhaseOfZeroException</code> without
     * detail message.
     */
    public PhaseOfZeroException() {
    }

    /**
     * Constructs an instance of <code>PhaseOfZeroException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PhaseOfZeroException(String msg) {
        super(msg);
    }
}
