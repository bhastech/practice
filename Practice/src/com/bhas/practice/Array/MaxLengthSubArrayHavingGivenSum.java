package com.bhas.practice.Array;

import java.util.HashMap;
import java.util.Map;

public class MaxLengthSubArrayHavingGivenSum {

    public static void main(String[] args) {

        int[] arr = new int[]{5, 6, -5, 5, 3, 5, 3, -2, 0};
        int sum = 8;

        printSubArrayHavingGivenSum(arr, sum);
    }

    private static void printSubArrayHavingGivenSum(int[] arr, int sum) {

        Map<Integer, Integer> m = new HashMap<>();

        int sumTillHere = 0, length = 0, endingIndex = -1;

        for (int i = 0; i < arr.length; i++) {

            sumTillHere += arr[i];

            if(!m.containsKey(sumTillHere)){
                m.put(sumTillHere, i);
            }

            if(m.containsKey(sumTillHere - sum) && length < i-m.get(sumTillHere - sum)){
                length = i-m.get(sumTillHere - sum);
                endingIndex = i;
            }
        }

        System.out.println("Max Length SubArray Having sum ::  "+sum+" , is from Index : "+(endingIndex-length+1)+" to Index : "+endingIndex);
    }

}
