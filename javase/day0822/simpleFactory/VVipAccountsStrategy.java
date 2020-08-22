package com.javase.day0822.simpleFactory;

/**
 * vvip用户结算类
 */
public class VVipAccountsStrategy implements AccountsStrategy{
    @Override
    public void account() {
        System.out.println("vvip用户结算");
    }
}
