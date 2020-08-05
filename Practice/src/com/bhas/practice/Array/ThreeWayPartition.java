package com.bhas.practice.Array;


import java.util.Arrays;

public class ThreeWayPartition {

    public static void main(String[] args) {

        int arr[] = new int[]{0, 2, 1, 0, 1, 2, 0, 0, 0, 1, 1, 1, 2, 0, 1, 1, 2, 0, 1, 1};
        threeWayPartition(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void threeWayPartition(int[] arr) {

        int start = 0, mid = 0, pivot = 1, end = arr.length - 1;

        while (mid <= end) {
            if (arr[mid] < pivot) {
                swap(arr, start, mid);
                start++;
                mid++;
            } else if (arr[mid] > pivot) {
                swap(arr, mid, end);
                end--;
            } else {
                mid++;
            }
        }

    }

    private static void swap(int[] arr, int start, int mid) {
        int temp = arr[start];
        arr[start] = arr[mid];
        arr[mid] = temp;
    }

}
