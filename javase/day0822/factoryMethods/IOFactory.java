package com.javase.day0822.factoryMethods;

/**
 * IO操作抽象工厂类
 */
public abstract class IOFactory {
    public abstract IOHandler getIOHandler();
}
