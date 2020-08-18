package com.javase.day0729;

import java.util.Scanner;

public class Master {
    /*
    多态：同一种事物，由于不同的条件，体现出不同的特性
     * 一个方法中，形参用父类类型声明，
     * 由于传递的实参的类型不同，会选择调用不同实参的各自重写的方法
     */
    public void cure(Pet pet) {
        pet.toHospital();
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        Penguin pen = new Penguin();
        dog.setHealth(40);
        pen.setHealth(30);
        Master master = new Master();
//        master.cure(dog);
//        master.cure(pen);
//        //父类的引用指向子类的对象
//        //把子类当成其父类来处理的过程叫做“向上转型
//        Pet pet = new Dog();
//        pet.toHospital();
        Pet pet = master.buyPet();
        pet.print();
        master.play(pet);
    }

    //主人和宠物玩
    public void play(Pet pet) {
        if (pet instanceof Dog) {
            Dog dog = (Dog) pet;
            dog.catchFlyDisc();
        } else if (pet instanceof Penguin) {
            Penguin penguin = (Penguin) pet;
            penguin.catchFish();
        }
    }

    public Pet buyPet() {
        Pet pet = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入你要领养的宠物类型:1.狗, 2.企鹅");
        int num = sc.nextInt();
        System.out.print("请输入你要领养的宠物名称:");
        String name = sc.next();
        switch (num) {
            case 1:
                pet = new Dog();
                System.out.print("请输入狗的品种:");
                ((Dog) pet).setStrain(sc.next());
                break;
            case 2:
                pet = new Penguin();
                System.out.print("请输入企鹅的性别:");
                ((Penguin) pet).setSex(sc.next());
                break;
        }
        pet.setName(name);
        return pet;
    }
}
