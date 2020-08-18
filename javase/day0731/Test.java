package com.javase.day0731;

import java.util.*;

public class Test {
    Object[] ojb = new Object[5];

    public static void exp() {
        List list = new ArrayList();
        list.add(1);
        list.add("111");
        list.add(new Object());
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(0, 0);
        System.out.println(list1.get(1));
        List<String> list2 = new ArrayList<>();
        list2.add("111");
        list2.add("222");
        Iterator<Integer> iterator = list1.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
//        Object a = new Random();
//        Object b = new Double(111);
//        Object c = new Scanner(System.in);
//        Test test = new Test();
//        test.ojb[0] = a;
//        test.ojb[1] = b;
//        test.ojb[2] = c;
        exp();
    }
}
