package ua.com.task.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.task.dao.DepDAO;
import ua.com.task.dao.EmplDAO;
import ua.com.task.entity.Department;
import ua.com.task.entity.Employee;
import ua.com.task.service.DepService;
import ua.com.task.service.EmplService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
@Transactional
public class DepServiceImpl implements DepService {
    private  String assistant = "assistant";
    private  String associate_professor = "associate_professor";
    private  String professor = "professor";

    @Autowired
    DepDAO depDAO;
    @Autowired
    EmplDAO emplDAO;
    @Override
    public void save(Department department,String depName) {
        if(depDAO.findByDepName(depName)==null){
            depDAO.save(department);
        }
        else{
            System.out.println("This department already exists");
        }

    }

    @Override
    public void delete(String depName)
    {
        depDAO.delete(depDAO.findByDepName(depName));
    }

    @Override
    public Department findDepByName(String depName) {
        return depDAO.findByDepName(depName);
    }

    @Override
    public void addEmpl(String depName, String emplNameandSurname) {
      Department department =   depDAO.findByDepName(depName);
      Employee employee = emplDAO.findByEmplName(emplNameandSurname);
      department.getEmployees().add(employee);
    }

    @Override
    public void deleteEmpl(String depName, String emplNameAndsurname) {
        Department department = depDAO.findByDepName(depName);
        List<Employee> list = department.getEmployees();
        for (int i = 0; i <list.size() ; i++) {
            if(list.get(i).getEmplNameAndSurname().equals(emplNameAndsurname)){
                list.remove(i);
            }
        }
        department.setEmployees(list);
    }

    @Override
    public void setTheHeadOfDep(String depName, String emplNameAndSurname) {
        boolean isAMember =false;
        Department department = depDAO.findByDepName(depName);
        List<Employee> list = department.getEmployees();
        for (int i = 0; i <list.size() ; i++) {
            if(list.get(i).getEmplNameAndSurname().equals(emplNameAndSurname)){
                isAMember  = true;
            }
        }
        if(isAMember){
            department.setHeadOfDep(emplDAO.findByEmplName(emplNameAndSurname).getEmplNameAndSurname());
            System.out.println(emplNameAndSurname+ " now is a head of "+depName+" department");
        }
        else {
            System.out.println("This employee is not a member of chosen department , please add employee first");
        }
    }

    @Override
    public void showDepHead(String depName) {
        Department department = depDAO.findByDepName(depName);
        System.out.println("The head of department is - "+department.getHeadOfDep());
    }

    @Override
    public void showEmplCount(String depName) {
        Department department = depDAO.findByDepName(depName);
        List<Employee> employeeList = department.getEmployees();
        System.out.println("Number of employees is - "+employeeList.size());
    }

    @Override
    public void showAvgSalary(String depName) {
        float avgSalary;
        float salary = 0;
        Department department = depDAO.findByDepName(depName);
        List<Employee> employeeList = department.getEmployees();
        for (int i = 0; i <employeeList.size() ; i++) {
           salary+=employeeList.get(i).getSalary();
        }
        avgSalary = salary/employeeList.size();
        System.out.println("avg salary in department is - "+avgSalary);
    }

    @Override
    public void showStatistic(String depName) {
        Department department = depDAO.findByDepName(depName);
        List<Employee> list = department.getEmployees();
        List<Employee> assistantsList = new ArrayList<>();
        List<Employee> associate_professorsList = new ArrayList<>() ;
        List<Employee> professorsList = new ArrayList<>() ;
        for ( Employee empl:list) {
            if(empl.getDegree().equals(assistant)){
                assistantsList.add(empl);
            }
            else if (empl.getDegree().equals(associate_professor)){
                associate_professorsList.add(empl);
            }
            else if (empl.getDegree().equals(professor)){
                professorsList.add(empl);
            }
        }

        System.out.println("Statistic of department");
        System.out.println("assistants - "+assistantsList.size());
        System.out.println("associate professors - "+associate_professorsList.size());
        System.out.println("professors - "+professorsList.size());
    }

    @Override
    public List<Department> findAll() {
        return depDAO.findAll();
    }

    @Override
    public void globalSerch(String word) {
        String depName = null;
        List<Department> findedDep = new ArrayList<>();
        List<Department> allDep = depDAO.findAll();
        for (int i = 0; i <allDep.size() ; i++) {
            depName = allDep.get(i).getDepName().toLowerCase();
            word = word.toLowerCase();
            if(depName.contains(word)){
                findedDep.add(allDep.get(i));
            }
        }
        for (Department dep:findedDep) {
            System.out.println(dep);
        }
    }


}
