package java8;

import android.annotation.TargetApi;
import android.os.Build;

import java.util.Comparator;

import datastructure.OrderedList;

class play {

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static void main(String[] str) {

        StringJoinerClass stringJoinerClass = new StringJoinerClass();
        stringJoinerClass.play();

//        OrderedList<String> orderedList = new OrderedList(new Comparator() {
//            @Override
//            public int compare(Object lhs, Object rhs) {
//                return lhs.toString().compareTo(rhs.toString());
//            }
//        });
//
//        orderedList.add("Ira");
//        orderedList.add("Amit");
//        orderedList.add("Saachi");
//        orderedList.add("Amit1");
//        orderedList.add("Amit");
//        orderedList.traverse();
    }
}