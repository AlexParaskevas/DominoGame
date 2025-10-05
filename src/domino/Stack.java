/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;

import java.util.ArrayList;
/**
 *This class represents a stack which contains all the played tiles, selected
 * by each player.
 * @author Αλέξανδρος Παρασκευάς, 2790 - Σπυριδωνίδης Ιωάννης, 2805
 */
public class Stack {
    private ArrayList<Integer> stack;
    private boolean check;
    private Human player;
    
    /**
     * The Stack constructor, creating a new object of the class player,
     * initializing a new stack and a new boolean variable, checking whether
     * the tile can be added to the stack or not.
     */
    public Stack(){
        stack = new ArrayList<>();
        check=false;
        player=new Human();
    }
    
    /**
     * This method adds the given tile to the stack and checks if the tile can
     * be put or not. When the tile matches the first or the last side of the
     * stack, the player can choose it's position.
     * @param tile the tile.
     * @see Stack#getCheck() 
     */
    public void addToStack(SingleTile tile){
        int s1=tile.getSide1();
        int s2=tile.getSide2();
        boolean canPut=false;
        if (stack.isEmpty()){
            stack.add(s1);
            stack.add(s2);
            canPut=true;
        }else{
            if ((stack.get(0)==s1 && stack.get(stack.size()-1)==s2)||(stack.get(0)==s2 && stack.get(stack.size()-1)==s1)){
                System.out.println();
                System.out.println("Your tile is : "+s1+"|"+s2);
                System.out.println("Choose the side you want to put it.");
                System.out.println("Available sides: Left , Right");
                System.out.println();
                String side=player.chooseSide(); 
                if ("left".equals(side)|| "Left".equals(side)){
                    if(stack.get(0)==s1){
                        stack.add(0,s2);
                        stack.add(1,s1);
                        canPut=true;
                    }else if(stack.get(0)==s2){
                      stack.add(0,s1);
                      stack.add(1,s2);
                      canPut=true;   
                    }
                }else if("Right".equals(side)||"right".equals(side)){
                    if(stack.get(stack.size()-1)==s1){
                        stack.add(s1);
                        stack.add(s2);
                        canPut=true;
                    }else if(stack.get(stack.size()-1)==s2){
                        stack.add(s2);
                        stack.add(s1);
                        canPut=true;
                    }
                }
            }else{
                if (stack.get(0)==s1){
                    stack.add(0,s2);
                    stack.add(1,s1);
                    canPut=true;
                }else if(stack.get(0)==s2){
                    stack.add(0,s1);
                    stack.add(1,s2);
                    canPut=true;
                }else if(stack.get(stack.size()-1)==s1){
                    stack.add(s1);
                    stack.add(s2);
                    canPut=true;
                }else if(stack.get(stack.size()-1)==s2){
                    stack.add(s2);
                    stack.add(s1);
                    canPut=true;
                }
            }  
        }
        check=canPut;
    }
    
    /**
     * This method adds the given tile to the stack without the ability of
     * the position's choice.
     * @param tile the tile.
     * @see Stack#getCheck() 
     */
    public void addToStackAsBot(SingleTile tile){
        int s1=tile.getSide1();
        int s2=tile.getSide2();
        boolean canPut=false;
        if (stack.isEmpty()){
            stack.add(s1);
            stack.add(s2);
            canPut=true;
        }else{
                if (stack.get(0)==s1){
                    stack.add(0,s2);
                    stack.add(1,s1);
                    canPut=true;
                }else if(stack.get(0)==s2){
                    stack.add(0,s1);
                    stack.add(1,s2);
                    canPut=true;
                }else if(stack.get(stack.size()-1)==s1){
                    stack.add(s1);
                    stack.add(s2);
                    canPut=true;
                }else if(stack.get(stack.size()-1)==s2){
                    stack.add(s2);
                    stack.add(s1);
                    canPut=true;
                }
            }  

        check=canPut;
    }    
    
    /**
     * Gets the check if the tile can be put to the stack.
     * @return a <code>boolean</code> representing the check.
     */
    public boolean getCheck(){
        return check;
    }
      
    /**
    * This method shows the current Stack.
    * @see ArrayList#isEmpty() 
    */
    public void showStack(){
        StringBuilder sb=new StringBuilder();
        if (stack.isEmpty()){
            System.out.println("The stack is empty.");
        }else{
        System.out.println("Current Stack:");
        for (int i=0;i<stack.size();i=i+2)       {
            sb.append(" ").append(stack.get(i)).append("|").append(stack.get(i+1));
        }
        System.out.println(sb.toString());
        }
    }
    
    /**
     * This method gets the second side of the last tile of the Stack.
     * @return an <code>integer</code> specifying the number of the side.
     * @see ArrayList#get(int) 
     */
    public int getLast(){
        return stack.get(stack.size()-1);
    }
    
    /**
     * This method gets the first side of the first tile of the Stack.
     * @return an <code>integer</code> specifying the number of the side.
     * @see ArrayList#get(int) 
     */
    public int getFirst(){
        return stack.get(0);
    }
    
    /**
     * This method gets how many tiles does the Stack contain.
     * @return an <code>integer</code> specifying the size.
     * @see ArrayList#size() 
     */
    public int getSize(){
        return stack.size();
    }
    
}
