/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alekos
 */
public class TableTest {
    
    private Table table;
    
    public TableTest() {
    }
  
    @Before
    public void setUp() {
        table=new Table();
    }
    

    /**
     * Test of getRight method, of class Table.
     */
    @Test
    public void testGetRight() {
        System.out.println("getRight");
        SingleTile expresult=new SingleTile(5,3);
        table.returnTile(expresult, 1);
        assertEquals(null,table.getRight(0));
        assertEquals(null,table.getRight(5));
        SingleTile result=table.getRight(1);
        assertEquals(expresult,result);
    }

    /**
     * Method returnTile(SingleTile, int) is tested in the above test. 
     * There is not get method to test the particular void method.
     */
    
    @Test
    public void testReturnTile() {

    }
    

    /**
     * Test of gameWon method, of class Table.
     */
    @Test
    public void testGameWon() {
        System.out.println("gameWon");
        boolean expResult = false;
        boolean result = table.gameWon();
        assertEquals(expResult, result);

    }

    /**
     * Test of showTable method, of class Table.
     */
    @Test
    public void testShowTable() {
        System.out.println("showTable");
        table.showTable();
    }
    
}
