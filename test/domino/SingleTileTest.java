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
public class SingleTileTest {
    
    private SingleTile tile;
    
    public SingleTileTest() {
    }
    

    
    @Before
    public void setUp() {
         tile=new SingleTile(1,5);
    }
    
   

    /**
     * Test of getSide1 method, of class SingleTile.
     */
    @Test
    public void testGetSide1() {
        System.out.println("getSide1");
        int expResult = 1;
        int result = tile.getSide1();
        assertEquals(expResult, result);

    }

    /**
     * Test of getSide2 method, of class SingleTile.
     */
    @Test
    public void testGetSide2() {
        System.out.println("getSide2");
        int expResult = 5;
        int result = tile.getSide2();
        assertEquals(expResult, result);
    }


    /**
     * Test of isDouble method, of class SingleTile.
     */
    @Test
    public void testIsDouble() {
        System.out.println("isDouble");
        boolean expResult = false;
        boolean result = tile.isDouble();
        assertEquals(expResult, result);
        SingleTile tile2=new SingleTile(3,3);
        expResult = true;
        result = tile2.isDouble();
        assertEquals(expResult, result);
    }

    /**
     * Test of getScore method, of class SingleTile.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        int expResult = 6;
        int result = tile.getScore();
        assertEquals(expResult, result);
    }
    
}
