package com.imcodebased.designpatterns.structuralpatterns.facade;

/**
 * Created by codebased on 21/1/17.
 */

public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }
}