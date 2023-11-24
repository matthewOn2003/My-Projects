package src.Project_RentHouseSys.HouseRentApp;

import src.Project_RentHouseSys.HouseRentView.HouseRentView;

public class HouseRentApp {
    public static void main(String[] args) {
        /* HouseView类
        1. 显示页面
        2. 接收用户输入
        3. 调用HouseService完成对房屋信息的操作
         */

        /*HouseService类
        1. 响应HouseView的调用
        2. 完成对房屋信息的操作(CRUD)
         */

        /*HouseDomain类
        1. 一个House对象代表一个房屋的信息
        2. 因还没学数据库，就用数组保存房屋信息
         */

        /*Utily类
        1. 工具类，获取用户的输入

         */

        /*HouseRentApp
        1. main方法，程序入口
        2. 创建house对象，显示主菜单
        3. 我把它放在一个包，看起来整齐
         */

        new HouseRentView().mainMenu();

    }
}
