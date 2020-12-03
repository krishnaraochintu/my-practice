package com.krishna.app.sorting;

import com.krishna.app.CArrayUtils;

public class Quicksort {
    //Used by Arrays.sort() for primitives
    //	Ω(n log(n))	θ(n log(n))	O(n^2) (Best, Average, Worest)
    public static void main(String[] args) {
        int array[] = {10, 80, 30, 90, 40, 50, 70};
        //int array[] = {50, 23, 9, 18, 61, 32};
        CArrayUtils.printArray(array, "Input");
        Quicksort quicksort = new Quicksort();
        quicksort.sort(array, 0, array.length-1);
    }

    public void sort(int[] array, int low, int high) {
        if(low < high) {
            int pivotIndex  =  partition(array, low, high);
            sort(array, low, pivotIndex-1);
            sort(array, pivotIndex+1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for(int j = low; j < high; j++) {
            if(array[j] < pivot) {
                i++; //i moves when smaller element found only
                if(i != j) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        //Swap pivot
        int pivotIndex = i+1;
        int temp = array[pivotIndex];
        array[pivotIndex] = array[high];
        array[high] = temp;
        return pivotIndex;
    }
}
