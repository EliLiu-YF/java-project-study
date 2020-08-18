package com.javase.day0729.printer;

public class BlackPrinter extends Printer{
    @Override
    public void print(String str) {
        System.out.println("黑白打印机:"+str);
    }
}
