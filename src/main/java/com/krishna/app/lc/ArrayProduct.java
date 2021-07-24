package com.krishna.app.lc;

public class ArrayProduct {
    boolean isProductExists(int arr[], int n) {
        for (int i = 0; i < arr.length; i++) {
            for(int j=i; j < arr.length; j++) {
                if((arr[i] * arr[j]) == n && (i != j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        ArrayProduct arrayProduct = new ArrayProduct();
        arrayProduct.isProductExists(arr, 12);
    }
}
