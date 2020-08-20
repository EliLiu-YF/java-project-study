package com.javase.day0819;

import com.tools.setStrategy.IntSetStrategy;
import com.tools.setStrategy.SetStrategy;
import com.tools.setStrategy.SetStrategyFactory;
import com.tools.setStrategy.StrSetStrategy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {
    /**
     * 读取文件将数据存放到map中
     * @return
     */
    static Map<String,String> readFile(){
        Map<String, String> map = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("Student"));
            String buf = br.readLine();
            while(buf!=null){
                String[] strings = buf.split("=");
                if (strings.length!=0){
                    map.put(strings[0],strings[1]);
                    buf = br.readLine();
                }
            }
            return map;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void main(String[] args) {
        Map<String, String> map = readFile();
        try {
            Class c = Class.forName(map.get("class"));
            Object o = c.newInstance();
            Field[] fields = c.getDeclaredFields();
            //在工厂容器中注册添加各个类型赋值的策略
            SetStrategyFactory.register("int",new IntSetStrategy());
            SetStrategyFactory.register("java.lang.String",new StrSetStrategy());
            //Stream流对数组进行遍历
            Arrays.stream(fields).forEach(f -> {
                f.setAccessible(true);
                String type = f.getType().getName();
                if (map.containsKey(f.getName())){
                    //在工厂中获取当前属性数值类型赋值所需要的策略
                    SetStrategy setStrategy = SetStrategyFactory.get(type);
                    setStrategy.set(f,o,map);
                }
            });
            System.out.println(o);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
