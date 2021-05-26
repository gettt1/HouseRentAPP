package com.sfstudy.house.service;

import com.sfstudy.house.domain.House;
import com.sfstudy.house.utils.Utility;

/*
 * @ Date: 12:41 2021/5/25
 * @ Description:
 * 1. 定义House[]，保存House对象
 * 2. 相应HouseView的调用
 * 3. 完成对房屋信息的各种操作(增删改查c[create]r[read]u[update]d[delete])
 *
 */
public class HouseService {
    private House[] houses;
//    private int houseNum = 0; // 记录当前有多少个房屋信息, 实现扩容后该变量与houses.length意义一致
    private int idCounter = 0; //记录id增长到哪个值，目前系统中默认的个数，HouseService中定义的
    // 由于中间会有删除的房屋信息，但房屋id会一直增长，因此id和已有的房屋信息并不存在任何数学关系


    public HouseService(int size){ // size为默认系统中的House个数
        houses = new House[size]; // 创建HouseService对象，指定数组大小
        // 为了配合测试列表信息，初始化两个对象，系统中自带
        for (int i = 0; i < size; i++) {
            houses[i] = new House(++idCounter, "jack", "122", "海淀区", 4000, "未出租");
//            houseNum++;
        }

    }

//    del方法，删除新对象，返回boolean
    public boolean del(int delId){
        // 应先找到删除房屋的下标，不能简单认为删除的id就是对应的下标
        int index = -1;
        for (int i = 0; i < houses.length; i++) {
            if(delId == houses[i].getId()){
                index = i;
                break;
            }
        }
        if(index == -1){
            System.out.println("未找到该房屋，请再次确认房屋ID");
            return false;
        }
        
        // 删除
        // 创建临时变量
        House[] temp = new House[houses.length-1];
        for (int i = 0; i < houses.length ; i++) {
            if(i < index) temp[i] = houses[i];
            else if(i > index) temp[i-1] = houses[i];
        }
        houses = temp;
        return true;
    }

//    add方法，添加新对象，返回boolean
    public boolean add(House newHouse){
        // 判断是否能添加
//        if(houseNum >= houses.length){// 不能再添加
//            System.out.println("数组已满，无法添加");
//            return false;
//        }

        // 设置关卡，如果录入信息不完整则无法添加房屋
        if(newHouse.getName() == " ") return false;
        if(newHouse.getTel() == " ") return false;
        if(newHouse.getAddress() == " ") return false;
        if(newHouse.getRent() == 0) return false;
        if(newHouse.getState() == " ") return false;
        // 实现扩容
        House[] temp = new House[houses.length+1];
        for (int i = 0; i < houses.length; i++) {
            temp[i] = houses[i];
        }
        temp[houses.length] = newHouse;

//        houses[houseNum++] = newHouse;
        // 设置id自增长，然后更新id，与输入的id无关
        newHouse.setId(++idCounter);
        houses = temp;
        return true;
    }

    public boolean find(int houseId){
        for (int i = 0; i < houses.length; i++) {
            if(houseId == houses[i].getId()){
                System.out.println(houses[i]);
                return true;
            }
        }
        System.out.println("未找到该房屋，请再次确认房屋ID");
        return false;
    }

    public boolean update(int updateId){
        for (int i = 0; i < houses.length; i++) {
            if(updateId == houses[i].getId()){
                // 修改房屋信息，其中键盘直接输入回车为默认不做修改
                System.out.print("姓名(" + houses[i].getName() + "):");
                houses[i].setName(Utility.readString(8, houses[i].getName()));
                System.out.print("电话(" + houses[i].getTel() + "):");
                houses[i].setTel(Utility.readString(12, houses[i].getTel()));
                System.out.print("地址(" + houses[i].getAddress() + "):");
                houses[i].setAddress(Utility.readString(16, houses[i].getAddress()));
                System.out.print("租金(" + houses[i].getRent() + "):");
                houses[i].setRent(Utility.readInt(houses[i].getRent()));
                System.out.print("状态(" + houses[i].getState() + "):");
                houses[i].setState(Utility.readString(3, houses[i].getState()));
                return true;
            }
        }
        System.out.println("未找到该房屋，请再次确认房屋ID");
        return false;
    }

    public House[] list(){
        return houses;
    }

    public void existId(){
        for (int i = 0; i < houses.length; i++) {
            if(houses[i] == null){
                break;
            }
            System.out.print(houses[i].getId() + " ");
        }
    }
}
