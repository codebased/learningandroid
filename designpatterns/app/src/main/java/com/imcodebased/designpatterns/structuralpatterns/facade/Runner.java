package com.imcodebased.designpatterns.structuralpatterns.facade;

public class Runner {
    public static void main(String[] str){

        // Facade is probably right to say that it works like a Repository or Unity pattern in this case of multiple repository.
        // However the idea is to hide implementations.
        ShapeBuilder shapeBuilder = new ShapeBuilder();
        shapeBuilder.drawCircle();
    }
}
