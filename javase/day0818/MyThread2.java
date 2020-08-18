package com.javase.day0818;

public class MyThread2 implements Runnable{

    @Override
    public void run() {
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
