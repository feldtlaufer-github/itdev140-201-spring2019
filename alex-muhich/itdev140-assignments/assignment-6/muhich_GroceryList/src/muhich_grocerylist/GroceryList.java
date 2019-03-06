/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhich_grocerylist;

import java.util.ArrayList;

/**
 *
 * @author plain
 */
public class GroceryList {
    private ArrayList<String> gList;
    public GroceryList(){
        gList = new ArrayList();
    }
    public ArrayList<String> getList(){
        return gList;
    }
    public void addToList(String s){
        gList.add(s);
    }
    public void removeFromList(int index){
        gList.remove(index);
    }
}
