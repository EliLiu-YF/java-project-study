package com.javase.day0730.old;

public class SoftwareEngineer extends Person implements IProgrammer, BizAgent {

    @Override
    public void biz() {
        System.out.println("谈业务");
    }

    @Override
    public void code() {
        System.out.println("写代码");

    }
}
