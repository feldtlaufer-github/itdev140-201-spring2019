/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhich_zookeeper;

import java.util.Scanner;

/**
 *
 * @author plain
 */
public class Controller {
    Animal[] zooList;
    String INSTR = "Welcome to the Zoo!";
    String DIRECT = "Please enter 'display' to display the animals in the zoo."
            + "\nEnter 'quit' to quit the program.";
    public Controller(){
        Mammal lion = new Mammal("Lion", "male", "carnivore", "Big cat field",
                10, 957678, "Leo", 200.0, 5);
        Mammal bear = new Mammal("Bear", "female", "omnivore", "Bear island",
                8, 989718, "Grizzly Barista", 500.0, 7);
        Mammal elephant = new Mammal("Elephant", "female", "herbivore", "Africa Island",
                15, 944748, "Dumbo", 1000.0, 12);
        
        Reptile snake = new Reptile("snake", "male", "herbivore", "Grassy field house",
                5, 678944, false, true);
        Reptile turtle = new Reptile("turtle", "male", "herbivore", "Central pond",
                18, 605647, true, false);
        Reptile gecko = new Reptile("gecko", "female", "herbivore", "Tropical house",
                15, 645033, false, true);
        
        Bird eagle = new Bird("Eagle", "male", "carnivore", "Building 53",
                9, 334448, false, true);
        Bird finch = new Bird("Finch", "female", "herbivore", "Building 23",
                3, 3940495, true, false);
        Bird parrot = new Bird("Parrot", "male", "herbivore", "Tropical Village",
                13, 345212, true, false);
     
        zooList = new Animal[]{lion, bear, elephant, snake, turtle, gecko, eagle, finch, parrot};
        
        
    }
    public void run(){
        System.out.println(INSTR);
        System.out.println(DIRECT);
        
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        while(!input.equals("quit")){
            if(input.equals("display")){
                for(Animal a: zooList){
                    System.out.println(a.toString() + "\n");
                }
            }
            
            input = scanner.next();
        }
        System.out.println("Thank you for coming to the Zoo");
    }
    
}
