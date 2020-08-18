package com.javase.day0722;

import java.util.Arrays;
import java.util.Scanner;

public class CustomerTestDemo {
    Customer[] customers = new Customer[5];

    int size;

    public boolean search(String name){
        for (int i = 0; i < size; i++) {
            if (customers[i].name.equals(name)){
                return true;
            }
        }
        return false;
    }

    public void show() {
        System.out.println("***********************");
        System.out.println("    客户姓名列表");
        System.out.println("***********************");
        for (int i = 0; i < size; i++) {
            System.out.print(customers[i].name + "\t");
        }
    }

    public void add(Customer customer) {
        customers[size] = customer;
        ++size;
        if (size >= customers.length) {
            customers = Arrays.copyOf(customers, customers.length * 2);
        }
    }

    public static void main(String[] args) {
        CustomerTestDemo customerTestDemo = new CustomerTestDemo();
        Scanner sc = new Scanner(System.in);
        String again = "y";
        do {
            System.out.print("请输入客户姓名:");
            Customer customer = new Customer();
            customer.name = sc.next();
            customerTestDemo.add(customer);
            System.out.print("是否继续:");
            again = sc.next();
        } while (again.equals("y"));
        customerTestDemo.show();
        System.out.print("\n请输入要查找的客户姓名:");
        String name = sc.next();
        System.out.println("******查找结果******");
        if (customerTestDemo.search(name)){
            System.out.println("找到了!");
        }else {
            System.out.println("没找到!");
        }

    }
}
