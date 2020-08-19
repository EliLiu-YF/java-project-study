package com.javase.day0818;

import java.util.ArrayList;
import java.util.List;

public class Tickets {
    List<Integer> tickets = new ArrayList<>(1000000);

    public Tickets() {
        for (int i = 1; i <= 1000000; i++) {
            tickets.add(i);
        }
    }

    synchronized void sale(){
        if (tickets.size()>0){
            System.out.println(Thread.currentThread().getId()+":"+tickets.remove(0));
        }
    }
}
