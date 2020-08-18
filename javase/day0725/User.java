package com.javase.day0725;

public class User {
    String account = "admin";

    String pwd = "123456";

    public boolean login(String name, String pwd) {
        if (name.equals(account) && pwd.equals(this.pwd)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        User user = new User();
        System.out.println(user.login("admin", "123456"));
    }
}
