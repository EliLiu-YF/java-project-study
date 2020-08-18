package com.soso.liuyufeng.soso;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class NetPackage extends ServicePackage implements INetService, Serializable {
    /**
     * 流量
     */
    private int flow = 3072;

    public NetPackage(int price, int flow) {
        super(price);
        this.flow = flow;
    }

    public NetPackage() {
        super(68);
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
        System.out.println("套餐详情:网虫套餐, 流量:"+format.format(getFlow()/1024.0)+"G, 资费:"+getPrice());
    }

    @Override
    public int netPlay(int flow, MobileCard card) throws Exception{
        int temp = 0;
        for (int i = 0; i < flow; i++) {
            if (this.flow - card.getRealFlow() > 0){
                card.setRealFlow(card.getRealFlow()+1);
            }else if(card.getMoney() >= 0.1){
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
}
