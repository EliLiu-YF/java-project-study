package com.javase.day0729;

public abstract class MotorVehicle {
    private String no;//车牌号

    private String brand;//品牌

    private String color;

    private double mileage;//里程

    public MotorVehicle(String no, String brand, String color, double mileage) {
        this.no = no;
        this.brand = brand;
        this.color = color;
        this.mileage = mileage;
    }

    public MotorVehicle() {

    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    /**
     * 根据天数计算租金
     *
     * @param days
     * @return 租金
     */
    abstract public double calcRent(int days);
}
