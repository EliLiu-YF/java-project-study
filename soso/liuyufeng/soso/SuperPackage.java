package com.soso.liuyufeng.soso;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class SuperPackage extends ServicePackage implements Serializable, ICallService, ISendService, INetService{
    /**
     * 通话时间
     */
    private int talkTime = 200;
    /**
     * 短信条数
     */
    private int smsCount = 50;
    /**
     * 流量
     */
    private int flow = 1024;

    public SuperPackage(int price, int talkTime, int smsCount, int flow) {
        super(price);
        this.talkTime = talkTime;
        this.smsCount = smsCount;
        this.flow = flow;
    }

    public SuperPackage() {
        super(78);
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

    public int getFlow() {
        return flow;
    }

    public void setFlow(int flow) {
        this.flow = flow;
    }

    @Override
    public void showInfo() {
        DecimalFormat format = new DecimalFormat("0.0");
        format.setRoundingMode(RoundingMode.FLOOR);
        System.out.println("套餐详情:话痨套餐, 通话时长:"+getTalkTime()+", 短信数量:"+getSmsCount()+", 流量"
                +format.format(getFlow()/1024.0) +"G, 资费:"+getPrice());
    }

    @Override
    public int call(int minCount, MobileCard card) throws Exception {
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
    public int netPlay(int flow, MobileCard card) throws Exception {
        int temp = 0;
        for (int i = 0; i < flow; i++) {
            if (this.flow - card.getRealFlow() > 0){
                card.setRealFlow(card.getRealFlow()+1);
            }else if(card.getMoney() > 0.1){
                card.setRealFlow(card.getRealFlow()+1);
                card.setMoney(card.getMoney()-0.1);
                card.setConsumAmount(card.getConsumAmount()+0.1);
            }else {
                temp = i;
                throw new Exception("已使用流量"+i+"mb"+",你的余额不足,请充值后再使用");
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
