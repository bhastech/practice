package com.bhas.practice.Array;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ArrayPairs {

    public static void main(String[] args) {
//        solve(new int[]{1, 1, 2, 4, 2});
//196
        String st = "1259 7119 6806 8924 8114 3797 6788 3735 6695 7189 5028 2092 8103 2206 3708 7873 7572 6687 8652 7282 3277 6846 9332 3435 6719 8943 8622 1840 792 372 7334 6099 4784 1117 7044 2315 7991 9596 8895 4576 8722 3612 4586 5883 2433 7285 6223 2580 7573 3117 8165 3342 3357 2769 6344 5067 8755 2049 7195 215 5323 7070 8046 2686 2440 8114 1011 3693 5668 5489 6513 9594 9506 1313 1374 3290 7590 5154 2654 4843 7988 3580 7873 6744 6768 3804 5554 3562 2627 4922 1801 9958 5989 6788 3859 6487 5699 4447 9750 9274 2482 7863 9630 8583 98 4567 3306 4633 1010 9373 9404 213 1087 7753 172 8286 1648 9423 4179 2283 4208 5196 7697 1195 7448 6118 6454 8352 3741 1759 2582 6717 7911 6371 7448 4392 6023 7352 5916 963 5821 5840 2376 7848 3711 7953 8138 6278 8253 1171 3208 257 3919 7908 6496 9360 1350 3414 9776 8611 2276 9385 3363 8577 4775 7425 9991 812 5321 5080 7370 8739 9474 590 915 4026 8163 5482 2941 4770 668 9511 8508 3446 6225 5190 4645 7699 8662 6298 1630 1712 4531 9834 5709 5779 9190 7009 6062 2740 5774 9232 7426 6612 676 8336 807";
        String[] ss = st.split(" ");
        int length = st.split(" ").length;
        int[] in = new int[length];
        for(int i=0 ;i<length;i++){
            in[i] = Integer.parseInt(ss[i]);
        }
        solve(in);
    }

    static long solve(int[] arr) {

        long maxInArray = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (maxInArray < arr[i]) {
                maxInArray = arr[i];
            }
        }
        int finalCount = 0;
        for (int i = 0; i < arr.length; i++) {

            for (int j = i+1; j < arr.length; j++) {
                long currPair = arr[i] * arr[j];
                if (currPair <= maxInArray) {
                    finalCount++;
                }
            }
        }
        System.out.println(finalCount);
        return finalCount;
    }
}
