package com.bhas.practice;

public class RatOnMaze {

    public static void main(String[] args) {

        int[][] maze={
                {1,0,0,1},
                {1,1,0,0},
                {1,1,1,0},
                {0,1,1,1}};
        int[][] validationMatrix = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        countPath(maze, 4, validationMatrix, 0);


    }

    private static void countPath(int[][] maze, int TOTAL_ROW_COLUMNS, int[][]
            validationMatrix, int count) {

        int startingRowIndex = 0;
        int startingColIndex = 0;

        System.out.println(countPath(maze, TOTAL_ROW_COLUMNS, validationMatrix, count, startingRowIndex, startingColIndex));

    }

    private static int countPath(int[][] maze, int total_row_columns, int[][] validationMatrix, int count, int startingRowIndex, int startingColIndex) {

        if(startingRowIndex == total_row_columns-1 && startingColIndex == total_row_columns-1){
            //reached till end
            count++;
            return count;
        }

        validationMatrix[startingRowIndex][startingColIndex] = 1;

        if(isSafeToMove(maze, startingRowIndex, startingColIndex)){


            if(startingRowIndex < total_row_columns-1 && validationMatrix[startingRowIndex+1][startingColIndex]!=1){
                count = countPath(maze,total_row_columns,validationMatrix, count,startingRowIndex+1, startingColIndex);
            }

            if(startingColIndex < total_row_columns-1 && validationMatrix[startingRowIndex][startingColIndex+1]!=1){
               count =  countPath(maze,total_row_columns,validationMatrix, count,startingRowIndex, startingColIndex+1);
            }
        }

        //backtrack
        validationMatrix[startingRowIndex][startingColIndex] = 0;

        return count;
    }

    private static boolean isSafeToMove(int[][] maze, int startingRowIndex, int startingColIndex) {
        return startingRowIndex>=0 && startingRowIndex<4 && startingColIndex>=0 && startingColIndex<4 && maze[startingRowIndex][startingColIndex]==1;
    }


}
