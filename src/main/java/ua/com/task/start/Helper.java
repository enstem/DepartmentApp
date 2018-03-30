package ua.com.task.start;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.com.task.entity.Department;
import ua.com.task.entity.Employee;
import ua.com.task.service.DepService;
import ua.com.task.service.EmplService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Helper {
    private ApplicationContext context = new AnnotationConfigApplicationContext(ua.com.task.config.DataConfig.class);
        private DepService depService =context.getBean(DepService.class);
        private EmplService emplService = context.getBean(EmplService.class);

        private String depName;

        private String word;


        private String emplNameAndSurname;
        private String emplDegree;
        private Float emplSalary;

        Scanner scanner = new Scanner(System.in);
        public void DepAndEmplNames(){
            System.out.print("Enter depName: ");
            depName = scanner.next();
            System.out.print("Enter emplName and emplSurname: ");
            emplNameAndSurname = scanner.next();
        }
        public  void addDep(){
            System.out.print("Enter depName: ");
            depName = scanner.next();
            depService.save(new Department(depName),depName);
        }
        public void deleteDep(){
            System.out.print("Enter depName: ");
            depName = scanner.next();
            try {
                depService.delete(depName);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("You trying to delete notEmpty department , it is not allowed , try to make it empty first. ");
            }
        }
        public void addEmpl(){
            System.out.print("Enter emplName and emplSurname like JonSmith- : ");
            emplNameAndSurname = scanner.next();
            System.out.print("Enter emplDegree, chose between assistant, associate_professor and professor : ");
            emplDegree = scanner.next();
            System.out.print("Enter emplSalary: ");
            emplSalary = scanner.nextFloat();
            emplService.save(new Employee(emplNameAndSurname,emplDegree,emplSalary),emplNameAndSurname);
        }
        public void deleteEmpl(){
            System.out.print("Enter emplName and emplSurname: ");
            emplNameAndSurname = scanner.next();
            emplService.delete(emplService.findEmplByName(emplNameAndSurname));
        }
        public void addEmplToDep(){
            DepAndEmplNames();
            depService.addEmpl(depName,emplNameAndSurname);
        }
    public void deleteEmplFromDep(){
        DepAndEmplNames();
       depService.deleteEmpl(depName,emplNameAndSurname);

    }
    public void setTheHeadOfDep(){
        DepAndEmplNames();
        depService.setTheHeadOfDep(depName,emplNameAndSurname);
    }
    public  void showDepHead(){
        System.out.print("Enter depName: ");
        depName = scanner.next();
       depService.showDepHead(depName);
    }
    public void showEmplCount(){
        System.out.print("Enter depName: ");
        depName = scanner.next();
        depService.showEmplCount(depName);
    }
    public void showAvgSalary(){
        System.out.print("Enter depName: ");
        depName = scanner.next();
        depService.showAvgSalary(depName);
    }
    public void showDepStatistic(){
        System.out.print("Enter depName: ");
        depName = scanner.next();
        depService.showStatistic(depName);
    }
    public void searchAmongDep(){
        System.out.print("Enter what are you looking for: ");
        word = scanner.next();
        depService.globalSerch(word);
    }
    public void searchAmongEmplp(){
        System.out.print("Enter what are you looking for: ");
        word = scanner.next();
        emplService.globalSerch(word);
    }
}
