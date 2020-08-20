package com.tools.setStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 注册,存放,获取各个策略的工厂容器
 */
public class SetStrategyFactory {
    static Map<String,SetStrategy> setStrategys = new HashMap<>();

    /**
     * 获取策略
     * @param key
     * @return
     */
    public static SetStrategy get(String key){
        if (!setStrategys.containsKey(key)){
            return null;
        }
        return setStrategys.get(key);
    }

    /**
     * 注册添加策略
     * @param str
     * @param setStrategy
     */
    public static void register(String str, SetStrategy setStrategy){
        setStrategys.put(str,setStrategy);
    }
}
