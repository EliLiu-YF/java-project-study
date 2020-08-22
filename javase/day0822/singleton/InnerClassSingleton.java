package com.javase.day0822.singleton;

/**
 * 静态内部类模式
 * 懒加载 线程安全
 * 推荐使用
 * 为什么会线程安全？类的构造器<clinit>()方法在多线程环境中被正确地加载，同步，如果多个线程同时去初始化一个类，
 * 那么只有一个线程去执行这个类的，其他线程都需要阻塞等待，直到活动线程执行<clinit>（）方法完毕
 *
 */
public class InnerClassSingleton {

    private InnerClassSingleton(){}

    public static InnerClassSingleton getInstance(){
        return InnerClassSingletonHolder.instance;
    }

    private static class InnerClassSingletonHolder{
        public static InnerClassSingleton instance = new InnerClassSingleton();
    }
}

class InnerClassSingletonTest{
    public static void main(String[] args) {
//        InnerClassSingleton instance1 = InnerClassSingleton.getInstance();
//        InnerClassSingleton instance2 = InnerClassSingleton.getInstance();
//        System.out.println(instance1 == instance2);

        Thread thread1 = new Thread(){
            @Override
            public void run() {
                InnerClassSingleton instance3 = InnerClassSingleton.getInstance();
                System.out.println(instance3);
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                InnerClassSingleton instance4 = InnerClassSingleton.getInstance();
                System.out.println(instance4);
            }
        };
        thread1.start();
        thread2.start();
    }
}
