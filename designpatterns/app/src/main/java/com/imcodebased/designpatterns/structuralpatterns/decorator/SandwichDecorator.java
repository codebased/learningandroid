package com.imcodebased.designpatterns.structuralpatterns.decorator;

/**
 * Created by codebased on 21/1/17.
 */

public abstract class SandwichDecorator implements Sandwich {
    protected Sandwich customSandwich;
    public SandwichDecorator(Sandwich customSandwich){
        this.customSandwich = customSandwich;
    }

    public String make(){
        return customSandwich.make();
    }
}
