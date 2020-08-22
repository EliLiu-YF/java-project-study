package com.javase.day0822.simpleFactory;

/**
 * 普通用户结算类
 */
public class CommonAccountsStrategy implements AccountsStrategy{
    @Override
    public void account() {
        System.out.println("普通用户结算");
    }
}
