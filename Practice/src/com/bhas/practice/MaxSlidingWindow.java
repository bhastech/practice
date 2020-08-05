package com.bhas.practice;

/*
* Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.
Examples :

Input :
arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}
k = 3
Output :
3 3 4 5 5 5 6

Input :
arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}
k = 4
Output :
10 10 10 15 15 90 90
* */


import java.util.Date;
import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {

    public static void main(String[] args) {
        printMaximumSlidingWindow(new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6}, 3);
        System.out.println();
        printMaximumSlidingwindowApproch1(new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6}, 3);

    }

    private static void printMaximumSlidingwindowApproch1(int[] arr, int k) {
        int windowSize = (arr.length - k) + 1;
        int[] maxSliding = new int[windowSize];

        Deque<Integer> queue = new LinkedList<>();

        for(int i=0;i<arr.length;i++){
            if(i>=k){
                arr[i-k] = arr[queue.getFirst()];
            }

            while(!queue.isEmpty() && arr[i] >= arr[queue.getLast()]){
                queue.pollLast();
            }

            while(!queue.isEmpty() && queue.getFirst() <= i-k){
                queue.pollLast();
            }

            queue.addLast(i);
        }
        maxSliding[windowSize-1] = arr[queue.getFirst()];

        for(int i:maxSliding){
            System.out.print(maxSliding[i]+"  ");
        }

    }

    private static void printMaximumSlidingWindow(int[] arr, int k) {
        //Idea here to keep a deque, which will keep k elements in desresing order

        Deque<Integer> queue = new LinkedList<>();
        int n = arr.length;
        int i = 0;
        //Process first k elements
        for(;i<k;i++){
            //For each element , previous smaller elements are useless, so we will remove
            while(!queue.isEmpty() && arr[i] >= arr[queue.peekLast()]){
                queue.removeLast();
            }
            //Add new element at rear of queue
            queue.addLast(i);
        }
        //Process rest
        for(;i<n;i++){
            //So we have identified first element in upper loop,, lets print this
            System.out.print(arr[queue.peek()]+"  ");

            //Remove elements which are out of this window

           if(queue.peek() <= i-k){
                queue.removeFirst();
            }

            //Remove all elements smaller than currently being added elements
            while(!queue.isEmpty() && arr[i] >= arr[queue.peekLast()]){
                queue.removeLast();
            }
            queue.addLast(i);
        }

        System.out.print(arr[queue.peek()]);
    }

}
