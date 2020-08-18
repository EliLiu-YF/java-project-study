package com.javase.day0728;

public class Penguin extends Pet {

    private String sex = "q仔";

    public Penguin() {
        
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void test() {
        this.love2 = 90;
    }

    @Override
    public void print() {
        System.out.println("penguin print");
    }
}
