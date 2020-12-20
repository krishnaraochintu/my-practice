package com.krishna.app.arrays;

import java.util.*;

public class MaxSumTriplet {

    int maxTripletSum(int arr[], int n) {
        int result = 0;
        for (int i = 1; i < n - 1; i++) {
            int max1 = 0, max2 = 0;
            for (int j = 0; j < i - 1; j++) {
                //Max value to less  than a[i]
                if (arr[j] < arr[i]) {
                    max1 = Math.max(max1, arr[j]);
                }
            }
            //Max value to greter than a[i]
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    max2 = Math.max(max2, arr[j]);
                }
            }
            result = Math.max(result, max1 + arr[i] + max2);
        }
        return result;
    }

    public int maxTripletSumBS(int arr[], int n) {
        Arrays.sort(arr);//Dual-Pivot Quicksort o(nlogn)
        int sum = 0;
        return sum;
    }

    public int solve(ArrayList<Integer> A) {
        int size = A.size();
        if (size < 3) return 0;
        int maxSum = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        int maxR[] = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            if (A.get(i) > max) {
                maxR[i] = A.get(i);
                max = A.get(i);
            } else {
                maxR[i] = max;
            }
        }
        TreeSet<Integer> maxL = new TreeSet();
        maxL.add(A.get(0));
        for (int i = 1; i < size - 1; i++) {
            Integer left = maxL.lower(A.get(i));
            if (maxR[i + 1] > A.get(i) && left != null) {
                int sum = A.get(i) + left + maxR[i + 1];
                if (sum > maxSum) maxSum = sum;
            }
            maxL.add(A.get(i));
        }
        return maxSum;
    }
}
