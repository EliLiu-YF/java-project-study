package com.javase.day0818;

import java.io.*;
import java.net.Socket;

public class Client {
    static void exp1() {
        try {
            Socket socket = new Socket("192.168.198.198", 8888);
            //读取数据 创建字节输入流
//            InputStream is = socket.getInputStream();
//            InputStreamReader isr = new InputStreamReader(is);
//            char[] ch = new char[1024];
//            int len = isr.read(ch);
//            System.out.println(String.valueOf(ch ,0 ,len));
            //发送数据 创建字节输出流
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("我是客户端");
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        exp1();
    }
}
