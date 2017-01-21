package com.imcodebased.designpatterns.factory;

// Factory Pattern: A part of creational pattern that create an object.
public class BoardFactory implements AbstractFactory {

    @Override
    public Board getBoard(String whichone) {
        switch (whichone) {
            case "Mother":
                return new MotherBoard();
            case "NIC":
                return new NIC();
        }
        return null;
    }

    @Override
    public Peripheral getPeripheral(String whichone) {
        return null;
    }
}

