package src.Project_RentHouseSys.HouseRentService;

import src.Project_RentHouseSys.HouseRentDomain.House;

import java.util.Scanner;

public class HouseRentService {
    Scanner keyboard = new Scanner(System.in);
    private static House[] houses; // stores House Object

    //add
    int i = 0; //index
    static int houseNums = 0;

    // A constructor to initialize houses array
    public HouseRentService(int size) {
        houses = new House[size];
    }

    public static House[] getHouses() {
        return houses;
    }

    public static int getHouseNums() {
        return houseNums;
    }

    //5. House List
    public House[] list() {
        return houses;
    }

    //1. Add house
    public boolean addHouses() {
        if (houseNums == houses.length) {
            System.out.println("Hint: The list of houses is full and no more can be added.\n");
            return false;
        }

        System.out.println("Hint: Please enter the following house information. (not include space)");
//        System.out.print("House ID: ");
        int id = houseNums+1;

        System.out.print("Owner name: ");
        String name = keyboard.next();

        System.out.print("Phone No: ");
        String phoneNo = keyboard.next();

        System.out.print("Address: ");
        String address = keyboard.next();

        System.out.print("Rent Fee (RM): ");
        int rent = keyboard.nextInt();

        String status = "available";

        houses[i] = new House(id, name, phoneNo, address, rent, status);//为每一个房屋赋值
        System.out.println("---------------- Housing information has been added ----------------\n");

        i++;
        houseNums++;

        return true;
    }

    //3. Delete house
    public boolean del(int del_id) {
        int index = -1;
//        System.out.println("进入del方法");

        for (int i = 0; i < houseNums; i++) {
//        System.out.println("进入del方法的第一个for");
            if (del_id == houses[i].getId()) {

//        System.out.println("进入del方法的第一个for的if");
                index = i;
            }
        }

//        if (index == 1) {
//            return false;
//        }
        for (int i = index; i < houseNums - 1; i++) {
//        System.out.println("进入del方法的第2个for");
            System.out.println(houses[i]);
            System.out.println(houseNums);
            houses[i] = houses[i+1];
            houses[i+1] = null;
        }
        houseNums--;//少一个
        System.out.println("--------------- Deleted this house ---------------\n");

        return true;
    }

    public static House search(int id) {
            System.out.println("id=" + id);
            System.out.println("house nums=" + houseNums);
        if (id < 0 || id > houseNums) {
            return null;
        }

        for (int i = 0; i < houses.length; i++) {
            if (id == houses[i].getId()) {
                return houses[i];
            }
        }
        return null;
    }

    // 4. Modify house information
    public boolean modifyHouse(int modify_id) {
        if (modify_id < 1 || modify_id > houseNums) {
            System.out.println("Hint: Invalid house ID!");
            return false;
        }

        House houseToModify = houses[modify_id - 1];

        System.out.println("Hint: Enter the new information for the house (not include space)");

        System.out.print("Owner name: ");
        houseToModify.setName(keyboard.next());

        System.out.print("Phone No: ");
        houseToModify.setPhoneNo(keyboard.next());

        System.out.print("Address: ");
        houseToModify.setAddress(keyboard.next());

        System.out.print("Rent Fee (RM): ");
        houseToModify.setRent(keyboard.nextInt());

        System.out.println("---------------- Housing information has been modified ----------------\n");

        return true;

    }

}

