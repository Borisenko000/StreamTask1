package edu.polina.generic6;

import java.util.Collection;
import java.util.Iterator;

/*
Утилита reduce(Collection<? extends T> items) - свёртка коллекции через merge слева направо (ошибка на пустой коллекции).
 */
public interface Mergeable<T extends Mergeable<T>>{
    T merge(T other);

    static <T extends Mergeable<T>> T reduce(Collection<? extends T> items) {
        if(items.isEmpty()) {
            throw new IllegalArgumentException("Коллекция не содержит элементов");
        }
        else {
            Iterator<? extends T> it = items.iterator();
            T t = it.next();
            while(it.hasNext()) {
                t = t.merge(it.next());
            }
            return t;
        }
    }
}
