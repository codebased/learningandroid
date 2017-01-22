package com.imcodebased.designpatterns.creationalpatterns.factory;

public class Mouse implements Peripheral {

    @Override
    public String type() {
        return "Input";
    }
}
