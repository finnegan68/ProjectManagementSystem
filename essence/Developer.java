package essence;

import java.util.ArrayList;
import java.util.List;

public class Developer {

    long id;
    String name;
    int age;
    long companyId;
    double salary;
    List<Skill> skills = new ArrayList<Skill>();

    public Developer(long id, String name, int age, long companyId, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.companyId = companyId;
        this.salary = salary;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getCompanyId() {
        return companyId;
    }

    public double getSalary() {
        return salary;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", companyId=" + companyId +
                ", salary=" + salary +
                '}';
    }
}

