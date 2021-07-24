package com.krishna.app.arrays;

public class MergeSortedArrays {

    //O(m*n) time complexity and 0(1) space complexity
    public void mergeWithNoExtraSpace(int[] arr1, int m, int[] arr2, int n) {
        // Iterate through all elements of arr2[] starting from
        // the last element
        for(int i = n-1; i>=0; i--){
           // Find the smallest element greater than arr2[i].
           // Move all elements one position ahead till the smallest greater element is not found */
            int j, last = arr1[m-1];
            for (j=m-2; j >= 0 && arr1[j] > arr2[i]; j--)
                arr1[j+1] = arr1[j];

            // If there was a greater element
            if (j != m-2 || last > arr2[i])
            {
                arr1[j+1] = arr2[i];
                arr2[i] = last;
            }
        }
    }

    public void mergeWhenFirstArrayHasExtraSpaces(int[] nums1, int m, int[] nums2, int n) {
        while(m > 0 && n > 0){
            if(nums1[m-1] > nums2[n-1]){
                nums1[m+n-1] = nums1[m-1];
                m--;
            }else{
                nums1[m+n-1] = nums2[n-1];
                n--;
            }
        }
        while(n > 0){
            nums1[m+n-1] = nums2[n-1];
            n--;
        }
    }

    //Time Complexity : O(m + n)
    //Auxiliary Space : O(m + n)
    public void mergeWithExtraArray(int A[], int m, int B[], int n, int C[]) {
       int i=0,j=0,k=0;
       while(i< m & j < n) {
           if(A[i] < B[j]) {
               C[k++] = A[i++];
           } else {
               C[k++] = B[j++];
           }
       }
       while(i < m) {
           C[k++] = A[i++];
       }
        while(j < n) {
            C[k++] = B[j++];
        }
    }

    public static void main(String[] args) {
        int arr1[] = new int[]{1,2,3,0,0,0};
        int arr2[] = new int[]{2,5,6};
       /* int arr1[] = new int[]{2, 3, 8, 13};
        int arr2[] = new int[]{1, 5, 9, 10, 15, 20};*/
        MergeSortedArrays mergeSortedArrays = new MergeSortedArrays();
        mergeSortedArrays.mergeWhenFirstArrayHasExtraSpaces(arr1, 3, arr2, arr2.length);
        System.out.println("done");
    }
}
