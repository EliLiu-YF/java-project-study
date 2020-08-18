package com.javase.day0729.printer;

public class ColorPrinter extends Printer{
    @Override
    public void print(String str) {
        System.out.println("彩色打印机:"+str);
    }
}
