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
import static java.lang.Math.PI;

/**
 *
 * @author marco
 */
public class NumeroComplessoTest {
    NumeroComplesso num;
    
    public NumeroComplessoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getRealPart method, of class NumeroComplesso.
     */
    @Test
    public void testGetRealPart() {
        System.out.println("Test getRealPart");
        num=new NumeroComplesso(3.0,5.0);
        assertEquals(3.0,num.getRealPart());
    }

    /**
     * Test of getImPart method, of class NumeroComplesso.
     */
    @Test
    public void testGetImPart() {
        System.out.println("Test getImPart");
        num=new NumeroComplesso(3.0,5.0);
        assertEquals(5.0,num.getImPart());
    }

    /**
     * Test of setRealPart method, of class NumeroComplesso.
     */
    @Test
    public void testSetRealPart() {
        System.out.println("Test setRealPart");
        num=new NumeroComplesso(0.0,0.0);
        num.setRealPart(3.0);
        assertEquals(3.0,num.getRealPart());
    }

    /**
     * Test of setImPart method, of class NumeroComplesso.
     */
    @Test
    public void testSetImPart() {
        System.out.println("Test setImPart");
        num=new NumeroComplesso(0.0,0.0);
        num.setImPart(5.0);
        assertEquals(5.0,num.getImPart());
    }

    /**
     * Test of module method, of class NumeroComplesso.
     */
    @Test
    public void testModule1() {
        System.out.println("Test Module: parte reale nulla, parte immaginaria nulla");
        num=new NumeroComplesso(0.0,0.0);
        assertEquals(0.0, num.module());
    }
    
    @Test
    public void testModule2() {
        System.out.println("Test Module: parte reale nulla, parte immaginaria negativa");
        num=new NumeroComplesso(0.0,-1.0);
        assertEquals(1.0, num.module());
    }

    @Test
    public void testModule3() {
        System.out.println("Test Module: parte reale nulla, parte immaginaria positiva");
        num=new NumeroComplesso(0.0,1.0);
        assertEquals(1.0, num.module());
    }

    @Test
    public void testModule4() {
        System.out.println("Test Module: parte reale positiva, parte immaginaria nulla");
        num=new NumeroComplesso(5.0,0.0);
        assertEquals(5.0, num.module());
    }
    
    @Test
    public void testModule5() {
        System.out.println("Test Module: parte reale positiva, parte immaginaria negativa");
        num=new NumeroComplesso(3.0, -4.0);
        assertEquals(5.0, num.module());
    } 
    
    @Test
    public void testModule6() {
        System.out.println("Test Module: parte reale positiva, parte immaginaria positiva");
        num=new NumeroComplesso(3.0, 4.0);
        assertEquals(5.0, num.module());
    }
    
    @Test
    public void testModule7() {
        System.out.println("Test Module: parte reale negativa, parte immaginaria nulla");
        num=new NumeroComplesso(-3.0, 0.0);
        assertEquals(3.0, num.module());
    } 
    
    @Test
    public void testModule8() {
        System.out.println("Test Module: parte reale negativa, parte immaginaria negativa");
        num=new NumeroComplesso(-3.0, -4.0);
        assertEquals(5.0, num.module());
    }  

    @Test
    public void testModule9() {
        System.out.println("Test Module: parte reale negativa, parte immaginaria positiva");
        num=new NumeroComplesso(-3.0, 4.0);
        assertEquals(5.0, num.module());
    }     

    /**
     * Test of phase method, of class NumeroComplesso.
     */
    @Test
    public void testPhase1() throws PhaseOfZeroException {
        System.out.println("Test Phase: parte reale nulla, parte immaginaria nulla");
        num=new NumeroComplesso(0.0,0.0);
        PhaseOfZeroException ex= assertThrows(PhaseOfZeroException.class, () -> num.phase());
        assertEquals("Fase del numero complesso 0+0i non definita", ex.getMessage());
    }
    
    @Test
    public void testPhase2() throws PhaseOfZeroException {
        System.out.println("Test Phase: parte reale positiva");
        num=new NumeroComplesso(1.0,1.0);
        assertEquals((double)PI/4.0, num.phase());
    }    
    
    @Test
    public void testPhase3() throws PhaseOfZeroException {
        System.out.println("Test Phase: parte reale negativa, parte immaginaria maggiore o uguale a zero");
        num=new NumeroComplesso(-1.0,1.0);
        assertEquals((double) 3.0*PI/4.0, num.phase());
    }   
    
    @Test
    public void testPhase4() throws PhaseOfZeroException {
        System.out.println("Test Phase: parte reale negativa, parte immaginaria negativa");
        num=new NumeroComplesso(-1.0,-1.0);
        assertEquals((double) -3.0*PI/4.0, num.phase());
    }  
    
    @Test
    public void testPhase5() throws PhaseOfZeroException {
        System.out.println("Test Phase: parte reale nulla, parte immaginaria positiva");
        num=new NumeroComplesso(0.0,1.0);
        assertEquals((double) PI/2.0, num.phase());
    } 

    @Test
    public void testPhase6() throws PhaseOfZeroException {
        System.out.println("Test Phase: parte reale nulla, parte immaginaria negativa");
        num=new NumeroComplesso(0.0,-1.0);
        assertEquals((double) -PI/2.0, num.phase());
    }     

    /**
     * Test of toString method, of class NumeroComplesso.
     */
    @Test
    public void testToString1() {
        System.out.println("Test toString: parte reale non nulla, parte immaginaria nulla");
        num=new NumeroComplesso(-3.0,0.0);
        assertEquals("-3.0",num.toString());
    }
    
    @Test
    public void testToString2() {
        System.out.println("Test toString: parte reale non nulla, parte immagianaria = -1");
        num=new NumeroComplesso(3.0,-1.0);
        assertEquals("3.0-j",num.toString());
    } 
  
    @Test
    public void testToString3() {
        System.out.println("Test toString: parte reale non nulla, parte immagianaria = 1");
        num=new NumeroComplesso(3.0,1.0);
        assertEquals("3.0+j",num.toString());
    }  

    @Test
    public void testToString4() {
        System.out.println("Test toString: parte reale non nulla, parte immagianaria positiva");
        num=new NumeroComplesso(3.0,2.0);
        assertEquals("3.0+2.0j",num.toString());
    }  

    @Test
    public void testToString5() {
        System.out.println("Test toString: parte reale non nulla, parte immagianaria negativa");
        num=new NumeroComplesso(3.0,-2.0);
        assertEquals("3.0-2.0j",num.toString());
    } 
    
    @Test
    public void testToString6() {
        System.out.println("Test toString: parte reale nulla, parte immagianaria nulla");
        num=new NumeroComplesso(0.0,0.0);
        assertEquals("0.0",num.toString());
    }    
    
    @Test
    public void testToString7() {
        System.out.println("Test toString: parte reale nulla, parte immagianaria = -1");
        num=new NumeroComplesso(0.0,-1.0);
        assertEquals("-j",num.toString());
    }  
    
    @Test
    public void testToString8() {
        System.out.println("Test toString: parte reale nulla, parte immagianaria = 1");
        num=new NumeroComplesso(0.0,1.0);
        assertEquals("j",num.toString());
    }
    
    @Test
    public void testToString9() {
        System.out.println("Test toString: parte reale nulla, parte immagianaria positiva");
        num=new NumeroComplesso(0.0,3.0);
        assertEquals("3.0j",num.toString());
    } 
    
    @Test
    public void testToString10() {
        System.out.println("Test toString: parte reale nulla, parte immagianaria negativa");
        num=new NumeroComplesso(0.0,-3.0);
        assertEquals("-3.0j",num.toString());
    }         
    
    
}
