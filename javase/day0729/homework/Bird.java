package com.javase.day0729.homework;

public class Bird extends Animal{
    private String color;

    public Bird(int age, String color){
        super(age);
        this.color = color;
    }

    public Bird(){

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void info() {
        System.out.println("我是一只"+color+"色的鸟");
        System.out.println("我今年"+getAge()+"岁了");
    }
}
