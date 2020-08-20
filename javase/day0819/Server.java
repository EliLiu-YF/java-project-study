package com.javase.day0819;

import sun.reflect.generics.scope.Scope;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static void exp(){
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            while (true){
                Socket socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
                ServerWrite serverWrite = new ServerWrite(socket);
                serverWrite.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        exp();
    }
}

class ServerWrite extends Thread{
    Socket socket;

    public ServerWrite(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.write("客户端信息");
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ServerThread extends Thread{
    Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            char[] buf = new char[1024];
            int len = isr.read(buf);
            System.out.println(socket.getInetAddress().getHostAddress()+","+String.valueOf(buf,0,len));
        } catch (IOException e) {
            e.printStackTrace();
            return;//当客户端结束运行退出该线程
        }
    }
}
