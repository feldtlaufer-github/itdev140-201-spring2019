/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhich_filedemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author plain
 */
public class TodoList {
    Scanner scanner  = new Scanner(System.in);
    String todoItem;
    
    public void doIt(){
        //get a filename from the user
        System.out.print("Enter the filename: ");
        String fileName = scanner.nextLine();
        
        //open the file
        File file = new File(fileName);
        try (Scanner inputFile = new Scanner(file)) {
                //Read todo list items from file until none left
                while (inputFile.hasNext()) {
                    //read the next todo item
                    todoItem = inputFile.nextLine();
                    
                    //display the todo item to the console
                    System.out.println(todoItem);
                }
                //close the file
            }
        catch (FileNotFoundException ex) {
            Logger.getLogger(TodoList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
