package src.Project_RentHouseSys.HouseRentView;

import src.Project_RentHouseSys.HouseRentDomain.House;
import src.Project_RentHouseSys.HouseRentService.HouseRentService;

import java.util.Scanner;

public class HouseRentView {
    /*主菜单功能说明
    1. 用户打开软件，可以看到主菜单
    2. 可以操作，增删改查房屋信息
    3. 可以退出程序
     */

    private boolean loop = true;//默认无限循环
    private int key = 0;//选择选项
    Scanner keyboard = new Scanner(System.in);
    HouseRentService houseRentService = new HouseRentService(5);//设置数组大小为5

    public void listHouses() {
        //因为房屋列表是界面而不是操作，所以放在view类
        System.out.println("Hint: Below is the house list");
        System.out.println("=========== House List (max 5 houses) ===========");
        System.out.println("ID\t\tOwner\t\tPhoneNo\t\tAddress\t\tRent fee\t\tStatus");
        House[] houses = houseRentService.list();//接收被返回的数组
        for (int i = 0; i < houses.length; i++) {//输出每一个被存储在house数组的房屋信息
            if (houses[i] == null) {
                break;//如果是空对象，就不输出，跳到下一个循环
            }else {
                System.out.println(houses[i]);//直接调用对象会调用其toString方法(原是Object，但现已被重写)
            }
        }
        System.out.println("--------------- House List displayed ----------------\n");
    }


    public void delHouses() {
        System.out.println("Hint: Enter house id you want to delete (-1 = back to main menu)");
        System.out.print("房屋编号：");
        int del_id = keyboard.nextInt();

        if (del_id == -1) {
            System.out.println("----------------- Give up deleting house -----------------\n");
            return;
        }
        while (true) {
            System.out.print("Warning：Do you confirm to delete the house?\n1. Yes\n2. No\nYour choice");
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
        System.out.print("Enter house id：");
        key = keyboard.nextInt();
        House house = houseRentService.search(key);

        if (house == null) {
            System.out.println("The house is not exist!!");
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
            System.out.print("Your choice：");
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
            System.out.print("Exit Program?\n1. Yes\n2. No\nYour choice： ");
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

