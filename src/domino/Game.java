/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;



/**
 * This class is responsible for running the domino game, Solo1 or Hungarian.
 * @author Αλέξανδρος Παρασκευάς, 2790 - Σπυριδωνίδης Ιωάννης, 2805
 */
public class Game {
    Table table;
    private Stack stack;
    Human player;
    private Tiles tiles2;
    Player bot;
    int row;
    SingleTile tile;
    int playerScore;
    int botScore;
    int playerCounter;
    int botCounter;
    boolean botWon=false;
    boolean playerWon=false;
    
    
    /**
     * The Game class constructor, initializing an object of the classes Table, Human and Player.
     */
    public Game(){
        table=new Table();
        player=new Human();
        bot=new Player();
    }
    
    /**
     * This method starts the game, making an interface to achieve communication with the user
     * regarding the game choise and playing methods.
     * @see Table
     * @see Stack
     * @see Player
     * @see Tiles
     * @see Human
     */
    public void startGame(){
        System.out.println();
        System.out.println("Please choose mode:");
        System.out.println("1. Solo1");
        System.out.println("2. Hungarian");
        System.out.println("\n");
        int s;
        do{
             s=chooseGame();
             if (s!=1 && s!=2){
                 System.out.println("Invalid game type, please try again..");
             }
        } while(s!=1 && s!=2);
        if (s==1){
        table.showTable();
            stack=new Stack();
            System.out.println(); 
            System.out.println("You chose to play Solo1");
            System.out.println(); 
            table.showTable();
            System.out.println("Pick the first tile by picking its row. ");
            row=player.pickUpTile();
            while (row<=0 || row >=5){
                System.out.println("Invalid selection. Please select again..");
                row=player.pickUpTile();
            }
            tile=table.getRight(row);
            stack.addToStack(tile);
            System.out.println();
            table.showTable();
            stack.showStack();
            while (!table.gameWon() && !gameOver()){
                System.out.println();
                System.out.println("Pick the next tile's row. ");
                row=player.pickUpTile();
                   while (row<=0 || row >=5){
                   System.out.println("Invalid selection. Please select again..");
                   System.out.println();
                   row=player.pickUpTile();
                } 
                   tile=table.getRight(row);
                   stack.addToStack(tile);
                   if (!stack.getCheck()){
                        System.out.println("Invalid Tile, please try again..!");
                        table.returnTile(tile, row);
                   }
                table.showTable();
                stack.showStack();
            }
            if (table.gameWon()){
                System.out.println();
                System.out.println("Victory !! ");
            }
            if (gameOver()){
                System.out.println();
                System.out.println("No more valid tiles !");
                System.out.println("Better luck next time..");
            }
        }else if(s==2){
            System.out.println(); 
            System.out.println("You chose to play Hungarian");
            System.out.println();
            while (playerScore<100 && botScore<100){
                stack=new Stack();
                tiles2=new Tiles();
                playerCounter=0;
                botCounter=0;
                player.getHand(tiles2.getPlayerHand());
                bot.getHand(tiles2.getBotHand());
                boolean didPlayerStart=false;
                if (tiles2.playerFirst()){
                        playerPlays();
                        didPlayerStart=true;
                    }
                if(!playerWon){
                    botPlays();
                }
                while (!roundIsOver() && !botWon && !playerWon){ 
                        playerPlays();
                    if(!playerWon){
                        botPlays();
                    }
                }
                if (didPlayerStart){ 
                    if (playerCounter>botCounter || playerWon ){
                        playerScore+=bot.getScore();
                    }else if(playerCounter==botCounter || playerCounter<botCounter || botWon){
                        botScore+=player.getScore();
                    }
                }else if(!didPlayerStart){
                    if (playerCounter==botCounter || playerCounter>botCounter || playerWon ){
                        playerScore+=bot.getScore();
                    }else if( playerCounter<botCounter || botWon){
                        botScore+=player.getScore();
                    }
                }
                    showPlayerScore();
                    showBotScore();
            }
            if (playerScore>=100){
                System.out.println();
                System.out.println("Victory !! ");
            }
            if (botScore>=100){
                System.out.println();
                System.out.println("You lost..!");
                System.out.println("Better luck next time..");
            }
        }
    }
            
    
    /**
     * This method checks if there are no valid tiles to play.
     * @return a <code>boolean</code> specifying if the game is over.
     * @see Stack
     * @see SingleTile
     * @see Table
     * 
     */
     public boolean gameOver(){ //checks if there are no valid tiles to play
        boolean gameover=false;
        int counter=0;
        SingleTile tile2;
            for (int i=1;i<5;i++){
                tile2=table.getRight(i);
                if (tile2!=null){
                    int s1=tile2.getSide1();
                    int s2=tile2.getSide2();
                    int last=stack.getLast();
                    int first=stack.getFirst();
                    if (s1!=last && s1!=first && s2!= last && s2!=first ){
                            counter++;
                    }
                    table.returnTile(tile2, i);
                }else if(table.getRight(i)==null){
                    counter++;
                }
            }
        if (counter==4){
            gameover=true;
        }   
        return gameover;
}
     
     /**
      * Gets the gamer's choise, Solo1 or Hungarian.
      * @return an <code>integer</code> representing the game choise.
      * @see Human#gamechoice
      * 
      */
     public int chooseGame(){
         return player.gameChoice();
     }
     
     /**
      * Starts the player's turn by checking whether he has any tiles left or
      * any valid tiles to play.
      * @see Player#isHandEmpty() 
      * @see Stack
      * @see Player
      * @see Human
      */
     public void playerPlays(){
         boolean playerTurn=true;
         boolean didPlayerPlay=false;
         int playerChoice;
         SingleTile atile;
         player.showHand();
         showStack();
         System.out.println();
         if (stack.getSize()==0){
             System.out.println("Pick the first tile.");
             System.out.println();
             stack.addToStack(player.getTile(player.playTile()));
             player.showHand();
             showStack();
             System.out.println();
         }
         while (playerTurn==true){
                if (!player.isHandEmpty() && !roundIsOver()){
                    System.out.println("Pick the next tile.");
                    System.out.println();
                    playerChoice=player.playTile();
                    atile=player.getTile(playerChoice);
                    stack.addToStack(atile);
                    if (!stack.getCheck()){
                        System.out.println("Invalid Tile, please try again..!");
                        player.returnTile(playerChoice-1,atile);
                    }
                    while(!stack.getCheck()){
                       playerChoice=player.playTile();
                       atile=player.getTile(playerChoice);
                       stack.addToStack(atile);
                       if (!stack.getCheck()){
                           System.out.println("Invalid Tile, please try again..!");
                           player.returnTile(playerChoice-1,atile);
                       }
                    }
                    player.showHand();
                    showStack();
                    System.out.println();
                    didPlayerPlay=true;
                }else if(player.isHandEmpty()||roundIsOver()){
                    if (didPlayerPlay){
                        playerCounter++;
                    }
                    if (player.isHandEmpty()){
                        playerWon=true;
                    }
                    playerTurn=false;
                }
         }
    }
     
     /**
      * Starts the bot's turn by checking whether he has any tiles left or
      * any valid tiles to play.
      * @see Stack
      * @see Player
      */
     public void botPlays(){
         System.out.println();
         System.out.println("Bot's turn..");
         //bot.showHand();  
         boolean didBotPlay=false;
         boolean canBotPlay=true;
         if (stack.getSize()==0){
             stack.addToStackAsBot(bot.getTile(1));
             didBotPlay=true;
         }
         while(canBotPlay && !bot.isHandEmpty()){
            int i=1;
            do{
                SingleTile gtile=bot.getTile(i);
                stack.addToStackAsBot(gtile);
                if (stack.getCheck()==false){
                    bot.returnTile(i-1,gtile);
                }
                i++;
            }while (i<=bot.getSize() && stack.getCheck()==false);
            if (stack.getCheck()==true){
                    didBotPlay=true;
                 }
            if (stack.getCheck()==false){
                 canBotPlay=false;   
            }
         }
         if(didBotPlay){
             botCounter++;
         }
         if (bot.isHandEmpty()){
             botWon=true;
         }
         showStack(); 
         System.out.println();
     }
     
     /**
      * Checks if the player has any valid tiles to play.
      * @return a <code>boolean</code> specifying if the round is over or not.
      * @see Stack
      * @see SingleTile
      * @see Player
      */
     public boolean roundIsOver(){
        boolean roundIsOver=true;
        SingleTile btile;
        for(int i=1;i<=player.getSize();i++){
            btile=player.getTile(i);
            int s1=btile.getSide1();
            int s2=btile.getSide2();
            int last=stack.getLast();
            int first=stack.getFirst();
            if (s1==last || s1==first || s2==last || s2==first){
                roundIsOver=false;
            }
            player.returnTile(i-1, btile);
        }

         return roundIsOver;
     }
     
     /**
      * This method shows the stack.
      * @see Stack#showStack() 
      */
     public void showStack(){
         stack.showStack();
     }
     
     /**
      * This method shows the current player's score.
      */
     public void showPlayerScore(){
         System.out.println();
         System.out.println("Current Player Score: "+playerScore);
     }
     
     /**
      * This method shows the current bot's score.
      */
     public void showBotScore(){
         System.out.println("Current Bot Score: "+botScore);
         System.out.println();
         System.out.println();
     }
}