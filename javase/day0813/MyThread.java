package com.javase.day0813;

public class MyThread extends Thread {
    int i;

    //Thread,getId() 获得的是线程的ID编号
    @Override
    public void run() {
        while (true) {
            System.out.println(this.getId() + "," + i++);
//            try {
//                sleep(1); //让当前程序睡眠1毫秒, 1000毫秒等于1秒
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
