package Entities;

import Utils.DAO;
import Utils.MyDate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

/*
    CREATE TABLE users (
        user_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        employee_id INT,
        username VARCHAR(500),
        password VARCHAR(500),
        permissions VARCHAR(500),
        create_date VARCHAR(500),
        last_update_date VARCHAR(500)
    );

 */

@SuppressWarnings("all")
public class User {
    private int userId;
    private int employeeId;
    private String username;
    private String password;
    private String permissions; // normal, admin
    private String createDate;
    private String lastUpdateDate;

    public User() {}

    public User(int userId, int employeeId, String username, String password,
                    String permissions, String createDate, String lastUpdateDate) {
        this.userId = userId;
        this.employeeId = employeeId;
        this.username = username;
        this.password = password;
        this.permissions = permissions;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public static void register(Employee employee) {
        //
        Scanner keyboard = new Scanner(System.in);
        int employeeId = employee.getEmployeeId();

        //
        String username = employee.getName().replaceAll("\\s", "").toLowerCase();
        String password = employee.getBirthDate().replaceAll("-", "");

        //
        String permissions = "normal"; // normal, admin
        String createDate = MyDate.getDateTimeString(new Date());
        String lastUpdateDate = MyDate.getDateTimeString(new Date());


        System.out.println("---------------------------- Register new user ----------------------------\n\n");

        if (isEmployeeExist(employeeId)) {
            User user = new User(0, employeeId, username, password, permissions, createDate, lastUpdateDate);
            insertUser(user);

        } else {
            System.out.println("This employee are not exist in our company.");
        }

    }

    public static boolean isEmployeeExist(int employeeId) {
        try {
            Connection connection = DAO.getConnection();
            String sql = "SELECT * FROM employees WHERE employee_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, employeeId);
            ResultSet resultSet = ps.executeQuery();
//            String name = resultSet.getString(2);

            return resultSet.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static User getInstanceFromDatabase(int userId) {
        ResultSet resultSet = null;
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            String selectSql = "SELECT * FROM users WHERE user_id = ?";
            PreparedStatement ps = connection.prepareStatement(selectSql);
            ps.setInt(1, userId);
            resultSet = ps.executeQuery();

            if (resultSet.next()) {
                return new User(
                        resultSet.getInt("user_id"),
                        resultSet.getInt("employee_id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("permissions"),
                        resultSet.getString("createDate"),
                        resultSet.getString("lastUpdateDate")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null; // Return null if user not found
    }


    // Database Operation
    private static boolean insertUser(User user) {
        try {
            // insert
            Connection connection = DAO.getConnection();
            String insertSql =
                    "INSERT INTO users(" +
                            "user_id, " +
                            "employee_id, " +
                            "username, " +
                            "password, " +
                            "permissions, " +
                            "create_date, " +
                            "last_update_date) " +
                            "VALUES(?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(insertSql);
            ps.setInt(1, user.getUserId());
            ps.setInt(2, user.getEmployeeId());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getPermissions());
            ps.setString(6, user.getCreateDate());
            ps.setString(7, user.getLastUpdateDate());
            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized boolean deleteUserById(int userId) {
        try {
            Connection connection = DAO.getConnection();

            String deleteSql = "DELETE FROM users WHERE user_id = ?";
            PreparedStatement ps = connection.prepareStatement(deleteSql);
            ps.setInt(1, userId);

            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized boolean updateEmployeeId(int userId, int employeeId) {
        try {
            // get connection
            Connection connection = DAO.getConnection();

            // update
            String updateSql = "UPDATE users SET employee_id = ? WHERE user_id = ?";
            PreparedStatement ps = connection.prepareStatement(updateSql);
            ps.setInt(1, employeeId);
            ps.setInt(2, userId);

            int rows = ps.executeUpdate();
            return (rows > 0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized boolean updateUsername(int userId, String username) {
        try {
            // get connection
            Connection connection = DAO.getConnection();

            // update
            String updateSql = "UPDATE users SET username = ? WHERE user_id = ?";
            PreparedStatement ps = connection.prepareStatement(updateSql);
            ps.setString(1, username);
            ps.setInt(2, userId);

            int rows = ps.executeUpdate();
            return (rows > 0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized boolean updatePassword(int userId, String password) {
        try {
            // get connection
            Connection connection = DAO.getConnection();

            // update
            String updateSql = "UPDATE users SET password = ? WHERE user_id = ?";
            PreparedStatement ps = connection.prepareStatement(updateSql);
            ps.setString(1, password);
            ps.setInt(2, userId);

            int rows = ps.executeUpdate();
            return (rows > 0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized boolean updatePermissions(int userId, String permissions) {
        try {
            // get connection
            Connection connection = DAO.getConnection();

            // update
            String updateSql = "UPDATE users SET permissions = ? WHERE user_id = ?";
            PreparedStatement ps = connection.prepareStatement(updateSql);
            ps.setString(1, permissions);
            ps.setInt(2, userId);

            int rows = ps.executeUpdate();
            return (rows > 0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized boolean updateCreateDate(int userId, String createDate) {
        try {
            // get connection
            Connection connection = DAO.getConnection();

            // update
            String updateSql = "UPDATE users SET create_date = ? WHERE user_id = ?";
            PreparedStatement ps = connection.prepareStatement(updateSql);
            ps.setString(1, createDate);
            ps.setInt(2, userId);

            int rows = ps.executeUpdate();
            return (rows > 0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized boolean updateLastUpdateDate(int userId, String lastUpdateDate) {
        try {
            // get connection
            Connection connection = DAO.getConnection();

            // update
            String updateSql = "UPDATE users SET last_update_date = ? WHERE user_id = ?";
            PreparedStatement ps = connection.prepareStatement(updateSql);
            ps.setString(1, lastUpdateDate);
            ps.setInt(2, userId);

            int rows = ps.executeUpdate();
            return (rows > 0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getIdByEmployeeId(int employeeId) {
        ResultSet resultSet = null;
        try {
            // get connection
            Connection connection = DAO.getConnection();

            // select
            String selectSql = "SELECT user_id FROM users WHERE employee_id = ?";
            PreparedStatement ps = connection.prepareStatement(selectSql);
            ps.setInt(1, employeeId);
            resultSet = ps.executeQuery();
            resultSet.next(); // from 0 to 1, next one
            return resultSet.getInt(1);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static int getEmployeeIdById(int userId) {
        ResultSet resultSet = null;
        try {
            // get connection
            Connection connection = DAO.getConnection();

            // select
            String selectSql = "SELECT employee_id FROM users WHERE user_id = ?";
            PreparedStatement ps = connection.prepareStatement(selectSql);
            ps.setInt(1, userId);
            resultSet = ps.executeQuery();
            resultSet.next(); // from 0 to 1, next one
            return resultSet.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static String getUsernameById(int userId) {
        ResultSet resultSet = null;
        try {
            // get connection
            Connection connection = DAO.getConnection();

            // select
            String selectSql = "SELECT username FROM users WHERE user_id = ?";
            PreparedStatement ps = connection.prepareStatement(selectSql);
            ps.setInt(1, userId);
            resultSet = ps.executeQuery();
            resultSet.next(); // from 0 to 1, next one
            return resultSet.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static String getPasswordById(int userId) {
        ResultSet resultSet = null;
        try {
            // get connection
            Connection connection = DAO.getConnection();

            // select
            String selectSql = "SELECT password FROM users WHERE user_id = ?";
            PreparedStatement ps = connection.prepareStatement(selectSql);
            ps.setInt(1, userId);
            resultSet = ps.executeQuery();
            resultSet.next(); // from 0 to 1, next one

            return resultSet.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static String getPermissionsById(int userId) {
        ResultSet resultSet = null;
        try {
            // get connection
            Connection connection = DAO.getConnection();

            // select
            String selectSql = "SELECT permissions FROM users WHERE user_id = ?";
            PreparedStatement ps = connection.prepareStatement(selectSql);
            ps.setInt(1, userId);
            resultSet = ps.executeQuery();
            resultSet.next(); // from 0 to 1, next one

            return resultSet.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static String getCreateDateById(int userId) {
        ResultSet resultSet = null;
        try {
            // get connection
            Connection connection = DAO.getConnection();

            // select
            String selectSql = "SELECT create_date FROM users WHERE user_id = ?";
            PreparedStatement ps = connection.prepareStatement(selectSql);
            ps.setInt(1, userId);
            resultSet = ps.executeQuery();
            resultSet.next(); // from 0 to 1, next one
            return resultSet.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static String getLastUpdateDateById(int userId) {
        ResultSet resultSet = null;
        try {
            // get connection
            Connection connection = DAO.getConnection();

            // select
            String selectSql = "SELECT last_update_date FROM users WHERE user_id = ?";
            PreparedStatement ps = connection.prepareStatement(selectSql);
            ps.setInt(1, userId);
            resultSet = ps.executeQuery();
            resultSet.next(); // from 0 to 1, next one
            return resultSet.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void printList() {
        try {
            System.out.println("---------------------------------------------- User List ----------------------------------------------");
            Connection connection = DAO.getConnection();
            String sql = "SELECT * FROM users";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            StringBuilder list = new StringBuilder();
            list.append("+------+-------------+----------------------+----------------------+-------------+----------------------+------------------------+\n");
            list.append("| ID   | Employee ID | Username             | Password             | Permissions | Create Date          | Last Update Date       |\n");
            list.append("+------+-------------+----------------------+----------------------+-------------+----------------------+------------------------+\n");

            while (resultSet.next()) {
                int userId = resultSet.getInt(1);
                int employeeId = resultSet.getInt(2);
                String username = resultSet.getString(3);
                String password = resultSet.getString(4);
                String permissions = resultSet.getString(5);
                String createDate = resultSet.getString(6);
                String lastUpdateDate = resultSet.getString(7);

                list.append(String.format("| %-5d | %-11d | %-20s | %-20s | %-11s | %-20s | %-22s |\n",
                        userId, employeeId, username, password, permissions, createDate, lastUpdateDate));
                list.append("+--------+-------------+----------------------+----------------------+-------------+----------------------+------------------------+\n");
            }
            System.out.println(list.toString());
            System.out.println("\n\n");

        } catch (Exception e) {
            System.out.println("User class");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
