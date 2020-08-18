package com.javase.day0729.homework;

public class Fish extends Animal{
    private String weight;

    public Fish(int age, String weight){
        super(age);
        this.weight = weight;
    }

    public Fish(){

    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public void info() {
        System.out.println("我是一只"+weight+"斤重的鱼");
        System.out.println("我今年"+getAge()+"岁了");
    }
}
