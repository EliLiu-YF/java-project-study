package com.javase.day0801.homework2;

public class Address {
    private String province;

    private String city;

    private String district;

    public Address(String province, String city, String district) {
        this.province = province;
        this.city = city;
        this.district = district;
    }

    public Address() {
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return province + "" + city + "" + district;
    }
}
