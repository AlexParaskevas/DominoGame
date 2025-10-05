/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;

import java.util.Scanner;
/**
 * This class represents a player through inheritance.
 * @see Player 
 * @author Αλέξανδρος Παρασκευάς 2790 - Ιωάννης Σπυριδωνίδης 2805
 */
public class Human extends Player{
    
    int row;
    int gamechoice;
    int op;
    
    /**
     * Human constructor using inheritance.
     */
    public Human(){
        super();
    }
    
    /**
     * Scans and validates the player's choice.
     * @return an <code>integer</code> representing the game choice.
     * @throws IllegalArgumentException in the case when integer is not given.
     */
    public int gameChoice(){
        Scanner scanner = new Scanner(System.in);
        boolean valid=true;
        while (valid){
             gamechoice = scanner.nextInt();
             if (gamechoice!=1 || gamechoice!=2){
                 valid=false;
             }
        }
        return gamechoice;
    }
    
    /**
     * Scans for the desired row in order to add its last tile to the stack, used
     * in the Solo1 mode.
     * @return an <code>integer</code> representing the row.
     * @throws IllegalArgumentException in the case when integer is not given.
     */
    public int pickUpTile(){
        Scanner input = new Scanner(System.in);
        row = input.nextInt();
        return row;     
    }
    
    /**  
     * Scans the side the player wants to place his tile, when the 
     * tile matches the first or the last side of the stack. 
     * @return a <code>String</code> representing the desired side.
     * @see Stack#addToStack(domino.SingleTile)  
     * 
     */
    public String chooseSide(){
        String side;
        Scanner sider = new Scanner(System.in);
        do{
            side=sider.next();
            if (!"Left".equals(side) && !"Right".equals(side) && !"right".equals(side) && !"left".equals(side)){
                System.out.println("Invalid side,please choose Left or Right.");
                System.out.println();  
            }
        }while (!"Left".equals(side) && !"Right".equals(side) && !"right".equals(side) && !"left".equals(side));
        return side;
    }
    
    /**
     * Scans which tile the player wants to play, used in the Hungarian mode.
     * @return an <code>integer</code> representing the tile's number on the hand.
     * @throws IllegalArgumentException in the case when integer is not given.
     */
    public int playTile(){
        Scanner input = new Scanner(System.in);
        do{
             s=input.nextInt();
             if (s<1 || s>super.getSize()){
                 System.out.println("Invalid tile, please try again..!");
             }
        } while(s<1 || s>super.getSize());     
        return s;
    }
    
    /**
     * This method gets the menu option by the player.
     * @return an <code>integer</code> specifying the menu option.
     * @throws IllegalArgumentException in the case when integer is not given.
     */
    public int giveOption(){
        Scanner option = new Scanner(System.in);
        op=option.nextInt();
        while(op!=1 && op!=2 && op!=3){
        System.out.println("Invalid option. Please choose one of the following commands:");
        System.out.println("1 to Start the game.");
        System.out.println("2 to view the Rules.");
        System.out.println("3 to Exit.");
            op=option.nextInt();
        }
        return op;
        
    }
}
