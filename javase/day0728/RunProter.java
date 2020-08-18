package com.javase.day0728;


public class RunProter extends Person{
    //实施年限
    private int implementationPeriod;

    public int getImplementationPeriod() {
        return implementationPeriod;
    }

    public void setImplementationPeriod(int implementationPeriod) {
        this.implementationPeriod = implementationPeriod;
    }

    public void print(){
        System.out.println("部署项目");
    }
}
