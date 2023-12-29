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
    CREATE TABLE `departments`  (
          `department_id` int NOT NULL AUTO_INCREMENT,
          `department_name` varchar(500),
          `manager_id` int,
          `location` varchar(500),
          PRIMARY KEY (`department_id`)
    );
    +---------------+------------------------+------------+----------+
    | department_id | department_name        | manager_id | location |
    +---------------+------------------------+------------+----------+
    |             1 | Sales                  |          0 | Block A  |
    |             2 | Marketing              |          0 | Block B  |
    |             3 | Finance                |          0 | Block C  |
    |             4 | Human Resource         |          0 | Block D  |
    |             5 | Information Technology |          0 | Block E  |
    +---------------+------------------------+------------+----------+


    - when an department created, only (department_name, location) are necessary
    - the manager id should input in another function


        Connection connection = DAO.getConnection();
        Department.insertDepartment(Department.newDepartment());
        Department.updateDepartmentName(6, "bb");
        Department.updateManagerId(6, 1);
        Department.updateLocation(6, "bb");
        System.out.println(Department.getDepartmentNameById(6));
        System.out.println(Department.getManagerIdById(6));
        System.out.println(Department.getLocationById(6));
        Department.deleteDepartmentById(6);

        connection.close();

 */

public class Department {
    private int departmentId;
    private String departmentName;
    private int managerId;
    private String location;

    public Department() {

    }

    public Department(int departmentId, String departmentName, int managerId, String location) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.managerId = managerId;
        this.location = location;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", managerId=" + managerId +
                ", location='" + location + '\'' +
                '}';
    }

    public static Department newInstance() {
        Scanner keyboard = new Scanner(System.in);

        String departmentName;
        int managerId;
        String location;

        System.out.println("------------ Enter following information ------------");
        System.out.print("Department Name: ");
        departmentName = keyboard.nextLine();

        System.out.print("Manager ID: ");
        managerId = keyboard.nextInt();
        keyboard.nextLine(); // Consume the newline character

        System.out.print("Location: ");
        location = keyboard.nextLine();

        Department department = new Department(0, departmentName, managerId, location);

        return department;
    }

    // Database Operation
    public static Department getInstanceFromDatabase(int departmentId) {
        ResultSet resultSet = null;
        try {
            Connection connection = DAO.getConnection();

            //
            String sql = "SELECT * FROM departments WHERE department_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, departmentId);
            resultSet = ps.executeQuery();
            resultSet.next();

            int department_id = resultSet.getInt(1);
            String department_name = resultSet.getString(2);
            int manager_id = resultSet.getInt(3);
            String location = resultSet.getString(4);

            return new Department(department_id, department_name, manager_id, location);


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

    public static synchronized boolean insertDepartment(Department department) {
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            // insert
            String insertSql =
                    "INSERT INTO departments(" +
                            "department_name, " +
                            "manager_id, " +
                            "location) " +
                            "VALUES(?, ?, ?)";

            // insert
            PreparedStatement ps = connection.prepareStatement(insertSql);
            ps.setString(1, department.getDepartmentName());
            ps.setInt(2, department.getManagerId());
            ps.setString(3, department.getLocation());

            int rows = ps.executeUpdate();
            return (rows > 0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized boolean deleteDepartmentById(int departmentId) {
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            // delete
            String deleteSql = "DELETE FROM departments WHERE department_id = ?";
            PreparedStatement ps = connection.prepareStatement(deleteSql);
            ps.setInt(1, departmentId);

            int rows = ps.executeUpdate();
            return (rows > 0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized boolean updateDepartmentName(int departmentId, String departmentName) {
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            String updateSql = "UPDATE departments SET department_name = ? WHERE department_id = ?";
            PreparedStatement ps = connection.prepareStatement(updateSql);
            ps.setString(1, departmentName);
            ps.setInt(2, departmentId);
            int rows = ps.executeUpdate();
            return (rows > 0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized boolean updateManagerId(int departmentId, int managerId) {
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            String updateSql = "UPDATE departments SET manager_id = ? WHERE department_id = ?";
            PreparedStatement ps = connection.prepareStatement(updateSql);
            ps.setInt(1, managerId);
            ps.setInt(2, departmentId);
            int rows = ps.executeUpdate();
            return (rows > 0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized boolean updateLocation(int departmentId, String location) {
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            String updateSql = "UPDATE departments SET location = ? WHERE department_id = ?";
            PreparedStatement ps = connection.prepareStatement(updateSql);
            ps.setString(1, location);
            ps.setInt(2, departmentId);
            int rows = ps.executeUpdate();
            return (rows > 0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getDepartmentNameById(int departmentId) {
        ResultSet resultSet = null;
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            String selectSql = "SELECT department_name FROM departments WHERE department_id = ?";
            PreparedStatement ps = connection.prepareStatement(selectSql);
            ps.setInt(1, departmentId);
            resultSet = ps.executeQuery();

            return resultSet.next() ? (resultSet.getString(1)) : "(no department)";

        } catch (SQLException e) {
            System.out.println("Department class");
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

    public static int getManagerIdById(int departmentId) {
        ResultSet resultSet = null;
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            String selectSql = "SELECT manager_id FROM departments WHERE department_id = ?";
            PreparedStatement ps = connection.prepareStatement(selectSql);
            ps.setInt(1, departmentId);
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

    public static String getLocationById(int departmentId) {
        ResultSet resultSet = null;
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            String selectSql = "SELECT location FROM departments WHERE department_id = ?";
            PreparedStatement ps = connection.prepareStatement(selectSql);
            ps.setInt(1, departmentId);
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

    public static void printList() {
        try {
            System.out.println("--------------------------------- Department List ---------------------------------");
            Connection connection = DAO.getConnection();
            String sql = "SELECT * FROM departments";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            StringBuilder list = new StringBuilder();
            list.append("+------+----------------------+-------------+----------------------+\n");
            list.append("| ID   | Department Name     | Manager ID  | Location             |\n");
            list.append("+------+----------------------+-------------+----------------------+\n");

            while (resultSet.next()) {
                int departmentId = resultSet.getInt(1);
                String departmentName = resultSet.getString(2);
                int managerId = resultSet.getInt(3);
                String location = resultSet.getString(4);

                list.append(String.format("| %-4d | %-20s | %-11d | %-20s |\n",
                        departmentId, departmentName, managerId, location));
                list.append("+------+----------------------+-------------+----------------------+\n");
            }
            System.out.println(list.toString());
            System.out.println("\n\n");


        } catch (Exception e) {
            System.out.println("Department class");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static List<Integer> getAllManagersId() {
        ArrayList<Integer> managersIdList = new ArrayList<>();
        try {
            Connection connection = DAO.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT manager_id FROM departments");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                managersIdList.add(resultSet.getInt(1));
            }

            return managersIdList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
