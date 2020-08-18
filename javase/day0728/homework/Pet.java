package com.javase.day0728.homework;

public abstract class Pet {
    private String name;

    private int health = 60;

    private int love = 20;

    public Pet() {
    }

    public Pet(String name, int health, int love) {
        this.name = name;
        this.health = health;
        this.love = love;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public boolean setHealth(int health) {
        if (!(health > 0 && health < 100)){
            return false;
        }
        this.health = health;
        return true;
    }

    public int getLove() {
        return love;
    }

    public void setLove(int love) {
        this.love = love;
    }

    abstract public void print();
}
