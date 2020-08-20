package com.javase.day0819;

import com.tools.setStrategy.IntSetStrategy;
import com.tools.setStrategy.SetStrategy;
import com.tools.setStrategy.SetStrategyFactory;
import com.tools.setStrategy.StrSetStrategy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class User {
    private String name;

    private int age;

    private String sex;

    public User(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public User() {
    }

    private String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Class 类的类型
     * Field 属性的类型
     * Methods 方法的类型
     * Constructor 构造器的类型
     */
    private static void exp() {
        try {
            Class c = Class.forName("com.javase.day0819.User");
            Field[] fields = c.getDeclaredFields();
            Arrays.stream(fields).forEach(f -> System.out.println(f.getName()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void exp2() {
        try {
            Class c = Class.forName("com.javase.day0819.User");
            Method[] methods = c.getMethods();
            Arrays.stream(methods).forEach(m -> System.out.println(m.getName()));
            System.out.println("************");
            Method[] methods1 = c.getDeclaredMethods();
//            Modifier.toString(m.getModifiers())获取访问权限
            Arrays.stream(methods1).forEach(m -> System.out.println(Modifier.toString(m.getModifiers())
                    + "," + m.getReturnType() + "," + m.getName()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    static void exp3() {
        User user = new User("小明", 10, "男");
        Class c = user.getClass();
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);//将私有属性设置为可访问
            try {
                System.out.println(field.get(user));//获取属性值
                if (field.getType().getName().equals("int")) {
                    field.set(user, 30);//对属性值进行改变
                }
                System.out.println(field.get(user));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    static String toJson(Object object) {
        if (object == null) {
            return null;
        }
        StringBuffer sb = new StringBuffer("{}");
        Class c = object.getClass();
        Field[] fields = c.getDeclaredFields();
        Arrays.stream(fields).forEach(f -> {
            f.setAccessible(true);
            try {
                sb.insert(sb.indexOf("}"), "\"" + f.getName() + "\"" + ":" + "\"" + f.get(object) + "\"" + ", ");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        sb.delete(sb.indexOf("}") - 2, sb.indexOf("}"));
        return sb.toString();

    }

    static void exp4() {
        Class c = User.class;
        Constructor[] constructors = c.getDeclaredConstructors();
        Arrays.stream(constructors).forEach(con -> {
            System.out.println(con.getName());//获取构造器的名字
            Parameter[] parameters = con.getParameters();//获取构造器的参数
            Arrays.stream(parameters).forEach(p -> {
                System.out.println("--" + p.getType());//获取参数的类型
                System.out.println("--" + p.getName());//获取参数的名字
            });
        });
    }

    /**
     * 使用反射创建对象
     */
    static void exp5() {
        Class c = User.class;
        try {
            User u = (User) c.newInstance();//创建对象
            u.setName("小明");
            System.out.println(u.getName());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    static Map<String, String> getFile() {
        Map<String, String> map = new HashMap<>();
        try {
            FileReader fr = new FileReader("aaa.txt");
            BufferedReader br = new BufferedReader(fr);
            String buf = br.readLine();
            while (buf != null) {
                String[] strs = buf.split("=");
                if (strs.length != 0) {
                    map.put(strs[0], strs[1]);
                }
                buf = br.readLine();
            }
            return map;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    /**
     * 根据读取的文件数据,创建对应的对象
     */
    static void exp6() {
        Map<String, String> map = getFile();
        try {
            Class c = Class.forName(map.get("class"));
            Object obj = c.newInstance();
            Field[] fields = c.getDeclaredFields();
            SetStrategyFactory.register("int",new IntSetStrategy());
            SetStrategyFactory.register("java.lang.String",new StrSetStrategy());
            for (Field field : fields) {
                field.setAccessible(true);
                String type = field.getType().getName();
                if (map.containsKey(field.getName())) {
                    SetStrategy setStrategy = SetStrategyFactory.get(field.getType().getName());
                    setStrategy.set(field,obj,map);
                }
            }
            System.out.println(obj.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
//        System.out.println(toJson(new User("小明",10,"男")));
//        System.out.println(getFile());
        exp6();
    }


}
