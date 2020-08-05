package com.bhas.practice.tree;

import com.bhas.practice.BasicUtil;

public class FoldableBinaryTree {

    public static void main(String[] args) {
        BasicUtil.BinaryTree node = BasicUtil.getBinaryTree();

        boolean isFoldable = checkFoldableBinaryTree(node);

        System.out.println("Is Binary tree foldable :: "+isFoldable);

    }

    private static boolean checkFoldableBinaryTree(BasicUtil.BinaryTree node) {
        if(node == null){
            return true;
        }

        return checkFoldableUtil(node.getLeft(), node.getRight());
    }

    private static boolean checkFoldableUtil(BasicUtil.BinaryTree node1, BasicUtil.BinaryTree node2) {


        if(node1 != null && node2 !=null){
            return true;
        }

        if(node1 == null || node2 == null){
            return false;
        }

        return checkFoldableUtil(node1.getLeft(), node2.getRight())
                && checkFoldableUtil(node1.getRight(), node2.getLeft());
    }

}
