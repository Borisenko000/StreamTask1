package edu.polina.generic5;

import java.util.Collection;
import java.util.Comparator;

interface SelfComparable<T extends SelfComparable<T>> extends Comparable<T> {
    static <T extends Comparable<? super T>> T max(Collection<? extends T> coll) {
        return coll.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow();

    }
}
