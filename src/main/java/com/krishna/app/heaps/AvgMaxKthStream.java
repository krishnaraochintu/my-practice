package com.krishna.app.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class AvgMaxKthStream {
    static void max_average_k_numbers(int n,
                                      int k,
                                      int m,
                                      int[] arr,
                                      int[] query) {
        double max_avg = 0.0;

        // min-heap to maintain
        // the max k elements at
        // any point of time;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        // Sort the array
        // in ascending order
        Arrays.sort(arr);

        // add max k elements
        // to the heap
        double sum = 0;
        for (int i = n - 1; i >= n - k; i--) {
            pq.add(arr[i]);
            sum = sum + arr[i];
        }

        // perform offline queries
        for (int i = 0; i < m; i++) {

            // if the minimum element in
            // the heap is less than
            // the incoming element
            if (query[i] > pq.peek()) {
                int polled = pq.poll();
                pq.add(query[i]);

                // decrement the current
                // sum by the polled element
                sum = sum - polled;

                // increment sum by the
                // incoming element
                sum = sum + query[i];
            }

            // compute the average
            max_avg = sum / (double) k;
            System.out.println(max_avg);
        }
    }

    // Driver code
    public static void main(String[] args) {
        int n = 4;
        int k = 3;
        int m = 4;
        int[] arr = new int[]{1, 2, 3, 4};
        int[] query = new int[]{7, 2, 1, 5};

        max_average_k_numbers(n, k, m, arr, query);
    }
}
