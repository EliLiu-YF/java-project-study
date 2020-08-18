package com.soso.liuyufeng.soso;

import java.io.Serializable;

public class ConsumInfo implements Serializable {
    private String cardNumber;

    private String type;

    private int cousumData;

    private int talkTime;

    private int smsCount;

    private int flow;

    private double price;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCousumData() {
        return cousumData;
    }

    public void setCousumData(int cousumData) {
        this.cousumData = cousumData;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
