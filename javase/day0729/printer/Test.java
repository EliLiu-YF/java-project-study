package com.javase.day0729.printer;

public class Test {
    public static void main(String[] args) {
        Printer printer = new ColorPrinter();
        printer.print("第一单元测试卷");
        Printer printer1 = new BlackPrinter();
        printer1.print("第二单元测试卷");
    }
}
