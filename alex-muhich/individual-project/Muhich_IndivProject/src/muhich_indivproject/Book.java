
package muhich_indivproject;

/**
 * Represents a generic book
 * @author Alex Jerard Muhich
 */
public class Book {
    //title and author of book, ownership represents whether the user owns the book
    private String title, author, ownership;
    /**
     * Book Constructor
     * @param title
     * @param author
     * @param ownership 
     */
    public Book(String title, String author, String ownership){
        this.title = title;
        this.author = author;
        this.ownership = ownership;
    }
    /**
     * toString Method
     * @return
     */
    @Override
    public String toString(){
        return "<html>Title: " + title + "<br>Author: " + author
                 + "<br>Own?: " + ownership + "</html>";
    }
    /**
     * Title Getter
     * @return
     */
    public String getTitle() {
        return title;
    }
    /**
     * Title Setter
     * @param title 
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * Author Getter
     * @return 
     */
    public String getAuthor() {
        return author;
    }
    /**
     * Author Setter
     * @param author 
     */
    public void setAuthor(String author) {
        this.author = author;
    }
    /**
     * Ownership Getter
     * @return 
     */
    public String getOwnership() {
        return ownership;
    }
    /**
     * Ownership Setter
     * @param ownership 
     */
    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }
    
    
}
