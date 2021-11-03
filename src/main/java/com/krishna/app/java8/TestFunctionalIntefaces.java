package com.krishna.app.java8;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestFunctionalIntefaces {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Geek", "GeeksQuiz", "g1", "QA", "Geek2");
        Predicate<String> predicateNL = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("G");
            }
        };
        Predicate<String> predicate = (String s) -> s.startsWith("G");
        for (String name : names) {
            if (predicate.test(name)) {
                System.out.println(name);
            }
        }
        names.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        names.forEach(name -> System.out.println(name));


        Map<String, Integer> map = new HashMap<>();
        map.computeIfAbsent("Jhon", s -> s.length());
        map.computeIfAbsent("Jhon", String::length);
        //Compose(before) and andThen(after)
        //Primitive types has specified functions like IntFunction, ToInFunction, IntToDoubleFunction etc
        //BiFunction(two inputs and one output) can be used to manipulate map. function will execute on each k,v and returns v.
        Supplier<Double> supplier = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10d;
        };
        Supplier<TestFunctionalIntefaces> aNew = TestFunctionalIntefaces::new;
        Supplier<Integer> integerSupplier = () -> new Random().nextInt(10);
        Stream.generate(integerSupplier).limit(5).forEach(System.out::println);
        int[] fibs = {0, 1};
        Supplier fibonocisFunction = () -> {
            int result = fibs[1];
            int fib3 = fibs[0] + fibs[1];
            fibs[0] = fibs[1];
            fibs[1] = fib3;
            return result;
        };
        Stream.generate(fibonocisFunction).limit(25).forEach(System.out::println);

        List<String> namesList = Arrays.asList("John", "Freddy", "Samuel");
        namesList.forEach(name -> System.out.println(name));
        map.forEach((key, value) -> System.out.println(key+":"+value));

        namesList.stream().filter(name -> name.startsWith("J")).collect(Collectors.toList());
        names.replaceAll(s -> s.replaceFirst("K", "J"));
        names.replaceAll(s -> s.toUpperCase());
        names.replaceAll(String:: toUpperCase);

        List<Integer> values = Arrays.asList(3, 5, 8, 9, 12);
        values.stream().reduce(0, (i1, i2) -> i1 + i2);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(() -> System.out.println("Running the method"));
        Future<String> submit = executorService.submit(() -> "Test");
        try {
            System.out.println(submit.get());
        } catch (InterruptedException | ExecutionException e2) {
            e2.printStackTrace();
        }
    }
}
