/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alekos
 */
public class StackTest {

    private Stack stack;
    
    public StackTest() {
    }
    
    @Before
    public void setUp() {
         stack=new Stack();
    }

    /**
     * Test of addToStack method, of class Stack.
     */
    @Test
    public void testAddToStack() {
        System.out.println("addToStack");
        SingleTile expresult = new SingleTile(4,5);
        stack.addToStack(expresult);
        assertEquals(expresult.getSide2(),stack.getLast());
        assertEquals(expresult.getSide1(),stack.getFirst());
        SingleTile expresult2=new SingleTile(3,6);
        stack.addToStack(expresult2);
        assertEquals(false,stack.getCheck());
        
    }

    /**
     * Test of addToStackAsBot method, of class Stack.
     */
    @Test
    public void testAddToStackAsBot() {
        System.out.println("addToStackAsBot");
        SingleTile expresult = new SingleTile(1,3);
        stack.addToStack(expresult);
        assertEquals(expresult.getSide2(),stack.getLast());
        assertEquals(expresult.getSide1(),stack.getFirst());
        SingleTile expresult2=new SingleTile(2,6);
        stack.addToStack(expresult2);
        assertEquals(false,stack.getCheck());
    }

    /**
     * Test of getCheck method, of class Stack.
     */
    @Test
    public void testGetCheck() {
        System.out.println("getCheck");
        SingleTile expresult = new SingleTile(4,5);
        stack.addToStack(expresult);
        assertEquals(true,stack.getCheck());
        SingleTile expresult2 = new SingleTile(3,6);
        stack.addToStack(expresult2);
        assertEquals(false,stack.getCheck());
    }

    /**
     * Test of showStack method, of class Stack.
     */
    @Test
    public void testShowStack() {
        System.out.println("showStack");
        SingleTile expresult = new SingleTile(4,5);
        stack.addToStack(expresult);
        stack.showStack();
    }

    /**
     * Test of getLast method, of class Stack.
     */
    @Test
    public void testGetLast() {
        System.out.println("getLast");
        SingleTile expresult = new SingleTile(4,5);
        stack.addToStack(expresult);
        assertEquals(5,stack.getLast());

    }

    /**
     * Test of getFirst method, of class Stack.
     */
    @Test
    public void testGetFirst() {
        System.out.println("getFirst");
        SingleTile expresult = new SingleTile(4,5);
        stack.addToStack(expresult);
        assertEquals(4,stack.getFirst());
        
    }

    /**
     * Test of getSize method, of class Stack.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        assertEquals(0,stack.getSize());
        SingleTile expresult = new SingleTile(4,5);
        stack.addToStack(expresult);
        assertEquals(2,stack.getSize());
        SingleTile expresult2 = new SingleTile(4,6);
        stack.addToStack(expresult2);
        assertEquals(4,stack.getSize());
    }
    
}
