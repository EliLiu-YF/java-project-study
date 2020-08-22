package com.javase.day0822.singleton;

/**
 *饿汉模式
 *线程安全 没有懒加载
 *类字节码加载就完成分配内存空间,浪费内存
 */
public class HungerSingleton {
    //定义变量完成初始化
    private static HungerSingleton instance = new HungerSingleton();

    //构造器私有化
    private HungerSingleton(){

    }

    public static HungerSingleton getInstance(){
        return instance;
    }
}

class HungerSingletonTest{
    public static void main(String[] args) {
//        HungerSingleton instance1 = HungerSingleton.getInstance();
//        HungerSingleton instance2 = HungerSingleton.getInstance();
//        //指向同一个实例,返回true
//        System.out.println(instance1==instance2);

        //多线程访问下,得到的仍是同一个实例
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                HungerSingleton instance3 = HungerSingleton.getInstance();
                System.out.println(instance3);
            }
        };

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                HungerSingleton instance4 = HungerSingleton.getInstance();
                System.out.println(instance4);
            }
        };
        thread1.start();
        thread2.start();
    }
}
