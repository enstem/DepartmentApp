package ua.com.task.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.task.entity.Employee;

import java.util.List;

public interface EmplDAO extends JpaRepository<Employee,Integer> {
    @Query("from Employee e where e.emplNameAndSurname=:emplNameAndSurname")
    Employee findByEmplName(@Param("emplNameAndSurname")String emplNameAndSurname);
    @Query("from Employee e")
    List<Employee> findAll();
}
