package com.javase.day0806;

import com.javase.day0805.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class day0806 {
    /**
     * 字节流适合复制非文本文件
     * InputStream,FileInputStream,OutputStream,FileOutputStream
     * InputStream: 是将文件中的数据读取到byte数组中
     * OutputStream: 是将byte数组中的数据写入到文件中
     * <p>
     * 字符流存的是现实世界中的字符,所以打印输出时能看懂
     * Reader, FileReader, Write, FileWrite
     */

    static void exp() {
        Reader reader = null;
        try {
//            reader = new FileReader("bbb");
            char[] data = new char[10];
            int len = reader.read(data);
            while (-1 != len) {
                System.out.println(String.valueOf(data, 0, len));
                len = reader.read(data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static void exp2() {
        Writer writer = null;
        try {
//            writer = new FileWriter("bb", true);
            for (int i = 0; i < 3; i++) {
                writer.write("hello word" + i + "\n");
            }
            writer.flush();//立刻写入内容
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void exp3() {
        Reader reader = null;
        BufferedReader bufferedReader = null;
        try {
//            reader = new FileReader("bbb");
            bufferedReader = new BufferedReader(reader);
            String str = bufferedReader.readLine();
            while (null != str) {
                System.out.println(str);
                str = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 序列化:把java对象数据按某种格式写入到文件中
     * 反序列化: 将文件数据读取出来,转换成java对象
     *  加transient关键字可以让该字段不序列化进文件
     *     private transient int id;
     */

    static void exp4(){
        User user1 = new User("01", "aa", 87);
        User user2 = new User("02", "aa", 87);
        User user3 = new User("03", "aa", 87);
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        OutputStream outputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try{
//            outputStream = new FileOutputStream("User2.obj");
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(list);
            objectOutputStream.writeObject(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static void exp5(){
        InputStream inputStream = null;
        ObjectInputStream objectInputStream = null;
        try{
            inputStream = new FileInputStream("User2.obj");
            objectInputStream = new ObjectInputStream(inputStream);
            List<User> list = (List<User>) objectInputStream.readObject();
            List<User> list2 = (List<User>)objectInputStream.readObject();
            System.out.println(list);
            System.out.println(list2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    public static void main(String[] args) {
        exp4();
        exp5();
    }
}
