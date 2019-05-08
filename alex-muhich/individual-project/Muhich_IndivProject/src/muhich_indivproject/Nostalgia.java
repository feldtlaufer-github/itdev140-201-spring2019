
package muhich_indivproject;

/**
 * Nostalgia are books that don't have an ISBN because they are too old.
 * @author Alex Jerard Muhich
 */
public class Nostalgia extends Book{
    private String year;
    /**
     * Constructor
     * @param title
     * @param author
     * @param ownership
     * @param year 
     */
    public Nostalgia(String title, String author, String ownership, String year){
        super(title, author, ownership);
        this.year = year;
    }
    /**
     * toString mainly for JList
     * @return 
     */
    @Override
    public String toString(){
        return "<html>Title: " + getTitle() + "<br>Author: " + getAuthor()
                 + "<br>Year Published: " + year + "<br>Own?: " + getOwnership() + "</html>";
    }
    /**
     * Year Getter
     * @return 
     */
    public String getYear() {
        return year;
    }
    /**
     * Year Setter
     * @param year 
     */
    public void setYear(String year) {
        this.year = year;
    }
}
