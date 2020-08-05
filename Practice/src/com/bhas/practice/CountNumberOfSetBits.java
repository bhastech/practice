package com.bhas.practice;

public class CountNumberOfSetBits {
    static boolean a;
    public static void main(String[] args) {

        countSetBits(13);


        System.out.println(a);

    }

    private static void countSetBits(int n) {

        int count = 0;

        while(n>0){
            n &= (n-1);
            System.out.println(n);
            count++;
        }

        System.out.println(count);

    }


}
