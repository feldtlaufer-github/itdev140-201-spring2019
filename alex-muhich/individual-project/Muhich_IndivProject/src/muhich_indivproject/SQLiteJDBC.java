
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
            connection = DriverManager.getConnection("jdbc:sqlite:manga.db");
            
            //create a table called manga
            statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS Manga ('isbn' TEXT,'title' TEXT,'author' TEXT,'volume' TEXT,'ownership' TEXT)";
            statement.execute(sql);
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
            String sql = "INSERT INTO Manga (isbn,title,author,volume,ownership) " +
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
    public ArrayList<Manga> selectWhere(String _isbn, String _title, String _author, String _volume, String _own){
        ArrayList<Manga> mangaList = new ArrayList<>();
        try{
            //attempt to make a connection to the database
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:manga.db");
            connection.setAutoCommit(false);
            
            statement = connection.createStatement();
            
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SELECT * FROM Manga WHERE 1 = 1 ");
            if(!_isbn.isEmpty()) {
                stringBuilder.append(" AND isbn LIKE ").append(_isbn);
            }
            if(!_title.isEmpty()) {
                stringBuilder.append(" AND title LIKE ").append(_title);
            }
            if(!_author.isEmpty()) {
                stringBuilder.append(" AND author LIKE ").append(_author);
            }
            if(!_volume.isEmpty()) {
                stringBuilder.append(" AND volume LIKE ").append(_volume);
            }
            if(!_own.isEmpty()) {
                stringBuilder.append(" AND ownership LIKE ").append(_own);
            }
            
            try (ResultSet resultSet = statement.executeQuery(stringBuilder.toString())) {
                while(resultSet.next()){
                    //make an object with the attributes and add it to the list
                    mangaList.add(new Manga(resultSet.getString("isbn"),
                            resultSet.getString("title"),
                            resultSet.getString("author"),
                            resultSet.getString("volume"),
                            resultSet.getString("ownership")));
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
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM Manga;")) {
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
            String sql = "UPDATE Manga set " + key + " = " +
                value + " where isbn=" + isbn + ";";
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
            String sql = "DELETE from Manga where isbn=" + isbn + ";";
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
