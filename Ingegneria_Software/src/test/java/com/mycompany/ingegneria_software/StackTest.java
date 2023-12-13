
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ingegneria_software;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author marco
 */
public class StackTest {
    Stack<NumeroComplesso> s;
    public StackTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        s=new Stack<NumeroComplesso>();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getNumElementi method, of class Stack.
     */
    @Test
    public void testGetNumElementi1() throws StackIsEmptyException {
        System.out.println("Test getNumElementi su stack vuoto");
        assertEquals(0,s.getNumElementi());
    }
    @Test
    public void testGetNumElementi2() throws StackIsEmptyException {
        System.out.println("Test getNumElementi dopo 3 aggiunte");
        s.push(new NumeroComplesso(1.0,1.0));
        s.push(new NumeroComplesso(8.6,5.8));
        s.push(new NumeroComplesso(9.3,2.9));
        assertEquals(3,s.getNumElementi());  
    }
    @Test
    public void testGetNumElementi3() throws StackIsEmptyException {
        System.out.println("Test getNumeroElementi dopo 3 aggiunte e 1 rimozione");
        s.push(new NumeroComplesso(1.0,1.0));
        s.push(new NumeroComplesso(8.6,5.8));
        s.push(new NumeroComplesso(9.3,2.9));
        s.pop();
        assertEquals(2,s.getNumElementi());  
    }   
    /**
     * Test of push method, of class Stack.
     */
    @Test
    public void testPush() throws StackIsEmptyException {
        System.out.println("Test operazione push");
        s.push(new NumeroComplesso(1.0,1.0));
        assertEquals(1.0, s.top().getRealPart());
        assertEquals(1.0, s.top().getImPart());
    }

    /**
     * Test of pop method, of class Stack.
     */
    @Test
    public void testPop1() throws StackIsEmptyException  {
        System.out.println("Test operazione pop su stack vuoto");
        StackIsEmptyException ex = assertThrows(StackIsEmptyException.class, () -> s.pop());
        assertEquals("Impossibile eseguire una pop su stack vuoto", ex.getMessage());        
    }
    
    @Test
    public void testPop2() throws StackIsEmptyException  {
        System.out.println("Test operazione pop su stack non vuoto");
        s.push(new NumeroComplesso(8.6,5.8));
        s.push(new NumeroComplesso(9.3,2.9));
        NumeroComplesso num= s.pop();
        assertEquals(9.3, num.getRealPart());
        assertEquals(2.9, num.getImPart());        
    }

    /**
     * Test of top method, of class Stack.
     */
    @Test
    public void testTop1() throws StackIsEmptyException {
        System.out.println("Test operazione top su stack vuoto");
        StackIsEmptyException ex = assertThrows(StackIsEmptyException.class, () -> s.top());
        assertEquals("Impossibile eseguire una top su stack vuoto", ex.getMessage());        
    }
    
    @Test
    public void testTop2() throws StackIsEmptyException {
        System.out.println("Test operazione top su stack non vuoto");
        s.push(new NumeroComplesso(2.0,6.0));
        assertEquals(2.0, s.top().getRealPart());
        assertEquals(6.0, s.top().getImPart());        
    }

    /**
     * Test of isEmpty method, of class Stack.
     */
    @Test
    public void testIsEmpty1() {
        System.out.println("Test metodo isEmpty su stack vuoto");
        assertEquals(true,s.isEmpty());
        

    }
    
    @Test
    public void testIsEmpty2() {
        System.out.println("Test metodo isEmpty su stack non vuoto");
        s.push(new NumeroComplesso(0.4,3.5));
        s.push(new NumeroComplesso(1.4,7.8));
        assertEquals(false,s.isEmpty());        
    }
    
}
