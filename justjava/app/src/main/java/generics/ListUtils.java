package generics;

import java.util.Comparator;
import java.util.IllegalFormatCodePointException;
import java.util.List;

/**
 * Created by codebased on 23/07/16.
 */
public class ListUtils {

    // generic types go before return type of the method and after the quantifier
    // generic
    // use T when you want to refer the type. otherwise we could have just used ?
    //     public static <T> T min (List<? super Object>  mItems, Comparator<T> comparator){
    // ....
    // }
    // Class<?> personClass = Class.forName(className) -- called unbound wildcards.
    public static <T> T min(List<T> mItems, Comparator<T> comparator) {
        if (mItems == null || mItems.size() == 0) {
            throw new IllegalArgumentException();
        }

        T minObject = mItems.get(0);
        for (T o :
                mItems) {
            if (comparator.compare(minObject, o) == 1) {
                minObject = o;
            }
        }

        return minObject;
    }
}
