package com.bhas.practice.tree;

import com.bhas.practice.BasicUtil;

public class HeightOfBinaryTree {

    public static void main(String[] args) {
        BasicUtil.BinaryTree node = BasicUtil.getBinaryTree();
        int height  = height(node);
        System.out.println(height);
    }

    private static int height(BasicUtil.BinaryTree node) {
        if(node == null){
            return 0;
        }
        int heightLeft = height(node.getLeft());
        int heightRight = height(node.getRight());
        if(heightLeft > heightRight){
            return 1 + heightLeft;
        }else{
            return 1 + heightRight;
        }
    }

}
