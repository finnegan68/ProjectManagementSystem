package essence;


import java.util.ArrayList;
import java.util.List;

public class Project {

    long id;
    long companyId;
    String name;
    double cost;
    List<Developer> developers = new ArrayList<Developer>();

    public Project(long id, long companyId, String name, double cost) {
        this.id = id;
        this.companyId = companyId;
        this.name = name;
        this.cost = cost;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public long getId() {
        return id;
    }

    public long getCompanyId() {
        return companyId;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }
}
