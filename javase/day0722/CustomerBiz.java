package com.javase.day0722;

import java.util.Arrays;

public class CustomerBiz {
    String[] names = new String[5];

    int size;

    public void show() {
        System.out.println("*******************");
        System.out.println("    客户姓名列表");
        System.out.println("*******************");
        System.out.println(Arrays.toString(names));
    }

    public void add(String name) {
        names[size++] = name;
        if (size >= names.length) {
            names = new String[10];
        }
    }

    public static void main(String[] args) {
//        CustomerBiz cu = new CustomerBiz();
//        for (int i = 0; i < 9; i++) {
//            cu.add("张三" + i);
//        }
//        cu.show();
        // Arrays.copyOf(arr[] ,length);  将旧数组中的元素copy给一个新数组  并指定新数组的长度
        // 参数1: 旧数组
        // 参数2: 新数组的长度
        // return 返回新数组
        String[] arr1 = {"a", "b", "c", "d", "e"};
        String[] arr2 = Arrays.copyOf(arr1, 10);
        System.out.println(Arrays.toString(arr2));
        String[] arr3 = Arrays.copyOf(arr1, 2);
        System.out.println(Arrays.toString(arr3));
    }
}
