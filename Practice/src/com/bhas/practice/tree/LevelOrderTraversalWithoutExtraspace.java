package com.bhas.practice.tree;

import com.bhas.practice.BasicUtil;

public class LevelOrderTraversalWithoutExtraspace {

    public static void main(String[] args) {
        BasicUtil.BinaryTree binaryTree = BasicUtil.getBinaryTree();

        int height = getHeight(binaryTree);

       // System.out.println(height);

        int timeout  = 100;

        long reqTimeout = timeout +(timeout*20/100);
        System.out.println(reqTimeout);
    }

    private static int getHeight(BasicUtil.BinaryTree root) {

        if (root == null) {
            return 0;
        }

        return 1 + Math.max(getHeight(root.getLeft()) , getHeight(root.getRight()));
    }


}
