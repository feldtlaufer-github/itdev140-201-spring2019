package muhich_mybmi;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Alex Jerard Muhich
 */
public class BMI {
    double height, weight, bmi;
    Scanner input;
    DecimalFormat df;
    public BMI(){
        input = new Scanner(System.in);
        height = 0.0;
        weight = 0.0;
        df = new DecimalFormat("#.##");
        
        getHeight();
        getWeight();
        bmi = calculateBMI(height, weight);
        displayBMI();
    }
    public void getHeight(){
        System.out.println("How tall are you in inches?");
        height = input.nextDouble();
    }
    public void getWeight(){
        System.out.println("How much do you weigh in lbs?");
        weight = input.nextDouble();
    }
    public double calculateBMI(double h, double w){
        return (w * 703)/Math.pow(h, 2);
    }
    public void displayBMI(){
        System.out.println("Your BMI is " + df.format(bmi));
        if(bmi < 18.5){
            System.out.println("You are underweight!");
        }else if(bmi > 25){
            System.out.println("You are overweight!");
        }else{
            System.out.println("Your weight is optimal!");
        }
    }
}
