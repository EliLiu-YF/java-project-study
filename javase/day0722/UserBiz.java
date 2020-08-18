package com.javase.day0722;

import java.util.Arrays;
import java.util.Scanner;

public class UserBiz {
    User[] users = new User[5];

    int size;

    public void show(){
        System.out.println("**********************");
        System.out.println("\t用户金币列表");
        System.out.println("**********************");
        for (int i = 0; i < size; i++) {
            System.out.println("姓名:"+users[i].name+"\t金币:"+users[i].gold);
        }
    }
    public void add(User user){
        users[size] = user;
        ++size;
        if (size >= users.length){
            users = Arrays.copyOf(users, users.length*2);
        }
    }

    public static void main(String[] args) {
        UserBiz userBiz = new UserBiz();
        Scanner sc = new Scanner(System.in);
        String again = "y";
        do {
            User user = new User();
            System.out.print("请输入用户姓名:");
            user.name = sc.next();
            System.out.print("请输入用户金币");
            user.gold = sc.nextInt();
            userBiz.add(user);
            System.out.print("是否继续输入:");
            again = sc.next();
        }while (again.equals("y"));
        userBiz.show();
    }
}
