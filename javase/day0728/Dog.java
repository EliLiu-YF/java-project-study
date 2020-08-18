package com.javase.day0728;

public class Dog extends Pet{

    private String strain;

    public String getStrain() {
        return strain;
    }

    public void setStrain(String strain) {
        this.strain = strain;
    }

    @Override
    public void print() {
        System.out.println("dog print");
    }
}
