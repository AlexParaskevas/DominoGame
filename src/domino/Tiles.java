/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;
import java.util.ArrayList;
import java.util.Collections;
/**
 * This class represents a total of 28 domino tiles used for Solo1 and Hungarian mode.
 * @author Αλέξανδρος Παρασκευάς, 2790 - Σπυριδωνίδης Ιωάννης, 2805
 */

/**
     * The class constructor creates a new list representing the total tiles,
     * initializes it and shuffles it and two more, one for each player,
     * representing each hand.
     */
public class Tiles {
    
    private ArrayList<SingleTile> tiles;
    private ArrayList<SingleTile> playerTiles;
    private ArrayList<SingleTile> botTiles;

    
    /**
     * The class constructor creates a new list representing the total tiles,
     * initializes it and shuffles it and two more, one for each player,
     * representing each hand.
     */
    public Tiles(){
        tiles=new ArrayList<SingleTile>();
        
        for (int i=0;i<=6;i++){
            for (int k=i;k<=6;k++){
               SingleTile tile=new SingleTile(i,k);
               tiles.add(tile);
            }
        }
        Collections.shuffle(tiles);
        playerTiles=new ArrayList<SingleTile>();
        botTiles=new ArrayList<SingleTile>();  

        for (int i=0;i<=11;i++){
            playerTiles.add(tiles.get(i));
            botTiles.add(tiles.get(i+12));
        }                                   
    }
    
    /**
     * This method returns the tiles that the players holds.
     * @return an <code>ArrayList</code> specifying the tiles.
     */
    public ArrayList<SingleTile> getPlayerHand(){
        return playerTiles;
    }
    
    /**
     * This method returns the tiles that the bot holds.
     * @return an <code>ArrayList</code> specifying the tiles.
     */
    public ArrayList<SingleTile> getBotHand(){
        return botTiles;
    }
    
    /**
     * This method checks who has the highest double tile in order to determine
     * who plays first.
     * @return a <code>boolean</code> representing if the player plays first.
     * @see Tiles#playerTiles
     */
    public boolean playerFirst(){
        boolean playerFirst=true;
        int highestDoublePlayer=-1;
        int highestDoubleBot=-1;
        if (playerTiles.get(0).isDouble()){
            highestDoublePlayer=playerTiles.get(0).getScore();
        }
        if (botTiles.get(0).isDouble()){
            highestDoubleBot=botTiles.get(0).getScore();
        }
        for (int i=1;i<playerTiles.size();i++){
            if(playerTiles.get(i).isDouble()){
                if (playerTiles.get(i).getScore()>highestDoublePlayer){
                highestDoublePlayer=playerTiles.get(i).getScore(); 
                }
            }
            if(botTiles.get(i).isDouble()){
                if (botTiles.get(i).getScore()>highestDoubleBot){
                highestDoubleBot=botTiles.get(i).getScore();
                }
            }
        }
        if (highestDoubleBot>highestDoublePlayer){
            playerFirst=false;
        }
        return playerFirst;
    }
    
    /**
     * This method gets the desired tile.
     * @param value A value.
     * @return a <code>SingleTile</code> specifying the tile.
     */
    public SingleTile getTile(int value){
       return tiles.get(value); 
    }
    
    
   
    }

