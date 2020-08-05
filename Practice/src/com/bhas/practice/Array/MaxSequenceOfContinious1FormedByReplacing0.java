package com.bhas.practice.Array;

public class MaxSequenceOfContinious1FormedByReplacing0 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,0,1,1,0,1,1,1,1,0,0};
        int k = 2;
        findMaxLenOfContinios1ByReplacingZeroOfSizeK(arr, k);
    }

    private static void findMaxLenOfContinios1ByReplacingZeroOfSizeK(int[] arr, int k) {
        int wLeft = 0;
        int wRight = 0;
        int bestWindow = 0;

        int zeroCount = 0;

        while(wRight < arr.length){

            if(zeroCount <= k){
                if(arr[wRight] == 0){
                    zeroCount++;
                }
                wRight++;
            }

            if(zeroCount > k){
                if(arr[wLeft] == 0){
                    zeroCount--;
                }
                wLeft++;
            }

            if(wRight-wLeft > bestWindow && zeroCount <= k){
                bestWindow = wRight - wLeft;
//                bestLeft = wLeft;
            }
        }

        System.out.println("Max length by replacing "+k+" zeros : is : "+bestWindow);
    }

}
