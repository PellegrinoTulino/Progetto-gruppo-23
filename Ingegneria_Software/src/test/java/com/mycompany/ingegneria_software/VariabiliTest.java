package com.mycompany.ingegneria_software;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author spaol
 */
public class VariabiliTest {
    Variabili v;
    
    public VariabiliTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        v=new Variabili();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getVar method, of class Variabili.
     */
   

@Test
public void testgetVar1()throws VariableNotInitializedException{
    System.out.println("test su getVar con variabile non inizializzata");
    Variabili v= new Variabili();
     VariableNotInitializedException ex = assertThrows(VariableNotInitializedException.class, () -> v.getVar('x'));
     assertEquals("La variabile x non è stata inizializzata",ex.getMessage());
}

@Test

public void testgetVar2() throws VariableNotInitializedException{
    System.out.println("test su getVar");
    Variabili v= new Variabili();
    NumeroComplesso num= new NumeroComplesso (3.0,3.0);
    v.setVar('d',num );
    assertEquals(num,v.getVar('d'));
    
    
}

@Test
public void testSetvar()throws VariableNotInitializedException{
    System.out.println("test su setVar");
    Variabili v= new Variabili();
    NumeroComplesso num= new NumeroComplesso(1.0,4.0);
    v.setVar('b', num);
    assertEquals(num,v.getVar('b'));
    
}
   
    @Test
    public void testsommaVar() throws VariableNotInitializedException{
        System.out.println("test somma tra variabile e nummero complesso");
        
        NumeroComplesso num= new NumeroComplesso(1.0,2.0);
        NumeroComplesso num2= new NumeroComplesso(1.0,10.3);
        NumeroComplesso sum= new NumeroComplesso(2.0,12.3);
        
        v.setVar('a', num);
        v.sommaVar('a',num2);
        assertEquals(sum.getRealPart(),v.getVar('a').getRealPart());
        assertEquals(sum.getImPart(),v.getVar('a').getImPart());
    }
    
    @Test
    public void testsommaVarNonIniz() throws VariableNotInitializedException{
        System.out.println("test sulla somma tra variabile e numero complesso con variabile non inizializzata");
        
        NumeroComplesso num= new NumeroComplesso(2,2);
         VariableNotInitializedException ex = assertThrows(VariableNotInitializedException.class, () -> v.sommaVar('x',num));
        assertEquals("La variabile x non è stata inizializzata, impossibile efetturne la somma",ex.getMessage());
    }
    
    @Test
    public void testdiffVar() throws VariableNotInitializedException{
        System.out.println("test differenza tra variabile e numero complesso");
        
        NumeroComplesso num1= new NumeroComplesso(5.0,5.0);
        NumeroComplesso num2 = new NumeroComplesso(2.0,2.0);
        NumeroComplesso diff= new NumeroComplesso(3.0,3.0);
        
        v.setVar('a', num1);
        v.diffVar('a', num2);
        assertEquals(diff.getRealPart(),v.getVar('a').getRealPart());
        assertEquals(diff.getImPart(),v.getVar('a').getImPart());
        
    }
    
    @Test
    public void testdiffVarNonIniz() throws VariableNotInitializedException{
        System.out.println("test differenza tra variabile e numero complesso con variabile non inizializzata");
        
        
        NumeroComplesso num= new NumeroComplesso(2,2);
        VariableNotInitializedException ex = assertThrows(VariableNotInitializedException.class, () -> v.diffVar('z',num));
        assertEquals("La variabile z non è stata inizializzata, impossibile efetturne la differenza",ex.getMessage());
    }
}