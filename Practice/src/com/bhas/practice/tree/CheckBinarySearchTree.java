package com.bhas.practice.tree;

public class CheckBinarySearchTree {

    Node root;
    boolean isBST()  {
        return isBSTUtil(root, Integer.MIN_VALUE,
                Integer.MAX_VALUE);
    }

    private boolean isBSTUtil(Node root, int minValue, int maxValue) {

        if(root == null){
            return true;
        }

        if(root.data < minValue || root.data > maxValue){
            return false;
        }

        return (isBSTUtil(root.left, minValue, root.data)
                && isBSTUtil(root.right,root.data, maxValue));
    }

    public static void main(String args[])
    {
        CheckBinarySearchTree tree = new CheckBinarySearchTree();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        if (tree.isBST())
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }
}

class Node
{
    int data;
    Node left, right;

    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}
