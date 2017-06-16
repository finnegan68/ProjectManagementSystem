package impl;


import essence.Customer;

import java.sql.*;

public class CustomerImpl implements DAO<Customer>{

    public void create(Customer obj) {
        try{
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO customers(customer_name,projects_project_id) VALUES (?, ?)");
            ps.setString(1, obj.getName());
            ps.setLong(2, obj.getProjectId());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Sorry, we can't connect now");
        }
    }

    public Customer read(long id) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from customers where customer_id = ?");
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String name = rs.getString("customer_name");
                long projectId = rs.getLong("projects_project_id");
                Customer c = new Customer(id, projectId, name);
                return c;
            }
        }catch (SQLException e) {
            System.out.println("Sorry, we can't connect now");
        }
        return null;
    }

    public Customer update(long id, Customer obj) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE customers set customer_name=?, projects_project_id=?,where customer_id = ?");
            ps.setString(1, obj.getName());
            ps.setLong(2, obj.getProjectId());
            ps.setLong(3, id);
            ps.execute();
            return obj;
        }catch (SQLException e) {
            System.out.println("Sorry, we can't connect now");
        }
        return null;
    }

    public void delete(long id) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("delete from customers where customer_id = ?");
            ps.setLong(1, id);
            ps.execute();
        }catch (SQLException e) {
            System.out.println("Sorry, we can't connect now");
        }
    }
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ilya_db?useSSL=false", "root","1111");
    }
}
