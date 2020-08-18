package com.javase.day0727;

import java.util.Scanner;

public class Member {
    private String idNumber;

    private String mobilePhone;

    private String telephone;

    public boolean setIdNumber(String idNumber) {
        if (!(idNumber.length() == 16 || idNumber.length() == 18)){
            return false;
        }
        this.idNumber = idNumber;
        return true;
    }

    public boolean setMobilePhone(String mobilePhone) {
        if (!(mobilePhone.length() == 11)){
            return false;
        }
        this.mobilePhone = mobilePhone;
        return true;
    }

    public boolean setTelephone(String telephone) {
        int index = telephone.indexOf("-");
        if (!(index == 4 && telephone.length()-1-index == 7)){
            return false;
        }
        this.telephone = telephone;
        return true;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public static void main(String[] args) {
        Member member = new Member();
        Scanner sc= new Scanner(System.in);
        while (true){
            System.out.print("请输入身份证号:");
            boolean id = member.setIdNumber(sc.next());
            System.out.print("请输入手机号:");
            boolean mob = member.setMobilePhone(sc.next());
            System.out.print("请输入座机号:");
            boolean tel = member.setTelephone(sc.next());
            if (!id) {
                System.out.println("身份证号必须为11位或者18位");
                continue;
            }else if(!mob){
                System.out.println("手机号必须为11位");
                continue;
            }else if(!tel){
                System.out.println("座机号区号必须为4位,电话号码必须为7位");
                continue;
            }
            break;
        }
        System.out.println("注册成功");
    }
}
