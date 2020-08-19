package com.javase.day0818;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static void exp1() {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            System.out.println(socket.getInetAddress().getHostAddress());
            //发送数据 创建字节输出流
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("我是服务端");
            pw.flush();
            //读取数据 创建字节输入流
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            char[] ch = new char[1024];
            int len = isr.read(ch);
            System.out.println(String.valueOf(ch,0,len));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        exp1();
    }
}
