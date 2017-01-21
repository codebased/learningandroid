package com.imcodebased.designpatterns.structuralpatterns.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by codebased on 21/1/17.
 */

/* this is composite because it contains a collection of components
* */
public class Menu extends MenuComponent {

    // has-a relationship defined with MenuComponent
    protected List<MenuComponent> menuComponentList = new ArrayList<>();

    @Override
    public String toString() {
        Iterator iterator = menuComponentList.iterator();
        StringBuilder builder = new StringBuilder();
        while(iterator.hasNext()){
            builder.append(iterator.next().toString());
        }

        return builder.toString();
    }

    public void add(MenuComponent menuComponent) {
        menuComponentList.add(menuComponent);
    }
}
