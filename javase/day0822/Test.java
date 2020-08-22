package com.javase.day0822;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Test {
    static void exp() {
        User user = new User("小明", 20, "男");
        System.out.println(toJson(user));
    }

    static String toJson(Object obj) {
        Class c = obj.getClass();
        StringBuffer sb = new StringBuffer("{}");
        Field[] fields = c.getDeclaredFields();
        Arrays.stream(fields).forEach(f -> {
            f.setAccessible(true);
            String key = f.getName();
            try {
                Object value = f.get(obj);
                sb.insert(sb.indexOf("}"),"\""+key+"\":"+"\""+value+"\", ");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        sb.delete(sb.indexOf("}")-2,sb.indexOf("}"));
        return String.valueOf(sb);
    }

    public static void main(String[] args) {
        exp();
    }
}
