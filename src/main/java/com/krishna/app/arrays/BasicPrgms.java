package com.krishna.app.arrays;

import java.math.BigInteger;

public class BasicPrgms {

    public BigInteger factorial (BigInteger b){
        if(b.equals(new BigInteger("1"))){
            return new BigInteger("1");
        }
        return b.multiply(factorial(b.subtract(new BigInteger("1"))));
    }

    public int recursiveFactorial(int n) {
        if(n == 0) return  1;
        return n * recursiveFactorial(n-1);
    }

    public int loopFactorial(int n) {
      int result = 1;
      for(int i =2; i <= n; i++) {
          result *= i;
        }
      return result;
    }

    public boolean isPrime(int n) {
        if(n <= 1) return false;
        if(n == 2) return true;
        if(n%2 ==0 || n%3 == 0) return false;
        for(int i = 3; i <= Math.sqrt(n); i +=2) {
            if(n%i == 0) return false;
        }
        return true;
    }

    public void printFibonacci(int n) {
        int i = 0;
        int num1=0, num2 =1;
        while (i < n) {
            System.out.print(num1+",");
            int temp = num2;
            num2 = num1 + num2;
            num1 = temp;
            i++;
        }
    }

    public int recursiveFibonacci(int n) {
      if(n <=1) return n;
      return recursiveFibonacci(n-1) + recursiveFibonacci(n-2);
    }

    public int[] dynamicFibonacci(int n) {
       int fib[] = new int[n+2];
       int i = 0;
       fib[0] = 0;fib[1] = 1;
       for(i = 2; i <= n; i++) {
           fib[i] = fib[i-1] + fib[i-2];
       }
       return fib;
    }
}
