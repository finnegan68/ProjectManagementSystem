import essence.Developer;
import essence.Project;
import essence.Skill;
import impl.DAO;
import impl.DeveloperImple;
import impl.ProjectImpl;


public class Main {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        DAO developerDAO = new DeveloperImple();
        DAO projectDAO = new ProjectImpl();

        Developer ira = new Developer(6, "Ira", 42, 2, 10000);
        Developer lena = new Developer(8, "Lena", 22, 3, 123456);
        developerDAO.create(ira);
        Skill skill1 = new Skill(1, "Java");
        Skill skill2 = new Skill(2, "C++");
        Skill skill3 = new Skill(3, "C#");

        ira.getSkills().add(skill1);
        ira.getSkills().add(skill2);

        developerDAO.update(ira.getId(), ira);

        Project prj = new Project(5, 3, "Cheburek", 9000000);
        prj.getDevelopers().add(ira);
        prj.getDevelopers().add(lena);
        projectDAO.update(prj.getId(), prj);

        System.out.println("Done!");
    }
}
