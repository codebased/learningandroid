package tests.datastructure;

import junit.framework.Assert;

import org.junit.Test;

import java.util.Comparator;

import datastructure.OrderedList;
import datastructure.recursion;

public class play {

    @Test
    public void shouldOrdered() {

        OrderedList<String> orderedList = new OrderedList(new Comparator() {
            @Override
            public int compare(Object lhs, Object rhs) {
                return lhs.toString().compareTo(rhs.toString());
            }
        });

        orderedList.add("Ira");
        orderedList.add("Amit");
        orderedList.add("Saachi");
        orderedList.add("Amit1");
        orderedList.add("Amit");

        Assert.assertEquals(orderedList.get(0), "Amit");
        Assert.assertEquals(orderedList.get(1), "Amit");
        Assert.assertEquals(orderedList.get(2), "Amit1");
        Assert.assertEquals(orderedList.get(3), "Ira");
    }

    @Test
    public void shouldShow() {
        for (int idx = 0; idx < 10; idx++) {
            int result = recursion.fib(idx);
            System.out.println(result);
        }

    }
}
