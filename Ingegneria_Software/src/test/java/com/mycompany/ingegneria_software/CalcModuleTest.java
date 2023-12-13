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
 * @author ANDREA
 */
public class CalcModuleTest {
    CalcModule module;
    
    public CalcModuleTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        module=new CalcModule();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of inputControl method, of class CalcModule.
     */
    /*
    INPUT CONTROL
 INPUT NUMERICI
     classi equivalenza
    -parte reale: senza segno, con segno +, con segno -
    -parte immaginaria: senza segno, con segno +, con segno -
    
    TEST_num1: reale senza segno (senza parte immaginaria)
    TEST_num2: reale senza segno, immaginario con segno +
    TEST_num3: reale senza segno, immaginario con segno -
    
    TEST_num4: reale con segno +  (senza parte immaginaria)
    TEST_num5: reale con segno +, immaginario con segno +
    TEST_num6: reale con segno +, immaginario con segno -
    
    TEST_num7: reale con segno -  (senza parte immaginaria)
    TEST_num8: reale con segno -, immaginario con segno +
    TEST_num9: reale con segno -, immaginario con segno -
    
    TEST_num10: numero complesso puro senza segno
    TEST_num11: numero complesso con sengo +
    TEST_num12: numero complesso con sengo -
    
    casi extra erronei
    NOTA: +j e -j non sono numeri validi, ma operazioni valide sulla variabile j
    
    TEST_num13: numero con molteplici punti consecutivi
    TEST_num14: numero di formato xx.x.x
    TEST_num15: parte reale che inizia con .
    TEST_num16: parte immaginaria che inizia con .
    
    TEST_num17: j
    TEST_num18: Numero complesso senza j
    
    TEST_num19: numero con molteplici parti reali
    TEST_num20: numero con molteplici parti immaginarie
    TEST_num21: numero che inizia con più segni
    TEST_num22: numero con più segni prima di parte immaginaria
    */
    @Test
    public void testInputControl_numl() throws Exception {
        String input =  "2.5";
        NumeroComplesso num = new NumeroComplesso(2.5,0);
        module.inputControl(input);
        
        //numero corretto-> salvato nello stack
        NumeroComplesso out[] = module.extractNElementFromStack(1);
        assertEquals(out[0].getRealPart(),num.getRealPart());
    }
    @Test
    public void testInputControl_num2() throws Exception {
        String input =  "2.5+3j";
        NumeroComplesso num = new NumeroComplesso(2.5,3);
        module.inputControl(input);
        
        //numero corretto-> salvato nello stack
        NumeroComplesso out[] = module.extractNElementFromStack(1);
        assertEquals(out[0].getRealPart(),num.getRealPart());
        assertEquals(out[0].getImPart(),num.getImPart());
    }
    @Test
    public void testInputControl_num3() throws Exception {
        String input =  "2.5-3j";
        NumeroComplesso num = new NumeroComplesso(2.5,-3);
        module.inputControl(input);
        
        //numero corretto-> salvato nello stack
        NumeroComplesso out[] = module.extractNElementFromStack(1);
        assertEquals(out[0].getRealPart(),num.getRealPart());
        assertEquals(out[0].getImPart(),num.getImPart());
    }
    @Test
    public void testInputControl_num4() throws Exception {
        String input =  "+2.5";
        NumeroComplesso num = new NumeroComplesso(2.5,0);
        module.inputControl(input);
        
        //numero corretto-> salvato nello stack
        NumeroComplesso out[] = module.extractNElementFromStack(1);
        assertEquals(out[0].getRealPart(),num.getRealPart());
        assertEquals(out[0].getImPart(),num.getImPart());
    }
    @Test
    public void testInputControl_num5() throws Exception {
        String input =  "+2.5+3j";
        NumeroComplesso num = new NumeroComplesso(2.5,3);
        module.inputControl(input);
        
        //numero corretto-> salvato nello stack
        NumeroComplesso out[] = module.extractNElementFromStack(1);
        assertEquals(out[0].getRealPart(),num.getRealPart());
        assertEquals(out[0].getImPart(),num.getImPart());
    }
    @Test
    public void testInputControl_num6() throws Exception {
        String input =  "+2.5-3j";
        NumeroComplesso num = new NumeroComplesso(2.5,-3);
        module.inputControl(input);
        
        //numero corretto-> salvato nello stack
        NumeroComplesso out[] = module.extractNElementFromStack(1);
        assertEquals(out[0].getRealPart(),num.getRealPart());
        assertEquals(out[0].getImPart(),num.getImPart());
    }
    @Test
    public void testInputControl_num7() throws Exception {
        String input =  "-2.5";
        NumeroComplesso num = new NumeroComplesso(-2.5,0);
        module.inputControl(input);
        
        //numero corretto-> salvato nello stack
        NumeroComplesso out[] = module.extractNElementFromStack(1);
        assertEquals(out[0].getRealPart(),num.getRealPart());
        assertEquals(out[0].getImPart(),num.getImPart());
    }
    @Test
    public void testInputControl_num8() throws Exception {
        String input =  "-2.5+3j";
        NumeroComplesso num = new NumeroComplesso(-2.5,3);
        module.inputControl(input);
        
        //numero corretto-> salvato nello stack
        NumeroComplesso out[] = module.extractNElementFromStack(1);
        assertEquals(out[0].getRealPart(),num.getRealPart());
        assertEquals(out[0].getImPart(),num.getImPart());
    }
    @Test
    public void testInputControl_num9() throws Exception {
        String input =  "-2.5-3j";
        NumeroComplesso num = new NumeroComplesso(-2.5,-3);
        module.inputControl(input);
        
        //numero corretto-> salvato nello stack
        NumeroComplesso out[] = module.extractNElementFromStack(1);
        assertEquals(out[0].getRealPart(),num.getRealPart());
        assertEquals(out[0].getImPart(),num.getImPart());
    }
    @Test
    public void testInputControl_num10() throws Exception {
        String input =  "3j";
        NumeroComplesso num = new NumeroComplesso(0,3);
        module.inputControl(input);
        
        //numero corretto-> salvato nello stack
        NumeroComplesso out[] = module.extractNElementFromStack(1);
        assertEquals(out[0].getRealPart(),num.getRealPart());
        assertEquals(out[0].getImPart(),num.getImPart());
    }
    @Test
    public void testInputControl_num11() throws Exception {
        String input =  "+3j";
        NumeroComplesso num = new NumeroComplesso(0,3);
        module.inputControl(input);
        
        //numero corretto-> salvato nello stack
        NumeroComplesso out[] = module.extractNElementFromStack(1);
        assertEquals(out[0].getRealPart(),num.getRealPart());
        assertEquals(out[0].getImPart(),num.getImPart());
    }
    @Test
    public void testInputControl_num12() throws Exception {
        String input =  "-3j";
        NumeroComplesso num = new NumeroComplesso(0,-3);
        module.inputControl(input);
        
        //numero corretto-> salvato nello stack
        NumeroComplesso out[] = module.extractNElementFromStack(1);
        assertEquals(out[0].getRealPart(),num.getRealPart());
        assertEquals(out[0].getImPart(),num.getImPart());
    }
    @Test
    public void testInputControl_num13() throws Exception {
        String input =  "2..1";
        
        //input sbagliato -> mostra messaggio errore
        WrongInputException assertThrows = assertThrows(WrongInputException.class,() ->  module.inputControl(input));
        assertEquals("Input non valido",assertThrows.getMessage());
    }
    @Test
    public void testInputControl_num14() throws Exception {
        String input =  "2.321.2j";
        
        //input sbagliato -> mostra messaggio errore
        WrongInputException assertThrows = assertThrows(WrongInputException.class,() ->  module.inputControl(input));
        assertEquals("Input non valido",assertThrows.getMessage());
    }
    @Test
    public void testInputControl_num15() throws Exception {
        String input =  ".5";
        
        //input sbagliato -> mostra messaggio errore
        WrongInputException assertThrows = assertThrows(WrongInputException.class,() ->  module.inputControl(input));
        assertEquals("Input non valido",assertThrows.getMessage());
    }
    @Test
    public void testInputControl_num16() throws Exception {
        String input =  "2+.2j";
        
        //input sbagliato -> mostra messaggio errore
        WrongInputException assertThrows = assertThrows(WrongInputException.class,() ->  module.inputControl(input));
        assertEquals("Input non valido",assertThrows.getMessage());
    }
    @Test
    public void testInputControl_num17() throws Exception {
        String input =  "j";
        
        //input sbagliato -> mostra messaggio errore
        WrongInputException assertThrows = assertThrows(WrongInputException.class,() ->  module.inputControl(input));
        assertEquals("Input non valido",assertThrows.getMessage());
    }
    @Test
    public void testInputControl_num18() throws Exception {
        String input =  "2+2.66";
        
        //input sbagliato -> mostra messaggio errore
        WrongInputException assertThrows = assertThrows(WrongInputException.class,() ->  module.inputControl(input));
        assertEquals("Input non valido",assertThrows.getMessage());
    }
    @Test
    public void testInputControl_num19() throws Exception {
        String input =  "2.3+2+3j";
        
        //input sbagliato -> mostra messaggio errore
        WrongInputException assertThrows = assertThrows(WrongInputException.class,() ->  module.inputControl(input));
        assertEquals("Input non valido",assertThrows.getMessage());
    }
    @Test
    public void testInputControl_num20() throws Exception {
        String input =  "2.3+2j+4.5j";
        
        //input sbagliato -> mostra messaggio errore
        WrongInputException assertThrows = assertThrows(WrongInputException.class,() ->  module.inputControl(input));
        assertEquals("Input non valido",assertThrows.getMessage());
    }
    @Test
    public void testInputControl_num21() throws Exception {
        String input =  "++2.3+4.5j";
        
        //input sbagliato -> mostra messaggio errore
        WrongInputException assertThrows = assertThrows(WrongInputException.class,() ->  module.inputControl(input));
        assertEquals("Input non valido",assertThrows.getMessage());
    }
    @Test
    public void testInputControl_num22() throws Exception {
        String input =  "+2.3+-4.5j";
        
        //input sbagliato -> mostra messaggio errore
        WrongInputException assertThrows = assertThrows(WrongInputException.class,() ->  module.inputControl(input));
        assertEquals("Input non valido",assertThrows.getMessage());
    }
    /* INPUT CONTROL
    OPERAZIONI SU VARIABILI //la correttezza delle operazioni su varibile è verificata dai Test su Variabili
    TEST_op1: estrazione
    TEST_op2: importazione
    TEST_op3: sommaVar
    TEST_op4: diffVar
    
    TEST_op5: operatore sbagliato
    TEST_op6: operatore non seguito da lettere
    TEST_op7: molteplici operatori
    TEST_op8: molteplici lettere
    
    ALTRO
        Test_x1: qualsiasi altro input
    */
    @Test
    public void testInputControl_op1() throws Exception {
        String input =  "<j";
        
        //variabile non inizializzata -> eccezione
        VariableNotInitializedException ex = assertThrows(VariableNotInitializedException.class, () -> module.inputControl(input));
     assertEquals("La variabile j non è stata inizializzata",ex.getMessage());
    }
    @Test
    public void testInputControl_op2() throws Exception {
        String input =  ">j";
        
        //stack vuoto -> eccezione
        StackIsEmptyException ex = assertThrows(StackIsEmptyException.class, () -> module.inputControl(input));
        assertEquals("Impossibile eseguire una top su stack vuoto", ex.getMessage()); 
    }
    @Test
    public void testInputControl_op3() throws Exception {
        String input =  "+j";
        
        //variabile non inizializzata -> eccezione
        StackIsEmptyException ex = assertThrows(StackIsEmptyException.class, () -> module.inputControl(input));
        assertEquals("Impossibile eseguire una top su stack vuoto", ex.getMessage()); 
    }
    @Test
    public void testInputControl_op4() throws Exception {
        String input =  "-j";
        
        //variabile non inizializzata -> eccezione
        StackIsEmptyException ex = assertThrows(StackIsEmptyException.class, () -> module.inputControl(input));
        assertEquals("Impossibile eseguire una top su stack vuoto", ex.getMessage()); 
    }
    @Test
    public void testInputControl_op5() throws Exception {
        String input =  "*j";
        
        //input sbagliato -> mostra messaggio errore
        WrongInputException assertThrows = assertThrows(WrongInputException.class,() ->  module.inputControl(input));
        assertEquals("Input non valido",assertThrows.getMessage());
    }
    @Test
    public void testInputControl_op6() throws Exception {
        String input =  ">";
        
        //input sbagliato -> mostra messaggio errore
        WrongInputException assertThrows = assertThrows(WrongInputException.class,() ->  module.inputControl(input));
        assertEquals("Input non valido",assertThrows.getMessage());
    }
    @Test
    public void testInputControl_op7() throws Exception {
        String input =  ">+j";
        
        //input sbagliato -> mostra messaggio errore
        WrongInputException assertThrows = assertThrows(WrongInputException.class,() ->  module.inputControl(input));
        assertEquals("Input non valido",assertThrows.getMessage());
    }
    @Test
    public void testInputControl_op8() throws Exception {
        String input =  ">jx";
        
        //input sbagliato -> mostra messaggio errore
        WrongInputException assertThrows = assertThrows(WrongInputException.class,() ->  module.inputControl(input));
        assertEquals("Input non valido",assertThrows.getMessage());
    }
    @Test
    public void testInputControl_ex1() throws Exception {
        String input =  "*/4";
        
        //input sbagliato -> mostra messaggio errore
        WrongInputException assertThrows = assertThrows(WrongInputException.class,() ->  module.inputControl(input));
        assertEquals("Input non valido",assertThrows.getMessage());
    }
    
    /**
     * Test of execute method, of class CalcModule.
     */
    /*
    EXECUTE     //la corretteza delle operazioni è stata verificata con i test di OperazioniBasilari
    TEST1: operatore binario con 2 o più operandi nello stack
    TEST2: operatore unario con 1 o più operandi nello stack
    
    TEST3: operatore binario con meno di 2 operandi nello stack
    TEST4: operatore unario con stack vuoto
    
    TEST5: divisione per zero
    TEST6: operatore non corretto    
    */
    @Test
    public void testExecute1() throws WrongInputException {
        //inserimento valori in stack
        module.inputControl("0+2j");
        module.inputControl("2+0j");
        NumeroComplesso num = new NumeroComplesso(2,2);
        
        //esegui operazione
        module.execute("+");
        
        //se la sommaè stata eseguita si trova in cima allo stack
        NumeroComplesso out[] = module.extractNElementFromStack(1);
        assertEquals(out[0].getRealPart(),num.getRealPart());
        assertEquals(out[0].getImPart(),num.getImPart());
    }
    
    @Test
    public void testExecute2() throws WrongInputException {
        //inserimento valori in stack
        module.inputControl("0+2j");
        module.inputControl("2+2j");
        NumeroComplesso num = new NumeroComplesso(-2,-2);
        
        //esegui operazione
        module.execute("+-");
        
        //se la sommaè stata eseguita si trova in cima allo stack
        NumeroComplesso out[] = module.extractNElementFromStack(1);
        assertEquals(out[0].getRealPart(),num.getRealPart());
        assertEquals(out[0].getImPart(),num.getImPart());
    }
    
    @Test
    public void testExecute3() throws WrongInputException {
        //inserimento valori in stack
        module.inputControl("2+2j");
        
        //non abbastanza elementi -> eccezione
        NotEnoughElementsException assertThrows = assertThrows(NotEnoughElementsException.class,() ->  module.execute("/"));
        assertEquals("Numero operandi insufficiente",assertThrows.getMessage());
    }
    
    @Test
    public void testExecute4() throws WrongInputException {
        //non abbastanza elementi -> eccezione
        NotEnoughElementsException assertThrows = assertThrows(NotEnoughElementsException.class,() ->  module.execute("+-"));
        assertEquals("Numero operandi insufficiente",assertThrows.getMessage());
    }
    
    @Test
    public void testExecute5() throws WrongInputException {
        //inserimento valori in stack
        module.inputControl("0+2j");
        module.inputControl("0+0j");
        
        //non abbastanza elementi -> eccezione
        DividedByZeroException assertThrows = assertThrows(DividedByZeroException.class,() -> module.execute("/"));
        assertEquals("Impossibile dividere per 0",assertThrows.getMessage());
    }

     @Test
    public void testExecute6() throws WrongInputException {
        //non abbastanza elementi -> eccezione
        OperatorNotFoundException assertThrows = assertThrows(OperatorNotFoundException.class,() -> module.execute("4+2j"));
        assertEquals("L'operatore usato non esiste",assertThrows.getMessage());
    }
    
    /**
     * Test of cmdStack method, of class CalcModule.
     */
    /*
    CMD STACK   //la corretezza delle operazioni di manipolazione dellos stack è garantita dai test su CmdStack
                //verifica che l'operazione venga eseguita
    TEST 1: clear
    TEST 2: dup
    TEST 3: drop
    TEST 4: swap
    TEST 5: over
    */
    @Test
    public void testCmdStack1() throws WrongInputException {
        //inserimento valori in stack
        module.inputControl("0+2j");
        module.inputControl("0+0j");
        
        module.cmdStack("clear");
        
        //controllo stack vuoto
        NumeroComplesso[] num = module.extractNElementFromStack(2);
        assertEquals(num.length,0);
    }
    
    @Test
    public void testCmdStack2() throws WrongInputException {
        //inserimento valori in stack
        module.inputControl("1+2j");
        module.inputControl("0+0j");
        NumeroComplesso comp = new NumeroComplesso(0,0);
        
        
        module.cmdStack("dup");
        
        //controllo copiato elemento in cima a stack
        NumeroComplesso[] num = module.extractNElementFromStack(2);
        assertEquals(num[0].getRealPart(), comp.getRealPart());
        assertEquals(num[0].getImPart(), comp.getImPart());
    }
    
    @Test
    public void testCmdStack3() throws WrongInputException {
        //inserimento valori in stack
        module.inputControl("1+2j");
        module.inputControl("0+0j");
        NumeroComplesso comp = new NumeroComplesso(1,2);
        
        
        module.cmdStack("drop");
        
        //controllo se 0+0j rimosso dallo stack
        NumeroComplesso[] num = module.extractNElementFromStack(2);
        assertEquals(num[0].getRealPart(), comp.getRealPart());
        assertEquals(num[0].getImPart(), comp.getImPart());
    }
    
    @Test
    public void testCmdStack4() throws WrongInputException {
        //inserimento valori in stack
        module.inputControl("1+2j");
        module.inputControl("0+0j");
        NumeroComplesso comp1 = new NumeroComplesso(1,2);
        NumeroComplesso comp2 = new NumeroComplesso(0,0);
        
        
        module.cmdStack("swap");
        
        //controllo se i due numeri invertiti di posto
        NumeroComplesso[] num = module.extractNElementFromStack(2);
        assertEquals(num[0].getRealPart(), comp1.getRealPart());
        assertEquals(num[0].getImPart(), comp1.getImPart());
        
        assertEquals(num[1].getRealPart(), comp2.getRealPart());
        assertEquals(num[1].getImPart(), comp2.getImPart());
    }

    /**
     * Test of extractNElementFromStack method, of class CalcModule.
     */
    /*EXTRACT N ELEMENT FROM STACK
    
    TEST 1: estrai meno elementi di quanti ne contenga lo stack
    
    TEST 2: estrai più elementi di quanti ne contenga lo stack
    
    TEST 3: verifica stato stack ripristinato dopo l'estrazione
    */
    @Test
    public void testExtractNElementFromStack1() throws WrongInputException {
        //inserimento valori in stack
        module.inputControl("0");
        module.inputControl("1");
        module.inputControl("2");
        
        //Estrazione
        NumeroComplesso[] num = module.extractNElementFromStack(2);
        
        /*STACK     ARRAY DA RICAVARE     
          |  2           2 1
         \/  1           ->
             0
        */
        
        assertEquals(num[0].getRealPart(),2.0);
        assertEquals(num[1].getRealPart(),1.0);
    }
    
     @Test
    public void testExtractNElementFromStack2() throws WrongInputException {
        //inserimento valori in stack
        module.inputControl("0");
        module.inputControl("1");
        module.inputControl("2");
        
        //Estrazione
        NumeroComplesso[] num = module.extractNElementFromStack(10);
        
        /*STACK     ARRAY DA RICAVARE     
          |  2           2 1 0
         \/  1           ->
             0
        */
        
        //non viene lanciata StackIsEmmptyException perché l'estrazione si ferma non appena lo stack è vuoto
        assertEquals(num[0].getRealPart(),2.0);
        assertEquals(num[1].getRealPart(),1.0);
        assertEquals(num[2].getRealPart(),0.0);
    }
    
     @Test
    public void testExtractNElementFromStack3() throws WrongInputException {
        //inserimento valori in stack
        module.inputControl("0");
        module.inputControl("1");
        module.inputControl("2");
        
        //Estrazioni
        //se lo stato dello stack non è ripristinato, una seconda estrazione troverà lo stack vuoto o nell'ordine errato
        NumeroComplesso[] num1 = module.extractNElementFromStack(3);
        NumeroComplesso[] num2 = module.extractNElementFromStack(3);
        /*STACK     ARRAY DA RICAVARE     
          |  2           2 1 0
         \/  1           ->
             0
        */
        
        assertEquals(num2[0].getRealPart(),2.0);
        assertEquals(num2[1].getRealPart(),1.0);
        assertEquals(num2[2].getRealPart(),0.0);
        
    }
    
}
