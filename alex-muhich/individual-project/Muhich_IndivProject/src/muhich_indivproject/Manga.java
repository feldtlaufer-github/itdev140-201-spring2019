package muhich_indivproject;

/**
 * The Manga class is a representation of Japanese graphic novels known by
 * the same name.
 * 
 * @author Alex Jerard Muhich
 */
public class Manga {
    private String isbn, title, author;
    private int volume;
    private boolean ownership;

    /**
     * 
     * @param isbn
     * @param title
     * @param author
     * @param volume
     * @param ownership 
     */
    public Manga(String isbn, String title, String author, int volume, boolean ownership) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.volume = volume;
        this.ownership = ownership;
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
    public int getVolume() {
        return volume;
    }
    /**
     * 
     * @param volume 
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }
    /**
     * 
     * @return 
     */
    public boolean getOwnership() {
        return ownership;
    }
    /**
     * 
     * @param ownership 
     */
    public void setOwnership(boolean ownership) {
        this.ownership = ownership;
    }
    
}
