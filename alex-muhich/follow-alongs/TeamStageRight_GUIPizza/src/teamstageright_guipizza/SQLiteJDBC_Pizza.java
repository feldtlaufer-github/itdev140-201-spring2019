
package teamstageright_guipizza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author 
 */
public class SQLiteJDBC_Pizza {
    public SQLiteJDBC_Pizza(){
        final String DB_URL = "jdbc:derby:GUIPizzaDB;create=true";
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            buildCustomerTable(conn);
            buildOrderTable(conn);
            buildPizzaTable(conn);
            
            conn.commit();
            conn.close();
            
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    /**
     * phone number is unique identifer
     * returns customer information (name, address, phone)
     * @param phoneNum 
     * @return  
     */
    public ArrayList<Customer> selectCustomerInfo(String phoneNum){
        try(Connection conn = DriverManager.getConnection("jdbc:derby:GUIPizzaDB;")){
            Statement stmt = conn.createStatement();
            stmt.execute("SELECT Name, Address, PhoneNum, "
                    + "Orders.DeliveryMethod AS Delivery, Orders.OrderNum AS OrderNum, "
                    + "Pizzas.PizzaId AS PizzaId, Pizzas.Size AS Size, Pizzas.Toppings AS Toppings"
                    + "FROM Customers "
                    + "INNER JOIN Orders ON Customers.OrderNum = Orders.OrderNum "
                    + "INNER JOIN Pizzas ON Orders.PizzaId = Pizzas.PizzaId"
                    + "WHERE PhoneNum LIKE '%" + phoneNum + "%'");
            try (ResultSet resultSet = stmt.executeQuery("")) { //TODO: remember to replace "" with the query
                ArrayList<Customer> customerList = new ArrayList<>();
                HashMap<String, Customer> customerMap = new HashMap<>();
                
                while(resultSet.next()){
                    String name = resultSet.getString("Name");
                    String address = resultSet.getString("Address");
                    String phone = resultSet.getString("PhoneNum");
                    
                    //we haven't seen this customer before
                    if(!customerMap.containsKey(phone)){
                        ArrayList<Pizza> pizzaList = new ArrayList<>();
                        pizzaList.add(new Pizza(resultSet.getString("Toppings"),
                                        resultSet.getDouble("PizzaId"),
                                        resultSet.getString("Size")));
                        ArrayList<Order> orderList = new ArrayList<>();
                        orderList.add(new Order(resultSet.getString("DeliveryMethod"),
                                                resultSet.getDouble("OrderNum"),
                                                pizzaList));
                        customerMap.put(phone, new Customer(name, address, phone, orderList));
                        
                        
                    }else{//we've already seen this customer
                        //we haven't seen an order from this customer before
                        if(customerMap.get(phone).getOrderList().isEmpty()){
                            ArrayList<Pizza> pizzaList = new ArrayList<>();
                            pizzaList.add(new Pizza(resultSet.getString("Toppings"),
                                            resultSet.getDouble("PizzaId"),
                                            resultSet.getString("Size")));
                            ArrayList<Order> orderList = new ArrayList<>();
                            orderList.add(new Order(resultSet.getString("DeliveryMethod"),
                                                    resultSet.getDouble("OrderNum"),
                                                    pizzaList));
                            customerMap.put(phone, new Customer(name, address, phone, orderList));
                        }else{//we have seen an order from this customer before
                            //for each order the customer has
                            for(int i = 0; i < customerMap.get(phone).getOrderList().size(); i++){
                                //if the query line's ordernum matches an ordernum in the orderlist
                                if(customerMap.get(phone).getOrderList().get(i).getOrderNum() ==
                                        resultSet.getDouble("OrderNum")){
                                    //add this pizza to the orderlist
                                    customerMap.get(phone).getOrderList().get(i).getPizzaList().add(
                                                        new Pizza(resultSet.getString("Toppings"),
                                                                  resultSet.getDouble("PizzaId"),
                                                                  resultSet.getString("Size")));
                                }
                            }   
                        }
                    }
                }
                //grab each customer in customermap and put it into customerList and return.
            }
        }catch(SQLException ex){
            
        }
        return customerList;
    }
    
    private void buildCustomerTable(Connection conn){
        try{
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE Customers(" + 
                    "Name CHAR(25), " +
                    "Address CHAR(50), " +
                    "PhoneNum CHAR(12) NOT NULL PRIMARY KEY, " +
                    "OrderNum DOUBLE, " +
                    "FOREIGN KEY (OrderNum) REFERENCES Orders(OrderNum))");
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
    private void buildOrderTable(Connection conn){
        try{
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE Orders(" + 
                    "DeliveryMethod CHAR(12), " +
                    "PizzaId DOUBLE, " +
                    "OrderNum DOUBLE, " +
                    "FOREIGN KEY (PizzaId) REFERENCES Pizzas(PizzaId))");
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
    private void buildPizzaTable(Connection conn){
        try{
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE Pizzas(" + 
                    "Size CHAR(10), " +
                    "PizzaId DOUBLE, " +
                    "Toppings CHAR(100))");
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
