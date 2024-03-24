import Entities.Employee;
import Entities.Notification;
import Pages.LoginPage;
import Utils.DAO;

import java.sql.Connection;


/*
    use human_resource_management_system
    select * from

    use `aa_bbb_ccc` for database words (tables, attributes...)
    use `aaBbbCcc` for java words (functions, variables...)


 */


@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) throws Exception {
        startApp();


        // Feature need to improve:
        // 1. Can not clear notifications
        // 2. Create a database and the tables if not exist, when the project run
        // 3. The database should create at local host


        // Need to do:
        // 1. Employee (manager) should see the notification of their subordinates any info changed
        // 2. Manager should able to approve or reject the employee's application of change position
        // 3. Employee should able to thick attendance
        // 4. Manager should have higher permissions? like can see the subordinates list
        // ...
    }

    public static void startApp() throws Exception{
        Connection connection = DAO.getConnection();
        DAO.initProgram();
        LoginPage.login();
        connection.close();
    }

}