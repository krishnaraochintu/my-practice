package com.krishna.app.lc;

import java.util.Stack;

public class QueueUsingSingleStack {
    static class Queue {
        Stack<Integer> stack1;
    }

    static void enQueue(Queue queue, int item) {
        queue.stack1.push(item);
    }

    static int deQueue(Queue queue) {
        if(queue.stack1.isEmpty()) System.exit(0);
        if(queue.stack1.size() == 1) return queue.stack1.pop();
        int x, res = 0;
        x = queue.stack1.pop();
        res = deQueue(queue);
        queue.stack1.push(x);
        return res;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.stack1 = new Stack<Integer>();
        enQueue(queue, 1);
        enQueue(queue, 2);
        enQueue(queue, 3);
        enQueue(queue, 3);

        deQueue(queue);
        deQueue(queue);
        deQueue(queue);
    }




}


