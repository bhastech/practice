package com.bhas.practice.java8;

import java.util.ArrayList;
import java.util.List;

public class GenericStack<T> {

    private List<T> stackList = new ArrayList<>();
    private int top;

    public void push(T t){
        stackList.add(top++,t);
    }

    public T pop(){
        return stackList.remove(--top);
    }

    public int size(){
        return top;
    }




//
//    private ArrayList<T> stack = new ArrayList<T>();
//    private int top = 0;
//
//    public int size() {
//        return top;
//    }
//
//    public void push(T item) {
//        stack.add(top++, item);
//    }
//
//    public T pop() {
//        return stack.remove(--top);
//    }

    public static void main(String[] args) {
       GenericStack<String> stack = new GenericStack<>();
       stack.push("Bhaskar");
       stack.push("Jitu");

        System.out.println(stack.pop());
    }

}