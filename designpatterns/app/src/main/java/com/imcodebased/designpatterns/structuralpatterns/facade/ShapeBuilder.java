package com.imcodebased.designpatterns.structuralpatterns.facade;

/**
 * Created by codebased on 22/1/17.
 */
class ShapeBuilder {
    private Shape circle;
    private Shape rectangle;
    private Shape square;

    public ShapeBuilder() {
        circle = new Circle();
        rectangle = new Rectangle();
        square = new Square();
    }

    public void drawCircle(){
        circle.draw();
    }
    public void drawRectangle(){
        rectangle.draw();
    }
    public void drawSquare(){
        square.draw();
    }
}