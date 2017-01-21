package com.imcodebased.designpatterns.structuralpatterns.bridge;

/**
 * Created by codebased on 21/1/17.
 */

public class Runner {
    public static void main(String[] str){
        // since we have abstracted the printer object for computer.
        // The user can add or modify its printer without modifying
        // the computer object.
        Computer computer = new Computer(new LaserPrinter());
        computer.print();
    }
}
