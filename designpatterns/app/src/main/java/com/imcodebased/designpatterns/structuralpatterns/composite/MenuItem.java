package com.imcodebased.designpatterns.structuralpatterns.composite;

/**
 * Created by codebased on 21/1/17.
 */

/** This is leaf **/
public class MenuItem extends MenuComponent {
    @Override
    public String toString() {
        return "Menu Item" + this.getTitle();
    }
}
