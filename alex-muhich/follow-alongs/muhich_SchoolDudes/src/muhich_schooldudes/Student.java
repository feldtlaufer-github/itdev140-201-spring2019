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
public class Student extends Person{
    private String major;
    private double gpa;
    
    //private String firstName, lastName, streetAddress, zipcode, phoneNumber;
    public Student(String firstName, String lastName, String streetAddress
            , String zipcode, String phoneNumber, String major, double gpa){
        super(firstName, lastName, streetAddress, zipcode, phoneNumber);
        this.major = major;
        this.gpa = gpa;
    }
    
    @Override
    public void displayAll(){
        System.out.println("First Name: " + getFirstName() + "\n"
        + "Last Name: " + getLastName() + "\n"
        + "Street Address: " + getStreetAddress() + "\n"
        + "Zipcode: " + getZipcode() + "\n"
        + "Phone Number: " + getPhoneNumber() + "\n"
        + "Major: " + getMajor() + "\n"
        + "GPA: " + getGPA() + "\n");
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGPA() {
        return gpa;
    }

    public void setGPA(double gpa) {
        this.gpa = gpa;
    }
    
    
}
