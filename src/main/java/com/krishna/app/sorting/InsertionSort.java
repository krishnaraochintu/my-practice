package com.krishna.app.sorting;

public class InsertionSort {
    //Time Complexity 0(n2)
    // Space Complexity 0(1)
    //Sort each element with in left of its. like fixing cards
    void insertionSort(int arr[]) {
        for(int i =1; i < arr.length; i++) {
            int key = arr[i];
            int j = i -1;
            while (j >=0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
}
