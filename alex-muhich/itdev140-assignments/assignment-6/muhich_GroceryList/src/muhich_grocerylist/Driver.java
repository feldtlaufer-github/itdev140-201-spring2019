/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhich_grocerylist;

import java.util.Scanner;

/**
 *
 * @author plain
 */
public class Driver {
    private final String INTRO = "";
    private final String DIRECTIONS = "";
    private Scanner scanner;
    private FileWriter fw;
    private GroceryList gList;
    public Driver(){
        scanner = new Scanner(System.in);
        
        System.out.println(INTRO);
        System.out.println(DIRECTIONS);
        String input = scanner.next();
        
        while(!input.equals("quit")){
            switch(input){
                case "display":
                    
                    break;
                case "add":
                    
                    break;
                case "delete":
                    
                    break;
            }
            
        }
        fw.write(gList.getList());
        System.out.println("Thank you for using GroceryList");
        
    }
    
}
