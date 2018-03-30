package ua.com.task.service;

import ua.com.task.entity.Department;
import ua.com.task.entity.Employee;

import java.util.List;

public interface EmplService {
    void save(Employee employee,String emplNameAndSurname);
    void delete(Employee employee);
    Employee findEmplByName(String emplNameAndSurname);
    List<Employee> findAll();
    void globalSerch(String word);
}
