package Pages;

import Entities.Department;
import Entities.Employee;
import Entities.Position;
import Entities.User;
import Utils.MyDate;

import java.util.Date;
import java.util.Scanner;

public class AdminPage {
    public static void mainPage(int employeeId) {
        // update last update date
        User.updateLastUpdateDate(User.getIdByEmployeeId(employeeId), MyDate.getDateTimeString(new Date()));

        //
        Scanner keyboard = new Scanner(System.in);
        int choice = 0;

        while (true) {
            System.out.println("------------ Welcome, System Admin ------------");
            Employee employee = Employee.getInstanceFromDatabase(employeeId);
            String name = employee.getName();
            String salutation = employee.getGender().equals("Male") ? "Mr. " : "Ms. ";
            String words = "Hi, " + salutation + name;
            System.out.println(words);

            System.out.println(
                    "1. User List\n" +
                            "2. Employee List\n" +
                            "3. Position List\n" +
                            "4. Department List\n" +
                            "5. new Employee\n" +
                            "0. Log out\n" +
                            "-1. exit program\n"
            );
            System.out.print("Choice: ");
            try {
                choice = keyboard.nextInt();
                System.out.println("-------------------------------------------------\n\n");

                switch (choice) {
                    case 1:
                        User.printList();
                        break;

                    case 2:
                        Employee.printList();
                        break;

                    case 3:
                        Position.printList();
                        break;

                    case 4:
                        Department.printList();
                        break;

                    case 5:
                        Employee.newInstance();
                        break;

                    case 0:
                        System.out.println("--------------------- LOG OUT ---------------------\n\n");
                        LoginPage.login();
                        break;

                    case -1:
                        // update last update date
                        User.updateLastUpdateDate(User.getIdByEmployeeId(employeeId), MyDate.getDateTimeString(new Date()));
                        System.out.println("------------- Exit Program -------------");
                        System.exit(0);

                    default:
                        System.out.println("Please enter valid number!\n\n");
                        mainPage(employeeId);
                        break;
                }

            } catch (Exception e) {
                System.out.println("-------------------------------------------------\n\n");
                System.out.println("Please enter valid value!\n\n");
                mainPage(employeeId);
                break;
            }
        }
    }
}
