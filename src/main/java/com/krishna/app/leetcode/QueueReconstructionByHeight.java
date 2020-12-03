package com.krishna.app.leetcode;

import com.krishna.app.CArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class QueueReconstructionByHeight {
    public static void main(String[] args) {
        //h: hight, k: number of people infront.
        //int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] people =  {{9,0},{7,0},{1,9},{3,0},{2,7},{5,3},{6,0},{3,4},{6,2},{5,2}};
        CArrayUtils.print2DArray(people, false, "Input");
        QueueReconstructionByHeight obj = new QueueReconstructionByHeight();
        obj.reconstructQueue(people);
    }

    public int[][] reconstructQueue(int[][] people) {
        int[][] result = new int[people.length][];
        // Arrays.sort uses dual pivot Quicksort for primitive types and mergesort for objects .
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                if(a1[0] != a2[0]) {//hight
                    return a2[0] - a1[0]; //to sort hight high to low
                } else {//hight equals
                    return a1[1] - a2[1]; // to sort position low to hight
                }
            }
        });
        CArrayUtils.print2DArray(people,false, "Sorted");
        //Insert elements into thier positions defined by k.
        ArrayList<int[]> tempList = new ArrayList<int[]>();
        for(int i=0; i < people.length; i++){
            int[] arry = people[i];
            tempList.add(arry[1], arry);
        }
        CArrayUtils.print2DArrayList(tempList, false, "Kth Positioned");
        return tempList.toArray(new int[tempList.size()][]);
       /* for(int i = 0; i < people.length; i++){
            result[i] = tempList.get(i);
        }
        CArrayUtils.print2DArray(result,false, "Result");
        return result;*/
    }
}
