package com.soso.liuyufeng.soso;

public abstract class ServicePackage {
    /**
     * 资费
     */
    private int price;

    public ServicePackage() {
    }

    public ServicePackage(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * 抽象显示套餐信息方法
     */
    abstract public void showInfo();
}
