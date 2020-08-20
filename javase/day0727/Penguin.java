package com.javase.day0727;

public class Penguin {
//    静态常量常用来设置固定值
    static final String SEX_MALE = "q仔";

    static final String SEX_FEMALE = "q妹";

    String name;

    static int love;

    String sex;

    public Penguin(){
        name = "企鹅";
        love = 100;
    }

    public void show(){
        System.out.println("名字:"+name+", 亲密度:"+love+", 性别:"+sex);
    }

    public static void main(String[] args) {
        Penguin penguin = new Penguin();
        Penguin penguin1 = new Penguin();

        //常量值是固定不变的,不能重新赋值
//        final int b = 1;
        //当定义引用类型为常量时,不能重新指向另一块地址,但是可以改变其中的属性值
//        penguin.name = "aaa.txt";
//        penguin = new Penguin();
        penguin.sex = Penguin.SEX_MALE;
        penguin.show();
        penguin.love = 100;
        penguin1.love = 90;
        System.out.println(penguin.love);
        System.out.println(penguin1.love);

    }
}
