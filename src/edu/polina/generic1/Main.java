package edu.polina.generic1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Утилиты:
static void swap(List<?> list, int i, int j) — поменять местами элементы по индексам.
static void reverse(List<?>) — развернуть список на месте.
Обе функции должны принимать List<?>, но при этом безопасно читать и записывать элементы (подсказка: используйте capture helper — приватный вспомогательный метод с параметром типа <T>).
Покройте примером корректность на List<Integer> и List<String>.
 */

public class Main {
    public static void main(String[] args) {
        List<?> list = new ArrayList<>(Arrays.asList("hi", 1, 3, "bye"));
        swap(list, 0, 3);
        reverse(list);

    }

    //поменять местами элементы по индексам.
    public static void swap(List<?> list, int index1, int index2) {
        swapHelper(list, index1, index2);
        list
                .forEach(System.out::println);
    }

    //развернуть список на месте.
    public static void reverse(List<?> list) {
        reverseHelper(list);
        list
                .forEach(System.out::println);
    }

    private static <T> void swapHelper(List<T> list, int index1, int index2) {
        T element = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, element);
    }

    private static <T> void reverseHelper(List<T> list) {
        int i = 0;
        int r = list.size() - 1;
        while(i < r) {
            T element = list.get(i);
            list.set(i, list.get(r));
            list.set(r, element);
            i++;r--;
        }
    }
}