/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhich_grocerylist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author plain
 */
public class Driver {
    private final String INTRO = "Welcome to Alex's Grocery List";
    private final String DIRECTIONS = "Please enter 'display' to view the current grocery list;"
                    + "\n'add' to add an item;"
                    + "\n'delete' to delete an item;"
                    + "\n'quit' to quit the program.";
    private Scanner scanner = new Scanner(System.in);
    private MyFileWriter fw = new MyFileWriter();
    private GroceryList theList = new GroceryList();
    
    public Driver(){
        //display intro and directions
        System.out.println(INTRO);
        System.out.println(DIRECTIONS);
        
        //input is what the user would like to do
        String input = scanner.next();
        
        //open the groceries file and make an array list of what's stored there
        File file = new File("groceries.txt");
        //create a new file if groceries doesn't already exist
        try {
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (Scanner inputFile = new Scanner(file)) {
                while (inputFile.hasNext()) {
                    theList.addToList(inputFile.next());
                }
            }
        catch (FileNotFoundException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //while user doesn't quit, switch on what they want to do
        while(!input.equals("quit")){
            switch(input){
                case "display":
                    System.out.println("\nGroceryList\n-----------");
                    theList.getList().forEach((s) -> {System.out.println(s);});
                    System.out.println();
                    break;
                case "add":
                    System.out.print("Enter the name of the grocery item to be added: ");
                    input = scanner.next();
                    System.out.println(theList.addToList(input));
                    System.out.println();
                    break;
                case "delete":
                    System.out.print("Enter the name of the grocery item to be deleted: ");
                    input = scanner.next();
                    System.out.println(theList.removeFromList(input));
                    System.out.println();
                    break;
            }
            System.out.println("Please enter 'display' to view the current grocery list;"
                    + "\n'add' to add an item;"
                    + "\n'delete' to delete an item;"
                    + "\n'quit' to quit the program.");
            input = scanner.next();
        }
        //when the user quits, save back to the file
        fw.write(theList.getList());
        System.out.println("Thank you for using GroceryList");
        
    }
    
}
