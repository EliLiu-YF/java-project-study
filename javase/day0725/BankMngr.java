package com.javase.day0725;

import java.util.Arrays;
import java.util.Scanner;

public class BankMngr {
    BankUser[] bankUsers = new BankUser[5];

    int size = 0;

    /**
     * 增加用户
     *
     * @param user
     */
    public void addUser(BankUser user) {
        if (size >= bankUsers.length) {
            bankUsers = Arrays.copyOf(bankUsers, bankUsers.length + 1);
        }
        bankUsers[size] = user;
        ++size;
    }

    /**
     * 打印所有用户信息
     */
    public void showInfo() {
        for (int i = 0; i < size; i++) {
            System.out.println(bankUsers[i].name + ":" + bankUsers[i].money);
        }
    }

    /**
     * 查询余额大于money的所有用户信息
     * @param money
     * @return
     */
    public BankUser[] getUser(int money){
        BankUser[] bankUsers = new BankUser[0];
        int size = 0;
        for (int i = 0; i < this.size; i++) {
            if (this.bankUsers[i].money > money){
                if (size >= bankUsers.length){
                    bankUsers = Arrays.copyOf(bankUsers, bankUsers.length+1);
                }
                bankUsers[size] = this.bankUsers[i];
                ++size;
            }
        }
        if (bankUsers.length == 0){
            return null;
        }
        return bankUsers;
    }

    /**
     * 查询用户名等于name的用户信息
     * @param name
     * @return
     */
    public BankUser getUser(String name){
        for (int i = 0; i < size; i++) {
            if (bankUsers[i].name.equals(name)){
                return bankUsers[i];
            }
        }
        return null;
    }

    /**
     * 查询所有性别等于sex的用户信息
     * @param sex
     * @return
     */
    public BankUser[] getUserBySex(String sex){
        BankUser[] bankUsers = new BankUser[0];
        int size = 0;
        for (int i = 0; i < this.size; i++) {
            if (this.bankUsers[i].sex.equals(sex)){
                if (size >= bankUsers.length){
                    bankUsers = Arrays.copyOf(bankUsers, bankUsers.length+1);
                }
                bankUsers[size] = this.bankUsers[i];
                ++size;
            }
        }
        if (bankUsers.length==0){
            return null;
        }
        return bankUsers;
    }

    /**
     * 根据卡号card查询用户的余额 找到返回money 没找到返回-1
     * @param card
     * @return
     */
    public double getMoney(String card){
        for (int i = 0; i < size; i++) {
            if (bankUsers[i].card.equals(card)){
                return bankUsers[i].money;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BankMngr bankMngr = new BankMngr();
        Scanner scanner = new Scanner(System.in);
        String again = "y";
        while (again.equals("y")){
            BankUser bankUser = new BankUser();
            System.out.print("请输入卡号");
            bankUser.card = scanner.next();
            System.out.print("请输入用户名");
            bankUser.name = scanner.next();
            System.out.print("请输入年龄");
            bankUser.age = scanner.nextInt();
            System.out.print("请输入余额");
            bankUser.money = scanner.nextInt();
            System.out.print("请输入性别");
            bankUser.sex = scanner.next();
            bankMngr.addUser(bankUser);
            System.out.print("是否继续");
            again = scanner.next();
        }
//        bankMngr.showInfo();
        BankUser[] b = bankMngr.getUser(50);
        if (b != null) {
            for (int i = 0; i < b.length; i++) {
                System.out.println(b[i].money);
            }
        }
        if (bankMngr.getUser("qq") != null) {
            System.out.println(bankMngr.getUser("qq").name);
        }
        BankUser[] c = bankMngr.getUserBySex("男");
        if (c != null) {
            for (int i = 0; i < c.length; i++) {
                System.out.println(c[i].sex);
            }
        }
        System.out.println(bankMngr.getMoney("1"));

    }
}
