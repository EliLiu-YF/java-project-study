package com.javase.day0728.homework;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎来到宠物店");
        System.out.print("请输入你要领养的宠物名字:");
        String name = sc.next();
        System.out.print("请选择要领养的宠物类型:(1.狗, 2.企鹅)");
        int type = sc.nextInt();
        switch (type) {
            case 1:
                Dog dog = new Dog();
                System.out.print("请选择狗的品种:(1.聪明的拉布拉多犬, 2.酷酷的雪纳瑞)");
                String strain = selectStrain(sc.nextInt());
                System.out.print("请输入狗的健康值:");
                int health = sc.nextInt();
                dog.setName(name);
                dog.setStrain(strain);
                if (!dog.setHealth(health)) {
                    System.out.println("健康值应该在0-100之间,默认值是60");
                }
                System.out.println("宠物的自白:");
                dog.print();
                break;
            case 2:
                Penguin penguin = new Penguin();
                System.out.print("请选择企鹅的性别:");
                String sex =sc.next();
                System.out.print("请选择企鹅的健康值:");
                int qHealth = sc.nextInt();
                penguin.setName(name);
                penguin.setSex(sex);
                if (!(penguin.setHealth(qHealth))){
                    System.out.println("健康值应该在0-100之间,默认值是60");
                }
                System.out.println("宠物的自白");
                penguin.print();
                break;
        }
    }


    public static String selectStrain(int strainId) {
        String strain = "";
        switch (strainId) {
            case 1:
                strain = "聪明的拉布拉多犬";
                break;
            case 2:
                strain = "酷酷的雪纳瑞";
                break;
        }
        return strain;
    }
}
