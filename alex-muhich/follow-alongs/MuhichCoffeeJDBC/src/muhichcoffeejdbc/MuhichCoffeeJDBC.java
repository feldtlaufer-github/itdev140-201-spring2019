/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhichcoffeejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author plain
 */
public class MuhichCoffeeJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final String DB_URL = "jdbc:derby:CoffeeDB;create=true";
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            dropTables(conn);
            buildCoffeeTable(conn);
            //buildCustomerTable(conn);
            //buildUnpaidOrderTable(conn);
            conn.commit();
            conn.close();
            
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
    public static void dropTables(Connection conn){
        System.out.println("Checking for existing tables");
        try{
            Statement stmt = conn.createStatement();
            try{
                stmt.execute("DROP TABLE UnpaidOrder");
                System.out.println("UnpaidOrder table dropped.");
            }catch(SQLException ex){
                //do nothing, table didn't exist
            }
            try{
                stmt.execute("DROP TABLE Customer");
                System.out.println("Customer table dropped.");
            }catch(SQLException ex){
                //do nothing, table didn't exist
            }
            try{
                stmt.execute("DROP TABLE Coffee");
                System.out.println("Coffee table dropped.");
            }catch(SQLException ex){
                //do nothing, table didn't exist
            }
            
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    public static void buildCoffeeTable(Connection conn){
        try{
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE Coffee(" + 
                    "Description CHAR(25), " +
                    "ProdNum CHAR(10) NOT NULL PRIMARY KEY, " +
                    "Price DOUBLE )");
            //insert row1
            stmt.execute("INSERT INTO Coffee Values ( " + 
                    "'Bolivian Dark', '14-001', 8.95)");
            
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
