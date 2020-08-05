package com.bhas.practice.Array;

import java.util.Arrays;

public class FindProductWithoutDivOperator {

    public static void main(String[] args) {
        /**
        * Input : {1,2,3,4,5}
         * o/p: {120,60,40,30,24}
        * */

        findProduct(new int[]{1,2,3,4,5});

    }

    private static void findProduct(int[] arr) {
        System.out.println(Arrays.toString(arr));

        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;

        for(int i=1;i<n;i++){
            left[i] = arr[i-1] * left[i-1];
        }

        System.out.println(Arrays.toString(left));

        right[n-1] = 1;

        for(int j = n-2; j>=0; j--){
            right[j] = arr[j+1] * right[j+1];
        }

        System.out.println(Arrays.toString(right));

        for(int i=0;i<n;i++){
            arr[i] = left[i] * right[i];
        }

        System.out.println(Arrays.toString(arr));
    }

}
