package com.javase.day0817;

import com.tools.InputUtil;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        //创建字节输入流
        InputStream is = null;
        //创建字节流变换为字符流桥梁
        InputStreamReader isr = null;
        //创建字符输入流
        BufferedReader br = null;
        //
        OutputStream os = null;
        PrintWriter pw = null;
        try {
            ServerSocket serverSocket = new ServerSocket(8088);
            Socket socket = serverSocket.accept();
            //获取字节输入流对象
            is = socket.getInputStream();
            //将字节输入流转为字符流
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            while(true){
                String data = InputUtil.inputStr("请输入你要发送的数据");
                pw.write(data);
                pw.flush();
                char[] ch = new char[1024];
                int len = br.read(ch);
                System.out.println(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
                isr.close();
                br.close();
                os.close();
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
