package com.javase.day0803;

import java.util.*;

public class User{
    private Integer id;

    private String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static void exp2() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(new Integer(2));
        linkedList.add(new Integer(3));
        linkedList.addFirst(new Integer(0));
        linkedList.addLast(new Integer(10));
        linkedList.addAll(linkedList);
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * Vector与LinkedList用法类似,Vector是线程安全的,有排队机制
     */
    public static void exp3() {
        Vector<Integer> vector = new Vector<>();
        vector.add(new Integer(1));
        vector.add(new Integer(3));
        Iterator<Integer> iterator = vector.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * HashSet中储存的元素是惟一的不可重复的
     */
    public static void exp4() {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(new Integer(0));
        hashSet.add(new Integer(0));
        hashSet.add(new Integer(0));
        hashSet.add(new Integer(0));
        Iterator<Integer> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        HashSet<User> userHashSet = new HashSet<>();
        User user = new User(new Integer(1), "aa");
        User user1 = new User(new Integer(2), "aa");
        userHashSet.add(user);
        userHashSet.add(user);
        userHashSet.add(user);
        userHashSet.add(user1);
        user.setId(3);
        userHashSet.add(user);
        Iterator<User> iterator1 = userHashSet.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
    }

    public static void exp5(){
        TreeSet<User> treeSet = new TreeSet<>(new UserComp());
        User user = new User(1,"a");
        User user1 = new User(2,"b");
        User user2 = new User(3,"c");
        treeSet.add(user);
        treeSet.add(user1);
        treeSet.add(user2);
        System.out.println(treeSet);

    }

    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(new Integer(1));
//        list.add(new Integer(2));
//        list.add(new Integer(3));
//        list.add(new Integer(4));
//        Iterator<Integer> iterator = list.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//        Iterator<Integer> iterator1 = list.iterator();
//        while(iterator1.hasNext()){
//            System.out.println(iterator1.next());
//        }
        exp5();
    }
}
