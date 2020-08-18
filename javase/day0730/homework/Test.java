package com.javase.day0730.homework;

public class Test {
    public static void main(String[] args) {
        Dog wangCai = new Dog("旺财",50, 50);
        wangCai.eat();
        Penguin huaTeng = new Penguin("马化腾", 50, 50);
        huaTeng.swim();
        wangCai.catchingFlyDisc();
        huaTeng.print();
        Pet pet = new Dog("腾化马", 50, 50);
        ((Dog)pet).eat();
    }
}
