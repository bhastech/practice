package com.bhas.practice.array_selected;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String st = "abbac";

        String palindromicSubstring = new LongestPalindromicSubstring().findLongestPalindromicSubstring(st);

        System.out.println(palindromicSubstring);


    }

    private String findLongestPalindromicSubstring(String st) {
        if(st == null || st.length() < 1){
            return "";
        }

        int start = 0, end = 0;
        for(int i=0;i< st.length();i++){
            int length1 = expendFromMiddle(st, i, i);
            //System.out.println("Length1 :"+length1);
            int length2 = expendFromMiddle(st, i, i+1);
            //System.out.println("Length2 :"+length2);
            int len = Math.max(length1, length2);
            if(len > (end - start)){
                start = i - ((len -1)/2);
                end = i + (len/2);
            }
        }
        return st.substring(start, end + 1);
    }

    private int expendFromMiddle(String s,int left, int right){
        if(s == null || left > right){
            return 0;
        }

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return right - left - 1;
    }
}
