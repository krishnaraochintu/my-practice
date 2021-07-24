package com.krishna.app.lc;

public class ClimbingStairs {

    //Time : 0(2~n), Space : 0(n)
    public int climbStairsBFRecursion(int n) {
        return climbStairsBFRecursion(0, n);
    }
    public int climbStairsBFRecursion(int i, int n) {
        if(i > n) {
            return 0;
        }
        if(i == n) {
            return 1;
        }
        return climbStairsBFRecursion(i+1, n) + climbStairsBFRecursion(i+2, n);
    }
    //Time : 0(n), Space : 0(n)
    public int climbStairsRecursion(int n) {
        int memo[] = new int[n + 1];
        return climbStairsRecursion(0, n, memo);
    }

    //Time : 0(n), Space : 0(n)
    private int climbStairsRecursion(int i, int n, int[] memo) {
        if(i > n) {
            return 0;
        }
        if(i == n) {
            return 1;
        }
        if(memo[i] > 0) {
            return memo[i];
        }
        memo[i] =  climbStairsRecursion(i+1, n, memo) + climbStairsRecursion(i+2, n, memo);
        return memo[i];
    }

    //Time : 0(n), Space : 0(n)
    public int climbStairsDP(int n) {
        if(n == 1){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <=n; i++) {
            dp[i]  = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    //Time : 0(n), Space : 0(1)
    public int climbStairsWithFibonacci(int n) {
        if(n == 1){
            return 1;
        }
        int first = 1;
        int second = 2;
        for(int i =3 ;i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    public int climbStairs(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }
    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        climbingStairs.climbStairs(5);
    }
}
