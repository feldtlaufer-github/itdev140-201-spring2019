package muhich_indivproject;

/**
 * The Manga class is a representation of Japanese graphic novels known by
 * the same name.
 * 
 * @author Alex Jerard Muhich
 */
public class Manga {
    private String isbn, title, author, volume, ownership;

    /**
     * 
     * @param isbn
     * @param title
     * @param author
     * @param volume
     * @param ownership 
     */
    public Manga(String isbn, String title, String author, String volume, String ownership) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.volume = volume;
        this.ownership = ownership;
    }

    @Override
    public String toString(){
        return "<html>ISBN: " + isbn + "<br>Title: " + title + "<br>Author: " + author
                 + "<br>Volume: " + volume + "<br>Own?: " + ownership + "</html>";
    }
    
    /**
     * 
     * @return
     */
    public String getIsbn() {
        return isbn;
    }
    /**
    * 
    * @param isbn 
    */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    /**
     * 
     * @return 
     */
    public String getTitle() {
        return title;
    }
    /**
     * 
     * @param title 
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * 
     * @return 
     */
    public String getAuthor() {
        return author;
    }
    /**
     * 
     * @param author 
     */
    public void setAuthor(String author) {
        this.author = author;
    }
    /**
     * 
     * @return 
     */
    public String getVolume() {
        return volume;
    }
    /**
     * 
     * @param volume 
     */
    public void setVolume(String volume) {
        this.volume = volume;
    }
    /**
     * 
     * @return 
     */
    public String getOwnership() {
        return ownership;
    }
    /**
     * 
     * @param ownership 
     */
    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }
    
}
