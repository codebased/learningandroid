package generics;

import java.util.List;

/**
 * Created by codebased on 23/07/16.
 */

// here the T should have implemented List<T> type at least
public class TemplateTypeBound<T extends List> {
    public T mList;
    public TemplateTypeBound(T list){
        mList = list;
    }
}
