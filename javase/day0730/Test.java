package com.javase.day0730;

import java.util.InputMismatchException;
import java.util.Random;

/**
 * 空指针异常
 */
public class Test {
    public static void exp() {

        try {
            Random random = null;
            random.nextInt(10);
        } catch (InputMismatchException e) {
            e.printStackTrace(); //打印异常堆栈信息
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 算数错误异常
     */
    public static void exp2() {
        try {
            int a = 2 / 0;
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    /**
     * 数组下标越界异常
     */
    public static void exp3() {
        try {
            int[] arr = new int[1];
            arr[1] = 2;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("数组下标越界异常");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 数字格式转化异常
     */
    public static void exp4() {

        try {
            String str = "10aa";
            int a = Integer.parseInt(str);
            System.out.println(a);
            return;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("数字格式转化异常");
            return;
        } finally {
            System.out.println("finally");
        }
    }

    /**
     * 声明异常
     *
     * @param
     */
    public static void exp5() throws ArithmeticException {
        int a = 10 / 0;
        System.out.println("aaaaaa");
    }

    /**
     * 手动抛出异常
     *
     * @param
     */
    public static void exp6(String sex) throws Exception {
        if (sex.equals("男") && sex.equals("女")) {

        } else {
            System.out.println("性别只能是男或女");
            throw new Exception();
        }
    }

    public static void main(String[] args) {
//        try {
//            exp5();
//        } catch (ArithmeticException e) {
//            e.printStackTrace();
//        }
        try {
            exp6("hehihei");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("异常之后的代码");
    }
}
