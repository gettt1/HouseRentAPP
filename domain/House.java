package com.sfstudy.house.domain;

/*
 * @ Date: 12:05 2021/5/25
 * @ Description:
 * 创建House对象，储存House信息
 *
 */
public class House {
//    编号 房主 电话 地址 月租 状态(未出租/已出租)
    private int id;
    private String name;
    private String tel;
    private String address;
    private int rent;
    private String state;

    public House(int id, String name, String tel, String address, int rent, String state) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.address = address;
        this.rent = rent;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

//    重写toString方法，输出信息
    @Override
    public String toString() {
        return  id +
                "\t\t" + name +
                "\t" + tel +
                "\t\t" + address +
                "\t" + rent +
                "\t" + state;
    }
}
