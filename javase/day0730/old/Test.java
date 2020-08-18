package com.javase.day0730.old;

public class Test {

    public static void exp(){
        //IMyInterface iMyInterface = new IMyInterface(); 接口不能实例化
        IMyInterface iMyInterface = new MyInterfaceImpl();
        iMyInterface.test();
    }

    public static void main(String[] args) {

    }
}
