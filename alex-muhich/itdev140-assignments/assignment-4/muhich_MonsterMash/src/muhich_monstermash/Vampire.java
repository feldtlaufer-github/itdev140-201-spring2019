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
public class Vampire extends Monster{
    private int wingSpan;
    public Vampire(String monsterType, String name, int scareFactor, int size, int speed, int wingSpan) {
        super(monsterType, name, scareFactor, size, speed);
        this.wingSpan = wingSpan;
    }
    
    public void setWingSpan(int wingSpan){
        this.wingSpan = wingSpan;
    }
    public int getWingSpan(){
        return wingSpan;
    }
    
    public String sparkle(){
        return "I sparkle like gemstones in the sun!";
    }
    @Override
    public String speak(){
        return "BBLLEEHH!";
    }
    
    @Override
    public String toString(){
        return "My name is " + getName() + ".\nI'm a " + getMonsterType() +
                " monster.\nI have a scare factor of " + getScareFactor() + 
                ",a size of " + getSize() + ", and a speed of " + getSpeed() + "."
                + "\nMy wingspan is " + getWingSpan() + ".\n";
    }
    
    
}
