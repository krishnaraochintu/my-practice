package com.krishna.app.sorting;

import com.krishna.app.CArrayUtils;

public class MergeSort {
    public static void main(String[] args) {
        int array[] = {10, 80, 30, 90, 40, 50, 70};
        //int array[] = {50, 23, 9, 18, 61, 32};
        CArrayUtils.printArray(array, "Input");
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(array, 0, array.length-1);
        System.out.println(array);
    }

    private void mergeSort(int[] array, int start, int end) {
        if(start < end) {
            int mid = (start + end)/2;
            mergeSort(array, start, mid);
            mergeSort(array, mid+1, end);
            mergeWithOutArrays(array, start, mid, end);
        }
    }

    private void merge(int[] array, int start, int mid, int end) {
        int leftArrayLength = mid - start + 1;
        int rightArryLength = end - mid;
        int leftArray[] = new int[leftArrayLength];
        int righArray[] = new int[rightArryLength];
        for(int i = 0; i < leftArrayLength; i++) {
            leftArray[i] = array[i];
        }
        for(int j = 0; j < rightArryLength; j++) {
            righArray[j] = array[mid+1+j];
        }
        int i=0, j=0, k=0;
        while(i < leftArrayLength && j < rightArryLength) {
            if(leftArray[i] <= righArray[j]) {
                array[k] = leftArray[i];
                i++; k++;
            } else {
                array[k] = righArray[j];
                j++; k++;
            }
        }
        while (i < leftArrayLength) {
            array[k] = leftArray[i];
            i++;k++;
        }
        while (j < rightArryLength) {
            array[k] = righArray[j];
            j++;k++;
        }
    }

    private void mergeWithOutArrays(int[] array, int start, int mid, int end) {
        int temp[] = new int[end-start+1];
        int i = start, j = mid+1, k =0;
        while(i <= mid && j <= end) {
            if(array[i] <= array[j]) {
                temp[k] = array[i];
                i++; k++;
            } else {
                temp[k] = array[j];
                j++; k++;
            }
        }
        while (i <= mid) {
            temp[k] = array[i];
            i++;k++;
        }
        while (j <= end) {
            temp[k] = array[j];
            j++;k++;
        }
        for(i = start; i <= end; i++) {
            array[i] = temp[i - start];
        }
    }
}
