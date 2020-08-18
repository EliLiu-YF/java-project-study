package com.javase.day0804.homework1;

import java.util.*;

public class UserMngr {
    TreeMap<String, User> userTreeMap = null;

    public UserMngr(TreeMap<String, User> userTreeMap) {
        this.userTreeMap = userTreeMap;
    }

    public UserMngr() {
    }

//    class ValueComp{
//        Map<String, User>
//    }

    public static void main(String[] args) {
        UserMngr userMngr = new UserMngr();
//        userMngr.userTreeMap = new TreeMap<>();
//        User user = new User("01","小明" ,20,90);
//        User user2 = new User("02","小红" ,19,70);
//        User user3 = new User("03","小华" ,21,80);
//        userMngr.userTreeMap.put(user.getId(),user);
//        userMngr.userTreeMap.put(user2.getId(),user2);
//        userMngr.userTreeMap.put(user3.getId(),user3);
//        Set<Map.Entry<String, User>> entrySet = userMngr.userTreeMap.entrySet();
//        Iterator<Map.Entry<String,User>> entryIterator = entrySet.iterator();
//        while(entryIterator.hasNext()){
//            Map.Entry<String, User> entry = entryIterator.next();
//            System.out.println(entry.getKey()+"->"+ entry.getValue());
//        }
        System.out.println("******************************************");
//        Map<String, User> map = new HashMap<>();
//        ValueComp valueComp = new ValueComp(map);
//        userMngr.userTreeMap = new TreeMap<>(valueComp);
//        User user = new User("01","小明" ,20,90);
//        User user2 = new User("02","小红" ,19,70);
//        User user3 = new User("03","小华" ,21,80);
////        map.put(user.getId(),user);
////        map.put(user2.getId(),user2);
////        map.put(user3.getId(),user3);
////        System.out.println(map);
////        userMngr.userTreeMap.putAll(map);
////        System.out.println(userMngr.userTreeMap);
//        userMngr.userTreeMap.put(user.getId(),user);
//        userMngr.userTreeMap.put(user2.getId(),user2);
//        userMngr.userTreeMap.put(user3.getId(),user3);
        System.out.println("***********************************************");
        userMngr.userTreeMap = new TreeMap<>();
        User user = new User("01","小明" ,20,90);
        User user2 = new User("02","小红" ,19,70);
        User user3 = new User("03","小华" ,21,80);
        userMngr.userTreeMap.put(user.getId(),user);
        userMngr.userTreeMap.put(user2.getId(),user2);
        userMngr.userTreeMap.put(user3.getId(),user3);
        Collection<User> users = userMngr.userTreeMap.values();
        List<User> list = new ArrayList<>();
        list.addAll(users);
        Collections.sort(list,(a,b) -> b.getScore() - a.getScore());
        System.out.println(list);

    }
}
