package com.javase.day0803;

public class MyList<E> {
    Object[] obj = new Object[5];

    int size;

    public void add(E o) {
        obj[size++] = o;
    }

    public E get(int index) {
        return (E) obj[index];
    }

    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();
        myList.add(new Integer(1));
        myList.add(new Integer(2));
        myList.add(new Integer(3));
        myList.add(new Integer(4));
        System.out.println(myList.get(0));
        MyList<Double> myList1 = new MyList<>();
        myList1.add(new Double(1.1));
        System.out.println(myList1.get(0));
    }
}
