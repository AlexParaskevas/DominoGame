/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;

/**
 * This class represents a single domino tile.
 * @author Αλέξανδρος Παρασκευάς, 2790 - Σπυριδωνίδης Ιωάννης, 2805
 */
public class SingleTile {
    
    private int side1;
    private int side2;
  
    
    /**
     * The SingleTile constructor, assigning each of the 2 tile's sides. 
     * @param aside1 the first side.
     * @param aside2 the second side.
     */
    public SingleTile(int aside1,int aside2){
        side1=aside1;
        side2=aside2;
    }
    
    /**
     * Gets the first side of the tile.
     * @return an <code>integer</code> specifying the side.
     */
    public int getSide1(){
        return side1;
    }
    
    /**
     * Gets the second side of the tile.
     * @return an <code>integer</code> specifying the side.
     */
    public int getSide2(){
        return side2;
    }
    
    /**
     * Checks if the two sides of the tile are the same.
     * @return a <code>boolean</code> representing if the equality is correct.
     */
    public boolean isDouble(){
        return side1==side2;
    }
    
    /**
     * Adds the two sides in order to get the score.
     * @return an <code>integet</code> specifying the score.
     */
    public int getScore(){
        return side1+side2;
    }

}
