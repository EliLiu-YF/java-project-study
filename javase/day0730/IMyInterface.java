package com.javase.day0730;

/*
jdk1.8之后接口增加的方法
 */
public interface IMyInterface {
    //静态方法
    static void test() {
        System.out.println("test");
    }

    //默认方法
    default void test2() {
        System.out.println("test2");
    }
}

class Test1 implements IMyInterface{
    public static void main(String[] args) {
        //静态方法用接口名调用
        IMyInterface.test();
        Test1 test = new Test1();
        //默认方法用实现类对象名调用
        test.test2();
    }
}
