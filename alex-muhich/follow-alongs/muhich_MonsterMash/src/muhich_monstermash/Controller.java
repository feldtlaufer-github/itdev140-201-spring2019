/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhich_monstermash;

/**
 *
 * @author plain
 */
public class Controller {
    Vampire edward, carlisle, alice;
    Werewolf jacob, sam, leah;
    Monster[] monsterList;
    public Controller(){
        //monsterType, name, scareFactor, size, and speed::wingSpan or color
        edward = new Vampire("vampire", "Edward", 7, 5, 8, 2);
        carlisle = new Vampire("vampire", "Carlisle", 5, 7, 4, 4);
        alice = new Vampire("vampire", "Alice", 2, 4, 3, 7);
        jacob = new Werewolf("werewolf", "Jacob", 7, 7, 6, "brown");
        sam = new Werewolf("werewolf", "Sam", 4, 4, 3, "black");
        leah = new Werewolf("werewolf", "Leah", 6, 6, 6, "white");
        monsterList = new Monster[]{edward, carlisle, alice, jacob, sam, leah};
    }
    public void meetTheMonsters(){
        for (Monster monster : monsterList) {
            System.out.println(monster);
        }
    }
    public void fight(Monster mon1, Monster mon2){
        
    }
}
