package com.bhas.practice;

public class BasicUtil {

    public static BinaryTree getBinaryTree(){
        /*
        *                       1
        *                      /  \
        *                     2    3
        *                    / \  / \
        *                   4  5 6   7
        *                           /
        *                          8
        * */

        BinaryTree root = new BinaryTree(1);

        BinaryTree firstLeftLeaf = new BinaryTree(2);

        BinaryTree firstRightLeaf = new BinaryTree(3);
        BinaryTree secondLeftLeaf = new BinaryTree(4);
        BinaryTree secondRightLeaf = new BinaryTree(5);
        BinaryTree thirdLeftLeaf = new BinaryTree(6);
        BinaryTree thirdRightLeaf = new BinaryTree(7);
        BinaryTree forthRightLeaf = new BinaryTree(8);

        root.setLeft(firstLeftLeaf);
        root.setRight(firstRightLeaf);

        firstLeftLeaf.setLeft(secondLeftLeaf);
        firstLeftLeaf.setRight(secondRightLeaf);

        firstRightLeaf.setLeft(thirdLeftLeaf);
        firstRightLeaf.setRight(thirdRightLeaf);

        thirdRightLeaf.setLeft(forthRightLeaf);

        return root;
    }

    public static class BinaryTree{
        int data;
        BinaryTree left;
        BinaryTree right;
        BinaryTree nextRight;

        public BinaryTree(int data){
            this.data = data;
            left = null;
            right = null;
            nextRight = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public BinaryTree getLeft() {
            return left;
        }

        public void setLeft(BinaryTree left) {
            this.left = left;
        }

        public BinaryTree getRight() {
            return right;
        }

        public void setRight(BinaryTree right) {
            this.right = right;
        }

        public BinaryTree getNextRight() {
            return nextRight;
        }

        public void setNextRight(BinaryTree nextRight) {
            this.nextRight = nextRight;
        }
    }


}
