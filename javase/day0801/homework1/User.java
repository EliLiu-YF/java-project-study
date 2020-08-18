package com.javase.day0801.homework1;

public class User {
    private String cardId;

    private String name;

    private String sex;

    private int age;

    private double money;

    public User(String cardId, String name, String sex, int age, double money) {
        this.cardId = cardId;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.money = money;
    }

    public User() {
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return
                "卡号:'" + cardId + '\'' +
                ", 姓名:'" + name + '\'' +
                ", 性别:'" + sex + '\'' +
                ", 年龄:" + age +
                ", 余额:" + money
                ;
    }
}
