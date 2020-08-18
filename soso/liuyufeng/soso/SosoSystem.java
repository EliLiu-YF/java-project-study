package com.soso.liuyufeng.soso;

import com.tools.InputUtil;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;


public class SosoSystem {

    CardUtil cardUtil = new CardUtil();

    /**
     * 序列化Cards保存至本地
     */
    public void writeCards(){
        OutputStream outputStream = null;
        ObjectOutputStream objectOutputStream = null;
        Writer writer = null;
        BufferedWriter bufferedWriter = null;
        try{
            outputStream = new FileOutputStream("liuyufeng_cards.log");
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(cardUtil.cards);
            objectOutputStream.flush();
            writer = new FileWriter("liuyufeng_cards.txt");
            bufferedWriter = new BufferedWriter(writer);
            ArrayList<MobileCard> arrayList = new ArrayList<>(cardUtil.cards.values());
            for (MobileCard mobileCard : arrayList){
                bufferedWriter.write(mobileCard.getCardNumber()+"  "+mobileCard.getUserName()+"\n");
            }
            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 序列化消费详情至本地
     */
    public void writeConsumInfo(){
        OutputStream outputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            outputStream = new FileOutputStream("liuyufeng_consumInfo.log");
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(cardUtil.consumInfos);
            objectOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void changePackageView(String number){
        System.out.println("***套餐变更***");
        String num;
        do {
            num = InputUtil.inputStr("1.话痨套餐, 2.网虫套餐, 3.超人套餐 请选择(序号)");
            if (num.equals("1") || num.equals("2") || num.equals("3")){
                break;
            }
            System.out.println("请输入正确的序号!");
        }while (true);
        try {
            cardUtil.changeingPack(number, num);
            System.out.println("套餐更改成功!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * 用户菜单
     * @param number 用户账号
     */
    public void userMenuView(String number){
        System.out.println("******SOSO移动用户菜单******");
        System.out.println("1.本月账单查询");
        System.out.println("2.套餐余量查询");
        System.out.println("3.打印消费详单");
        System.out.println("4.套餐变更");
        System.out.println("5.办理退网");
        int fin = InputUtil.inputInt("请选择(输入1-5选择功能,其他键返回上一级)");
        switch (fin){
            case 1:
                System.out.println("***本月账单查询***");
                cardUtil.showAmountDetail(number);
                userMenuView(number);
                break;
            case 2:
                System.out.println("***套餐余量***");
                cardUtil.showRemainDetail(number);
                userMenuView(number);
                break;
            case 3:
                System.out.println("消费详单已打印");
                cardUtil.showConsumInfo(number);
                userMenuView(number);
                break;
            case 4:
                changePackageView(number);
                userMenuView(number);
                break;
            case 5:
                System.out.println("退网");
                cardUtil.delCard(number);
                System.out.println("卡号"+number+"办理退网成功!");
                System.out.println("谢谢使用");
                mainView();
                break;
            default:
                mainView();
                break;
        }

    }

    /**
     * 注册界面
     */
    public void registerView(){
        String[] numbers = cardUtil.getNewNumber(9);
        MobileCard card = new MobileCard();
        int fin = 0;
        String number = null;
        do {
            System.out.println("******可选择的卡号*****");
            for (int i = 0; i < numbers.length; i++) {
                System.out.print(i+1+"."+numbers[i]+"\t");
                if (i%3 == 2){
                    System.out.println();
                }
            }
            fin = InputUtil.inputInt("请选择卡号(输入1-9的序号)");
            if (!(fin >= 1 && fin <= 9)) {
                System.out.println("规范输入!");
                registerView();
            }
            number = numbers[fin - 1];
            if (cardUtil.isExistCard(number)){
                System.out.println("该账号已存在");
                continue;
            }
            break;
        }while (true);
        card.setCardNumber(number);
        System.out.println("1.话痨套餐\t2.网虫套餐3.\t超人套餐");
        fin = InputUtil.inputInt("请选择套餐(输入序号)");
        switch (fin){
            case 1:
                TalkPackage talkPackage = new TalkPackage();
                card.setSerPackage(talkPackage);
                break;
            case 2:
                NetPackage netPackage = new NetPackage();
                card.setSerPackage(netPackage);
                break;
            case 3:
                SuperPackage superPackage = new SuperPackage();
                card.setSerPackage(superPackage);
                break;
            default:
                System.out.println("请规范输入!");
                System.exit(0);
        }
        String name = InputUtil.inputStr("输入姓名");
        card.setUserName(name);
        String pwd = InputUtil.inputStr("输入密码");
        double talkMoney = InputUtil.inputInt("输入预存话费金额");
        card.setPassWord(pwd);
        do {
            if (talkMoney < card.getSerPackage().getPrice()){
                talkMoney = InputUtil.inputInt("你预存的话费不足以支付本月固定套餐资费,请重新充值");
                continue;
            }
            break;
        }while (true);
        card.setConsumAmount(card.getSerPackage().getPrice());
        card.setMoney(talkMoney - card.getSerPackage().getPrice());
        try {
            cardUtil.addCard(card);
            System.out.println("注册成功! 卡号: " + card.getCardNumber()+", 用户名: "+card.getUserName()
                    +", 当前余额: "+card.getMoney());
            card.getSerPackage().showInfo();
            mainView();
        }catch (Exception e){
            e.printStackTrace();
        }
        mainView();
    }

    /**
     * 使用soso页面
     */
    public void useSOSO(){
        String number = InputUtil.inputStr("请输入手机号");
        try{
            cardUtil.useSoso(number);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            mainView();
        }

    }

    /**
     * 登录界面
     */
    public void login(){
        String number;
        String password;
        do {
            number = InputUtil.inputStr("请输入卡号(0退出登录)");
            if (number.equals("0")){
                mainView();
            }
            password = InputUtil.inputStr("请输入密码");
            if (!cardUtil.isExistCard(number)){
                System.out.println("不存在该用户!");
                continue;
            }
            if (!cardUtil.isExistCard(number, password)){
                System.out.println("密码错误!");
                continue;
            }
            System.out.println("登录成功!");
            break;
        }while(true);
        userMenuView(number);
    }

    public void changeMoneyView(){
        System.out.println("***话费充值***");
        String number = InputUtil.inputStr("请输入充值卡号");
        double money = InputUtil.inputInt("请输入充值金额");
        try {
            DecimalFormat format = new DecimalFormat("0.0");
            double getMoney = cardUtil.changeMoney(number, money);
            System.out.println("充值成功,当前话费余额为"+format.format(getMoney)+"元");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 系统主页面
     */
    public void mainView(){
        System.out.println("***************欢迎使用移动SOSO大厅**************");
        System.out.println("1.用户登录\t2.用户注册\t3.使用SOSO\t4.话费充值\t5.资费说明\t6.退出系统");
        int fin = InputUtil.inputInt("请选择");
        switch (fin){
            case 1:
                login();
                break;
            case 2:
                registerView();
                break;
            case 3:
                useSOSO();
                break;
            case 4:
                changeMoneyView();
                mainView();
                break;
            case 5:
                cardUtil.showDescription();
                mainView();
                break;
            case 6:
                System.out.println("退出系统...");
                writeCards();
                writeConsumInfo();
                System.exit(0);
                break;
            default:
                System.out.println("请规范输入!");
                mainView();
                break;
        }
    }
    public static void main(String[] args) {

        SosoSystem sosoSystem = new SosoSystem();
        sosoSystem.cardUtil.initScene();
        sosoSystem.mainView();
    }
}
