package com.javase.day0722;

import java.util.Arrays;
import java.util.Scanner;

public class StudentBiz {
    //定义学生类数组,存放学生对象
    Student[] students = new Student[5];

    int size;

    public void add(Student stu) {
        students[size] = stu;
        ++size;
        if (size >= students.length) {
            students = Arrays.copyOf(students, students.length);
        }
    }

    public void show() {
        System.out.println("************************");
        System.out.println("    学生信息列表");
        System.out.println("************************");
        for (int i = 0; i < size; i++) {
            System.out.println(students[i].name + "\t" + students[i].idNumber + "\t" + students[i].age);
        }
    }

    public static void main(String[] args) {
        StudentBiz studentBiz = new StudentBiz();
        Scanner sc = new Scanner(System.in);
        String again = "y";
        do {
            System.out.println("请输入学生信息");
            System.out.print("学生姓名:");
            String name = sc.next();
            System.out.print("学生学号:");
            String idNumber = sc.next();
            System.out.print("学生年龄");
            int age = sc.nextInt();
            Student stu = new Student();
            stu.name = name;
            stu.age = age;
            stu.idNumber = idNumber;
            studentBiz.add(stu);
            System.out.print("是否继续(y/n):");
            again = sc.next();
        } while (again.equals("y"));
        studentBiz.show();
    }


}
