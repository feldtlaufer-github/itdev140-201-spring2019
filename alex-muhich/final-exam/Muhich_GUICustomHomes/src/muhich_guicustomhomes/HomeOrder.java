/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhich_guicustomhomes;

/**
 *
 * @author plain
 */
public class HomeOrder {
    private String firstname, lastname, address, city, state, zipcode, typeofhome;
    private double price;

    public HomeOrder(String firstname, String lastname, String address, String city, String state, String zipcode, String typeofhome, double price) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.typeofhome = typeofhome;
        this.price = price;
    }

    @Override
    public String toString() {
        return "HomeOrder{" + "firstname=" + firstname + ", lastname=" + lastname +
                ", address=" + address + ", city=" + city + ", state=" + state +
                ", zipcode=" + zipcode + ", typeofhome=" + typeofhome + ", price=" + price + '}';
    }

    
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getTypeofhome() {
        return typeofhome;
    }

    public void setTypeofhome(String typeofhome) {
        this.typeofhome = typeofhome;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
}
