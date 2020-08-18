package com.javase.day0818;

public class MyThread extends Thread{
    @Override
    public void run() {
        int i = 0;
        while(true){
            System.out.println(this.getId()+","+i++);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
