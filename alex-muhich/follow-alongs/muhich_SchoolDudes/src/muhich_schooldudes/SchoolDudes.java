/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhich_schooldudes;

import java.util.Scanner;

/**
 *
 * @author plain
 */
public class SchoolDudes {
    private CollegeEmployee[] collegeEmployees;
    private Faculty[] faculties;
    private Student[] students;
    private Scanner scanner;
    
    public SchoolDudes(){
        collegeEmployees = new CollegeEmployee[5];
        faculties = new Faculty[5];
        students = new Student[5];
    }
    public void dude(){
        scanner = new Scanner(System.in);
        System.out.println("Please enter 'quit' to discontinue;"
                + " 'add' to add a person; 'find' to find a person; or 'display'"
                + " to display information.");
        String input = scanner.next();
        while(!input.equals("quit")){
            switch (input) {
                case "add":
                    addDude();
                    break;
                case "find":
                    find();
                    break;
                case "display":
                    displayAll();
                    break;
            }
            System.out.println("Please enter 'quit' to discontinue;"
                + " 'add' to add a person; 'find' to find a person; or 'display'"
                + " to display information.");
            input = scanner.next();
        }
        System.out.println("Thank you for using the SchoolDudes App!");
    }
    private void addDude(){
        String ssn, department, type = "";
        double salary;
        
        while(!type.equals("back")){
            System.out.println("Please enter 'back' to return to main menu;"
                    + " 'student' to add a student;"
                    + " 'employee' to add an employee;"
                    + " or 'faculty' to add a faculty member");
            type = scanner.next();

            //if the user tries to add a sixth person, don't let them.
            switch(type){
                case "student":
                    if(students[4] != null){
                        System.out.println("Too many students!");
                        continue;
                    }
                    break;
                case "employee":
                    if(collegeEmployees[4] != null){
                        System.out.println("Too many employees!");
                        continue;
                    }
                    break;
                case "faculty":
                    if(faculties[4] != null){
                        System.out.println("Too many faculty members!");
                        continue;
                    }
                    break;
                case "back":
                    continue;
            }
/**
* String firstName, String lastName, String streetAddress
String zipcode, String phoneNumber
*/
            System.out.println("Please enter the person's FIRST NAME");
            String firstName = scanner.next();
            System.out.println("Please enter the person's LAST NAME");
            String lastName = scanner.next();
            System.out.println("Please enter the person's STREET ADDRESS");
            String streetAddress = scanner.next();
            System.out.println("Please enter the person's ZIPCODE");
            String zipcode = scanner.next();
            System.out.println("Please enter the person's PHONE NUMBER");
            String phoneNumber = scanner.next();

            switch(type){
                case "student":
/**
* String major, double gpa
*/
                    System.out.println("Please enter the student's MAJOR");
                    String major = scanner.next();
                    System.out.println("Please enter the student's GPA");
                    double gpa = scanner.nextDouble();

                    for(int i = 0; i < students.length; i++){
                        if(students[i] == null){
                            students[i] = new Student(
                            firstName, lastName, streetAddress,
                            zipcode, phoneNumber, major, gpa);
                            break;
                        }
                    }
                    break;
                case "faculty":
/**
* String ssn, String department
Double salary, boolean tenured
*/
                    System.out.println("Please enter the faculty's SSN");
                    ssn = scanner.next();
                    System.out.println("Please enter the faculty's DEPARTMENT");
                    department = scanner.next();
                    System.out.println("Please enter the faculty's SALARY");
                    salary = scanner.nextDouble();
                    System.out.println("Please enter the faculty's TENURED status");
                    boolean tenured = scanner.nextBoolean();

                    for(int i = 0; i < faculties.length; i++){
                        if(faculties[i] == null){
                            faculties[i] = new Faculty(
                            firstName, lastName, streetAddress,
                            zipcode, phoneNumber, ssn, department, salary, tenured);
                            break;
                        }
                    }
                    break;
                case "employee":
/**
* String ssn, String department, Double salary
*/
                    System.out.println("Please enter the faculty's SSN");
                    ssn = scanner.next();
                    System.out.println("Please enter the faculty's DEPARTMENT");
                    department = scanner.next();
                    System.out.println("Please enter the faculty's SALARY");
                    salary = scanner.nextDouble();

                    for(int i = 0; i < collegeEmployees.length; i++){
                        if(collegeEmployees[i] == null){
                            collegeEmployees[i] = new CollegeEmployee(
                            firstName, lastName, streetAddress,
                            zipcode, phoneNumber, ssn, department, salary);
                            break;
                        }
                    }
                    break;
            }
        }
    }
    private void find(){
        boolean found = false;
        System.out.println("Please enter 'back' to return to main menu;"
                    + " or a last name to search for that person");
        String lastName = scanner.next();
        while(!lastName.equals("back")){
            for(CollegeEmployee collegeEmployee : collegeEmployees) {
                if(collegeEmployee != null && collegeEmployee.getLastName().equals(lastName)) {
                    collegeEmployee.displayAll();
                    found = true;
                }
            }
            for(Student student: students){
                if(student != null && student.getLastName().equals(lastName)){
                    student.displayAll();
                    found = true;
                }
            }
            for(Faculty faculty: faculties){
                if(faculty != null && faculty.getLastName().equals(lastName)){
                    faculty.displayAll();
                    found = true;
                }
            }
            if(!found){
                System.out.println("No person found with that name");
            }
            System.out.println("Please enter 'back' to return to main menu;"
                    + " or a last name to search for that person");
            lastName = scanner.next();
        }
    }
    private void displayAll(){
        System.out.println("Please enter a type of person ('student', 'employee', 'faculty'); or 'back' to return to main menu");
        String type = scanner.next();
        switch(type){
            case "student":
                for(Student student: students){
                    if(student != null){
                        student.displayAll();
                    }
                }
                break;
            case "employee":
                for(CollegeEmployee employee: collegeEmployees){
                    if(employee != null){
                        employee.displayAll();
                    }
                }
                break;
            case "faculty":
                for(Faculty faculty: faculties){
                    if(faculty != null){
                        faculty.displayAll();
                    }
                }
                break;
        }
    }
}
