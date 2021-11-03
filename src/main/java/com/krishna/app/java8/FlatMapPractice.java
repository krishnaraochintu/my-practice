package com.krishna.app.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

public class FlatMapPractice {
    public static void main(String[] args) {
        Stream.of("a", "b").map(String::toUpperCase).collect(Collectors.toList());
        Arrays.asList(Arrays.asList("a"),
                Arrays.asList("b")).stream().flatMap(Collection::stream).collect(Collectors.toList());
        List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11,13);
        List<Integer> OddNumbers = Arrays.asList(1, 3, 5);
        List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8);
        List<List<Integer>> listOfListofInts = Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers);
        System.out.println("The Structure before flattening is : " + listOfListofInts);
        listOfListofInts.stream().flatMap(list -> list.stream()).collect(Collectors.toList());

        // Using flatMap for transformating and flattening.
        List<Integer> listofInts  = listOfListofInts.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());
        List<String> listString = Arrays.asList("Geeks", "GFG", "GeeksforGeeks", "gfg");
        // Using Stream flatMap(Function mapper)
        listString.stream().flatMap(str ->
                Stream.of(str.charAt(2))).
                forEach(System.out::println);
        List<String> listNumbers = Arrays.asList("5.6", "7.4", "4","1", "2.3");
        // Using Stream flatMap(Function mapper)
        listNumbers.stream().flatMap(num -> Stream.of(num)).
                forEach(System.out::println);

    }
}
