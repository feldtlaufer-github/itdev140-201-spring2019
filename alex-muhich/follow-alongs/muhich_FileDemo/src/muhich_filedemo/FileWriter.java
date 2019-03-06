/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhich_filedemo;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author plain
 */
public class FileWriter {
    String fileName;
    String todoItem;
    int numItems;
    Scanner scanner = new Scanner(System.in);
    
    public void controlIt(){
        //get the number of todo items from user
        System.out.println("How many todo items will you enter?");
        numItems = scanner.nextInt();
        
        //consume the remaining new line character
        scanner.nextLine();
        
        //get the fileName
        System.out.print("Enter the filename: ");
        fileName = scanner.nextLine();
        
        try (PrintWriter outputFile = new PrintWriter(fileName)) {
                for (int i = 1; i <= numItems; i++) {
                    //get the name of the todolist item
                    System.out.print("Enter the name of the todo item number " + i + ": ");
                    todoItem = scanner.nextLine();
                    
                    //write the todo item to the file
                    outputFile.println(todoItem);
                }
                //close the file
                outputFile.close();
                System.out.println("Data entered");
            }
        catch (FileNotFoundException ex) {
            Logger.getLogger(FileWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
