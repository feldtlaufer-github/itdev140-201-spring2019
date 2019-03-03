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
public class CollegeEmployee extends Person{
    private String ssn, department;
    private double salary;
    
    //private String firstName, lastName, streetAddress, zipcode, phoneNumber;
    public CollegeEmployee(String firstName, String lastName, String streetAddress
            , String zipcode, String phoneNumber, String ssn, String department
            , Double salary){
        super(firstName, lastName, streetAddress, zipcode, phoneNumber);
        this.ssn = ssn;
        this.department = department;
        this.salary = salary;
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
        + "Salary: $" + df.format(getSalary()) + "\n");
    }

    public String getSSN() {
        return ssn;
    }

    public void setSSN(String ssn) {
        this.ssn = ssn;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    

}
