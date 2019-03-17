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
public class Bird extends Animal{
    private boolean isTagged;
    private boolean isCarnivore;
    public Bird(String type, String gender, String dietType, String zooLocation,
            int age, int animalIdNumber, boolean isTagged, boolean isCarnivore) {
        super(type, gender, dietType, zooLocation, age, animalIdNumber);
        this.isTagged = isTagged;
        this.isCarnivore = isCarnivore;
        
    }
    @Override
    public String move(){
        return "Birds fly";
    }
    
    @Override
    public String toString() {
        return "Bird{\ntype= " + getType() +
                "\ngender= " + getGender() +
                "\ndietType= " + getDietType() +
                "\nzooLocation= " + getZooLocation() +
                "\nage= " + getAge() +
                "\nanimalIdNumber= " + getAnimalIdNumber() +
                "\nisTagged= " + isIsTagged() +
                "\nisCarnivore= " + isIsCarnivore() +
                '}';
    }

    public boolean isIsTagged() {
        return isTagged;
    }

    public void setIsTagged(boolean isTagged) {
        this.isTagged = isTagged;
    }

    public boolean isIsCarnivore() {
        return isCarnivore;
    }

    public void setIsCarnivore(boolean isCarnivore) {
        this.isCarnivore = isCarnivore;
    }
    
    
}
