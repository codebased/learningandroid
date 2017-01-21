package com.imcodebased.designpatterns.structuralpatterns.decorator;

/**
 * Created by codebased on 21/1/17.
 */

public class CheeseSandwichDecorator extends SandwichDecorator {
    public CheeseSandwichDecorator(Sandwich customSandwich) {
        super(customSandwich);
    }

    @Override
    public String make() {
        return customSandwich.make() + addCheese();
    }

    private String addCheese() {
        return " cheddar cheese ";
    }
}
