package com.bhas.practice.tree;

import com.bhas.practice.BasicUtil;

import javax.swing.tree.TreeNode;
import java.util.*;

public class SerializeDeserializeBinaryTree {



    final String DELIMITER = "#";
    List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        BasicUtil.BinaryTree node = BasicUtil.getBinaryTree();
        String serialize = new SerializeDeserializeBinaryTree().serialize(node);
        System.out.println(serialize);
        BasicUtil.BinaryTree deserialize = new SerializeDeserializeBinaryTree().deserialize(serialize);
        System.out.println();
    }

    public String serialize(BasicUtil.BinaryTree root) {
        StringBuilder sb = new StringBuilder();
        encode(root, sb);
        return sb.toString();
    }

    private void encode(BasicUtil.BinaryTree root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
        } else {
            sb.append(String.format("%d,", root.getData())); // pre-order
            encode(root.getLeft(), sb);
            encode(root.getRight(), sb);
        }
    }

    // Decodes your encoded data to tree.
    public BasicUtil.BinaryTree deserialize(String data) {
        Queue<String> queue = new LinkedList();
        List<String> list = Arrays.asList(data.split(","));
        queue.addAll(list);
        return decode(queue);
    }

    public BasicUtil.BinaryTree decode(Queue<String> queue) {
        String str = queue.remove();
        if (DELIMITER.equals(str)) return null;

        BasicUtil.BinaryTree node = new BasicUtil.BinaryTree(Integer.valueOf(str));
        node.setLeft(decode(queue));
        node.setRight(decode(queue));
        return node;
    }

    private void preorder(BasicUtil.BinaryTree root, StringBuffer sb){
        if(root != null){
            sb.append(root.getData());
            preorder(root.getLeft(),sb);
            preorder(root.getRight(),sb);
        }else{
            sb.append(DELIMITER);
        }

    }
}
