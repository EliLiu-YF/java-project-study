package com.javase.day0822.abstractFactory;

/**
 * amd显卡
 */
public class AmdGPU extends GraphicsCard{
    @Override
    public void about() {
        System.out.println("Amd 显卡 amd yes");
    }
}
