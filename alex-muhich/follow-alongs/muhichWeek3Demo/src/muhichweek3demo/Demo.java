/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhichweek3demo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Alex Jerard Muhich
 */
public class Demo {
    ArrayList<String> names = new ArrayList<>();
    public Demo(){
        names.add("Smith");
        names.add("Wessen");
        names.add("George");
        names.add("Angela");
        names.size();
        int nameSize = names.size() - 1; //last index of names
        String name2 = names.get(1);
        String name3 = names.set(2, "Susie"); //replaces index 2 with "Susie"
        System.out.println(names);
        names.remove(3);
        System.out.println(names);
    }
    public void moreDemo(){
        int[] num1 = {313, 367, 379};
        int[] num2 = num1;
        System.out.println("num1 value: " + num1[2] + "\n"
                + "num2 value: "  + num2[2]);
        num2[2] = 414;
        System.out.println("num1 value: " + num1[2] + "\n"
                + "num2 value: "  + num2[2]);
        
        //use Arrays.copyOf(array, array.length) to copy array values.
        int[] num3 = Arrays.copyOf(num1, num1.length);
        System.out.println("num1 value: " + num1[2] + "\n"
                + "num2 value: "  + num2[2] + "\n"
                + "num3 value: " + num3[2]);
        num3[2] = 777;
        System.out.println("num1 value: " + num1[2] + "\n"
                + "num2 value: "  + num2[2] + "\n"
                + "num3 value: " + num3[2]);
        
        //System.arraycopy to copy arrays without pointing to the original address
        //arraycopy(source array, starting element, destination array, starting element, length...)
        char[] copyFrom = { 'd', 'e', 'c', 'a', 'f', 'f', 'e', 'i', 'n', 'a', 't', 'e', 'd'};
        char[] copyTo = new char[7];
        System.arraycopy(copyFrom, 2, copyTo, 0, 7);
        System.out.println(copyTo);
        
        
        String[] strung = new String[9];
        strung[0] = "Merrily";
        System.out.printf("%s we go along ", strung[0]); //%s is a placeholder for a string when using printf
        
        String stringLike = "Happy String";
        int intLike = 2999;
        double doubleLike = 12312.034;
        System.out.printf("The text is here with a %s that can"
                + " also be an integer %d, or a double %,.2f%n", stringLike, intLike, doubleLike);
        
        int[] numbers = {45, 73, 29};
        int total = 0;
        for(int element: numbers){
            total += element;
        }
        System.out.println(Arrays.toString(numbers) + " Total: " + total);
    }
}
