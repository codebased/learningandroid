package com.imcodebased.designpatterns.behaviouralpatterns.iteratorpatterns;

/**
 * Created by codebased on 22/1/17.
 */

public class Runner {
    public static void main(String[] str) {
        NameRepository repository = new NameRepository();
        for (String item :
                repository) {
            System.out.println(item);
        }
    }
}
