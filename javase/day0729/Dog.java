package com.javase.day0729;

public class Dog extends Pet {

    private String strain;

    /**
     * 一个类的构造方法允许互相调用，但是只能是彼此构造方法的第一句代码
     * 并且不能在普通成员方法中调用构造方法
     */
    public Dog() {

    }

    //静态方法中不能用this
    public static void test() {

    }


    public String getStrain() {
        return strain;
    }

    public void setStrain(String strain) {
        this.strain = strain;
    }

    public void print() {
        System.out.println("狗的品种是:" + strain + ",名字是:" + this.getName() + ", 健康值是：" + this.getHealth() +
                ", 与主人的亲密度是:" + this.getLove());
    }

    @Override
    public void toHospital() {
        if (this.getHealth() < 50) {
            this.setHealth(80);
            System.out.println("打针,吃药" + ", 当前健康值" + this.getHealth());
        }
    }

    public void catchFlyDisc(){
        System.out.println("狗会接飞盘");
    }
}
