package impl;


import essence.Company;
import essence.Skill;

import java.sql.*;

public class CompanyImple implements DAO<Company>{

    public void create(Company obj) {
        try{
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO companies(company_name) VALUES (?)");
            ps.setString(1, obj.getName());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Sorry, we can't connect now");
        }
    }

    public Company read(long id) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from companies where company_id = ?");
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String name = rs.getString("company_name");
                return new Company(id, name);
            }
        }catch (SQLException e) {
            System.out.println("Sorry, we can't connect now");
        }
        return null;
    }

    public Company update(long id, Company obj) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE companies set company_name=? where company_id = ?");
            ps.setString(1, obj.getName());
            ps.setLong(2, id);
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
            PreparedStatement ps = connection.prepareStatement("delete from companies where company_id = ?");
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
