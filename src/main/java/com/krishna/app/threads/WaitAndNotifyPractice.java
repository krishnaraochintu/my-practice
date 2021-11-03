package com.krishna.app.threads;

import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.*;

public class WaitAndNotifyPractice {

    Stack<String> stack = new Stack<>();
    int CAPACITY = 5;
    ReentrantLock lock = new ReentrantLock();
    Condition stackEmptyCondition = lock.newCondition();
    Condition stackFullCondition = lock.newCondition();

    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        readWriteLock.writeLock();
        StampedLock lock = new StampedLock();
        long stamp = lock.writeLock();
        Semaphore semaphore = new Semaphore(5);
        WaitAndNotifyPractice waitAndNotifyPractice = new WaitAndNotifyPractice();
        Arrays.asList("Test", "Two", "Three", "Four").
                parallelStream().forEach(
                s -> {
                    try {
                        waitAndNotifyPractice.pushToStack(s);
                        waitAndNotifyPractice.popFromStack();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });

        //reentrant characteristics
    }

    public void pushToStack(String item) throws InterruptedException {
        try {
            lock.lock();
            while (stack.size() == CAPACITY) {
                stackFullCondition.await();
            }
            stack.push(item);
            System.out.println("Element pushed"+ item+":"+Thread.currentThread().getName());
            stackFullCondition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public String popFromStack() throws InterruptedException {
        try {
            lock.lock();
            while (stack.size() == 0) {
                stackEmptyCondition.await();
            }
            String item = stack.pop();
            System.out.println("Element pop"+ item+":"+Thread.currentThread().getName());
            return item;
        } finally {
            stackFullCondition.signalAll();
            lock.unlock();
        }
    }

}

