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
public class TilesTest {
    
    private Tiles tiles;
    
    public TilesTest() {
    }
    
    @Before
    public void setUp() {
        tiles=new Tiles();
    }


    /**
     * Test of getPlayerHand method, of class Tiles.
     */
    @Test
    public void testGetPlayerHand() {
        System.out.println("getPlayerHand");
        ArrayList<SingleTile> expResult=new ArrayList<>();
        for(int i=0;i<12;i++){
            expResult.add(tiles.getTile(i));
        }
        ArrayList<SingleTile> result = tiles.getPlayerHand();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBotHand method, of class Tiles.
     */
    @Test
    public void testGetBotHand() {
        System.out.println("getBotHand");
        ArrayList<SingleTile> expResult=new ArrayList<>();
        for(int i=12;i<24;i++){
            expResult.add(tiles.getTile(i));
        }
        ArrayList<SingleTile> result = tiles.getBotHand();
        for (int i=0;i<12;i++){
            assertEquals(expResult.get(i),result.get(i));
        }
    }

    /**
     * Test of playerFirst method, of class Tiles.
     */
    @Test
    public void testPlayerFirst() {
        System.out.println("playerFirst");
        ArrayList<SingleTile> playerTiles=new ArrayList<>();
        playerTiles=tiles.getPlayerHand();
        ArrayList<SingleTile> botTiles=new ArrayList<>();
        botTiles=tiles.getBotHand();
        int highestPlayer=-1;
        int highestBot=-1;
        boolean expResult=true;
        for (int i=0;i<12;i++){
            if (playerTiles.get(i).isDouble()){
                if (playerTiles.get(i).getScore()>highestPlayer){
                    highestPlayer=playerTiles.get(i).getScore();
                }
            }
            if (botTiles.get(i).isDouble()){
                if (botTiles.get(i).getScore()>highestBot){
                    highestBot=botTiles.get(i).getScore();
                }
            }
        }
        if(highestBot>highestPlayer){
            expResult = false;
        }else if (highestBot<highestPlayer){
            expResult= true;
        }
        boolean result = tiles.playerFirst();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTile method, of class Tiles.
     */
    @Test
    public void testGetTile() {
        System.out.println("getTile");
        ArrayList<SingleTile> playerTiles=new ArrayList<>();
        playerTiles=tiles.getPlayerHand();
        SingleTile expResult = playerTiles.get(2);
        SingleTile result = tiles.getTile(2);
        assertEquals(expResult, result);
    }
    
}
