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
public class Werewolf extends Monster{
    private String color;
    public Werewolf(String monsterType, String name, int scareFactor, int size, int speed, String color) {
        super(monsterType, name, scareFactor, size, speed);
        this.color = color;
    }
    
    public String imprint(){
        return "I imprinted on your daughter to save her.";
    }
    @Override
    public String speak(){
        return "AAWWOO!";
    }
    
    @Override
    public String toString(){
        return "My name is " + getName() + ".\nI'm a " + getMonsterType() +
                " monster.\nI have a scare factor of " + getScareFactor() + 
                ",a size of " + getSize() + ", and a speed of " + getSpeed() + "."
                + "\nMy fur is " + getColor() + ".";
    }
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
    
}
