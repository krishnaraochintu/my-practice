package com.krishna.app;

import java.util.ArrayList;

public class CArrayUtils {

    public static void printArray(int[] array, String message) {
        System.out.print(message + " : ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
    }
    public static void print2DArray(int[][] array, boolean newLine, String message) {
        System.out.print(message+" : ");
        for(int i = 0; i < array.length; i++) {
            System.out.print("{");
            for(int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
                if(j < array[j].length) System.out.print(",");
            }
            System.out.print("}");
            if(newLine) System.out.println(); else System.out.print(", ");;
        }
        System.out.println();
    }

    public static void print2DArrayList(ArrayList<int[]> tempList, boolean newLine, String message) {
        System.out.print(message+" : ");
        for(int i =0; i < tempList.size(); i++) {
            System.out.print("[");
            for(int j = 0; j < tempList.get(i).length; j++) {
                System.out.print(tempList.get(i)[j]);
                if(j < tempList.get(i).length) System.out.print(",");
            }
            System.out.print("]");
            if(newLine) System.out.println(); else System.out.print(", ");;
        }
        System.out.println();
    }
}
