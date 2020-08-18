package com.javase.day0731;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Son extends Person {
    public void test1() {

    }

    public static void main(String[] args) {
        Person person = new Son();
        person.test();
        ((Son) person).test1();
        List<Son> listSon = new ArrayList<>();
        listSon.add(new Son());
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add(0, "qwe");
        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        list.remove(0);
        for(String str: list){
            System.out.println(str);
        }
    }
}
