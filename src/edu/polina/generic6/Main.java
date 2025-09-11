package edu.polina.generic6;

import java.util.List;

import static edu.polina.generic6.Mergeable.reduce;

/*
F-bounded полиморфизм: «сворачиваем» коллекцию объектов, умеющих сливаться
 */
public class Main {
    public static void main(String[] args) {
        List<Money> list1 = List.of(new Money("ruble", 200), new Money("ruble", 300), new Money("ruble", 250));
        System.out.println(reduce(list1).toString());
        List<TimeSpan> list2 = List.of(new TimeSpan(3000), new TimeSpan(4000), new TimeSpan(100));
        System.out.println(reduce(list2).toString());
    }
}
