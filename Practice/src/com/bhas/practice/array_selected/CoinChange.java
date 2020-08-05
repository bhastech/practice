package com.bhas.practice.array_selected;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        int[][] dpArray = new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            Arrays.fill(dpArray[i], -1);
        }
        int count = getCoinChange(coins, 0, amount, dpArray);
        System.out.println(count);
    }

    private static int getCoinChange(int[] coins, int i, int amount, int[][] dpArray) {
        if(amount == 0){
            return 1;
        }
        if(amount < 0 || i == coins.length){
            return 0;
        }
        if(dpArray[i][amount] != -1){
            return dpArray[i][amount];
        }
        return dpArray[i][amount] = getCoinChange(coins, i , amount - coins[i], dpArray) + getCoinChange(coins, i +1, amount, dpArray);
    }


}
