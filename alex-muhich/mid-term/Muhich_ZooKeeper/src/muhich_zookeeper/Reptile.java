/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhich_zookeeper;

/**
 *
 * @author plain
 */
public class Reptile extends Animal{
    private boolean hasShell;
    private boolean livesIndoors;

    public Reptile(String type, String gender, String dietType, String zooLocation,
            int age, int animalIdNumber, boolean hasShell, boolean livesIndoors) {
        super(type, gender, dietType, zooLocation, age, animalIdNumber);
        this.hasShell = hasShell;
        this.livesIndoors = livesIndoors;
    }
    @Override
    public String move(){
        return "Reptiles crawl.";
    }

    @Override
    public String toString() {
        return "Reptile{\ntype= " + getType() +
                "\ngender= " + getGender() +
                "\ndietType= " + getDietType() +
                "\nzooLocation= " + getZooLocation() +
                "\nage= " + getAge() +
                "\nanimalIdNumber= " + getAnimalIdNumber() +
                "\nhasShall= " + isHasShell() +
                "\nlivesIndoors= " + isLivesIndoors() +
                '}';
    }
    
    public boolean isHasShell() {
        return hasShell;
    }

    public void setHasShell(boolean hasShell) {
        this.hasShell = hasShell;
    }

    public boolean isLivesIndoors() {
        return livesIndoors;
    }

    public void setLivesIndoors(boolean livesIndoors) {
        this.livesIndoors = livesIndoors;
    }
    
    
}
