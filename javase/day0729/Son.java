package com.javase.day0729;
//fianl修饰的类不能被继承
public class Son extends Parent {
    //    public int a;
    //final修饰成员变量需要初始化
    final int b =  10;
    public Son() {
        //当父类没有无参构造器时,需要在子类构造器中显式调用父类有参构造器
        super(1);
    }
    //final修饰的方法不能重写
//    public void run(){
//
//    }

    public void show() {
        super.a = 20;
        this.a = 30;
        System.out.println(super.a);
        System.out.println(this.a);
    }

    public static void main(String[] args) {
//        Parent parent = new Parent(); Parent类构造器设置为私有 不能再本类外调用构造器实例化
        Son son = new Son();
        son.show();
        //final修饰局部变量可以不初始化,但只能赋值一次
        final int a;
        a = 10;
//        a= 12;
        //final修饰引用类型不能再次引用
        //但可以改变对象中的值
        final Son son1 = new Son();
//        son1 = new Son();
    }
}
