package impl;


import essence.Customer;
import essence.Project;

import java.sql.*;

public class ProjectImpl implements DAO<Project>{

    public void create(Project obj) {
        try{
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO projects(project_name,companies_company_id, cost) VALUES (?, ?, ?)");
            ps.setString(1, obj.getName());
            ps.setLong(2, obj.getCompanyId());
            ps.setDouble(3, obj.getCost());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Sorry, we can't connect now");
        }
    }

    public Project read(long id) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from projects where project_id = ?");
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String name = rs.getString("project_name");
                long customerId = rs.getLong("companies_company_id");
                double cost = rs.getDouble("cost");
                Project p = new Project(id, customerId, name, cost);
                return p;
            }
        }catch (SQLException e) {
            System.out.println("Sorry, we can't connect now");
        }
        return null;
    }

    public Project update(long id, Project obj) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE projects set project_name=?, companies_company_id=?, cost=? where project_id = ?");
            ps.setString(1, obj.getName());
            ps.setLong(2, obj.getCompanyId());
            ps.setDouble(3, obj.getCost());
            ps.setLong(4, id);
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
            PreparedStatement ps = connection.prepareStatement("delete from projects where project_id = ?");
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
