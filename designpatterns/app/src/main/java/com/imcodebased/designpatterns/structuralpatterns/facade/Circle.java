package com.imcodebased.designpatterns.structuralpatterns.facade;

/**
 * Created by codebased on 22/1/17.
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Circle::draw()");
    }
}