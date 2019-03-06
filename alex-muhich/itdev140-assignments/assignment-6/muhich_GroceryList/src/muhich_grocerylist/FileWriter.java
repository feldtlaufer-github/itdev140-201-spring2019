/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhich_grocerylist;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author plain
 */
public class FileWriter {
    public void write(ArrayList gList){
        try (PrintWriter outputFile = new PrintWriter("groceries.txt")) {
            for(int i = 0; i < gList.size(); i++){
                outputFile.println(gList.get(i));
            }
            outputFile.close();
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(FileWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
