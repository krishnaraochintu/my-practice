package com.krishna.app.collections;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ListPractice {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(205,258,10,29,240);
      /*  List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
               return n1-n2;
            }
        });
        Collections.sort(numbers, (n1, n2) -> n1 > n2 ? -1 : (n1 < n2) ? 1 : 0);
        TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>( (n1, n2) -> (n1 > n2 ? -1 : (n1 < n2) ? 1 : 0));
        numbers.stream().forEach((number) -> {
            System.out.println(number);
            number++;
        });
        strings.stream().filter((string) -> !string.isEmpty()).collect(Collectors.toList());
        Random random = new Random();
        random.ints().limit(100).forEach(System.out::println);*/
/*        Stream<Integer> stream = numbers.stream();
        Stream<Integer> integerStream = stream.map(n -> n * n);
        Stream<Integer> distinct = integerStream.distinct();
        List<Integer> squaresList = distinct.collect(Collectors.toList());*/
      /*  IntStream streamOfChars = "abc".chars();
        streamOfChars.forEach(System.out::println); */
        List<String> list = Arrays.asList("abc1", "abc2", "abc3", "abc2");
       /* String s = list.stream().filter(element -> {
            System.out.println("filter() was called " + element);
            return element.contains("2");
        }).map(element -> {
            System.out.println("map() was called " + element);
            return element.toUpperCase();
        }).findFirst().get();
        System.out.println(s);*/
        String s = list.stream().filter(element -> element.contains("2")
        ).collect(Collectors.toList()).stream().map(element ->
             element.toUpperCase()
        ).findFirst().get();
        System.out.println(s);
    }
        static private long counter;

        static private void wasCalled() {
            counter++;
        }
}
