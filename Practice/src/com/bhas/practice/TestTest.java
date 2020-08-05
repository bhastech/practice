package com.bhas.practice;

import java.math.BigDecimal;
import java.util.*;

public class TestTest {

    public static void main(String[] args) {
        //Value , than range sorting
        List<Integer> li = new ArrayList<>();
        li.add(4);
        li.add(4);
        li.add(2);
        li.add(2);
        li.add(2);
        li.add(2);
        li.add(3);
        li.add(3);
        li.add(1);
        li.add(1);
        li.add(6);
        li.add(7);
        li.add(5);
        li.add(5);
        li.add(3);
        li.add(1);
        li.add(2);
        li.add(2);
        li.add(4);

        List<Integer> li1 = new ArrayList<>();
        li1.add(5);
        li1.add(1);
        li1.add(2);
        li1.add(3);
        li1.add(4);
        li1.add(1);
        System.out.println(li1);
        int[] array = { 4, 4, 2, 2, 2, 2, 3, 3, 1, 1, 6, 7, 5 };

        customSort(li1);
//
//        missingWords("I am using hackerrank to improve programming","am hackerrank to improve");
//
//        System.out.println(fourthBit(32));
////nums
//        System.out.println(kSub(3,li1));

        Float f = 0.1F;

        System.out.println(f);;

        System.out.println(new BigDecimal(f.toString()));

        System.out.println(twoSum(new int[]{2,7,1,4}, 9));
    }

    static int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        int i = 0;
        for(int num : nums){

            int rem = target - num;

            if(map.containsKey(rem)){
                return new int[]{i, map.get(rem)};
            }else{
                map.put(num,i);
            }
            i++;
        }
        return new int[]{0,0};
    }



    public static void customSort(List<Integer> array) {
        // Write your code here
        // Assign elements and their count in the list and map
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> outputArray = new ArrayList<>();
        int ii = 0;
        for (int current : array) {
            if (ii==0){
                ii++;
                continue;
            }
            int count = map.getOrDefault(current, 0);
            map.put(current, count + 1);
            outputArray.add(current);
            ii++;
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            entry.getKey();
        }

        // Compare the map by value
        SortComparator comp = new SortComparator(map);

        // Sort the map using Collections CLass
        Collections.sort(outputArray,comp);

        // Final Output
        for (Integer i : outputArray) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

   static class SortComparator implements Comparator<Integer> {
        private final Map<Integer, Integer> integerFrequencyMap;

        SortComparator(Map<Integer, Integer> tFreqMap)
        {
            this.integerFrequencyMap = tFreqMap;
        }

        @Override
        public int compare(Integer k1, Integer k2)
        {

            int freqCompare = integerFrequencyMap.get(k1).compareTo(integerFrequencyMap.get(k2));
            int valueCompare = k1.compareTo(k2);


            if (freqCompare == 0)
                return valueCompare;
            else
                return freqCompare;
        }
    }


    public static List<String> missingWords(String s, String t) {
        // Write your code here
        String[] a = s.split(" ");
        String[] b = t.split(" ");
        int sz = a.length - b.length;
        String [] missing = new String[sz];
        int c = 0;
        for(int i=0;i<a.length;i++){
            int flag=0;
            for(int j=0;j<b.length;j++){
                if(a[i].equals(b[j]))
                    flag=1;
            }
            if(flag==0){
                missing[c++]=a[i];

            }
        }

        List<String> missingWords = new ArrayList<>();
        for(String str: missing){
            missingWords.add(str);
        }
        System.out.println(missingWords);
        return missingWords;
    }




    public static int fourthBit(int num) {
        // Write your code here
        String s = Integer.toString(num, 2);
        if(s.charAt(s.length()-4)=='0'){
            return 0;
        }
        //System.out.println(c);
        return 1;
    }

    public static long kSub(int k, List<Integer> num)
    {
        int n = num.size();
        Integer[] numbers = (Integer[])num.toArray(new Integer[n]);

        long[] prefixModCount = new long[k];
        for(int i = 0; i < k; i++)
        {
            prefixModCount[i] = 0;
        }
        prefixModCount[0] = 1;

        int prefixSum = 0;
        for(int i = 1; i < numbers.length; i++)
        {
                prefixSum += numbers[i];
                prefixSum %= k;
                prefixModCount[prefixSum] += 1;

        }

        long result = 0;
        for(int mod = 0; mod < k; mod++)
        {
            result += prefixModCount[mod] * (prefixModCount[mod] - 1) / 2;
        }
        return result;
    }
}
