package com.bhas.practice.tree;

import com.bhas.practice.BasicUtil;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static com.bhas.practice.BasicUtil.BinaryTree;



public class TreeTraversals {

    public static void main(String[] args) {
        BinaryTree binaryTree = BasicUtil.getBinaryTree();
        System.out.println("Inorder recursive order traversal");
        inOrderTraversalRecursive(binaryTree);
        System.out.println();
        System.out.println("Level order traversal");
        levelOrderTraversalItrative(binaryTree);
        System.out.println();
        System.out.println("Reverse Level order traversal");
        reverseLevelOrderTraversal(binaryTree);
        System.out.println();
        System.out.println("Zig zag traversal ");
        zigZagTraversal(binaryTree);
        System.out.println();
        System.out.println("Left View of Binary Tree");
        printLeftView(binaryTree);
    }

    class QNode{
        BinaryTree node;
        int hd;

        public QNode(BinaryTree node, int hd) {
            this.node = node;
            this.hd = hd;
        }

        public BinaryTree getNode() {
            return node;
        }

        public void setNode(BinaryTree node) {
            this.node = node;
        }

        public int getHd() {
            return hd;
        }

        public void setHd(int hd) {
            this.hd = hd;
        }
    }

    private static void printLeftView(BinaryTree node) {
        //Refer traversal class
    }

    private static void zigZagTraversal(BinaryTree node) {
        Stack<BinaryTree> s1 = new Stack<>();
        Stack<BinaryTree> s2 = new Stack<>();

        if(node == null){
            return;
        }

        s1.push(node);

        while(!s1.isEmpty() || !s2.isEmpty()){
            while(!s1.isEmpty()){

                BinaryTree temp = s1.pop();

                if(temp.getLeft()!=null){
                    s2.push(temp.getLeft());
                }

                if(temp.getRight()!=null){
                    s2.push(temp.getRight());
                }

                System.out.print(temp.getData()+" ");
            }

            while(!s2.isEmpty()){

                BinaryTree temp = s2.pop();

                if(temp.getRight()!=null){
                    s1.push(temp.getRight());
                }

                if(temp.getLeft()!=null){
                    s1.push(temp.getLeft());
                }

                System.out.print(temp.getData()+" ");
            }
        }
    }

    private static void reverseLevelOrderTraversal(BinaryTree root) {
        if(root == null){
            return;
        }
        Queue<BinaryTree> q = new LinkedList<BinaryTree>();
        q.offer(root);
        Stack<Integer> stack = new Stack<>();
        while(!q.isEmpty()){
            BinaryTree node = q.poll();
            stack.push(node.getData());
            if(node.getLeft()!=null){
                q.offer(node.getLeft());
            }
            if(node.getRight()!=null){
                q.offer(node.getRight());
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }

    private static void levelOrderTraversalItrative(BinaryTree node) {
        Queue<BinaryTree> q = new LinkedList<BinaryTree>();
        if(node == null){
            return;
        }
        q.offer(node);
        while(!q.isEmpty()){
            BinaryTree temp = q.poll();
            System.out.print(temp.getData()+" ");
            if(temp.getLeft()!=null){
                q.offer(temp.getLeft());
            }
            if(temp.getRight()!=null){
                q.offer(temp.getRight());
            }
        }

    }

    private static void inOrderTraversalRecursive(BinaryTree node) {
        if(node == null){
            return;
        }
        inOrderTraversalRecursive(node.getLeft());
        System.out.print(node.getData() +  " ");
        inOrderTraversalRecursive(node.getRight());
    }



}
