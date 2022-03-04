package com.northeastern.edu;

public class question8 {


    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static TreeNode removeLeafNodes(TreeNode root, int target) {
        dfs(root, target);
        if (root.val == target && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }

    public static void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }

        dfs(root.left, target);
        dfs(root.right, target);

        if (root.left != null) {
            if (root.left.val == target) {
                if (root.left.left == null && root.left.right == null) {
                    root.left = null;
                }
            }
        }

        if (root.right != null) {
            if (root.right.val == target) {
                if (root.right.right == null && root.right.left == null) {
                    root.right = null;
                }
            }
        }
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        TreeNode ans = removeLeafNodes(node1, 2);
    }
}
