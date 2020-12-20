package com.krishna.app.arrays;


public class SpiralOrder {
    public int[] spiralOrder(int[][] inputList) {
        int rows = inputList.length;;
        int coloumns = inputList[0].length;
        int output[] = new int[rows*coloumns];
        int dr[] = {0,1,0,-1};
        int dc[] = {1,0,-1,0};
        boolean[][] seen = new boolean[rows][coloumns];
        int di =0, r=0, c=0;
        for(int i=0; i < rows* coloumns; i++) {
            output[i] = inputList[r][c];
            seen[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
            if(0 <= cr && cr <= rows && 0 <= cc && cc < coloumns && !seen[cr][cc]) {
                r = cr;
                c = cc;
            } else {
                di = (di+1)%4;
                r = r + dr[di];
                c = c + dc[di];
            }
        }
        return output;
    }

    public int[] spiralOrder(int row, int col, int[][] inputList) {
        int output[] = new int[row*col];
        int j=0;
        int k=0;//k:-starting row index, row:m:-ending row index
        int l=0; //l:-starting column index, col:n:-ending column index
        while(k < row && l < col) {
            //First Top Row, mean Row:k is fixed
            for(int i = l; i < col; i++) {
                output[j++] = inputList[k][i];
            }
            k++;
            //Print Right Column, means Column is fixed:n-1, Row++
            for(int i = k; i < row; i++) {
                output[j++] = inputList[i][col-1];
            }
            col--;
            //Print Botton Row. Means Row is fixed:m-1, Column--
            if(k < row) {
                for(int i = col-1; i >= l; i++) {
                    output[j++] = inputList[row-1][i];
                }
                row--;
            }
            //Print Left Column. Means Row is fixed:m-1, Column--
            if(l < col) {
                for(int i = row-1; i >= k; i++) {
                    output[j++] = inputList[i][l];
                }
                l++;
            }
        }
        return output;
    }
}
