package com.javase.day0818.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            while(true){
               Socket socket = serverSocket.accept();//此时处于阻塞状态,登台等待新的客户端连接,但之前连接的客户端任在独立的线程中执行
               ServerThread serverThread = new ServerThread(socket);
               serverThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
