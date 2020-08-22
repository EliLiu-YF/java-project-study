package com.javase.day0822.simpleFactory;

/**
 * vip用户结算类
 */
public class VipAccountsStrategy implements AccountsStrategy{
    @Override
    public void account() {
        System.out.println("vip用户结算");
    }
}
