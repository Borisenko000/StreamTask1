package edu.polina.stream;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/*Напишите программу, читающую из System.in текст в кодировке UTF-8, подсчитывающую в нем частоту появления слов, и в конце выводящую 10 наиболее часто встречающихся слов.
Словом будем считать любую непрерывную последовательность символов, состоящую только из букв и цифр. Например, в строке "Мама мыла раму 33 раза!" ровно пять слов: "Мама", "мыла", "раму", "33" и "раза".
Подсчет слов должен выполняться без учета регистра, т.е. "МАМА", "мама" и "Мама" — это одно и то же слово. Выводите слова в нижнем регистре.
Если в тексте меньше 10 уникальных слов, то выводите сколько есть.
Если в тексте некоторые слова имеют одинаковую частоту, т.е. их нельзя однозначно упорядочить только по частоте, то дополнительно упорядочите слова с одинаковой частотой в лексикографическом порядке.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        scanner.useDelimiter("[^\\p{L}\\p{Nd}]+");
        List<String> words = new ArrayList<>();
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase();
            if (!word.isEmpty()) {
                words.add(word);
            }
        }
        Map<String, Long> freaqMap = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        freaqMap.entrySet().stream()
                .sorted(
                        Comparator.comparing(Map.Entry<String, Long>::getValue, Comparator.reverseOrder())
                                .thenComparing(Map.Entry::getKey)
                )                .map(Map.Entry::getKey)
                .limit(10)
                .forEach(System.out::println);
    }
}