package com.javase.day0822.simpleFactory;

/**
 * 简单工厂模式
 * 例:根据不同用户等级进行结算 优化 if else
 */
public class PayTest {
    public static void main(String[] args) {
        //原始代码
        //当增加用户类型时需要对选择语句进行添加,选择太多不好维护
//        String accountType = "common";
//        switch (accountType){
//            case "common":
//                System.out.println("普通用户结算");
//                break;
//            case "vip":
//                System.out.println("vip用户结算");
//                break;
//            case "vvip":
//                System.out.println("vvip用户结算");
//                break;
//        }


        //优化后的代码
        //在工厂类中获取该用户结算需要的结算类
//        AccountsStrategy accountsStrategy = AccountsFactory.getAccountsStrategy(accountType);
//        accountsStrategy.account();


        //对工厂进行优化后的代码
        AccountsStrategy accountsStrategy = AccountsFactory.getAccountsStrategy(CommonAccountsStrategy.class);
        accountsStrategy.account();
    }
}
