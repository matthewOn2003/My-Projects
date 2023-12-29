package Pages;

import Utils.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginPage {
    public static void login() {
        Scanner keyboard = new Scanner(System.in);
        String username, password;

        while (true) {
            System.out.println("--------------------- LOGIN ---------------------");
            System.out.print("Username: ");
            username = keyboard.nextLine();

            System.out.print("Password: ");
            password = keyboard.nextLine();
            System.out.println("-------------------------------------------------\n\n");

            //
            try {
                Connection connection = DAO.getConnection();
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet resultSet = ps.executeQuery();

                if (resultSet.next()) { // user exist
                    int employeeId = resultSet.getInt(2);
                    String permissions = resultSet.getString(5);

                    if (permissions.equals("admin")) {
                        AdminPage.mainPage(employeeId);
                    } else {
                        NormalPage.mainPage(employeeId);
                    }


                    break;
                } else {
                    System.out.println("Invalid username or password, please try again.\n");
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
