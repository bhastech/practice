package com.bhas.practice.tree;

import com.bhas.practice.BasicUtil;

public class ConnectNodesWithoutExtraSpace {

    public static void main(String[] args) {
        BasicUtil.BinaryTree root = BasicUtil.getBinaryTree();

        connectNodes(root);
    }

    private static void connectNodes(BasicUtil.BinaryTree node) {

        BasicUtil.BinaryTree temp = null;

        if (node == null) {
            return;
        }

        node.setNextRight(null);

        while (node != null) {

            BasicUtil.BinaryTree nextNode = node;

            while (nextNode != null) {

                if (nextNode.getLeft() != null) {

                    if (nextNode.getRight() != null) {
                        nextNode.getLeft().setNextRight(nextNode.getRight());
                    } else {
                        nextNode.getLeft().setNextRight(getNextNode(nextNode));
                    }

                }

                if (nextNode.getRight() != null) {
                    nextNode.getRight().setNextRight(getNextNode(nextNode));
                }

                nextNode = nextNode.getNextRight();

            }

            if (node.getLeft() != null) {
                node = node.getLeft();
            } else if (node.getRight() != null) {
                node = node.getRight();
            } else {
                node = getNextNode(node);
            }

        }

    }

    private static BasicUtil.BinaryTree getNextNode(BasicUtil.BinaryTree nextNode) {
        BasicUtil.BinaryTree temp = nextNode.getNextRight();
        while (temp != null) {
            if (temp.getLeft() != null) {
                return temp.getLeft();
            } else if (temp.getRight() != null) {
                return temp.getRight();
            }
            temp = temp.getNextRight();
        }
        return null;
    }

}
