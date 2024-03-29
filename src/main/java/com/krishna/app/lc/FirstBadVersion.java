package com.krishna.app.lc;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int left  = 1;
        int right = n;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    boolean isBadVersion(int version) {
        return version == 2 ? true : false;
    }

    public static void main(String[] args) {
        FirstBadVersion firstBadVersion = new FirstBadVersion();
        firstBadVersion.firstBadVersion(2);
    }
}
