package com.javase.day0819.socket;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    static void exp(){
        try {
            //模拟10个客户端
            for (int i = 0; i < 10; i++) {
                Socket socket = new Socket("localhost",8888);
                ClientWriteThread writeThread = new ClientWriteThread(socket);
                writeThread.start();
                ClientReadThread readThread = new ClientReadThread(socket);
                readThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        exp();
    }
}

class ClientReadThread extends Thread{
    Socket socket;

    public ClientReadThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            char[] buf = new char[1024];
            int len = isr.read(buf);
            System.out.println(String.valueOf(buf,0,len));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientWriteThread extends Thread{
    Socket socket;

    public ClientWriteThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.write("客户端"+this.getId());
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
