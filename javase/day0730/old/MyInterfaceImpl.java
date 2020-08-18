package com.javase.day0730.old;
//类与抽象类是继承关系,类与类是单继承关系
//接口与实现类是实现关系,实现接口的类被称为实现类,接口和类是多实现
//接口与接口是继承关系,接口与接口可以多继承
public class MyInterfaceImpl implements IMyInterface, IMyInterface2{
    @Override
    public void test() {

    }

    @Override
    public int test2() {
        return 0;
    }
}
