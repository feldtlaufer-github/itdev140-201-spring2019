
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
        if(!doesTableExist()) createTable();
    }
    /**
     * Checks if there is a table called manga in the database
     * @return 
     */
    private boolean doesTableExist(){
        boolean result = false;
        try{
            //make a connection to the database
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:manga.db");
            
            //check if manga table exists in database
            statement = connection.createStatement();
            String sql = "SELECT name FROM sqlite_master WHERE type='table' AND name='manga'";
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                result = resultSet.next(); //if there is a next in resultSet, result will be true, otherwise false
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return result;
    }
    /**
     * Creates a table called manga with attributes isbn as primary key, title, author, volume, ownership
     */
    private void createTable(){
        try{
            //make a connection to the database
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:manga.db");
            
            //create a table called manga
            statement = connection.createStatement();
            String sql = "CREATE TABLE MANGA " +
                    "(ISBN TEXT PRIMARY KEY    NOT NULL," +
                    " TITLE             TEXT   NOT NULL, " +
                    " AUTHOR            TEXT   NOT NULL, " + 
                    " VOLUME            INT    NOT NULL, " +
                    " OWNERSHIP         TEXT    NOT NULL";
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
            
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    /**
     * Inserts a manga into the database
     * @param manga
     */
    public void insert(Manga manga){
        try{
            //attempt to make a connection to the database
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:manga.db");
            connection.setAutoCommit(false);
            
            statement = connection.createStatement();
            String sql = "INSERT INTO MANGA (ISBN,TITLE,AUTHOR,VOLUME,OWNERSHIP) " +
                    "VALUES (" + manga.getIsbn() + ", " + manga.getTitle() +
                    ", " + manga.getAuthor() + ", " + manga.getVolume()  + ", " + manga.getOwnership() + " );";
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
     * Grabs all manga from the database and returns what's found in an ArrayList
     * @return 
     */
    public ArrayList<Manga> selectAll(){
        ArrayList<Manga> mangaList = new ArrayList<>();
        try{
            //attempt to make a connection to the database
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:manga.db");
            connection.setAutoCommit(false);
            
            statement = connection.createStatement();
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM MANGA;")) {
                while(resultSet.next()){
                    //grab attributes of the manga
                    String isbn = resultSet.getString("isbn");
                    String title = resultSet.getString("title");
                    String author = resultSet.getString("author");
                    String volume = resultSet.getString("volume");
                    String ownership = resultSet.getString("ownership");
                    //make an object with those attributes and add it to the list
                    mangaList.add(new Manga(isbn, title, author, volume, ownership));
                }
            }
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return mangaList;
    }
    /**
     * Update an existing manga in the database with new data
     * @param key
     * @param value
     * @param isbn 
     */
    public void update(String key, String value, String isbn){
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:manga.db");
            connection.setAutoCommit(false);
            
            statement = connection.createStatement();
            String sql = "UPDATE MANGA set " + key + " = " +
                value + " where ISBN=" + isbn + ";";
            statement.executeUpdate(sql);
            connection.commit();
            
            statement.close();
            connection.close();
            
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    /**
     * Delete an existing manga from the database
     * @param isbn 
     */
    public void delete(String isbn){
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:manga.db");
            connection.setAutoCommit(false);
            
            statement = connection.createStatement();
            String sql = "DELETE from MANGA where ISBN=" + isbn + ";";
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
