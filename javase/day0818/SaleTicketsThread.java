package com.javase.day0818;

public class SaleTicketsThread extends Thread{
    private Tickets tickets = null;

    public SaleTicketsThread(Tickets tickets){
        this.tickets = tickets;
    }

    @Override
    public void run() {
        while(true){
            tickets.sale();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
