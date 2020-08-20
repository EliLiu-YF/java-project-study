package com.javase.day0819;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class Client {
    static void exp() {
        for (int i = 0; i < 10; i++) {
            try {
                Socket socket = new Socket("localhost",8888);
                ClientThread clientThread = new ClientThread(socket);
                clientThread.start();
                ClientRead clientRead = new ClientRead(socket);
                clientRead.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        exp();
    }
}

class ClientRead extends Thread{
    Socket socket;

    public ClientRead(Socket socket) {
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


class ClientThread extends Thread {
    Socket socket;

    public ClientThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.write(exp());
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String exp(){
        Random random = new Random();
        String str = "";
        for (int i = 0; i < 10; i++) {
            int c = random.nextInt(10);
            str+=c;
        }
        return str;
    }
}
