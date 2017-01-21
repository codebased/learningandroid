package com.imcodebased.designpatterns.structuralpatterns.facade;

/**
 * Created by codebased on 22/1/17.
 */

public class Runner {
    public static void main(String[] str){
        ShapeBuilder shapeBuilder = new ShapeBuilder();
        shapeBuilder.drawCircle();
    }
}
