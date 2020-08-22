package com.javase.day0822.abstractFactory;

/**
 * Amd电脑组件工厂类
 */
public class AmdPcComponentFactory extends PcComponentFactory{
    @Override
    public Cpu getCpu() {
        return new AmdCpu();
    }

    @Override
    public GraphicsCard getGpu() {
        return new AmdGPU();
    }
}
