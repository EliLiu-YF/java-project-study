package com.javase.day0803;

import java.util.Comparator;

public class NewsComp implements Comparator<News> {
    @Override
    public int compare(News o1, News o2) {
        return o1.getId() - o2.getId();
    }
}
