package com.bhas.practice.tree;

import com.bhas.practice.BasicUtil;

import java.math.BigInteger;
import java.nio.ByteBuffer;

public class LCA {

    public static void main(String[] args) {
        BasicUtil.BinaryTree binaryTree = BasicUtil.getBinaryTree();
        BasicUtil.BinaryTree lca = findLCA(binaryTree, 6, 7);
        System.out.println("LCA is :: " + lca.getData());
        int data = 8;
        System.out.println("Finding parents for node data : " + data);
        findParents(binaryTree, data);
        System.out.println();
        //1 & 0xFF,2 & 0xFF,3 & 0xFF,3 & 0xFF
        System.out.println(ByteBuffer.wrap(new byte[]{1, 2, 3, 4}).getInt());
        BigInteger bigInteger = new BigInteger(new byte[]{1, 2, 3, 4});
        System.out.println(bigInteger);

    }

    private static BasicUtil.BinaryTree findLCA(BasicUtil.BinaryTree root, int n1, int n2) {

        if (root == null) {
            return null;
        }

        if (root.getData() == n1 || root.getData() == n2) {
            return root;
        }



        BasicUtil.BinaryTree left = findLCA(root.getLeft(), n1, n2);

        BasicUtil.BinaryTree right = findLCA(root.getRight(), n1, n2);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    private static boolean findParents(BasicUtil.BinaryTree root, int target) {
        if (root == null) {
            return false;
        }

        if (root.getData() == target) {
            return true;
        }

        if (findParents(root.getLeft(), target) || findParents(root.getRight(), target)) {
            System.out.print(root.getData() + " ");
            return true;
        }
        return false;
    }


}
