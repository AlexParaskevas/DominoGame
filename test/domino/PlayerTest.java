/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alekos
 */
public class PlayerTest {
    
    private Player player;
    private ArrayList<SingleTile> hand;
    
    public PlayerTest() {
    }
    
    @Before
    public void setUp() {
        player=new Player();
        hand = new ArrayList<>();
        SingleTile tile=new SingleTile(3,4);
        hand.add(tile);
    }
 
    /**
     * Test of getHand method, of class Player.
     */
    @Test
    public void testGetHand() {
        System.out.println("getHand");
        int expsize=0;
        assertEquals(player.getSize(),expsize);
        player.getHand(hand);
        expsize=1;
        assertEquals(player.getSize(),expsize);
    }

    /**
     * Test of isHandEmpty method, of class Player.
     */
    @Test
    public void testIsHandEmpty() {
        System.out.println("isHandEmpty");
        assertEquals(true,player.isHandEmpty());
        player.getHand(hand);
        assertEquals(false,player.isHandEmpty());
    }

    /**
     * Test of getTile method, of class Player.
     */
    @Test
    public void testGetTile() {
        System.out.println("getTile");
        player.getHand(hand);
        SingleTile expresult=new SingleTile(3,4);
        SingleTile result=player.getTile(1);
        assertEquals(expresult.getSide1(), result.getSide1());
        assertEquals(expresult.getSide2(), result.getSide2());
    }

    /**
     * Test of returnTile method, of class Player.
     */
    @Test
    public void testReturnTile() {
        System.out.println("returnTile");
        SingleTile expresult=new SingleTile(1,3);
        player.returnTile(0, expresult);
        SingleTile result=player.getTile(1);
        assertEquals(expresult.getSide1(), result.getSide1());
        assertEquals(expresult.getSide2(), result.getSide2());
    }

    /**
     * Test of getSize method, of class Player.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        player.getHand(hand);
        int expresult=1;
        assertEquals(expresult,player.getSize());
    }

    /**
     * Test of getScore method, of class Player.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        player.getHand(hand);
        int expresult=7;
        assertEquals(expresult,player.getScore());
    }

    /**
     * Test of showHand method, of class Player.
     */
    @Test
    public void testShowHand() {
        System.out.println("showHand");
        player.getHand(hand);
        player.showHand();
    }
    
}
