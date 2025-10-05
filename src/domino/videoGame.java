/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
/**
 * This class is used for the GUI of the game.
 * @author Αλέξανδρος Παρασκευάς 2790 - Ιωάννης Σπυριδωνίδης 2805
 * 
 */
public class videoGame {
    private JFrame frame;
    private Game game;
    private JLabel[] tilesLabel1;
    private JLabel[] tilesLabel2;
    private JLabel[] tilesLabel3;
    private JLabel[] tilesLabel4;
    private JButton newGame;
    private JButton rules;
    private JTextField rowText;
    private JLabel rowLabel;
    private JButton rowConfirm;
    private int row1;
    private int row2;
    private int row3;
    private int row4;
    private int q;
    private JPanel leftPanel;
    private JLabel[] tilesPlaced;
    private JPanel endPanel;
    private ArrayList<Integer> stack;
    private JPanel centerPanel;
    private JLabel label2;
    private int chosenRow;
    private JLabel botScore;
    private JLabel playerScore;
    private JLabel bot1Score;
    private JLabel bot2Score;
    private JLabel bot3Score;
    private JLabel[] playerHandLabel;
    private boolean botWon;
    private boolean playerWon;
    private boolean bot1Won;
    private boolean bot2Won;
    private boolean bot3Won;
    private int playerCounter;
    private int botCounter;
    private boolean check;
    private JLabel tileChoice;
    private JTextField tileText;
    private JButton tileConfirm;
    private int tmp2;
    private int pScore;
    private int bScore;
    private int b1Score;
    private int b2Score;
    private int b3Score;
    private boolean playerTurn;
    private boolean canBotPlay;
    private boolean canBot1Play;
    private boolean canBot2Play;
    private boolean canBot3Play;
    private boolean didPlayerStart;
    private int tmp3;
    private JLabel stackH;
    private JPanel topPanel;
    private JRadioButton button;
    private ResourceBundle rb;
    private JRadioButton button2;
    private ResourceBundle rb2;
    private int result;
    private int result2;
    private int result3;
    private int result4;
    private Player player;
    private Player bot;
    private Player bot1;
    private Player bot2;
    private Player bot3;
    private JPanel endInner1;
    private JPanel endInner2;
    private JLabel restTilesTitle;
    private JLabel[] restTilesLabel;
    private JButton restTilesButton;
    private boolean didBotPlay;
    private boolean didBot1Play;
    private boolean didBot2Play;
    private boolean didBot3Play;
    private ArrayList<SingleTile> restTiles;
    private JLabel label3;
    
    /**
     * The constructor of the GUI.
     */
    public videoGame(){
        frame = new JFrame();
        frame.setSize(1900,400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
           
        topPanel = new JPanel();
        FlowLayout flow = new FlowLayout();
        topPanel.setLayout(flow);
        
        leftPanel = new JPanel();
              
        centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout());

        endPanel= new JPanel();
        FlowLayout flow2 = new FlowLayout();
        endPanel.setLayout(flow2);   
        
        button = new JRadioButton("Ελληνικά");
        button.setActionCommand("gr");
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                rb = ResourceBundle.getBundle("domino.Gr");
                newGame.setText(rb.getString("New"));
                rules.setText(rb.getString("Rules"));
            }
        });
        
        button2=new JRadioButton("English",true);
        button.setActionCommand("en");
        button2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                rb2 = ResourceBundle.getBundle("domino.En");
                newGame.setText(rb2.getString("Καινούριο"));
                rules.setText(rb2.getString("Κανόνες"));
            }
        });
        
        ButtonGroup group = new ButtonGroup();
        group.add(button);
        group.add(button2);
        topPanel.add(button2);
        topPanel.add(button);
        
        newGame= new JButton("New game");
        newGame.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                leftPanel.removeAll();
                centerPanel.removeAll();
                endPanel.removeAll();
                frame.repaint();
                String[] buttons={"Solo1","Hungarian","All 7"};
                String imgName2 = "/images/domino.jpg";
                URL imageURL2 = getClass().getResource(imgName2);
                ImageIcon icon2 = new ImageIcon(imageURL2);
                if (button.isSelected()){
                    result=JOptionPane.showOptionDialog(null,"Επέλεξε είδος παιχνιδιού",null,JOptionPane.NO_OPTION,0,icon2,buttons,buttons);
                }else if(button2.isSelected()){
                    result=JOptionPane.showOptionDialog(null,"Choose game type",null,JOptionPane.NO_OPTION,0,icon2,buttons,buttons);
                }
                if (result==0){
                    GridLayout grid2 = new GridLayout(4, 7, 4, 4);
                    leftPanel.setLayout(grid2);
                    endPanel.setLayout(new FlowLayout());
                    centerPanel.setLayout(new FlowLayout());
                    label2=new JLabel("Current Stack:");
                    endPanel.add(label2);
                    game=new Game();
                    stack=new ArrayList<>();
                    row1=6;
                    row2=6;
                    row3=6;
                    row4=6;
                    q=0;
                    tilesLabel1 = new JLabel[7];
                    tilesLabel2 = new JLabel[7];
                    tilesLabel3 = new JLabel[7];
                    tilesLabel4 = new JLabel[7];
                    tilesPlaced= new JLabel[28];
                    int k=0;
                    for (int i=0;i<7;i++){
                            tilesLabel1[i] = new JLabel();
                            leftPanel.add(tilesLabel1[i]);
                            String imgName = "/images/" +game.table.tiles.getTile(k+i).getSide1()+game.table.tiles.getTile(k+i).getSide2()+".jpg";
                            URL imageURL = getClass().getResource(imgName);
                            ImageIcon icon = new ImageIcon(imageURL);                       
                            tilesLabel1[i].setIcon(icon);
                    }
                    k+=7;
                    for (int i=0;i<7;i++){
                            tilesLabel2[i] = new JLabel();
                            leftPanel.add(tilesLabel2[i]);
                            String imgName = "/images/" +game.table.tiles.getTile(k+i).getSide1()+game.table.tiles.getTile(k+i).getSide2()+".jpg";
                            URL imageURL = getClass().getResource(imgName);
                            ImageIcon icon = new ImageIcon(imageURL);                       
                            tilesLabel2[i].setIcon(icon);
                    }
                    k+=7;
                    for (int i=0;i<7;i++){
                            tilesLabel3[i] = new JLabel();
                            leftPanel.add(tilesLabel3[i]);
                            String imgName = "/images/" +game.table.tiles.getTile(k+i).getSide1()+game.table.tiles.getTile(k+i).getSide2()+".jpg";
                            URL imageURL = getClass().getResource(imgName);
                            ImageIcon icon = new ImageIcon(imageURL);                       
                            tilesLabel3[i].setIcon(icon);
                    }
                    k+=7;
                    for (int i=0;i<7;i++){
                            tilesLabel4[i] = new JLabel();
                            leftPanel.add(tilesLabel4[i]);
                            String imgName = "/images/" +game.table.tiles.getTile(k+i).getSide1()+game.table.tiles.getTile(k+i).getSide2()+".jpg";
                            URL imageURL = getClass().getResource(imgName);
                            ImageIcon icon = new ImageIcon(imageURL);                       
                            tilesLabel4[i].setIcon(icon);
                    }
                    rowLabel = new JLabel(" Pick the desired tile's row:");
                    centerPanel.add(rowLabel);
                    if (button.isSelected()){
                        label2.setText(rb.getString("Current"));
                        rowLabel.setText(rb.getString("desired"));
                    }
                    button.removeActionListener(this);
                    button.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                            rb = ResourceBundle.getBundle("domino.Gr");
                            newGame.setText(rb.getString("New"));
                            rules.setText(rb.getString("Rules"));
                            label2.setText(rb.getString("Current"));
                            rowLabel.setText(rb.getString("desired"));
                        }
                     });
                    button2.removeActionListener(this);
                    button2.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                            rb2 = ResourceBundle.getBundle("domino.En");
                            newGame.setText(rb2.getString("Καινούριο"));
                            rules.setText(rb2.getString("Κανόνες"));
                            label2.setText(rb2.getString("Τρέχουσα"));
                            rowLabel.setText(rb2.getString("Επέλεγε"));
                        }
                    });
                    rowText=new JTextField("");
                    rowText.setColumns(5);
                    centerPanel.add(rowText);
                    rowConfirm=new JButton(" OK ");
                    rowConfirm.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                            try{
                                getRight(Integer.parseInt(rowText.getText()));
                                rowText.setText("");
                            }catch (NumberFormatException q){
                                    if (button.isSelected()){
                                        JOptionPane.showMessageDialog(null, "Παρακαλώ βάλε έναν έγκυρο αριθμό.","Error",JOptionPane.ERROR_MESSAGE);
                                    }else if(button2.isSelected()){
                                        JOptionPane.showMessageDialog(null, "Please put a valid number.","Error",JOptionPane.ERROR_MESSAGE);
                                    }
                                    rowText.setText("");
                            }
                        }
                    });
                    centerPanel.add(rowConfirm);
                }else if(result==1){
                    endPanel.setLayout(new FlowLayout());
                    centerPanel.setLayout(new FlowLayout());
                    leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
                    JPanel leftPanelInner1=new JPanel();
                    leftPanel.add(leftPanelInner1);
                    JPanel leftPanelInner2=new JPanel();
                    leftPanel.add(leftPanelInner2);
                    game=new Game();
                    stack=new ArrayList<>();
                    q=0;
                    tmp2=11;
                    bScore=0;
                    pScore=0;
                    tmp3=12;
                    playerCounter=0;
                    botCounter=0;
                    botWon=false;
                    playerWon=false;
                    tilesPlaced= new JLabel[28];
                    stackH=new JLabel("Current Stack:");
                    centerPanel.add(stackH);
                    botScore=new JLabel("Bot's Score: 0");
                    playerScore=new JLabel("Your Score: 0");
                    leftPanelInner1.add(playerScore);
                    leftPanelInner1.add(botScore);  
                    game.player.getHand(game.table.tiles.getPlayerHand());
                    game.bot.getHand(game.table.tiles.getBotHand());
                    playerHandLabel=new JLabel[12];
                    label3=new JLabel("Your Hand: ");
                    endPanel.add(label3);
                    for (int i=0;i<=11;i++){
                        playerHandLabel[i]=new JLabel();
                        endPanel.add(playerHandLabel[i]);
                        SingleTile tile2=game.player.getTile(i+1);
                        game.player.returnTile(i,tile2);
                        String imgName = "/images/" +tile2.getSide1()+tile2.getSide2()+".jpg";
                        URL imageURL = getClass().getResource(imgName);
                        ImageIcon icon = new ImageIcon(imageURL);                       
                        playerHandLabel[i].setIcon(icon);
                    }
                    didPlayerStart=game.table.tiles.playerFirst();
                    tileChoice = new JLabel("Pick which tile you want to play: ");
                    leftPanelInner2.add(tileChoice);
                    if (button.isSelected()){
                        stackH.setText(rb.getString("Current"));
                        label3.setText(rb.getString("hand"));
                        tileChoice.setText(rb.getString("pick"));
                    }
                    button.removeActionListener(this);
                    button.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                            rb = ResourceBundle.getBundle("domino.Gr");
                            newGame.setText(rb.getString("New"));
                            rules.setText(rb.getString("Rules"));
                            stackH.setText(rb.getString("Current"));
                            label3.setText(rb.getString("hand"));
                            tileChoice.setText(rb.getString("pick"));
                        }
                    });
                    button2.removeActionListener(this);
                    button2.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                            rb2 = ResourceBundle.getBundle("domino.En");  
                            newGame.setText(rb2.getString("Καινούριο")); 
                            rules.setText(rb2.getString("Κανόνες"));
                            stackH.setText(rb2.getString("Τρέχουσα"));
                            label3.setText(rb2.getString("χέρι"));
                            tileChoice.setText(rb2.getString("Επέλεξε"));
                        }   
                    });
                    if(didPlayerStart==false){
                        botPlays();
                    }
                    tileText=new JTextField("");
                    tileText.setColumns(5);
                    leftPanelInner2.add(tileText);
                    tileConfirm=new JButton(" OK ");
                    tileConfirm.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                            try{
                                if(Integer.parseInt(tileText.getText())>0&&Integer.parseInt(tileText.getText())<=tmp3){
                                    playerPlays(Integer.parseInt(tileText.getText()));   
                                }else{
                                    if (button.isSelected()){
                                        JOptionPane.showMessageDialog(null, "Άκυρη επιλογή.","Error",JOptionPane.ERROR_MESSAGE);
                                    }else if(button2.isSelected()){
                                        JOptionPane.showMessageDialog(null, "Invalid selection.","Error",JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            }catch (NumberFormatException q){
                                    if (button.isSelected()){
                                        JOptionPane.showMessageDialog(null, "Παρακαλώ βάλε έναν έγκυρο αριθμό.","Error",JOptionPane.ERROR_MESSAGE);
                                    }else if(button2.isSelected()){
                                        JOptionPane.showMessageDialog(null, "Please put a valid number.","Error",JOptionPane.ERROR_MESSAGE);
                                    }
                                    tileText.setText("");
                            }
                        }
                    });
                    leftPanelInner2.add(tileConfirm);
                    leftPanel.revalidate();
                }else if(result==2){
                    if (button.isSelected()){
                        String[] buttons2={"2 παίχτες","3 παίχτες","4 παίχτες"};
                        result3=JOptionPane.showOptionDialog(null,"Επέλεξε τον αριθμό των παιχτών:","All 7",JOptionPane.PLAIN_MESSAGE,JOptionPane.INFORMATION_MESSAGE,null,buttons2,buttons2);
                    }else if(button2.isSelected()){
                        String[] buttons2={"2 players","3 players","4 players"};
                        result3=JOptionPane.showOptionDialog(null,"Choose the number of players:","All 7",JOptionPane.PLAIN_MESSAGE,JOptionPane.INFORMATION_MESSAGE,null,buttons2,buttons2);
                    }
                    if (result3==0){
                        endPanel.setLayout(new BoxLayout(endPanel,BoxLayout.PAGE_AXIS));
                        endInner1=new JPanel();
                        endInner1.setLayout(new FlowLayout());
                        endInner2=new JPanel();
                        endInner2.setLayout(new FlowLayout());
                        endPanel.add(endInner2);
                        endPanel.add(endInner1);
                        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
                        JPanel leftPanelInner1=new JPanel();
                        leftPanel.add(leftPanelInner1);
                        JPanel leftPanelInner2=new JPanel();
                        leftPanel.add(leftPanelInner2);
                        TilesAll7 tiles7=new TilesAll7();
                        player=new Player();
                        bot=new Player();
                        stack=new ArrayList<>();
                        restTiles=new ArrayList<>();
                        q=0;
                        bScore=0;
                        tmp2=6;
                        tmp3=7;
                        pScore=0;
                        botWon=false;
                        playerWon=false;
                        tilesPlaced= new JLabel[28];
                        stackH=new JLabel("Current Stack:");
                        centerPanel.add(stackH);
                        botScore=new JLabel("Bot's Score: 0");
                        playerScore=new JLabel("Your Score: 0");
                        leftPanelInner1.add(playerScore);
                        leftPanelInner1.add(botScore);  
                        player.getHand(tiles7.getPtiles7());
                        bot.getHand(tiles7.getBtiles7());
                        restTilesTitle=new JLabel("Extra Tiles:");
                        restTilesLabel=new JLabel[14];
                        endInner1.add(restTilesTitle);
                        for (int i=14;i<28;i++){
                            SingleTile tile2=tiles7.getTile(i);
                            restTiles.add(tile2);
                            String imgName = "/images/" +tile2.getSide1()+tile2.getSide2()+".jpg";
                            URL imageURL = getClass().getResource(imgName);
                            ImageIcon icon = new ImageIcon(imageURL);  
                            restTilesLabel[i-14]=new JLabel();
                            endInner1.add(restTilesLabel[i-14]);
                            restTilesLabel[i-14].setIcon(icon);
                        }
                        restTilesButton=new JButton("Take from Extra");
                        restTilesButton.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e){
                                if (restTiles.size()>2){
                                    player.returnTile(player.getSize(), restTiles.get(restTiles.size()-1));
                                    String imgName = "/images/" +restTiles.get(restTiles.size()-1).getSide1()+restTiles.get(restTiles.size()-1).getSide2()+".jpg";
                                    URL imageURL = getClass().getResource(imgName);
                                    ImageIcon icon = new ImageIcon(imageURL);
                                    playerHandLabel[tmp2+1]=new JLabel();
                                    endInner2.add(playerHandLabel[tmp2+1],tmp2+2);
                                    playerHandLabel[tmp2+1].setIcon(icon);
                                    restTilesLabel[restTiles.size()-1].setIcon(null);
                                    restTiles.remove(restTiles.get(restTiles.size()-1));
                                    tmp2++;
                                    tmp3++;
                                }else{
                                    if (button.isSelected()){
                                        JOptionPane.showMessageDialog(null, "Δεν μπορείς να πάρεις επιπλέον πλακίδια. Έφτασες το όριο.","Error",JOptionPane.ERROR_MESSAGE);
                                    }else if(button2.isSelected()){
                                        JOptionPane.showMessageDialog(null, "You can't take more tiles. You reached the limit.","Error",JOptionPane.ERROR_MESSAGE);
                                    } 
                                }
                            }
                        });    
                        endInner1.add(restTilesButton);
                        playerHandLabel=new JLabel[19];
                        label3=new JLabel("Your Hand:");
                        endInner2.add(label3);
                        for (int i=0;i<=6;i++){
                            playerHandLabel[i]=new JLabel();
                            endInner2.add(playerHandLabel[i]);
                            SingleTile tile3=tiles7.getTile(i);
                            String imgName = "/images/" +tile3.getSide1()+tile3.getSide2()+".jpg";
                            URL imageURL = getClass().getResource(imgName);
                            ImageIcon icon = new ImageIcon(imageURL);                       
                            playerHandLabel[i].setIcon(icon);
                        }
                        tileChoice = new JLabel("Pick which tile you want to play: ");
                        leftPanelInner2.add(tileChoice);
                        if (button.isSelected()){
                            stackH.setText(rb.getString("Current"));
                            label3.setText(rb.getString("hand"));
                            tileChoice.setText(rb.getString("pick"));
                            restTilesTitle.setText(rb.getString("rest"));
                            restTilesButton.setText(rb.getString("Take"));
                        }
                        button.removeActionListener(this);
                        button.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e){
                                rb = ResourceBundle.getBundle("domino.Gr");
                                newGame.setText(rb.getString("New"));
                                rules.setText(rb.getString("Rules"));
                                stackH.setText(rb.getString("Current"));
                                label3.setText(rb.getString("hand"));
                                tileChoice.setText(rb.getString("pick"));
                                restTilesTitle.setText(rb.getString("rest"));
                                restTilesButton.setText(rb.getString("Take"));
                            }
                        });
                        button2.removeActionListener(this);
                        button2.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e){
                                rb2 = ResourceBundle.getBundle("domino.En");  
                                newGame.setText(rb2.getString("Καινούριο")); 
                                rules.setText(rb2.getString("Κανόνες"));
                                stackH.setText(rb2.getString("Τρέχουσα"));
                                label3.setText(rb2.getString("χέρι"));
                                tileChoice.setText(rb2.getString("Επέλεξε"));
                                restTilesTitle.setText(rb2.getString("Έξτρα"));
                                restTilesButton.setText(rb2.getString("Πάρε"));
                            }   
                        });
                        tileText=new JTextField("");
                        tileText.setColumns(5);
                        leftPanelInner2.add(tileText);
                        tileConfirm=new JButton(" OK ");
                        tileConfirm.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e){
                                try{
                                    if(Integer.parseInt(tileText.getText())>0&&Integer.parseInt(tileText.getText())<=tmp3){
                                        playerPlays7(Integer.parseInt(tileText.getText()));   
                                    }else{
                                        if (button.isSelected()){
                                            JOptionPane.showMessageDialog(null, "Άκυρη επιλογή.","Error",JOptionPane.ERROR_MESSAGE);
                                        }else if(button2.isSelected()){
                                            JOptionPane.showMessageDialog(null, "Invalid selection.","Error",JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                }catch (NumberFormatException q){
                                    if (button.isSelected()){
                                        JOptionPane.showMessageDialog(null, "Παρακαλώ βάλε έναν έγκυρο αριθμό.","Error",JOptionPane.ERROR_MESSAGE);
                                    }else if(button2.isSelected()){
                                        JOptionPane.showMessageDialog(null, "Please put a valid number.","Error",JOptionPane.ERROR_MESSAGE);
                                    }
                                    tileText.setText("");
                                }
                            }
                        });
                        leftPanelInner2.add(tileConfirm);
                        leftPanel.revalidate();
                    }else if(result3==1){
                        endPanel.setLayout(new BoxLayout(endPanel,BoxLayout.PAGE_AXIS));
                        endInner1=new JPanel();
                        endInner1.setLayout(new FlowLayout());
                        endInner2=new JPanel();
                        endInner2.setLayout(new FlowLayout());
                        endPanel.add(endInner2);
                        endPanel.add(endInner1);
                        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
                        JPanel leftPanelInner1=new JPanel();
                        leftPanel.add(leftPanelInner1);
                        JPanel leftPanelInner2=new JPanel();
                        leftPanel.add(leftPanelInner2);
                        TilesAll7 tiles7=new TilesAll7();
                        player=new Player();
                        bot1=new Player();
                        bot2=new Player();
                        stack=new ArrayList<>();
                        restTiles=new ArrayList<>();
                        q=0;
                        b1Score=0;
                        b2Score=0;
                        tmp2=4;
                        tmp3=5;
                        pScore=0;
                        bot1Won=false;
                        bot2Won=false;
                        playerWon=false;
                        tilesPlaced= new JLabel[28];
                        stackH=new JLabel("Current Stack:");
                        centerPanel.add(stackH);
                        bot1Score=new JLabel("    Bot1 Score: 0");
                        bot2Score=new JLabel("    Bot2 Score: 0");
                        playerScore=new JLabel("Your Score: 0");
                        leftPanelInner1.add(playerScore);
                        leftPanelInner1.add(bot1Score);  
                        leftPanelInner1.add(bot2Score);  
                        player.getHand(tiles7.getPTiles5());
                        bot1.getHand(tiles7.getB1Tiles5());
                        bot2.getHand(tiles7.getB2Tiles5());
                        restTilesTitle=new JLabel("Extra Tiles: ");
                        restTilesLabel=new JLabel[13];
                        endInner1.add(restTilesTitle);
                        for (int i=15;i<28;i++){
                            SingleTile tile2=tiles7.getTile(i);
                            restTiles.add(tile2);
                            String imgName = "/images/" +tile2.getSide1()+tile2.getSide2()+".jpg";
                            URL imageURL = getClass().getResource(imgName);
                            ImageIcon icon = new ImageIcon(imageURL);  
                            restTilesLabel[i-15]=new JLabel();
                            endInner1.add(restTilesLabel[i-15]);
                            restTilesLabel[i-15].setIcon(icon);
                        }
                        restTilesButton=new JButton("Take from Extra");
                        restTilesButton.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e){
                                if (restTiles.size()>2){
                                    player.returnTile(player.getSize(), restTiles.get(restTiles.size()-1));
                                    String imgName = "/images/" +restTiles.get(restTiles.size()-1).getSide1()+restTiles.get(restTiles.size()-1).getSide2()+".jpg";
                                    URL imageURL = getClass().getResource(imgName);
                                    ImageIcon icon = new ImageIcon(imageURL);
                                    playerHandLabel[tmp2+1]=new JLabel();
                                    endInner2.add(playerHandLabel[tmp2+1],tmp2+2);
                                    playerHandLabel[tmp2+1].setIcon(icon);
                                    restTilesLabel[restTiles.size()-1].setIcon(null);
                                    restTiles.remove(restTiles.get(restTiles.size()-1));
                                    endInner2.revalidate();
                                    tmp2++;
                                    tmp3++;
                                }else{
                                    if (button.isSelected()){
                                        JOptionPane.showMessageDialog(null, "Δεν μπορείς να πάρεις επιπλέον πλακίδια. Έφτασες το όριο.","Error",JOptionPane.ERROR_MESSAGE);
                                    }else if(button2.isSelected()){
                                        JOptionPane.showMessageDialog(null, "You can't take more tiles. You reached the limit.","Error",JOptionPane.ERROR_MESSAGE);
                                    } 
                                }
                            }
                        });    
                        endInner1.add(restTilesButton);
                        playerHandLabel=new JLabel[18];
                        JLabel label3=new JLabel("Your Hand:");
                        endInner2.add(label3);
                        for (int i=0;i<=4;i++){
                            playerHandLabel[i]=new JLabel();
                            endInner2.add(playerHandLabel[i]);
                            SingleTile tile3=tiles7.getTile(i);
                            String imgName = "/images/" +tile3.getSide1()+tile3.getSide2()+".jpg";
                            URL imageURL = getClass().getResource(imgName);
                            ImageIcon icon = new ImageIcon(imageURL);                       
                            playerHandLabel[i].setIcon(icon);
                        }
                        tileChoice = new JLabel("Pick which tile you want to play:");
                        leftPanelInner2.add(tileChoice);
                        if (button.isSelected()){
                            stackH.setText(rb.getString("Current"));
                            label3.setText(rb.getString("hand"));
                            tileChoice.setText(rb.getString("pick"));
                            restTilesTitle.setText(rb.getString("rest"));
                            restTilesButton.setText(rb.getString("Take"));
                        }
                        button.removeActionListener(this);
                        button.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e){
                                rb = ResourceBundle.getBundle("domino.Gr");
                                newGame.setText(rb.getString("New"));
                                rules.setText(rb.getString("Rules"));
                                stackH.setText(rb.getString("Current"));
                                label3.setText(rb.getString("hand"));
                                tileChoice.setText(rb.getString("pick"));
                                restTilesTitle.setText(rb.getString("rest"));
                                restTilesButton.setText(rb.getString("Take"));
                            }
                        });
                        button2.removeActionListener(this);
                        button2.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e){
                                rb2 = ResourceBundle.getBundle("domino.En");  
                                newGame.setText(rb2.getString("Καινούριο")); 
                                rules.setText(rb2.getString("Κανόνες"));
                                stackH.setText(rb2.getString("Τρέχουσα"));
                                label3.setText(rb2.getString("χέρι"));
                                tileChoice.setText(rb2.getString("Επέλεξε"));
                                restTilesTitle.setText(rb2.getString("Έξτρα"));
                                restTilesButton.setText(rb2.getString("Πάρε"));
                            }   
                        });
                        tileText=new JTextField("");
                        tileText.setColumns(5);
                        leftPanelInner2.add(tileText);
                        tileConfirm=new JButton(" OK ");
                        tileConfirm.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e){
                                try{
                                    if(Integer.parseInt(tileText.getText())>0&&Integer.parseInt(tileText.getText())<=tmp3){
                                        playerPlays2bot(Integer.parseInt(tileText.getText()));   
                                    }else{
                                        if (button.isSelected()){
                                            JOptionPane.showMessageDialog(null, "Άκυρη επιλογή.","Error",JOptionPane.ERROR_MESSAGE);
                                        }else if(button2.isSelected()){
                                            JOptionPane.showMessageDialog(null, "Invalid selection.","Error",JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                }catch (NumberFormatException q){
                                    if (button.isSelected()){
                                        JOptionPane.showMessageDialog(null, "Παρακαλώ βάλε έναν έγκυρο αριθμό.","Error",JOptionPane.ERROR_MESSAGE);
                                    }else if(button2.isSelected()){
                                        JOptionPane.showMessageDialog(null, "Please put a valid number.","Error",JOptionPane.ERROR_MESSAGE);
                                    }
                                    tileText.setText("");
                                }
                            }
                        });
                        leftPanelInner2.add(tileConfirm);
                        leftPanel.revalidate();
                    }else if(result3==2){
                        endPanel.setLayout(new BoxLayout(endPanel,BoxLayout.PAGE_AXIS));
                        endInner1=new JPanel();
                        endInner1.setLayout(new FlowLayout());
                        endInner2=new JPanel();
                        endInner2.setLayout(new FlowLayout());
                        endPanel.add(endInner2);
                        endPanel.add(endInner1);
                        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
                        JPanel leftPanelInner1=new JPanel();
                        leftPanel.add(leftPanelInner1);
                        JPanel leftPanelInner2=new JPanel();
                        leftPanel.add(leftPanelInner2);
                        TilesAll7 tiles7=new TilesAll7();
                        player=new Player();
                        bot1=new Player();
                        bot2=new Player();
                        bot3=new Player();
                        stack=new ArrayList<>();
                        restTiles=new ArrayList<>();
                        q=0;
                        b1Score=0;
                        b2Score=0;
                        b3Score=0;
                        tmp2=4;
                        tmp3=5;
                        pScore=0;
                        bot1Won=false;
                        bot2Won=false;
                        bot3Won=false;
                        playerWon=false;
                        tilesPlaced= new JLabel[28];
                        stackH=new JLabel("Current Stack:");
                        centerPanel.add(stackH);   
                        bot1Score=new JLabel("    Bot1 Score: 0");
                        bot2Score=new JLabel("    Bot2 Score: 0");
                        bot3Score=new JLabel("    Bot3 Score: 0");
                        playerScore=new JLabel("Your Score: 0");
                        leftPanelInner1.add(playerScore);
                        leftPanelInner1.add(bot1Score);  
                        leftPanelInner1.add(bot2Score);  
                        leftPanelInner1.add(bot3Score); 
                        player.getHand(tiles7.getPTiles5());
                        bot1.getHand(tiles7.getB1Tiles5());
                        bot2.getHand(tiles7.getB2Tiles5());
                        bot3.getHand(tiles7.getB3Tiles5());
                        restTilesTitle=new JLabel("Extra Tiles: ");
                        restTilesLabel=new JLabel[8];
                        endInner1.add(restTilesTitle);
                        for (int i=20;i<28;i++){
                            SingleTile tile2=tiles7.getTile(i);
                            restTiles.add(tile2);
                            String imgName = "/images/" +tile2.getSide1()+tile2.getSide2()+".jpg";
                            URL imageURL = getClass().getResource(imgName);
                            ImageIcon icon = new ImageIcon(imageURL);  
                            restTilesLabel[i-20]=new JLabel();
                            endInner1.add(restTilesLabel[i-20]);
                            restTilesLabel[i-20].setIcon(icon);
                        }
                        restTilesButton=new JButton("Take from Extra");
                        restTilesButton.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e){
                                if (restTiles.size()>2){
                                    player.returnTile(player.getSize(), restTiles.get(restTiles.size()-1));
                                    String imgName = "/images/" +restTiles.get(restTiles.size()-1).getSide1()+restTiles.get(restTiles.size()-1).getSide2()+".jpg";
                                    URL imageURL = getClass().getResource(imgName);
                                    ImageIcon icon = new ImageIcon(imageURL);
                                    playerHandLabel[tmp2+1]=new JLabel();
                                    endInner2.add(playerHandLabel[tmp2+1],tmp2+2);
                                    playerHandLabel[tmp2+1].setIcon(icon);
                                    restTilesLabel[restTiles.size()-1].setIcon(null);
                                    restTiles.remove(restTiles.get(restTiles.size()-1));
                                    endInner2.revalidate();
                                    tmp2++;
                                    tmp3++;
                                }else{
                                    if (button.isSelected()){
                                        JOptionPane.showMessageDialog(null, "Δεν μπορείς να πάρεις επιπλέον πλακίδια. Έφτασες το όριο.","Error",JOptionPane.ERROR_MESSAGE);
                                    }else if(button2.isSelected()){
                                        JOptionPane.showMessageDialog(null, "You can't take more tiles. You reached the limit.","Error",JOptionPane.ERROR_MESSAGE);
                                    } 
                                }
                            }
                        });    
                        endInner1.add(restTilesButton);
                        playerHandLabel=new JLabel[18];
                        JLabel label3=new JLabel("Your Hand:");
                        endInner2.add(label3);
                        for (int i=0;i<=4;i++){
                            playerHandLabel[i]=new JLabel();
                            endInner2.add(playerHandLabel[i]);
                            SingleTile tile3=tiles7.getTile(i);
                            String imgName = "/images/" +tile3.getSide1()+tile3.getSide2()+".jpg";
                            URL imageURL = getClass().getResource(imgName);
                            ImageIcon icon = new ImageIcon(imageURL);                       
                            playerHandLabel[i].setIcon(icon);
                        }
                        tileChoice = new JLabel("Pick which tile you want to play:");
                        leftPanelInner2.add(tileChoice);
                        if (button.isSelected()){
                            stackH.setText(rb.getString("Current"));
                            label3.setText(rb.getString("hand"));
                            tileChoice.setText(rb.getString("pick"));
                            restTilesTitle.setText(rb.getString("rest"));
                            restTilesButton.setText(rb.getString("Take"));
                        }
                        button.removeActionListener(this);
                        button.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e){
                                rb = ResourceBundle.getBundle("domino.Gr");
                                newGame.setText(rb.getString("New"));
                                rules.setText(rb.getString("Rules"));
                                stackH.setText(rb.getString("Current"));
                                label3.setText(rb.getString("hand"));
                                tileChoice.setText(rb.getString("pick"));
                                restTilesTitle.setText(rb.getString("rest"));
                                restTilesButton.setText(rb.getString("Take"));
                            }
                        });
                        button2.removeActionListener(this);
                        button2.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e){
                                rb2 = ResourceBundle.getBundle("domino.En");  
                                newGame.setText(rb2.getString("Καινούριο")); 
                                rules.setText(rb2.getString("Κανόνες"));
                                stackH.setText(rb2.getString("Τρέχουσα"));
                                label3.setText(rb2.getString("χέρι"));
                                tileChoice.setText(rb2.getString("Επέλεξε"));
                                restTilesTitle.setText(rb2.getString("Έξτρα"));
                                restTilesButton.setText(rb2.getString("Πάρε"));
                            }   
                        });
                        tileText=new JTextField("");
                        tileText.setColumns(5);
                        leftPanelInner2.add(tileText);
                        tileConfirm=new JButton(" OK ");
                        tileConfirm.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e){
                                try{
                                    if(Integer.parseInt(tileText.getText())>0&&Integer.parseInt(tileText.getText())<=tmp3){
                                        playerPlays3bot(Integer.parseInt(tileText.getText()));   
                                    }else{
                                        if (button.isSelected()){
                                            JOptionPane.showMessageDialog(null, "Άκυρη επιλογή.","Error",JOptionPane.ERROR_MESSAGE);
                                        }else if(button2.isSelected()){
                                            JOptionPane.showMessageDialog(null, "Invalid selection.","Error",JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                }catch (NumberFormatException q){
                                    if (button.isSelected()){
                                        JOptionPane.showMessageDialog(null, "Παρακαλώ βάλε έναν έγκυρο αριθμό.","Error",JOptionPane.ERROR_MESSAGE);
                                    }else if(button2.isSelected()){
                                        JOptionPane.showMessageDialog(null, "Please put a valid number.","Error",JOptionPane.ERROR_MESSAGE);
                                    }
                                    tileText.setText("");
                                }
                            }
                        });
                        leftPanelInner2.add(tileConfirm);
                        leftPanel.revalidate();
                    }
                }
            }       
         });
        rules=new JButton("Rules");
        rules.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (button.isSelected()){
                    JOptionPane.showMessageDialog(null, "Solo1 mode:\n\n"+"Μόνο το πιο δεξί πλακίδιο κάθε σειράς μπορεί να παιχτεί.\n"+"Άρχισε επιλέγοντας την σειρά που θες.\n"+
                        "Κάθε πλακίδιο τοποθετείται στην στοίβα, εφόσον οι πλευρές του ταιριάζουν με την πρώτη ή την τελευταία πλευρά της στοίβας.\n"+
                        "Αν δεν υπάρχουν πλακίδια που να ταιριάζουν, χάνεις.\n"+"Αν καταφέρεις να αδειάσεις το τραπέζι, κερδίζεις!\n\n\n"+"Hungarian mode:\n\n"+"Παίζεις ενάντια σε ένα μποτ.\n"+
                        "Σε κάθε γύρο δίνονται από 12 πλακίδια στις παίχτες.\n"+"Ο παίχτης με το υψηλότερο διπλό ξεκινάει.\n"+
                        "Κάθε πλακίδιο τοποθετείται στην στοίβα, εφόσον οι πλευρές του ταιριάζουν με την πρώτη ή την τελευταία πλευρά της στοίβας.\n"+
                        "Ο παίχτης που παίζει τελευταίος ή αδειάζει το χέρι του πρώτος κερδίζει τον γύρο και παίρνει το σκορ του αντίπαλου χεριού.\n"+
                        "Στόχος σου να φτάσεις 100 πόντου πρώτος.\n\n\n"+"All 7 mode:\n\n"+"Παίζεις ενάντια σε 1,2 ή 3 μποτ.\n"+
                        "Παίζεις πρώτος.\n"+"Σε κάθε γύρο πρέπει να παίξεις ένα πλακίδιο. Αν δεν έχεις κάποιο έγκυρο τραβάς αυτόματα από τα Έξτρα Πλακίδια μέχρι "+
                        "να μπορέσεις να παίξεις.\n"+"Ενδιάμεσα μπορείς να τραβήξεις από τα Έξτρα Πλακίδια όποτε θες, πρέπει όμως να μείνουν σε αυτά τουλάχιστον 2 πλακίδια.\n"+
                        "Τα πλακίδια πρέπει να τοποθετούνται έτσι ώστε οι δύο πλευρές τους που ακουμπούν, να έχουν άθροισμα 7.\n"+
                        "Τα διπλά λευκά και όλα τα πλακίδια των οποίων το σύνολο των πόντων είναι ο αριθμός 7 είναι μπαλαντέρ και μπορούν πάντα να τοποθετούνται.\n" +
                        "Ο γύρος τελειώνει όταν ένας παίκτης τοποθετήσει όλα του τα πλακίδια ή όταν κανένας παίκτης δεν μπορεί να τοποθετήσει πλακίδια.\nΟ παίκτης που έχει τους λιγότερους" +
                        " πόντους κερδίζει τον γύρο.\n"+"Ο νικητής κάθε γύρου μαζεύει τους πόντους των χεριών των αντιπάλων του.\n"+
                        "Σκοπός σου να φτάσεις πρώτος 100 πόντους.\n\n"+"Καλά να περάσεις!","Rules",JOptionPane.PLAIN_MESSAGE);
                }else if(button2.isSelected()){
                    JOptionPane.showMessageDialog(null, "Solo1 mode:\n\n"+"Only the very right tile of each row can be played.\n"+"Start by selecting the row you want.\n"+
                        "Each tile is placed in the stack, as long as its sides match with the stack's first or last side.\n"+"If there are no matching tiles, you lose.\n"+
                        "If you manage to empty the table ,you win!\n\n\n"+"Hungarian mode:\n\n"+"You play against a bot.\n"+
                        "For every round the players are given 12 tiles each.\n"+"The player with the highest double plays first.\n"+
                        "Each tile is placed in the stack, as long as its sides match with the stack's first or last side.\n"+
                        "The player who plays last or empties his hand first wins the round and takes the opponent's hand score.\n"+
                        "Your goal is to reach 100 points first.\n\n\n"+"All 7 mode:\n\n"+"You play against 1,2 or 3 bots.\n"+
                        "You play first.\n"+"You need to play a tile each round. If you don't have any valid ones you drag from Extra tiles until you can play.\n"+
                        "You can drag from Extra Tiles whenever you want, however Extra Tiles got to have at least 2 tiles in total.\n"+
                        "Tiles must be placed so the two sides that unite make a total of 7.\n"+
                        "The double-white tile and all the tiles that make a total of 7 are wildcards and can be placed at anytime.\n"+
                        "The round ends when a player/bot plays all his tiles or when noone can add to the stack.\n"+
                        "The player with the fewest points wins the round.\n"+
                        "The winner of the round gets all the hand points of his opponents.\n"+
                        "Your goal is to hit 100 points first.\n\n"+"Have fun!","Rules",JOptionPane.PLAIN_MESSAGE);
                }               
            }
        });
        JLabel empty=new JLabel("                        ");
        topPanel.add(newGame,0);
        topPanel.add(rules,1);  
        topPanel.add(empty,2);
        frame.add(topPanel, BorderLayout.PAGE_START);  
        frame.add(leftPanel, BorderLayout.LINE_START);
        frame.add(centerPanel,BorderLayout.CENTER);
        frame.add(endPanel,BorderLayout.PAGE_END);
        frame.setVisible(true);
    }
    
    /**
     * The main method of the game, starting a new videogame.
     * @param args the arguments.
     */
    public static void main(String[] args){
        videoGame game=new videoGame();
    }
    
    /**
     * This method gets the right tile of the chosen row used in the Solo1 mode.
     * @param value the chosen row.
     */
    public void getRight(int value){
        chosenRow=value;
        if(value-1>=0 && value-1<=3 && !gameOver()){
            SingleTile tile=game.table.getRight(value);
            if (tile!=null){
                if (value-1==0){
                    tilesLabel1[row1].setIcon(null);
                    row1--;
                }else if(value-1==1){
                    tilesLabel2[row2].setIcon(null);
                    row2--;
                }else if(value-1==2){
                    tilesLabel3[row3].setIcon(null);
                    row3--;
                }else if(value-1==3){
                    tilesLabel4[row4].setIcon(null);
                    row4--;
                }
                addToStack(tile);
            }else if(tile==null){
                if (button.isSelected()){
                    JOptionPane.showMessageDialog(null, "Άδεια γραμμή","Error",JOptionPane.ERROR_MESSAGE);
                }else if(button2.isSelected()){
                    JOptionPane.showMessageDialog(null, "Empty row.","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }else if(value-1<0 || value-1>3){
            if (button.isSelected()){
                JOptionPane.showMessageDialog(null, "Άκυρη γραμμή.","Error",JOptionPane.ERROR_MESSAGE);
            }else if(button2.isSelected()){
                JOptionPane.showMessageDialog(null, "Invalid row.","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    /**
     * This method is executed if the game is over or there are no more valid tiles to play.
     * @return a <code>boolean</code> showing if the game is over.
     */
   public boolean gameOver(){
        boolean gameover=false;
        int counter=0;
        SingleTile tile2;
            for (int i=1;i<5;i++){
                if (getSize()!=0){
                    tile2=game.table.getRight(i);
                    if (tile2!=null){
                        int s1=tile2.getSide1();
                        int s2=tile2.getSide2();
                        int last=getLast();
                        int first=getFirst();
                        if (s1!=last && s1!=first && s2!= last && s2!=first ){
                                counter++;
                        }
                        game.table.returnTile(tile2, i);
                        
                }else if(game.table.getRight(i)==null){
                    counter++;
                }
             }
            }
        if (counter==4){
            gameover=true;
        }   
        return gameover;
   }
   
   /**
    * Adds the given tile to the stack used in the Solo1 and Hungarian mode.
    * @param tile the given tile.
    */
    public void addToStack(SingleTile tile){
        int s1=tile.getSide1();
        int s2=tile.getSide2();
        boolean canPut=false;
        if (stack.isEmpty()){
            stack.add(s1);
            stack.add(s2);
            tilesPlaced[q]=new JLabel();
            endPanel.add(tilesPlaced[q]);
            String imgName = "/images/" +tile.getSide1()+tile.getSide2()+".jpg";
            URL imageURL = getClass().getResource(imgName);
            ImageIcon icon = new ImageIcon(imageURL);                       
            tilesPlaced[q].setIcon(icon);
            q++;
            canPut=true;
        }else{
            if ((stack.get(0)==s1 && stack.get(stack.size()-1)==s2)||(stack.get(0)==s2 && stack.get(stack.size()-1)==s1)){
                
                if (button.isSelected()){
                    String[] buttons2={"Αριστερά","Δεξιά"};
                    result2=JOptionPane.showOptionDialog(null,"Επέλεξε την πλευρά που θες να το βάλεις.",null,JOptionPane.NO_OPTION,0,null,buttons2,buttons2); 
                }else if(button2.isSelected()){
                    String[] buttons2={"Left","Right"};
                    result2=JOptionPane.showOptionDialog(null,"Choose the side you want to put it.",null,JOptionPane.NO_OPTION,0,null,buttons2,buttons2);  
                }
                if (result2==0){
                    if(stack.get(0)==s1){
                        stack.add(0,s2);
                        stack.add(1,s1);
                        tilesPlaced[q]=new JLabel();
                        endPanel.add(tilesPlaced[q],1);
                        String imgName = "/images/" +tile.getSide2()+tile.getSide1()+".jpg";
                        URL imageURL = getClass().getResource(imgName);
                        ImageIcon icon = new ImageIcon(imageURL);                       
                        tilesPlaced[q].setIcon(icon);
                        q++;
                        if(gameOver()){
                            if (button.isSelected()){
                                JOptionPane.showMessageDialog(null, "Δεν υπάρχουν έγκυρα πλακίδια..! Έχασες.","Error",JOptionPane.ERROR_MESSAGE);
                            }else if(button2.isSelected()){
                                JOptionPane.showMessageDialog(null, "No more valid tiles..! You Lost.","Error",JOptionPane.ERROR_MESSAGE);  
                            }
                            leftPanel.removeAll();
                            centerPanel.removeAll();
                            endPanel.removeAll();
                            frame.repaint();
                        }
                        if(game.table.gameWon()){
                            if (button.isSelected()){
                                JOptionPane.showMessageDialog(null, "Συγχαρητήρια..! Κέρδισες!","Winner winner chicken dinner!",JOptionPane.INFORMATION_MESSAGE);
                            }else if(button2.isSelected()){
                                JOptionPane.showMessageDialog(null, "Congratulations..! You Won!","Winner winner chicken dinner!",JOptionPane.INFORMATION_MESSAGE);  
                            }
                            leftPanel.removeAll();
                            centerPanel.removeAll();
                            endPanel.removeAll();
                            frame.repaint();
                        }
                        canPut=true;
                    }else if(stack.get(0)==s2){
                        stack.add(0,s1);
                        stack.add(1,s2);
                        tilesPlaced[q]=new JLabel();
                        endPanel.add(tilesPlaced[q],1,1);
                        String imgName = "/images/" +tile.getSide1()+tile.getSide2()+".jpg";
                        URL imageURL = getClass().getResource(imgName);
                        ImageIcon icon = new ImageIcon(imageURL);                       
                        tilesPlaced[q].setIcon(icon);
                        q++;
                        if(gameOver()){
                            if (button.isSelected()){
                                JOptionPane.showMessageDialog(null, "Δεν υπάρχουν έγκυρα πλακίδια..! Έχασες.","Error",JOptionPane.ERROR_MESSAGE);
                            }else if(button2.isSelected()){
                                JOptionPane.showMessageDialog(null, "No more valid tiles..! You Lost.","Error",JOptionPane.ERROR_MESSAGE);  
                            }
                            leftPanel.removeAll();
                            centerPanel.removeAll();
                            endPanel.removeAll();
                            frame.repaint();
                        }
                        if(game.table.gameWon()){
                            if (button.isSelected()){
                                JOptionPane.showMessageDialog(null, "Συγχαρητήρια..! Κέρδισες!","Winner winner chicken dinner!",JOptionPane.INFORMATION_MESSAGE);
                            }else if(button2.isSelected()){
                                JOptionPane.showMessageDialog(null, "Congratulations..! You Won!","Winner winner chicken dinner!",JOptionPane.INFORMATION_MESSAGE);  
                            }
                            leftPanel.removeAll();
                            centerPanel.removeAll();
                            endPanel.removeAll();
                            frame.repaint();
                        }
                        canPut=true;   
                    }
                }else if(result2==1){
                    if(stack.get(stack.size()-1)==s1){
                        stack.add(s1);
                        stack.add(s2);
                        tilesPlaced[q]=new JLabel();
                        endPanel.add(tilesPlaced[q]);
                        String imgName = "/images/" +tile.getSide1()+tile.getSide2()+".jpg";
                        URL imageURL = getClass().getResource(imgName);
                        ImageIcon icon = new ImageIcon(imageURL);                       
                        tilesPlaced[q].setIcon(icon);
                        q++;
                        if(gameOver()){
                            if (button.isSelected()){
                                JOptionPane.showMessageDialog(null, "Δεν υπάρχουν έγκυρα πλακίδια..! Έχασες.","Error",JOptionPane.ERROR_MESSAGE);
                            }else if(button2.isSelected()){
                                JOptionPane.showMessageDialog(null, "No more valid tiles..! You Lost.","Error",JOptionPane.ERROR_MESSAGE);  
                            }
                            leftPanel.removeAll();
                            centerPanel.removeAll();
                            endPanel.removeAll();
                            frame.repaint();
                        }
                        if(game.table.gameWon()){
                            if (button.isSelected()){
                                JOptionPane.showMessageDialog(null, "Συγχαρητήρια..! Κέρδισες!","Winner winner chicken dinner!",JOptionPane.INFORMATION_MESSAGE);
                            }else if(button2.isSelected()){
                                JOptionPane.showMessageDialog(null, "Congratulations..! You Won!","Winner winner chicken dinner!",JOptionPane.INFORMATION_MESSAGE);  
                            }
                            leftPanel.removeAll();
                            centerPanel.removeAll();
                            endPanel.removeAll();
                            frame.repaint();
                        }
                        canPut=true;
                    }else if(stack.get(stack.size()-1)==s2){
                        stack.add(s2);
                        stack.add(s1);
                        tilesPlaced[q]=new JLabel();
                        endPanel.add(tilesPlaced[q]);
                        String imgName = "/images/" +tile.getSide2()+tile.getSide1()+".jpg";
                        URL imageURL = getClass().getResource(imgName);
                        ImageIcon icon = new ImageIcon(imageURL);                       
                        tilesPlaced[q].setIcon(icon);
                        q++;
                        if(gameOver()){
                            if (button.isSelected()){
                                JOptionPane.showMessageDialog(null, "Δεν υπάρχουν έγκυρα πλακίδια..! Έχασες.","Error",JOptionPane.ERROR_MESSAGE);
                            }else if(button2.isSelected()){
                                JOptionPane.showMessageDialog(null, "No more valid tiles..! You Lost.","Error",JOptionPane.ERROR_MESSAGE);  
                            }
                            leftPanel.removeAll();
                            centerPanel.removeAll();
                            endPanel.removeAll();
                            frame.repaint();
                        }
                        if(game.table.gameWon()){
                            if (button.isSelected()){
                                JOptionPane.showMessageDialog(null, "Συγχαρητήρια..! Κέρδισες!","Winner winner chicken dinner!",JOptionPane.INFORMATION_MESSAGE);
                            }else if(button2.isSelected()){
                                JOptionPane.showMessageDialog(null, "Congratulations..! You Won!","Winner winner chicken dinner!",JOptionPane.INFORMATION_MESSAGE);  
                            }
                            leftPanel.removeAll();
                            centerPanel.removeAll();
                            endPanel.removeAll();
                            frame.repaint();
                        }
                        canPut=true;
                    }
                }
            }else{
                if (stack.get(0)==s1){
                    stack.add(0,s2);
                    stack.add(1,s1);
                    tilesPlaced[q]=new JLabel();
                    endPanel.add(tilesPlaced[q],1);
                    String imgName = "/images/" +tile.getSide2()+tile.getSide1()+".jpg";
                    URL imageURL = getClass().getResource(imgName);
                    ImageIcon icon = new ImageIcon(imageURL);                       
                    tilesPlaced[q].setIcon(icon);
                    q++;
                    if(gameOver()){
                            if (button.isSelected()){
                                JOptionPane.showMessageDialog(null, "Δεν υπάρχουν έγκυρα πλακίδια..! Έχασες.","Error",JOptionPane.ERROR_MESSAGE);
                            }else if(button2.isSelected()){
                                JOptionPane.showMessageDialog(null, "No more valid tiles..! You Lost.","Error",JOptionPane.ERROR_MESSAGE);  
                            }
                        leftPanel.removeAll();
                        centerPanel.removeAll();
                        endPanel.removeAll();
                        frame.repaint();
                    }
                    if(game.table.gameWon()){
                        if (button.isSelected()){
                            JOptionPane.showMessageDialog(null, "Συγχαρητήρια..! Κέρδισες!","Winner winner chicken dinner!",JOptionPane.INFORMATION_MESSAGE);
                        }else if(button2.isSelected()){
                            JOptionPane.showMessageDialog(null, "Congratulations..! You Won!","Winner winner chicken dinner!",JOptionPane.INFORMATION_MESSAGE);  
                        }
                        leftPanel.removeAll();
                        centerPanel.removeAll();
                        endPanel.removeAll();
                        frame.repaint();
                    }
                    canPut=true;
                }else if(stack.get(0)==s2){
                    stack.add(0,s1);
                    stack.add(1,s2);
                    tilesPlaced[q]=new JLabel();
                    endPanel.add(tilesPlaced[q],1);
                    String imgName = "/images/" +tile.getSide1()+tile.getSide2()+".jpg";
                    URL imageURL = getClass().getResource(imgName);
                    ImageIcon icon = new ImageIcon(imageURL);                       
                    tilesPlaced[q].setIcon(icon);
                    q++;
                    if(gameOver()){
                        if (button.isSelected()){
                            JOptionPane.showMessageDialog(null, "Δεν υπάρχουν έγκυρα πλακίδια..! Έχασες.","Error",JOptionPane.ERROR_MESSAGE);
                        }else if(button2.isSelected()){
                            JOptionPane.showMessageDialog(null, "No more valid tiles..! You Lost.","Error",JOptionPane.ERROR_MESSAGE);  
                        }
                        leftPanel.removeAll();
                        centerPanel.removeAll();
                        endPanel.removeAll();
                        frame.repaint();
                    }
                    if(game.table.gameWon()){
                        if (button.isSelected()){
                            JOptionPane.showMessageDialog(null, "Συγχαρητήρια..! Κέρδισες!","Winner winner chicken dinner!",JOptionPane.INFORMATION_MESSAGE);
                        }else if(button2.isSelected()){
                            JOptionPane.showMessageDialog(null, "Congratulations..! You Won!","Winner winner chicken dinner!",JOptionPane.INFORMATION_MESSAGE);  
                        }
                        leftPanel.removeAll();
                        centerPanel.removeAll();
                        endPanel.removeAll();
                        frame.repaint();
                    }
                    canPut=true;
                }else if(stack.get(stack.size()-1)==s1){
                    stack.add(s1);
                    stack.add(s2);
                    tilesPlaced[q]=new JLabel();
                    endPanel.add(tilesPlaced[q]);
                    String imgName = "/images/" +tile.getSide1()+tile.getSide2()+".jpg";
                    URL imageURL = getClass().getResource(imgName);
                    ImageIcon icon = new ImageIcon(imageURL);                       
                    tilesPlaced[q].setIcon(icon);
                    q++;
                    if(gameOver()){
                        if (button.isSelected()){
                            JOptionPane.showMessageDialog(null, "Δεν υπάρχουν έγκυρα πλακίδια..! Έχασες.","Error",JOptionPane.ERROR_MESSAGE);
                        }else if(button2.isSelected()){
                            JOptionPane.showMessageDialog(null, "No more valid tiles..! You Lost.","Error",JOptionPane.ERROR_MESSAGE);  
                        }
                        leftPanel.removeAll();
                        centerPanel.removeAll();
                        endPanel.removeAll();
                        frame.repaint();
                    }
                    if(game.table.gameWon()){
                        if (button.isSelected()){
                            JOptionPane.showMessageDialog(null, "Συγχαρητήρια..! Κέρδισες!","Winner winner chicken dinner!",JOptionPane.INFORMATION_MESSAGE);
                        }else if(button2.isSelected()){
                            JOptionPane.showMessageDialog(null, "Congratulations..! You Won!","Winner winner chicken dinner!",JOptionPane.INFORMATION_MESSAGE);  
                        }
                        leftPanel.removeAll();
                        centerPanel.removeAll();
                        endPanel.removeAll();
                        frame.repaint();
                    }
                    canPut=true;
                }else if(stack.get(stack.size()-1)==s2){
                    stack.add(s2);
                    stack.add(s1);
                    tilesPlaced[q]=new JLabel();
                    endPanel.add(tilesPlaced[q]);
                    String imgName = "/images/" +tile.getSide2()+tile.getSide1()+".jpg";
                    URL imageURL = getClass().getResource(imgName);
                    ImageIcon icon = new ImageIcon(imageURL);                       
                    tilesPlaced[q].setIcon(icon);
                    q++;
                    if(gameOver()){
                        if (button.isSelected()){
                            JOptionPane.showMessageDialog(null, "Δεν υπάρχουν έγκυρα πλακίδια..! Έχασες.","Error",JOptionPane.ERROR_MESSAGE);
                        }else if(button2.isSelected()){
                            JOptionPane.showMessageDialog(null, "No more valid tiles..! You Lost.","Error",JOptionPane.ERROR_MESSAGE);  
                        }
                        leftPanel.removeAll();
                        centerPanel.removeAll();
                        endPanel.removeAll();
                        frame.repaint();
                    }
                    if(game.table.gameWon()){
                        if (button.isSelected()){
                            JOptionPane.showMessageDialog(null, "Συγχαρητήρια..! Κέρδισες!","Winner winner chicken dinner!",JOptionPane.INFORMATION_MESSAGE);
                        }else if(button2.isSelected()){
                            JOptionPane.showMessageDialog(null, "Congratulations..! You Won!","Winner winner chicken dinner!",JOptionPane.INFORMATION_MESSAGE);  
                        }
                        leftPanel.removeAll();
                        centerPanel.removeAll();
                        endPanel.removeAll();
                        frame.repaint();
                    }
                    canPut=true;
                }
            }
        }
        if (!canPut){
            String imgName = "/images/" +tile.getSide1()+tile.getSide2()+".jpg";
            URL imageURL = getClass().getResource(imgName);
            ImageIcon icon = new ImageIcon(imageURL);  
            if (chosenRow-1==0){
                row1++;
                tilesLabel1[row1].setIcon(icon);
            }else if(chosenRow-1==1){
                    row2++;
                    tilesLabel2[row2].setIcon(icon);
            }else if(chosenRow-1==2){
                    row3++;
                    tilesLabel3[row3].setIcon(icon);
            }else if(chosenRow-1==3){
                    row4++;
                    tilesLabel4[row4].setIcon(icon);
            }
            game.table.returnTile(tile, chosenRow);
            if (button.isSelected()){
                JOptionPane.showMessageDialog(null, "Άκυρη γραμμή.","Error",JOptionPane.ERROR_MESSAGE);
            }else if(button2.isSelected()){
                JOptionPane.showMessageDialog(null, "Invalid row.","Error",JOptionPane.ERROR_MESSAGE); 
            }
        }
    }
    /**
     * Gets the last tile of the stack.
     * @return an <code>integer</code> representing desired tile.
     * @see ArrayList#get(int) 
     */
    public int getLast(){
        return stack.get(stack.size()-1);
    }
    
    /**
     * Gets the first tile of the stack.
     * @return an <code>integer</code> representing the desired tile.
     * @see ArrayList#get(int) 
     */
    public int getFirst(){
        return stack.get(0);
    }
    
    /**
     * Gets the size of the stack.
     * @return an <code>integer</code> representing the size.
     * @see ArrayList#get(int) 
     */
    public int getSize(){
        return stack.size();
    }
    
    /**
     * Shows if the round is over used in the Solo1 and Hungarian mode.
     * @return a <code>boolean</code> showing if the round is over.
     */
    public boolean roundIsOver(){
        boolean roundIsOver=true;
        SingleTile btile;
        if(getSize()==0){
            roundIsOver=false;
        }else if (getSize()!=0){
            for(int i=1;i<=game.player.getSize();i++){
                btile=game.player.getTile(i);
                int s1=btile.getSide1();
                int s2=btile.getSide2();
                int last=getLast();
                int first=getFirst();
                if (s1==last || s1==first || s2==last || s2==first){
                    roundIsOver=false;
                }
                game.player.returnTile(i-1, btile);
            }
        }
        return roundIsOver;
     }
    /**
     * This method is used when the player plays.
     * @param value the value of the tile the player wants to play.
     */
    public void playerPlays(int value){
        if(!botWon){
            playerTurn=true;
            boolean didPlayerPlay=false;
            SingleTile atile;
            if (!game.player.isHandEmpty() && !roundIsOver()){
                       atile=game.player.getTile(value);
                       addToStackH(atile);
                       if(getCheck()){
                           playerHandLabel[value-1].setIcon(null);
                           for (int i=value;i<=tmp2;i++){
                               JLabel tmp=new JLabel();
                               tmp.setIcon(playerHandLabel[i].getIcon());
                               playerHandLabel[i-1].setIcon(tmp.getIcon());
                           }
                           playerHandLabel[tmp2].setIcon(null);
                           tmp2--;
                           tmp3--;
                       }
                       if (!getCheck()){
                            if (button.isSelected()){
                                JOptionPane.showMessageDialog(null, "Άκυρο πλακίδιο.","Error",JOptionPane.ERROR_MESSAGE);
                            }else if(button2.isSelected()){
                                JOptionPane.showMessageDialog(null, "Invalid tile.","Error",JOptionPane.ERROR_MESSAGE);
                            }
                            game.player.returnTile(value-1,atile);
                        }
                       didPlayerPlay=true;
            }
            if(game.player.isHandEmpty()||roundIsOver()){
                       if (didPlayerPlay){
                           playerCounter++;
                       }
                       if (game.player.isHandEmpty()){
                           playerWon=true;
                       }
                       playerTurn=false;
            }
            tileText.setText("");
            if (!playerTurn && !playerWon){
                botPlays();
            }
        }
        if(roundIsOver()||botWon||playerWon){
            if (didPlayerStart){ 
                if (playerCounter>botCounter || playerWon ){
                    pScore+=game.bot.getScore();
                    playerScore.setText("Your Score: "+Integer.toString(pScore));
                    if (pScore<100){
                        nextRound();
                    }
                }else if(playerCounter==botCounter || playerCounter<botCounter || botWon){
                    bScore+=game.player.getScore();
                    botScore.setText("Bot Score: "+Integer.toString(bScore));
                    if (bScore<100){
                        nextRound();
                    }
                }
            }else if(!didPlayerStart){
                if (playerCounter==botCounter || playerCounter>botCounter || playerWon ){
                    pScore+=game.bot.getScore();
                    playerScore.setText("Your Score: "+Integer.toString(pScore));
                    if (pScore<100){
                        nextRound();
                    }
                }else if( playerCounter<botCounter || botWon){
                    bScore+=game.player.getScore();
                    botScore.setText("Bot Score: "+Integer.toString(bScore));
                    if (bScore<100){
                        nextRound();
                    }
                }
            }
            if (pScore>=100){
                if (button.isSelected()){
                    JOptionPane.showMessageDialog(null, "Συγχαρητήρια..! Κέρδισες!","Winner winner chicken dinner!",JOptionPane.INFORMATION_MESSAGE);
                }else if(button2.isSelected()){
                    JOptionPane.showMessageDialog(null, "Congratulations..! You Won!","Winner winner chicken dinner!",JOptionPane.INFORMATION_MESSAGE);  
                }
                leftPanel.removeAll();
                centerPanel.removeAll();
                endPanel.removeAll();
                frame.repaint();
            }
             if (bScore>=100){
                if (button.isSelected()){
                    JOptionPane.showMessageDialog(null, "Καλύτερη τύχη την επόμενη φορά..! Έχασες.","Error",JOptionPane.ERROR_MESSAGE);
                }else if(button2.isSelected()){
                    JOptionPane.showMessageDialog(null, "Better luck next time..! You Lost.","Error",JOptionPane.ERROR_MESSAGE);  
                }
                leftPanel.removeAll();
                centerPanel.removeAll();
                endPanel.removeAll();
                frame.repaint();
            }
         }
    }
    /**
     * This method is used when a single bot plays.
     */
    public void botPlays(){
        if (button.isSelected()){
            JOptionPane.showMessageDialog(null, "Σειρά του Bot.","",JOptionPane.INFORMATION_MESSAGE);
        }else if(button2.isSelected()){
            JOptionPane.showMessageDialog(null, "Bot's Turn.","",JOptionPane.INFORMATION_MESSAGE); 
        } 
         didBotPlay=false;
         canBotPlay=true;
         if (getSize()==0){
             addToStackAsBot(game.bot.getTile(1));
             didBotPlay=true;
         }
         while(canBotPlay && !game.bot.isHandEmpty()){
            int i=1;
            do{
                SingleTile gtile=game.bot.getTile(i);
                addToStackAsBot(gtile);
                if (getCheck()==false){
                    game.bot.returnTile(i-1,gtile);
                }
                i++;
            }while (i<=game.bot.getSize() && getCheck()==false);
            if (getCheck()==true){
                    didBotPlay=true;
                 }
            if (getCheck()==false){
                 canBotPlay=false;   
            }
         }
         if(didBotPlay){
             botCounter++;
         }
         if (game.bot.isHandEmpty()){
             botWon=true;
         } 
         if (button.isSelected()){
            JOptionPane.showMessageDialog(null, "Η σειρά του Bot τέλειωσε.","",JOptionPane.INFORMATION_MESSAGE); 
        }else if(button2.isSelected()){
            JOptionPane.showMessageDialog(null, "Bot's Turn Over.","",JOptionPane.INFORMATION_MESSAGE); 
        }
        frame.revalidate();
     }
    
    /**
     * Adds the tile to the stack when the bot plays in the Solo1 or Hungarian mode.
     * @param tile the given tile.
     */
    public void addToStackAsBot(SingleTile tile){
        int s1=tile.getSide1();
        int s2=tile.getSide2();
        boolean canPut=false;
        if (stack.isEmpty()){
            stack.add(s1);
            stack.add(s2);
            tilesPlaced[q]=new JLabel();
            centerPanel.add(tilesPlaced[q],1);
            String imgName = "/images/" +tile.getSide1()+tile.getSide2()+".jpg";
            URL imageURL = getClass().getResource(imgName);
            ImageIcon icon = new ImageIcon(imageURL);                       
            tilesPlaced[q].setIcon(icon);
            q++;
            canPut=true;
        }else{
                if (stack.get(0)==s1){
                    stack.add(0,s2);
                    stack.add(1,s1);
                    tilesPlaced[q]=new JLabel();
                    centerPanel.add(tilesPlaced[q],1);
                    String imgName = "/images/" +tile.getSide2()+tile.getSide1()+".jpg";
                    URL imageURL = getClass().getResource(imgName);
                    ImageIcon icon = new ImageIcon(imageURL);                       
                    tilesPlaced[q].setIcon(icon);
                    q++;
                    canPut=true;
                }else if(stack.get(0)==s2){
                    stack.add(0,s1);
                    stack.add(1,s2);
                    tilesPlaced[q]=new JLabel();
                    centerPanel.add(tilesPlaced[q],1);
                    String imgName = "/images/" +tile.getSide1()+tile.getSide2()+".jpg";
                    URL imageURL = getClass().getResource(imgName);
                    ImageIcon icon = new ImageIcon(imageURL);                       
                    tilesPlaced[q].setIcon(icon);
                    q++;
                    canPut=true;
                }else if(stack.get(stack.size()-1)==s1){
                    stack.add(s1);
                    stack.add(s2);
                    tilesPlaced[q]=new JLabel();
                    centerPanel.add(tilesPlaced[q]);
                    String imgName = "/images/" +tile.getSide1()+tile.getSide2()+".jpg";
                    URL imageURL = getClass().getResource(imgName);
                    ImageIcon icon = new ImageIcon(imageURL);                       
                    tilesPlaced[q].setIcon(icon);
                    q++;
                    canPut=true;
                }else if(stack.get(stack.size()-1)==s2){
                    stack.add(s2);
                    stack.add(s1);
                    tilesPlaced[q]=new JLabel();
                    centerPanel.add(tilesPlaced[q]);
                    String imgName = "/images/" +tile.getSide2()+tile.getSide1()+".jpg";
                    URL imageURL = getClass().getResource(imgName);
                    ImageIcon icon = new ImageIcon(imageURL);                       
                    tilesPlaced[q].setIcon(icon);
                    q++;
                    canPut=true;
                }
            }  

        check=canPut;
    }   
    
    /**
     * Adds the tile to the stack used in the Hungarian mode.
     * @param tile the given tile.
     */
    public void addToStackH(SingleTile tile){
        int s1=tile.getSide1();
        int s2=tile.getSide2();
        boolean canPut=false;
        if (stack.isEmpty()){
            stack.add(s1);
            stack.add(s2);
            tilesPlaced[q]=new JLabel();
            centerPanel.add(tilesPlaced[q],1);
            String imgName = "/images/" +tile.getSide1()+tile.getSide2()+".jpg";
            URL imageURL = getClass().getResource(imgName);
            ImageIcon icon = new ImageIcon(imageURL);                       
            tilesPlaced[q].setIcon(icon);
            q++;
            canPut=true;
        }else{
            if ((stack.get(0)==s1 && stack.get(stack.size()-1)==s2)||(stack.get(0)==s2 && stack.get(stack.size()-1)==s1)){
                if (button.isSelected()){ 
                    String[] buttons2={"Αριστερά","Δεξιά"};
                    result2=JOptionPane.showOptionDialog(null,"Επέλεξε την πλευρά που θες να το βάλεις.",null,JOptionPane.NO_OPTION,0,null,buttons2,buttons2); 
                }else if(button2.isSelected()){
                    String[] buttons2={"Left","Right"};
                    result2=JOptionPane.showOptionDialog(null,"Choose the side you want to put it.",null,JOptionPane.NO_OPTION,0,null,buttons2,buttons2); 
                }
                if (result2==0){
                    if(stack.get(0)==s1){
                        stack.add(0,s2);
                        stack.add(1,s1);
                        tilesPlaced[q]=new JLabel();
                        centerPanel.add(tilesPlaced[q],1);
                        String imgName = "/images/" +tile.getSide2()+tile.getSide1()+".jpg";
                        URL imageURL = getClass().getResource(imgName);
                        ImageIcon icon = new ImageIcon(imageURL);                       
                        tilesPlaced[q].setIcon(icon);
                        q++;
                        canPut=true;
                    }else if(stack.get(0)==s2){
                        stack.add(0,s1);
                        stack.add(1,s2);
                        tilesPlaced[q]=new JLabel();
                        centerPanel.add(tilesPlaced[q],1);
                        String imgName = "/images/" +tile.getSide1()+tile.getSide2()+".jpg";
                        URL imageURL = getClass().getResource(imgName);
                        ImageIcon icon = new ImageIcon(imageURL);                       
                        tilesPlaced[q].setIcon(icon);
                        q++;
                        canPut=true;   
                    }
                }else if(result2==1){
                    if(stack.get(stack.size()-1)==s1){
                        stack.add(s1);
                        stack.add(s2);
                        tilesPlaced[q]=new JLabel();
                        centerPanel.add(tilesPlaced[q]);
                        String imgName = "/images/" +tile.getSide1()+tile.getSide2()+".jpg";
                        URL imageURL = getClass().getResource(imgName);
                        ImageIcon icon = new ImageIcon(imageURL);                       
                        tilesPlaced[q].setIcon(icon);
                        q++;
                        canPut=true;
                    }else if(stack.get(stack.size()-1)==s2){
                        stack.add(s2);
                        stack.add(s1);
                        tilesPlaced[q]=new JLabel();
                        centerPanel.add(tilesPlaced[q]);
                        String imgName = "/images/" +tile.getSide2()+tile.getSide1()+".jpg";
                        URL imageURL = getClass().getResource(imgName);
                        ImageIcon icon = new ImageIcon(imageURL);                       
                        tilesPlaced[q].setIcon(icon);
                        q++;
                        canPut=true;
                    }
                }
            }else{
                if (stack.get(0)==s1){
                    stack.add(0,s2);
                    stack.add(1,s1);
                    tilesPlaced[q]=new JLabel();
                    centerPanel.add(tilesPlaced[q],1);
                    String imgName = "/images/" +tile.getSide2()+tile.getSide1()+".jpg";
                    URL imageURL = getClass().getResource(imgName);
                    ImageIcon icon = new ImageIcon(imageURL);                       
                    tilesPlaced[q].setIcon(icon);
                    q++;
                    canPut=true;
                }else if(stack.get(0)==s2){
                    stack.add(0,s1);
                    stack.add(1,s2);
                    tilesPlaced[q]=new JLabel();
                    centerPanel.add(tilesPlaced[q],1);
                    String imgName = "/images/" +tile.getSide1()+tile.getSide2()+".jpg";
                    URL imageURL = getClass().getResource(imgName);
                    ImageIcon icon = new ImageIcon(imageURL);                       
                    tilesPlaced[q].setIcon(icon);
                    q++;
                    canPut=true;
                }else if(stack.get(stack.size()-1)==s1){
                    stack.add(s1);
                    stack.add(s2);
                    tilesPlaced[q]=new JLabel();
                    centerPanel.add(tilesPlaced[q]);
                    String imgName = "/images/" +tile.getSide1()+tile.getSide2()+".jpg";
                    URL imageURL = getClass().getResource(imgName);
                    ImageIcon icon = new ImageIcon(imageURL);                       
                    tilesPlaced[q].setIcon(icon);
                    q++;
                    canPut=true;
                }else if(stack.get(stack.size()-1)==s2){
                    stack.add(s2);
                    stack.add(s1);
                    tilesPlaced[q]=new JLabel();
                    centerPanel.add(tilesPlaced[q]);
                    String imgName = "/images/" +tile.getSide2()+tile.getSide1()+".jpg";
                    URL imageURL = getClass().getResource(imgName);
                    ImageIcon icon = new ImageIcon(imageURL);                       
                    tilesPlaced[q].setIcon(icon);
                    q++;
                    canPut=true;
                }
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
     * This method initiates if the next round begins in the Solo1 or the Hungarian mode.
     */
    public void nextRound(){
        stack=new ArrayList<>();        
        for(int i=0;i<q;i++){
            centerPanel.remove(tilesPlaced[i]);
        }
        centerPanel.revalidate();
        for(int i=0;i<game.player.getSize();i++){
            playerHandLabel[i].setIcon(null);
        }
        game=new Game();
        q=0;
        tmp2=11;
        tmp3=12;
        playerCounter=0;
        botCounter=0;
        botWon=false;
        playerWon=false;
        game.player.getHand(game.table.tiles.getPlayerHand());
        game.bot.getHand(game.table.tiles.getBotHand());
        for (int i=0;i<=11;i++){
            SingleTile tile2=game.player.getTile(i+1);
            game.player.returnTile(i,tile2);
            String imgName = "/images/" +tile2.getSide1()+tile2.getSide2()+".jpg";
            URL imageURL = getClass().getResource(imgName);
            ImageIcon icon = new ImageIcon(imageURL);                       
            playerHandLabel[i].setIcon(icon);
        }
        didPlayerStart=game.table.tiles.playerFirst();
        if(didPlayerStart==false){
            botPlays();
        }
    }
    
    /**
     * This method is initiated when the players plays in the All7 mode.
     * @param value the value of the tile.
     */
    public void playerPlays7(int value) {
        playerTurn=true;
        SingleTile atile;
        atile=player.getTile(value);
        addToStack7(atile);
        boolean canPlayerPlay=true;
        if(getCheck()){
            playerHandLabel[value-1].setIcon(null);
            for (int i=value;i<=tmp2;i++){
                JLabel tmp=new JLabel();
                tmp.setIcon(playerHandLabel[i].getIcon());
                playerHandLabel[i-1].setIcon(tmp.getIcon());
            }
            playerHandLabel[tmp2].setIcon(null);
            endInner2.revalidate();
            tmp2--;
            tmp3--;
            playerTurn=false;
        }
        if (!getCheck()){
            player.returnTile(value-1,atile);
            if (button.isSelected()){
                JOptionPane.showMessageDialog(null, "Άκυρο πλακίδιο.","Error",JOptionPane.ERROR_MESSAGE);
            }else if(button2.isSelected()){
                JOptionPane.showMessageDialog(null, "Invalid tile.","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        if(player.isHandEmpty()){
            playerWon=true;
        }
        tileText.setText("");
        if (!playerTurn && !playerWon){
            botPlays7();
        }
        if(!botWon && !playerWon){
            while(restTiles.size()>2 && roundIsOver7()){
                if (button.isSelected()){
                    JOptionPane.showMessageDialog(null, "Δεν έχεις έγκυρα πλακίδια, τραβάς αυτόματα από τα Έξτρα Πλακίδια.","Error",JOptionPane.ERROR_MESSAGE);
                }else if(button2.isSelected()){
                    JOptionPane.showMessageDialog(null, "You don't have any valid tiles, you automatically drag from Extra Tiles.","Error",JOptionPane.ERROR_MESSAGE);
                }
                player.returnTile(player.getSize(), restTiles.get(restTiles.size()-1));
                String imgName = "/images/" +restTiles.get(restTiles.size()-1).getSide1()+restTiles.get(restTiles.size()-1).getSide2()+".jpg";
                URL imageURL = getClass().getResource(imgName);
                ImageIcon icon = new ImageIcon(imageURL);
                playerHandLabel[tmp2+1]=new JLabel();
                endInner2.add(playerHandLabel[tmp2+1],tmp2+2);
                playerHandLabel[tmp2+1].setIcon(icon);
                restTilesLabel[restTiles.size()-1].setIcon(null);
                restTiles.remove(restTiles.get(restTiles.size()-1));
                endPanel.revalidate();
                tmp2++;
                tmp3++;
            }
            if(roundIsOver7()){
                canPlayerPlay=false;
                if (didBotPlay){
                    botPlays7();
                }
            }
        }
        if(playerWon || botWon || (!canPlayerPlay && !canBotPlay)){
            if (player.getScore()<bot.getScore()){
                pScore+=bot.getScore();
                if (button.isSelected()){
                    JOptionPane.showMessageDialog(null, "Κέρδισες αυτόν τον γύρο!\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot's Hand Score: "
                            +Integer.toString(bot.getScore()),null,JOptionPane.INFORMATION_MESSAGE);
                }else if(button2.isSelected()){
                    JOptionPane.showMessageDialog(null, "You won this round!\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot's Hand Score: "
                            +Integer.toString(bot.getScore()),null,JOptionPane.INFORMATION_MESSAGE);  
                }
                playerScore.setText("Your Score: "+Integer.toString(pScore));
                if (pScore<100){
                    nextRound7();
                }
            }else if(player.getScore()>bot.getScore()){
                bScore+=player.getScore();
                if (button.isSelected()){
                    JOptionPane.showMessageDialog(null, "Έχασες αυτόν τον γύρο.\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot's Hand Score: "
                            +Integer.toString(bot.getScore()),"Error",JOptionPane.ERROR_MESSAGE);
                }else if(button2.isSelected()){
                    JOptionPane.showMessageDialog(null, "You lost this round.\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot's Hand Score: "
                            +Integer.toString(bot.getScore()),"Error",JOptionPane.ERROR_MESSAGE);  
                }
                botScore.setText("Bot Score: "+Integer.toString(bScore));
                if (bScore<100){
                    nextRound7();
                }
            }else if (player.getScore()==bot.getScore()){
                if (button.isSelected()){
                    JOptionPane.showMessageDialog(null, "Ισοπαλία!\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot's Hand Score: "
                            +Integer.toString(bot.getScore()),null,JOptionPane.INFORMATION_MESSAGE);
                }else if(button2.isSelected()){
                    JOptionPane.showMessageDialog(null, "Draw!\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot's Hand Score: "
                            +Integer.toString(bot.getScore()),null,JOptionPane.INFORMATION_MESSAGE);  
                }
            }
            if (pScore>=100){
                if (button.isSelected()){
                    JOptionPane.showMessageDialog(null, "Συγχαρητήρια..! Κέρδισες!","Winner winner chicken dinner!",JOptionPane.INFORMATION_MESSAGE);
                }else if(button2.isSelected()){
                    JOptionPane.showMessageDialog(null, "Congratulations..! You Won!","Winner winner chicken dinner!",JOptionPane.INFORMATION_MESSAGE);  
                }
                leftPanel.removeAll();
                centerPanel.removeAll();
                endPanel.removeAll();
                frame.repaint();
            }
             if (bScore>=100){
                if (button.isSelected()){
                    JOptionPane.showMessageDialog(null, "Καλύτερη τύχη την επόμενη φορά..! Έχασες.","Error",JOptionPane.ERROR_MESSAGE);
                }else if(button2.isSelected()){
                    JOptionPane.showMessageDialog(null, "Better luck next time..! You Lost.","Error",JOptionPane.ERROR_MESSAGE);  
                }
                leftPanel.removeAll();
                centerPanel.removeAll();
                endPanel.removeAll();
                frame.repaint();
            }
         }
    }
    
    /**
     * Adds the given tile to the stack used in All7 mode.
     * @param tile the given tile.
     */
    public void addToStack7(SingleTile tile){
        int s1=tile.getSide1();
        int s2=tile.getSide2();
        boolean canPut=false;
        if (stack.isEmpty()){
            stack.add(s1);
            stack.add(s2);
            tilesPlaced[q]=new JLabel();
            centerPanel.add(tilesPlaced[q],1);
            String imgName = "/images/" +tile.getSide1()+tile.getSide2()+".jpg";
            URL imageURL = getClass().getResource(imgName);
            ImageIcon icon = new ImageIcon(imageURL);                       
            tilesPlaced[q].setIcon(icon);
            q++;
            canPut=true;
        }else{
            if ((s1+s2==7)||((s1==0)&&(s2==0))){
                if (button.isSelected()){ 
                    String[] buttons2={"Αριστερά","Δεξιά"};
                    result3=JOptionPane.showOptionDialog(null,"Επέλεξε την πλευρά που θες να το βάλεις.",null,JOptionPane.NO_OPTION,0,null,buttons2,buttons2); 
                }else if(button2.isSelected()){
                    String[] buttons2={"Left","Right"};
                    result3=JOptionPane.showOptionDialog(null,"Choose the side you want to put it.",null,JOptionPane.NO_OPTION,0,null,buttons2,buttons2); 
                }
                if (result3==0){
                    stack.add(0,s1);
                    stack.add(1,s2);
                    tilesPlaced[q]=new JLabel();
                    centerPanel.add(tilesPlaced[q],1);
                    String imgName = "/images/" +tile.getSide1()+tile.getSide2()+".jpg";
                    URL imageURL = getClass().getResource(imgName);
                    ImageIcon icon = new ImageIcon(imageURL);                       
                    tilesPlaced[q].setIcon(icon);
                    q++;
                    canPut=true;   
                }else if(result3==1){
                    stack.add(s1);
                    stack.add(s2);
                    tilesPlaced[q]=new JLabel();
                    centerPanel.add(tilesPlaced[q]);
                    String imgName = "/images/" +tile.getSide1()+tile.getSide2()+".jpg";
                    URL imageURL = getClass().getResource(imgName);
                    ImageIcon icon = new ImageIcon(imageURL);                       
                    tilesPlaced[q].setIcon(icon);
                    q++;
                    canPut=true;
                }
            }else if((stack.get(0)+stack.get(1)==7)||(stack.get(stack.size()-1)+stack.get(stack.size()-2)==7)||(stack.get(0)+stack.get(1)==0)||(stack.get(stack.size()-1)+stack.get(stack.size()-2)==0)){
                if((stack.get(0)+stack.get(1)==7||(stack.get(0)+stack.get(1)==0))&&(stack.get(stack.size()-1)+stack.get(stack.size()-2)==7||(stack.get(stack.size()-1)+stack.get(stack.size()-2)==0))){
                    if (button.isSelected()){ 
                        String[] buttons2={"Αριστερά","Δεξιά"};
                        result3=JOptionPane.showOptionDialog(null,"Επέλεξε την πλευρά που θες να το βάλεις.",null,JOptionPane.NO_OPTION,0,null,buttons2,buttons2); 
                    }else if(button2.isSelected()){
                        String[] buttons2={"Left","Right"};
                        result3=JOptionPane.showOptionDialog(null,"Choose the side you want to put it.",null,JOptionPane.NO_OPTION,0,null,buttons2,buttons2); 
                    }
                    if (s1!=s2){
                        if (button.isSelected()){                         
                            String[] buttons2={"Κανονικά","Ανάποδα"};
                            result4=JOptionPane.showOptionDialog(null,"Επέλεξε πως θες να βάλεις το πλακίδιο δίπλα στο μπαλαντέρ:",null,JOptionPane.NO_OPTION,0,null,buttons2,buttons2); 
                        }else if(button2.isSelected()){
                            String[] buttons2={"Normally","Backwards"};
                            result4=JOptionPane.showOptionDialog(null,"Choose how you want to put the tile next to the wild card.",null,JOptionPane.NO_OPTION,0,null,buttons2,buttons2); 
                        }     
                    }else{
                        result4=0;
                    }
                    if(result3==0&&result4==0){
                        stack.add(0,s1);
                        stack.add(1,s2);
                        tilesPlaced[q]=new JLabel();
                        centerPanel.add(tilesPlaced[q],1);
                        String imgName = "/images/" +tile.getSide1()+tile.getSide2()+".jpg";
                        URL imageURL = getClass().getResource(imgName);
                        ImageIcon icon = new ImageIcon(imageURL);                       
                        tilesPlaced[q].setIcon(icon);
                        q++;
                        canPut=true;  
                    }
                    if(result3==0&&result4==1){
                        stack.add(0,s2);
                        stack.add(1,s1);
                        tilesPlaced[q]=new JLabel();
                        centerPanel.add(tilesPlaced[q],1);
                        String imgName = "/images/" +tile.getSide2()+tile.getSide1()+".jpg";
                        URL imageURL = getClass().getResource(imgName);
                        ImageIcon icon = new ImageIcon(imageURL);                       
                        tilesPlaced[q].setIcon(icon);
                        q++;
                        canPut=true;   
                    }
                    if(result3==1&&result4==0){
                        stack.add(s1);
                        stack.add(s2);
                        tilesPlaced[q]=new JLabel();
                        centerPanel.add(tilesPlaced[q]);
                        String imgName = "/images/" +tile.getSide1()+tile.getSide2()+".jpg";
                        URL imageURL = getClass().getResource(imgName);
                        ImageIcon icon = new ImageIcon(imageURL);                       
                        tilesPlaced[q].setIcon(icon);
                        q++;
                        canPut=true;
                    }
                    if(result3==1&&result4==1){
                        stack.add(s2);
                        stack.add(s1);
                        tilesPlaced[q]=new JLabel();
                        centerPanel.add(tilesPlaced[q]);
                        String imgName = "/images/" +tile.getSide2()+tile.getSide1()+".jpg";
                        URL imageURL = getClass().getResource(imgName);
                        ImageIcon icon = new ImageIcon(imageURL);                       
                        tilesPlaced[q].setIcon(icon);
                        q++;
                        canPut=true;
                    }
                }else if(((stack.get(0)+stack.get(1)==7)||(stack.get(0)+stack.get(1)==0))&&((stack.get(stack.size()-1)+s1==7)||(stack.get(stack.size()-1)+s2==7))){
                    if (button.isSelected()){ 
                        String[] buttons2={"Αριστερά","Δεξιά"};
                        result3=JOptionPane.showOptionDialog(null,"Επέλεξε την πλευρά που θες να το βάλεις.",null,JOptionPane.NO_OPTION,0,null,buttons2,buttons2); 
                    }else if(button2.isSelected()){
                        String[] buttons2={"Left","Right"};
                        result3=JOptionPane.showOptionDialog(null,"Choose the side you want to put it.",null,JOptionPane.NO_OPTION,0,null,buttons2,buttons2); 
                    }
                    if(result3==0){
                        if(s1!=s2){
                            if (button.isSelected()){                         
                                String[] buttons2={"Κανονικά","Ανάποδα"};
                                result4=JOptionPane.showOptionDialog(null,"Επέλεξε πως θες να βάλεις το πλακίδιο δίπλα στο μπαλαντέρ:",null,JOptionPane.NO_OPTION,0,null,buttons2,buttons2); 
                            }else if(button2.isSelected()){
                                String[] buttons2={"Normally","Backwards"};
                                result4=JOptionPane.showOptionDialog(null,"Choose how you want to put the tile next to the wild card.",null,JOptionPane.NO_OPTION,0,null,buttons2,buttons2); 
                            } 
                        }else{
                            result4=0;
                        }
                        if(result4==1){
                            stack.add(0,s2);
                            stack.add(1,s1);
                            tilesPlaced[q]=new JLabel();
                            centerPanel.add(tilesPlaced[q],1);
                            String imgName = "/images/" +tile.getSide2()+tile.getSide1()+".jpg";
                            URL imageURL = getClass().getResource(imgName);
                            ImageIcon icon = new ImageIcon(imageURL);                       
                            tilesPlaced[q].setIcon(icon);
                            q++;
                            canPut=true;
                        }else if(result4==0){
                            stack.add(0,s1);
                            stack.add(1,s2);
                            tilesPlaced[q]=new JLabel();
                            centerPanel.add(tilesPlaced[q],1);
                            String imgName = "/images/" +tile.getSide1()+tile.getSide2()+".jpg";
                            URL imageURL = getClass().getResource(imgName);
                            ImageIcon icon = new ImageIcon(imageURL);                       
                            tilesPlaced[q].setIcon(icon);
                            q++;
                            canPut=true;   
                        }
                    }else if(result3==1){
                         if(stack.get(stack.size()-1)+s1==7){
                            stack.add(s1);
                            stack.add(s2);
                            tilesPlaced[q]=new JLabel();
                            centerPanel.add(tilesPlaced[q]);
                            String imgName = "/images/" +tile.getSide1()+tile.getSide2()+".jpg";
                            URL imageURL = getClass().getResource(imgName);
                            ImageIcon icon = new ImageIcon(imageURL);                       
                            tilesPlaced[q].setIcon(icon);
                            q++;
                            canPut=true;                             
                         }else if(stack.get(stack.size()-1)+s2==7){
                            stack.add(s2);
                            stack.add(s1);
                            tilesPlaced[q]=new JLabel();
                            centerPanel.add(tilesPlaced[q]);
                            String imgName = "/images/" +tile.getSide2()+tile.getSide1()+".jpg";
                            URL imageURL = getClass().getResource(imgName);
                            ImageIcon icon = new ImageIcon(imageURL);                       
                            tilesPlaced[q].setIcon(icon);
                            q++;
                            canPut=true;                             
                         }
                    }
                }else if(((stack.get(stack.size()-1)+stack.get(stack.size()-2)==7)||(stack.get(stack.size()-1)+stack.get(stack.size()-2)==0))&&
                        ((stack.get(0)+s1==7)||(stack.get(0)+s2==7))){
                    if (button.isSelected()){ 
                        String[] buttons2={"Αριστερά","Δεξιά"};
                        result3=JOptionPane.showOptionDialog(null,"Επέλεξε την πλευρά που θες να το βάλεις.",null,JOptionPane.NO_OPTION,0,null,buttons2,buttons2); 
                    }else if(button2.isSelected()){
                        String[] buttons2={"Left","Right"};
                        result3=JOptionPane.showOptionDialog(null,"Choose the side you want to put it.",null,JOptionPane.NO_OPTION,0,null,buttons2,buttons2); 
                    }
                    if(result3==0){
                        if(stack.get(0)+s1==7){
                            stack.add(0,s2);
                            stack.add(1,s1);
                            tilesPlaced[q]=new JLabel();
                            centerPanel.add(tilesPlaced[q],1);
                            String imgName = "/images/" +tile.getSide2()+tile.getSide1()+".jpg";
                            URL imageURL = getClass().getResource(imgName);
                            ImageIcon icon = new ImageIcon(imageURL);                       
                            tilesPlaced[q].setIcon(icon);
                            q++;
                            canPut=true;                            
                        }else if(stack.get(0)+s2==7){
                            stack.add(0,s1);
                            stack.add(1,s2);
                            tilesPlaced[q]=new JLabel();
                            centerPanel.add(tilesPlaced[q],1);
                            String imgName = "/images/" +tile.getSide1()+tile.getSide2()+".jpg";
                            URL imageURL = getClass().getResource(imgName);
                            ImageIcon icon = new ImageIcon(imageURL);                       
                            tilesPlaced[q].setIcon(icon);
                            q++;
                            canPut=true;                            
                        }
                    }else if(result3==1){
                        if(s1!=s2){
                            if (button.isSelected()){                         
                                String[] buttons2={"Κανονικά","Ανάποδα"};
                                result4=JOptionPane.showOptionDialog(null,"Επέλεξε πως θες να βάλεις το πλακίδιο δίπλα στο μπαλαντέρ:",null,JOptionPane.NO_OPTION,0,null,buttons2,buttons2); 
                            }else if(button2.isSelected()){
                                String[] buttons2={"Normally","Backwards"};
                                result4=JOptionPane.showOptionDialog(null,"Choose how you want to put the tile next to the wild card.",null,JOptionPane.NO_OPTION,0,null,buttons2,buttons2); 
                            }
                        }else{
                            result4=0;
                        }
                        if(result4==0){
                            stack.add(s1);
                            stack.add(s2);
                            tilesPlaced[q]=new JLabel();
                            centerPanel.add(tilesPlaced[q]);
                            String imgName = "/images/" +tile.getSide1()+tile.getSide2()+".jpg";
                            URL imageURL = getClass().getResource(imgName);
                            ImageIcon icon = new ImageIcon(imageURL);                       
                            tilesPlaced[q].setIcon(icon);
                            q++;
                            canPut=true;
                        }else if(result4==1){
                            stack.add(s2);
                            stack.add(s1);
                            tilesPlaced[q]=new JLabel();
                            centerPanel.add(tilesPlaced[q]);
                            String imgName = "/images/" +tile.getSide2()+tile.getSide1()+".jpg";
                            URL imageURL = getClass().getResource(imgName);
                            ImageIcon icon = new ImageIcon(imageURL);                       
                            tilesPlaced[q].setIcon(icon);
                            q++;
                            canPut=true;
                        }
                    }
                }else if((stack.get(0)+stack.get(1)==7)||(stack.get(0)+stack.get(1)==0)){
                    if(s1!=s2){
                        if (button.isSelected()){ 
                            String[] buttons2={"Κανονικά","Ανάποδα"};
                            result3=JOptionPane.showOptionDialog(null,"Επέλεξε πως θες να βάλεις το πλακίδιο δίπλα στο μπαλαντέρ:",null,JOptionPane.NO_OPTION,0,null,buttons2,buttons2); 
                        }else if(button2.isSelected()){
                            String[] buttons2={"Normally","Backwards"};
                            result3=JOptionPane.showOptionDialog(null,"Choose how you want to put the tile next to the wild card.",null,JOptionPane.NO_OPTION,0,null,buttons2,buttons2); 
                        }
                    }else{
                        result3=0;
                    }
                    if(result3==1){
                        stack.add(0,s2);
                        stack.add(1,s1);
                        tilesPlaced[q]=new JLabel();
                        centerPanel.add(tilesPlaced[q],1);
                        String imgName = "/images/" +tile.getSide2()+tile.getSide1()+".jpg";
                        URL imageURL = getClass().getResource(imgName);
                        ImageIcon icon = new ImageIcon(imageURL);                       
                        tilesPlaced[q].setIcon(icon);
                        q++;
                        canPut=true;
                    }else if(result3==0){
                        stack.add(0,s1);
                        stack.add(1,s2);
                        tilesPlaced[q]=new JLabel();
                        centerPanel.add(tilesPlaced[q],1);
                        String imgName = "/images/" +tile.getSide1()+tile.getSide2()+".jpg";
                        URL imageURL = getClass().getResource(imgName);
                        ImageIcon icon = new ImageIcon(imageURL);                       
                        tilesPlaced[q].setIcon(icon);
                        q++;
                        canPut=true;   
                    }
                }else if((stack.get(stack.size()-1)+stack.get(stack.size()-2)==7)||(stack.get(stack.size()-1)+stack.get(stack.size()-2)==0)){
                    if(s1!=s2){
                        if (button.isSelected()){ 
                            String[] buttons2={"Κανονικά","Ανάποδα"};
                            result3=JOptionPane.showOptionDialog(null,"Επέλεξε πως θες να βάλεις το πλακίδιο δίπλα στο μπαλαντέρ:",null,JOptionPane.NO_OPTION,0,null,buttons2,buttons2); 
                        }else if(button2.isSelected()){
                            String[] buttons2={"Normally","Backwards"};
                            result3=JOptionPane.showOptionDialog(null,"Choose how you want to put the tile next to the wild card.",null,JOptionPane.NO_OPTION,0,null,buttons2,buttons2); 
                        }
                    }else{
                        result3=0;
                    }
                    if(result3==0){
                        stack.add(s1);
                        stack.add(s2);
                        tilesPlaced[q]=new JLabel();
                        centerPanel.add(tilesPlaced[q]);
                        String imgName = "/images/" +tile.getSide1()+tile.getSide2()+".jpg";
                        URL imageURL = getClass().getResource(imgName);
                        ImageIcon icon = new ImageIcon(imageURL);                       
                        tilesPlaced[q].setIcon(icon);
                        q++;
                        canPut=true;
                    }else if(result3==1){
                        stack.add(s2);
                        stack.add(s1);
                        tilesPlaced[q]=new JLabel();
                        centerPanel.add(tilesPlaced[q]);
                        String imgName = "/images/" +tile.getSide2()+tile.getSide1()+".jpg";
                        URL imageURL = getClass().getResource(imgName);
                        ImageIcon icon = new ImageIcon(imageURL);                       
                        tilesPlaced[q].setIcon(icon);
                        q++;
                        canPut=true;
                    }
                }
            }else{
                if (stack.get(0)+s1==7){
                    stack.add(0,s2);
                    stack.add(1,s1);
                    tilesPlaced[q]=new JLabel();
                    centerPanel.add(tilesPlaced[q],1);
                    String imgName = "/images/" +tile.getSide2()+tile.getSide1()+".jpg";
                    URL imageURL = getClass().getResource(imgName);
                    ImageIcon icon = new ImageIcon(imageURL);                       
                    tilesPlaced[q].setIcon(icon);
                    q++;
                    canPut=true;
                }else if(stack.get(0)+s2==7){
                    stack.add(0,s1);
                    stack.add(1,s2);
                    tilesPlaced[q]=new JLabel();
                    centerPanel.add(tilesPlaced[q],1);
                    String imgName = "/images/" +tile.getSide1()+tile.getSide2()+".jpg";
                    URL imageURL = getClass().getResource(imgName);
                    ImageIcon icon = new ImageIcon(imageURL);                       
                    tilesPlaced[q].setIcon(icon);
                    q++;
                    canPut=true;
                }else if(stack.get(stack.size()-1)+s1==7){
                    stack.add(s1);
                    stack.add(s2);
                    tilesPlaced[q]=new JLabel();
                    centerPanel.add(tilesPlaced[q]);
                    String imgName = "/images/" +tile.getSide1()+tile.getSide2()+".jpg";
                    URL imageURL = getClass().getResource(imgName);
                    ImageIcon icon = new ImageIcon(imageURL);                       
                    tilesPlaced[q].setIcon(icon);
                    q++;
                    canPut=true;
                }else if(stack.get(stack.size()-1)+s2==7){
                    stack.add(s2);
                    stack.add(s1);
                    tilesPlaced[q]=new JLabel();
                    centerPanel.add(tilesPlaced[q]);
                    String imgName = "/images/" +tile.getSide2()+tile.getSide1()+".jpg";
                    URL imageURL = getClass().getResource(imgName);
                    ImageIcon icon = new ImageIcon(imageURL);                       
                    tilesPlaced[q].setIcon(icon);
                    q++;
                    canPut=true;
                }
            }  
        }
        check=canPut;
    }
    
    /**
     * This method is initiated when the round is over in the All7 mode.
     * @return a <code>boolean</code> showing if the round is over.
     */
    public boolean roundIsOver7(){
        boolean roundIsOver=true;
        SingleTile btile;
        if(getSize()==0){
            roundIsOver=false;
        }else if (getSize()!=0){
            for(int i=1;i<=player.getSize();i++){
                btile=player.getTile(i);
                int s1=btile.getSide1();
                int s2=btile.getSide2();
                if ((stack.get(0)+s1==7)||(stack.get(0)+s2==7)||(stack.get(stack.size()-1)+s1==7)||(stack.get(stack.size()-1)+s2==7)||(s1+s2==7)||(stack.get(0)+stack.get(1)==7)
                        ||(stack.get(stack.size()-1)+stack.get(stack.size()-2)==7)||(stack.get(0)+stack.get(1)==0)||(stack.get(stack.size()-1)+stack.get(stack.size()-2)==0)||(s1+s2==0)){
                    roundIsOver=false;
                }
                player.returnTile(i-1, btile);
            }
        }
        return roundIsOver;
     }
    
    /**
     * This method is initiated when the bot plays in the All7 mode.
     */
    public void botPlays7(){
        if (button.isSelected()){
            JOptionPane.showMessageDialog(null, "Σειρά του Bot.","",JOptionPane.INFORMATION_MESSAGE);
        }else if(button2.isSelected()){
            JOptionPane.showMessageDialog(null, "Bot's Turn.","",JOptionPane.INFORMATION_MESSAGE); 
        } 
         didBotPlay=false;
         canBotPlay=true;
         if (getSize()==0){
             addToStackAsBot7(bot.getTile(1));
             didBotPlay=true;
         }
         while(!didBotPlay && !bot.isHandEmpty() && canBotPlay){
            int i=1;
            do{
                SingleTile gtile=bot.getTile(i);
                addToStackAsBot7(gtile);
                if (getCheck()==false){
                    bot.returnTile(i-1,gtile);
                }
                i++;
            }while (i<=bot.getSize() && getCheck()==false);
            if (getCheck()==true){
                didBotPlay=true;
            }
            if (getCheck()==false){
                while(restTiles.size()>2 && !didBotPlay){
                    bot.returnTile(bot.getSize(), restTiles.get(restTiles.size()-1));
                    restTilesLabel[restTiles.size()-1].setIcon(null);
                    restTiles.remove(restTiles.get(restTiles.size()-1));
                    SingleTile gtile=bot.getTile(bot.getSize()-1);
                    addToStackAsBot7(gtile);
                    if(getCheck()==true){
                        didBotPlay=true;
                    }
                }
                if (!didBotPlay){
                    canBotPlay=false;
                 }
            }
         }
         if (bot.isHandEmpty()){
             botWon=true;
         } 
         if (button.isSelected()){
            JOptionPane.showMessageDialog(null, "Η σειρά του Bot τέλειωσε.","",JOptionPane.INFORMATION_MESSAGE); 
        }else if(button2.isSelected()){
            JOptionPane.showMessageDialog(null, "Bot's Turn Over.","",JOptionPane.INFORMATION_MESSAGE); 
        }
        frame.revalidate();
     }
    
    /**
     * Adds the tile to the stack when the bot plays used in the All7 mode.
     * @param tile the given tile.
     */
    public void addToStackAsBot7(SingleTile tile){
        int s1=tile.getSide1();
        int s2=tile.getSide2();
        boolean canPut=false;
        if (stack.isEmpty()){
            stack.add(s1);
            stack.add(s2);
            tilesPlaced[q]=new JLabel();
            centerPanel.add(tilesPlaced[q],1);
            String imgName = "/images/" +tile.getSide1()+tile.getSide2()+".jpg";
            URL imageURL = getClass().getResource(imgName);
            ImageIcon icon = new ImageIcon(imageURL);                       
            tilesPlaced[q].setIcon(icon);
            q++;
            canPut=true;
        }else{
            if ((s1+s2==7)||((s1==0)&&(s2==0))){
                stack.add(0,s1);
                stack.add(1,s2);
                tilesPlaced[q]=new JLabel();
                centerPanel.add(tilesPlaced[q],1);
                String imgName = "/images/" +tile.getSide1()+tile.getSide2()+".jpg";
                URL imageURL = getClass().getResource(imgName);
                ImageIcon icon = new ImageIcon(imageURL);                       
                tilesPlaced[q].setIcon(icon);
                q++;
                canPut=true;   
            }else if((stack.get(0)+stack.get(1)==7)||(stack.get(0)+stack.get(1)==0)){
                stack.add(0,s2);
                stack.add(1,s1);
                tilesPlaced[q]=new JLabel();
                centerPanel.add(tilesPlaced[q],1);
                String imgName = "/images/" +tile.getSide2()+tile.getSide1()+".jpg";
                URL imageURL = getClass().getResource(imgName);
                ImageIcon icon = new ImageIcon(imageURL);                       
                tilesPlaced[q].setIcon(icon);
                q++;
                canPut=true;
            }else if((stack.get(stack.size()-1)+stack.get(stack.size()-2)==7)||(stack.get(stack.size()-1)+stack.get(stack.size()-2)==0)){
                stack.add(s1);
                stack.add(s2);
                tilesPlaced[q]=new JLabel();
                centerPanel.add(tilesPlaced[q]);
                String imgName = "/images/" +tile.getSide1()+tile.getSide2()+".jpg";
                URL imageURL = getClass().getResource(imgName);
                ImageIcon icon = new ImageIcon(imageURL);                       
                tilesPlaced[q].setIcon(icon);
                q++;
                canPut=true;
            }else{
                if (stack.get(0)+s1==7){
                    stack.add(0,s2);
                    stack.add(1,s1);
                    tilesPlaced[q]=new JLabel();
                    centerPanel.add(tilesPlaced[q],1);
                    String imgName = "/images/" +tile.getSide2()+tile.getSide1()+".jpg";
                    URL imageURL = getClass().getResource(imgName);
                    ImageIcon icon = new ImageIcon(imageURL);                       
                    tilesPlaced[q].setIcon(icon);
                    q++;
                    canPut=true;
                }else if(stack.get(0)+s2==7){
                    stack.add(0,s1);
                    stack.add(1,s2);
                    tilesPlaced[q]=new JLabel();
                    centerPanel.add(tilesPlaced[q],1);
                    String imgName = "/images/" +tile.getSide1()+tile.getSide2()+".jpg";
                    URL imageURL = getClass().getResource(imgName);
                    ImageIcon icon = new ImageIcon(imageURL);                       
                    tilesPlaced[q].setIcon(icon);
                    q++;
                    canPut=true;
                }else if(stack.get(stack.size()-1)+s1==7){
                    stack.add(s1);
                    stack.add(s2);
                    tilesPlaced[q]=new JLabel();
                    centerPanel.add(tilesPlaced[q]);
                    String imgName = "/images/" +tile.getSide1()+tile.getSide2()+".jpg";
                    URL imageURL = getClass().getResource(imgName);
                    ImageIcon icon = new ImageIcon(imageURL);                       
                    tilesPlaced[q].setIcon(icon);
                    q++;
                    canPut=true;
                }else if(stack.get(stack.size()-1)+s2==7){
                    stack.add(s2);
                    stack.add(s1);
                    tilesPlaced[q]=new JLabel();
                    centerPanel.add(tilesPlaced[q]);
                    String imgName = "/images/" +tile.getSide2()+tile.getSide1()+".jpg";
                    URL imageURL = getClass().getResource(imgName);
                    ImageIcon icon = new ImageIcon(imageURL);                       
                    tilesPlaced[q].setIcon(icon);
                    q++;
                    canPut=true;
                }
            }  
        }
        check=canPut;
    }
    
    /**
     * This method is initiated when the next round begins in the All7 mode.
     */
    public void nextRound7(){
        stack=new ArrayList<>();        
        for(int i=0;i<q;i++){
            centerPanel.remove(tilesPlaced[i]);
        }
        centerPanel.revalidate();
        for(int i=0;i<player.getSize();i++){
            endInner2.remove(playerHandLabel[i]);
        }
        int k=restTiles.size();
        for(int i=0;i<k;i++){
            endInner1.remove(restTilesLabel[i]);
        }
        frame.revalidate();
        TilesAll7 tiles7=new TilesAll7();
        player=new Player();
        bot=new Player();
        stack=new ArrayList<>();
        restTiles=new ArrayList<>();
        q=0;
        tmp2=6;
        tmp3=7;
        botWon=false;
        playerWon=false;
        player.getHand(tiles7.getPtiles7());
        bot.getHand(tiles7.getBtiles7());
        for (int i=14;i<28;i++){
            SingleTile tile2=tiles7.getTile(i);
            restTiles.add(tile2);
            String imgName = "/images/" +tile2.getSide1()+tile2.getSide2()+".jpg";
            URL imageURL = getClass().getResource(imgName);
            ImageIcon icon = new ImageIcon(imageURL);  
            restTilesLabel[i-14]=new JLabel();
            endInner1.add(restTilesLabel[i-14],i-13);
            restTilesLabel[i-14].setIcon(icon);
        }
        for (int i=0;i<=6;i++){
            playerHandLabel[i]=new JLabel();
            endInner2.add(playerHandLabel[i],i+1);
            SingleTile tile2=player.getTile(i+1);
            player.returnTile(i,tile2);
            String imgName = "/images/" +tile2.getSide1()+tile2.getSide2()+".jpg";
            URL imageURL = getClass().getResource(imgName);
            ImageIcon icon = new ImageIcon(imageURL);                       
            playerHandLabel[i].setIcon(icon);
        }
        endInner1.remove(restTilesButton);
        restTilesButton=new JButton("Take from Extra");
         restTilesButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (restTiles.size()>2){
                    player.returnTile(player.getSize(), restTiles.get(restTiles.size()-1));
                    String imgName = "/images/" +restTiles.get(restTiles.size()-1).getSide1()+restTiles.get(restTiles.size()-1).getSide2()+".jpg";
                    URL imageURL = getClass().getResource(imgName);
                    ImageIcon icon = new ImageIcon(imageURL);
                    playerHandLabel[tmp2+1]=new JLabel();
                    endInner2.add(playerHandLabel[tmp2+1],tmp2+2);
                    playerHandLabel[tmp2+1].setIcon(icon);
                    restTilesLabel[restTiles.size()-1].setIcon(null);
                    restTiles.remove(restTiles.get(restTiles.size()-1));
                    tmp2++;
                    tmp3++;
                }else{
                    if (button.isSelected()){
                        JOptionPane.showMessageDialog(null, "Δεν μπορείς να πάρεις επιπλέον πλακίδια. Έφτασες το όριο.","Error",JOptionPane.ERROR_MESSAGE);
                    }else if(button2.isSelected()){
                        JOptionPane.showMessageDialog(null, "You can't take more tiles. You reached the limit.","Error",JOptionPane.ERROR_MESSAGE);
                    } 
                }
            }
        });
        endInner1.add(restTilesButton);
    } 
    
    /**
     * This method is executed when the player plays along with 2 bots.
     * @param value the value of the tile.
     */
    public void playerPlays2bot(int value){
        playerTurn=true;
        SingleTile atile;
        atile=player.getTile(value);
        addToStack7(atile);
        boolean canPlayerPlay=true;
        if(getCheck()){
            playerHandLabel[value-1].setIcon(null);
            for (int i=value;i<=tmp2;i++){
                JLabel tmp=new JLabel();
                tmp.setIcon(playerHandLabel[i].getIcon());
                playerHandLabel[i-1].setIcon(tmp.getIcon());
            }
            playerHandLabel[tmp2].setIcon(null);
            endInner2.revalidate();
            tmp2--;
            tmp3--;
            playerTurn=false;
        }
        if (!getCheck()){
            player.returnTile(value-1,atile);
            if (button.isSelected()){
                JOptionPane.showMessageDialog(null, "Άκυρο πλακίδιο.","Error",JOptionPane.ERROR_MESSAGE);
            }else if(button2.isSelected()){
                JOptionPane.showMessageDialog(null, "Invalid tile.","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        if(player.isHandEmpty()){
            playerWon=true;
        }
        tileText.setText("");
        if (!playerTurn && !playerWon){
            bot1Plays5();
        }
        if(!playerTurn && !playerWon && !bot1Won){
            bot2Plays5();
            if(roundIsOver7() && !bot2Won){
                while(restTiles.size()>2 && roundIsOver7()){
                    if (button.isSelected()){
                        JOptionPane.showMessageDialog(null, "Δεν έχεις έγκυρα πλακίδια, τραβάς αυτόματα από τα Έξτρα Πλακίδια.","Error",JOptionPane.ERROR_MESSAGE);
                    }else if(button2.isSelected()){
                        JOptionPane.showMessageDialog(null, "You don't have any valid tiles, you automatically drag from Extra Tiles.","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    player.returnTile(player.getSize(), restTiles.get(restTiles.size()-1));
                    String imgName = "/images/" +restTiles.get(restTiles.size()-1).getSide1()+restTiles.get(restTiles.size()-1).getSide2()+".jpg";
                    URL imageURL = getClass().getResource(imgName);
                    ImageIcon icon = new ImageIcon(imageURL);
                    playerHandLabel[tmp2+1]=new JLabel();
                    endInner2.add(playerHandLabel[tmp2+1],tmp2+2);
                    playerHandLabel[tmp2+1].setIcon(icon);
                    restTilesLabel[restTiles.size()-1].setIcon(null);
                    restTiles.remove(restTiles.get(restTiles.size()-1));
                    endPanel.revalidate();
                    tmp2++;
                    tmp3++;
                }
                if(roundIsOver7()){
                    canPlayerPlay=false;
                    if(didBot2Play){
                        bot1Plays5();
                        if(didBot1Play){
                            bot2Plays5();
                        }
                    }
                }
            }
        }
        if((roundIsOver7() && !canBot1Play && !canBot2Play) || bot1Won || bot2Won || playerWon){
            if ((player.getScore()<bot1.getScore())||(player.getScore()==bot1.getScore())){
                if (player.getScore()<bot2.getScore()){
                    pScore+=bot1.getScore()+bot2.getScore();
                    if (button.isSelected()){
                        JOptionPane.showMessageDialog(null, "Κέρδισες αυτόν τον γύρο!\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+Integer.toString(bot2.getScore()),null,JOptionPane.INFORMATION_MESSAGE);
                    }else if(button2.isSelected()){
                        JOptionPane.showMessageDialog(null, "You won this round!\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+Integer.toString(bot2.getScore()),null,JOptionPane.INFORMATION_MESSAGE);  
                    }
                    playerScore.setText("Your Score: "+Integer.toString(pScore));
                    if (pScore<100){
                        nextRound2bots();
                    }
                }else if(player.getScore()>bot2.getScore()){
                    b2Score+=player.getScore()+bot1.getScore();
                    if (button.isSelected()){
                        JOptionPane.showMessageDialog(null, "Έχασες αυτόν τον γύρο.\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+Integer.toString(bot2.getScore()),"Error",JOptionPane.ERROR_MESSAGE);
                    }else if(button2.isSelected()){
                        JOptionPane.showMessageDialog(null, "You lost this round.\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+Integer.toString(bot2.getScore()),"Error",JOptionPane.ERROR_MESSAGE);  
                    }
                    bot2Score.setText("    Bot2 Score: "+Integer.toString(b2Score));
                    if (b2Score<100){
                        nextRound2bots();
                    }
                }else if(bot1.getScore()==bot2.getScore()){
                    if (button.isSelected()){
                        JOptionPane.showMessageDialog(null, "Ισοπαλία!\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+Integer.toString(bot2.getScore()),null,JOptionPane.INFORMATION_MESSAGE);
                    }else if(button2.isSelected()){
                        JOptionPane.showMessageDialog(null, "Draw!\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+Integer.toString(bot2.getScore()),null,JOptionPane.INFORMATION_MESSAGE);  
                    }
                }
            }else if(player.getScore()>bot1.getScore()){
                if(bot1.getScore()<bot2.getScore()){
                    b1Score+=player.getScore()+bot2.getScore();
                    if (button.isSelected()){
                        JOptionPane.showMessageDialog(null, "Έχασες αυτόν τον γύρο.\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+Integer.toString(bot2.getScore()),"Error",JOptionPane.ERROR_MESSAGE);
                    }else if(button2.isSelected()){
                        JOptionPane.showMessageDialog(null, "You lost this round.\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+Integer.toString(bot2.getScore()),"Error",JOptionPane.ERROR_MESSAGE);  
                    }
                    bot1Score.setText("    Bot1 Score: "+Integer.toString(b1Score));
                    if (b1Score<100){
                        nextRound2bots();
                    }
                }else if(bot1.getScore()>bot2.getScore()){
                    b2Score+=player.getScore()+bot1.getScore();
                    if (button.isSelected()){
                        JOptionPane.showMessageDialog(null, "Έχασες αυτόν τον γύρο.\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+Integer.toString(bot2.getScore()),"Error",JOptionPane.ERROR_MESSAGE);
                    }else if(button2.isSelected()){
                        JOptionPane.showMessageDialog(null, "You lost this round.\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+Integer.toString(bot2.getScore()),"Error",JOptionPane.ERROR_MESSAGE);  
                    }
                    bot2Score.setText("    Bot2 Score: "+Integer.toString(b2Score));
                    if (b2Score<100){
                        nextRound2bots();
                    }
                }else if(bot1.getScore()==bot2.getScore()){
                    if (button.isSelected()){
                        JOptionPane.showMessageDialog(null, "Ισοπαλία!\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+Integer.toString(bot2.getScore()),null,JOptionPane.INFORMATION_MESSAGE);
                    }else if(button2.isSelected()){
                        JOptionPane.showMessageDialog(null, "Draw!\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+Integer.toString(bot2.getScore()),null,JOptionPane.INFORMATION_MESSAGE);  
                    }
                }
            }
            if (pScore>=100){
                if (button.isSelected()){
                    JOptionPane.showMessageDialog(null, "Συγχαρητήρια..! Κέρδισες!","Winner winner chicken dinner!",JOptionPane.INFORMATION_MESSAGE);
                }else if(button2.isSelected()){
                    JOptionPane.showMessageDialog(null, "Congratulations..! You Won!","Winner winner chicken dinner!",JOptionPane.INFORMATION_MESSAGE);  
                }
                leftPanel.removeAll();
                centerPanel.removeAll();
                endPanel.removeAll();
                frame.repaint();
            }
             if (b1Score>=100 || b2Score>=100){
                if (button.isSelected()){
                    JOptionPane.showMessageDialog(null, "Καλύτερη τύχη την επόμενη φορά..! Έχασες.","Error",JOptionPane.ERROR_MESSAGE);
                }else if(button2.isSelected()){
                    JOptionPane.showMessageDialog(null, "Better luck next time..! You Lost.","Error",JOptionPane.ERROR_MESSAGE);  
                }
                leftPanel.removeAll();
                centerPanel.removeAll();
                endPanel.removeAll();
                frame.repaint();
            }
         }
    }
    
    /**
     * This method is used when the first bot plays.
     */
    public void bot1Plays5(){
        if (button.isSelected()){
            JOptionPane.showMessageDialog(null, "Σειρά του Bot1.","",JOptionPane.INFORMATION_MESSAGE);
        }else if(button2.isSelected()){
            JOptionPane.showMessageDialog(null, "Bot1's Turn.","",JOptionPane.INFORMATION_MESSAGE); 
        } 
         didBot1Play=false;
         canBot1Play=true;
         if (getSize()==0){
             addToStackAsBot7(bot1.getTile(1));
             didBot1Play=true;
         }
         while(!didBot1Play && !bot1.isHandEmpty() && canBot1Play){
            int i=1;
            do{
                SingleTile gtile=bot1.getTile(i);
                addToStackAsBot7(gtile);
                if (getCheck()==false){
                    bot1.returnTile(i-1,gtile);
                }
                i++;
            }while (i<=bot1.getSize() && getCheck()==false);
            if (getCheck()==true){
                didBot1Play=true;
            }
            if (getCheck()==false){
                while(restTiles.size()>2 && !didBot1Play){
                    bot1.returnTile(bot1.getSize(), restTiles.get(restTiles.size()-1));
                    restTilesLabel[restTiles.size()-1].setIcon(null);
                    restTiles.remove(restTiles.get(restTiles.size()-1));
                    SingleTile gtile=bot1.getTile(bot1.getSize()-1);
                    addToStackAsBot7(gtile);
                    if(getCheck()==true){
                        didBot1Play=true;
                    }
                }
                if (!didBot1Play){
                    canBot1Play=false;
                 }
            }
         }
         if (bot1.isHandEmpty()){
             bot1Won=true;
         } 
         if (button.isSelected()){
            JOptionPane.showMessageDialog(null, "Η σειρά του Bot1 τέλειωσε.","",JOptionPane.INFORMATION_MESSAGE); 
        }else if(button2.isSelected()){
            JOptionPane.showMessageDialog(null, "Bot1's Turn Over.","",JOptionPane.INFORMATION_MESSAGE); 
        }
        frame.revalidate();
     }
    
    /**
     * This method is used when the second bot plays.
     */
    public void bot2Plays5(){
        if (button.isSelected()){
            JOptionPane.showMessageDialog(null, "Σειρά του Bot2.","",JOptionPane.INFORMATION_MESSAGE);
        }else if(button2.isSelected()){
            JOptionPane.showMessageDialog(null, "Bot2's Turn.","",JOptionPane.INFORMATION_MESSAGE); 
        } 
         didBot2Play=false;
         canBot2Play=true;
         if (getSize()==0){
             addToStackAsBot7(bot2.getTile(1));
             didBot2Play=true;
         }
         while(!didBot2Play && !bot2.isHandEmpty() && canBot2Play){
            int i=1;
            do{
                SingleTile gtile=bot2.getTile(i);
                addToStackAsBot7(gtile);
                if (getCheck()==false){
                    bot2.returnTile(i-1,gtile);
                }
                i++;
            }while (i<=bot2.getSize() && getCheck()==false);
            if (getCheck()==true){
                didBot2Play=true;
            }
            if (getCheck()==false){
                while(restTiles.size()>2 && !didBot2Play){
                    bot2.returnTile(bot2.getSize(), restTiles.get(restTiles.size()-1));
                    restTilesLabel[restTiles.size()-1].setIcon(null);
                    restTiles.remove(restTiles.get(restTiles.size()-1));
                    SingleTile gtile=bot2.getTile(bot2.getSize()-1);
                    addToStackAsBot7(gtile);
                    if(getCheck()==true){
                        didBot2Play=true;
                    }
                }
                if (!didBot2Play){
                    canBot2Play=false;
                 }
            }
         }
         if (bot2.isHandEmpty()){
             bot2Won=true;
         } 
         if (button.isSelected()){
            JOptionPane.showMessageDialog(null, "Η σειρά του Bot2 τέλειωσε.","",JOptionPane.INFORMATION_MESSAGE); 
        }else if(button2.isSelected()){
            JOptionPane.showMessageDialog(null, "Bot2's Turn Over.","",JOptionPane.INFORMATION_MESSAGE); 
        }
        frame.revalidate();
     }
    
    /**
     * This method is used when the third bot plays.
     */
    public void bot3Plays5(){
        if (button.isSelected()){
            JOptionPane.showMessageDialog(null, "Σειρά του Bot3.","",JOptionPane.INFORMATION_MESSAGE);
        }else if(button2.isSelected()){
            JOptionPane.showMessageDialog(null, "Bot3's Turn.","",JOptionPane.INFORMATION_MESSAGE); 
        } 
         didBot3Play=false;
         canBot3Play=true;
         if (getSize()==0){
             addToStackAsBot7(bot3.getTile(1));
             didBot3Play=true;
         }
         while(!didBot3Play && !bot3.isHandEmpty() && canBot3Play){
            int i=1;
            do{
                SingleTile gtile=bot3.getTile(i);
                addToStackAsBot7(gtile);
                if (getCheck()==false){
                    bot3.returnTile(i-1,gtile);
                }
                i++;
            }while (i<=bot3.getSize() && getCheck()==false);
            if (getCheck()==true){
                didBot3Play=true;
            }
            if (getCheck()==false){
                while(restTiles.size()>2 && !didBot3Play){
                    bot3.returnTile(bot3.getSize(), restTiles.get(restTiles.size()-1));
                    restTilesLabel[restTiles.size()-1].setIcon(null);
                    restTiles.remove(restTiles.get(restTiles.size()-1));
                    SingleTile gtile=bot3.getTile(bot3.getSize()-1);
                    addToStackAsBot7(gtile);
                    if(getCheck()==true){
                        didBot3Play=true;
                    }
                }
                if (!didBot3Play){
                    canBot3Play=false;
                 }
            }
         }
         if (bot3.isHandEmpty()){
             bot3Won=true;
         } 
         if (button.isSelected()){
            JOptionPane.showMessageDialog(null, "Η σειρά του Bot3 τέλειωσε.","",JOptionPane.INFORMATION_MESSAGE); 
        }else if(button2.isSelected()){
            JOptionPane.showMessageDialog(null, "Bot3's Turn Over.","",JOptionPane.INFORMATION_MESSAGE); 
        }
        frame.revalidate();
     }
    
    /**
     * This method is initiated when the next round begins while 2 bots are playing.
     */
    public void nextRound2bots(){
        stack=new ArrayList<>();        
        for(int i=0;i<q;i++){
            centerPanel.remove(tilesPlaced[i]);
            centerPanel.revalidate();
            centerPanel.repaint();
        }
        for(int i=0;i<player.getSize();i++){
            playerHandLabel[i].setIcon(null);
        }
        int k=restTiles.size();
        for(int i=0;i<k;i++){
            endInner1.remove(restTilesLabel[i]);
        }
        frame.revalidate();
        TilesAll7 tiles7=new TilesAll7();
        player=new Player();
        bot1=new Player();
        bot2=new Player();
        stack=new ArrayList<>();
        restTiles=new ArrayList<>();
        q=0;
        tmp2=4;
        tmp3=5;
        bot1Won=false;
        bot2Won=false;
        playerWon=false;
        player.getHand(tiles7.getPTiles5());
        bot1.getHand(tiles7.getB1Tiles5());
        bot2.getHand(tiles7.getB2Tiles5());
        for (int i=15;i<28;i++){
            SingleTile tile2=tiles7.getTile(i);
            restTiles.add(tile2);
            String imgName = "/images/" +tile2.getSide1()+tile2.getSide2()+".jpg";
            URL imageURL = getClass().getResource(imgName);
            ImageIcon icon = new ImageIcon(imageURL);  
            restTilesLabel[i-15]=new JLabel();
            endInner1.add(restTilesLabel[i-15]);
            restTilesLabel[i-15].setIcon(icon);
        }
        for (int i=0;i<=4;i++){
            SingleTile tile2=player.getTile(i+1);
            player.returnTile(i,tile2);
            String imgName = "/images/" +tile2.getSide1()+tile2.getSide2()+".jpg";
            URL imageURL = getClass().getResource(imgName);
            ImageIcon icon = new ImageIcon(imageURL);                       
            playerHandLabel[i].setIcon(icon);
        }
        endInner1.remove(restTilesButton);
        restTilesButton=new JButton(" Take from Extra ");
        restTilesButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (restTiles.size()>2){
                    player.returnTile(player.getSize(), restTiles.get(restTiles.size()-1));
                    String imgName = "/images/" +restTiles.get(restTiles.size()-1).getSide1()+restTiles.get(restTiles.size()-1).getSide2()+".jpg";
                    URL imageURL = getClass().getResource(imgName);
                    ImageIcon icon = new ImageIcon(imageURL);
                    playerHandLabel[tmp2+1]=new JLabel();
                    endInner2.add(playerHandLabel[tmp2+1],tmp2+2);
                    playerHandLabel[tmp2+1].setIcon(icon);
                    restTilesLabel[restTiles.size()-1].setIcon(null);
                    restTiles.remove(restTiles.get(restTiles.size()-1));
                    tmp2++;
                    tmp3++;
                }else{
                    if (button.isSelected()){
                        JOptionPane.showMessageDialog(null, "Δεν μπορείς να πάρεις επιπλέον πλακίδια. Έφτασες το όριο.","Error",JOptionPane.ERROR_MESSAGE);
                    }else if(button2.isSelected()){
                        JOptionPane.showMessageDialog(null, "You can't take more tiles. You reached the limit.","Error",JOptionPane.ERROR_MESSAGE);
                    } 
                }
            }
        });    
        endInner1.add(restTilesButton);
        frame.revalidate();
    }
    
    /**
     * This method is executed when the player plays along with 3 bots.
     * @param value the value of the tile.
     */
    public void playerPlays3bot(int value){
        playerTurn=true;
        SingleTile atile;
        atile=player.getTile(value);
        addToStack7(atile);
        boolean canPlayerPlay=true;
        if(getCheck()){
            playerHandLabel[value-1].setIcon(null);
            for (int i=value;i<=tmp2;i++){
                JLabel tmp=new JLabel();
                tmp.setIcon(playerHandLabel[i].getIcon());
                playerHandLabel[i-1].setIcon(tmp.getIcon());
            }
            playerHandLabel[tmp2].setIcon(null);
            endInner2.revalidate();
            tmp2--;
            tmp3--;
            playerTurn=false;
        }
        if (!getCheck()){
            player.returnTile(value-1,atile);
            if (button.isSelected()){
                JOptionPane.showMessageDialog(null, "Άκυρο πλακίδιο.","Error",JOptionPane.ERROR_MESSAGE);
            }else if(button2.isSelected()){
                JOptionPane.showMessageDialog(null, "Invalid tile.","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        if(player.isHandEmpty()){
            playerWon=true;
        }
        tileText.setText("");
        if (!playerTurn && !playerWon){
            bot1Plays5();
        }
        if(!playerTurn && !playerWon && !bot1Won){
            bot2Plays5();
        }
        if(!playerTurn && !playerWon && !bot1Won && !bot2Won){
            bot3Plays5();
            if(roundIsOver7() && !bot3Won){
                while(restTiles.size()>2 && roundIsOver7()){
                    if (button.isSelected()){
                        JOptionPane.showMessageDialog(null, "Δεν έχεις έγκυρα πλακίδια, τραβάς αυτόματα από τα Έξτρα Πλακίδια.","Error",JOptionPane.ERROR_MESSAGE);
                    }else if(button2.isSelected()){
                        JOptionPane.showMessageDialog(null, "You don't have any valid tiles, you automatically drag from Extra Tiles.","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    player.returnTile(player.getSize(), restTiles.get(restTiles.size()-1));
                    String imgName = "/images/" +restTiles.get(restTiles.size()-1).getSide1()+restTiles.get(restTiles.size()-1).getSide2()+".jpg";
                    URL imageURL = getClass().getResource(imgName);
                    ImageIcon icon = new ImageIcon(imageURL);
                    playerHandLabel[tmp2+1]=new JLabel();
                    endInner2.add(playerHandLabel[tmp2+1],tmp2+2);
                    playerHandLabel[tmp2+1].setIcon(icon);
                    restTilesLabel[restTiles.size()-1].setIcon(null);
                    restTiles.remove(restTiles.get(restTiles.size()-1));
                    endPanel.revalidate();
                    tmp2++;
                    tmp3++;
                }
                if(roundIsOver7()){
                    canPlayerPlay=false;
                    if(didBot3Play){
                        bot1Plays5();
                        if(didBot1Play){
                            bot2Plays5();
                            if(didBot2Play){
                                bot3Plays5();
                            }
                        }
                    }
                }
            }
        }
        if((roundIsOver7() && !canBot1Play && !canBot2Play && !canBot3Play) || bot1Won || bot2Won  || bot3Won || playerWon){
            if ((player.getScore()<bot1.getScore())||(player.getScore()==bot1.getScore())){
                if ((player.getScore()<bot2.getScore())||(player.getScore()==bot2.getScore())){
                    if(player.getScore()<bot3.getScore()){
                        pScore+=bot1.getScore()+bot2.getScore()+bot3.getScore();
                        if (button.isSelected()){
                            JOptionPane.showMessageDialog(null, "Κέρδισες αυτόν τον γύρο!\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                    +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+Integer.toString(bot2.getScore())+"\nBot3 Hand Score: "
                                    +Integer.toString(bot3.getScore()),null,JOptionPane.INFORMATION_MESSAGE);
                        }else if(button2.isSelected()){
                            JOptionPane.showMessageDialog(null, "You won this round!\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                    +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+Integer.toString(bot2.getScore())+"\nBot3 Hand Score: "
                                    +Integer.toString(bot3.getScore()),null,JOptionPane.INFORMATION_MESSAGE);  
                        }
                        playerScore.setText("Your Score: "+Integer.toString(pScore));
                        if (pScore<100){
                            nextRound3bots();
                        }
                    }else if (player.getScore()>bot3.getScore()){
                        b3Score+=player.getScore()+bot1.getScore()+bot2.getScore();
                        if (button.isSelected()){
                            JOptionPane.showMessageDialog(null, "Έχασες αυτόν τον γύρο.\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                    +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+"\nBot3 Hand Score: "
                                    +Integer.toString(bot3.getScore())+Integer.toString(bot2.getScore()),"Error",JOptionPane.ERROR_MESSAGE);
                        }else if(button2.isSelected()){
                            JOptionPane.showMessageDialog(null, "You lost this round.\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                    +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+Integer.toString(bot2.getScore())+"\nBot3 Hand Score: "
                                    +Integer.toString(bot3.getScore()),"Error",JOptionPane.ERROR_MESSAGE);  
                        }
                        bot3Score.setText("    Bot3 Score: "+Integer.toString(b3Score));
                        if (b3Score<100){
                            nextRound3bots();
                        }
                    }else if(player.getScore()==bot3.getScore()){
                        if (button.isSelected()){
                            JOptionPane.showMessageDialog(null, "Ισοπαλία!\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                    +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+Integer.toString(bot2.getScore())+"\nBot3 Hand Score: "
                                    +Integer.toString(bot3.getScore()),null,JOptionPane.INFORMATION_MESSAGE);
                        }else if(button2.isSelected()){
                            JOptionPane.showMessageDialog(null, "Draw!\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                    +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+Integer.toString(bot2.getScore())+"\nBot3 Hand Score: "
                                    +Integer.toString(bot3.getScore()),null,JOptionPane.INFORMATION_MESSAGE);  
                        }
                        nextRound3bots();
                    }
                }else if(player.getScore()>bot2.getScore()){
                    if(bot2.getScore()<bot3.getScore()){
                        b2Score+=player.getScore()+bot1.getScore()+bot3.getScore();
                        if (button.isSelected()){
                            JOptionPane.showMessageDialog(null, "Έχασες αυτόν τον γύρο.\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                    +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+Integer.toString(bot2.getScore())+"\nBot3 Hand Score: "
                                    +Integer.toString(bot3.getScore()),"Error",JOptionPane.ERROR_MESSAGE);
                        }else if(button2.isSelected()){
                            JOptionPane.showMessageDialog(null, "You lost this round.\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                    +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+Integer.toString(bot2.getScore())+"\nBot3 Hand Score: "
                                    +Integer.toString(bot3.getScore()),"Error",JOptionPane.ERROR_MESSAGE);  
                        }
                        bot2Score.setText("    Bot2 Score: "+Integer.toString(b2Score));
                        if (b2Score<100){
                            nextRound3bots();
                        }
                    }else if(bot2.getScore()>bot3.getScore()){
                        b3Score+=player.getScore()+bot1.getScore()+bot2.getScore();
                        if (button.isSelected()){
                            JOptionPane.showMessageDialog(null, "Έχασες αυτόν τον γύρο.\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                    +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+Integer.toString(bot2.getScore())+"\nBot3 Hand Score: "
                                    +Integer.toString(bot3.getScore()),"Error",JOptionPane.ERROR_MESSAGE);
                        }else if(button2.isSelected()){
                            JOptionPane.showMessageDialog(null, "You lost this round.\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                    +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+Integer.toString(bot2.getScore())+"\nBot3 Hand Score: "
                                    +Integer.toString(bot3.getScore()),"Error",JOptionPane.ERROR_MESSAGE);  
                        }
                        bot3Score.setText("    Bot3 Score: "+Integer.toString(b3Score));
                        if (b3Score<100){
                            nextRound3bots();
                        }
                    }else if(bot2.getScore()==bot3.getScore()){
                        if (button.isSelected()){
                            JOptionPane.showMessageDialog(null, "Ισοπαλία!\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                    +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+Integer.toString(bot2.getScore()),null,JOptionPane.INFORMATION_MESSAGE);
                        }else if(button2.isSelected()){
                            JOptionPane.showMessageDialog(null, "Draw!\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                    +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+Integer.toString(bot2.getScore()),null,JOptionPane.INFORMATION_MESSAGE);  
                        }
                        nextRound3bots();
                    }
                }
            }else if(player.getScore()>bot1.getScore()){
                if ((bot1.getScore()<bot2.getScore())||(bot1.getScore()==bot2.getScore())){
                    if(bot1.getScore()<bot3.getScore()){
                        b1Score+=player.getScore()+bot2.getScore()+bot3.getScore();
                        if (button.isSelected()){
                            JOptionPane.showMessageDialog(null, "Κέρδισες αυτόν τον γύρο!\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                    +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+Integer.toString(bot2.getScore())+"\nBot3 Hand Score: "
                                    +Integer.toString(bot3.getScore()),null,JOptionPane.INFORMATION_MESSAGE);
                        }else if(button2.isSelected()){
                            JOptionPane.showMessageDialog(null, "You won this round!\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                    +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+Integer.toString(bot2.getScore())+"\nBot3 Hand Score: "
                                    +Integer.toString(bot3.getScore()),null,JOptionPane.INFORMATION_MESSAGE);  
                        }
                        bot1Score.setText("Your Score: "+Integer.toString(b1Score));
                        if (b1Score<100){
                            nextRound3bots();
                        }
                    }else if (bot1.getScore()>bot3.getScore()){
                        b3Score+=player.getScore()+bot1.getScore()+bot2.getScore();
                        if (button.isSelected()){
                            JOptionPane.showMessageDialog(null, "Έχασες αυτόν τον γύρο.\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                    +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+"\nBot3 Hand Score: "
                                    +Integer.toString(bot3.getScore())+Integer.toString(bot2.getScore()),"Error",JOptionPane.ERROR_MESSAGE);
                        }else if(button2.isSelected()){
                            JOptionPane.showMessageDialog(null, "You lost this round.\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                    +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+Integer.toString(bot2.getScore())+"\nBot3 Hand Score: "
                                    +Integer.toString(bot3.getScore()),"Error",JOptionPane.ERROR_MESSAGE);  
                        }
                        bot3Score.setText("    Bot3 Score: "+Integer.toString(b3Score));
                        if (b3Score<100){
                            nextRound3bots();
                        }
                    }else if(bot1.getScore()==bot3.getScore()){
                        if (button.isSelected()){
                            JOptionPane.showMessageDialog(null, "Ισοπαλία!\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                    +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+Integer.toString(bot2.getScore())+"\nBot3 Hand Score: "
                                    +Integer.toString(bot3.getScore()),null,JOptionPane.INFORMATION_MESSAGE);
                        }else if(button2.isSelected()){
                            JOptionPane.showMessageDialog(null, "Draw!\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                    +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+Integer.toString(bot2.getScore())+"\nBot3 Hand Score: "
                                    +Integer.toString(bot3.getScore()),null,JOptionPane.INFORMATION_MESSAGE);  
                        }
                        nextRound3bots();
                    }
                }else if(bot1.getScore()>bot2.getScore()){
                    if(bot2.getScore()<bot3.getScore()){
                        b2Score+=player.getScore()+bot1.getScore()+bot3.getScore();
                        if (button.isSelected()){
                            JOptionPane.showMessageDialog(null, "Έχασες αυτόν τον γύρο.\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                    +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+Integer.toString(bot2.getScore())+"\nBot3 Hand Score: "
                                    +Integer.toString(bot3.getScore()),"Error",JOptionPane.ERROR_MESSAGE);
                        }else if(button2.isSelected()){
                            JOptionPane.showMessageDialog(null, "You lost this round.\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                    +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+Integer.toString(bot2.getScore())+"\nBot3 Hand Score: "
                                    +Integer.toString(bot3.getScore()),"Error",JOptionPane.ERROR_MESSAGE);  
                        }
                        bot2Score.setText("    Bot2 Score: "+Integer.toString(b2Score));
                        if (b2Score<100){
                            nextRound3bots();
                        }
                    }else if(bot2.getScore()>bot3.getScore()){
                        b3Score+=player.getScore()+bot1.getScore()+bot2.getScore();
                        if (button.isSelected()){
                            JOptionPane.showMessageDialog(null, "Έχασες αυτόν τον γύρο.\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                    +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+Integer.toString(bot2.getScore())+"\nBot3 Hand Score: "
                                    +Integer.toString(bot3.getScore()),"Error",JOptionPane.ERROR_MESSAGE);
                        }else if(button2.isSelected()){
                            JOptionPane.showMessageDialog(null, "You lost this round.\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                    +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+Integer.toString(bot2.getScore())+"\nBot3 Hand Score: "
                                    +Integer.toString(bot3.getScore()),"Error",JOptionPane.ERROR_MESSAGE);  
                        }
                        bot3Score.setText("    Bot3 Score: "+Integer.toString(b3Score));
                        if (b3Score<100){
                            nextRound3bots();
                        }
                    }else if(bot2.getScore()==bot3.getScore()){
                        if (button.isSelected()){
                            JOptionPane.showMessageDialog(null, "Ισοπαλία!\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                    +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+Integer.toString(bot2.getScore()),null,JOptionPane.INFORMATION_MESSAGE);
                        }else if(button2.isSelected()){
                            JOptionPane.showMessageDialog(null, "Draw!\nYour Hand Score: "+Integer.toString(player.getScore())+"\nBot1 Hand Score: "
                                    +Integer.toString(bot1.getScore())+"\nBot2 Hand Score: "+Integer.toString(bot2.getScore()),null,JOptionPane.INFORMATION_MESSAGE);  
                        }
                        nextRound3bots();
                    }
                }
            }
            if (pScore>=100){
                if (button.isSelected()){
                    JOptionPane.showMessageDialog(null, "Συγχαρητήρια..! Κέρδισες!","Winner winner chicken dinner!",JOptionPane.INFORMATION_MESSAGE);
                }else if(button2.isSelected()){
                    JOptionPane.showMessageDialog(null, "Congratulations..! You Won!","Winner winner chicken dinner!",JOptionPane.INFORMATION_MESSAGE);  
                }
                leftPanel.removeAll();
                centerPanel.removeAll();
                endPanel.removeAll();
                frame.repaint();
            }
             if (b1Score>=100 || b2Score>=100 || b3Score>=100){
                if (button.isSelected()){
                    JOptionPane.showMessageDialog(null, "Καλύτερη τύχη την επόμενη φορά..! Έχασες.","Error",JOptionPane.ERROR_MESSAGE);
                }else if(button2.isSelected()){
                    JOptionPane.showMessageDialog(null, "Better luck next time..! You Lost.","Error",JOptionPane.ERROR_MESSAGE);  
                }
                leftPanel.removeAll();
                centerPanel.removeAll();
                endPanel.removeAll();
                frame.repaint();
            }
         }
    }
    
    /**
     * This method is initiated when the next round begins while 3 bots are playing.
     */
    public void nextRound3bots(){
        stack=new ArrayList<>();        
        for(int i=0;i<q;i++){
            centerPanel.remove(tilesPlaced[i]);
            centerPanel.revalidate();
            centerPanel.repaint();
        }
        for(int i=0;i<player.getSize();i++){
            playerHandLabel[i].setIcon(null);
        }
        int k=restTiles.size();
        for(int i=0;i<k;i++){
            endInner1.remove(restTilesLabel[i]);
        }
        frame.revalidate();
        TilesAll7 tiles7=new TilesAll7();
        player=new Player();
        bot1=new Player();
        bot2=new Player();
        bot3=new Player();
        stack=new ArrayList<>();
        restTiles=new ArrayList<>();
        q=0;
        tmp2=4;
        tmp3=5;
        bot1Won=false;
        bot2Won=false;
        bot3Won=false;
        playerWon=false;
        player.getHand(tiles7.getPTiles5());
        bot1.getHand(tiles7.getB1Tiles5());
        bot2.getHand(tiles7.getB2Tiles5());
        bot3.getHand(tiles7.getB3Tiles5());
        for (int i=20;i<28;i++){
            SingleTile tile2=tiles7.getTile(i);
            restTiles.add(tile2);
            String imgName = "/images/" +tile2.getSide1()+tile2.getSide2()+".jpg";
            URL imageURL = getClass().getResource(imgName);
            ImageIcon icon = new ImageIcon(imageURL);  
            restTilesLabel[i-20]=new JLabel();
            endInner1.add(restTilesLabel[i-20]);
            restTilesLabel[i-20].setIcon(icon);
        }
        for (int i=0;i<=4;i++){
            SingleTile tile2=player.getTile(i+1);
            player.returnTile(i,tile2);
            String imgName = "/images/" +tile2.getSide1()+tile2.getSide2()+".jpg";
            URL imageURL = getClass().getResource(imgName);
            ImageIcon icon = new ImageIcon(imageURL);                       
            playerHandLabel[i].setIcon(icon);
        }
        endInner1.remove(restTilesButton);
        restTilesButton=new JButton(" Take from Extra ");
        restTilesButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (restTiles.size()>2){
                    player.returnTile(player.getSize(), restTiles.get(restTiles.size()-1));
                    String imgName = "/images/" +restTiles.get(restTiles.size()-1).getSide1()+restTiles.get(restTiles.size()-1).getSide2()+".jpg";
                    URL imageURL = getClass().getResource(imgName);
                    ImageIcon icon = new ImageIcon(imageURL);
                    playerHandLabel[tmp2+1]=new JLabel();
                    endInner2.add(playerHandLabel[tmp2+1],tmp2+2);
                    playerHandLabel[tmp2+1].setIcon(icon);
                    restTilesLabel[restTiles.size()-1].setIcon(null);
                    restTiles.remove(restTiles.get(restTiles.size()-1));
                    tmp2++;
                    tmp3++;
                }else{
                    if (button.isSelected()){
                        JOptionPane.showMessageDialog(null, "Δεν μπορείς να πάρεις επιπλέον πλακίδια. Έφτασες το όριο.","Error",JOptionPane.ERROR_MESSAGE);
                    }else if(button2.isSelected()){
                        JOptionPane.showMessageDialog(null, "You can't take more tiles. You reached the limit.","Error",JOptionPane.ERROR_MESSAGE);
                    } 
                }
            }
        });    
        endInner1.add(restTilesButton);
        frame.revalidate();
    }
    
    
}