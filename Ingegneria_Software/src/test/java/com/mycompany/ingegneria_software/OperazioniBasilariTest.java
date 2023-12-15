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
        System.out.println("Test Somma parti reali concordi positive, parti immaginarie concordi positive");
        NumeroComplesso num2= op.somma(new NumeroComplesso(1.0,3.0),new NumeroComplesso(3.0,1.0));
        assertEquals(4.0,num2.getRealPart());
        assertEquals(4.0,num2.getImPart()); 
    }
    
    @Test
    public void testSomma2() {
        System.out.println("Test Somma parti reali concordi negative, parti immaginarie concordi negative");
        NumeroComplesso num2= op.somma(new NumeroComplesso(-1.0,-3.0),new NumeroComplesso(-3.0,-1.0));
        assertEquals(-4.0,num2.getRealPart());
        assertEquals(-4.0,num2.getImPart()); 
    } 
    
    @Test
    public void testSomma3() {
        System.out.println("Test Somma parti reali discordi, parti immaginarie discordi: primo positivo");
        NumeroComplesso num2= op.somma(new NumeroComplesso(-1.0,3.0),new NumeroComplesso(3.0,-1.0));
        assertEquals(2.0,num2.getRealPart());
        assertEquals(2.0,num2.getImPart()); 
    }   
    

    /**
     * Test of differenza method, of class OperazioniBasilari.
     */
    @Test
    public void testDifferenza1() {
        System.out.println("Test differenza parti reali concordi positive, parti immaginarie concordi positive");
        NumeroComplesso num2= op.differenza(new NumeroComplesso(1.0,3.0),new NumeroComplesso(3.0,1.0));
        assertEquals(-2.0,num2.getRealPart());
        assertEquals(2.0,num2.getImPart()); 
    }
    
    @Test
    public void testDifferenza2() {
        System.out.println("Test differenza parti reali concordi negative, parti immaginarie concordi negative");
        NumeroComplesso num2= op.differenza(new NumeroComplesso(-1.0,-3.0),new NumeroComplesso(-3.0,-1.0));
        assertEquals(2.0,num2.getRealPart());
        assertEquals(-2.0,num2.getImPart()); 
    } 
    
    @Test
    public void testDifferenza3() {
        System.out.println("Test differenza parti reali discordi, parti immaginarie discordi");
        NumeroComplesso num2= op.differenza(new NumeroComplesso(-1.0,3.0),new NumeroComplesso(3.0,-1.0));
        assertEquals(-4.0,num2.getRealPart());
        assertEquals(4.0,num2.getImPart()); 
    }        
    /**
     * Test of prodotto method, of class OperazioniBasilari.
     */
   
    @Test
    public void testProdotto1() {
        System.out.println("Test Prodotto 0*0");
        NumeroComplesso num= op.prodotto(new NumeroComplesso(0.0,0.0), new NumeroComplesso(0.0,0.0));
        assertEquals(0.0,num.getRealPart());
        assertEquals(0.0,num.getImPart());
    }
    
    @Test
    public void testProdotto2() {
        System.out.println("Test Prodotto num1: parte reale nulla, immaginaria positiva; num 2: parte reale positiva, immaginaria positiva");
        NumeroComplesso num= op.prodotto(new NumeroComplesso(0.0,2.0), new NumeroComplesso(2.0,2.0));
        assertEquals(-4.0,num.getRealPart());
        assertEquals(4.0,num.getImPart());
    }
    
    @Test
    public void testProdotto3() {
        System.out.println("Test Prodotto num1: parte reale nulla, immaginaria positiva; num 2: parte reale positiva, immaginaria negativa");
        NumeroComplesso num= op.prodotto(new NumeroComplesso(0.0,2.0), new NumeroComplesso(2.0,-2.0));
        assertEquals(4.0,num.getRealPart());
        assertEquals(4.0,num.getImPart());
    }
    
    @Test
    public void testProdotto4() {
        System.out.println("Test Prodotto num1: parte reale nulla, immaginaria negativa; num 2: parte reale negativa, immaginaria positiva");
        NumeroComplesso num= op.prodotto(new NumeroComplesso(0.0,-2.0), new NumeroComplesso(-2.0,2.0));
        assertEquals(4.0,num.getRealPart());
        assertEquals(4.0,num.getImPart());
    }
    
    @Test
    public void testProdotto5() {
        System.out.println("Test Prodotto num1: parte reale nulla, immaginaria negativa; num 2: parte reale negativa, immaginaria negativa");
        NumeroComplesso num= op.prodotto(new NumeroComplesso(0.0,-2.0), new NumeroComplesso(-2.0,-2.0));
        assertEquals(-4.0,num.getRealPart());
        assertEquals(4.0,num.getImPart());
    }
    
    @Test
    public void testProdotto6() {
        System.out.println("Test Prodotto num1: parte reale positiva, immaginaria nulla; num 2: parte reale positiva, immaginaria positiva");
        NumeroComplesso num= op.prodotto(new NumeroComplesso(2.0,0.0), new NumeroComplesso(2.0,2.0));
        assertEquals(4.0,num.getRealPart());
        assertEquals(4.0,num.getImPart());
    }
    
    @Test
    public void testProdotto7() {
        System.out.println("Test Prodotto num1: parte reale positiva, immaginaria nulla; num 2: parte reale positiva, immaginaria negativa");
        NumeroComplesso num= op.prodotto(new NumeroComplesso(2.0,.0), new NumeroComplesso(2.0,-2.0));
        assertEquals(4.0,num.getRealPart());
        assertEquals(-4.0,num.getImPart());
    }
    
    @Test
    public void testProdotto8() {
        System.out.println("Test Prodotto num1: parte reale negativa, immaginaria nulla; num 2: parte reale negativa, immaginaria positiva");
        NumeroComplesso num= op.prodotto(new NumeroComplesso(-2.0,0.0), new NumeroComplesso(-2.0,2.0));
        assertEquals(4.0,num.getRealPart());
        assertEquals(-4.0,num.getImPart());
    }
    
    @Test
    public void testProdotto9() {
        System.out.println("Test Prodotto num1: parte reale negativa, immaginaria nulla; num 2: parte reale negativa, immaginaria negativa");
        NumeroComplesso num= op.prodotto(new NumeroComplesso(-2.0,0.0), new NumeroComplesso(-2.0,-2.0));
        assertEquals(4.0,num.getRealPart());
        assertEquals(4.0,num.getImPart());
    }
    
   

    /**
     * Test of divisione method, of class OperazioniBasilari.
     */
    /*
        TEST DIVISIONE 
        A/B = (a+ib)/(c+id)
    
        classi equivalenza valore: nullo (0); positivo (+); negativo (-)
    
        TEST 1 dividendo nullo
        TEST 2 divisore nullo
    
        TEST 3 a 0; b +  c +; d+
        TEST 4 a 0; b +  c +; d-
        TEST 5 a 0; b -  c -; d+
        TEST 6 a 0; b -  c -; d-
    
        TEST 7  a +; b 0  c +; d+
        TEST 8  a +; b 0  c +; d-
        TEST 9  a -; b 0  c -; d+
        TEST 10 a -; b 0  c -; d-
    
    */
    @Test
    public void testDivisione1() throws Exception {
        System.out.println("Test divisione() dividendo nullo, divosore nullo");
        NumeroComplesso a = new NumeroComplesso(0.0,0.0);
        NumeroComplesso b = new NumeroComplesso(2.0,2.0);
        
        NumeroComplesso res = op.divisione(a,b);
        
        assertEquals(0.0d, res.getRealPart());
        assertEquals(0.0d, res.getImPart());
    }
    
    public void testDivisione2() throws Exception {
        System.out.println("Test divisione() dividendo non nullo, divisore nullo");
        NumeroComplesso a = new NumeroComplesso(2.0,-4.0);
        NumeroComplesso b = new NumeroComplesso(0.0,0.0);
        
        DividedByZeroException assertThrows = assertThrows(DividedByZeroException.class,() -> op.divisione(a,b));
        assertEquals("Impossibile dividere per 0",assertThrows.getMessage());
    }
    
    
    @Test
    public void testDivisione3() throws Exception {
        System.out.println("Test divisione() a=0 b pos  /  c pos  d pos");
        NumeroComplesso a = new NumeroComplesso(0.0,2.0);
        NumeroComplesso b = new NumeroComplesso(2.0,2.0);
        
        NumeroComplesso res = op.divisione(a,b);
        System.out.println(res.toString());
        assertEquals(0.5d, res.getRealPart());
        assertEquals(0.5d, res.getImPart());
    }
    
    @Test
    public void testDivisione4() throws Exception {
        System.out.println("Test divisione() a=0 b pos  /  c pos  d neg");
        NumeroComplesso a = new NumeroComplesso(0.0,2.0);
        NumeroComplesso b = new NumeroComplesso(2.0,-2.0);
        
        NumeroComplesso res = op.divisione(a,b);
        System.out.println(res.toString());
        assertEquals(-0.5d, res.getRealPart());
        assertEquals(0.5d, res.getImPart());
    }
    
    @Test
    public void testDivisione5() throws Exception {
        System.out.println("Test divisione() a=0 b neg  /  c neg  d pos");
        NumeroComplesso a = new NumeroComplesso(0.0,-2.0);
        NumeroComplesso b = new NumeroComplesso(-2.0,2.0);
        
        NumeroComplesso res = op.divisione(a,b);
        System.out.println(res.toString());
        assertEquals(-0.5d, res.getRealPart());
        assertEquals(0.5d, res.getImPart());
    }
    
    @Test
    public void testDivisione6() throws Exception {
        System.out.println("Test divisione() a=0 b neg  /  c neg  d neg");
        NumeroComplesso a = new NumeroComplesso(0.0,-2.0);
        NumeroComplesso b = new NumeroComplesso(-2.0,-2.0);
        
        NumeroComplesso res = op.divisione(a,b);
        System.out.println(res.toString());
        assertEquals(0.5d, res.getRealPart());
        assertEquals(0.5d, res.getImPart());
    }
    
    @Test
    public void testDivisione7() throws Exception {
        System.out.println("Test divisione() a pos b 0  /  c pos  d pos");
        NumeroComplesso a = new NumeroComplesso(2.0,0.0);
        NumeroComplesso b = new NumeroComplesso(2.0,2.0);
        
        NumeroComplesso res = op.divisione(a,b);
        System.out.println(res.toString());
        assertEquals(0.5d, res.getRealPart());
        assertEquals(-0.5d, res.getImPart());
    }
    
    @Test
    public void testDivisione8() throws Exception {
        System.out.println("Test divisione() a pos b 0  /  c pos  d neg");
        NumeroComplesso a = new NumeroComplesso(2.0,0.0);
        NumeroComplesso b = new NumeroComplesso(2.0,-2.0);
        
        NumeroComplesso res = op.divisione(a,b);
        System.out.println(res.toString());
        assertEquals(0.5d, res.getRealPart());
        assertEquals(0.5d, res.getImPart());
    }
    
    @Test
    public void testDivisione9() throws Exception {
        System.out.println("Test divisione() a neg b 0  /  c neg  d pos");
        NumeroComplesso a = new NumeroComplesso(-2.0,0.0);
        NumeroComplesso b = new NumeroComplesso(-2.0,2.0);
        
        NumeroComplesso res = op.divisione(a,b);
        System.out.println(res.toString());
        assertEquals(0.5d, res.getRealPart());
        assertEquals(0.5d, res.getImPart());
    }
    
    @Test
    public void testDivisione10() throws Exception {
        System.out.println("Test divisione() a neg b 0  /  c neg  d neg");
        NumeroComplesso a = new NumeroComplesso(-2.0,0.0);
        NumeroComplesso b = new NumeroComplesso(-2.0,-2.0);
        
        NumeroComplesso res = op.divisione(a,b);
        System.out.println(res.toString());
        assertEquals(0.5d, res.getRealPart());
        assertEquals(-0.5d, res.getImPart());
    }
    
    /**
     * Test of radiceQuadrata method, of class OperazioniBasilari.
     */
     
     /*
        TEST RADICE QUADRATA
        classi equivalenza parte reale: valore nullo, valore negativo, valore positivo
        classi equivalenza parte immaginaria: valore nullo, valore negativo, valore positivo
    
    
        Test 1 reale nulla; Immaginaria nulla
        Test 2 reale nulla; Immaginaria negativa    //fase=PI/2
        Test 3 reale nulla; Immaginaria positiva    //fase=PI/2
    
        Test 4 reale neagativa; Immaginaria nulla
        Test 5 reale positiva; Immaginaria nulla
     
        Test 6 reale positivi; Immaginaria positiva
            //il funzionamenti di tutte le altre combinazioni è garantito dai test 
            //sul modulo e fase di NumeroComplesso
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
        System.out.println("Test radiceQuadrata() reale positiva; Immaginaria nulla");
        NumeroComplesso a = new NumeroComplesso(16.0,0.0);
        
        NumeroComplesso res = op.radiceQuadrata(a);
        System.out.println(res.toString());
        assertEquals(4.0d, res.getRealPart(),0.009);
        assertEquals(0.0d, res.getImPart(),0.009);
    }
    
    @Test
    public void testRadiceQuadrata6() throws Exception {
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
        Test 2 reale positiva; Immaaginaria positiva
        Test 3 reale negativa; Immaginaria negativa
    */
    
    
    @Test
    public void testInvertSign1() {
        System.out.println("Test invertSign() reale nulla; Immaginaria nulla");
        NumeroComplesso a = new NumeroComplesso(0.0,0.0);
        
        NumeroComplesso res = op.invertSign(a);
        System.out.println(res.toString());
        assertEquals(0.0, res.getRealPart());
        assertEquals(0.0, res.getImPart());
    }
    
    @Test
    public void testInvertSign2() {
        System.out.println("Test invertSign() reale positiva; Immaaginaria positiva");
        NumeroComplesso a = new NumeroComplesso(3.0,3.0);
        
        NumeroComplesso res = op.invertSign(a);
        assertEquals(-3.0d, res.getRealPart());
        assertEquals(-3.0, res.getImPart());
    }
    
    @Test
    public void testInvertSign3() {
        System.out.println("Test invertSign() reale negativa; Immaginaria negativa");
        NumeroComplesso a = new NumeroComplesso(-3.0,-3.0);
        
        NumeroComplesso res = op.invertSign(a);
        System.out.println(res.toString());
        assertEquals(3.0, res.getRealPart());
        assertEquals(3.0, res.getImPart());
    }
    
    
}
