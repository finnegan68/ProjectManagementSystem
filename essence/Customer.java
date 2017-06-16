package essence;


public class Customer {
    long id;
    long projectId;
    String name;

    public Customer(long id, long projectId, String name) {
        this.id = id;
        this.projectId = projectId;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public long getProjectId() {
        return projectId;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public void setName(String name) {
        this.name = name;
    }
}



