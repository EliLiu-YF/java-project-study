package com.javase.day0805;


import java.io.*;
import java.util.Arrays;

public class Test {
    public static void exp() {
        //读取文件,支持任意文件的格式
        try {
            InputStream input = new FileInputStream("D:/a6.jpg");
            int d = input.read();//返回流中下一个字节数 取值0-255,-1读取失败 数据读取结束
            int bytes = 0;
            while (-1 != d) {
                d = input.read();
                ++bytes;
            }
            System.out.println("字节数:" + bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void exp2() {
        try {
            InputStream inputStream = new FileInputStream("D:/a6.jpg");
            byte[] data = new byte[1024];
            int size = 0;
            /**一次读取多个数据到data数组中
             * 最多读取 数组.length 个字节数,返回实际读取到的字节数
             * 返回-1 表示读到最后,无数据可读
             *
             * */
            int len = inputStream.read(data);
            while (-1 != len) {
                size += len;
                len = inputStream.read(data);
            }
            System.out.println(size);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void exp3() {
        try {
            byte[] data = new byte[1024];
            InputStream inputStream = new FileInputStream("D:/a6.jpg");
            System.out.println(Arrays.toString(data));
            int len = inputStream.read(data, 0, 10);
            System.out.println(Arrays.toString(data));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * File类是对一个文件或文件夹的抽象表示
     * 一个file表示一个文件或文件夹
     * <p>
     * isFile() 判断是否是文件
     * isDirectory() 判断是否为文件夹
     * exists() 判断文件是否存在
     * getAbsolutePath() 获取文件绝对路径
     */
    public static void exp4() {
        File file = new File("D:/a6.jpg");
        System.out.println(file.isFile());
        if (file.exists()) {
            file.delete();
        }
        File file1 = new File("aaa.txt");
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.exists());
        if (file1.exists()) {
            file1.delete();
        }
//        File file3 = new File("aaa.txt");
//        file3.mkdir();
//        File file4 = new File("aaa.txt/a.txt");
//        try {
//            file4.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        System.out.println("**********************");
        File file2 = new File("D:/sc20200601_project/html/html/img");
        File[] files = file2.listFiles();
        for (File fil : files) {
            if (fil.isFile()) {
                System.out.println("文件:" + fil.getName());
            } else {
                System.out.println("文件夹:" + fil.getName());
            }
        }
    }

    public static void printDirectory(File file) {
        File[] files = file.listFiles();
        for (File fil : files) {
            if (fil.isDirectory()) {
                System.out.println("文件夹名:" + fil.getName());
                printDirectory(fil);
            } else {
                System.out.println(fil.getName());
            }
        }
    }

    static void exp5() {
        File file = new File("D:/sc20200601_project/html/html/img/b.jpg");
        try {
            InputStream inputStream = new FileInputStream(file);
            OutputStream outputStream = new FileOutputStream(new File("D:/copyB.jpg"));
            byte[] data = new byte[1024];
            int len = inputStream.read(data);
            while (-1 != len) {
                outputStream.write(data, 0, len);
                len = inputStream.read(data);
            }
            inputStream.close();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字符流
     */
    static void exp6(){
        try {
            Reader reader = new FileReader("aa.txt");
            char[] chars = new char[100];
            int len = reader.read(chars);
            while(-1 != len){
                System.out.println(chars);
                len = reader.read(chars);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void exp7(){
        char[] chars = new char[10];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = 'q';
        }
        System.out.println(chars);
        double[] doubles = new double[5];
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = '1';
        }
        System.out.println(doubles);
        String str=new String();
        str = "qqq";
    }

    public static void main(String[] args) {
//        printDirectory(new File("D:/sc20200601_project/html/html/img"));
        exp7();
    }
}
