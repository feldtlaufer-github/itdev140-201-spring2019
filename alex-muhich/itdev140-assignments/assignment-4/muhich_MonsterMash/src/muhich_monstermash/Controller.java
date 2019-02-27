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
        edward =        new Vampire("vampire", "Edward", 2, 5, 8, 2);
        carlisle =    new Vampire("vampire", "Carlisle", 7, 5, 6, 4);
        alice =          new Vampire("vampire", "Alice", 2, 1, 4, 7);
        jacob =        new Werewolf("werewolf", "Jacob", 2, 5, 8, "brown");
        sam =            new Werewolf("werewolf", "Sam", 7, 3, 6, "black");
        leah =          new Werewolf("werewolf", "Leah", 9, 1, 4, "white");
        monsterList = new Monster[]{edward, carlisle, alice, jacob, sam, leah};
    }
    public void meetTheMonsters(){
        System.out.println("Meet the Monsters!\n");
        for (Monster monster : monsterList) {
            System.out.println(monster);
        }
    }
    public void fight(Monster mon1, Monster mon2){
        System.out.println(mon1.getName() + " will be fighting " + mon2.getName() + "\n");
        System.out.println(mon1.toString());
        System.out.println(mon2.toString());
        
        //check speed
        if(mon1.getSpeed() > mon2.getSpeed()){
            System.out.println(mon1.getName() + " outsped " + mon2.getName() + " and won the battle!");
            System.out.println(mon1.speak());
        }else if(mon2.getSpeed() > mon1.getSpeed()){
            System.out.println(mon2.getName() + " outsped " + mon1.getName() + " and won the battle!");
            System.out.println(mon2.speak());
        }else{
            //if tied, check size
            if(mon1.getSize() > mon2.getSize()){
                System.out.println(mon1.getName() + " outsized " + mon2.getName() + " and won the battle!");
                System.out.println(mon1.speak());
            }else if(mon2.getSize() > mon1.getSize()){
                System.out.println(mon2.getName() + " outsized " + mon1.getName() + " and won the battle!");
                System.out.println(mon2.speak());
            }else{
            //if tied, check scareFactor
                if(mon1.getScareFactor() > mon2.getScareFactor()){
                    System.out.println(mon1.getName() + " outscared " + mon2.getName() + " and won the battle!");
                    System.out.println(mon1.speak());
                }else if(mon2.getScareFactor() > mon1.getScareFactor()){
                    System.out.println(mon2.getName() + " outscared " + mon1.getName() + " and won the battle!");
                    System.out.println(mon2.speak());
                }else{
                    System.out.println("The monsters were evenly matched. It's a tie!");
                }
            }
        }
    }
}
