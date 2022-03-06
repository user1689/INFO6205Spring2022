package com.northeastern.edu;

import java.util.Deque;
import java.util.LinkedList;

public class question4 {


    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class Codec {
        String NULL = "#";
        String SEP = ",";
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            return serializeTree(root, sb).toString();
        }

        public StringBuilder serializeTree(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append(NULL).append(SEP);
                return sb;
            }
            sb.append(root.val).append(SEP);
            serializeTree(root.left, sb);
            serializeTree(root.right, sb);
            return sb;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Deque<String> deque = new LinkedList<>();
            String[] tmp = data.split(",");
            for (String ss : tmp) {
                deque.offer(ss);
            }
            return constructTree(deque);
        }

        public TreeNode constructTree(Deque<String> deque) {
            if (deque.isEmpty()) {
                return null;
            }
            String tmp = deque.poll();
            if (tmp.equals(NULL)) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(tmp));
            root.left = constructTree(deque);
            root.right = constructTree(deque);
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

//    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(4);
//        TreeNode node2 = new TreeNode(3);
//        TreeNode node3 = new TreeNode(5);
//        TreeNode node4 = new TreeNode(2);
//        TreeNode node5 = new TreeNode(0);
//        TreeNode node6 = new TreeNode(8);
//        TreeNode node7 = new TreeNode(7);
//        TreeNode node8 = new TreeNode(1);
//        node1.left = node2;
//        node2.left = node3;
//        node3.right = node4;
//        node2.right = node8;
//        node3.left = node6;
//        node6.left = node7;
//        node6.right = node5;
//
//        Codec ser = new Codec();
//        Codec deser = new Codec();
//        TreeNode ans = deser.deserialize(ser.serialize(node1));
//    }
}
