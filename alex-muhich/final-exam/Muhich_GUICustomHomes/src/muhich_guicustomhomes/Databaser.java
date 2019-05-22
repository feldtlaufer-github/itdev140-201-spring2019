
package muhich_guicustomhomes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex Jerard Muhich
 */
public class Databaser {
    private Connection connection = null;
    private Statement statement = null;
    public Databaser(){
        createTable();
    }
    private void createTable(){
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:finalexam.db");
            statement = connection.createStatement();
            String query = "CREATE TABLE IF NOT EXISTS HomeOrders ("
                    + "'firstname' TEXT, "
                    + "'lastname' TEXT, "
                    + "'address' TEXT, "
                    + "'city' TEXT, "
                    + "'state' TEXT, "
                    + "'zipcode' TEXT, "
                    + "'typeofhome' TEXT, "
                    + "'price' DOUBLE)";
            statement.execute(query);
            statement.close();
            connection.close();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Databaser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void update(HomeOrder oldOrder, HomeOrder newOrder){
        System.out.println(oldOrder);
        System.out.println(newOrder);
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:finalexam.db");
            connection.setAutoCommit(false);
            
            statement = connection.createStatement();
            String query = "UPDATE HomeOrders SET firstname = '" + newOrder.getFirstname() + "', "
                    + "lastname = '" + newOrder.getLastname() + "', "
                    + "address = '" + newOrder.getAddress() + "', "
                    + "city = '" + newOrder.getCity() + "', "
                    + "state = '" + newOrder.getState() + "', "
                    + "zipcode = '" + newOrder.getZipcode() + "', "
                    + "typeofhome = '" + newOrder.getTypeofhome() + "', "
                    + "price = " + newOrder.getPrice() + " WHERE "
                    + "firstname = '" + oldOrder.getFirstname() + "' AND "
                    + "lastname = '" + oldOrder.getLastname() + "' AND "
                    + "address = '" + oldOrder.getAddress() + "' AND "
                    + "city = '" + oldOrder.getCity() + "' AND "
                    + "state = '" + oldOrder.getState() + "' AND "
                    + "zipcode = '" + oldOrder.getZipcode() + "' AND "
                    + "typeofhome = '" + oldOrder.getTypeofhome() + "' AND "
                    + "price = " + oldOrder.getPrice()
                    ;
            
            statement.execute(query);
            statement.close();
            connection.commit();
            connection.close();
            
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Databaser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void delete(HomeOrder order){
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:finalexam.db");
            connection.setAutoCommit(false);
            
            statement = connection.createStatement();
            
            String query = "DELETE from HomeOrders where firstname='" + order.getFirstname() + "' "
                    + "AND lastname='" + order.getLastname() + "' "
                    + "AND address='" + order.getAddress() + "' "
                    + "AND city='" + order.getCity() + "' "
                    + "AND state='" + order.getState() + "' "
                    + "AND zipcode='" + order.getZipcode() + "' "
                    + "AND typeofhome='" + order.getTypeofhome() + "' "
                    + "AND price=" + order.getPrice()
                    + ";";
            statement.executeUpdate(query);
            statement.close();
            connection.commit();
            connection.close();
            
        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(Databaser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insert(HomeOrder order){
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:finalexam.db");
            connection.setAutoCommit(false);
            
            statement = connection.createStatement();
            String query = "INSERT INTO HomeOrders (firstname, lastname, address"
                    + ", city, state, zipcode, typeofhome, price) VALUES ("
                    + "'" + order.getFirstname() + "', '" + order.getLastname() + 
                    "', '" + order.getAddress() + "', '" + order.getCity() +
                    "', '" + order.getState() + "', '" + order.getZipcode() +
                    "', '" + order.getTypeofhome() + "', " + order.getPrice() + ");";
            statement.executeUpdate(query);
            statement.close();
            connection.commit();
            connection.close();
            
        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(Databaser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<HomeOrder> selectAll(){
        ArrayList<HomeOrder> orderList = new ArrayList<>();
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:finalexam.db");
            connection.setAutoCommit(false);
            
            statement = connection.createStatement();
            String query = "SELECT * FROM HomeOrders;";
            try(ResultSet resultSet = statement.executeQuery(query)){
                while(resultSet.next()){
                    String firstname = resultSet.getString("firstname");
                    String lastname = resultSet.getString("lastname");
                    String address = resultSet.getString("address");
                    String city = resultSet.getString("city");
                    String state = resultSet.getString("state");
                    String zipcode = resultSet.getString("zipcode");
                    String typeofhome = resultSet.getString("typeofhome");
                    Double price = resultSet.getDouble("price");
                    
                    orderList.add(new HomeOrder(firstname, lastname, address, city,
                            state, zipcode, typeofhome, price));
                }
            }
            
            statement.close();
            connection.commit();
            connection.close();
            
        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(Databaser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderList;
    }
}
