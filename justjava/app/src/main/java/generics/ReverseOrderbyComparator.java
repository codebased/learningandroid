package generics;

import java.util.Comparator;

/**
 * Created by codebased on 23/07/16.
 */
public class ReverseOrderByComparator<T> implements Comparator<T> {

    private final Comparator<T> comparator;

    public ReverseOrderByComparator(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public int compare(T lhs, T rhs) {
        // reverse it by multiplying with -1
        return comparator.compare(lhs, rhs) * -1;
    }
}
