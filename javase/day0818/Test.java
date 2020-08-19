package com.javase.day0818;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    static void exp2() {
        MyThread2 myThread2 = new MyThread2();
        Thread thread = new Thread(myThread2);
        thread.start();
    }

    static void exp3() {
        Tickets tickets = new Tickets();
        for (int i = 0; i < 3; i++) {
            SaleTicketsThread saleTicketsThread = new SaleTicketsThread(tickets);
            saleTicketsThread.start();
        }
    }

    static void exp4() {
        MyThread3 myThread3 = new MyThread3();
        myThread3.start();
//        try {
//            myThread3.join();//等myThread3线程结束后,后面的代码才会执行
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getId() + "," + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static void exp5() {
        MyThread4 myThread4 = new MyThread4();
        Thread thread = new Thread(myThread4);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {

        }
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getId()+","+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static void exp6(){
        List<Integer> data = new ArrayList<>(100);
        for (int i = 0; i < 10; i++) {
            Producer producter = new Producer(data);
            producter.start();
        }
    }

    static void exp7(){
        List<Integer> data = new ArrayList<>();
        Producer producer = new Producer(data);
        Consumer consumer = new Consumer(data);
        producer.start();
        consumer.start();
    }

    static void exp8(){
//        创建一个线程池,该线程池内同时只能运行5个线程
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100; i++) {
//            Runnable runnable = new Runnable() {
//                @Override
//                public void run() {
//                    while(true){
//                        System.out.println(Thread.currentThread().getId()+"正在运行");
//                        try {
//                            Thread.sleep(3000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            };
            //将线程对象交给线程池管理,线程池中有50个线程对象
//            executorService.execute(runnable);
            executorService.execute(() -> {
                while(true){
                        System.out.println(Thread.currentThread().getId()+"正在运行");
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            });
        }


    }

    public static void main(String[] args) {
//        for (int i = 0; i < 3; i++) {
//            MyThread myThread = new MyThread();
//            myThread.start();
//        }
//        exp2();
//        int i = 0;
//        while(true){
//            System.out.println(Thread.currentThread().getId()+","+i++);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        exp8();
    }
}
