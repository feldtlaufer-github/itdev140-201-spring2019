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
public class Car {
    
    private String carMake, carModel, carSize;
    private int maxSpeed;
    
    public Car(String carMake, String carModel, String carSize, int maxSpeed){
        this.carMake = carMake;
        this.carModel = carModel;
        this.carSize = carSize;
        this.maxSpeed = maxSpeed;
        
    }
    @Override
    public String toString(){
        
        return "\nCar Make: " + this.getCarMake() + 
               "\nCar Model: " + this.getCarModel() +
               "\nCar Size: " + this.getCarSize() +
               "\nCar Speed: " + this.getMaxSpeed() + 
               "\nCar Horn: " + horn();
    }
    
    public String horn(){
        String arg = "This is a car horn";
        return arg;
    }
    
    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarSize() {
        return carSize;
    }

    public void setCarSize(String carSize) {
        this.carSize = carSize;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
