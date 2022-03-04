package com.northeastern.edu;

import java.util.ArrayList;
import java.util.List;

public class question7 {

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

    // delete static when testing in LEETCODE.
    static List<Integer> tmp = new ArrayList<>();

    public static int sumNumbers(TreeNode root) {
        dfs(root, root.val);
        int res = 0;
        for (Integer num : tmp) {
            res += num;
        }
        return res;
    }

    public static void dfs(TreeNode root, int total) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            tmp.add(total);
        }

        if (root.left != null) {
            dfs(root.left, total * 10 + root.left.val);
        }

        if (root.right != null) {
            dfs(root.right, total * 10 + root.right.val);
        }

    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        int ans = sumNumbers(node1);
        System.out.println(ans);
    }
}
