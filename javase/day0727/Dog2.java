package com.javase.day0727;

public class Dog2 {
    private int health;
    //设置属性值
    public void setHealth(int health){
        if(health <0 || health > 100){
            return;
        }
        //this是一个关键字，表示当前对象
        this.health = health;
    }
    //得到属性值
    public int getHealth(){
        return health;
    }
}
