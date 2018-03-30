package ua.com.task.service;
        import ua.com.task.entity.Department;
        import ua.com.task.entity.Employee;

        import java.util.List;
public interface DepService {
    void save(Department department,String depName);
    void delete(String depName);
    Department findDepByName(String depName);
    void addEmpl(String depName,String emplNameAndSurname);
    void deleteEmpl(String depName,String emplNameAndSurname);
    void setTheHeadOfDep(String depName,String emplNameAndSurname);
    void showDepHead(String depName);
    void showEmplCount(String depName);
    void showAvgSalary(String depName);
    void showStatistic(String depName);
    List<Department> findAll();
    void globalSerch(String word);

}
