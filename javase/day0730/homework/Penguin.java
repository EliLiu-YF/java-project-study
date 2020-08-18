package com.javase.day0730.homework;

public class Penguin extends Pet implements IEatable, ISwimmable{
    public Penguin(String name, int love, int health) {
        super(name, love, health);
    }

    @Override
    public void eat() {
        System.out.println(getName()+"吃鱼");
    }


    @Override
    public void print() {
        System.out.println("我叫"+getName()+",我和主人亲密度"+getLove()+", 我的健康值"+getHealth());
    }

    @Override
    public void swim() {
        System.out.println(getName()+"游泳");
    }
}
