package com.krishna.app.collections;

public class Calculator {
    public int calculate(int a, int b, Operator operator) {
        return operator.apply(a, b);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.calculate(2, 6, Operator.valueOf("ADD"));
    }
}
