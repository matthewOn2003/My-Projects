package Pages;

import Entities.Department;
import Entities.Employee;
import Entities.Notification;
import Entities.User;
import Utils.MyDate;

import java.util.Date;
import java.util.Scanner;
import java.util.stream.Stream;

public class NormalPage {

    public static void mainPage(int employeeId) {
        // update last update date
        User.updateLastUpdateDate(User.getIdByEmployeeId(employeeId), MyDate.getDateTimeString(new Date()));

        //
        Scanner keyboard = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("------------------- Welcome -------------------");
            Employee employee = Employee.getInstanceFromDatabase(employeeId);
            String name = employee.getName();
            String salutation = employee.getGender().equals("Male") ? "Mr. " : "Ms. ";
            String words = "Hi, " + salutation + name;
            System.out.println(words);

            System.out.println(
                            "1. Personal Info\n" +
                            "2. Edit Personal Info\n" +
                            "3. Application Change Position\n" +
                            "4. Notification\n" +
                            "0. Log out\n" +
                            "-1. exit program\n"
            );

            try {
                System.out.print("Choice: ");
                choice = keyboard.nextInt();
                System.out.println("-------------------------------------------------\n\n");

                switch (choice) {
                    case 1:
                        employee.printPersonalInfo();
                        break;

                    case 2:
                        employee.editPersonalInfo();
                        break;

                    case 3:
                        boolean isManager = false;
                        for (int managerId : Department.getAllManagersId()) {
                            if (managerId == employeeId) {
                                System.out.println("Hint: Manager cannot change position.\n\n");
                                isManager = true;
                            }
                        }

                        if (!isManager) {
                            employee.printChangePosition();
                        }
                        break;

                    case 4:
                        Notification.printPersonalNotifications(employeeId);
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
