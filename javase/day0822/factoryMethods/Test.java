package com.javase.day0822.factoryMethods;

/**
 * 工厂方法模式
 *
 * 抽象产品类：需要创建的产品的抽象类。
 * 具体产品类：为实现抽象产品的某个具体产品类。
 * 抽象工厂类：工厂模式方法核心，返回一个 抽象产品类 类型的对象。
 * 具体工厂类：实现具体业务逻辑，返回 具体产品类 实例
 */
public class Test {
    public static void main(String[] args) {
        //得到json文件操作工厂
        IOFactory factory = new JsonFactory();
        //通过json文件操作工厂获取json文件操作对象
        IOHandler handler = factory.getIOHandler();
    }
}
