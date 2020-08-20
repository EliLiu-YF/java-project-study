package com.javase.day0819.socket;

import javax.print.event.PrintEvent;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static void exp(){
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            while(true){
                Socket socket = serverSocket.accept();
                ReadThread readThread = new ReadThread(socket);
                readThread.start();
                WriteThread writeThread = new WriteThread(socket);
                writeThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        exp();
    }
}

class WriteThread extends Thread{
    Socket socket;

    public WriteThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.write("服务端");
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}

class ReadThread extends Thread{
    Socket socket;

    public ReadThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            while(true){
                char[] buf = new char[1024];
                int len = isr.read(buf);
                System.out.println(String.valueOf(buf,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

    }
}
