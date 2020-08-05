package com.bhas.practice.Array;

import java.util.Arrays;

public class ArrayManipulation {

    public static void main(String[] args) {
        /*
        * 1 2 100
2 5 100
3 4 100
        * */
        int[][] queries = new int[][]{{2 ,3 ,603},{1 ,1 ,286},{4 ,4 ,882}};
        System.out.println(arrayManipulation(4, queries));
    }

    static long arrayManipulation(int n, int[][] queries) {
//        long tempArray[][] = new long[queries.length+1][n];
//        long maxTillNow = 0;
//        for(int i=0;i<queries.length;i++){
//            for(int j=0;j<n;j++){
//                long from = queries[i][0]-1;
//                long to = queries[i][1]-1;
//                long k = queries[i][2];
//                if(j>=from && j<=to){
//                    tempArray[i+1][j] = tempArray[i][j]+k;
//                }else{
//                    tempArray[i+1][j] = tempArray[i][j];
//                }
//                if(maxTillNow < tempArray[i+1][j] ){
//                    maxTillNow = tempArray[i+1][j];
//                }
//            }
//        }
//        System.out.println(maxTillNow);
        //
        long temp[] = new long[n+2];
        for(int i=0;i<queries.length;i++){
            int from = queries[i][0];
            int to  = queries[i][1];
            int k  = queries[i][2];
            temp[from] += k;
            temp[to+1] -= k;
        }
        System.out.println(Arrays.toString(temp));
        long max = 0l;
        int i =0;
        long maxTillNow = 0;
        for (long l : temp) {
            max+=l;
            temp[i] = max;
            i++;
            if(maxTillNow<max){
                maxTillNow = max;
            }
        }
//        System.out.println(Arrays.toString(temp));

        //
        return maxTillNow;
    }

}
