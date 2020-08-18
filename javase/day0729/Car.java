package com.javase.day0729;

final public class Car extends MotorVehicle {
    private String type;//品牌

    public Car(String no, String brand, String color, double mileage, String type) {
        super(no, brand, color, mileage);
        this.type = type;
    }

    public Car(String no, String type) {
        setNo(no);
        this.type = type;
    }

    public Car() {

    }

    @Override
    public double calcRent(int days) {
        int price = 0;
        switch (this.type){
            case  "别克商务舱GL8":
                price = 600;
                return price * days;
            case  "宝马550i":
                price = 500;
                return price * days;
            case  "别克林荫大道":
                price =300;
                return price * days;
        }
        return 0;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
