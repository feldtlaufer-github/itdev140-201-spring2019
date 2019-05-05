/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamstageright_guipizza;

import java.util.ArrayList;

/**
 *
 * @author plain
 */
public class Order {
    private String deliveryMethod;
    private int orderNum;
    private ArrayList<Pizza> pizzaList;

    public Order(String deliveryMethod, int orderNum, ArrayList<Pizza> pizzaList) {
        this.deliveryMethod = deliveryMethod;
        this.orderNum = orderNum;
        this.pizzaList = pizzaList;
    }

    public ArrayList<Pizza> getPizzaList() {
        return pizzaList;
    }

    public void setPizzaList(ArrayList<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }
    

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }
    
    
}
