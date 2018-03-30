package ua.com.task.start;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Helper helper = new Helper();
        int cases;
        Scanner scanner = new Scanner(System.in);
        boolean forWhile = true;
        while (forWhile) {
            System.out.println("Enter 1- to add department \n" +
                    "Enter 2- to remove department \n" +
                    "Enter 3- to add employee \n" +
                    "Enter 4- to remove  employee \n"+
                    "Enter 5- to add employee to department \n"+
                    "Enter 6- to remove  from department \n"+
                    "Enter 7- to set department head \n"+
                    "Enter 8- to see department head  \n"+
                    "Enter 9- to see number of employees  \n"+
                    "Enter 10- to see avg salary of employees  \n"+
                    "Enter 11- to see department statistic  \n"+
                    "Enter 12- for search among departments  \n"+
                    "Enter 13- for search among employees  \n"+
                    "Enter 14- to exit \n");
            cases = scanner.nextInt();
            switch (cases){
                case 1: helper.addDep();
                break;
                case 2: helper.deleteDep();
                break;
                case 3: helper.addEmpl();
                break;
                case 4: helper.deleteEmpl();
                break;
                case 5: helper.addEmplToDep();
                    break;
                case 6: helper.deleteEmplFromDep();
                    break;
                case 7: helper.setTheHeadOfDep();
                    break;
                case 8: helper.showDepHead();
                    break;
                case 9: helper.showEmplCount();
                    break;
                case 10: helper.showAvgSalary();
                    break;
                case 11: helper.showDepStatistic();
                    break;
                case 12: helper.searchAmongDep();
                    break;
                case 13: helper.searchAmongEmplp();
                    break;
                case 14: forWhile = false;
                break;
                default :{
                    System.out.print("Wrong input");
                }
            }
        }
    }
}
