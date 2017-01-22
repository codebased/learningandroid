package com.imcodebased.designpatterns.creationalpatterns.factory;

 /**
 * Created by codebased on 20/1/17.
 */

public class Runner {

    public static void main(String[] str){

        doPeripheralFactory();

        doAbstractFactoryOfBoardFactory();

    }

    private static void doPeripheralFactory() {
        Peripheral peripheral = new PeripheralFactory().getPeripheral("Mouse");
        peripheral.type();
    }

    private static void doAbstractFactoryOfBoardFactory() {
        Board board = FactoryGenerator.getFactory("Board").getBoard("NIC");
        board.name();
    }
}
