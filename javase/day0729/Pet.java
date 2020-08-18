package com.javase.day0729;

/**
 * 父类属性初始化->父类构造方法->子类属性初始化->子类构造方法
 * 如果想让一个类不能实例化(new) ，可以让这个类变成抽象类
 * 声明一个抽象类的关键字是abstract
 * 抽象方法：要求子类必须重写该方法,或则子类也变成抽象类
 */
public abstract class Pet {
    private String name;

    private int health = 10;

    private int love;
    public Pet(){}
    protected int love2; //默认访问权限

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLove() {
        return love;
    }

    public void setLove(int love) {
        this.love = love;
    }

    public abstract void print();

    public abstract void toHospital();
}
