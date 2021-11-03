package com.krishna.app.java8;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class ParalleStreamPractice {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Default using ForkJoinPool worker poll.
        //ParallelStream internally uses SplitIterator
        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
        listOfNumbers.parallelStream().forEach(
                number -> System.out.println(number+":-"+Thread.currentThread().getName()));
        Integer value1 = listOfNumbers.stream().reduce(5, Integer::sum);
        Integer value2 = listOfNumbers.parallelStream().reduce(5, Integer::sum);
        System.out.println(value1+ ":"+value2);
        ForkJoinPool customThreadPool = new ForkJoinPool(2);
        Integer result = customThreadPool.submit(() -> listOfNumbers.parallelStream().reduce(5, Integer::sum)).get();
        customThreadPool.shutdown();
        System.out.println(result);
    }
}
