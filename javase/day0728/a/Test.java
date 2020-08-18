package com.javase.day0728.a;

public class Test {
    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.a = 10; //a 为public的,可以访问
        parent.c = 10; //本包内,c可以访问
//        parent.b = 10; b为私有的,不能访问
        parent.d = 20;
    }
}
