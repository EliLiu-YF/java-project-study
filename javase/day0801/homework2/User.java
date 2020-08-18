package com.javase.day0801.homework2;

public class User{

    private String id;

    private String name;

    private int age;

    private Address address;

    private String tel;

    public User(String id, String name, int age, Address address, String tel) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.tel = tel;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return id + "\t\t" + name + "\t\t" + age + "\t" + address.toString() + "\t\t" + tel;

    }
}
