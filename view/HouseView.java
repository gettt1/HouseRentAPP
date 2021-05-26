package com.sfstudy.house.view;

import com.sfstudy.house.domain.House;
import com.sfstudy.house.service.HouseService;
import com.sfstudy.house.utils.Utility;

/*
 * @ Date: 12:12 2021/5/25
 * @ Description:
 * 1. 显示界面
 * 2. 接收用户的输入
 * 3. 调用HouseService完成对房屋信息的各种操作
 *
 */
public class HouseView {
//    loop控制显示菜单
    private boolean loop = true;
//    key接收用户输入
    private char key = ' ';
//    创建HouseService对象
//  设置系统中内容大小为3，此处无法随机生成3个不同的房屋信息....求教
    private HouseService  houseService = new HouseService(3);

//    编写delHouse()，接收输入的id，调用service的del方法
    public void delHouse(){
        System.out.println("-------------------删除房屋-------------------\n");
        System.out.print("提示：已存在的id:");
        houseService.existId();
        System.out.print("\n请输入需要删除的房屋编号(-1退出)：");
        int delId = Utility.readInt();
        if(delId == -1){
            System.out.println("-----------------放弃删除房屋-----------------\n");
            return;
        }
        char choice = Utility.readConfirmSelection(); // 注意该方法就存在循环判断的逻辑
        if(choice == 'Y'){
            if (houseService.del(delId)){
                System.out.println("-----------------成功删除房屋-----------------\n");
            }else {
                System.out.println("---------------房屋编号不存在，删除失败---------------\n");
            }
        }else {
            System.out.println("-----------------放弃删除房屋-----------------\n");
        }
    }

//    创建addHouse(), 接收输入，创建House对象，调用add方法
    public void addHouse(){
        System.out.println("-------------------添加房屋-------------------");
        System.out.print("姓名: ");
        String name = Utility.readString(8, " ");
        System.out.print("电话: ");
        String tel = Utility.readString(12, " ");
        System.out.print("地址: ");
        String address = Utility.readString(16, " ");
        System.out.print("月租: ");
        int rent = Utility.readInt(0);
        System.out.print("状态: ");
        String state = Utility.readString(3, " "); // 此处有键盘输入回车，不需要println
        // id是系统输入的，与输入的无关
        House newHouse = new House(0, name, tel, address, rent, state);
        if(houseService.add(newHouse)){
            System.out.println("================添加房屋成功=================\n");
        }else {
            System.out.println("================添加房屋失败=================\n");
        }
    }

//    编写listHouses()显示房屋列表
    public void listHouses(){
        System.out.println("===================房屋列表===================");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if(houses[i] == null){
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("================房屋列表显示完毕================\n");
    }

    public void findHouse(){
        System.out.println("-------------------查找房屋-------------------");
        System.out.print("提示：已存在的id:");
        houseService.existId();
        System.out.print("\n请输入需要查找的房屋编号(-1退出)：");
        int findId = Utility.readInt();
        if(findId == -1){
            System.out.println("-----------------退出查找房屋-----------------\n");
            return;
        }
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        if (houseService.find(findId)){
            System.out.println("-----------------成功查找房屋-----------------\n");
        }else {
            System.out.println("---------------房屋编号不存在，查找失败---------------\n");
        }
    }

    public void updateHouse(){
        System.out.println("------------------修改房屋信息------------------");
        System.out.print("提示：已存在的id:");
        houseService.existId();
        System.out.print("\n请输入需要修改的房屋编号(-1退出)：");
        int updateId = Utility.readInt();
        if(updateId == -1){
            System.out.println("-----------------退出修改房屋-----------------\n");
            return;
        }
        if (houseService.update(updateId)){
            System.out.println("-----------------成功修改房屋-----------------\n");
        }else {
            System.out.println("---------------房屋编号不存在，修改失败---------------\n");
        }
    }

//    确认退出
    public void exit(){
        char c = Utility.readConfirmSelection();
        if(c == 'Y'){
            loop = false;
        }else {
            System.out.println();
        }
    }

    public void mainMenu(){
        do{
            System.out.println("===================房屋出租系统===================");
            System.out.println("\t\t\t1 新 增 房 屋");
            System.out.println("\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t3 删 除 房 屋 信 息");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 显 示 房 屋 信 息 列 表");
            System.out.println("\t\t\t6 退 出");
            System.out.print("请输入你的选择(1-6):");
            key = Utility.readChar();

            switch (key){
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    updateHouse();
                    break;
                case '5':
                    listHouses();
                    break;
                case '6':
                    exit();
                    break;
                default:
                    System.out.println("请输入(1-6)的整数：");
            }
        }while (loop);
    }

}
