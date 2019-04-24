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
public class Customer {
    private String name, address, phone;
    private ArrayList<Order> orderList;
    public Customer(String name, String address, String phone, ArrayList<Order> orderList){
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.orderList = orderList;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
}
