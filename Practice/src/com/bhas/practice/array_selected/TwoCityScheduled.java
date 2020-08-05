package com.bhas.practice.array_selected;

import java.util.*;

public class TwoCityScheduled {

    public int twoCitySchedCost(int[][] costs) {
       Arrays.sort(costs, new Comparator<int[]>() {
           @Override
           public int compare(int[] a, int[] b) {
               return (a[0] - a[1]) -(b[0] - b[1]);
           }
       });

        int res = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            res += costs[i][0];
        }
        for (int i = costs.length / 2; i < costs.length;i++) {
            res += costs[i][1];
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        //[10,20],[30,200],[400,50],[30,20]
        int[][] cost = new int[][]{{10,20},{30,200},{400,50},{30,20}};
//        new TwoCityScheduled().twoCitySchedCost(cost);

        //
//        add(2,3);
        //[[0,1,2,0],[3,4,5,2],[1,3,1,5]]
        setZeroes(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
        //
        new TwoCityScheduled().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        //
    }

    static int add(int x, int y)
    {
        // Iterate till there is no carry
        while (y != 0)
        {
            // carry now contains common
            // set bits of x and y
            int carry = x & y;

            // Sum of bits of x and
            // y where at least one
            // of the bits is not set
            x = x ^ y;

            // Carry is shifted by
            // one so that adding it
            // to x gives the required sum
            y = carry << 1;
        }
        return x;
    }

    static void setZeroes(int[][] matrix) {

        int row = matrix.length;
        int column = matrix[0].length;
        List<Coordinate> list = new ArrayList<>();

        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(matrix[i][j] == 0){
                    Coordinate co = new Coordinate(i,j);
                    list.add(co);
                }
            }
        }

        for(int i = 0;i<list.size();i++){
            Coordinate co = list.get(i);
            int x = co.getX();
            int y = co.getY();
            //
            for(int j = 0;j<column;j++){
                matrix[x][j] = 0;
            }

            for(int k = 0;k<row;k++){
                matrix[k][y] = 0;
            }
        }


        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0){
            return new ArrayList<>();
        }
        List<String> li = new ArrayList<>();
        Map<String, List> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String value = strs[i];
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList(){{add(value);}});
            }else{
                map.get(key).add(strs[i]);
            }
        }
        Collection<List> values = map.values();
        return new ArrayList(values);
    }
}

class Solution {


}

class Coordinate{

    int x;
    int y;

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public Coordinate(){

    }

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}