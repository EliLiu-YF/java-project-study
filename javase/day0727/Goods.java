package com.javase.day0727;

import com.sun.jmx.snmp.SnmpNull;

import java.util.Scanner;

public class Goods {
    String name = "TOM";

    String pwd = "123";

    public boolean login(String name, String pwd){
        if (!(this.name.equals(name) && this.pwd.equals(pwd))){
            return false;
        }
        return true;
    }

    public void show() {
        System.out.println("************欢迎进入商品批发城**********");
        System.out.println("编号\t商品\t价格");
        System.out.println("1\t电风扇\t124.33");
        System.out.println("2\t洗衣机\t4,500.0");
        System.out.println("3\t电视机\t8,800.0");
        System.out.println("4\t冰箱 \t5,000.88");
        System.out.println("5\t空调机\t4,456.0");
        System.out.println("*************************************");
    }

    public StringBuffer change(int idNum, int sum) {
        double money = 0;
        switch (idNum) {
            case 1:
                money = 124.33 * sum;
                break;
            case 2:
                money = 4500.0 * sum;
                break;
            case 3:
                money = 8800.0 * sum;
                break;
            case 4:
                money = 5000.88 * sum;
                break;
            case 5:
                money = 4456.0 * sum;
                break;
        }
        StringBuffer stringBuffer = new StringBuffer(Double.toString(money));
        int floatIndex = stringBuffer.indexOf("."); //小数点的位置
        if (floatIndex < 4){
            return stringBuffer;
        }
        int index = floatIndex; //初始为小数点的位置
        while (true){
            stringBuffer.insert(index-3, ",");
            index = stringBuffer.indexOf(","); //赋值为第一个逗号的位置
            if (index < 4){
                return stringBuffer;
            }
        }
    }

    public static void main(String[] args) {
        Goods goods = new Goods();
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入用户名:");
        String name = sc.next();
        System.out.print("请输入密码:");
        String pwd = sc.next();
        if (goods.login(name, pwd)){
            System.out.println("登录成功");
            goods.show();
            System.out.print("请输入您批发的商品编号:");
            int num = sc.nextInt();
            System.out.print("请输入批发数量:");
            int sum = sc.nextInt();
            StringBuffer stringBuffer=goods.change(num, sum);
            System.out.println("你需要付款:"+stringBuffer.toString());
        }
    }
}
