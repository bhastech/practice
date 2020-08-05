package com.bhas.practice.array_selected;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReconstructQueue {

    public static void main(String[] args) {
        //[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]
        int[][] length = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        new ReconstructQueue().reconstructQueue(length);

    }

//    public int[][] reconstructQueue(int[][] people) {
//        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]); // nlogn
//        List<int[]> list = new ArrayList<int[]>();
//        for (int[] p : people) { // n
//            list.add(p[1], p); // n
//        }
//
//        return list.toArray(new int[list.size()][]);
//    }

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int [] b){
                return a[0] == b[0] ? a[1] - b[1] :b[0] - a[0];
            }
        });
        //
        List<int[]> list = new ArrayList<int[]>();

        for(int[] p : people){
            list.add(p[1], p);
        }



        return list.toArray(new int[list.size()][]);
    }

}
