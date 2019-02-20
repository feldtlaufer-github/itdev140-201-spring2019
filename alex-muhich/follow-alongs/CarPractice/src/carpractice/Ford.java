/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carpractice;

/**
 *
 * @author plain
 */
public class Ford extends Car{
    private String color;
    public Ford(String make, String model, String size, int speed, String color){
        super(make, model, size, speed);
        this.color = color;
    }
    
    public void setColor(String color){
        this.color = color;
    }
    public String getColor(){
        return color;
    }
    
    @Override
    public String toString(){
        return "\nIn Ford Class, Make: " + this.getCarMake() +
               "\nFord Model: " + this.getCarModel() +
               "\nFord Size: " + this.getCarSize() +
               "\nFord Speed: " + this.getMaxSpeed() +
               "\nFord Color: " + this.getColor() +
               "\nFord Horn: " + this.horn();
    }
    
    @Override
    public String horn(){
        return "This is a Ford horn";
    }
}
