package com.krishna.app.arrays;

public class MedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m != 0 || n != 0) {//Merge
            for (int i = n - 1; i >= 0; i--) {
                int last = nums1[m - 1];
                int j = 0;
                for (j = m - 2; j >= 0 && nums1[j] > nums2[i]; j--) {
                    nums1[j + 1] = nums1[j];
                }
                if (last > nums2[i]) {
                    nums1[j + 1] = nums2[i];
                    nums2[i] = last;
                }
            }
        }
        boolean isEven = (nums1.length + nums2.length) % 2 == 0;
        int mid = (nums1.length + nums2.length) / 2;
        if (!isEven) {
            return (mid < nums1.length) ? nums1[mid] : nums2[nums2.length - mid - 1];
        } else {
            int i = mid - 1;
            int j = mid;
            int firstElement = (i < nums1.length) ? nums1[i] : nums2[nums2.length - i - 1];
            int secondElement = (j < nums1.length) ? nums1[j] : nums2[nums2.length - j - 1];
            return (firstElement + secondElement) / 2.0;
        }
    }

    public double findMedianSortedArraysLeetCode(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = i + 1; // i is too small
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = i - 1; // i is too big
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] num1 = {3, 4};
        int[] num2 = {5, 6, 7, 8};
        MedianSortedArrays medianSortedArrays = new MedianSortedArrays();
        double median = medianSortedArrays.findMedianSortedArrays(num1, num2);
        System.out.println(median);
    }
}
