package com.imcodebased.designpatterns.structuralpatterns.facade;

/**
 * Created by codebased on 21/1/17.
 */

public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }
}