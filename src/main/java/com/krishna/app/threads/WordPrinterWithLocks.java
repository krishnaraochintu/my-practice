package com.krishna.app.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class WordPrinterWithLocks {
    private  String wordToPrint = null;
    ReentrantLock reentrantLock;
    Condition readyToPrintCondition;
    public WordPrinterWithLocks() {
        reentrantLock = new ReentrantLock();
        readyToPrintCondition = reentrantLock.newCondition();
    }
    public void printWord() throws InterruptedException {
        try {
            reentrantLock.lock();
            readyToPrintCondition.await();
            System.out.println(wordToPrint);
        } finally {
            reentrantLock.unlock();
        }
    }

    public void setWord(String word) {
        try {
            reentrantLock.lock();
            this.wordToPrint = word;
            readyToPrintCondition.signal();
        } finally {
            reentrantLock.unlock();
        }

    }
}
