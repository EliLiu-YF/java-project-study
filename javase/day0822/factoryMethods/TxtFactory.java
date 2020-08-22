package com.javase.day0822.factoryMethods;

public class TxtFactory extends IOFactory{
    @Override
    public IOHandler getIOHandler() {
        return new TxtHandler();
    }
}
