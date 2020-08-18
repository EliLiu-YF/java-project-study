package com.javase.day0728.a2;

import com.javase.day0728.a.Parent;

public class Test extends Parent{

    public void test(){
        this.d = 20; //不同包内,但继承了Parent类,可以访问
    }
    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.a = 10;//a 为public 的,可以访问
    //    parent.b = 10; // 不在同一个包内,不能访问
//        parent.c = 10; 私有的,不能访问
//        parent.d = 100; 不是同一包,不能访问

    }

}
