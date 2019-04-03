/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhich_guibmi;

/**
 *
 * @author plain
 */
public class Calculation {
    
    public double calculateBMI(double weight, double height){
        return ((weight * 703)/Math.pow(height, 2));
    }
    
}
