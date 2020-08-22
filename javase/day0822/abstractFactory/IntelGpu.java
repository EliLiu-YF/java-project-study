package com.javase.day0822.abstractFactory;

/**
 * 英特尔显卡
 */
public class IntelGpu extends GraphicsCard{
    @Override
    public void about() {
        System.out.println("intel 集显");
    }
}
