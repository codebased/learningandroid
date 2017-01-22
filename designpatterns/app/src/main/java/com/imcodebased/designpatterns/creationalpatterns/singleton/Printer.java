package com.imcodebased.designpatterns.creationalpatterns.singleton;

/**
 * Created by codebafsed on 22/1/17.
 */

public class Printer {

    private static Printer o;
    private Printer(){

    }

    public static Printer getInstance(){

        // lazy loading
        if ( o == null ){
            // thread safe.
            synchronized (Printer.class)
            {
                if ( o == null ) {
                    o = new Printer();
                }
            }
        }

        return o;
    }
}
