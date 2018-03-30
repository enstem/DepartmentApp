package ua.com.task.dao;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.task.entity.Department;
import ua.com.task.entity.Employee;

import java.util.List;

public interface DepDAO extends JpaRepository<Department,Integer> {
    @Query("from Department d where d.depName=:depName")
    Department findByDepName(@Param("depName")String depName);
    @Query("from Department d")
    List<Department> findAll();
}
