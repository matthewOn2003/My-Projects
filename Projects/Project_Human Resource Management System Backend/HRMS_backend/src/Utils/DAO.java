package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


@SuppressWarnings("all")
// Database Access Object
public class DAO {
    private static Connection connectionInstance = null;

    /*
    - Once this function used by any entities/function,
    - It must closed in the main function before exit program.
     */
    public static Connection getConnection () {
        if (connectionInstance == null) {
            try {
                // configuration
                Properties properties = new Properties();
                String filePath = "C:\\Users\\Asus\\OneDrive\\Desktop\\My-Projects\\Projects\\Project_Human Resource Management System Backend\\HRMS_backend\\src\\db.properties";
                properties.load(new FileInputStream(filePath));
                String user = properties.getProperty("user");
                String pw = properties.getProperty("password");
                String url = properties.getProperty("url");
                String driver = properties.getProperty("driver");

                // database connection
                Class.forName(driver);
                Connection connection = DriverManager.getConnection(url, user, pw);
                return connection;

            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {

            }
        }
        return connectionInstance;

    }
}
