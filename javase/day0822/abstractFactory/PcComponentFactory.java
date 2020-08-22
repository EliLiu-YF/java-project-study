package com.javase.day0822.abstractFactory;

/**
 * 电脑组件工厂
 */
public abstract class PcComponentFactory {
    public abstract Cpu getCpu();

    public abstract GraphicsCard getGpu();
}
