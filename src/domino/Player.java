/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents a human/bot player.
 * @author Αλέξανδρος Παρασκευάς, 2790 - Σπυριδωνίδης Ιωάννης, 2805
 */
public class Player {
    
    int s;
    private ArrayList<SingleTile> Hand;
    
    /**
     *The Player constructor, initializing a player's hand as empty.
     */
    public Player(){
        Hand = new ArrayList<>();
    }
    
    /**
     * This method sets the player's hand.                                  
     * @param hand a player's hand.
     */
    public void getHand(ArrayList<SingleTile> hand){
        Hand=hand;
    }
    
    /**
     * This method checks if the player holds any tiles on his hand.
     * @return a <code>boolean</code> specifying if the player holds no tiles.
     */
    public boolean isHandEmpty(){
        return (Hand.isEmpty());
    }
    
    /**
     * This method gets the chosen tile.
     * @param a the tile's position.
     * @return a <code>SingleTile</code> specifying the tile.
     */
    public SingleTile getTile(int a){
        SingleTile atile=Hand.get(a-1);
        removeTile(a);
        return atile;
    }
    
    /**
     * This method removes the tile from the hand as soon as the player selects it.
     * @param a the tile's position.
     */
    private void removeTile(int a){
        Hand.remove(a-1);
    }
    
    /**
     * This method returns a tile to the chosen position.
     * @param a the tile's position.
     * @param atile the tile.
     */
    public void returnTile(int a,SingleTile atile){
        Hand.add(a,atile);
    }
    
    /**
     * This method represents how many tiles are left on the player's hand.
     * @return and <code>integer</code> specifying the number of tiles.
     */
    public int getSize(){
        return Hand.size();
    }
    
    /**
     * This method counts the score of the player's hand.
     * @return an <code>integer</code> specifying the score.
     */
    public int getScore(){
        int score=0;
        for (int i=0;i<Hand.size();i++){
            score+=Hand.get(i).getScore();
        }
        return score;
    }
    
    /**
     * This method shows the player's current hand.
     */
    public void showHand(){
        StringBuilder sb=new StringBuilder();
        System.out.println("Current Hand:");
        for (SingleTile atile : Hand){
            sb.append(" ").append(atile.getSide1()).append("|").append(atile.getSide2());
        }
        System.out.println(sb.toString());
        System.out.println();
    }
    
    
}
