package com.bhas.practice.Array;

public class HourGlass {

    public static void main(String[] args) {
        /*
        *
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0



-2 -1 -6 -8 -2 -5
-1 -1 -1 -2 -3 -4
-1 -9 -2 -4 -4 -5
-7 -3 -3 -2 -9 -9
-1 -3 -1 -2 -4 -5
        * */
        int[][] arr = new int[][]{  {1 ,1, 1, 0, 0, 0},
                                    {1, 1, 1, 0, 0, 0},
                                    {0, 0, 2, 4, 4, 0},
                                    {0, 0, 0, 2, 0, 0},
                                    {0, 0, 1, 2, 4, 0}};

        int[][] input1 = new int[][]{{-1 ,-1, 0, -9, -2, -2},
                                     {-1, -1, -1, -2, -3, -4},
                                     {-2 ,-1 ,-6, -8, -2, -5},
                                     {-1, -9, -2, -4, -4, -5},
                                     {-7, -3, -3, -2, -9, -9},
                                     {-1, -3, -1, -2, -4, -5}};

        int hourGlass = calculateHourGlass(input1);
    }


    private static int calculateHourGlass(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        int finalHourGlass = Integer.MIN_VALUE;
        for(int i=0;i<=row-3;i++){
            for(int j=0;j<=col-3;j++){
                int hourGlass = 0;
                int row1Sum = arr[i][j]+arr[i][j+1]+arr[i][j+2];
                int row2Sum = arr[i+1][j+1];
                int row3Sum = arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
                hourGlass = row1Sum+row2Sum+row3Sum;
                System.out.println(hourGlass);
                if(finalHourGlass < hourGlass){
                    finalHourGlass = hourGlass;
                }
            }
        }
        return finalHourGlass;
    }
}
