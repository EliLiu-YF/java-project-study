package com.javase.day0804;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class ArrayListTest {
    public static void exp() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(1);
        System.out.println(arrayList.contains(new Integer(1)));
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("1");
        System.out.println(arrayList1.contains(new String("1")));
        ArrayList<User> arrayList2 = new ArrayList<>();
        arrayList2.add(new User("01"));
        System.out.println(arrayList2.contains(new User("01")));
    }

    public static void exp2() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(1);
        arrayList.add(3);
        Collections.sort(arrayList);
        for (Integer val : arrayList) {
            System.out.println(val);
        }
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("1");
        arrayList1.add("0");
        Collections.sort(arrayList1);
        for (String str : arrayList1) {
            System.out.println(str);
        }
        ArrayList<User> arrayList2 = new ArrayList<>();
        arrayList2.add(new User("02"));
        arrayList2.add(new User("01"));
//        Collections.sort(arrayList2);
        for (User user : arrayList2) {
            System.out.println(user.getId());
        }
    }

    public static void exp3() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "01");
        map.put(2, "02");
        map.put(3, "03");
        Set<Integer> keySet = map.keySet();
        Iterator<Integer> ketIterator = keySet.iterator();
        while (ketIterator.hasNext()) {
            int key = ketIterator.next();
            String value = map.get(key);
            System.out.println("key:" + key + ", value:" + value);
        }
        map.put(4, "04");
        map.put(5, "05");
        Set<Integer> set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            int key = iterator.next();
            String value = map.get(key);
            System.out.println(key + ":" + value);
        }

    }

    public static void exp4() {
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("01", "11");
        hashtable.put("02", "22");
        hashtable.put("03", "33");
        hashtable.put("06", "66");
        hashtable.put("05", "55");
        hashtable.put("04", "44");
        Set<String> setKet = hashtable.keySet();
        Iterator<String> iterator = setKet.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            String val = hashtable.get(key);
            System.out.println("key:" + key + ", val:" + val);
        }
        Set<Map.Entry<String, String>> entrySet = hashtable.entrySet();
        Iterator<Map.Entry<String, String>> entryIterator = entrySet.iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, String> entry = entryIterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    public static void exp5() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "01");
        map.put(2, "02");
        map.put(3, "03");
        System.out.println(map.remove(1));
        System.out.println(map.remove(1));
        System.out.println(map.remove(2, "02"));
    }

    public static void exp6() {
//        TreeMap<User, String> treeMap = new TreeMap<>(new Comparator<User>() {
//            @Override
//            public int compare(User o1, User o2) {
//                return o1.getId().compareTo(o2.getId());
//            }
//        });
        TreeMap<User, String> treeMap = new TreeMap<>((o1, o2) -> o1.getId().compareTo(o2.getId()));
        treeMap.put(new User("01"), "01");
        treeMap.put(new User("03"), "03");
        treeMap.put(new User("02"), "02");
        Set<Map.Entry<User, String>> entrySet = treeMap.entrySet();
        Iterator<Map.Entry<User, String>> entryIterator = entrySet.iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<User, String> entry = entryIterator.next();
            System.out.println(entry.getKey().getId() + ":" + entry.getValue());
        }
    }

    public static void exp7() {
//        Comparator<User> comparator = new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                return 0;
//            }
//        };
        MathOperation mathOperation = new MathOperation() {
            @Override
            public int op(int a, int b) {
                return a + b;
            }
        };
        System.out.println(mathOperation.op(1, 2));
        MathOperation mathOperation1 = new MathOperation() {
            @Override
            public int op(int a, int b) {
                return a + b;
            }
        };
        System.out.println(mathOperation1.op(2, 3));
        //lambda表达式,只适合一个抽象方法的接口
        MathOperation mathOperation2 = (int a, int b) -> a + b;
        MathOperation mathOperation3 = (a, b) -> a + b;
        System.out.println(mathOperation2.op(10, 10));
        System.out.println(mathOperation3.op(10, 30));
    }

    public static void exp8() {
        Random random = new Random();
        char[] cArr = new char[1000];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            char c = (char) (random.nextInt(123 - 97) + 97);
            cArr[i] = c;
        }
        for (int i = 0; i < cArr.length; i++) {
            char key = cArr[i];
            if (map.containsKey(key)) {
                int val = map.get(key);
                map.put(key, ++val);
                continue;
            }
            map.put(key, 1);
        }
        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<Character, Integer>> entryIterator = entrySet.iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<Character, Integer> entry = entryIterator.next();
            System.out.println(entry.getKey() + "=>" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        exp8();
    }

    interface MathOperation {
        int op(int a, int b);
    }
}
