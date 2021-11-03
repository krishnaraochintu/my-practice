package com.krishna.app.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.List;

public class KthLargestElement {

    public static void main(String[] args) {
        KthLargestElement kthLargestElement = new KthLargestElement();
       /* int arr[] = {12, 3, 5, 7, 19};
        int k = 2;
        System.out.print("K'th Largest element is " + kthLargestElement.findKthLargestWithMaxHeap(arr, k));*/

        List<Integer> ints = Arrays.asList(7, 4, 6, 3, 9, 1);
        int k = 2;
        System.out.println("k'th largest array element is " + kthLargestElement.findKthLargestUsingMaxHeap(ints, k));
    }

    //Dual-Pivot Quicksort with O(n log(n))
    public int kthLargestQuicksort(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[arr.length - k];
    }

    //Using Max Heap with Java PriorityQueue with O(n + k log n)
    public int findKthLargestUsingMaxHeap(List<Integer> ints, int k) {
        // base case
        if (ints == null || ints.size() < k) {
            System.exit(-1);
        }
        // build a max-heap using the `PriorityQueue` class from all  elements in the list
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        // or pass `Comparator.reverseOrder()`
        pq.addAll(ints);
        // pop from max-heap exactly `k-1` times
        while (--k > 0) {
            pq.poll();
        }
        // return the root of max-heap
        return pq.peek();
    }

    //Using Min Heap with Java PriorityQueue with O(n. log(k))
    public int findKthLargestMinHeap(List<Integer> ints, int k) {
        // base case
        if (ints == null || ints.size() < k) {
            System.exit(-1);
        }
        // create a min-heap using the `PriorityQueue` class and insert
        // the first `k` array elements into the heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(ints.subList(0, k));
        // do for remaining array elements
        for (int i = k; i < ints.size(); i++) {
            // if the current element is more than the root of the heap
            if (ints.get(i) > pq.peek()) {
                // replace root with the current element
                pq.poll();
                pq.add(ints.get(i));
            }
        }
        // return the root of min-heap
        return pq.peek();
    }

    // With MaxHeap O(n + kLogn) or O(k + (n-k)*Logk)
    public int findKthLargestWithMaxHeap(int[] nums, int k) {
        int n = nums.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            maxHeapify(nums, n, i);
        }

        for (int i = n - 1; i > (n - k); i--) {
            swap(nums, 0, i);
            maxHeapify(nums, i, 0);
        }

        return nums[0];
    }

    private void maxHeapify(int[] nums, int n, int i) {
        int largest = i;
        int leftchild = (2 * i) + 1;
        int rightchild = (2 * i) + 2;
        if (leftchild < n && nums[leftchild] > nums[largest]) {
            largest = leftchild;
        }
        if (rightchild < n && nums[rightchild] > nums[largest]) {
            largest = rightchild;
        }
        if (largest != i) {
            swap(nums, largest, i);
            maxHeapify(nums, n, largest);
        }
    }

    private void swap(int[] nums, int pos1, int pos2) {
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }
}
