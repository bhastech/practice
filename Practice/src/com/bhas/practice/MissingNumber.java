package com.bhas.practice;

public class MissingNumber {

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,4,5,6,7,8,9};

        findMissing(arr);
    }

    private static void findMissing(int[] arr) {
        int i, X = 0,Y = 0, n = arr.length;
        for (int ar : arr) {
            System.out.print("value : "+ar);
            X ^= ar;
            System.out.println(" value after XOR "+X);
        }
        System.out.println("===============");
        for(i=1;i<=n;i++){
            System.out.print("value : "+i);
            Y ^= i;
            System.out.println(" value after XOR "+Y);
        }
        System.out.print("Missing Number : ");
        System.out.println(X ^ Y);

    }

}
