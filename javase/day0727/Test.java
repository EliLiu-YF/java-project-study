package com.javase.day0727;

public class Test {

    public static void exp() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer1 = new StringBuffer("abc");
        stringBuffer.append("1");
        stringBuffer.append("1.1");
        stringBuffer.append("abc");
        System.out.println(stringBuffer.toString());
        char[] ch = {'1', '2', '3'};
        stringBuffer1.append(ch);
        System.out.println(stringBuffer1.toString());
        //删除索引0-1之间的子字符串(不包括1)
        stringBuffer1.delete(0, 1);
        System.out.println(stringBuffer1);
        //在索引为2 的位置插入字符串
        stringBuffer1.insert(2, "aa");
        System.out.println(stringBuffer1);
        stringBuffer1.insert(1, 1.1);
        System.out.println(stringBuffer1);
        //将索引0-4之间的字符串替换
        stringBuffer1.replace(0, 4, "aa");
        System.out.println(stringBuffer1);
        System.out.println("********************");
        //StringBuffer线程安全,StringBuilder线程不安全
        StringBuilder stringBuilder = new StringBuilder("abcd");
        stringBuilder.append("efg");
        System.out.println(stringBuilder);
        stringBuilder.insert(0, 1);
        System.out.println(stringBuilder);
        stringBuilder.delete(0, 2);
        System.out.println(stringBuilder);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.println(stringBuilder);
        stringBuilder.replace(0, 2, "aaa");
        System.out.println(stringBuilder);
    }

    public static String exp2(String name, int age, String sno) {
        String str = "{\"name\":\"" + name + "\", \"age\":" + age + ", \"sno\":\"" + sno + "\"}";
        return str;
    }

    public static StringBuffer exp3(String name, int age, String sno) {
        StringBuffer stringBuffer = new StringBuffer("{");
        stringBuffer.append("\"name\":\"" + name + "\", ");
        stringBuffer.append("\"age\":" + age + ", ");
        stringBuffer.append("\"sno\":\"" + sno + "\"}");
        return stringBuffer;
    }

    public static void main(String[] args) {
        exp();
//        System.out.println(exp2("小明", 12, "123"));
//        System.out.println(exp3("小明", 12, "123"));
    }
}
