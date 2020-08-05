package com.bhas.practice;

public class RemoveAdjecent {

    public static void main(String[] args) {
//        System.out.println(removeAdj("abcbbccddcbe"));
        //"a
        // e"
//
//        int ac = (1939 * 10) / 100;
//        double d = 10;
//
//        int a = (int)Math.round((1939) * (d/100));
//
//        System.out.println(a);
//
//        System.out.println(Math.round((4 * 10) / 100.0));
//
//        System.out.println(ac);


    }

    private static String removeAdj(String str) {
       return removeAdj(str, '\n');
    }

    private static String removeAdj(String str, char last_removed) {

        if(str.length()==0 || str.length()==1){
            return str;
        }

        if(str.charAt(0) == str.charAt(1)){
            last_removed = str.charAt(0);

            while(str.length()>1 && str.charAt(0)==str.charAt(1)){
                str = str.substring(1,str.length());
            }
            str = str.substring(1,str.length());
            return removeAdj(str, last_removed);
        }

        System.out.println(str);

        String remaingString = removeAdj(str.substring(1, str.length()));

        System.out.println(remaingString);

        if (remaingString.length() != 0 && remaingString.charAt(0) == str.charAt(0))
        {
            last_removed = str.charAt(0);
            return remaingString.substring(1,remaingString.length()); // Remove first character
        }

        if (remaingString.length() == 0 && last_removed == str.charAt(0))
            return remaingString;

        // If the two first characters of str and rem_str don't match,
        // append first character of str before the first character of
        // rem_str

        System.out.println((str.charAt(0) + remaingString));
        return (str.charAt(0) + remaingString);

    }

}
