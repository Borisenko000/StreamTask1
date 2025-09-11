package edu.polina.generic5;

import java.util.ArrayList;
import java.util.List;

import static edu.polina.generic5.SelfComparable.max;

/*
Реализуйте compareTo (по major, затем minor, затем patch).
Утилита: static <T extends Comparable<? super T>> T max(Collection<? extends T> coll) — вернуть максимум (ошибка на пустой коллекции).
Покажите, что Version корректно работает с max(...) и со структурами, ожидающими Comparable<Version>.
 */

public class Main {
    public static void main(String[] args) {
        List<Version> version = new ArrayList<>();
        version.add(new Version(2, 0, 1));
        version.add(new Version(3, 1, 2));
        version.add(new Version(0, 0, 1));
        System.out.println(max(version));
    }
}
