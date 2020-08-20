package com.tools.setStrategy;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 通过反射创建对象为属性赋值,不同类型属性赋值策略类实现的接口;
 */
public interface SetStrategy {
    void set(Field field, Object obj, Map<String,String> map);
}
