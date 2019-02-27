
package muhich_monstermash;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Alex Jerard Muhich
 */
public class Muhich_MonsterMash {

    private static final String INTRO = "Welcome to Monster Mash!\n"
            + "You will introduced to monsters that will fight each other.\n";
    private static final String DIRECTIONS = "Enter 'fight' to have 2 random monsters face-off.\n"
            + "Whichever monster has the better stats wins!\n"
            + "When you want to stop, enter 'quit'.\n";
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println(INTRO);
        
        Controller cont = new Controller();
        
        cont.meetTheMonsters();
        System.out.println(DIRECTIONS);
        
        String input = scanner.next();
        while(!input.equals("quit")){
            if(input.equals("fight")){
                Random rand = new Random();
                int[] indexList = new int[2];
                indexList[0] = rand.nextInt(cont.monsterList.length);
                int i = rand.nextInt(cont.monsterList.length);
                while(i == indexList[0]){
                    i = rand.nextInt(cont.monsterList.length);
                }
                indexList[1] = i;
                cont.fight(cont.monsterList[indexList[0]], cont.monsterList[indexList[1]]);
                
            }else{
                System.out.println("Invalid input");
            }
            input = scanner.next();
        }
        System.out.println("It was a graveyard smash!");
    }
}
