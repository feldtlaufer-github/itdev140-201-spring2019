/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhich_indivproject;

/**
 * Nostalgia are books that don't have an ISBN because they are too old.
 * @author Alex Jerard Muhich
 */
public class Nostalgia extends Book{
    private String year;
    public Nostalgia(String title, String author, String year, String ownership){
        super(title, author, ownership);
        this.year = year;
    }
    
    @Override
    public String toString(){
        return "<br>Title: " + getTitle() + "<br>Author: " + getAuthor()
                 + "<br>Year Published: " + year + "<br>Own?: " + getOwnership() + "</html>";
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    
    
    
}
