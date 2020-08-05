package com.bhas.practice.Array;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(rotLeft(arr, 4)));
    }

    static int[] rotLeft(int[] arr, int d) {

        int[] tempArray = new int[arr.length];
        StringBuilder output = new StringBuilder();
        for(int i = 0; i< arr.length; i++) {
            System.out.println((i+d) % arr.length);
            tempArray[i] = arr[(i+d) % arr.length];
            output = output.append(tempArray[i]).append(" ");
            System.out.println(output);

        }

        System.out.println(output);



        if(arr.length == 0){
            return null;
        }
//        int[] tempArray = new int[arr.length];
//
//        for (int i = 0;i<tempArray.length;i++){
//            int index = (i + (tempArray.length - d ))% tempArray.length;
//            System.out.println(index);
//            System.out.println(Arrays.toString(tempArray));
//            tempArray[i] = arr[index];
//            System.out.println(Arrays.toString(tempArray));
//        }
        return tempArray;
    }

}
