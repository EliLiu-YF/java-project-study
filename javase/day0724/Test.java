package com.javase.day0724;

import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void exp1() {
        String str1 = "hello world"; //在常量池中分配一个内存,并且内容是hello world
        String str2 = new String("hello world"); //在堆中重新分配内存空间
        String str3 = "hello world"; //在常量池中指向的是同一个地址
        String str4 = new String("hello world"); //在堆中重新分配内存空间
        System.out.println(str1.equals(str2)); //true
        System.out.println(str1 == str2); //false
        System.out.println(str1.equals(str3)); //true
        System.out.println(str1 == str3); //true
        System.out.println(str2.equals(str4)); //true
        System.out.println(str2 == str4); //false
    }

    /**
     * 随机一个长度在50-100之间有a-z 组成的字符串
     *
     * @param minLen 最小长度
     * @param maxLen 最大长度
     * @return
     */
    public static String randomString(int minLen, int maxLen) {
        Random random = new Random();
        int len = random.nextInt(maxLen - minLen + 1) + minLen;
        String str = "";
        for (int i = 0; i < len; i++) {
            char c = (char)(random.nextInt(26)+97);
            str += c;
        }
        return str;
    }

    public static void main(String[] args) {
//        exp1();
//        String str = randomString(50,100);
//        System.out.println(str.length());
////      getBytes()  将字符串转为字节类型的数组
//        System.out.println(str.getBytes().length);
//        str += "中文";
////        中文占2个字节
//        System.out.println(str.length());
//        System.out.println(str.getBytes().length);
        String str2 = "abc";
        String str3 = "ABC";
//        System.out.println(str2.equals(str3));
//        System.out.println(str2.equalsIgnoreCase(str3));
//        System.out.println(str2.equals(str3.toLowerCase()));
//        System.out.println(str3.equals(str2.toUpperCase()));
        System.out.println(str2.concat("abc"));
        System.out.println(str2);
        String strA= "abcabccom";
//        查找 "ab"字符在 字符串strA中第一次出现的位置
        System.out.println(strA.indexOf("ab"));
//        查找 "ab"字符在 字符串strA中最后一次出现的位置
        System.out.println(strA.lastIndexOf("com"));
//        从第2个位置查找查找 "ab"字符在 字符串strA中第一次出现的位置
//        System.out.println(strA.indexOf("ab",3));
////        查找 "ab"字符在 字符串strA中最后一次出现的位置,添加索引后反向查找
//        System.out.println(strA.lastIndexOf("ab",1));
////        截取strA中从下标1开始到最后的字符串并返回,原字符串不变
//        System.out.println(strA.substring(1));
////        截取strA中下标从1到3的字符串(不包括3)并返回,原字符串不变
//        System.out.println(strA.substring(1,3));
////        将srtA中的ab替换成aa并返回,原字符串不变
//        System.out.println(strA.replace("ab","aa"));
//        System.out.println(strA);
////        返回strA中下标为0的字符
//        System.out.println(strA.charAt(0));
////        返回strAz中下标为0的字符串的uniCode码值
//        System.out.println(strA.codePointAt(0));
//        String strC = "ab#ab#ab";
////         将strA以#为分隔组成字符串数组并返回 原字符串不变
//        System.out.println(Arrays.toString(strC.split("#")));
//        String strD = "abc";
//        String strE = "bcd";
//        将strD strE第一个字符的unicode码相减,若第一个相等则匹配下一个
//        System.out.println(strD.compareTo(strE));
    }
}
