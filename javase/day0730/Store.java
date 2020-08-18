package com.javase.day0730;

public class Store {
    public static IAnimal get(String choice){
        if (choice.equalsIgnoreCase("dog")){
            return new DogImpl();
        }else if(choice.equalsIgnoreCase("pig")){
            return new PigImpl();
        }else {
            return new CatImpl();
        }
    }
}
