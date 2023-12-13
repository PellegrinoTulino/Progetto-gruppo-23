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
public class CmdStackTest {
    Stack<NumeroComplesso> s;
    CmdStack<NumeroComplesso> cmd;
    public CmdStackTest() {
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
        cmd=new CmdStack<NumeroComplesso>(s);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of stackClear method, of class CmdStack.
     */
    @Test
    public void testStackClear1() throws StackIsEmptyException {
        System.out.println("Test operazione clear su stack vuoto");
        cmd.stackClear();
        assertEquals(true,s.isEmpty());
    }
    
    @Test
    public void testStackClear2() throws StackIsEmptyException {
        System.out.println("Test operazione clear su stack non vuoto");
        s.push(new NumeroComplesso(3.7,6.2));
        s.push(new NumeroComplesso(1.4,7.2));
        s.push(new NumeroComplesso(3,2));
        cmd.stackClear();
        assertEquals(true,s.isEmpty());        
    }

    /**
     * Test of stackDrop method, of class CmdStack.
     */
    @Test
    public void testStackDrop1() throws StackIsEmptyException  {
        System.out.println("Test operazione drop su stack vuoto");
        StackIsEmptyException ex = assertThrows(StackIsEmptyException.class, () -> cmd.stackDrop());
        assertEquals("Impossibile effettuare operazione drop su stack vuoto", ex.getMessage());


    }
    
    @Test
    public void testStackDrop2() throws StackIsEmptyException  {
        System.out.println("Test operazione drop su stack con un elemento");        
        s.push(new NumeroComplesso(3.7,6.2));
        cmd.stackDrop();
        assertEquals(true,s.isEmpty());        
    }
    
    @Test
    public void testStackDrop3() throws StackIsEmptyException  {
        System.out.println("Test operazione drop su stack con più di un elemento");
        s.push(new NumeroComplesso(1.4,7.2));
        s.push(new NumeroComplesso(3,2));
        s.push(new NumeroComplesso(5,8));
        cmd.stackDrop();
        assertEquals(3,s.top().getRealPart());
        assertEquals(2,s.top().getImPart());        
    }

    /**
     * Test of stackDup method, of class CmdStack.
     */
    @Test
    public void testStackDup() throws StackIsEmptyException  {
        System.out.println("Test operazione dup su stack vuoto");
        StackIsEmptyException ex = assertThrows(StackIsEmptyException.class, () -> cmd.stackDup());
        assertEquals("Impossibile effettuare operazione dup su stack vuoto", ex.getMessage());
    }
    
    @Test
    public void testStackDup1() throws StackIsEmptyException  {
        System.out.println("Test operazione dup su stack non vuoto");
        s.push(new NumeroComplesso(3.7,6.2));
        s.push(new NumeroComplesso(1.4,7.2));
        s.push(new NumeroComplesso(3,2));
        cmd.stackDup();
        NumeroComplesso num=s.pop();
        assertEquals(num.getRealPart(),s.top().getRealPart());
        assertEquals(num.getImPart(),s.top().getImPart());         
    }
    

    /**
     * Test of stackSwap method, of class CmdStack.
     */
    @Test
    public void testStackSwap1() throws NotEnoughElementsException, StackIsEmptyException {
        System.out.println("Test operazione swap su stack vuoto");
        NotEnoughElementsException ex = assertThrows(NotEnoughElementsException.class, () -> cmd.stackSwap());
        assertEquals("Sono presenti meno di due elementi nello stack. Impossibile effettuare lo swap", ex.getMessage());
    }
    
    @Test
    public void testStackSwap2() throws NotEnoughElementsException, StackIsEmptyException {
        System.out.println("Test operazione swap su stack con un elemento"); 
        s.push(new NumeroComplesso(3.7,6.2));
        NotEnoughElementsException exc = assertThrows(NotEnoughElementsException.class, () -> cmd.stackSwap());        
        assertEquals("Sono presenti meno di due elementi nello stack. Impossibile effettuare lo swap", exc.getMessage());        
    }
    
    @Test
    public void testStackSwap3() throws NotEnoughElementsException, StackIsEmptyException {
        System.out.println("Test operazione swap su stack con un più di un elemento");
        s.push(new NumeroComplesso(1.4,7.2));
        s.push(new NumeroComplesso(3,2));
        cmd.stackSwap();
        NumeroComplesso num=s.pop();
        assertEquals(num.getRealPart(),1.4);
        assertEquals(num.getImPart(),7.2);
        assertEquals(s.top().getRealPart(),3);
        assertEquals(s.top().getImPart(),2);         
    }

    /**
     * Test of stackOver method, of class CmdStack.
     */
    @Test
    public void testStackOver1() throws NotEnoughElementsException, StackIsEmptyException {
        System.out.println("Test operazione over su stack vuoto");
        NotEnoughElementsException ex = assertThrows(NotEnoughElementsException.class, () -> cmd.stackOver());
        assertEquals("Sono presenti meno di due elementi nello stack. Impossibile effettuare l'over", ex.getMessage());
    }
    
    @Test
    public void testStackOver2() throws NotEnoughElementsException, StackIsEmptyException {
        System.out.println("Test operazione over su stack con un elemento");
        s.push(new NumeroComplesso(3.7,6.2));        
        NotEnoughElementsException exc = assertThrows(NotEnoughElementsException.class, () -> cmd.stackOver());
        assertEquals("Sono presenti meno di due elementi nello stack. Impossibile effettuare l'over", exc.getMessage());        
    }
    
    @Test
    public void testStackOver3() throws NotEnoughElementsException, StackIsEmptyException {
        System.out.println("Test operazione over su stack con più di un elemento");
        s.push(new NumeroComplesso(1.4,7.2));
        s.push(new NumeroComplesso(3,2));
        cmd.stackOver();
        NumeroComplesso last=s.pop();
        s.pop();
        assertEquals(last,s.top());        
    }
    
}