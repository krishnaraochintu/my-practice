package com.krishna.app.java8;

import java.util.*;
import java.util.stream.Collectors;

public class StreamPractice {
    public static void main(String[] args) {
        List<String> listForReplacement = Arrays.asList("geeks_for_geeks",  "bc", "efg", "abcd", "jkl");
        listForReplacement.stream().map(str -> str.substring(0, 1).toUpperCase() + str.substring(1)).collect(Collectors.toList());
        List<String> collectedReplaced = listForReplacement.stream().map(str -> str = str.substring(0, 1).toUpperCase() + str.substring(1)).
                map(str -> str.replaceFirst("_[a-z]", String.valueOf(Character.toUpperCase(str.charAt(str.indexOf("_") + 1))))).collect(Collectors.toList());
        System.out.println(collectedReplaced);
       /* List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> collected = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        collected.stream().forEach(s -> System.out.print(s + ","));
        String collect = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);
        List<String> list = Arrays.asList("abc1", "abc2", "abc3", "def2", "abc4");
        Optional<String> collectedFirst = list.stream().filter(string -> string.contains("2")).map(s -> s.toUpperCase()).findFirst();
        System.out.println(collectedFirst.orElseGet(() -> "Empty"));
        List<Employee> employeeList = new ArrayList<>();
        //employee -> employee.getSalary()
        //employee -> employee.getId()
        employeeList.stream().sorted(Comparator.comparingInt(Employee::getId)).collect(Collectors.toList());
        employeeList.stream().sorted((e1, e2) -> (e1.getId() - e2.getId())).collect(Collectors.toList());
        employeeList.stream().sorted(Comparator.comparing(Employee::getSalary));
        employeeList.stream().map(Employee::getSalary).reduce(0.0, (a, b) -> Double.sum(a, b));
        Double sumSal = employeeList.stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);
        Vector<String> empNames = employeeList.stream().map(Employee::getName)
                .collect(Collectors.toCollection(Vector::new));*/

    }

    protected class Employee implements Comparable<Employee> {
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

        @Override
        public int compareTo(Employee employee) {
            return this.equals(employee) ? 1: 0;
        }
    }
}
