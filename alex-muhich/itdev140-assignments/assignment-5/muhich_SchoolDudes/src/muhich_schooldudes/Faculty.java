/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhich_schooldudes;

import java.text.DecimalFormat;

/**
 *
 * @author plain
 */
public class Faculty extends CollegeEmployee{
    private boolean tenured;
    
    //private String firstName, lastName, streetAddress, zipcode, phoneNumber;
    public Faculty(String firstName, String lastName, String streetAddress
            , String zipcode, String phoneNumber, String ssn, String department
            , Double salary, boolean tenured){
        super(firstName, lastName, streetAddress, zipcode, phoneNumber, ssn, department, salary);
        this.tenured = tenured;
    }
    
    @Override
    public void displayAll(){
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("First Name: " + getFirstName() + "\n"
        + "Last Name: " + getLastName() + "\n"
        + "Street Address: " + getStreetAddress() + "\n"
        + "Zipcode: " + getZipcode() + "\n"
        + "Phone Number: " + getPhoneNumber() + "\n"
        + "Social Security Number: " + getSSN() + "\n"
        + "Department: " + getDepartment() + "\n"
        + "Salary: $" + df.format(getSalary()) + "\n"
        + "Tenured: " + isTenured() + "\n");
    }
    public void setTenured(boolean tenured){
        this.tenured = tenured;
    }
    public boolean getTenured(){
        return tenured;
    }
    private String isTenured(){
        if(tenured) return "Yes";
        else return "No";
    }
}
