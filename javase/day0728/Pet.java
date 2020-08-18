package com.javase.day0728;

public abstract class Pet {
    private  String name;

    private int love;

    private int heath;

    protected int love2 = 1; //默认访问权限

    public Pet() {
        System.out.println("父类无参构造方法");
    }

    public Pet(String name, int heath, int love) {
        this.name = name;
        this.heath = heath;
        this.love = love;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLove() {
        return love;
    }

    public void setLove(int love) {
        this.love = love;
    }

    public int getHeath() {
        return heath;
    }

    public void setHeath(int heath) {
        this.heath = heath;
    }

    public abstract void print();
}
