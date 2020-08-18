package com.javase.day0729.homework;

public abstract class Animal {
    private int age;

    public Animal(int age) {
        this.age = age;
    }

    public Animal() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract void info();
}
