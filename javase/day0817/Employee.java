package com.javase.day0817;

public class Employee implements Cloneable{
    private String name;

    private Address address;

    private int age;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", age=" + age +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Employee employee = null;
        employee = (Employee) super.clone();
//        克隆employee的同时 ,将employee的address克隆
        employee.address = (Address) address.clone();
        return employee;
    }

    public Employee(String name, Address address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        System.out.println("克隆之前");
        Address address = new Address("中国","江西","南昌");
        Employee employee = new Employee("刘宇峰",address,21);
        System.out.println(employee.toString());
        System.out.println("克隆后");
        try {
            Employee employee1 = (Employee) employee.clone();
            employee1.setName("刘宇峰2");
            employee1.setAge(20);
            employee1.getAddress().setProvince("江西");
            employee1.getAddress().setCity("上饶");
            System.out.println("用户1");
            System.out.println(employee.toString());
            System.out.println("用户2");
            System.out.println(employee1.toString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


    }
}
