package com.krishna.app.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SmallestSubarray {
    static void minRange(int arr[], int n, int k) {
        int l = 0, r = n;

        // Consider every element
        // as starting point.
        for (int i = 0; i < n; i++) {

            // Find the smallest window
            // starting with arr[i] and
            // containing exactly k
            // distinct elements.
            Set<Integer> s = new HashSet<Integer>();
            int j;
            for (j = i; j < n; j++) {
                s.add(arr[j]);
                if (s.size() == k) {
                    if ((j - i) < (r - l)) {
                        r = j;
                        l = i;
                    }
                    break;
                }
            }

            // There are less than k
            // distinct elements now,
            // so no need to continue.
            if (j == n)
                break;
        }

        // If there was no window
        // with k distinct elements
        // (k is greater than total
        // distinct elements)
        if (l == 0 && r == n)
            System.out.println("Invalid k");
        else
            System.out.println(l + " " + r);
    }

    // Prints the minimum range that contains exactly
// k distinct numbers.
    static void minRangeOptimized(int arr[], int n, int k) {

        // Initially left and right side is -1 and -1,
        // number of distinct elements are zero and
        // range is n.
        int l = 0, r = n;
        // Initialize right side
        int j = -1;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            while (j < n) {
                // Increment right side.
                j++;
                // If number of distinct elements less than k.
                if (j < n && hm.size() < k)
                    hm.put(arr[j], hm.getOrDefault(arr[j], 0) + 1);
                // If distinct elements are equal to k and length is less than previous length.
                if (hm.size() == k && ((r - l) >= (j - i))) {
                    l = i;
                    r = j;
                    break;
                }
            }
            // If number of distinct elements less than k, then break.
            if (hm.size() < k) break;
            // If distinct elements equals to k then try to increment left side.
            while (hm.size() == k) {
                if (hm.getOrDefault(arr[i], 0) == 1)
                    hm.remove(arr[i]);
                else
                    hm.put(arr[i], hm.getOrDefault(arr[i], 0) - 1);
                // Increment left side.
                i++;
                // It is same as explained in above loop.
                if (hm.size() == k && (r - l) >= (j - i)) {
                    l = i;
                    r = j;
                }
            }
            if (hm.getOrDefault(arr[i], 0) == 1)
                hm.remove(arr[i]);
            else
                hm.put(arr[i], hm.getOrDefault(arr[i], 0) - 1);
        }

        if (l == 0 && r == n)
            System.out.println("Invalid k");
        else
            System.out.println(l + " " + r);
    }

    public static void main(String args[]) {
        int arr[] = {1, 1, 2, 2, 3, 3, 4, 5};
        int n = arr.length;
        int k = 3;
        minRange(arr, n, k);
    }
}
