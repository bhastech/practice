package com.bhas.practice.array_selected;

public class ReverseInteger {

    public static int reverse(int x) {
        boolean isNegative = false;
        if(x < 0){
            x = -x;
            isNegative = true;
        }
        int result = 0;
        int prevResult = 0;
        while(x > 0){
            int carry = x % 10;

            result = (result * 10) + carry;

            if((result - carry)/10 != prevResult ){
                return 0;
            }

            prevResult = result;

            x = x/10;
        }

        return isNegative? -result :result ;

    }

    public static void main(String[] args) {
        reverse(1000000045);
    }
}
