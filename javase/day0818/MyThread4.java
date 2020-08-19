package com.javase.day0818;

public class MyThread4 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <1000 ; i++) {
            System.out.println(Thread.currentThread().getId()+","+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
