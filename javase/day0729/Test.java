package com.javase.day0729;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
//        System.out.println("请输入要租赁的车型:");
//        System.out.println("1:别克商务舱GL8");
//        System.out.println("2:宝马550i");
//        System.out.println("3:别克林荫大道");
//        System.out.println("4:30座客车");
//        System.out.println("5:15座客车");
//        System.out.println("6:卡车");
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        System.out.println("请输入你要租的天数:");
//        int days = sc.nextInt();
//        switch (num){
//            case 1:
//                Car car1 = new Car("01","别克商务舱GL8");
//                System.out.println("价格:"+car1.calcRent(days));
//                break;
//            case 2:
//                Car car2 = new Car("02","宝马550i");
//                System.out.println("价格:"+car2.calcRent(days));
//                break;
//            case 3:
//                Car car3 = new Car("03","别克林荫大道");
//                System.out.println("价格:"+car3.calcRent(days));
//                break;
//            case 4:
//                Bus bus1 = new Bus("04", 30);
//                System.out.println("价格:"+bus1.calcRent(days));
//                break;
//            case 5:
//                Bus bus2 = new Bus("05", 15);
//                System.out.println("价格:"+bus2.calcRent(days));
//                break;
//            case 6:
//                System.out.print("请输入你要租的吨位:");
//                double tonnage = sc.nextInt();
//                Truck truck = new Truck("06", tonnage);
//                System.out.println("价格:"+truck.calcRent(days));
//        }
        MotorVehicle motorVehicle = buyMotorVehicle();
        System.out.println("车型:"+motorVehicle.getBrand()+", 颜色:"+motorVehicle.getColor());
    }

    public static MotorVehicle buyMotorVehicle(){
        MotorVehicle motorVehicle = null;
        System.out.println("请输入你要购买的车型:1.轿车, 2.客车, 3.卡车");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String color = "";
        switch (num){
            case 1:
                System.out.print("请输入你要购买的轿车品牌:");
                String type = sc.next();
                System.out.print("请输入颜色:");
                color = sc.next();
                motorVehicle = new Car("01",type);
                motorVehicle.setBrand("轿车");
                motorVehicle.setColor(color);
                break;
            case 2:
                System.out.println("请输入你要购买客车的乘客量:");
                int seatCount = sc.nextInt();
                System.out.println("请输入颜色:");
                color = sc.next();
                motorVehicle = new Bus("01", seatCount);
                motorVehicle.setBrand("客车");
                motorVehicle.setColor(color);
                break;
            case 3:
                System.out.println("请输入你要购买卡车的吨数:");
                double tonnage = sc.nextInt();
                System.out.println("请输入颜色:");
                color = sc.next();
                motorVehicle = new Truck("01", tonnage);
                motorVehicle.setBrand("卡车");
                motorVehicle.setColor(color);
                break;
        }
        return motorVehicle;
    }
}
