package com.bhas.practice.tree;

import com.bhas.practice.BasicUtil;

import java.util.LinkedList;

public class CloneBinaryTree {

    public static void main(String[] args) {
        BasicUtil.BinaryTree node = BasicUtil.getBinaryTree();

        inOrderTraversal(node);

        System.out.println();

        BasicUtil.BinaryTree clonedBinaryTree = cloneBinaryTree(node);
        inOrderTraversal(clonedBinaryTree);

        //TODO: clone with random pointers

        LinkedList<BasicUtil.BinaryTree> dll = new LinkedList<>();

        extractLeavesOfBinaryTreeToDLL(node,dll);

    }

    private static void extractLeavesOfBinaryTreeToDLL(BasicUtil.BinaryTree node, LinkedList<BasicUtil.BinaryTree> dll) {
        if(node == null){
            return;
        }

        if (node.getRight() == null && node.getLeft() == null) {//Leaf node
            dll.addFirst(node);
        } else {

        }
    }

    private static void inOrderTraversal(BasicUtil.BinaryTree node) {
        if(node !=null){
            inOrderTraversal(node.getLeft());
            System.out.print(node.getData()+"  ");
            inOrderTraversal(node.getRight());
        }
    }


    private static BasicUtil.BinaryTree cloneBinaryTree(BasicUtil.BinaryTree node) {

        if (node == null) {
            return null;
        }

        BasicUtil.BinaryTree node1 = new BasicUtil.BinaryTree(node.getData());

        node1.setLeft(node.getLeft());
        node1.setRight(node.getRight());
        return node1;

    }


}
