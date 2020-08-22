package com.javase.day0822.simpleFactory;

public class AccountsFactory {
    /**
     * 根据结算类型通过选择语句获取结算的类
     *
     * 带来的问题:需要增加结算类是仍然需要更改选择语句
     * @param AccountType
     * @return
     */
//    public static AccountsStrategy getAccountsStrategy(String AccountType){
//        AccountsStrategy accountsStrategy = null;
//        switch (AccountType){
//            case "common":
//                accountsStrategy = new CommonAccountsStrategy();
//                break;
//            case "vip":
//                accountsStrategy = new VipAccountsStrategy();
//                break;
//            case "vvip":
//                accountsStrategy = new VVipAccountsStrategy();
//        }
//        return accountsStrategy;
//    }

    /**
     * 优化:
     * 通过反射创建结算对象
     */
    public static AccountsStrategy getAccountsStrategy(Class c){
        AccountsStrategy accountsStrategy = null;
        try {
            accountsStrategy = (AccountsStrategy) c.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return accountsStrategy;
    }
}
