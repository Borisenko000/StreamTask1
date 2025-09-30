package edu.polina.threadstomap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\fact.txt");
        List<String> text = new ArrayList<>();
        try {
            text = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла");
        }
        int threads = Math.min(Runtime.getRuntime().availableProcessors(), text.size());
        int chunkSize = (text.size() + threads - 1) / threads;
        List<String> finalList = new ArrayList<>(threads);
        for (int from = 0; from < text.size(); from += chunkSize) {

            StringBuilder strb = new StringBuilder();
            for (int to = 0; to < chunkSize; to++) {
                if (from + to >= text.size()) {
                    break;
                }
                strb.append(text.get(from + to)).append("\n");
            }
            finalList.add(strb.toString());
        }
        Map<String, Long> global = Collections.synchronizedMap(new HashMap<>(threads));
        try(ExecutorService pool = Executors.newFixedThreadPool(threads)) {
            for (String s : text) {
                pool.submit(() -> {
                    Map<String, Long> local = Arrays.stream(s.split("\\s+"))
                            .filter(k  -> !k.isEmpty())
                            .map(k -> k.toLowerCase().replaceAll("\\p{Punct}", ""))
                            .collect(Collectors.groupingBy(k -> k, Collectors.counting()));
                    synchronized (global) {
                        for (Map.Entry<String, Long> e: local.entrySet()) {
                            global.merge(e.getKey(), e.getValue(), Long::sum);
                        }
                    }
                });
            }
        }
        global.forEach((k, v) -> System.out.println(k + ":" + v));
    }
}
