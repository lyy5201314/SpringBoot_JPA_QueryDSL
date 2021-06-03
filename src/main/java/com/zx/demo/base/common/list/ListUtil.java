package com.zx.demo.base.common.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ListUtil {

    public static final boolean isEmptyList(List<?> list){
        return (list==null||list.isEmpty());
    }

    public static <T> List<T> copyIterator(Iterator<T> iter) {
        List<T> copy = new ArrayList<T>();
        while (iter.hasNext())
            copy.add(iter.next());
        return copy;
    }
}
