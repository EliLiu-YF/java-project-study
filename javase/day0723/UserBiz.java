package com.javase.day0723;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class UserBiz {
    User[] users = new User[5];
    int size; //已有用户数量

    public void addUser(User user) {
        if (size >= users.length) {
            users = Arrays.copyOf(users, users.length * 2);
        }
        users[size++] = user;
    }

    /**
     * 查找年龄在minAge和maxAge之间的所有User对象
     *
     * @param minAge
     * @param maxAge
     * @return null无满足条件的数据，否则返回所有满足的对象数组
     */
    public User[] findUserByAge(int minAge, int maxAge) {
        User[] users = new User[0];
        for (int i = 0, j = 0; i < size; i++) {
            if (this.users[i].age >= minAge && this.users[i].age <= maxAge) {
                if (j >= users.length) {
                    users = Arrays.copyOf(users, users.length + 1);
                }
                users[j] = this.users[i];
                ++j;
            }
        }
        if (users.length != 0) {
            return users;
        }
        return null;
    }

    /**
     * 根据姓名查找User对象
     *
     * @param name 查找的姓名
     * @return null无该名字的用户，否则返回User对象
     */
    public User findUserByName(String name) {
        for (int i = 0; i < size; i++) {
            if (users[i].name.equals(name)) {
                return users[i];
            }
        }
        return null;
    }

    /**
     * 写一个方法：查找金币大于10000的所有用户
     * public User[] findUserByGold(double gold)
     *
     */
    /**
     * @param gold 查找大于或等于该金币的用户对象
     * @return 找到的用户对象数组, 如果没找到就返回null
     */
    public User[] findUserByGold(double gold) {
        User[] users = new User[1];
        int index = 0;
        boolean hasUser = false;
        for (int i = 0; i < size; i++) {
            if (this.users[i].gold >= gold) {
                if (index >= users.length) {
                    users = Arrays.copyOf(users, users.length + 1);
                }
                hasUser = true;
                users[index] = this.users[i];
                ++index;
            }
        }
        if (hasUser) {
            return users;
        } else {
            return null;
        }
    }

    public void show() {
        System.out.println("当前用户信息");
        System.out.println("用户姓名\t\t用户金币\t\t年龄");
        for (int i = 0; i < size; i++) {
            System.out.println(users[i].name + "\t\t\t" + users[i].gold + "\t\t\t" + users[i].age);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        UserBiz userBiz = new UserBiz();
        Random random = new Random();
        String isContinue = "y";
        do {
            System.out.println("1.增加用户,2.根据金币查找用户,3.根据年龄查找用户,4.根据姓名查找用户");
            System.out.print("请输入你的选择:");
            int sel = input.nextInt();
            switch (sel) {
                case 1:
                    User user = new User();
                    System.out.println("请输入用户的姓名:");
                    user.name = input.next();
                    user.age = random.nextInt(11) + 15;
                    user.gold = random.nextInt(9999) + 1000;
                    userBiz.addUser(user);
                    userBiz.show();
                    System.out.print("是否继续y/n:");
                    isContinue = input.next();
                    break;
                case 2:
                    System.out.print("请输入金币数量:");
                    int money = input.nextInt();
                    User[] users = userBiz.findUserByGold(money);
                    if (!(users == null)) {
                        System.out.println("当前用户信息");
                        System.out.println("用户姓名\t\t用户金币\t\t年龄");
                        for (int i = 0; i < users.length; i++) {
                            System.out.println(users[i].name + "\t\t\t" + users[i].gold + "\t\t\t" + users[i].age);
                        }
                    } else {
                        System.out.println("没有金币大于" + money + "的用户");
                    }
                    System.out.print("是否继续y/n:");
                    isContinue = input.next();
                    break;
                case 3:
                    System.out.print("请输入最小年龄:");
                    int minAge = input.nextInt();
                    System.out.print("请输入最大年龄:");
                    int maxAge = input.nextInt();
                    User[] userArr = userBiz.findUserByAge(minAge, maxAge);
                    if (userArr != null) {
                        System.out.println("用户姓名\t\t用户金币\t\t年龄");
                        for (int i = 0; i < userArr.length; i++) {
                            System.out.println(userArr[i].name + "\t\t\t" + userArr[i].gold + "\t\t\t"
                                    + userArr[i].age);
                        }
                    } else {
                        System.out.println("没有年龄" + minAge + "到" + maxAge + "之间的用户");
                    }
                    System.out.print("是否继续y/n:");
                    isContinue = input.next();
                    break;
                case 4:
                    System.out.print("请输入你要查找的用户姓名:");
                    String name = input.next();
                    User use = userBiz.findUserByName(name);
                    if (use != null) {
                        System.out.println("用户姓名\t\t用户金币\t\t年龄");
                        System.out.println(use.name + "\t\t\t" + use.gold + "\t\t\t" + use.age);
                    }else {
                        System.out.println("没有姓名是"+name+"的用户");
                    }
                    System.out.print("是否继续y/n:");
                    isContinue = input.next();
            }

        } while (isContinue.equals("y"));
    }
}
