package com.bhas.practice.array_selected;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindPairWithGivenSum {

    public static void main(String[] args) {
//        int[] arr = new int[]{1, 4, 45, 6, 10, -8};
//        int sum = 16;
//        //Method 1 : By sorting the array
//        findPairs(arr, sum);
//        //Method 2 : Using Hashmap
//        findPairsUsingMap(arr, sum);

        int suborderAmount = 357;
        int subscriptionCharge = 199;

        int total  = 558;

        int sc = 59;
        int cc = 499;
//int amount = (int) (suborder.getSuborderAmount() * ((float) transaction.getPaymentAmount() / orderPaidAmount));
        int subscriptionSC = (int) (sc * ((float) subscriptionCharge / total));//(sc*subscriptionCharge/total);
        int subscriptionCC =  (int) (cc * ((float) subscriptionCharge / total));//(cc*subscriptionCharge/total);

        System.out.println("subscriptionSC : "+subscriptionSC+" subscriptionCC : "+subscriptionCC + "(float) subscriptionCharge / total) : "+Math.round(cc*((float) subscriptionCharge / total)));
    }

    private static void findPairsUsingMap(int[] arr, int sum) {
        Set<Integer> set = new HashSet<>();

        for (int i =0; i< arr.length ; i++) {
            int temp = sum - arr[i];

            if(set.contains(temp)){
                System.out.println("Pair for given sum is : "+temp+" and "+arr[i]);
            }
            set.add(arr[i]);
        }

    }

    private static void findPairs(int[] arr, int sum) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length-1;

        while(left < right){
            if(arr[left] + arr[right] == sum){
                System.out.println("Found pair for given sum : "+arr[left]+" , "+arr[right]);
                break;
            }else if(arr[left] + arr[right] < sum){
                left ++;
            }else{
                right --;
            }
        }
    }

}
