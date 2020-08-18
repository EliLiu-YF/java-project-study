package com.javase.day0729;

final public class Truck extends MotorVehicle{
    private double tonnage;

    public Truck(String no, double tonnage){
        setNo(no);
        this.tonnage = tonnage;
    }

    public double getTonnage() {
        return tonnage;
    }

    public void setTonnage(double tonnage) {
        this.tonnage = tonnage;
    }

    @Override
    public double calcRent(int days) {
        return 50 * tonnage * days;
    }
}
