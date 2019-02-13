/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhichweek3demo;

/**
 *
 * @author plain
 */
public class Practice {
    int number;
    String[] family = {"Alex", "Steve", "Drew", "Francine"};
    public Practice(){
        number = acceptValues(5, 6);
        System.out.println(number);
        displayArray();
        displayHorizontal();
    }
    public int acceptValues(int a, int b){
        int result;
        
        result = a + b;
        
        return result;
    }
    public void displayArray(){
        for(int i = 0; i < family.length; i++){
            System.out.println(family[i]);
        }
    }
    public void displayHorizontal(){
        int i = 0;
        while(i < family.length){
            System.out.print(family[i] + " ");
            i++;
        }
        System.out.println();
    }
}
