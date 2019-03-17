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
public class Mammal extends Animal{
    private String name;
    private double weight;
    private int dailyMealCount;
    
    public Mammal(String type, String gender, String dietType, String zooLocation,
            int age, int animalIdNumber, String name, double weight, int dailyMealCount){
        super(type, gender, dietType, zooLocation, age, animalIdNumber);
        this.name = name;
        this.weight = weight;
        this.dailyMealCount = dailyMealCount;
    }
    @Override
    public String move(){
        return "Mammals run or walk.";
    }

    @Override
    public String toString() {
        return "Mammal{\nname= " + name +
                "\ntype= " + getType() +
                "\ngender= " + getGender() +
                "\ndietType= " + getDietType() +
                "\nzooLocation= " + getZooLocation() +
                "\nage= " + getAge() +
                "\nanimalIdNumber= " + getAnimalIdNumber() +
                "\nweight= " + weight +
                "\ndailyMealCount= " + dailyMealCount +
                '}';
    }
    
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getDailyMealCount() {
        return dailyMealCount;
    }

    public void setDailyMealCount(int dailyMealCount) {
        this.dailyMealCount = dailyMealCount;
    }
    
}
