package com.javase.day0822.abstractFactory;

/**
 * 因特尔电脑组件工厂类
 */
public class IntelPcComponentFactory extends PcComponentFactory{
    @Override
    public Cpu getCpu() {
        return new IntelCpu();
    }

    @Override
    public GraphicsCard getGpu() {
        return new IntelGpu();
    }
}
