package com.imcodebased.designpatterns.creationalpatterns.factory;

/**
 * Created by codebased on 20/1/17.
 */

// Abstract factory pattern: It defines pattern of patterns.
public class FactoryGenerator {

    public static AbstractFactory getFactory(String whichone) {
        switch (whichone) {
            case "Board":
                return new BoardFactory();

            case "Peripheral":
                return new PeripheralFactory();
        }

        return null;
    }
}
