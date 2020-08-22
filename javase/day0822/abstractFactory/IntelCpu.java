package com.javase.day0822.abstractFactory;

/**
 * 英特尔CPU
 */
public class IntelCpu extends Cpu {
    @Override
    public void about() {
        System.out.println("因特尔cpu");
    }
}
