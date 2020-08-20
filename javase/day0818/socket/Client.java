package com.javase.day0818.socket;

import com.tools.InputUtil;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.198.198", 8888);
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            while (true){
                String str = InputUtil.inputStr("");
                pw.write(str);
                pw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
