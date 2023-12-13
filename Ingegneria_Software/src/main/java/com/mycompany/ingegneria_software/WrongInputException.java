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
public class WrongInputException extends InputException{

    /**
     * Creates a new instance of <code>WrongInputException</code> without detail
     * message.
     */
    public WrongInputException() {
    }

    /**
     * Constructs an instance of <code>WrongInputException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public WrongInputException(String msg) {
        super(msg);
    }
}
