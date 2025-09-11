package edu.polina.generic2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
static void swapValues(Map<?, ?> map, Object k1, Object k2) — если оба ключа присутствуют,
поменять их значения местами. Нельзя менять сигнатуру публичного метода: вход — Map<?, ?>.
Запись обратно должна быть типобезопасной (через helper <K,V>). Обработайте кейсы null-значений
и отсутствие ключа.
 */

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "yes");
        map.put(2, "or");
        map.put(3, "no");
        swapValues(map, 1, 3);
        map.entrySet()
                .forEach(System.out::println);
    }

    public static  void swapValues(Map<?, ?> map, Object k1, Object k2) {
        if (k1 == null) {
            System.out.println("Ключ k1 равен null)");
        }
        else if (k2 == null) {
            System.out.println("Ключ k2 равен null)");
        }
        else if (!(map.containsKey(k1))) {
            System.out.println("Коллекция не содержит ключ " + k1);
        }
        else if (!(map.containsKey(k2))) {
            System.out.println("Коллекция не содержит ключ " +  k1);
        }
         else {
             swapHelper(map, k1, k2);
        }
    }

    private static <K, V> void swapHelper(Map<K, V> map, Object k1, Object k2) {
        Set<K> keys = map.keySet();
        if (keys.contains(k1) && keys.contains(k2)) {
            V value1 = map.get(k1);
            V value2 = map.get(k2);
            map.put((K) k1, value2);
            map.put((K) k2, value1);
        }
    }

}
