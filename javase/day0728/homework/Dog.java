package com.javase.day0728.homework;

public class Dog extends Pet {
    private String strain;

    public Dog() {

    }

    public Dog(String name, int health, int love, String strain) {
        super(name, health, love);
        this.strain = strain;
    }

    public String getStrain() {
        return strain;
    }

    public void setStrain(String strain) {
        this.strain = strain;
    }

    @Override
    public void print() {
        System.out.println("我的名字叫"+getName()+", 我的健康值是"+getHealth()+", 我的类型是"+getStrain());
    }
}
