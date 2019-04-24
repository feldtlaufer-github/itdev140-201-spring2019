/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamstageright_guipizza;

/**
 *
 * @author plain
 */
public class Pizza {
    private String toppings, size;
    private double pizzaId;

    public Pizza(String toppings, double pizzaId, String size) {
        this.toppings = toppings;
        this.pizzaId = pizzaId;
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    
    public String getToppings() {
        return toppings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public double getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(double pizzaId) {
        this.pizzaId = pizzaId;
    }
    
}
