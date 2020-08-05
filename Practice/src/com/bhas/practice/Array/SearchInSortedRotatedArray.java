package com.bhas.practice.Array;


import java.util.concurrent.CompletableFuture;

public class SearchInSortedRotatedArray {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, 7, 8, 9, 10, 1, 2, 3};
        int elementToSearch = 9;

        int index = find(arr, 0, arr.length - 1, elementToSearch);

        System.out.println("Find index for element : "+elementToSearch+" at : "+index);

    }

    private static int find(int[] arr, int low, int high, int elementToSearch) {

        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (arr[mid] == elementToSearch) {
            return mid;
        }
        //First half is sorted
        if (arr[low] <= arr[mid]) {

            if (elementToSearch > arr[low] && elementToSearch <= arr[mid]) {
                return find(arr, low, mid - 1, elementToSearch);
            }
            //Check in other half
            return find(arr, mid + 1, high, elementToSearch);
        }
        //Other half is sorted
        else {
            if (elementToSearch >= arr[mid] && elementToSearch <= arr[high]) {
                return find(arr, mid + 1, high, elementToSearch);
            }
            return find(arr, low, mid - 1, elementToSearch);
        }

    }


    private int search(int arr[], int low, int high, int element){
        if(low > high){
            return -1;
        }

        int mid = (high - low)/2;

        if(arr[mid] == element){
            return mid;
        }

        if(arr[low] <= arr[mid]){
            if(element > arr[low] && element <= arr[mid]){
                return search(arr, low, mid -1, element);
            }
            return search(arr, mid+1, high, element);
        }else{
            if(element>=arr[mid] && element <= arr[high]){
                return search(arr, mid+1, high, element);
            }
            return search(arr, mid-1, high, element);
        }
    }
}
