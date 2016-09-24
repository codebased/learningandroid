package datastructure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class OrderedList<E> {

    private final Comparator<E> mComparator;

    private LinkedList<E> mLinkedList;

    public OrderedList(Comparator<E> comparator) {
        mComparator = comparator;
        mLinkedList = new LinkedList<>();
    }

    public E get(int idx){
        return mLinkedList.get(idx);
    }
    public void add(E item) {

        ListIterator iterator = mLinkedList.listIterator();

        if (!iterator.hasNext()) {
            iterator.add(item);
        } else {
            while (iterator.hasNext()) {
                if (mComparator.compare(item, (E) iterator.next()) <= 0) {
                    iterator.previous();
                    break;
                }
            }
            iterator.add(item);
        }
    }

    public void traverse() {
        ListIterator iterator = mLinkedList.listIterator();
        while (iterator.hasNext()) {
            System.out.printf("%s", iterator.next());
        }
    }
}
