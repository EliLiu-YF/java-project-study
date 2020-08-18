package com.javase.day0727;

public class Dog {
    public static final String a;
    //静态代码块 ,用来完成静态常量属性的初始化
    static {
        a = "aaa";
    }

    //宠物狗的名字
    String name;
    //健康程度
    int health;
    //与主人的亲密度
    int love;
    //品种
    String strain;

    public Dog() {
        System.out.println("dog构造");
        name = "旺财";
        love = 100;
        health = 80;
        strain = "哈士奇";
    }

    public Dog(String name){
        System.out.println("调用了参数为name的构造方法");
    }

    public Dog(int love){
        System.out.println("调用了参数为love的构造方法");
    }

    public Dog(String name, int health, String strain){
        System.out.println("调用了参数为name,health,strain的构造方法");
    }

    public Dog(short a){
        System.out.println("short");
    }

    public void print() {
        System.out.println("狗的品种是:" + strain + ", 名字:" + name + ", 健康程度:" + health + ", 与主人的亲密度:" + love);
    }

    public static void main(String[] args) {
        Dog dog = new Dog((short)1);
//        dog.print();
        Dog2 dog2 = new Dog2();
        dog2.setHealth(-1);
        System.out.println(dog2.getHealth());
    }
}
