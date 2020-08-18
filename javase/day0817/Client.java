package com.javase.day0817;

import com.tools.InputUtil;

import java.io.*;
import java.net.Socket;

public class Client {
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
            Socket socket = new Socket("localhost",8088);
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            while(true){
//                char[] ch = new char[1024];
//                int len = isr.read(ch);
//                System.out.println(ch);
                char[] ch = new char[1024];
                int len = br.read(ch);
                System.out.println(ch);
                String data = InputUtil.inputStr("请输入你要发送的数据");
                pw.write(data);
                pw.flush();
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
        System.out.println("游戏结束");
    }
}
