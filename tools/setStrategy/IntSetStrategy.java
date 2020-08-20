package com.tools.setStrategy;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 为int类型属性赋值的策略类
 */
public class IntSetStrategy implements SetStrategy{
    @Override
    public void set(Field field,Object obj, Map<String,String> map) {
        try {
            field.set(obj, Integer.valueOf(map.get(field.getName())));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
