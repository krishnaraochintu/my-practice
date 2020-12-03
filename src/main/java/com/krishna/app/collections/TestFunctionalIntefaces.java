package com.krishna.app.collections;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TestFunctionalIntefaces {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Geek","GeeksQuiz","g1","QA","Geek2");
        Predicate<String> predicateNL = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("G");
            }
        };
        Predicate<String> predicate = (String s) -> s.startsWith("G");
        for(String name : names) {
            if(predicate.test(name)) {
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

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(() -> System.out.println("Thead execution"));
    }
}
