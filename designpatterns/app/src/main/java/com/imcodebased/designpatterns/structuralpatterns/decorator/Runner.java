package com.imcodebased.designpatterns.structuralpatterns.decorator;

/**
 * Created by codebased on 21/1/17.
 */

public class Runner {
    // You are adding features on the top of Simple Sandwich by providing different decorators that you would like to apply against this sandwich.
    // just like here we are applying Dressing, Cheese and so on.
    // the reason is we will have mustard, cheddar, and then Bread as an output.
    public static void main(String args[]){
        Sandwich sandwich = new DressingDecorator(new CheeseSandwichDecorator(new SimpleSandwich()));
        System.out.println(sandwich.make());
    }
}
