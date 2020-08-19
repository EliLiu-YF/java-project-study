package com.javase.day0818.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread extends Thread{
    Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            isr = new InputStreamReader(socket.getInputStream());
            char[] buf = new char[1024];
            while (true){
                int len = isr.read(buf);//此时处于阻塞状态,等待客户端发送信息
                System.out.println(socket.getInetAddress().getHostAddress()+","+this.getId()+","
                        +String.valueOf(buf,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
//            return;
        }
    }
}
