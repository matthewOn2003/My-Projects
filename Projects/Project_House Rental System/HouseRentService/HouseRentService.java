package src.Project_RentHouseSys.HouseRentService;

import src.Project_RentHouseSys.HouseRentDomain.House;

import java.util.Scanner;

public class HouseRentService {
    Scanner keyboard = new Scanner(System.in);
    private House[] houses;//House数组，保存House对象

    //add
    int i = 0;//编号/索引
    int houseNums = 0;


    //del


    //一个构造器，给House数组的大小赋值()，注意：还没有房屋信息
    public HouseRentService(int size) {
        houses = new House[size];
    }

    //5. 房屋列表
    public House[] list() {
        return houses;
    }

    //1. 新增房源
    public boolean addHouses() {
        if (houseNums == houses.length) {
            System.out.println("提示：房屋列表已满，不能再添加\n");
            return false;
        }

        System.out.println("提示：请输入以下房屋信息");
        int id = i+1;//初始编号是0

        System.out.print("房主：");
        String name = keyboard.next();

        System.out.print("电话：");
        String phoneNo = keyboard.next();

        System.out.print("地址：");
        String address = keyboard.next();

        System.out.print("月租：");
        int rent = keyboard.nextInt();

        String status = "未出租";

        houses[i] = new House(id, name, phoneNo, address, rent, status);//为每一个房屋赋值
        System.out.println("---------------- 房屋信息已添加 ----------------\n");

        i++;//编号/数组索引增加
        houseNums++;

        return true;
    }

    //3. 删除房屋
    public boolean del(int del_id) {
        int index = -1;

        for (int i = 0; i < houseNums; i++) {
            if (del_id == houses[i].getId()) {
                index = i;//真正要删除的是i索引的对象
            }//走完后还没进入判断的话，那del_id的值还是-1
        }

        if (index == 1) {
            return false;
        }
        for (int i = index; i < houseNums - 1; i++) {
            houses[i] = houses[i+1];
            houses[i+1] = null;
        }
        houseNums--;//少一个
        System.out.println("--------------- 已删除该房屋信息 ---------------\n");

        return true;

        //数组长度：5
        //要删除 编号3(数组[2])
        //i = 2 获取到的索引
        //2 < 数组长度-1(4)
        //会跑1次
        //house[2] = house[3]第四位
        //house[3] = null
        //跑第2次
        //i++了，i=3
        //house[3] = house[4]第五位赋值给第四位
        //house[4] = null 第五位制空

    }

    public House search(int id) {
        for (int i = 0; i < houses.length; i++) {
            /*
            this.id = id;
            this.name = name;
            this.phoneNo = phoneNo;
            this.address = address;
            this.rent = rent;
            this.status = status;
             */
            if (id == houses[i].getId()) {
                return houses[i];
            }

        }
        return null;
    }


    //3. 删除房屋
//    public void delHouses() {
//        System.out.print("请输入你想删除的房屋编号：");
//        del_id = keyboard.nextInt();
//
//        for (int a = 0; a < houseNums; a++) {
////            System.out.println(houses[a].getId());
//
//            if (houses[a].getId() == del_id) {
//                while (true) {
//                    System.out.println("确定要删除此房屋吗？");
//                    System.out.println(houses[a]);
//                    System.out.print("1. 是\n2. 否\n您的选择：");
//                    del_choice = keyboard.nextInt();
//
//                    switch (del_choice) {
//                        case 1:
//                            houses[a] = null;
//                            System.out.println("温馨提示：房屋信息已删除。");
//                            break;
//                        case 2:
//                            break;
//
//                        default:
//                            System.out.println("温馨提示：不删除，返回菜单");
//                            System.out.println("温馨提示：请再次确认是否删除！");
//                    }
//                }
//
//            } else {
//                System.out.println("温馨提示：没有此编号的房屋信息！");
//                break;
//            }
//
//        }
//
//    }

}

