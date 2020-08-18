package com.javase.day0804.homework2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("01",85);
        hashMap.put("02",67);
        hashMap.put("03",89);
        Set<Map.Entry<String, Integer>> entrySet = hashMap.entrySet();
        Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
        while(entryIterator.hasNext()){
            Map.Entry<String, Integer> entry = entryIterator.next();
            System.out.println("学号:"+entry.getKey()+","+"分数:"+entry.getValue());
        }
        hashMap.put("01",90);
        System.out.println(hashMap.values());
    }
}
