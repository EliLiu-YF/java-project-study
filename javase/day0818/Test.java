package com.javase.day0818;

public class Test {
    static void exp2(){
        MyThread2 myThread2 = new MyThread2();
        Thread thread = new Thread(myThread2);
        thread.start();
    }
    public static void main(String[] args) {
//        for (int i = 0; i < 3; i++) {
//            MyThread myThread = new MyThread();
//            myThread.start();
//        }
        exp2();
        int i = 0;
        while(true){
            System.out.println(Thread.currentThread().getId()+","+i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
