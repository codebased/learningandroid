package com.imcodebased.designpatterns.structuralpatterns.composite;

/**
 * Created by codebased on 21/1/17.
 */

/** this is component**/
public abstract class MenuComponent extends Object{
    private String title;


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }
    public abstract String toString();

 }
