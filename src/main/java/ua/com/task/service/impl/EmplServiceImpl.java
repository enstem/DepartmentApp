package ua.com.task.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;
        import ua.com.task.dao.EmplDAO;
import ua.com.task.entity.Department;
import ua.com.task.entity.Employee;
        import ua.com.task.service.EmplService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmplServiceImpl implements EmplService {
    @Autowired
    EmplDAO emplDAO;
    @Override
    public void save(Employee employee,String emplNameAndSurname) {
        if(emplDAO.findByEmplName(emplNameAndSurname)==null){
            emplDAO.save(employee);
        }
        else{
            System.out.println("This employee already exists");
        }
    }
    @Override
    public void delete(Employee employee) {
        emplDAO.delete(employee);
    }

    @Override
    public Employee findEmplByName(String emplNameAndSurname) {
        return emplDAO.findByEmplName(emplNameAndSurname);
    }

    @Override
    public List<Employee> findAll() {
        return emplDAO.findAll();
    }

    @Override
    public void globalSerch(String word) {
        String emplName = null;
        List<Employee> findedEmpl = new ArrayList<>();
        List<Employee> allEmpl = emplDAO.findAll();
        for (int i = 0; i <allEmpl.size() ; i++) {
            emplName = allEmpl.get(i).getEmplNameAndSurname().toLowerCase();
            word = word.toLowerCase();
            if(emplName.contains(word)){
                findedEmpl.add(allEmpl.get(i));
            }
        }
        for (Employee dep:findedEmpl) {
            System.out.println(dep);
        }
    }

}
