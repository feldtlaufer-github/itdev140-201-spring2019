/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhichweek1fun;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author plain
 */
public class Pizza {
    String name;
    int numPizzas;
    double pizzaPrice;
    double totalCost;
    Scanner input;
    DecimalFormat df;
    
    public Pizza(){
        this.input = new Scanner(System.in);
        df = new DecimalFormat("#.00");
        this.totalCost = 0.00;
        this.pizzaPrice = 10.00;
        this.numPizzas = 0;
        
        pizzaOrder();
        calculateTotal();
        displayOrder();
    }
    public void pizzaOrder(){
        System.out.println("Enter your name: ");
        name = input.nextLine();
        System.out.println("How many pizzas do you want?");
        numPizzas = input.nextInt();
    }
    public void calculateTotal(){
        totalCost = numPizzas * pizzaPrice;
    }
    public void displayOrder(){
        System.out.println("Hello " + name);
        System.out.println("You ordered " + numPizzas + " pizzas");
        System.out.println("Your Order Total: $" + df.format(totalCost));
    }
}
