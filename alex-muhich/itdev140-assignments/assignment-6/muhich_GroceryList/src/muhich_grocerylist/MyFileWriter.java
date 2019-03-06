/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhich_grocerylist;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author plain
 */
public class MyFileWriter {
    public void write(ArrayList<String> gList){
        try (FileWriter outputFile = new FileWriter("groceries.txt", false)) {
            for(int i = 0; i < gList.size(); i++){
                outputFile.write(gList.get(i) + "\n");
            }
        }
        catch (IOException ex) {
            Logger.getLogger(MyFileWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
