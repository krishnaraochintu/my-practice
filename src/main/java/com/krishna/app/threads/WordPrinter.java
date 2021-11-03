package com.krishna.app.threads;

public class WordPrinter {
    private volatile Object lock = new Object();
    private String wordToPrint = null;
    private boolean readyToPrint = false;

    public void printWord() throws InterruptedException {
        synchronized(lock) {
            while(!readyToPrint) {
                lock.wait();
            }
            System.out.println(wordToPrint);
            readyToPrint = false;
        }
    }

    public void setWord(String word) {
        synchronized (lock) {
            this.wordToPrint = word;
            readyToPrint = true;
            lock.notify();
        }
    }
}
