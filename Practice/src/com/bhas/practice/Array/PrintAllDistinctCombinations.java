package com.bhas.practice.Array;

public class PrintAllDistinctCombinations {

    public static void main(String[] args) {

        int k = 2;
        printAllDistinctCombinationsOfSize(new int[]{1, 2, 3}, k);
    }

    private static void printAllDistinctCombinationsOfSize(int[] arr, int k) {
        printAllDistinctCombinations(arr, "", 0, arr.length, k);
    }

    private static void printAllDistinctCombinations(int[] arr, String output, int start, int length, int k) {

        if (k > length) {
            return;
        }

        if (k == 0) {
            System.out.println(output);
            return;
        }

        for (int j = start; j < length; j++) {
            printAllDistinctCombinations(arr, output+"  " + (arr[j]), j+1, length, k-1);
        }
    }

}
