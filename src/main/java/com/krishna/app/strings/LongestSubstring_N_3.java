package com.krishna.app.strings;

public class LongestSubstring_N_3 {
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println("The input string is " + str);

        int len = longestUniqueSubsttr(str);

        System.out.println("The length of the longest " +
                "non-repeating character " +
                "substring is " + len);
    }

    public static int longestUniqueSubsttr(String str) {
        int n = str.length();
         int res = 0;
         String longestString = "";
         int k = 0;
         for(int  i = 0; i < n; i++) {
             for(int j =i; j < n; j++) {
                 if(areDistinct(str, i, j)) {
                     if(j-i+1 > res) {
                         longestString = str.substring(i, j+1);
                         res = j - i + 1;
                     }

                 }
             }
         }
        System.out.println("Longest SubString "+longestString);
        return res;
    }

    private static boolean areDistinct(String str, int i, int j) {
        boolean[] visited = new boolean[26];
        for(int k = i; k <= j; k++) {
            if( visited[str.charAt(k) - 'a']  == true) {
                return false;
            }
            visited[str.charAt(k) - 'a'] = true;
        }
        return true;
    }
}
