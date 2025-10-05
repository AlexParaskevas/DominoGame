/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;
 


/**
 * This is the main class of the program, starting the game.
 * @author Αλέξανδρος Παρασκευάς, 2790 - Σπυριδωνίδης Ιωάννης, 2805
 */
public class Main {
    
    /**
     * The main method represents the main menu of the game.
     * @param args the arguments
     */
    public static void main(String[] args){
        Human player=new Human();      
        Game game = new Game();
        System.out.println("Welcome to Domino!");
        System.out.println();
        System.out.println("Please choose one of the following commands:");
        System.out.println("1 to Start the game.");
        System.out.println("2 to view the Rules.");
        System.out.println("3 to Exit.");
        int option=player.giveOption();
        while (option!=3){
            if (option==1){
                game.startGame();
            }else if(option==2){
                System.out.println();
                System.out.println("Rules for the Solo1 mode:");
                System.out.println("Only the very right tile of each row can be played.");
                System.out.println("Start by selecting the row you want.");
                System.out.println("Each tile is placed in the stack, as long as its sides match with the stack's first or last side.");           
                System.out.println("If you don't have any tiles left to play, you lose.");
                System.out.println("If you manage to empty the table ,you win!");
                System.out.println();
                System.out.println("Rules for the Hungarian mode:");
                System.out.println("You play against a bot.");
                System.out.println("For every round the players are given 12 tiles each.");
                System.out.println("The player with the highest double plays first.");
                System.out.println("Each tile is placed in the stack, as long as its sides match with the stack's first or last side.");
                System.out.println("The player who plays last or empties his hand first wins the round and takes the opponent's hand score.");
                System.out.println("Your goal is to reach 100 points.");
                System.out.println();
                System.out.println("Have fun!");
                System.out.println();
                System.out.println("Please choose one of the following commands:");
                System.out.println("1 to Start the game.");
                System.out.println("2 to view the Rules.");
                System.out.println("3 to Exit.");
            }
            
            
            option=player.giveOption();
        }
        System.exit(0);
            
        
    }
    
}
