package com.bhas.practice.tree;

import com.bhas.practice.BasicUtil;

import java.util.*;

public class TreeViews {

    public static void main(String[] args) {
        BasicUtil.BinaryTree binaryTree = BasicUtil.getBinaryTree();
        System.out.println("Top View");
        printTopView(binaryTree);
        System.out.println("Left View");
        printLeftView(binaryTree);
        System.out.println("Right view");
        printRightView(binaryTree);
        System.out.println("Bottom View");
        printBottomView(binaryTree);

    }

    private static void printTopView(BasicUtil.BinaryTree binaryTree) {

        class QNode{
            BasicUtil.BinaryTree node;
            int hd;
            public QNode(BasicUtil.BinaryTree node, int hd){
                this.node = node;
                this.hd = hd;
            }
        }

        Queue<QNode> queue = new LinkedList<>();

        if(binaryTree==null){
            return;
        }

        queue.offer(new QNode(binaryTree, 0));
        Set<Integer> s= new HashSet<>();
        s.add(0);
        System.out.println(binaryTree.getData());
        while(!queue.isEmpty()){
            QNode temp = queue.poll();
            int temp_Value = temp.hd;
            BasicUtil.BinaryTree node = temp.node;
            if(!s.contains(temp_Value)){
                s.add(temp_Value);
                System.out.println(node.getData());
            }

            if(node.getLeft()!=null){
                queue.offer(new QNode(node.getLeft(), temp_Value-1));
            }
            if(node.getRight()!=null){
                queue.offer(new QNode(node.getRight(),temp_Value+1));
            }
        }
    }


    private static void printLeftView(BasicUtil.BinaryTree binaryTree) {

        class QNode{
            BasicUtil.BinaryTree node;
            int hd;
            public QNode(BasicUtil.BinaryTree node, int hd){
                this.node = node;
                this.hd = hd;
            }
        }

        Queue<QNode> queue = new LinkedList<>();

        if(binaryTree==null){
            return;
        }

        queue.offer(new QNode(binaryTree, 0));
        Set<Integer> s= new HashSet<>();
        s.add(0);
        System.out.println(binaryTree.getData());
        while(!queue.isEmpty()){
            QNode temp = queue.poll();
            int temp_Value = temp.hd;
            BasicUtil.BinaryTree node = temp.node;
            if(!s.contains(temp_Value)){
                s.add(temp_Value);
                System.out.println(node.getData());
            }

            if(node.getLeft()!=null){
                queue.offer(new QNode(node.getLeft(), temp_Value-1));
            }
            if(node.getRight()!=null){
                queue.offer(new QNode(node.getRight(),temp_Value-1));
            }
        }
    }

    private static void printRightView(BasicUtil.BinaryTree binaryTree) {

        class QNode{
            BasicUtil.BinaryTree node;
            int hd;
            public QNode(BasicUtil.BinaryTree node, int hd){
                this.node = node;
                this.hd = hd;
            }
        }

        Queue<QNode> queue = new LinkedList<>();

        if(binaryTree==null){
            return;
        }

        queue.offer(new QNode(binaryTree, 0));
        Set<Integer> s= new HashSet<>();
        s.add(0);
        System.out.println(binaryTree.getData());
        while(!queue.isEmpty()){
            QNode temp = queue.poll();
            int temp_Value = temp.hd;
            BasicUtil.BinaryTree node = temp.node;
            if(!s.contains(temp_Value)){
                s.add(temp_Value);
                System.out.println(node.getData());
            }

            if(node.getRight()!=null){
                queue.offer(new QNode(node.getRight(),temp_Value+1));
            }

            if(node.getLeft()!=null){
                queue.offer(new QNode(node.getLeft(), temp_Value+1));
            }

        }
    }

    //TODO: not correct solution ,...need to check

    private static void printBottomView(BasicUtil.BinaryTree binaryTree) {

        class QNode{
            BasicUtil.BinaryTree node;
            int hd;
            public QNode(BasicUtil.BinaryTree node, int hd){
                this.node = node;
                this.hd = hd;
            }
        }

        Queue<QNode> queue = new LinkedList<>();

        if(binaryTree==null){
            return;
        }

        queue.offer(new QNode(binaryTree, 0));
        Map<Integer, BasicUtil.BinaryTree> s= new TreeMap<>();
        while(!queue.isEmpty()){
            QNode temp = queue.remove();
            int temp_Value = temp.hd;
            BasicUtil.BinaryTree node = temp.node;

            s.put(temp_Value, node);

            if(node.getLeft()!=null){
                queue.offer(new QNode(node.getLeft(), temp_Value-1));
            }
            if(node.getRight()!=null){
                queue.offer(new QNode(node.getRight(),temp_Value+1));
            }
        }

        for (Map.Entry<Integer, BasicUtil.BinaryTree> integerBinaryTreeEntry : s.entrySet()) {
            System.out.println(integerBinaryTreeEntry.getValue().getData());
        }

    }
}
