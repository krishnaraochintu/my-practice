package com.krishna.app;

import java.util.Arrays;
import java.util.Comparator;

public class QueueReconstructionByHeight {
    public static void main(String[] args) {
        int[][] array = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
    }

    public int[][] reconstructQueue(int[][] people) {
        int[][] result = new int[people.length][];
        // Arrays.sort uses dual pivot Quicksort for primitive types and mergesort for objects .
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1 > o2) {
                    return 1;
                } else {
                    return -1
                }
                return 0;
            }
        });
    }
}
