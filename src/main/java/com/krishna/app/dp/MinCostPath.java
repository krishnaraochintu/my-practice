package com.krishna.app.dp;

public class MinCostPath {
    /* A utility function that returns minimum of 3 integers */
    private static int min(int x, int y, int z) {
        if (x < y)
            return (x < z) ? x : z;
        else
            return (y < z) ? y : z;
    }

    private static int minCostRecursive(int cost[][], int m, int n) {
        if (m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        }
        if (m == 0 && n == 0) {
            return cost[0][0];
        }
        return cost[m][n] + min(minCostRecursive(cost, m - 1, n - 1),
                minCostRecursive(cost, m - 1, n),
                minCostRecursive(cost, m, n - 1));
    }

    private static int minCost(int cost[][], int m, int n) {
        int i, j;
        int tc[][] = new int[m + 1][n + 1];

        tc[0][0] = cost[0][0];

        /* Initialize first column of total cost(tc) array */
        for (i = 1; i <= m; i++)
            tc[i][0] = tc[i - 1][0] + cost[i][0];

        /* Initialize first row of tc array */
        for (j = 1; j <= n; j++)
            tc[0][j] = tc[0][j - 1] + cost[0][j];

        /* Construct rest of the tc array */
        for (i = 1; i <= m; i++)
            for (j = 1; j <= n; j++)
                tc[i][j] = min(tc[i - 1][j - 1],
                        tc[i - 1][j],
                        tc[i][j - 1]) + cost[i][j];

        return tc[m][n];
    }

    private static int minCostWithSameArray(int cost[][], int m, int n) {
        int rows = 3;
        int columns = 3;

        for (int i = 1; i < 3; i++) {
            cost[i][0] = cost[i][0] + cost[i - 1][0];
        }
        for (int j = 1; j < 3; j++) {
            cost[0][j] = cost[0][j] + cost[0][j - 1];
        }
        for (int i = 1; i < 3; i++) {
            for (int j = 1; j < 3; j++){
                cost[i][j] = cost[i][j] + min(cost[i-1][j-1], cost[i][j-1], cost[i-1][j]);
            }
        }
        return cost[m][n];
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        int cost[][] = {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};
        System.out.println(minCostRecursive(cost, 1, 1));
        System.out.println(minCost(cost, 1, 1));
        System.out.println(minCostWithSameArray(cost, 1, 1));
    }
}
