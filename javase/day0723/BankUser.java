package com.javase.day0723;

import com.tools.InputUtil;

public class BankUser {
    double money = 1000;

    public boolean deposits(int depMoney) {
        if (depMoney <= 0) {
            return false;
        }
        money += depMoney;
        return true;
    }

    public boolean withdrawMoney(int witMoney) {
        if (witMoney <= 0 || witMoney > money) {
            return false;
        }
        money -= witMoney;
        return true;
    }

    public static void main(String[] args) {
        BankUser bankUser = new BankUser();
        System.out.println("1.存款\t2.取款\t3.退出");
        int num = InputUtil.inputInt("请选择你要办理的业务");
        switch (num) {
            case 1:
                int deMoney = InputUtil.inputInt("请输入存款金额");
                if (bankUser.deposits(deMoney)) {
                    System.out.println("存款成功");
                    System.out.println("当前余额:" + bankUser.money);
                } else {
                    System.out.println("存款失败");
                }
                break;
            case 2:
                int WiMoney = InputUtil.inputInt("请输入取款金额");
                if (bankUser.withdrawMoney(WiMoney)) {
                    System.out.println("取款成功");
                    System.out.println("*************当前余额" + bankUser.money + "元***********");
                } else {
                    System.out.println("取款失败");
                }
                break;
            case 3:
                System.out.println("谢谢使用");
                break;
        }
    }
}
