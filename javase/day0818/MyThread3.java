package com.javase.day0818;

public class MyThread3 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <10000 ; i++) {
            System.out.println(this.getId()+","+i);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.interrupt();
        }
    }
}
