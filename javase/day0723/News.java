package com.javase.day0723;

import java.util.Random;

public class News {
    public int id;

    public String title;

    public String content;

    public void show() {
        System.out.println(id);
        System.out.println(title);
        System.out.println(content);
    }

    public static void main(String[] args) {
        News[] newsArr = new News[10];
        Random random = new Random();
        for (int i = 0; i < newsArr.length; i++) {
            News news = new News();
            news.id = i + 1;
            news.title = "新闻" + (i + 1);
            String str = "";
            for (int j = 0; j < 100; j++) {
                char ch = (char) (random.nextInt(26) + 97);
                str += ch;
            }
            news.content = str;
            newsArr[i] = news;
        }
        for (News news : newsArr){
            news.show();
        }
    }

}
