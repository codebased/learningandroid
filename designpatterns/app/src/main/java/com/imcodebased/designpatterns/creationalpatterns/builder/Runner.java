package com.imcodebased.designpatterns.creationalpatterns.builder;

/**
 * Created by codebased on 22/1/17.
 */

public class Runner {

    public static void main(String str){

        // idea behind using builder pattern is to create an object that depends on
        // multiple arguments. Thus you don't need to define multiple overloaded constructors.
        // it also reduces the number of set methods require for the main class.
        // in our case the IceCreamMaker just need the get method. The set may not be required
        // after once it has been build through the builder class.

        IceCreamMaker.Builder builder = new IceCreamMaker.Builder();
        IceCreamMaker iceCreamMaker =
                builder.flavour("Pineapple").creamQuantity(2).milkQuantity(200).saltLevel(1).build();

    }
}
