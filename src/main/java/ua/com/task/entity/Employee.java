package ua.com.task.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int emplId;
    private String emplNameAndSurname;
    private String degree;
    private float salary;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY,mappedBy = "employees")

    private List<Department> departments = new ArrayList<>();
    public Employee() {
    }

    public Employee(String emplNameAndSurname, String degree, float salary) {
        this.emplNameAndSurname = emplNameAndSurname;
        this.degree = degree;
        this.salary = salary;
    }
    @PrePersist
    public void addDepartments() {
        departments.forEach(department -> department.getEmployees().add(this));
    }

    @PreRemove
    public void deleteDepartments() {
        departments.forEach(department -> department.getEmployees().remove(this));
    }
    public int getEmplId() {
        return emplId;
    }

    public void setEmplId(int emplId) {
        this.emplId = emplId;
    }

    public String getEmplNameAndSurname() {
        return emplNameAndSurname;
    }

    public void setEmplNameAndSurname(String emplNameAndSurname) {
        this.emplNameAndSurname = emplNameAndSurname;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emplId=" + emplId +
                ", emplNameAndSurname='" + emplNameAndSurname + '\'' +
                ", degree='" + degree + '\'' +
                ", salary=" + salary +
                '}';
    }
}
