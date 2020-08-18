package com.javase.day0729;

final public class Bus extends MotorVehicle {
    private int seatCount; //座位

    public Bus(String no, String brand, String color, double mileage, int seatCount) {
        super(no, brand, color, mileage);
        this.seatCount = seatCount;
    }

    public Bus(String no, int seatCount) {
        setNo(no);
        this.seatCount = seatCount;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    @Override
    public double calcRent(int days) {
        int price;
        if (days <=16){
            price = 800;
        }else {
            price = 1500;
        }
        return price * days;
    }
}
