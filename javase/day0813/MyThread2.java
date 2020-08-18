package com.javase.day0813;

public class MyThread2 extends Thread {
    int i;

    @Override
    public void run() {
        while (true) {
            System.out.println(this.getId() + "," + i++);
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
