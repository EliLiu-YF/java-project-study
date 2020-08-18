package com.javase.day0801.homework1;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * 银行管理系统
 */
public class BankMngr {

    List<User> userList = new ArrayList<>();

    /**
     * 增加用户
     *
     * @param user
     */
    public void addUser(User user) {
        userList.add(user);
    }

    /**
     * 打印用户
     */
    public void showInfo() {
        System.out.println("*******************************");
        for (User user : userList) {
            System.out.println("卡号:" + user.getCardId() + ", 姓名:" + user.getName() + ", 性别:"
                    + user.getSex() + ", 年龄:" + user.getAge() + ", 存款金额:" + user.getMoney() + "元");
        }
        System.out.println("*******************************");
    }

    /**
     * 查询余额大于money的用户
     *
     * @param money
     * @return 没找到返回null
     */
    public ArrayList<User> getUser(int money) {
        ArrayList<User> findUser = new ArrayList<>(0);
        for (User user : userList) {
            if (user.getMoney() > money) {
                findUser.add(user);
            }
        }
        if (findUser.size() == 0) {
            return null;
        }
        return findUser;
    }

    /**
     * 查找用户名为name的用户
     *
     * @param name
     * @return 没找到返回null
     */
    public User getUser(String name) {
        for (User user : userList) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    /**
     * 查询性别为sex的用户
     *
     * @param sex
     * @return
     */
    public ArrayList<User> getUserBySex(String sex) {
        ArrayList<User> findUser = new ArrayList<>(0);
        for (User user : userList) {
            if (user.getSex().equals(sex)) {
                findUser.add(user);
            }
        }
        if (findUser.size() == 0) return null;
        return findUser;
    }

    /**
     * 根据卡号查找用户存款余额,
     *
     * @param cardId
     * @return 没找到返回-1
     */
    public double getMoney(String cardId) {
        for (User user : userList) {
            if (user.getCardId().equals(cardId)) {
                return user.getMoney();
            }
        }
        return -1;
    }

    /**
     * 存钱
     * @param cardId
     * @param money
     * @return
     */
    public boolean saveMoney(String cardId, double money) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getCardId().equals(cardId)) {
                userList.get(i).setMoney(userList.get(i).getMoney() + money);
                return true;
            }
        }
        return false;
    }

    /**
     * 取钱
     * @param cardId
     * @param money
     * @return
     */
    public boolean   takeMoney(String cardId, double money){
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getCardId().equals(cardId)) {
                if (money > userList.get(i).getMoney()) return false;
                userList.get(i).setMoney(userList.get(i).getMoney() - money);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BankMngr bankMngr = new BankMngr();
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String again = "y";
        do{
            User user = new User();
            System.out.print("请输入卡号:");
            user.setCardId(sc.next());
            System.out.print("请输入用户名:");
            user.setName(sc.next());
            System.out.print("请输入性别:");
            user.setSex(sc.next());
            System.out.print("请输入年龄:");
            user.setAge(sc.nextInt());
            user.setMoney(random.nextInt(4501)+500);
            bankMngr.addUser(user);
            System.out.print("是否继续");
            again = sc.next();
        }while (again.equals("y"));
        bankMngr.showInfo();
//        System.out.print("请输入你要查询的余额大小:");
//        ArrayList<User> list1 = bankMngr.getUser(sc.nextInt());
//        if (list1 ==null){
//            System.out.println("没有该用户");
//        }else {
//            for (User user : list1){
//                System.out.println(user.toString());
//            }
//        }
//        System.out.print("请输入你要查询的用户名称");
//        User user = bankMngr.getUser(sc.next());
//        if (user == null){
//            System.out.println("没有该用户");
//        }else {
//            System.out.println(user.toString());
//        }
//        ArrayList<User> list = bankMngr.getUserBySex("男");
//        for (User user : list){
//            System.out.println(user.toString());
//        }
//        System.out.println(bankMngr.getMoney("01"));
        bankMngr.saveMoney("01",4000);
        bankMngr.showInfo();
        bankMngr.takeMoney("01",2000);
        bankMngr.showInfo();
    }
}
