package com.krishna.app.heaps;

import java.util.PriorityQueue;
import java.util.TreeSet;

public class PriorityQueueTesting {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        priorityQueue.add(9);treeSet.add(9);
        priorityQueue.add(8);treeSet.add(8);
        System.out.println("Queue"+priorityQueue);
        System.out.println("TreeSet"+treeSet);
        priorityQueue.add(6);treeSet.add(6);
        System.out.println("Queue"+priorityQueue);
        System.out.println("TreeSet"+treeSet);
        priorityQueue.add(5);treeSet.add(5);
        System.out.println("Queue"+priorityQueue);
        System.out.println("TreeSet"+treeSet);
        priorityQueue.add(3);treeSet.add(3);
        System.out.println("Queue"+priorityQueue);
        System.out.println("TreeSet"+treeSet);
        priorityQueue.add(1);treeSet.add(1);
        System.out.println("Queue"+priorityQueue);
        System.out.println("TreeSet"+treeSet);

        System.out.println(priorityQueue.poll());

        System.out.println(priorityQueue);
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue);
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue);
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue);
    }

}
