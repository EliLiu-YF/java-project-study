package com.javase.day0728;

public class UiDesginer extends Person{
    //UI等级
    private String uiLevel;

    public String getUILevel() {
        return uiLevel;
    }

    public void setUILevel(String uiLevel) {
        this.uiLevel = uiLevel;
    }

    public void print(){
        System.out.println("画画");
    }
}
