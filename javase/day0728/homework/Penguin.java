package com.javase.day0728.homework;

public class Penguin extends Pet {
    private String sex;

    public Penguin(){

    }

    public Penguin(String name, int health, int love, String sex){
        super(name, health, love);
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public void print() {
        System.out.println("我的名字是"+getName()+", 我的健康值是"+getHealth()+", 我和主人的亲密度是"+getLove()
                +", 我得性别是"+sex);
    }
}
