
package muhich_indivproject;

/**
 * 
 * @author Alex Jerard Muhich
 */
public class Book {
    private String title, author, ownership;
    public Book(String title, String author, String ownership){
        this.title = title;
        this.author = author;
        this.ownership = ownership;
    }
    
    @Override
    public String toString(){
        return "<html>Title: " + title + "<br>Author: " + author
                 + "<br>Own?: " + ownership + "</html>";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }
    
    
}
