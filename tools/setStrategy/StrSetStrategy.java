package com.tools.setStrategy;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 为String类型赋值的策略类
 */
public class StrSetStrategy implements SetStrategy{
    @Override
    public void set(Field field, Object obj, Map<String, String> map) {
        try {
            field.set(obj,map.get(field.getName()));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
