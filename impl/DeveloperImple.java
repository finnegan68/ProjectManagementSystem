package impl;

import essence.Developer;

import java.sql.*;

public class DeveloperImple implements DAO<Developer>{


    public void create(Developer obj) {
        try{
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO developers(name, age, companies_company_id, salary) VALUES (?, ?, ?, ?)");
            ps.setString(1, obj.getName());
            ps.setInt(2, obj.getAge());
            ps.setLong(3, obj.getCompanyId());
            ps.setDouble(4,obj.getSalary());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Sorry, we can't connect now");
        }

    }

    public Developer read(long id){
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from developers where dev_id = ?");
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String name = rs.getString("name");
                long companyId = rs.getLong("companies_company_id");
                int age = rs.getInt("age");
                double salary = rs.getDouble("salary");
                Developer d = new Developer(id, name, age, companyId, salary);
                return d;
            }
        }catch (SQLException e) {
            System.out.println("Sorry, we can't connect now");
        }
        return null;
    }

    public Developer update(long id, Developer obj) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE developers set name=?, age=?, companies_company_id=?, salary=? where dev_id = ?");
            ps.setString(1, obj.getName());
            ps.setInt(2, obj.getAge());
            ps.setLong(3, obj.getCompanyId());
            ps.setDouble(4,obj.getSalary());
            ps.setLong(5, id);
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
            PreparedStatement ps = connection.prepareStatement("delete from developers where dev_id = ?");
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
