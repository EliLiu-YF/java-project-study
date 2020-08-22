package com.javase.day0822.factoryMethods;

public class JsonFactory extends IOFactory{
    @Override
    public IOHandler getIOHandler() {
        return new XMLHandler();
    }
}
