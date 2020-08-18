package com.javase.day0801.homework2;

public class Administrator {
    private String userName;

    private String pwd;

    public Administrator(String userName, String pwd) {
        this.userName = userName;
        this.pwd = pwd;
    }

    public Administrator() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
