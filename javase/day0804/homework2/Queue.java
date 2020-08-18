package com.javase.day0804.homework2;

import java.util.LinkedList;

public class Queue<E>{
    LinkedList<E>  linkedList = new LinkedList<>();

    private int size = 0;

    public int size(){
        return size;
    }

    public boolean add(E obj){
        linkedList.addFirst(obj);
        ++size;
        return true;
    }

    public E remove(){
        --size;
        return linkedList.removeLast();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < 5; i++) {
            queue.add(i);
        }
        System.out.println(queue.size());
        for (int i = 0; i < 5; i++) {
            System.out.println(queue.remove());
        }
    }
}
