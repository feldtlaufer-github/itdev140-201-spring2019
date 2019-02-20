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
public class Builder {
    
    Car myCar;
    Mercedes mid, compact, suv;
    Ford myFord;
    
    public void createCars(){
        myFord = new Ford("Ford", "Alpha", "truck", 100, "blue");
        System.out.println(myFord);
        
        myCar = new Car("Fiat", "Beta", "economy", 110);
        System.out.println(myCar.toString());
        mid = new Mercedes("Mercedes", "C200", "mid-sized", 140, "aluminum");
        System.out.println(mid);
        compact = new Mercedes("Mercedes", "E300", "compact", 130, "Black Ice");
        suv = new Mercedes("Mercedes", "S500", "suv", 160, "steel");
        System.out.println(suv);
        
        Mercedes obj = compact;
        showMercedes(obj);
    }
    public void showMercedes(Mercedes obj){
        System.out.println("\nCar Make: " + obj.getCarMake());
        System.out.println("Car Model: " + obj.getCarModel());
        System.out.println("Car Size: " + obj.getCarSize());
        System.out.println("Car Speed: " + obj.getMaxSpeed());
        
        if(obj.equals(mid) || obj.equals(suv) || obj.equals(compact)){
            System.out.println("Sports Wheel Type: " + obj.getSportsWheels());
        }
        System.out.println("Car Horn: " + obj.horn());
    }
}
