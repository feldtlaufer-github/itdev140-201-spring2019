
package teamstageright_guipizza;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
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
            buildPizzaTable(conn);
            buildOrderTable(conn);
            buildCustomerTable(conn);
            
        }catch(SQLException ex){
            System.out.println("Error Main: " + ex.getMessage());
        }
    }
    /**
     * deletes all of the customer data with that phone number
     * @param phoneNum 
     */
    public void delete(String phoneNum){
        try(Connection conn = DriverManager.getConnection("jdbc:derby:GUIPizzaDB;")){
            Statement stmt = conn.createStatement();
            
            stmt.execute("DELETE FROM Customers WHERE PhoneNum = '" + phoneNum + "'");
                        
        }catch(SQLException ex){
            System.out.println("Error Delete: " + ex.getMessage());
        }
    }
    
    /**
     * Takes in a phonenumber and the new customer information
     * updating a phonenumber is not allowed, must delete then re-insert
     * @param phoneNum
     * @param newCustomer 
     */
    
    public void update(String phoneNum, Customer newCustomer){
        try(Connection conn = DriverManager.getConnection("jdbc:derby:GUIPizzaDB;")){
            Statement stmt = conn.createStatement();
            //name address, phone
            stmt.execute("UPDATE Customers "
                    + "SET Name = '" + newCustomer.getName() + "', "
                        + "Address = '" + newCustomer.getAddress() + "', "
                    + "WHERE PhoneNum = '" + phoneNum + "'"
            );
            for(int i = 0; i < newCustomer.getOrderList().size(); i++){
                stmt.execute("UPDATE Orders "
                    + "SET DeliveryMethod = '" + newCustomer.getOrderList().get(i).getDeliveryMethod() + "' "
                    + "WHERE OrderNum = " + newCustomer.getOrderList().get(i).getOrderNum()
                );
            }
            for(int i = 0; i < newCustomer.getOrderList().size(); i++){
                for(int j = 0; j < newCustomer.getOrderList().get(i).getPizzaList().size(); j++){
                    stmt.execute("UPDATE Pizzas "
                        + "SET Size = '" + newCustomer.getOrderList().get(i).getPizzaList().get(j).getSize() + "', "
                            + "Toppings = '" + newCustomer.getOrderList().get(i).getPizzaList().get(j).getToppings() + "' "
                        + "WHERE PizzaId = " + newCustomer.getOrderList().get(i).getPizzaList().get(j).getPizzaId()
                );
                }
            }
            
            
            
        }catch(SQLException ex){
            System.out.println("Error Update: " + ex.getMessage());
        }
    }
    /**
     * takes in a customer object and inserts it into the db
     * @param c 
     */
    public void insertCustomerInfo(Customer c){
        try(Connection conn = DriverManager.getConnection("jdbc:derby:GUIPizzaDB;")){
            Statement stmt = conn.createStatement();
            
            //string toppings, int pizza id, string size
            for(int i = 0; i < c.getOrderList().size(); i++){
                for(int j = 0; j < c.getOrderList().get(i).getPizzaList().size(); j++){
                    stmt.execute("INSERT INTO Pizzas VALUES ( '"
                    + c.getOrderList().get(i).getPizzaList().get(j).getToppings() + "', "
                    + c.getOrderList().get(i).getPizzaList().get(j).getPizzaId() + ", '"
                    + c.getOrderList().get(i).getPizzaList().get(j).getSize()
                    + "' )");
                }
            }
            //string delivery method, int pizzaid, int orderid
            for(int i = 0; i < c.getOrderList().size(); i++){
                for(int j = 0; j < c.getOrderList().get(i).getPizzaList().size(); j++){
                    stmt.execute("INSERT INTO Orders VALUES ( '"
                        + c.getOrderList().get(i).getDeliveryMethod() + "', "
                        + c.getOrderList().get(i).getPizzaList().get(j).getPizzaId() + ", "
                        + c.getOrderList().get(i).getOrderNum()
                        + " )");
                }
            }
            //string name, string address, string phonenum, int orderid
            for(int i = 0; i < c.getOrderList().size(); i++){
                stmt.execute("INSERT INTO Customers VALUES ( '"
                        + c.getName() + "', '"
                        + c.getAddress() + "', '"
                        + c.getPhone() + "', "
                        + c.getOrderList().get(i).getOrderNum()
                        + " )");
            }
            
        }catch(SQLException ex){
            System.out.println("Error Insert: " + ex.getMessage());
        }
    }
    /**
     * Takes a phone number string and returns an arraylist of customers
     * with that phone number
     * @param phoneNum String
     * @return
     */
    public ArrayList<Customer> selectCustomerInfo(String phoneNum){
        HashMap<String, Customer> customerMap = new HashMap<>();
        try(Connection conn = DriverManager.getConnection("jdbc:derby:GUIPizzaDB;")){
            Statement stmt = conn.createStatement();
            
            try (ResultSet resultSet = stmt.executeQuery("SELECT Name, Address, PhoneNum, "
                    + "Orders.DeliveryMethod AS Delivery, Orders.OrderNum AS OrderNum, "
                    + "Pizzas.PizzaId AS PizzaId, Pizzas.Size AS Size, Pizzas.Toppings AS Toppings "
                    + "FROM Customers "
                    + "INNER JOIN Orders ON Customers.OrderNum = Orders.OrderNum "
                    + "INNER JOIN Pizzas ON Orders.PizzaId = Pizzas.PizzaId "
                    + "WHERE PhoneNum LIKE '%" + phoneNum + "%'")) { 
                
                
                while(resultSet.next()){
                    String name = resultSet.getString("Name");
                    String address = resultSet.getString("Address");
                    String phone = resultSet.getString("PhoneNum");
                    
                    //we haven't seen this customer before
                    if(!customerMap.containsKey(phone)){
                        ArrayList<Pizza> pizzaList = new ArrayList<>();
                        pizzaList.add(new Pizza(resultSet.getString("Toppings"),
                                        resultSet.getInt("PizzaId"),
                                        resultSet.getString("Size")));
                        ArrayList<Order> orderList = new ArrayList<>();
                        orderList.add(new Order(resultSet.getString("Delivery"),
                                                resultSet.getInt("OrderNum"),
                                                pizzaList));
                        customerMap.put(phone, new Customer(name, address, phone, orderList));
                        
                        
                    }else{//we've already seen this customer
                        //we haven't seen an order from this customer before
                        if(customerMap.get(phone).getOrderList().isEmpty()){
                            ArrayList<Pizza> pizzaList = new ArrayList<>();
                            pizzaList.add(new Pizza(resultSet.getString("Toppings"),
                                            resultSet.getInt("PizzaId"),
                                            resultSet.getString("Size")));
                            ArrayList<Order> orderList = new ArrayList<>();
                            orderList.add(new Order(resultSet.getString("DeliveryMethod"),
                                                    resultSet.getInt("OrderNum"),
                                                    pizzaList));
                            customerMap.put(phone, new Customer(name, address, phone, orderList));
                        }else{//we have seen an order from this customer before
                            //for each order the customer has
                            for(int i = 0; i < customerMap.get(phone).getOrderList().size(); i++){
                                //if the query line's ordernum matches an ordernum in the orderlist
                                if(customerMap.get(phone).getOrderList().get(i).getOrderNum() ==
                                        resultSet.getInt("OrderNum")){
                                    //add this pizza to the orderlist
                                    customerMap.get(phone).getOrderList().get(i).getPizzaList().add(
                                                        new Pizza(resultSet.getString("Toppings"),
                                                                  resultSet.getInt("PizzaId"),
                                                                  resultSet.getString("Size")));
                                }
                            }   
                        }
                    }
                }                
            }
        }catch(SQLException ex){
            System.out.println("Error Select: " + ex.getMessage());
        }
        return new ArrayList<>(customerMap.values());
    }
    
    private void buildCustomerTable(Connection conn){
        try{
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rs = dbmd.getTables(null, null, "CUSTOMERS", null);
            if(!rs.next()){
                Statement stmt = conn.createStatement();
                stmt.execute("CREATE TABLE Customers(" + 
                        "Name CHAR(25), " +
                        "Address CHAR(50), " +
                        "PhoneNum CHAR(12) PRIMARY KEY, " +
                        "OrderNum INTEGER, " +
                        "FOREIGN KEY (OrderNum) REFERENCES Orders(OrderNum) ON DELETE CASCADE)");
                System.out.println("customer table created");
            }
            
            
        }catch(SQLException ex){
            System.out.println("Error Build Customers: " + ex.getMessage());
        }
    }
    private void buildOrderTable(Connection conn){
        try{
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rs = dbmd.getTables(null, null, "ORDERS", null);
            if(!rs.next()){
                Statement stmt = conn.createStatement();
                stmt.execute("CREATE TABLE Orders(" + 
                        "DeliveryMethod CHAR(12), " +
                        "PizzaId INTEGER, " +
                        "OrderNum INTEGER PRIMARY KEY, " +
                        "FOREIGN KEY (PizzaId) REFERENCES Pizzas(PizzaId) ON DELETE CASCADE)");
                System.out.println("order table created");
            }
            
            
        }catch(SQLException ex){
            System.out.println("Error Build Orders: " + ex.getMessage());
        }
    }
    private void buildPizzaTable(Connection conn){
        try{
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rs = dbmd.getTables(null, null, "PIZZAS", null);
            if(!rs.next()){
                Statement stmt = conn.createStatement();
                stmt.execute("CREATE TABLE Pizzas(" + 
                        "Toppings CHAR(100), " +
                        "PizzaId INTEGER PRIMARY KEY, " +
                        "Size CHAR(10))");
                System.out.println("pizza table created");
            }
            
            
        }catch(SQLException ex){
            System.out.println("Error Build Pizzas: " + ex.getMessage());
        }
    }
}
