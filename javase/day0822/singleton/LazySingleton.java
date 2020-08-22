package com.javase.day0822.singleton;

/**
 * 懒汉模式 线程不安全,懒加载
 * 懒汉模式同步锁
 * 懒汉模式双重校验锁
 */
public class LazySingleton {
    /**
     * 私有自身类的变量
     */
    private static LazySingleton lazySingleton = null;

    /**
     * 私有构造器,外部对该类实例化
     */
    private LazySingleton() {

    }

    /**
     * 懒汉模式双重校验锁
     * 线程安全 懒加载 多个线程同时访问获取的是同一个实例
     * 线程安全，避免了不必要的同步，但高并发环境下小概率会有DCL失效问题
     * @return
     */
    public static LazySingleton getInstance(){
        //当lazySingleton为 null时再启用同步锁
        if (null == lazySingleton){
            synchronized (LazySingleton.class){
                if(null == lazySingleton){
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }

    /**
     * 懒汉模式同步锁
     * 线程安全的 多个线程同时访问获取的是同一个实例
     * 会产生不必要的同步,影响性能
     * 例:在线程访问之前,实例以被初始化一次,但因为加了同步锁,获取该实例认需要线程排队
     * @return
     */
//    public static LazySingleton getInstance(){
//        synchronized (LazySingleton.class){
//            if (null == lazySingleton){
//                lazySingleton = new LazySingleton();
//            }
//        }
//        return lazySingleton;
//    }
    /**
     * 懒汉模式
     * 多个线程同时获取该类实例时会创建了多个实例对象,非线程安全
     */
//    public static LazySingleton getInstance() {
//        if (lazySingleton==null){
//            lazySingleton = new LazySingleton();
//        }
//        return lazySingleton;
//    }
}

class LazySingletonTest{
    public static void main(String[] args) {
//        LazySingleton instance1 = LazySingleton.getInstance();
//        LazySingleton instance2 = LazySingleton.getInstance();
//        //同一个实例,返回true
//        System.out.println(instance1==instance2);

        Thread thread1 = new Thread(){
            @Override
            public void run() {
                LazySingleton instance3 = LazySingleton.getInstance();
                System.out.println(instance3);
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                LazySingleton instance4 = LazySingleton.getInstance();
                System.out.println(instance4);
            }
        };
        thread1.start();
        thread2.start();
    }
}
