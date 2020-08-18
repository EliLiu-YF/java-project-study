package com.javase.day0729;

/**
 * public:所有类都有访问权限
 * private:只有本类中的方法可以访问
 * 默认(不写访问权限):同包中的类可以访问,所以也叫包访问权限，有些地方也叫friendly访问权限
 * protected访问权限修饰符：本类可以访问，同包下的类也可以访问,不同包但是子类也可以访问
 */
public class Penguin extends Pet {
    private String sex = "Q仔";


    public Penguin(String name, int health, int love, String sex) {

    }

    public Penguin() {

    }

    public String getSex() {
        return sex;

    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void test() {
        this.setHealth(99);
        System.out.println(getHealth());
        this.love2 = 100;
    }

    public void print() {
        System.out.println("企鹅的性别是:" + sex + ",名字是:" + this.getName() + ", 健康值是：" + this.getHealth() + ", 与主人的亲密度是:" + this.getLove());
    }

    @Override
    public void toHospital() {
        if (this.getHealth() < 50) {
            this.setHealth(70);
            System.out.println("吃药,疗养" + ", 当前健康值" + this.getHealth());
        }
    }

    public void catchFish(){
        System.out.println("企鹅会抓鱼");
    }

}
