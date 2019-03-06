/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhich_filedemo;

/**
 *
 * @author Alex Jerard Muhich
 */
public class Muhich_FileDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileWriter fw = new FileWriter();
        fw.controlIt();
        
        TodoList tdl = new TodoList();
        tdl.doIt();
    }
    
}
