package com.javase.day0806;

public class test {
    public static void main(String[] args) {
        int[] arr = new int[6];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 4;
        arr[3] = 6;
        arr[4] = 7;
        int num = 5;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (num < arr[i]){
                index = i;
                break;
            }
        }
        for (int i = arr.length-1; i >index ; i--) {
            arr[i] = arr[i-1];
        }
        arr[index] = num;
        for (int i : arr){
            System.out.print(i);
        }
    }
}
