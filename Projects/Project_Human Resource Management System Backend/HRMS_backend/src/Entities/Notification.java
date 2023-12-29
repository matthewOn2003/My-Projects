package Entities;

import Utils.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

/*
    CREATE TABLE notifications (
        notification_id INT PRIMARY KEY AUTO_INCREMENT,
        employee_id INT,
        type VARCHAR(255),
        message TEXT,
        date VARCHAR(500)
    );



    - Notification's receiver is Employee, so it may be related to employee
    - what an employee have? (name, birthDate, gender, phoneNo, address) - assume these can edit

    types:
    - any U operation
    - employee data changed: info(), position and department




*/

@SuppressWarnings("all")
public class Notification {
    private int notificationId;
    private int employeeId; // receiver id
    private String type;
    private String message;
    private String date;

    public Notification() {}

    public Notification(int notificationId, int employeeId, String type, String message, String date) {
        this.notificationId = notificationId;
        this.employeeId = employeeId;
        this.type = type;
        this.message = message;
        this.date = date;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId=" + notificationId +
                ", employeeId=" + employeeId +
                ", type='" + type + '\'' +
                ", message='" + message + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public static boolean insertNotification(Notification notification) {
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            // insert
            String insertSql =
                    "INSERT INTO notifications (" +
                    "employee_id, " +
                    "type, " +
                    "message, " +
                    "date) " +
                    "VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(insertSql);
            ps.setInt(1, notification.getEmployeeId());
            ps.setString(2, notification.getType());
            ps.setString(3, notification.getMessage());
            ps.setString(4, notification.getDate());

            int rows = ps.executeUpdate();
            return (rows > 0);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printPersonalNotifications(int employeeId) {
        Scanner keyboard = new Scanner(System.in);
        String choice;
        try {
            System.out.println("---------------------------------------------- Notifications ----------------------------------------------");
            Connection connection = DAO.getConnection();
            String sql = "SELECT * FROM notifications WHERE employee_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, employeeId);
            ResultSet resultSet = ps.executeQuery();

            StringBuilder list = new StringBuilder();
            list.append("+----------------------+---------------------------------------------------------------------------------------------+------------------------+\n");
            list.append("| Type                 | Message                                                                                     | Date                   |\n");
            list.append("+----------------------+---------------------------------------------------------------------------------------------+------------------------+\n");

            while (resultSet.next()) {
                String type = resultSet.getString(3);
                String message = resultSet.getString(4);
                String date = resultSet.getString(5);
                list.append(String.format("| %-20s | %-91s | %-22s |\n", type, message, date));
                list.append("+----------------------+---------------------------------------------------------------------------------------------+------------------------+\n");
            }
            System.out.println(list.toString());
            System.out.println("Hint: Press [Enter] to back main menu, or press [1] to CLEAR ALL NOTIFICATIONS");
            choice = keyboard.nextLine();

            if (choice.equals("1")) {
                Notification.clearAll(employeeId);
            } else {
                System.out.println("\n\n");
            }


        } catch (Exception e) {
            System.out.println("Notification class");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void clearAll(int employeeId) {
        Scanner keyboard = new Scanner(System.in);
        int choice = 0;
        System.out.print("Hint: Are you decide to clear all notification?\n1. Yes\n2. No\nChoice: ");
        try {
            choice = keyboard.nextInt();

            switch (choice) {
                case 1:
                    Connection connection = DAO.getConnection();
                    PreparedStatement ps = connection.prepareStatement("DELETE FROM notifications WHERE employee_id = ?");
                    ps.setInt(1, employeeId);
                    System.out.println("Hint: " + (ps.executeUpdate() > 0 ? ("Clear all notifications.") : ("Fail to clear notifications.")));
                    break;
                case 2:
                    System.out.println("Hint: Cancel to clear notifications");
                    break;
                default:
                    System.out.println("Hint: Please enter valid number.");
                    break;
            }
        } catch (SQLException e) {
            System.out.println("Hint: Please enter valid value.");
            throw new RuntimeException(e);
        }
    }



}
