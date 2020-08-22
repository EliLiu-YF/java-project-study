package com.javase.day0822.abstractFactory;

/**
 * 抽象工厂模式 生成一组对象
 */
public class Test {
    public static void main(String[] args) {
        PcComponentFactory factory =new AmdPcComponentFactory();
        Cpu cpu = factory.getCpu();
        GraphicsCard gpu = factory.getGpu();
        cpu.about();;
        gpu.about();
    }
}
