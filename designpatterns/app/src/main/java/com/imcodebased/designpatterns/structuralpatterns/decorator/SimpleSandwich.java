package com.imcodebased.designpatterns.structuralpatterns.decorator;

/**
 * Created by codebased on 21/1/17.
 */

public class SimpleSandwich implements Sandwich {
    @Override
    public String make() {
        return " Bread ";
    }
}
