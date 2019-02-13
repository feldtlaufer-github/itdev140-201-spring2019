
package muhich_ofakind;

import java.util.Arrays;

/**
 *
 * @author Alex Muhich
 */
public class Player {
    private final String name;
    private int[] diceTray;
    private int numWins;
    public Player(String name){
        this.name = name;
        this.diceTray = new int[5];
        numWins = 0;
    }
    public String getName(){
        return name;
    }
    public int[] rollDice(int num){
        for(int i = 0; i < diceTray.length; i++){
            diceTray[i] = (int)(Math.random() * 6) + 1; 
        }
        Arrays.sort(diceTray);
        return diceTray;
    }
    public int[] getDiceTray(){
        return diceTray;
    }
    public int getNumWins(){
        return numWins;
    }
    public void incrNumWins(){
        numWins++;
    }
}
