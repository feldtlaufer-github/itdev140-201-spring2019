
package muhich_indivproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author Alex Jerard Muhich
 */
public class SQLiteJDBC {
    private Connection connection = null;
    private Statement statement = null;
    /**
     * Constructor
     */
    public SQLiteJDBC(){
        //if there isn't a manga table, make one
        createTableIfNotExists();
    }
    /**
     * Creates a table called manga with attributes isbn as primary key, title, author, volume, ownership
     */
    private void createTableIfNotExists(){
        try{
            //make a connection to the database
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:books.db");
            
            //create a table called manga
            statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS Books ('isbn' TEXT,'title'"
                    + " TEXT,'author' TEXT,'volume' TEXT,'ownership' TEXT,'year' TEXT)";
            statement.execute(sql);
            statement.close();
            connection.close();
            
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    public void insertBook(String _isbn, String _title, String _author, String _volume,
            String _ownership, String _year){
        try{
         //attempt to make a connection to the database
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:books.db");
            connection.setAutoCommit(false);
            
            statement = connection.createStatement();
            String sql;
            if(_isbn != null && _volume != null){
                Manga book = new Manga(_isbn, _title, _author, _volume, _ownership);
                sql = "INSERT INTO Books (isbn,title,author,volume,ownership,year) " +
                    "VALUES ('" + book.getIsbn() + "', '" + book.getTitle() +
                    "', '" + book.getAuthor() + "', '" + book.getVolume()  +
                    "', '" + book.getOwnership() + "', NULL );";
            }else if(_year != null){
                Nostalgia book = new Nostalgia(_title, _author, _ownership, _year);
                sql = "INSERT INTO Books (isbn,title,author,volume,ownership,year) " +
                    "VALUES (NULL, '" + book.getTitle() +
                    "', '" + book.getAuthor() + "', NULL, '" + book.getOwnership() +
                    "', '" + book.getYear() + "' );";
            }else{
                Book book = new Book(_title, _author, _ownership);
                sql = "INSERT INTO Books (isbn,title,author,volume,ownership,year) " +
                    "VALUES (NULL, '" + book.getTitle() +
                    "', '" + book.getAuthor() + "', NULL, '" + book.getOwnership() +
                    "', NULL );";
            }          
            
            statement.executeUpdate(sql);
            statement.close();
            connection.commit();
            connection.close();
            
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    /**
     * 
     * @param _isbn
     * @param _title
     * @param _author
     * @param _volume
     * @param _own
     * @param _year
     * @return 
     */
    public ArrayList<Book> selectBookWhere(String _isbn, String _title,
            String _author, String _volume, String _own, String _year){
        ArrayList<Book> bookList = new ArrayList<>();
        try{
            //attempt to make a connection to the database
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:books.db");
            connection.setAutoCommit(false);
            
            statement = connection.createStatement();
            
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SELECT * FROM Books WHERE 1 = 1 ");
            if(!_isbn.isEmpty()) {
                stringBuilder.append(" AND isbn LIKE '%").append(_isbn).append("%'");
            }
            if(!_title.isEmpty()) {
                stringBuilder.append(" AND title LIKE '%").append(_title).append("%'");
            }
            if(!_author.isEmpty()) {
                stringBuilder.append(" AND author LIKE '%").append(_author).append("%'");
            }
            if(!_volume.isEmpty()) {
                stringBuilder.append(" AND volume LIKE '%").append(_volume).append("%'");
            }
            if(!_own.isEmpty()) {
                stringBuilder.append(" AND ownership LIKE '%").append(_own).append("%'");
            }
            if(!_year.isEmpty()) {
                stringBuilder.append(" AND year LIKE '%").append(_year).append("%'");
            }
            
            try (ResultSet resultSet = statement.executeQuery(stringBuilder.toString())) {
                while(resultSet.next()){
                    //grab attributes of the book
                    String isbn = resultSet.getString("isbn");
                    String title = resultSet.getString("title");
                    String author = resultSet.getString("author");
                    String volume = resultSet.getString("volume");
                    String ownership = resultSet.getString("ownership");
                    String year = resultSet.getString("year");
                    if(isbn != null && volume != null){
                        bookList.add(new Manga(isbn, title, author, volume, ownership));
                    }else if(year != null){
                        bookList.add(new Nostalgia(title, author, ownership, year));
                    }else{
                        bookList.add(new Book(title, author, ownership));
                    }
                }
            }
            statement.close();
            connection.close();
        }catch(ClassNotFoundException | SQLException e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return bookList;
    }
    public ArrayList<Book> selectAllBooks(){
        ArrayList<Book> bookList = new ArrayList<>();
        try{
            //attempt to make a connection to the database
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:books.db");
            connection.setAutoCommit(false);
            
            statement = connection.createStatement();
            try(ResultSet resultSet = statement.executeQuery("SELECT * FROM Books;")){
                while(resultSet.next()){
                    //grab attributes of the book
                    String isbn = resultSet.getString("isbn");
                    String title = resultSet.getString("title");
                    String author = resultSet.getString("author");
                    String volume = resultSet.getString("volume");
                    String ownership = resultSet.getString("ownership");
                    String year = resultSet.getString("year");
                    if(isbn != null && volume != null){
                        bookList.add(new Manga(isbn, title, author, volume, ownership));
                    }else if(year != null){
                        bookList.add(new Nostalgia(title, author, year, ownership));
                    }else{
                        bookList.add(new Book(title, author, ownership));
                    }
                }
            }
            statement.close();
            connection.close();
            
        }catch(ClassNotFoundException | SQLException e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return bookList;
    }
    /**
     * Delete an existing book from the database
     * @param title
     * @param author
     * @param isbn 
     * @param own 
     * @param volume 
     * @param year 
     */
    public void delete(String title, String author, String own, String isbn, String volume, String year){
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:books.db");
            connection.setAutoCommit(false);
            
            statement = connection.createStatement();
            
            String sql = "DELETE from Books where title='" + title + "' "
                    + "AND author='" + author + "' AND ownership='" + own + "'";
            if(isbn != null) sql+=" AND isbn='" + isbn + "'";
            if(volume != null) sql+=" AND volume='" + volume + "'";
            if(year != null) sql+=" AND year='" + year + "'";
            
            sql+=";";
            statement.executeUpdate(sql);
            connection.commit();
            
            statement.close();
            connection.close();
            
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
