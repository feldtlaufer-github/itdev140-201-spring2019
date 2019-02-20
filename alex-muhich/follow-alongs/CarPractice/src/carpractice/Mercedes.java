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
public class Mercedes extends Car{
    private String sportsWheels;
    
    public Mercedes(String make, String model, String size, int maxSpeed, String sportsWheels){
        super(make, model, size, maxSpeed);
        this.sportsWheels = sportsWheels;
    }

    @Override
    public String toString(){
        return "\nIn Mercedes Class, Make: " + this.getCarMake() +
               "\nMercedes Model: " + this.getCarModel() +
               "\nMercedes Size: " + this.getCarSize() +
               "\nMercedes Speed: " + this.getMaxSpeed() +
               "\nMercedes Wheel Type: " + this.getSportsWheels() +
               "\nMercedes Horn: " + this.horn();
               
    }
    @Override
    public String horn(){
        String arg = "This is a Mercedes horn";
        return arg;
    }
    
    public String getSportsWheels() {
        return sportsWheels;
    }

    public void setSportsWheels(String sportsWheels) {
        this.sportsWheels = sportsWheels;
    }
    
    
}
