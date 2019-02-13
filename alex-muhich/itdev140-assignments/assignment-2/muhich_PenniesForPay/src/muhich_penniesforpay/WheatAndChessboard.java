/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhich_penniesforpay;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author Alex Jerard Muhich
 */
public class WheatAndChessboard {
    int input;
    public WheatAndChessboard(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a period of time worked");
        System.out.println("Enter '-1' to quit.");
        input = scanner.nextInt();
        while(input != -1){
            if(input < 1){
                System.out.println("Invalid input");
                input = scanner.nextInt();
            }else{
                double sum = 0.0;
                double[] table = new double[input];
                for(int i = 0; i < input; i++){
                    table[i] = Math.pow(2, i)/100;
                    sum+=table[i];
                }
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                System.out.print("[ ");
                for(int i = 0; i < table.length; i++){
                    System.out.print("(Day " + (i+1) + " ->) " + nf.format(table[i]) + " ");
                    if(i == table.length-1){
                        System.out.println("]");
                    }
                }
                System.out.println("Total: " + nf.format(sum));
                input = scanner.nextInt();
            }
        }
        
    }
    
}
