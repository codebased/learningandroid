package com.imcodebased.designpatterns.creationalpatterns.factory;

/**
 * Created by codebased on 20/1/17.
 */
public interface AbstractFactory {
    Peripheral getPeripheral(String whichone);
    Board getBoard(String whichone);
}
