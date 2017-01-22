package com.imcodebased.designpatterns.creationalpatterns.factory;

public class Keyboard implements Peripheral {

    @Override
    public String type() {
        return "Input";
    }
}
