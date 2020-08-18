package com.javase.day0730.homework;

public class Dog extends Pet implements IEatable, IFlyingDiscCatchable{
    public Dog(String name, int love, int health) {
        super(name, love, health);
    }

    @Override
    public void eat() {
        System.out.println(getName()+"吃狗粮");
    }

    @Override
    public void catchingFlyDisc() {
        System.out.println(getName()+"玩飞盘");
    }

    @Override
    public void print() {
        System.out.println("我叫"+getName()+",我和主人亲密度"+getLove()+", 我的健康值"+getHealth());
    }
}
