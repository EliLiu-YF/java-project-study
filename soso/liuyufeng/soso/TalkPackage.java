package com.soso.liuyufeng.soso;

import java.io.Serializable;

/**
 * 话痨套餐
 */
public class TalkPackage extends ServicePackage implements ICallService, ISendService, Serializable {
    /**
     * 通话时长
     */
    private int talkTime = 500;
    /**
     * 短信条数
     */
    private int smsCount = 30;

    public TalkPackage(int price, int talkTime, int smsCount) {
        super(price);
        this.talkTime = talkTime;
        this.smsCount = smsCount;
    }

    public TalkPackage() {
        super(58);
    }

    public int getTalkTime() {
        return talkTime;
    }

    public void setTalkTime(int talkTime) {
        this.talkTime = talkTime;
    }

    public int getSmsCount() {
        return smsCount;
    }

    public void setSmsCount(int smsCount) {
        this.smsCount = smsCount;
    }

    /**
     * 重写显示信息方法
     */
    @Override
    public void showInfo() {
        System.out.println("套餐详情:话痨套餐, 通话时长:"+getTalkTime()+", 短信数量:"+getSmsCount()+", 资费:"+getPrice());
    }

    @Override
    public int call(int minCount, MobileCard card) throws Exception{
        int temp = 0;
        for (int i = 0; i < minCount; i++) {
            if (talkTime - card.getRealTalkTime() > 0){
                card.setRealTalkTime(card.getRealTalkTime()+1);
            }else if (card.getMoney() > 0.2){
                card.setRealTalkTime(card.getRealTalkTime()+1);
                card.setMoney(card.getMoney()-0.2);
                card.setConsumAmount(card.getConsumAmount()+0.2);
            }else{
                temp = i;
                throw new Exception("本次通话"+i+"分钟,你的余额不足,请充值后再使用");
            }
        }
        return temp;
    }

    @Override
    public int send(int count, MobileCard card) throws Exception {
        int temp = 0;
        for (int i = 0; i < count; i++) {
            if (smsCount - card.getRealSMSCount() > 0){
                card.setRealSMSCount(card.getRealSMSCount()+1);
            }else if(card.getMoney() > 0.1){
                card.setRealSMSCount(card.getRealSMSCount()+1);
                card.setMoney(card.getMoney()-0.1);
                card.setConsumAmount(card.getConsumAmount()+0.1);
            }else {
                temp = i;
                throw new Exception("已发送短信"+i+"条"+",你的余额不足,请充值后再使用");
            }
        }
        return temp;

    }
}
