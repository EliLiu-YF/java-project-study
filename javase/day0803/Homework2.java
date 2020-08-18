package com.javase.day0803;

import java.util.*;


public class Homework2 {

    public static void exp() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        for (Integer val : list) {
            System.out.println(val);
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void exp2() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(0);
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }
        for (Integer val : linkedList) {
            System.out.println(val);
        }
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void exp3(){
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(0);
        for (Integer val : hashSet){
            System.out.println(val);
        }
        Iterator<Integer> iterator = hashSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public static void exp4(){
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(0);
        treeSet.add(100);
        treeSet.add(-1000);
        treeSet.add(10000);
        for (Integer val : treeSet){
            System.out.println(val);
        }
        Iterator<Integer> iterator = treeSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public static void exp5(){
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(4);
        for (int i = 0; i < vector.size(); i++) {
            System.out.println(vector.get(i));

        }
        for (Integer val : vector){
            System.out.println(val);
        }
        Iterator<Integer> iterator = vector.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public static void exp6(){
        List<News> list = new ArrayList<>();
        list.add(new News(1,"title1"));
        list.add(new News(2,"title2"));
        list.add(new News(3,"title3"));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        for(News news : list){
            System.out.println(news);
        }
        Iterator<News> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public static void exp7(){
        LinkedList<News> linkedList = new LinkedList<>();
        linkedList.add(new News(3,"title3"));
        linkedList.add(new News(1,"title1"));
        linkedList.add(new News(2,"title2"));
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }
        for (News news : linkedList){
            System.out.println(news);
        }
        Iterator<News> iterator = linkedList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        Vector<News> vector = new Vector<>();
        vector.add(new News(1,"title1"));
        vector.add(new News(2,"title2"));
        vector.add(new News(3,"title3"));
        for (int i = 0; i < vector.size(); i++) {
            System.out.println(vector.get(i));
        }
        for (News news : vector){
            System.out.println(news);
        }
        Iterator<News> iterator1 = vector.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }

    public static void exp8(){
        HashSet<News> hashSet = new HashSet<>();
        hashSet.add(new News(2,"title2"));
        hashSet.add(new News(1,"title1"));
        News news = new News(3,"title3");
        hashSet.add(news);
        for(News news1 : hashSet){
            System.out.println(news1);
        }
        news.setTitle("title33");
        hashSet.add(news);
        Iterator<News> iterator = hashSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public static void exp9(){
        TreeSet<News> treeSet = new TreeSet<>();
        treeSet.add(new News(1,"title1"));
        treeSet.add(new News(0,"title0"));
        for(News news : treeSet){
            System.out.println(news);
        }
        Iterator<News> iterator = treeSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        TreeSet<News> treeSet1 = new TreeSet<>(new NewsComp());
        treeSet1.add(new News(1,"title1"));
        treeSet1.add(new News(4,"title4"));
        for(News news : treeSet1){
            System.out.println(news);
        }
    }

    public static void main(String[] args) {
        exp9();
    }
}
