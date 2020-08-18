package com.javase.day0804.homework1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ValueComp implements Comparator<String> {
    Map<String, User> map;

    public ValueComp(Map<String, User> map) {
        this.map = map;
    }


    @Override
    public int compare(String o1, String o2) {
        if (map.get(o1).getScore() >= map.get(o2).getScore()){
            return -1;
        }else {
            return 1;
        }
    }
}
