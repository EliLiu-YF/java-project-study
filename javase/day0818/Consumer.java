package com.javase.day0818;

import java.util.List;

public class Consumer extends Thread{
    List<Integer> data;

    public Consumer(List<Integer> data){
        this.data = data;
    }

    @Override
    public void run() {
        while(true){
            synchronized (data){
                if (data.size() > 0 ){
                    for (int i = 0; i < data.size(); i++) {
                        System.out.println("消费者消费数据"+data.remove(0));
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
