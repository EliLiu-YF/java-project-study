package com.javase.day0818;

public class BridgeThread extends Thread{
    Bridge bridge;

    public BridgeThread(Bridge bridge) {
        this.bridge = bridge;
    }

    @Override
    public void run() {
            synchronized (bridge){
                System.out.println(this.getId()+","+bridge.CrossBridge());
                try {
                    sleep(1000);
                    bridge.notify();
                    bridge.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }

    public static void main(String[] args) {
        Bridge bridge = new Bridge();
        for (int i = 0; i < 10; i++) {
            BridgeThread bridgeThread = new BridgeThread(bridge);
            bridgeThread.start();
        }
    }
}
