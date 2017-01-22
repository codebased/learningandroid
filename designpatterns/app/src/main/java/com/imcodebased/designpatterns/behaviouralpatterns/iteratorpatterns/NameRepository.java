package com.imcodebased.designpatterns.behaviouralpatterns.iteratorpatterns;

import java.util.Iterator;

/**
 * Created by codebased on 22/1/17.
 */

public class NameRepository implements Iterable<String> {
    public String names[] = {"Ram", "Jagat", "Jaan", "Leela"};

    @Override
    public Iterator<String> iterator() {
        Iterator<String> it = new Iterator<String>() {

            int currentIndex = 0;

            @Override
            public boolean hasNext() {
                if (currentIndex < names.length) {
                    return true;
                }
                return false;
            }

            @Override
            public String next() {
                if (this.hasNext()) {
                    return names[currentIndex++];
                }
                return null;
            }
        };

        return it;
    }
}