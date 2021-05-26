package com.sfstudy.house;

import com.sfstudy.house.view.HouseView;

/*
 * @ Date: 10:14 2021/5/25
 * @ Description:
 * 房屋出租系统App程序入口
 *
 */
public class HouseRentApp {
    public static void main(String[] args) {
        // 创建HouseView对象并调用main方法，是app入口
        new HouseView().mainMenu();
        System.out.println("系统提示：你已退出房屋出租系统...");
    }
}
