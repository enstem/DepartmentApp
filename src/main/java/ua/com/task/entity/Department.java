package ua.com.task.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int depId;
    private String depName;
    private String headOfDep;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "employee_department", joinColumns = @JoinColumn(name = "departments_depId", referencedColumnName = "depId"),
            inverseJoinColumns = @JoinColumn(name = "employees_emplId", referencedColumnName = "emplId"))
    private List<Employee> employees  = new ArrayList<>();

    public Department() {
    }

    public Department(String depName) {
        this.depName = depName;
    }

//    public Department(String depName, String headOfDep, List<Employee> employees) {
//        this.depName = depName;
//        this.headOfDep = headOfDep;
//        this.employees = employees;
//    }

    public int getDepId() {
        return depId;
    }
    public void setDepId(int depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getHeadOfDep() {
        return headOfDep;
    }

    public void setHeadOfDep(String headOfDep) {
        this.headOfDep = headOfDep;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "depId=" + depId +
                ", depName='" + depName + '\'' +
                ", headOfDep='" + headOfDep + '\'' +
                '}';
    }
}
