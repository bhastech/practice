package com.bhas.practice.tree;

import com.bhas.practice.BasicUtil;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        BasicUtil.BinaryTree binaryTree = BasicUtil.getBinaryTree();
        levelOrderTraversal(binaryTree);
        reverseLevelOrderTraversal(binaryTree);
        zigZagTraversal(binaryTree);
    }

    private static void levelOrderTraversal(BasicUtil.BinaryTree root) {
        Queue<BasicUtil.BinaryTree> queue = new LinkedList<>();

        if(root == null){
            return;
        }

        queue.offer(root);

        while(!queue.isEmpty()){

            BasicUtil.BinaryTree temp = queue.poll();

            System.out.println(temp.getData());

            if(temp.getLeft()!=null){
                queue.offer(temp.getLeft());
            }

            if(temp.getRight()!=null){
                queue.offer(temp.getRight());
            }

        }
    }

    private static void reverseLevelOrderTraversal(BasicUtil.BinaryTree root){
        Stack<Integer> stack = new Stack<>();

        Queue<BasicUtil.BinaryTree> queue = new LinkedList<>();

        if(root == null){
            return;
        }

        queue.offer(root);

        while(!queue.isEmpty()){
            BasicUtil.BinaryTree temp = queue.poll();

            stack.push(temp.getData());

            if(temp.getLeft()!=null){
                queue.offer(temp.getLeft());
            }

            if(temp.getRight()!=null){
                queue.offer(temp.getRight());
            }

        }

        System.out.println("Reverse Level order traversal");

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }

    private static void zigZagTraversal(BasicUtil.BinaryTree root){

        Stack<BasicUtil.BinaryTree> s1 = new Stack<>();
        Stack<BasicUtil.BinaryTree> s2 = new Stack<>();

        s1.push(root);

        System.out.println("Zigzag Level order traversal");

        while(!s1.isEmpty() || !s2.isEmpty()){
            while(!s1.isEmpty()){
                BasicUtil.BinaryTree temp = s1.pop();
                if(temp.getLeft()!=null){
                    s2.push(temp.getLeft());
                }
                if(temp.getRight()!=null){
                    s2.push(temp.getRight());
                }
                System.out.print(temp.getData()+"  ");
            }

            while(!s2.isEmpty()){
                BasicUtil.BinaryTree temp = s2.pop();
                if(temp.getRight()!=null){
                    s1.push(temp.getRight());
                }
                if(temp.getLeft()!=null){
                    s1.push(temp.getLeft());
                }
                System.out.print(temp.getData()+"  ");
            }
        }
    }

}
