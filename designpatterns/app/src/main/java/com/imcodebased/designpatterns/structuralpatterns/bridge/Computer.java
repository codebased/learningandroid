package com.imcodebased.designpatterns.structuralpatterns.bridge;

/**
 * Created by codebased on 21/1/17.
 */

public class Computer {
    Printer printer;
    Computer(Printer printer){
        this.printer = printer;
    }

    public void print() {
        this.printer.print();;
    }
}
