package edu.polina.generic3;

/*
static void swapTopTwo(Deque<?> stack) — поменять местами два верхних элемента дека (моделируем стек: используйте push/pop).
Требования:
Если элементов меньше двух — бросить IllegalArgumentException.
Публичная сигнатура остаётся Deque<?>; запись назад — через capture helper <T>.
 */

import java.util.Deque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

    }

    static void swapTopTwo(Deque<?> stack) {
        if (stack.size() < 2) {
            throw new IllegalArgumentException("В коллекции меньше двух элементов");
        }
        else {

        }
    }

    static <T> void swapHelper(Deque<T> stack) {
        T element1 = stack.pop();
        T element2 = stack.pop();
        stack.push(element1);
        stack.push(element2);
    }
}
