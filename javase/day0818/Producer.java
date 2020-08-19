package com.javase.day0818;

import java.util.List;

/**
 * 生产者 生产数据
 * 消费者 消费数据
 */
public class Producer extends Thread{
    List<Integer> data;

    public Producer(List<Integer> data){
        this.data = data;
    }

    @Override
    public void run() {
        while (true){
            synchronized (data){
               if (data.size() <= 0){
                   for (int i = 0; i <5 ; i++) {
                       data.add(new Integer(i));
                       System.out.println("生产者生产数据"+i);
                       try {
                           sleep(500);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
               }else {
                   data.notify();
                   try {
                       data.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            }
        }
    }
}
