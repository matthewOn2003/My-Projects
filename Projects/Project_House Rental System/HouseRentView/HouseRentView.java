package src.Project_RentHouseSys.HouseRentView;

import src.Project_RentHouseSys.HouseRentDomain.House;
import src.Project_RentHouseSys.HouseRentService.HouseRentService;

import java.util.Scanner;

public class HouseRentView {
   /* Main Menu Functional Description
    1. Users open the software, you can see the main menu
    2. can operate, add, delete, change and check the housing information
    3. can exit the program
     */

    private boolean loop = true;
    private int key = 0;
    Scanner keyboard = new Scanner(System.in);
    HouseRentService houseRentService = new HouseRentService(5);

    public void listHouses() {
        // Because the list of houses is an interface rather than an operation, it is placed in the view class
        System.out.println("Hint: Below is the house list");
        System.out.println("=========== House List (max 5 houses) ===========");
        System.out.println("ID\t\tOwner\t\tPhoneNo\t\tAddress\t\tRent fee\t\tStatus");
        House[] houses = houseRentService.list();
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                break;
            }else {
                System.out.println(houses[i]);
            }
        }
        System.out.println("--------------- House List displayed ----------------\n");
    }


    public void delHouses() {
        System.out.println("Hint: Enter house id you want to delete (-1 = back to main menu)");
        System.out.print("House ID: ");
        int del_id = keyboard.nextInt();

        if (del_id == -1) {
            System.out.println("----------------- Canceled deleting house -----------------\n");
            return;
        } else {
            if (HouseRentService.search(del_id) == null) {
                System.out.println("Hint: The house is not exist!!");
                return;
            }
        }
        while (true) {
            System.out.print("Warning: Do you confirm to delete the house?\n1. Yes\n2. No\nYour choice: ");
            int del_choice = keyboard.nextInt();

            if (del_choice == 1) {
                houseRentService.del(del_id);
                break;

            } else if (del_choice == 2) {
                System.out.println("Hint: back to main menu");
                break;
            } else {
                System.out.println("Hint: Confirm again whether to delete!");
            }

        }

    }

    public void searchHouses() {
        System.out.print("Enter house id: ");
        key = keyboard.nextInt();
        House house = houseRentService.search(key);

        if (house == null) {
            System.out.println("Hint: The house is not exist!!");
        } else {
            System.out.println(house);
        }
        System.out.println("----------------------------------------------\n");
    }



    public void mainMenu() {
        do {
            System.out.println("================= House Rental System =================\n" +
                                "1. Add new houses\n" +
                                "2. Search for houses\n" +
                                "3. Delete houses\n" +
                                "4. Modify housing information\n" +
                                "5. House List\n" +
                                "6. Exit");
            System.out.print("Your choice: ");
            key = keyboard.nextInt();
            System.out.println("----------------------------------------------");

            switch (key) {
                case 1:
                    //新增房源
                    houseRentService.addHouses();
                    break;

                case 2:
                    //查询房屋
                    searchHouses();
                    break;

                case 3:
                    //删除房屋
                    delHouses();
                    break;

                case 4:
                    //修改房屋信息
                    // Modify housing information
                    System.out.print("Enter house id you want to modify: ");
                    int modify_id = keyboard.nextInt();
                    houseRentService.modifyHouse(modify_id);
                    break;

                case 5:
                    //房屋列表
                    listHouses();
                    break;

                case 6:
                    //退出
                    quit();
                    break;

                default:
                    System.out.println("Please enter valid number！(1~6)");
            }


        } while (loop);
        System.out.println("=================== Exit Program ===================");


    }


    public void quit() {
        int quit = 0;

        //默认继续循环true
        //把代码简化，阅读理解起来比较轻松
        while (true) {//这边先把输入范围定在1/2，如果不符合要求则重复，只有1/2能打破这个循环
            System.out.print("Exit Program?\n1. Yes\n2. No\nYour choice: ");
            quit = keyboard.nextInt();
            if (quit == 1) {
                loop = false;
                System.out.println("------------------- Confirm exit -------------------");
                break;//跳出while
            } else if (quit == 2) {
                System.out.println("Hint: back to main menu\n");
                break;//跳出while
            } else {
                System.out.println("Hint: Confirm again whether to exit!!\n");
            }

        }

    }
}

