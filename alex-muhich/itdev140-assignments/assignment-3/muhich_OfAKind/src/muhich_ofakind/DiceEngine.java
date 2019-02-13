
package muhich_ofakind;

import java.util.Arrays;
import java.util.Scanner;


/**
 *
 * @author Alex Jerard Muhich
 */
public class DiceEngine {
    //these are seperate in case I want to allow the user to ask for the rules again
    String intro = "Welcome to DiceGame!\n"
            + "You will be playing a dice game vs the computer.\n";
    String rules = "Each player will roll 5 dice.\n"
            + "Whoever rolls higher wins!\n"
            + "5 of a kind > 4 of a kind > 3 of a kind > 2 of a kind\n"
            + "If there is a tie, the player with the higher value wins!\n"
            + "If there is a second tie, an even value means the computer wins"
            + " and an odd value means you win.\n"
            + "Each game is 10 rounds of rolling. Whoever wins the most rounds wins the game.";
    String instr = "Enter 'play' to play a game. Enter 'quit' to stop playing.";
    String input;
    Scanner scanner;
    String playerName;
    
    public DiceEngine(){
        System.out.println(intro);
        System.out.println(rules);
        
        scanner = new Scanner(System.in);
        System.out.println("Please enter your name");
        playerName = scanner.next();
        System.out.println(instr);
        input = scanner.next();
        while(!input.equals("quit")){
            if(input.equals("play")){
                playGame();
            }else{
                System.out.println("Invalid input");
            }
            input = scanner.next();
        }
        System.out.println("Thank you for playing");
    }
    public void playGame(){
        Player compPlayer = new Player("Computer");
        Player userPlayer = new Player(playerName);
        
        for(int i = 1; i <= 10; i++){
            compPlayer.rollDice(5);
            userPlayer.rollDice(5);
           
            System.out.println("Round " + i);
            System.out.println(compPlayer.getName() + ": " + Arrays.toString(compPlayer.getDiceTray()));
            System.out.println(userPlayer.getName() + ": " + Arrays.toString(userPlayer.getDiceTray()));
            
            //computer's hand is higher than users
            if(getRank(compPlayer.getDiceTray())[1] > getRank(userPlayer.getDiceTray())[1]){
                System.out.println(compPlayer.getName() + " wins this round!");
                compPlayer.incrNumWins();
            }
            //computer's hand equals users hand
            else if(getRank(compPlayer.getDiceTray())[1] == getRank(userPlayer.getDiceTray())[1]){
                //computer's dice was higher
                if(getRank(compPlayer.getDiceTray())[0] > getRank(userPlayer.getDiceTray())[0]){
                    System.out.println(compPlayer.getName() + " wins this round!");
                    compPlayer.incrNumWins();
                }
                //computer's dice equals users dice
                else if(getRank(compPlayer.getDiceTray())[0] == getRank(userPlayer.getDiceTray())[0]){
                    System.out.println("You tied exactly!");
                }
                //computer's dice was lower
                else if(getRank(compPlayer.getDiceTray())[0] < getRank(userPlayer.getDiceTray())[0]){
                    System.out.println(userPlayer.getName() + " win this round!");
                    userPlayer.incrNumWins();
                }
            }
            //computer's hand was lower
            else if(getRank(compPlayer.getDiceTray())[1] < getRank(userPlayer.getDiceTray())[1]){
                System.out.println(userPlayer.getName() + " win this round!");
                userPlayer.incrNumWins();
            }
        }
        if(compPlayer.getNumWins() > userPlayer.getNumWins()){
            System.out.println(compPlayer.getName() + " won the game " + compPlayer.getNumWins() + " to " + userPlayer.getNumWins());
        }else if(compPlayer.getNumWins() < userPlayer.getNumWins()){
            System.out.println(userPlayer.getName() + " won the game " + userPlayer.getNumWins() + " to " + compPlayer.getNumWins());
        }else if(compPlayer.getNumWins() == userPlayer.getNumWins()){
            System.out.println("You tied " + userPlayer.getNumWins() + " to " + compPlayer.getNumWins());
        }
    }
    
    private int[] getRank(int[] diceArr){
        /**
         * determine what kind of hand each player has
         * maybe assign a value to each hand then compare values?
         * assumes dice are sorted
         * 5: aaaaa  
         * 4: aaaax xaaaa 
         * 3: aaaxx xaaax xxaaa 
         * 2: aaxxx xaaxx xxaax xxxaa 
         * 
         */
        int value = 0;
        
        //five of a kind
        if(diceArr[0] == diceArr[1] && diceArr[1] == diceArr[2] && diceArr[2] == diceArr[3] && diceArr[3] == diceArr[4]){
            return new int[]{diceArr[0], 5};
        }
        
        //four of a kind
        if(diceArr[0] == diceArr[1] && diceArr[1] == diceArr[2] && diceArr[2] == diceArr[3]){
            value = diceArr[0];
        }
        if(diceArr[1] == diceArr[2] && diceArr[2] == diceArr[3] && diceArr[3] == diceArr[4]){
            if(value < diceArr[1]) value = diceArr[1];
        }
        if(value != 0) return new int[]{value, 4};
        
        //three of a kind
        if(diceArr[0] == diceArr[1] && diceArr[1] == diceArr[2]){
            value = diceArr[0];
        }
        if(diceArr[1] == diceArr[2] && diceArr[2] == diceArr[3]){
            if(value < diceArr[1]) value = diceArr[1];
        }
        if(diceArr[2] == diceArr[3] && diceArr[3] == diceArr[4]){
            if(value < diceArr[2]) value = diceArr[2];
        }
        if(value != 0) return new int[]{value, 3};
        
        //two of a kind
        if(diceArr[0] == diceArr[1]){
            value = diceArr[0];
        }
        if(diceArr[1] == diceArr[2]){
            if(value < diceArr[1]) value = diceArr[1];
        }
        if(diceArr[2] == diceArr[3]){
            if(value < diceArr[2]) value = diceArr[2];
        }
        if(diceArr[3] == diceArr[4]){
            if(value < diceArr[3]) value = diceArr[3];
        }
        return new int[]{value, 2};
    }
}
