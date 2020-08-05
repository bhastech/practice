package com.bhas.practice.array_selected;

public class LengthOfLongestSubstringWithoutDuplicates {

    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int[] mem = new int[128];
        int maxLength = 0;

        while (right < s.length()) {
            if (mem[s.charAt(right)] > 0) {
                mem[s.charAt(left)]--;
                left++;
            } else {
                mem[s.charAt(right)]++;
                right++;
                maxLength = Math.max(maxLength, right - left);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
//        int length = new LengthOfLongestSubstringWithoutDuplicates().lengthOfLongestSubstring("abcabcs");
//        System.out.println(length);
//        System.out.println(isPowerOfTwo(218));
        System.out.println(increasingTriplet(new int[]{2,1,5,0,4,6}));
    }

    public static boolean isPowerOfTwo(int n) {
        if(n == 1){
            return true;
        }
        if(n < 1){
            return false;
        }

        while(n > 0){
            int temp = n % 2;
            if(n == 1 || n ==2){
                return true;
            }
            if(temp == 1){
                return false;
            }
            if(temp == 0){
                n = n /2;
            }
        }
        return false;
    }
    public static boolean increasingTriplet(int[] nums) {

        if(nums.length < 3 ){
            return false;
        }

        int num1 = -1;
        int num2 = -1;
        int num3 = -1;

        boolean tripletExists = false;
        for(int i = 0;i<nums.length;i++){
            if(num1 < nums[i]){
                num1 = nums[i];
            }
            if(i+1 < nums.length && num2 < nums[i+1]){
                num2 = nums[i+1];
            }
            if(i+2 < nums.length && num3 < nums[i+2]){
                num3 = nums[i+2];
            }
        }
        if(num1 < num2 && num2 < num3){
            tripletExists = true;
        }
        return tripletExists;
    }
}
