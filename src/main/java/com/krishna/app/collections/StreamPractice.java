package com.krishna.app.collections;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice {
    public static void main(String[] args) {
/*        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
       // List<String> collect = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
      //  collect.stream().forEach(s -> System.out.print(s+","));
        String collect = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);
        List<String> list = Arrays.asList("abc1", "abc2", "abc3", "def2", "abc4");
        Optional<String> collected = list.stream().filter(string -> string.contains("2")).map(string -> string.toUpperCase()).findFirst();
        System.out.println(collected.toString());
        List<Employee> employeeList = new ArrayList<>();
        employeeList.stream().sorted(Comparator.comparingInt(Employee::getId)).collect(Collectors.toList());
        employeeList.stream().sorted((e1, e2) -> (e1.getId() - e2.getId())).collect(Collectors.toList());
        employeeList.stream().sorted(Comparator.comparing(Employee::getSalary));
        Double sumSal = employeeList.stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);
        Vector<String> empNames = employeeList.stream().map(Employee::getName)
                .collect(Collectors.toCollection(Vector::new));*/
        List<Integer> numbers = Arrays.asList(205,258,10,29,240);
        numbers.spliterator().forEachRemaining(System.out::println);
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        //forkJoinPool.invoke();
    }

    protected class Employee {
        int id;
        String name;
        double salary;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }
    }
}
