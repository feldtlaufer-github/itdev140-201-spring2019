package muhich_indivproject;

/**
 * The Manga class is a representation of Japanese graphic novels known by
 * the same name.
 * 
 * @author Alex Jerard Muhich
 */
public class Manga extends Book{
    private String isbn, volume;

    /**
     * 
     * @param isbn
     * @param title
     * @param author
     * @param volume
     * @param ownership 
     */
    public Manga (String isbn, String title, String author, String volume, String ownership) {
        super(title, author, ownership);
        this.isbn = isbn;
        this.volume = volume;
    }

    @Override
    public String toString(){
        return "<html>ISBN: " + isbn + "<br>Title: " + getTitle() + "<br>Author: " + getAuthor()
                 + "<br>Volume: " + volume + "<br>Own?: " + getOwnership() + "</html>";
    }
    /**
     * 
     * @return 
     */
    public String getIsbn(){
        return isbn;
    }
    /**
     * 
     * @param isbn 
     */
    public void setIsbn(String isbn){
        this.isbn = isbn;
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
    
}
