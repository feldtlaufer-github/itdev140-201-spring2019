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
    private int pizzaId;

    public Pizza(String toppings, int pizzaId, String size) {
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

    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }
    
}
