package com.krishna.app.java8;

import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpliteratorTest {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(0);
        List<Article> articleList = Stream.generate(() -> new Article(i.incrementAndGet(),"Java", null))
                .limit(35000)
                .collect(Collectors.toList());
        Spliterator<Article> spliterator = articleList.spliterator();
        new Task(spliterator).run();
        Spliterator<Article> spliterator1 = articleList.spliterator();
        Spliterator<Article> spliterator2 = spliterator1.trySplit();
        new Thread(new Task(spliterator1)).start();
        new Thread(new Task(spliterator2)).start();
    }

    public static class Task implements Runnable {
        Spliterator<SpliteratorTest.Article> spliterator = null;
        volatile int current = 0;
        public Task(Spliterator<SpliteratorTest.Article> spliterator) {
            this.spliterator = spliterator;
        }

        @Override
        public void run() {
            while(spliterator.tryAdvance(a -> a.setName(a.getName().concat("-published-by-others") ))) {
                current++;
            }
            System.out.println("Testing"+Thread.currentThread().getName() + ":" + current);
        }
    }

    static public class Article {
        private List<Author> listOfAuthors;
        private int id;
        private String name;

        public Article(int id, String name, List<Author> listOfAuthors) {
            this.listOfAuthors = listOfAuthors;
            this.id = id;
            this.name = name;
        }

        public List<Author> getListOfAuthors() {
            return listOfAuthors;
        }

        public void setListOfAuthors(List<Author> listOfAuthors) {
            this.listOfAuthors = listOfAuthors;
        }

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
    }

    static public class Author {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
