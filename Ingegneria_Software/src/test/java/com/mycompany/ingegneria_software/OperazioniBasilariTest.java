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

import com.mycompany.ingegneria_software.DividedByZeroException;

/**
 *
 * @author ANDREA
 */
public class OperazioniBasilariTest {
    OperazioniBasilari op;
    
    public OperazioniBasilariTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        op = new OperazioniBasilari();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of somma method, of class OperazioniBasilari.
     */
    @Test
    public void testSomma1() {
        System.out.println("Test Somma parti reali nulle, parti immaginarie concordi positive");
        NumeroComplesso num= op.somma(new NumeroComplesso(0.0,3.0),new NumeroComplesso(0.0,1.0));
        assertEquals(0.0,num.getRealPart());
        assertEquals(4.0,num.getImPart());
    }
    
    @Test
    public void testSomma2() {
        System.out.println("Test Somma parti reali nulle, parti immaginarie concordi negative");
        NumeroComplesso num2= op.somma(new NumeroComplesso(0.0,-3.0),new NumeroComplesso(0.0,-1.0));
        assertEquals(0.0,num2.getRealPart());
        assertEquals(-4.0,num2.getImPart());      
    }
    @Test
    public void testSomma3() {
        System.out.println("Test Somma parti reali nulle, parti immaginarie discordi: primo positivo");
        NumeroComplesso num2= op.somma(new NumeroComplesso(0.0,3.0),new NumeroComplesso(0.0,-1.0));
        assertEquals(0.0,num2.getRealPart());
        assertEquals(2.0,num2.getImPart());          
    }
    
    @Test
    public void testSomma4() {
        System.out.println("Test Somma parti reali nulle, parti immaginarie nulle");
        NumeroComplesso num2= op.somma(new NumeroComplesso(0.0,0.0),new NumeroComplesso(0.0,0.0));
        assertEquals(0.0,num2.getRealPart());
        assertEquals(0.0,num2.getImPart()); 
    } 
    
    @Test
    public void testSomma5() {
        System.out.println("Test Somma parti reali concordi positive, parti immaginarie concordi positive");
        NumeroComplesso num2= op.somma(new NumeroComplesso(1.0,3.0),new NumeroComplesso(3.0,1.0));
        assertEquals(4.0,num2.getRealPart());
        assertEquals(4.0,num2.getImPart()); 
    }

    @Test
    public void testSomma6() {
        System.out.println("Test Somma parti reali concordi positive, parti immaginarie concordi negative");
        NumeroComplesso num2= op.somma(new NumeroComplesso(1.0,-3.0),new NumeroComplesso(3.0,-1.0));
        assertEquals(4.0,num2.getRealPart());
        assertEquals(-4.0,num2.getImPart()); 
    }

    @Test
    public void testSomma7() {
        System.out.println("Test Somma parti reali concordi positive, parti immaginarie discordi: primo positivo");
        NumeroComplesso num2= op.somma(new NumeroComplesso(1.0,3.0),new NumeroComplesso(3.0,-1.0));
        assertEquals(4.0,num2.getRealPart());
        assertEquals(2.0,num2.getImPart()); 
    }     
    
    @Test
    public void testSomma8() {
        System.out.println("Test Somma parti reali concordi positive, parti immaginarie nulle");
        NumeroComplesso num2= op.somma(new NumeroComplesso(1.0,0.0),new NumeroComplesso(3.0,0.0));
        assertEquals(4.0,num2.getRealPart());
        assertEquals(0.0,num2.getImPart()); 
    }  
   
    @Test
    public void testSomma9() {
        System.out.println("Test Somma parti reali concordi negative, parti immaginarie concordi positive");
        NumeroComplesso num2= op.somma(new NumeroComplesso(-1.0,3.0),new NumeroComplesso(-3.0,1.0));
        assertEquals(-4.0,num2.getRealPart());
        assertEquals(4.0,num2.getImPart()); 
    } 

    @Test
    public void testSomma10() {
        System.out.println("Test Somma parti reali concordi negative, parti immaginarie concordi negative");
        NumeroComplesso num2= op.somma(new NumeroComplesso(-1.0,-3.0),new NumeroComplesso(-3.0,-1.0));
        assertEquals(-4.0,num2.getRealPart());
        assertEquals(-4.0,num2.getImPart()); 
    } 

    @Test
    public void testSomma11() {
        System.out.println("Test Somma parti reali concordi negative, parti immaginarie discordi: primo positivo");
        NumeroComplesso num2= op.somma(new NumeroComplesso(-1.0,3.0),new NumeroComplesso(-3.0,-1.0));
        assertEquals(-4.0,num2.getRealPart());
        assertEquals(2.0,num2.getImPart()); 
    }     
    
@Test
    public void testSomma12() {
        System.out.println("Test Somma parti reali concordi negative, parti immaginarie nulle");
        NumeroComplesso num2= op.somma(new NumeroComplesso(-1.0,0.0),new NumeroComplesso(-3.0,0.0));
        assertEquals(-4.0,num2.getRealPart());
        assertEquals(0.0,num2.getImPart()); 
    }    
    
    @Test
    public void testSomma13() {
        System.out.println("Test Somma parti reali discordi, parti immaginarie concordi positive");
        NumeroComplesso num2= op.somma(new NumeroComplesso(-1.0,3.0),new NumeroComplesso(3.0,1.0));
        assertEquals(2.0,num2.getRealPart());
        assertEquals(4.0,num2.getImPart()); 
    }    
    
    @Test
    public void testSomma14() {
        System.out.println("Test Somma parti reali discordi, parti immaginarie concordi negative");
        NumeroComplesso num2= op.somma(new NumeroComplesso(-1.0,-3.0),new NumeroComplesso(3.0,-1.0));
        assertEquals(2.0,num2.getRealPart());
        assertEquals(-4.0,num2.getImPart()); 
    }
    
@Test
    public void testSomma15() {
        System.out.println("Test Somma parti reali discordi, parti immaginarie discordi: primo positivo");
        NumeroComplesso num2= op.somma(new NumeroComplesso(-1.0,3.0),new NumeroComplesso(3.0,-1.0));
        assertEquals(2.0,num2.getRealPart());
        assertEquals(2.0,num2.getImPart()); 
    }   
    
    @Test
    public void testSomma16() {
        System.out.println("Test Somma parti reali discordi, parti immaginarie nulle");
        NumeroComplesso num2= op.somma(new NumeroComplesso(-1.0,0.0),new NumeroComplesso(3.0,0.0));
        assertEquals(2.0,num2.getRealPart());
        assertEquals(0.0,num2.getImPart()); 
    }    
    

    /**
     * Test of differenza method, of class OperazioniBasilari.
     */
    @Test
    public void testDifferenza1() {
        System.out.println("Test Differenza parti reali nulle, parti immaginarie concordi positivi");
        NumeroComplesso num= op.differenza(new NumeroComplesso(0.0,8.0),new NumeroComplesso(0.0,5.0));
        assertEquals(0.0,num.getRealPart());
        assertEquals(3.0,num.getImPart());       
    }
    @Test
    public void testDifferenza2() {
        System.out.println("Test Differenza parti reali nulle, parti immaginarie concordi negativi");
        NumeroComplesso num= op.differenza(new NumeroComplesso(0.0,-5.0),new NumeroComplesso(0.0,-4.0));
        assertEquals(0.0,num.getRealPart());
        assertEquals(-1.0,num.getImPart()); 
    }     

    @Test
    public void testDifferenza3() {
        System.out.println("Test Differenza parti reali nulle, parti immaginarie discordi: primo positivo"); 
        NumeroComplesso num= op.differenza(new NumeroComplesso(0.0,8.0),new NumeroComplesso(0.0,-5.0));
        assertEquals(0.0,num.getRealPart());
        assertEquals(13.0,num.getImPart());        
    }       
    
    @Test
    public void testDifferenza4() {
        System.out.println("Test Differenza parti reali nulle, parti immaginarie nulle");
        NumeroComplesso num= op.differenza(new NumeroComplesso(0.0,0.0),new NumeroComplesso(0.0,0.0));
        assertEquals(0.0,num.getRealPart());
        assertEquals(0.0,num.getImPart());         
    }     
    
    @Test
    public void testDifferenza5() {
        System.out.println("Test Differenza parti reali discordi, parti immaginarie nulle");
        NumeroComplesso num= op.differenza(new NumeroComplesso(3.0,0.0),new NumeroComplesso(-1.0,0.0));
        assertEquals(4.0,num.getRealPart());
        assertEquals(0.0,num.getImPart());
    }    
    
    @Test
    public void testDifferenza6() {
        System.out.println("Test Differenza parti reali discordi, parti immaginarie concordi positive");
        NumeroComplesso num= op.differenza(new NumeroComplesso(-3.0,1.0),new NumeroComplesso(1.0,1.0));
        assertEquals(-4.0,num.getRealPart());
        assertEquals(0.0,num.getImPart());  
    }    
    
    @Test
    public void testDifferenza7() {
        System.out.println("Test Differenza parti reali discordi, parti immaginarie concordi negative");
        NumeroComplesso num= op.differenza(new NumeroComplesso(-3.0,-1.0),new NumeroComplesso(1.0,-1.0));
        assertEquals(-4.0,num.getRealPart());
        assertEquals(0.0,num.getImPart());  
    }
    
    @Test
    public void testDifferenza8() {
        System.out.println("Test Differenza parti reali discordi, parti immaginarie discordi");
        NumeroComplesso num= op.differenza(new NumeroComplesso(2.0,1.0),new NumeroComplesso(-6.0,-7.0));
        assertEquals(8.0,num.getRealPart());
        assertEquals(8.0,num.getImPart());   
    }
    
    @Test
    public void testDifferenza9() {
        System.out.println("Test Differenza parti reali concordi positive, parti immaginarie concordi positive");
        NumeroComplesso num= op.differenza(new NumeroComplesso(2.0,1.0),new NumeroComplesso(6.0,7.0));
        assertEquals(-4.0,num.getRealPart());
        assertEquals(-6.0,num.getImPart());    
    } 
    
    @Test
    public void testDifferenza10() {
        System.out.println("Test Differenza parti reali concordi positive, parti immaginarie concordi negative");
        NumeroComplesso num= op.differenza(new NumeroComplesso(2.0,-1.0),new NumeroComplesso(6.0,-7.0));
        assertEquals(-4.0,num.getRealPart());
        assertEquals(6.0,num.getImPart());    
    }   
    
    @Test
    public void testDifferenza11() {
        System.out.println("Test Differenza parti reali concordi positive, parti immaginarie discordi: primo positivo");
        NumeroComplesso num= op.differenza(new NumeroComplesso(2.0,1.0),new NumeroComplesso(6.0,-7.0));
        assertEquals(-4.0,num.getRealPart());
        assertEquals(8.0,num.getImPart());    
    }   
    
    @Test
    public void testDifferenza12() {
        System.out.println("Test Differenza parti reali concordi positive, parti immaginarie nulle");
        NumeroComplesso num= op.differenza(new NumeroComplesso(2.0,0.0),new NumeroComplesso(6.0,0.0));
        assertEquals(-4.0,num.getRealPart());
        assertEquals(0.0,num.getImPart());    
    } 
    
    @Test
    public void testDifferenza13() {
        System.out.println("Test Differenza parti reali concordi negative, parti immaginarie concordi positive");
        NumeroComplesso num= op.differenza(new NumeroComplesso(-2.0,1.0),new NumeroComplesso(-6.0,2.0));
        assertEquals(4.0,num.getRealPart());
        assertEquals(-1.0,num.getImPart());    
    }   
    
    @Test
    public void testDifferenza14() {
        System.out.println("Test Differenza parti reali concordi negative, parti immaginarie concordi negative");
        NumeroComplesso num= op.differenza(new NumeroComplesso(-2.0,-1.0),new NumeroComplesso(-6.0,-2.0));
        assertEquals(4.0,num.getRealPart());
        assertEquals(1.0,num.getImPart());    
    }    
    
    @Test
    public void testDifferenza15() {
        System.out.println("Test Differenza parti reali concordi negative, parti immaginarie discordi: primo positivo");
        NumeroComplesso num= op.differenza(new NumeroComplesso(-2.0,1.0),new NumeroComplesso(-6.0,-2.0));
        assertEquals(4.0,num.getRealPart());
        assertEquals(3.0,num.getImPart());    
    }          

    @Test
    public void testDifferenza16() {
        System.out.println("Test Differenza parti reali concordi negative, parti immaginarie nulle");
        NumeroComplesso num= op.differenza(new NumeroComplesso(-2.0,0.0),new NumeroComplesso(-6.0,0.0));
        assertEquals(4.0,num.getRealPart());
        assertEquals(0.0,num.getImPart());    
    }       
    /**
     * Test of prodotto method, of class OperazioniBasilari.
     */
   
        @Test
    public void testProdotto1() {
        System.out.println("Test Prodotto a nullo, b nullo");
        NumeroComplesso num= op.prodotto(new NumeroComplesso(0.0,0.0), new NumeroComplesso(0.0,0.0));
        assertEquals(0.0,num.getRealPart());
        assertEquals(0.0,num.getImPart());
    }
    @Test
    public void testProdotto2() {
        System.out.println("Test Prodotto a nullo, b non nullo");
        NumeroComplesso num= op.prodotto(new NumeroComplesso(0.0,0.0), new NumeroComplesso(3.0,7.0));
        assertEquals(0.0,num.getRealPart());
        assertEquals(0.0,num.getImPart());        
    }
   
    @Test
    public void testProdotto3() {
        System.out.println("Test Prodotto a non nullo, b nullo");
        NumeroComplesso num= op.prodotto(new NumeroComplesso(3.0,4.0), new NumeroComplesso(0.0,0.0));
        assertEquals(0.0,num.getRealPart());
        assertEquals(0.0,num.getImPart());     
    }
    
    @Test
    public void testProdotto4() {
        System.out.println("Test Prodotto a: parte reale e immaginaria positive, b: parte reale e immaginaria positive");
        NumeroComplesso num= op.prodotto(new NumeroComplesso(2.0,5.0), new NumeroComplesso(3.0,7.0));
        assertEquals(-29.0,num.getRealPart());
        assertEquals(29.0,num.getImPart());           
    }
    
    @Test
    public void testProdotto5() {
        System.out.println("Test Prodotto a: parte reale e immaginaria positive, b: parte reale e immaginaria negative");
        NumeroComplesso num= op.prodotto(new NumeroComplesso(2.0,5.0), new NumeroComplesso(-3.0,-7.0));
        assertEquals(29.0,num.getRealPart());
        assertEquals(-29.0,num.getImPart());    
    }
    
    @Test
    public void testProdotto6() {
        System.out.println("Test Prodotto a: parte reale e immaginaria positive, b: parte reale e immaginaria discordi");
        NumeroComplesso num= op.prodotto(new NumeroComplesso(2.0,5.0), new NumeroComplesso(-3.0,7.0));
        assertEquals(-41.0,num.getRealPart());
        assertEquals(-1.0,num.getImPart());    
    }  
    
    @Test
    public void testProdotto7() {
        System.out.println("Test Prodotto a: parte reale e immaginaria negative, b: parte reale e immaginaria positive");
        NumeroComplesso num= op.prodotto(new NumeroComplesso(-2.0,-5.0), new NumeroComplesso(3.0,7.0));
        assertEquals(29.0,num.getRealPart());
        assertEquals(-29.0,num.getImPart()); 
    }
    
    @Test
    public void testProdotto8() {
        System.out.println("Test Prodotto a: parte reale e immaginaria negative, b: parte reale e immaginaria negative");
        NumeroComplesso num= op.prodotto(new NumeroComplesso(-2.0,-5.0), new NumeroComplesso(-3.0,-7.0));
        assertEquals(-29.0,num.getRealPart());
        assertEquals(29.0,num.getImPart()); 
    }  
 
    @Test
    public void testProdotto9() {
        System.out.println("Test Prodotto a: parte reale e immaginaria negative, b: parte reale e immaginaria discordi");
        NumeroComplesso num= op.prodotto(new NumeroComplesso(-2.0,-5.0), new NumeroComplesso(3.0,-7.0));
        assertEquals(-41.0,num.getRealPart());
        assertEquals(-1.0,num.getImPart()); 
    }
    @Test
    public void testProdotto10() {
        System.out.println("Test Prodotto a: parte reale e immaginaria discordi, b: parte reale e immaginaria positive");
        NumeroComplesso num= op.prodotto(new NumeroComplesso(2.0,-5.0), new NumeroComplesso(3.0,7.0));
        assertEquals(41.0,num.getRealPart());
        assertEquals(-1.0,num.getImPart());        
    }
    
    @Test
    public void testProdotto11() {
        System.out.println("Test Prodotto a: parte reale e immaginaria discordi, b: parte reale e immaginaria negative");
        NumeroComplesso num= op.prodotto(new NumeroComplesso(2.0,-5.0), new NumeroComplesso(-3.0,-7.0));
        assertEquals(-41.0,num.getRealPart());
        assertEquals(1.0,num.getImPart());        
    }  
    
    @Test
    public void testProdotto12() {
        System.out.println("Test Prodotto a: parte reale e immaginaria discordi, b: parte reale e immaginaria discordi");
        NumeroComplesso num= op.prodotto(new NumeroComplesso(2.0,-5.0), new NumeroComplesso(3.0,-7.0));
        assertEquals(-29.0,num.getRealPart());
        assertEquals(-29.0,num.getImPart());        
    } 

    /**
     * Test of divisione method, of class OperazioniBasilari.
     */
    /*
        TEST DIVISIONE 
        classi equivalenza dividendo: nullo, part Re e Im positive, part Re e Im negative,part Re e Im discordi 
        classi equivalenza divisore: nullo, part Re e Im positive, part Re e Im negative,part Re e Im discordi 
    
        TEST 0 dividendo nullo, divosore nullo
	TEST 1 dividendo non nullo, divisore nullo //raggruppa tutti i test con divisore nullo

        TEST 2 dividendo nullo, divosore part Real e Im positive   
        TEST 3 dividendo nullo, divosore part Real e Im negative
        TEST 4 dividendo nullo, divosore part Real e Im discordi

        TEST 5 dividendo part Real e Im positive , divosore part Real e Im positive   
        TEST 6 dividendo part Real e Im positive , divosore part Real e Im negative
        TEST 7 dividendo part Real e Im positive , divosore part Real e Im discordi
    

        TEST 8 dividendo part Real e Im negative , divosore part Real e Im positive   
        TEST 9 dividendo part Real e Im negative , divosore part Real e Im negative
        TEST 10 dividendo part Real e Im negative , divosore part Real e Im discordi
    

        TEST 11 dividendo part Real e Im discordi, divosore part Real e Im positive   
        TEST 12 dividendo part Real e Im discordi, divosore part Real e Im negative
        TEST 13 dividendo part Real e Im discordi, divosore part Real e Im discordi
    */
    @Test
    public void testDivisione0() throws Exception {
        System.out.println("Test divisione() dividendo nullo, divosore nullo");
        NumeroComplesso a = new NumeroComplesso(0.0,0.0);
        NumeroComplesso b = new NumeroComplesso(0.0,0.0);
        
        DividedByZeroException assertThrows = assertThrows(DividedByZeroException.class,() -> op.divisione(a,b));
        assertEquals("Impossibile dividere per 0",assertThrows.getMessage());
    }
    
    public void testDivisione1() throws Exception {
        System.out.println("Test divisione() dividendo non nullo, divisore nullo");
        NumeroComplesso a = new NumeroComplesso(2.0,-4.0);
        NumeroComplesso b = new NumeroComplesso(0.0,0.0);
        
        DividedByZeroException assertThrows = assertThrows(DividedByZeroException.class,() -> op.divisione(a,b));
        assertEquals("Impossibile dividere per 0",assertThrows.getMessage());
    }
    
    
    @Test
    public void testDivisione2() throws Exception {
        System.out.println("Test divisione() dividendo nullo, divosore part Real e Im positive");
        NumeroComplesso a = new NumeroComplesso(0.0,0.0);
        NumeroComplesso b = new NumeroComplesso(2.0,4.0);
        
        NumeroComplesso res = op.divisione(a,b);
        System.out.println(res.toString());
        assertEquals(0.0d, res.getRealPart());
        assertEquals(0.0d, res.getImPart());
    }
    
    @Test
    public void testDivisione3() throws Exception {
        System.out.println("Test divisione() dividendo nullo, divosore part Real e Im negative");
        NumeroComplesso a = new NumeroComplesso(0.0,0.0);
        NumeroComplesso b = new NumeroComplesso(-20.0,-2.0);
        
        NumeroComplesso res = op.divisione(a,b);
        System.out.println(res.toString());
        assertEquals(0.0, res.getRealPart());
        assertEquals(0.0d, res.getImPart());
    }
    
    @Test
    public void testDivisione4() throws Exception {
        System.out.println("Test divisione() dividendo nullo, divosore part Real e Im discordi");
        NumeroComplesso a = new NumeroComplesso(0.0,0.0);
        NumeroComplesso b = new NumeroComplesso(4.0,-2.0);
        
        NumeroComplesso res = op.divisione(a,b);
        System.out.println(res.toString());
        assertEquals(0.0, res.getRealPart());
        assertEquals(0.0d, res.getImPart());
    }
    

    @Test
    public void testDivisione5() throws Exception {
        System.out.println("Test divisione() dividendo part Real e Im positive , divosore part Real e Im positive   ");
        NumeroComplesso a = new NumeroComplesso(4.0,2.0);
        NumeroComplesso b = new NumeroComplesso(4.0,2.0);
        
        NumeroComplesso res = op.divisione(a,b);
        System.out.println(res.toString());
        assertEquals(1.0, res.getRealPart());
        assertEquals(0.0d, res.getImPart());
    }
    
    @Test
    public void testDivisione6() throws Exception {
        System.out.println("Test divisione() dividendo part Real e Im positive , divosore part Real e Im negative");
        NumeroComplesso a = new NumeroComplesso(4.0,2.0);
        NumeroComplesso b = new NumeroComplesso(-4.0,-2.0);
        
        NumeroComplesso res = op.divisione(a,b);
        System.out.println(res.toString());
        assertEquals(-1.0d, res.getRealPart());
        assertEquals(0.0, res.getImPart());
    }
    
    @Test
    public void testDivisione7() throws Exception {
        System.out.println("Test divisione() dividendo part Real e Im positive , divosore part Real e Im discordi");
        NumeroComplesso a = new NumeroComplesso(4.0,2.0);
        NumeroComplesso b = new NumeroComplesso(4.0,-2.0);
        
        NumeroComplesso res = op.divisione(a,b);
         System.out.println(res.toString());
        assertEquals(0.6d, res.getRealPart());
        assertEquals(0.8d, res.getImPart());
    }
    
    
    @Test
    public void testDivisione8() throws Exception {
        System.out.println("Test divisione() dividendo part Real e Im negative , divosore part Real e Im positive ");
        NumeroComplesso a = new NumeroComplesso(-16.0,-8.0);
        NumeroComplesso b = new NumeroComplesso(4.0,2.0);
        
        NumeroComplesso res = op.divisione(a,b);
        System.out.println(res.toString());
        assertEquals(-4.0d, res.getRealPart());
        assertEquals(0.0d, res.getImPart());
    }
    
    @Test
     public void testDivisione9() throws Exception {
        System.out.println("Test divisione() dividendo part Real e Im negative , divosore part Real e Im negative");
        NumeroComplesso a = new NumeroComplesso(-16.0,-8.0);
        NumeroComplesso b = new NumeroComplesso(-1.0,-0.5);
        
        NumeroComplesso res = op.divisione(a,b);
        System.out.println(res.toString());
        assertEquals(16.0d, res.getRealPart());
        assertEquals(0.0d, res.getImPart());
    }
     
     @Test
     public void testDivisione10() throws Exception {
        System.out.println("Test divisione() dividendo part Real e Im negative , divosore part Real e Im discordi");
        NumeroComplesso a = new NumeroComplesso(-16.0,-8.0);
        NumeroComplesso b = new NumeroComplesso(-1.0,0.5);
        
        NumeroComplesso res = op.divisione(a,b);
        System.out.println(res.toString());
        assertEquals(9.6d, res.getRealPart());
        assertEquals(12.8d, res.getImPart());
    }
     
     @Test
     public void testDivisione11() throws Exception {
        System.out.println("Test divisione() dividendo part Real e Im discordi, divosore part Real e Im positive ");
        NumeroComplesso a = new NumeroComplesso(-16.0,8.0);
        NumeroComplesso b = new NumeroComplesso(1.0,0.5);
        
        NumeroComplesso res = op.divisione(a,b);
        System.out.println(res.toString());
        assertEquals(-9.6d, res.getRealPart());
        assertEquals(12.8d, res.getImPart());
    }
     
     @Test
     public void testDivisione12() throws Exception {
        System.out.println("Test divisione() dividendo part Real e Im discordi, divosore part Real e Im negative");
        NumeroComplesso a = new NumeroComplesso(-16.0,8.0);
        NumeroComplesso b = new NumeroComplesso(-1.0,-0.5);
        
        NumeroComplesso res = op.divisione(a,b);
        System.out.println(res.toString());
        assertEquals(9.6d, res.getRealPart());
        assertEquals(-12.8d, res.getImPart());
    }
     
     @Test
     public void testDivisione13() throws Exception {
        System.out.println("Test divisione()dividendo part Real e Im discordi, divosore part Real e Im discordi");
        NumeroComplesso a = new NumeroComplesso(-16.0,8.0);
        NumeroComplesso b = new NumeroComplesso(-1.0,0.5);
        
        NumeroComplesso res = op.divisione(a,b);
        System.out.println(res.toString());
        assertEquals(16.0d, res.getRealPart());
        assertEquals(0.0d, res.getImPart());
    }
    
    
    /**
     * Test of radiceQuadrata method, of class OperazioniBasilari.
     */
     
     /*
        TEST RADICE QUADRATA
        classi equivalenza parte reale: valore nullo, valore negativo, valore positivo
        classi equivalenza parte immaginaria: valore nullo, valore negativo, valore positivo
    
    
        Test 1 reale nulla; Immaginaria nulla
        Test 2 reale nulla; Immaginaria negativa
        Test 3 reale nulla; Immaginaria positiva
    
        Test 4 reale neagativa; Immaginaria nulla
        Test 5 reale neagativa; Immaginaria positiva
        Test 6 reale neagativa; Immaginaria negativa
    
        Test 7 reale positiva; Immaginaria nulla
        Test 8 reale positiva; Immaginaria postivia
        Test 9 reale positiva; Immaginaria nagativa
     */
     
    @Test
    public void testRadiceQuadrata1() throws Exception {
        System.out.println("Test radiceQuadrata() reale nulla; Immaginaria nulla");
        NumeroComplesso a = new NumeroComplesso(0.0,0.0);
        
        NumeroComplesso res = op.radiceQuadrata(a);
        System.out.println(res.toString());
        assertEquals(0.0, res.getRealPart(),0.009);
        assertEquals(0.0d, res.getImPart(),0.009);
    }
    
    @Test
    public void testRadiceQuadrata2() throws Exception {
        System.out.println("Test radiceQuadrata() reale nulla; Immaginaria negativa");
        NumeroComplesso a = new NumeroComplesso(0.0,-18.0);
        
        NumeroComplesso res = op.radiceQuadrata(a);
        System.out.println(res.toString());
        assertEquals(3.0d, res.getRealPart(),0.009);
        assertEquals(-3.0, res.getImPart(),0.009);
    }
    
    @Test
    public void testRadiceQuadrata3() throws Exception {
        System.out.println("Test radiceQuadrata() reale nulla; Immaginaria positiva");
        NumeroComplesso a = new NumeroComplesso(0.0,18.0);
        
        NumeroComplesso res = op.radiceQuadrata(a);
        System.out.println(res.toString());
        assertEquals(3.0, res.getRealPart(),0.009);
        assertEquals(3.0, res.getImPart(),0.009);
    }
    
    @Test
    public void testRadiceQuadrata4() throws Exception {
        System.out.println("Test radiceQuadrata()  reale neagativa; Immaginaria nulla");
        NumeroComplesso a = new NumeroComplesso(-9.0,0.0);
        
        NumeroComplesso res = op.radiceQuadrata(a);
        System.out.println(res.toString());
        assertEquals(0.0, res.getRealPart(),0.009);
        assertEquals(3.0, res.getImPart(),0.009);
    }
    
    @Test
    public void testRadiceQuadrata5() throws Exception {
        System.out.println("Test radiceQuadrata() reale neagativa; Immaginaria positiva");
        NumeroComplesso a = new NumeroComplesso(-5.0,12.0);
        
        NumeroComplesso res = op.radiceQuadrata(a);
        System.out.println(res.toString());
        assertEquals(2.0d, res.getRealPart(),0.009);
        assertEquals(3.0d, res.getImPart(),0.009);
    }
    
    @Test
    public void testRadiceQuadrata6() throws Exception {
        System.out.println("Test radiceQuadrata() reale neagativa; Immaginaria negativa");
        NumeroComplesso a = new NumeroComplesso(-5.0,-12.0);
        
        NumeroComplesso res = op.radiceQuadrata(a);
        System.out.println(res.toString());
        assertEquals(2.0d, res.getRealPart(),0.009);
        assertEquals(-3.0d, res.getImPart(),0.009);
    }
    
    @Test
    public void testRadiceQuadrata7() throws Exception {
        System.out.println("Test radiceQuadrata() reale positiva; Immaginaria nulla");
        NumeroComplesso a = new NumeroComplesso(16.0,0.0);
        
        NumeroComplesso res = op.radiceQuadrata(a);
        System.out.println(res.toString());
        assertEquals(4.0d, res.getRealPart(),0.009);
        assertEquals(0.0d, res.getImPart(),0.009);
    }
    
    @Test
    public void testRadiceQuadrata8() throws Exception {
        System.out.println("Test radiceQuadrata() reale positiva; Immaginaria negativa");
        NumeroComplesso a = new NumeroComplesso(5.0,-12.0);
        
        NumeroComplesso res = op.radiceQuadrata(a);
        System.out.println(res.toString());
        assertEquals(3.0d, res.getRealPart(),0.009);
        assertEquals(-2.0d, res.getImPart(),0.009);
    }
    
    @Test
    public void testRadiceQuadrata9() throws Exception {
        System.out.println("Test radiceQuadrata() reale positiva; Immaginaria positiva");
        NumeroComplesso a = new NumeroComplesso(5.0,12.0);
        
        NumeroComplesso res = op.radiceQuadrata(a);
        System.out.println(res.toString());
        assertEquals(3.0d, res.getRealPart(),0.009);
        assertEquals(2.0d, res.getImPart(),0.009);
    }

    /**
     * Test of invertSign method, of class OperazioniBasilari.
     */
    
    /* TEST INVERSIONE DEL SEGNO
        classi equivalenza parte reale: valore nullo, valore negativo, valore positivo
        classi equivalenza parte immaginaria: valore nullo, valore negativo, valore positivo
    
        Test 1 reale nulla; Immaginaria nulla
        Test 2 reale nulla; Immaginaria negativa
        Test 3 reale nulla; Immaaginaria positiva
    
        Test 4 reale neagativa; Immaginaria nulla
        Test 5 reale neagativa; Immaginaria positiva
        Test 6 reale neagativa; Immaginaria negativa
    
        Test 7 reale positiva; Immaginaria nulla
        Test 8 reale positiva; Immaginaria postivia
        Test 9 reale positiva; Immaginaria nagativa
    */
    
    @Test
    public void testInvertSign1() {
        System.out.println("Test invertSign() reale nulla; Immaginaria nulla");
        NumeroComplesso a = new NumeroComplesso(0.0,0.0);
        
        NumeroComplesso res = op.invertSign(a);
        System.out.println(res.toString());
        assertEquals(0.0d, res.getRealPart());
        assertEquals(0.0d, res.getImPart());
    }
    
    @Test
    public void testInvertSign2() {
        System.out.println("Test invertSign() reale nulla; Immaginaria negativa");
        NumeroComplesso a = new NumeroComplesso(0.0,-2.0);
        
        NumeroComplesso res = op.invertSign(a);
        System.out.println(res.toString());
        assertEquals(0.0, res.getRealPart());
        assertEquals(2.0, res.getImPart());
    }
    
    @Test
    public void testInvertSign3() {
        System.out.println("Test invertSign() reale nulla; Immaaginaria positiva");
        NumeroComplesso a = new NumeroComplesso(0.0,3.0);
        
        NumeroComplesso res = op.invertSign(a);
        assertEquals(0.0d, res.getRealPart());
        assertEquals(-3.0, res.getImPart());
    }
    
    @Test
    public void testInvertSign4() {
        System.out.println("Test invertSign() reale neagativa; Immaginaria nulla");
        NumeroComplesso a = new NumeroComplesso(-3.0,0.0);
        
        NumeroComplesso res = op.invertSign(a);
        System.out.println(res.toString());
        assertEquals(3.0, res.getRealPart());
        assertEquals(0.0, res.getImPart());
    }
    
    @Test
    public void testInvertSign5() {
        System.out.println("Test invertSign() reale neagativa; Immaginaria postiva");
        NumeroComplesso a = new NumeroComplesso(-3.0,4.0);
        
        NumeroComplesso res = op.invertSign(a);
        System.out.println(res.toString());
        assertEquals(3.0, res.getRealPart());
        assertEquals(-4.0, res.getImPart());
    }
    
    @Test
    public void testInvertSign6() {
        System.out.println("Test invertSign() reale neagativa; Immaginaria negativa");
        NumeroComplesso a = new NumeroComplesso(-3.0,-4.5);
        
        NumeroComplesso res = op.invertSign(a);
        System.out.println(res.toString());
        assertEquals(3.0, res.getRealPart());
        assertEquals(4.5, res.getImPart());
    }
    
    @Test
    public void testInvertSign7() {
        System.out.println("Test invertSign() reale positiva; Immaginaria nulla");
        NumeroComplesso a = new NumeroComplesso(3.0,0.0);
        
        NumeroComplesso res = op.invertSign(a);
        System.out.println(res.toString());
        assertEquals(-3.0, res.getRealPart());
        assertEquals(0.0, res.getImPart());
    }
    
    @Test
    public void testInvertSign8() {
        System.out.println("Test invertSign() reale positiva; Immaginaria positiva");
        NumeroComplesso a = new NumeroComplesso(3.0,4.0);
        
        NumeroComplesso res = op.invertSign(a);
        System.out.println(res.toString());
        assertEquals(-3.0, res.getRealPart());
        assertEquals(-4.0, res.getImPart());
    }
    
    @Test
    public void testInvertSign9() {
        System.out.println("Test invertSign() reale positiva; Immaginaria negativa");
        NumeroComplesso a = new NumeroComplesso(3.0,-3.0);
        
        NumeroComplesso res = op.invertSign(a);
        System.out.println(res.toString());
        assertEquals(-3.0, res.getRealPart());
        assertEquals(3.0, res.getImPart());
    }
}
