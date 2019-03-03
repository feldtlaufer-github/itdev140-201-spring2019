/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhich_schooldudes;

/**
 *
 * @author plain
 */
abstract class Person {
    private String firstName, lastName, streetAddress, zipcode, phoneNumber;

    public Person(String firstName, String lastName, String streetAddress, String zipcode, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.zipcode = zipcode;
        this.phoneNumber = phoneNumber;
    }
    
    public void displayAll(){
        System.out.println("First Name: " + getFirstName() + "\n"
        + "Last Name: " + getLastName() + "\n"
        + "Street Address: " + getStreetAddress() + "\n"
        + "Zipcode: " + getZipcode() + "\n"
        + "Phone Number: " + getPhoneNumber() + "\n");
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    

}
