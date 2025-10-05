/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class represents a total of 28 domino tiles used in All 7 mode.
 * @author Αλέξανδρος Παρασκευάς 2790 - Ιωάννης Σπυριδωνίδης 2805
 * 
 */
public class TilesAll7 {
    
    private ArrayList<SingleTile> tiles;
    private ArrayList<SingleTile> pTiles7;
    private ArrayList<SingleTile> bTiles7;
    private ArrayList<SingleTile> pTiles5;
    private ArrayList<SingleTile> b1Tiles5;
    private ArrayList<SingleTile> b2Tiles5;
    private ArrayList<SingleTile> b3Tiles5;
    
    /**
     * The constructor of the TilesAll7 class.
     */
    
    public TilesAll7(){
        tiles=new ArrayList<SingleTile>();
        
        for (int i=0;i<=6;i++){
            for (int k=i;k<=6;k++){
               SingleTile tile=new SingleTile(i,k);
               tiles.add(tile);
            }
        }
        Collections.shuffle(tiles);
    } 
    
    /**
     * Gets the tile the user wants to play.
     * @param value the user's choice.
     * @return the desired tile
     */
    public SingleTile getTile(int value){
       return tiles.get(value); 
    }
    
    /**
     * Gets new tiles for the player.
     * @return the player's tiles
     */
    public ArrayList<SingleTile> getPtiles7(){
        pTiles7=new ArrayList<>();
        for (int i=0;i<7;i++){
            SingleTile tile=tiles.get(i);
            pTiles7.add(tile);
        }
        return pTiles7;
    }
    
    /**
     * Gets new tiles for the bot.
     * @return the bot's tiles.
     */
    public ArrayList<SingleTile> getBtiles7(){
        bTiles7=new ArrayList<>();
        for (int i=7;i<14;i++){
            SingleTile tile=tiles.get(i);
            bTiles7.add(tile);
        }
        return bTiles7;
    }  
    
    /**
     * Gets new tiles for the player if there are playing 3-4 players.
     * @return the player's tiles.
     */
    public ArrayList<SingleTile> getPTiles5(){
        pTiles5=new ArrayList<>();
        for (int i=0;i<5;i++){
            SingleTile tile=tiles.get(i);
            pTiles5.add(tile);
        }
        return pTiles5;
    }
    
    /**
     * Gets new tiles for the first bot.
     * @return the bot's tiles.
     */
    public ArrayList<SingleTile> getB1Tiles5(){
        b1Tiles5=new ArrayList<>();
        for (int i=5;i<10;i++){
            SingleTile tile=tiles.get(i);
            b1Tiles5.add(tile);
        }
        return b1Tiles5;
    }
    
    /**
     * Gets new tiles for the second bot.
     * @return the bot's tiles.
     */
    public ArrayList<SingleTile> getB2Tiles5(){
        b2Tiles5=new ArrayList<>();
        for (int i=10;i<15;i++){
            SingleTile tile=tiles.get(i);
            b2Tiles5.add(tile);
        }
        return b2Tiles5;
    }   
    
    /**
     * Gets new tiles for the third bot.
     * @return the bot's tiles.
     */
    public ArrayList<SingleTile> getB3Tiles5(){
        b3Tiles5=new ArrayList<>();
        for (int i=15;i<20;i++){
            SingleTile tile=tiles.get(i);
            b3Tiles5.add(tile);
        }
        return b3Tiles5;
    }    
    
}
