package com.krishna.app.sorting;

import com.krishna.app.test.CArrayUtils;

public class SelectionSort {
    public static void main(String[] args) {
        int array[] = {64,25,12,22,11};
        CArrayUtils.printArray(array, "Input");
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(array);
    }
    void sort(int array[]) {
     int n = array.length;
     for(int i = 0; i < n-1; i++) { //Find Minimum Element.
            int min_index = i;
            for(int j = i+1; j < n; j++) {
                if(array[j] < array[min_index]) {
                    min_index = j;
                }
            }
            //Swap Elements.
            int temp = array[i];
            array[i] = array[min_index];
            array[min_index] = temp;
       }
     CArrayUtils.printArray(array, "output");
    }
}
