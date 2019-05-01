
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
    
    
    //TODO: Update/Delete need to be implemented, also change db so you don't have to do db18, 19, 20...
    
    public SQLiteJDBC_Pizza(){
        final String DB_URL = "jdbc:derby:GUIPizzaDB17;create=true";
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            buildPizzaTable(conn);
            buildOrderTable(conn);
            buildCustomerTable(conn);
            
            ArrayList<Order> orderList = new ArrayList<>();
            ArrayList<Pizza> pizzaList = new ArrayList<>();
            pizzaList.add(new Pizza("Mushroom", 991.0, "Small"));
            orderList.add(new Order("Pick-up", 199.0, pizzaList));
            insertCustomerInfo(new Customer("Alex", "1234 Penny Lane", "4145551234", orderList));
            System.out.println(selectCustomerInfo("4145551234").get(0).toString());
            
            conn.commit();
            conn.close();
            
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    public void insertCustomerInfo(Customer c){
        try(Connection conn = DriverManager.getConnection("jdbc:derby:GUIPizzaDB17;")){
            Statement stmt = conn.createStatement();
            //string toppings, double pizza id, string size
            for(int i = 0; i < c.getOrderList().size(); i++){
                for(int j = 0; j < c.getOrderList().get(i).getPizzaList().size(); j++){
                    stmt.execute("INSERT INTO Pizzas VALUES ( '"
                    + c.getOrderList().get(i).getPizzaList().get(j).getToppings() + "', "
                    + c.getOrderList().get(i).getPizzaList().get(j).getPizzaId() + ", '"
                    + c.getOrderList().get(i).getPizzaList().get(j).getSize()
                    + "' )");
                }
            }
            //string delivery method, double pizzaid, double orderid
            for(int i = 0; i < c.getOrderList().size(); i++){
                for(int j = 0; j < c.getOrderList().get(i).getPizzaList().size(); j++){
                    stmt.execute("INSERT INTO Orders VALUES ( '"
                        + c.getOrderList().get(i).getDeliveryMethod() + "', "
                        + c.getOrderList().get(i).getPizzaList().get(j).getPizzaId() + ", "
                        + c.getOrderList().get(i).getOrderNum()
                        + " )");
                }
            }
            //string name, string address, string phonenum, double orderid
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
     * phone number is unique identifier
     * returns customer information (name, address, phone)
     * @param phoneNum 
     * @return  
     */
    public ArrayList<Customer> selectCustomerInfo(String phoneNum){
        HashMap<String, Customer> customerMap = new HashMap<>();
        try(Connection conn = DriverManager.getConnection("jdbc:derby:GUIPizzaDB17;")){
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
                                        resultSet.getDouble("PizzaId"),
                                        resultSet.getString("Size")));
                        ArrayList<Order> orderList = new ArrayList<>();
                        orderList.add(new Order(resultSet.getString("Delivery"),
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
            System.out.println("Error: " + ex.getMessage());
        }
        return new ArrayList<>(customerMap.values());
    }
    
    private void buildCustomerTable(Connection conn){
        try{
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE Customers(" + 
                    "Name CHAR(25), " +
                    "Address CHAR(50), " +
                    "PhoneNum CHAR(12) PRIMARY KEY, " +
                    "OrderNum DOUBLE, " +
                    "FOREIGN KEY (OrderNum) REFERENCES Orders(OrderNum))");
            System.out.println("customer table created");
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
                    "OrderNum DOUBLE PRIMARY KEY, " +
                    "FOREIGN KEY (PizzaId) REFERENCES Pizzas(PizzaId))");
            System.out.println("order table created");
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
    private void buildPizzaTable(Connection conn){
        try{
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE Pizzas(" + 
                    "Toppings CHAR(100), " +
                    "PizzaId DOUBLE PRIMARY KEY, " +
                    "Size CHAR(10))");
            System.out.println("pizza table created");
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
