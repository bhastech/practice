package com.bhas.practice.graphs;

//MMT
public class CountNumberOfConnectedIslends {

    final static int[] offsets = {-1, 0, +1};

    public static void main(String[] args) {

        int[][] arr = new int[][]{
                {1, 1, 0, 1, 1, 0},
                {1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 0},
                {1, 1, 0, 0, 0, 0}
        };

        int numberOfIslends = new CountNumberOfConnectedIslends().findConnectedIslends(arr);
        System.out.println("numberOfIslends :: " + numberOfIslends);

        int islandsCount = countIslands(arr);

        System.out.println("Islands count :: " + islandsCount);
    }

    private static int countIslands(int[][] arr) {

        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    count++;
                    doDFS(arr, i, j);
                }
            }

        }
        return count;
    }

    private static void doDFS(int[][] arr, int i, int j) {
        //Boundary condition check
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[i].length || arr[i][j] == 0) {
            return;
        }
        arr[i][j] = 0;
        doDFS(arr, i + 1, j);
        doDFS(arr, i - 1, j);
        doDFS(arr, i, j - 1);
        doDFS(arr, i, j + 1);

    }

    private int findConnectedIslends(int[][] arr) {

        boolean[][] isVisited = new boolean[arr.length][arr[0].length];

        int totalCount = 0;

        for (int i = 0; i < arr.length; i++) {
            //
            for (int j = 0; j < arr[0].length; j++) {
                //
                if (arr[i][j] == 1 && !isVisited[i][j]) {
                    ++totalCount;
                    dfs(arr, i, j, isVisited);
                }
            }
        }

        return totalCount;
    }

    private void dfs(int[][] arr, int i, int j, boolean[][] isVisited) {

        if (isVisited[i][j]) {
            return;
        }

        isVisited[i][j] = true;

        int xOffset, yOffset;

        for (int ii = 0; ii < offsets.length; ii++) {
            xOffset = offsets[ii];
            //
            for (int jj = 0; jj < offsets.length; jj++) {
                yOffset = offsets[jj];
                //
                if (xOffset == 0 && yOffset == 0) {
                    continue;
                }

                //
                if (isNeighborExists(arr, i + xOffset, j + yOffset)) {
                    dfs(arr, i + xOffset, j + yOffset, isVisited);
                }
            }
        }

    }

    private boolean isNeighborExists(int[][] arr, int i, int j) {
        if ((i >= 0 && i < arr.length) && (j >= 0 && j < arr[0].length)) {
            if (arr[i][j] == 1) {
                return true;
            }
        }
        return false;
    }

}
