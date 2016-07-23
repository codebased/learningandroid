package generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListManager<T> {

    private List<T> mItems = new ArrayList<>();

    public void add(T item) {
        mItems.add(item);
    }

    public void add(T... items) {
        for (T item :
                items) {
            this.add(item);
        }
    }

    public T get(int idx) {
        return mItems.get(idx);
    }

    public List<T> get() {
        return mItems;
    }

    public void sort(Comparator<T> comparator) {
        Collections.sort(this.get(), comparator);
    }

    public void sortDescending(Comparator<T> comparator) {
        Collections.sort(this.get(), new ReverseOrderByComparator<T>(comparator));
    }

    public T first() {
        return mItems.get(0);
    }

    public T last() {
        return mItems.get(mItems.size() - 1);
    }
}
