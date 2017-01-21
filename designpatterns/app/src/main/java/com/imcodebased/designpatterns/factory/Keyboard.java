package com.imcodebased.designpatterns.factory;

public class Keyboard implements Peripheral {

    @Override
    public String type() {
        return "Input";
    }
}
