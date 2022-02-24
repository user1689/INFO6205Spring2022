package com.northeastern.edu;

import java.util.LinkedList;
import java.util.Queue;

public class question3 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val) { this.val = val; }
        TreeNode (int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class AnotatedNode {
        TreeNode node;
        int depth;
        int pos;
        AnotatedNode() {}
        AnotatedNode(TreeNode node) {
            this.node = node;
        }
        AnotatedNode(TreeNode node, int depth, int pos) {
            this.node = node;
            this.depth = depth;
            this.pos = pos;
        }

    }

    public static int widthOfBinaryTree(TreeNode root) {
        Queue<AnotatedNode> queue = new LinkedList<>();
        int curDepth = 0;
        int curMax = 0;
        // using left records the idx of the most left node in each line.
        int left = 0;
        AnotatedNode node = new AnotatedNode(root, 0, 0);
        queue.offer(node);
        while (!queue.isEmpty()) {
            AnotatedNode curNode = queue.poll();
            if (curNode.node != null) {
                queue.offer(new AnotatedNode(curNode.node.left, curNode.depth + 1, curNode.pos * 2));
                queue.offer(new AnotatedNode(curNode.node.right, curNode.depth + 1, curNode.pos * 2 + 1));

                // it represents that when we first reach next line, and we can get the value of first node.
                if (curDepth != curNode.depth) {
                    curDepth = curNode.depth;
                    left = curNode.pos;
                }

                curMax = Math.max(curMax, curNode.pos - left + 1);
            }
        }
        return curMax;


    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node5;
        node2.right = node6;
        node3.right = node7;

        int res =  widthOfBinaryTree(node1);
        System.out.println(res);
    }
}
