package com.javase.day0813;

public class MyThread3 implements Runnable {
    int i;

    @Override
    public void run() {
        while (true) {
            System.out.println(i++);
        }

    }
}
