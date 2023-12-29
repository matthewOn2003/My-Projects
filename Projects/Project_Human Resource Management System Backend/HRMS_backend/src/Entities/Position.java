package Entities;

import Utils.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/*
    CREATE TABLE positions (
        position_id INT NOT NULL AUTO_INCREMENT,
        position_name VARCHAR(500),
        role VARCHAR(500),
        salary DECIMAL(10, 2),
        department_id INT,
        PRIMARY KEY (position_id)
    );

    +-------------+---------------------------------+-----------------------------------------------------+----------+---------------+
    | position_id | position_name                   | role                                                | salary   | department_id |
    +-------------+---------------------------------+-----------------------------------------------------+----------+---------------+
    |           1 | Sales Representative            | Handle sales inquiries and promote products.        | 50000.00 |             1 |
    |           2 | Sales Manager                   | Lead and manage the sales team.                     | 80000.00 |             1 |
    |           3 | Account Executive               | Manage client accounts and relationships.           | 60000.00 |             1 |
    |           4 | Customer Service Representative | Assist customers with product-related queries.      | 45000.00 |             1 |
    |           5 | Marketing Specialist            | Develop and implement marketing strategies.         | 55000.00 |             2 |
    |           6 | Marketing Manager               | Oversee and coordinate marketing campaigns.         | 75000.00 |             2 |
    |           7 | Digital Marketing Analyst       | Analyze digital marketing data and trends.          | 65000.00 |             2 |
    |           8 | Content Writer                  | Create engaging content for marketing materials.    | 50000.00 |             2 |
    |           9 | Financial Analyst               | Analyze financial data and prepare reports.         | 70000.00 |             3 |
    |          10 | Finance Manager                 | Manage financial operations and budgets.            | 90000.00 |             3 |
    |          11 | Accountant                      | Handle financial transactions and record-keeping.   | 60000.00 |             3 |
    |          12 | Investment Analyst              | Evaluate investment opportunities and risks.        | 80000.00 |             3 |
    |          13 | HR Generalist                   | Handle various HR functions and employee relations. | 65000.00 |             4 |
    |          14 | HR Manager                      | Oversee HR policies and procedures.                 | 85000.00 |             4 |
    |          15 | Recruitment Specialist          | Source and recruit candidates for open positions.   | 70000.00 |             4 |
    |          16 | Training Coordinator            | Coordinate employee training programs.              | 55000.00 |             4 |
    |          17 | Software Developer              | Design and develop software applications.           | 80000.00 |             5 |
    |          18 | Network Administrator           | Manage and maintain network infrastructure.         | 75000.00 |             5 |
    |          19 | IT Project Manager              | Lead and oversee IT projects.                       | 90000.00 |             5 |
    |          20 | Systems Analyst                 | Analyze and optimize IT systems.                    | 85000.00 |             5 |
    +-------------+---------------------------------+-----------------------------------------------------+----------+---------------+


    // department manager
    2  | Sales Manager
    6  | Marketing Manager
    10 | Finance Manager
    14 | HR Manager
    19 | IT Project Manager


 */


@SuppressWarnings("all")
public class Position {
    private int positionId;
    private String positionName;
    private String role;
    private double salary;
    private int departmentId;

    public Position() {

    }

    public Position(int positionId, String positionName, String role, double salary, int departmentId) {
        this.positionId = positionId;
        this.positionName = positionName;
        this.role = role;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Position{" +
                "positionId=" + positionId +
                ", positionName='" + positionName + '\'' +
                ", role='" + role + '\'' +
                ", salary=" + salary +
                '}';
    }

    public static Position newInstance() {
        Scanner keyboard = new Scanner(System.in);

        String positionName;
        String role;
        double salary;
        int departmentId;

        System.out.println("------------ Enter following information ------------");
        System.out.print("Position Name: ");
        positionName = keyboard.nextLine();

        System.out.print("Role: ");
        role = keyboard.nextLine();

        System.out.print("Salary: ");
        salary = keyboard.nextDouble();

        System.out.print("Department ID: ");
        departmentId = keyboard.nextInt();

        Position position = new Position(0, positionName, role, salary, departmentId);

        return position;
    }

    // Database
    public static Position getInstanceFromDatabase(int positionId) {
        ResultSet resultSet = null;
        try {
            Connection connection = DAO.getConnection();

            //
            String sql = "SELECT * FROM positions WHERE position_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, positionId);
            resultSet = ps.executeQuery();
            resultSet.next();

            int position_id = resultSet.getInt(1);
            String positin_name = resultSet.getString(2);
            String role = resultSet.getString(3);
            double salary = resultSet.getDouble(4);
            int department_id = resultSet.getInt(5);

            return new Position(position_id, positin_name, role, salary, department_id);


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static synchronized boolean insertPosition(Position position) {
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            // insert
            String insertSql =
                    "INSERT INTO positions(" +
                            "position_name, " +
                            "role, " +
                            "salary," +
                            "department_id) " +
                            "VALUES(?, ?, ?, ?)";

            // insert
            PreparedStatement ps = connection.prepareStatement(insertSql);
            ps.setString(1, position.getPositionName());
            ps.setString(2, position.getRole());
            ps.setDouble(3, position.getSalary());
            ps.setDouble(4, position.getDepartmentId());

            int rows = ps.executeUpdate();
            return (rows > 0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized boolean deletePositionById(int positionId) {
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            // delete
            String deleteSql = "DELETE FROM positions WHERE position_id = ?";
            PreparedStatement ps = connection.prepareStatement(deleteSql);
            ps.setInt(1, positionId);

            int rows = ps.executeUpdate();
            return (rows > 0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized boolean updatePositionName(int positionId, String positionName) {
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            String updateSql = "UPDATE positions SET position_name = ? WHERE position_id = ?";
            PreparedStatement ps = connection.prepareStatement(updateSql);
            ps.setString(1, positionName);
            ps.setInt(2, positionId);
            int rows = ps.executeUpdate();
            return (rows > 0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized boolean updateRole(int positionId, String role) {
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            String updateSql = "UPDATE positions SET role = ? WHERE position_id = ?";
            PreparedStatement ps = connection.prepareStatement(updateSql);
            ps.setString(1, role);
            ps.setInt(2, positionId);
            int rows = ps.executeUpdate();
            return (rows > 0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized boolean updateSalary(int positionId, double salary) {
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            String updateSql = "UPDATE positions SET salary = ? WHERE position_id = ?";
            PreparedStatement ps = connection.prepareStatement(updateSql);
            ps.setDouble(1, salary);
            ps.setInt(2, positionId);
            int rows = ps.executeUpdate();
            return (rows > 0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized boolean updateDepartmentId(int positionId, int departmentId) {
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            String updateSql = "UPDATE positions SET department_id = ? WHERE position_id = ?";
            PreparedStatement ps = connection.prepareStatement(updateSql);
            ps.setInt(1, departmentId);
            ps.setInt(2, positionId);
            int rows = ps.executeUpdate();
            return (rows > 0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getPositionNameById(int positionId) {
        ResultSet resultSet = null;
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            String selectSql = "SELECT position_name FROM positions WHERE position_id = ?";
            PreparedStatement ps = connection.prepareStatement(selectSql);
            ps.setInt(1, positionId);
            resultSet = ps.executeQuery();

            return resultSet.next() ? (resultSet.getString(1)) : "(no position)";

        } catch (SQLException e) {
            System.out.println("Position class");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static String getRoleById(int positionId) {
        ResultSet resultSet = null;
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            String selectSql = "SELECT role FROM positions WHERE position_id = ?";
            PreparedStatement ps = connection.prepareStatement(selectSql);
            ps.setInt(1, positionId);
            resultSet = ps.executeQuery();
            resultSet.next(); // from 0 to 1, next one
            return resultSet.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static String getSalaryById(int positionId) {
        ResultSet resultSet = null;
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            String selectSql = "SELECT salary FROM positions WHERE position_id = ?";
            PreparedStatement ps = connection.prepareStatement(selectSql);
            ps.setInt(1, positionId);
            resultSet = ps.executeQuery();
            resultSet.next(); // from 0 to 1, next one
            return resultSet.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static int getDepartmentIdById(int positionId) {
        ResultSet resultSet = null;
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            String selectSql = "SELECT department_id FROM positions WHERE position_id = ?";
            PreparedStatement ps = connection.prepareStatement(selectSql);
            ps.setInt(1, positionId);
            resultSet = ps.executeQuery();
            resultSet.next(); // from 0 to 1, next one
            return resultSet.getInt(1);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //
    public static void verifyPositionId(int position_id) {
        ResultSet resultSet = null;
        try {
            Connection connection = DAO.getConnection();
            String sql = "SELECT * FROM positions WHERE position_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, position_id);
            resultSet = ps.executeQuery();
            resultSet.next();

        } catch (Exception e) {
            System.out.println(e.getMessage());


            throw new RuntimeException("The position doesn't exist.");
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
            System.out.println("-------------------------------------- Position List --------------------------------------");
            Connection connection = DAO.getConnection();
            String sql = "SELECT * FROM positions";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();


            System.out.format("+------+---------------------------------+------------------------------------------------------------------+----------+-------------+%n");
            System.out.format("| ID   | Position Name                   | Role                                                             | Salary   | Department  |%n");
            System.out.format("+------+---------------------------------+------------------------------------------------------------------+----------+-------------+%n");

            while (resultSet.next()) {
                int positionId = resultSet.getInt(1);
                String positionName = resultSet.getString(2);
                String role = resultSet.getString(3);
                double salary = resultSet.getDouble(4);
                int departmentId = resultSet.getInt(5);

                System.out.format("| %-4d | %-31s | %-64s | %-8.2f | %-11d |%n",
                        positionId, positionName, role, salary, departmentId);
                System.out.format("+------+---------------------------------+------------------------------------------------------------------+----------+-------------+%n");
            }
            System.out.println("\n\n");


        } catch (Exception e) {
            System.out.println("Position class");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static List printAndGetIdList(Employee employee, boolean isSameDepartment) {

        try {
            System.out.println("-------------------------------------- Position List --------------------------------------");
            Connection connection = DAO.getConnection();
            String sql = "";
            PreparedStatement ps = null;

            if (isSameDepartment) {
                sql = "SELECT * FROM positions WHERE department_id = ? AND position_id != ? AND position_id != ?";
                ps = connection.prepareStatement(sql);
                ps.setInt(1, employee.getDepartmentId());
                ps.setInt(2, employee.getPositionId());

                // can not show department manager's id
                ps.setInt(3, Employee.getPositionIdById(Department.getManagerIdById(employee.getDepartmentId())));

            } else {
                sql = "SELECT * FROM positions WHERE department_id != ? AND position_name NOT LIKE '%Manager%'";
                ps = connection.prepareStatement(sql);
                ps.setInt(1, employee.getDepartmentId());

            }
            ResultSet resultSet = ps.executeQuery();
            List<Integer> positionIDs = new ArrayList<>();

            System.out.format("+------+---------------------------------+------------------------------------------------------------------+----------+-------------+%n");
            System.out.format("| ID   | Position Name                   | Role                                                             | Salary   | Department  |%n");
            System.out.format("+------+---------------------------------+------------------------------------------------------------------+----------+-------------+%n");

            while (resultSet.next()) {
                int positionId = resultSet.getInt(1);
                String positionName = resultSet.getString(2);
                String role = resultSet.getString(3);
                double salary = resultSet.getDouble(4);
                int departmentId = resultSet.getInt(5);

                System.out.format("| %-4d | %-31s | %-64s | %-8.2f | %-11d |%n",
                        positionId, positionName, role, salary, departmentId);
                System.out.format("+------+---------------------------------+------------------------------------------------------------------+----------+-------------+%n");

                // append ID to list
                positionIDs.add(positionId);

            }
            System.out.println("\n\n");
            return positionIDs;


        } catch (Exception e) {
            System.out.println("Position class");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
    // Add more database operations as needed
}
