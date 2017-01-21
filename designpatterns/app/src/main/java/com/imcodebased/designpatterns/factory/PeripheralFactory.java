package com.imcodebased.designpatterns.factory;

/**
 * Created by codebased on 20/1/17.
 */

public class PeripheralFactory implements AbstractFactory {

    @Override
    public  Peripheral getPeripheral(String whichone) {
        switch (whichone) {
            case "Mouse":
                return new Mouse();
            case "Keyboard":
                return new Keyboard();
        }
        return null;
    }

    @Override
    public Board getBoard(String whichone) {
        return null;
    }
}


