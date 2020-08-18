package com.javase.day0723;

import java.util.Arrays;
import java.util.Scanner;

public class MemberManageSystem {
    Member[] members = new Member[5];

    int size; //已输入的会员数

    /**
     * 根据会员编号查找会员积分
     * @param memberId 会员编号
     * @return 找到了返回积分  没找到返回 -1
     */
    public int findIntegralById(int memberId){
        for (int i = 0; i < size; i++) {
            if (members[i].memberId == memberId){
                return members[i].integral;
            }
        }
        return -1;
    }

    /**
     * 添加会员
     * @param member
     */
    public void addMember(Member member){
        if (size >= members.length){
            members = Arrays.copyOf(members,members.length*2);
        }
        members[size] = member;
        ++size;
    }

    /**
     * 显示会员信息
     */
    public void show(){
        System.out.println("******会员列表*******");
        System.out.println("会员编号\t\t\t积分");
        for (int i = 0; i < size; i++) {
            System.out.println(members[i].memberId+"\t\t\t"+members[i].integral);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MemberManageSystem mms = new MemberManageSystem();
        for (int i = 0; i < 5 ; i++) {
            System.out.print("输入会员编号:");
            int memberId = sc.nextInt();
            System.out.print("输入会员积分:");
            int integral = sc.nextInt();
            Member member = new Member();
            member.memberId = memberId;
            member.integral = integral;
            mms.addMember(member);
        }
        mms.show();
        System.out.print("请输入要查找的会员编号:");
        int findIntegral=mms.findIntegralById(sc.nextInt());
        if (findIntegral != -1 ) {
            System.out.println("该会员积分为:"+findIntegral);
        }else {
            System.out.println("找不到该会员!");
        }
    }
}
