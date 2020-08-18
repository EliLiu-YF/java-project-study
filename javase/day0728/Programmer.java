package com.javase.day0728;

public class Programmer extends Person{
    //技术等级
    private String technicalGrade;

    public String getTechnicalGrade() {
        return technicalGrade;
    }

    public void setTechnicalGrade(String technicalGrade) {
        this.technicalGrade = technicalGrade;
    }

    public void print(){
        System.out.println("写代码");
    }
}
