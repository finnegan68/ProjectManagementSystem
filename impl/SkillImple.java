package impl;


import essence.Skill;

import java.sql.*;

public class SkillImple implements DAO<Skill>{

    public void create(Skill obj) {
        try{
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO skills(name_skill) VALUES (?)");
            ps.setString(1, obj.getName());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Sorry, we can't connect now");
        }
    }

    public Skill read(long id) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from skills where skill_id = ?");
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String name = rs.getString("name_skill");
                return new Skill(id, name);
            }
        }catch (SQLException e) {
            System.out.println("Sorry, we can't connect now");
        }
        return null;
    }

    public Skill update(long id, Skill obj) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE skills set name_skill=? where skill_id = ?");
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
            PreparedStatement ps = connection.prepareStatement("delete from skills where skill_id = ?");
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
