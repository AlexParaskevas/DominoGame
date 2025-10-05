/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class represents how the tiles are placed on the board.
 * @author Αλέξανδρος Παρασκευάς, 2790 - Σπυριδωνίδης Ιωάννης, 2805
 */
public class Table {
    private HashMap<Integer,ArrayList<SingleTile>> setup;
    Tiles tiles;
    
    /**
     * The constructor of the Table, setting up a new HashMap and new object of 
     * the class Tiles.
     * @see HashMap
     * @see Tiles
     * @see ArrayList
     */
    public Table(){
        setup=new HashMap<Integer,ArrayList<SingleTile>>();
        tiles = new Tiles();
        int k=0;
        for (int i=0;i<4;i++){
            ArrayList<SingleTile> tilessetup = new ArrayList<>();
            for (int j=0;j<7;j++){
                tilessetup.add(tiles.getTile(j+k));
            }
            k+=7;//adds 7 to use all the ArrayList tiles elements
            setup.put(i,tilessetup);
        }
    }
    
    /**
     * This method gets the valid tile of the table, used in the Solo1 game.
     * @param row the table's row.
     * @return a <code>SingleTile</code> specifying the valid tile.
     */
    public SingleTile getRight(int row){
        if(row-1>=0 && row-1<=3){
            if (setup.get(row-1).isEmpty() ){
             return null;
            }
           else{
            ArrayList<SingleTile> tilessetup=setup.get(row-1);
            SingleTile returnedTile =tilessetup.get(tilessetup.size()-1);           
            removeTile(row,tilessetup.size()-1);
            return  returnedTile;
        }
        }
            else{
                System.out.println("Invalid row");
                System.out.println("\n");
                return null;//!
  }
    }
    
    /**
     * This method returns the given tile back to the specified row of the table.
     * @param tile the tile.
     * @param row the table's row.
     * @see ArrayList#get(int) 
     */
    public void returnTile(SingleTile tile,int row){
        ArrayList<SingleTile> tilessetup=setup.get(row-1);
        tilessetup.add(tile);
    }
    
    /**
     * This method removes the tile picked by the player.
     * @param row the row.
     * @param index the position.
     * @see ArrayList#remove(int) 
     */
    private void removeTile(int row,int index){ // removes the tile picked by player
        ArrayList<SingleTile> tilessetup=setup.get(row-1);
        tilessetup.remove(index);
    }
    
    /**
     * This method checks if the table contains no more tiles.
     * @return a <code>boolean</code> representing if the game is won.
     */
    public boolean gameWon(){
        boolean win=true;
        if (!setup.isEmpty()){
            win=false;
        }
        return win;
    }
    
    /**
     * This method shows the current table.
     * @see StringBuilder#append(java.lang.String) 
     * @see StringBuilder#append(java.lang.Object) 
     */
    public void showTable(){
        StringBuilder sb=new StringBuilder();
        System.out.println("Current Table:");
        for (Integer i : setup.keySet()){
            ArrayList<SingleTile> tilessetup=setup.get(i);
            for (SingleTile tile : tilessetup){
                sb.append(" ").append(tile.getSide1()).append("|").append(tile.getSide2());
                
            }
            sb.append("\n");
            
        }
        
        System.out.println(sb.toString()); 
    }
 
    
}
