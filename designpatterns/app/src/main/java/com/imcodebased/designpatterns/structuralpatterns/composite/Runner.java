package com.imcodebased.designpatterns.structuralpatterns.composite;

/**
 * Created by codebased on 21/1/17.
 */

public class Runner {
    // composite should be used when clients ignore the difference between compositions of objects and individual objects.
    public static void main(String[] srtr){
        Menu menu = new Menu();

        MenuItem item1 = new MenuItem();
        MenuItem item2 = new MenuItem();

        item1.setTitle("Item 1");
        item2.setTitle("Item 2");

        menu.add(item1);
        menu.add(item2);

        System.out.println(menu.toString());
    }
}
