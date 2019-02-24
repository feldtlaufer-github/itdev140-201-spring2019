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
public class Monster {
    //monsterType, name, scareFactor, size, and speed
    private String monsterType, name;
    private int scareFactor, size, speed;
    
    public Monster(String monsterType, String name, int scareFactor, int size, int speed){
        
    }
    
    @Override
    public String toString(){
        return "My name is " + getName() + ".\nI'm a " + getMonsterType() +
                " monster.\nI have a scare factor of " + getScareFactor() + 
                ",a size of " + getSize() + ", and a speed of " + getSpeed() + ".";
    }
    
    public String speak(){
        return "ARRGGHH!";
    }

    public String getMonsterType() {
        return monsterType;
    }

    public void setMonsterType(String monsterType) {
        this.monsterType = monsterType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScareFactor() {
        return scareFactor;
    }

    public void setScareFactor(int scareFactor) {
        this.scareFactor = scareFactor;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    
}

