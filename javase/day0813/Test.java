package com.javase.day0813;

public class Test {
    public static void exp() {
        long i = 0;
        while (true) {

        }
    }

    static void exp2() {
        for (int i = 0; i < 10; i++) {
            MyThread myThread = new MyThread();
            myThread.start();
        }

    }

    public static void main(String[] args) {
        exp2();
        int i = 0;
        while (true) {
//            Thread.currentThread() 当前执行的线程 mian方法主线程
            System.out.println(Thread.currentThread().getId() + "," + i++);
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
