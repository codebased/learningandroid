package com.imcodebased.designpatterns.structuralpatterns.decorator;

/**
 * Created by codebased on 21/1/17.
 */

public class DressingDecorator extends SandwichDecorator {
    public DressingDecorator(Sandwich customSandwich) {
        super(customSandwich);
    }

    @Override
    public String make() {
        return customSandwich.make() + add();
    }

    public String add(){
        return " mustard ";
    }
}
