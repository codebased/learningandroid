package starterkit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by codebased on 19/07/16.
 */
public class ComparableInterfaceClass implements Comparable<ComparableInterfaceClass>, Iterable<ComparableInterfaceClass> {

    int value;
    private List<ComparableInterfaceClass> comparableClassList;

    private ComparableInterfaceClass(int value) {
        this.value = value;
    }

    public void play() {
        comparableClassList = new ArrayList<>();
        comparableClassList.add(new ComparableInterfaceClass(10));
        comparableClassList.add(new ComparableInterfaceClass(1));
        comparableClassList.add(new ComparableInterfaceClass(3));
        comparableClassList.add(new ComparableInterfaceClass(2));

        Collections.sort(comparableClassList);

        play2();
    }

    private void play2() {

        // making life difficult for demo purpose that iterator is also one way to expose object array for iteration.
        Iterator<ComparableInterfaceClass> iterator = this.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().value);
        }
    }

    public static ComparableInterfaceClass getInstance() {
        return new ComparableInterfaceClass(0);
    }


    @Override
    public int compareTo(ComparableInterfaceClass o) {
        if (this.value == o.value) return 0;
        return this.value > o.value ? 1 : -1;
    }

    @Override
    public Iterator<ComparableInterfaceClass> iterator() {
        return comparableClassList.iterator();
    }
}
