package Entities;

import Pages.LoginPage;
import Pages.NormalPage;
import Utils.DAO;
import Utils.MyDate;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.StreamSupport;

/*
    CREATE TABLE `employees`  (
          `employee_id` int NOT NULL AUTO_INCREMENT,
          `name` varchar(500),
          `birth_date` varchar(500),
          `gender` varchar(500),
          `phone_no` varchar(500),
          `address` varchar(500),
          `position_id` int,
          `department_id` int,
          PRIMARY KEY (`employee_id`)
    );

    - when an employee created, only (name, birth_date, gender, phone_no, address) are necessary
    - the position and department id should input in another function
 */

/*
        // get connection
        Connection connection = DAO.getConnection();


        //
        boolean isDelete = Employee.deleteEmployeeById(2);
        System.out.println(isDelete);
        Employee.updateName(1, "On Pei Yun");
        Employee.updateBirthDate(1, "2005-03-25");
        Employee.updateGender(1, "Female");
        Employee.updatePhoneNo(1, "011-39845159");
        Employee.updateAddress(1, "A-19-02, MKH Boulevard");
        Employee.updatePositionId(1, 1);
        Employee.updateDepartmentId(1, 1);


        // rest "SELECT", CRUD done (U dept, position not yet)
        System.out.println(Employee.getNameById(1));
        System.out.println(Employee.getBirthDateById(1));
        System.out.println(Employee.getGenderById(1));
        System.out.println(Employee.getPhoneNoById(1));
        System.out.println(Employee.getAddressById(1));
        System.out.println(Employee.getDepartmentIdById(1));
        System.out.println(Employee.getPositionIdById(1));


        // close
        connection.close();
 */

@SuppressWarnings("all")
public class Employee {
    private int employeeId;
    private String name;
    private String birthDate;
    private String gender;
    private String phoneNo;
    private String address;
    private int positionId;
    private int departmentId;

    public Employee() {

    }

    public Employee(int employeeId, String name, String birthDate, String gender,String phoneNo, String address, int positionId, int departmentId) {
        this.employeeId = employeeId;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.address = address;
        this.positionId = positionId;
        this.departmentId = departmentId;
    }

    

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", gender='" + gender + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", address='" + address + '\'' +
                ", positionId=" + positionId +
                ", departmentId=" + departmentId +
                '}';
    }

    public static void newInstance() {
        try {
            Scanner keyboard = new Scanner(System.in);

            String name;
            String birthDate;
            String gender;
            String phoneNo;
            String address;
            int positionId;
            int departmentId;

            System.out.println("------------------------ Enter employee information ------------------------");
            System.out.print("Employee Name: ");
            name = keyboard.nextLine();

            System.out.print("Birth Date (yyyy-MM-dd): ");
            birthDate = keyboard.nextLine();
            MyDate.stringToDate(birthDate); // varify birthdate

            System.out.print("Gender: ");
            gender = keyboard.nextLine();

            System.out.print("Phone No: ");
            phoneNo = keyboard.nextLine();

            System.out.print("Address: ");
            address = keyboard.nextLine();

            Position.printList();
            System.out.print("The Application Position's ID: ");
            positionId = keyboard.nextInt();
            Position.verifyPositionId(positionId);

            departmentId = Position.getDepartmentIdById(positionId);

            //
            Employee employee = new Employee(0, name, String.valueOf(birthDate), gender, phoneNo, address, positionId, departmentId);
            insertEmployee(employee);

            //
            Connection connection = DAO.getConnection();
            String sql = "SELECT employee_id FROM employees ORDER BY employee_id DESC LIMIT 1";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery(sql);
            resultSet.next();
            employee.setEmployeeId(resultSet.getInt(1));

            User.register(employee);
//            return employee;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Hint: You entered unvalid input, please follow the format.");

        } finally {

        }
    }




    // Database Operation
    public static Employee getInstanceFromDatabase(int employeeId) {
        ResultSet resultSet = null;
        try {
            Connection connection = DAO.getConnection();

            //
            String sql = "SELECT * FROM employees WHERE employee_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, employeeId);
            resultSet = ps.executeQuery();
            resultSet.next();

            int employee_id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String birth_date = resultSet.getString(3);
            String gender = resultSet.getString(4);
            String phone_no = resultSet.getString(5);
            String address = resultSet.getString(6);
            int position_id = resultSet.getInt(7);
            int department_id = resultSet.getInt(8);

            return new Employee(employee_id, name, birth_date, gender, phone_no, address, position_id, department_id);


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


    public static synchronized boolean insertEmployee(Employee employee){

        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            // insert
            String insertSql =
                    "INSERT INTO employees(" +
                            "name, " +
                            "birth_date, " +
                            "gender, " +
                            "phone_no, " +
                            "address, " +
                            "position_id, " +
                            "department_id) " +
                            "VALUES(?, ?, ?, ?, ?, ?, ?)";

            // insert
            PreparedStatement ps = connection.prepareStatement(insertSql);
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getBirthDate());
            ps.setString(3, employee.getGender());
            ps.setString(4, employee.getPhoneNo());
            ps.setString(5, employee.getAddress());
            ps.setInt(6, employee.getPositionId()); // 0
            ps.setInt(7, employee.getDepartmentId()); // 0

            int rows = ps.executeUpdate();

            // register an user account


            return (rows > 0) ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static synchronized boolean deleteEmployeeById(int employeeId) {
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            // delete
            String deleteSql = "DELETE FROM employees WHERE employee_id = ?";
            PreparedStatement ps = connection.prepareStatement(deleteSql);
            ps.setInt(1, employeeId);

            int rows = ps.executeUpdate();
            return (rows > 0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static synchronized boolean updateName(int employeeId, String name) {
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            String updateSql = "UPDATE employees SET name = ? WHERE employee_id = ?";
            PreparedStatement ps = connection.prepareStatement(updateSql);
            ps.setString(1, name);
            ps.setInt(2, employeeId);
            int rows = ps.executeUpdate();
            return (rows > 0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized boolean updateBirthDate(int employeeId, String birthDate) {
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            String updateSql = "UPDATE employees SET birth_date = ? WHERE employee_id = ?";
            PreparedStatement ps = connection.prepareStatement(updateSql);
            ps.setString(1, birthDate);
            ps.setInt(2, employeeId);
            int rows = ps.executeUpdate();
            return (rows > 0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized boolean updateGender(int employeeId, String gender) {
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            String updateSql = "UPDATE employees SET gender = ? WHERE employee_id = ?";
            PreparedStatement ps = connection.prepareStatement(updateSql);
            ps.setString(1, gender);
            ps.setInt(2, employeeId);
            int rows = ps.executeUpdate();
            return (rows > 0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized boolean updatePhoneNo(int employeeId, String phoneNo) {
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            String updateSql = "UPDATE employees SET phone_no = ? WHERE employee_id = ?";
            PreparedStatement ps = connection.prepareStatement(updateSql);
            ps.setString(1, phoneNo);
            ps.setInt(2, employeeId);
            int rows = ps.executeUpdate();
            return (rows > 0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized boolean updateAddress(int employeeId, String address) {
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            String updateSql = "UPDATE employees SET address = ? WHERE employee_id = ?";
            PreparedStatement ps = connection.prepareStatement(updateSql);
            ps.setString(1, address);
            ps.setInt(2, employeeId);
            int rows = ps.executeUpdate();
            return (rows > 0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized boolean updatePositionId(int employeeId, int positionId) {
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            // reject if he/she want to apply manager position
            ResultSet resultSet = connection.prepareStatement("SELECT position_id FROM positions WHERE position_name LIKE '%Manager%'").executeQuery();
            while (resultSet.next()) {
                if (positionId == resultSet.getInt(1)) {
                    throw new RuntimeException("Only allow 1 manager in each department, please choose other position");
                }
            }

            String updateSql = "UPDATE employees SET position_id = ? WHERE employee_id = ?";
            PreparedStatement ps = connection.prepareStatement(updateSql);
            ps.setInt(1, positionId);
            ps.setInt(2, employeeId);
            int rows = ps.executeUpdate();
            updateDepartmentId(employeeId, Position.getDepartmentIdById(positionId));
            return (rows > 0);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized boolean updateDepartmentId(int employeeId, int departmentId) {
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            String updateSql = "UPDATE employees SET department_id = ? WHERE employee_id = ?";
            PreparedStatement ps = connection.prepareStatement(updateSql);
            ps.setInt(1, departmentId);
            ps.setInt(2, employeeId);
            int rows = ps.executeUpdate();
            return (rows > 0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getNameById(int employeeId) {
        ResultSet resultSet = null;
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            String selectSql = "SELECT name FROM employees WHERE employee_id = ?";
            PreparedStatement ps = connection.prepareStatement(selectSql);
            ps.setInt(1, employeeId);
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

    public static String getBirthDateById(int employeeId) {
        ResultSet resultSet = null;
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            String selectSql = "SELECT birth_date FROM employees WHERE employee_id = ?";
            PreparedStatement ps = connection.prepareStatement(selectSql);
            ps.setInt(1, employeeId);
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

    public static String getGenderById(int employeeId) {
        ResultSet resultSet = null;
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            String selectSql = "SELECT gender FROM employees WHERE employee_id = ?";
            PreparedStatement ps = connection.prepareStatement(selectSql);
            ps.setInt(1, employeeId);
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

    public static String getPhoneNoById(int employeeId) {
        ResultSet resultSet = null;
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            String selectSql = "SELECT phone_no FROM employees WHERE employee_id = ?";
            PreparedStatement ps = connection.prepareStatement(selectSql);
            ps.setInt(1, employeeId);
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

    public static String getAddressById(int employeeId) {
        ResultSet resultSet = null;
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            String selectSql = "SELECT address FROM employees WHERE employee_id = ?";
            PreparedStatement ps = connection.prepareStatement(selectSql);
            ps.setInt(1, employeeId);
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

    public static int getPositionIdById(int employeeId) {
        ResultSet resultSet = null;
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            String selectSql = "SELECT position_id FROM employees WHERE employee_id = ?";
            PreparedStatement ps = connection.prepareStatement(selectSql);
            ps.setInt(1, employeeId);
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

    public static int getDepartmentIdById(int employeeId) {
        ResultSet resultSet = null;
        try {
            // get connection of the HRMS database
            Connection connection = DAO.getConnection();

            String selectSql = "SELECT department_id FROM employees WHERE employee_id = ?";
            PreparedStatement ps = connection.prepareStatement(selectSql);
            ps.setInt(1, employeeId);
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

    // department, position
    public String getPositionName() {
        return Position.getPositionNameById(this.getPositionIdById(this.getEmployeeId()));
    }

    // display
    public void printPersonalInfo() {

        System.out.println("---------------------------------- Personal Info ----------------------------------");
        System.out.println("ID: " + this.getEmployeeId());
        System.out.println("Name: " + this.getName());
        System.out.println("Birth Date: " + this.getBirthDate());
        System.out.println("Gender: " + this.getGender());
        System.out.println("Phone No: " + this.getPhoneNo());
        System.out.println("Address: " + this.getAddress());
        System.out.println("Salary: RM " + Position.getSalaryById(this.getPositionId()));

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Position: " + Position.getPositionNameById(this.getPositionId()));
        System.out.println("Department: " + Department.getDepartmentNameById(this.getDepartmentId()));
        System.out.println("Manager's name: " + Employee.getNameById(Department.getManagerIdById(this.getDepartmentId())));
        System.out.println("----------------------------------------------------------------------------------\n\n");

    }

    public void editPersonalInfo() {
        Scanner keyboard = new Scanner(System.in);
        String input = "";
        String prevPhoneNo = this.getPhoneNo();
        String prevAddress = this.getAddress();
        String newPhoneNo;
        String newAddress;

        System.out.println("---------------------------------- Edit Personal Info ----------------------------------");
        //
        System.out.println("Hint: Edit new info or press [Enter] to skip.\n");
        System.out.print("Phone No [" + prevPhoneNo + "]: ");
        input = keyboard.nextLine();
        newPhoneNo = (input.equals("") ? prevPhoneNo : (input));
        input = "";

        System.out.print("Address [" + prevAddress + "]: ");
        input = keyboard.nextLine();
        newAddress = (input.equals("") ? prevAddress : (input));

        //
        System.out.println("\nHint: Your new info would be like: ");
        System.out.println("Phone No: " + newPhoneNo);
        System.out.println("Address: " + newAddress);
        System.out.print("\nHint: Are you sure to change your info? \n1. Yes\n2. No\nChoice: ");
        int choice;

        try {
            choice = keyboard.nextInt();
            System.out.println("-----------------------------------------------------------------------------------------\n\n");
            switch (choice) {
                case 1:
                    handleChangePhoneNo(prevPhoneNo, newPhoneNo);
                    handleChangeAddress(prevAddress, newAddress);
                    break;
                case 2:
                    System.out.println("Hint: Cancel change info.\n\n");
                    break;
                default:
                    System.out.println("Please enter valid number!\n\n");
            }
        } catch (Exception e) {
//            System.out.println("Please enter valid");
            throw new RuntimeException(e);
        }


    }

    public void handleChangePhoneNo(String prevPhoneNo, String newPhoneNo) {

        if (!prevPhoneNo.equals(newPhoneNo)) {
            try {
                boolean isPhoneNoUpdate = Employee.updatePhoneNo(this.getEmployeeId(), newPhoneNo);

                if (isPhoneNoUpdate) {
                    int managerId = Department.getManagerIdById(this.getDepartmentId());
                    String type = "Phone No - UPDATE";
                    String msgToEmployee =
                            "Your phone no updated from [" + prevPhoneNo + "] to [" + newPhoneNo + "].";
                    String msgToManager =
                            "Your subordinate [" + this.getName() + "]'s phone no updated from [" + prevPhoneNo + "] to [" + newPhoneNo + "].";
                    String date = MyDate.getDateTimeString(new Date());

                    Notification toEmployee = new Notification(0, employeeId, type, msgToEmployee, date);
                    Notification toManager = new Notification(0, managerId, type, msgToManager, date);

                    Notification.insertNotification(toEmployee);
                    Notification.insertNotification(toManager);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void handleChangeAddress(String prevAddress, String newAddress) {

        if (!prevAddress.equals(newAddress)) {
            try {
                boolean isAddressUpdate = Employee.updateAddress(this.getEmployeeId(), newAddress);

                if (isAddressUpdate) {
                    int managerId = Department.getManagerIdById(this.getDepartmentId());
                    String type = "Address - UPDATE";
                    String msgToEmployee =
                            "Your address updated from [" + prevAddress + "] to [" + newAddress + "].";
                    String msgToManager =
                            "Your subordinate [" + this.getName() + "]'s address updated from [" + prevAddress + "] to [" + newAddress + "].";
                    String date = MyDate.getDateTimeString(new Date());

                    Notification toEmployee = new Notification(0, employeeId, type, msgToEmployee, date);
                    Notification toManager = new Notification(0, managerId, type, msgToManager, date);

                    Notification.insertNotification(toEmployee);
                    Notification.insertNotification(toManager);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

    }

    public static void printList() {
        try {
            System.out.println("---------------------------------------------- Employee List ----------------------------------------------");
            Connection connection = DAO.getConnection();
            String sql = "SELECT * FROM employees";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            StringBuilder list = new StringBuilder();
            list.append("+------+----------------------+----------------------+--------+-----------------+------------------------------+-------------------------+----------------------+\n");
            list.append("| ID   | Name                 | Birth Date           | Gender | Phone No        | Address                      | Position                | Department           |\n");
            list.append("+------+----------------------+----------------------+--------+-----------------+------------------------------+-------------------------+----------------------+\n");

            while (resultSet.next()) {

                int employeeId = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String birthDate = resultSet.getString(3);
                String gender = resultSet.getString(4);
                String phoneNo = resultSet.getString(5);
                String address = resultSet.getString(6);
                int positionId = resultSet.getInt(7);
                int departmentId = resultSet.getInt(8);

                list.append(String.format("| %-4d | %-20s | %-20s | %-6s | %-15s | %-29s | %-24s | %-20s |\n",
                        employeeId, name, birthDate, gender, phoneNo, address, positionId, departmentId));
                list.append("+------+----------------------+----------------------+--------+-----------------+------------------------------+-------------------------+----------------------+\n");
            }

            System.out.println(list.toString());
            System.out.println("\n\n");


        } catch (Exception e) {
            System.out.println("Employee class");
            System.out.println(e.getMessage());

            throw new RuntimeException(e);
        }
    }

    public void printChangePosition() {
        Scanner keyboard = new Scanner(System.in);
        int choice;
        String prevPosition = Position.getPositionNameById(this.getPositionId());
        String newPosition = "";

        while (true) {
            System.out.println("------------------- Change Position -------------------");
            Employee employee = Employee.getInstanceFromDatabase(this.getEmployeeId());

            System.out.println("What is the department of position?\n" +
                    "1. My Department\n" +
                    "2. Other Department\n" +
                    "0. Back\n" +
                    "-1. Exit Program");
            System.out.print("Choice: ");

            try {
                choice = keyboard.nextInt();
                System.out.println("-------------------------------------------------\n\n");
                List<Integer> positionIdlist = null;

                switch (choice) {
                    case 1:
                        positionIdlist = Position.printAndGetIdList(this, true);
                        handleChangePosition(positionIdlist, true);
                        break;

                    case 2:
                        positionIdlist = Position.printAndGetIdList(this, false);
                        handleChangePosition(positionIdlist, false);
                        break;

                    case 0:
                        System.out.println("--------------------- Back ---------------------\n\n");
                        NormalPage.mainPage(this.getEmployeeId());
                        break;

                    case -1:
                        System.out.println("------------- Exit Program -------------");
                        System.exit(0);

                    default:
                        System.out.println("Please enter valid number!\n\n");

                }

            } catch (Exception e) {
                System.out.println("Please enter valid value!\n\n");
            }
        }

    }

    public void handleChangePosition(List<Integer> positionIdlist, boolean isSameDepartment) {
        Scanner keyboard = new Scanner(System.in);
        int choice;
        String prevPosition = Position.getPositionNameById(this.getPositionId());
        String newPosition = "";
        int prevDepartmentId = this.getDepartmentId();
        int newDepartmentId = 0;

        System.out.print("Choice: ");
        try {
            choice = keyboard.nextInt();
            Position.verifyPositionId(choice); // exist
            boolean choiceIsValid = false;

            for (int positionId : positionIdlist) {
                if (choice == positionId) {
                    newPosition = Position.getPositionNameById(positionId);
//                    boolean isUpdate = Employee.updatePositionId(this.getEmployeeId(), choice);
//                    System.out.println("Hint: " + ((isUpdate) ? "Change position successful." : "Fail change position.\n\n"));
                    boolean isApplyPosition = notifyApplyPosition(prevPosition, newPosition);
                    System.out.println(
                            "Hint: " + ((isApplyPosition)
                                    ? "Your application has change to the manager.)"
                                    : "Your application is failed to send.") + "\n\n");
                    choiceIsValid = true;


                    // notify change department
                    if (!isSameDepartment) {
                        newDepartmentId = Position.getDepartmentIdById(positionId);
                        boolean isApplyDepartment = notifyApplyDepartment(prevDepartmentId, newDepartmentId);
                    }

                }
            }
            if (!choiceIsValid) {
                System.out.println("Hint: The ID is unvalid.\n\n");
            }


        } catch (Exception e) {
            System.out.println("Please enter valid value\n\n");
            printChangePosition();
        }
        NormalPage.mainPage(this.getEmployeeId());
    }

    public boolean notifyApplyPosition(String prevPosition, String newPosition) {
        int managerId = Department.getManagerIdById(this.getDepartmentId());
        String type = "Position - APPLY";
        String msgToEmployee = "You request of change position from [" + prevPosition + "] to [" + newPosition + "] was send to the manager.";
        String msgToManager = "Your subordinate [" + this.getName() + "] " +
                "request to change position from [" + prevPosition + "] to [" + newPosition + "].";
        String date = MyDate.getDateTimeString(new Date());

        // create a notification
        Notification toEmployee = new Notification(0, this.getEmployeeId(), type, msgToEmployee, date);
        Notification toManager = new Notification(0, managerId, type, msgToManager, date);

        return Notification.insertNotification(toManager) && Notification.insertNotification(toEmployee);

    }

    // leave
    public boolean notifyApplyDepartment(int prevDepartmentId, int newDepartmentId) {
        int prevManagerId = Department.getManagerIdById(prevDepartmentId);
        int newManagerId = Department.getManagerIdById(newDepartmentId);
        String prevDepartmentName = Department.getDepartmentNameById(prevDepartmentId);
        String newDepartmentName = Department.getDepartmentNameById(newDepartmentId);

        String type = "Department - APPLY";
        String msgToEmployee = "You request of change department " +
                "from [" + prevDepartmentName + "] " +
                "to [" + newDepartmentName + "] was send to the manager.";

        String msgToPrevManager = "Your subordinate [" + this.getName() + "] "
                + "request quit your department [" + prevDepartmentName
                + "] and join the department [" + newDepartmentName + "].";
        String msgToNewManager = "The employee [" + this.getName() + "] "
                + "request join your department [" + prevDepartmentName + "] "
                + "from department [" + newDepartmentName + "].";
        String date = MyDate.getDateTimeString(new Date());

        Notification toEmployee = new Notification(0, this.getEmployeeId(), type, msgToEmployee, date);
        Notification toPrevManager = new Notification(0, prevManagerId, type, msgToPrevManager, date);
        Notification toNewManager = new Notification(0, newManagerId, type, msgToNewManager, date);

        return Notification.insertNotification(toEmployee)
                && Notification.insertNotification(toPrevManager)
                && Notification.insertNotification(toNewManager);
    }

}
