package com.imcodebased.designpatterns.factory;

public class Mouse implements Peripheral {

    @Override
    public String type() {
        return "Input";
    }
}
