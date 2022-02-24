package com.northeastern.edu;

import java.util.ArrayList;
import java.util.List;

public class question2 {
    public static class TreeNode {
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

    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null) {
            return res;
        }
        dfs(root);
        return res;
    }

    public static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);
        int nowLevel = Math.max(leftHeight, rightHeight) + 1;
        if (nowLevel - 1 == res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(nowLevel - 1).add(root.val);
        return nowLevel;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        List<List<Integer>> res = findLeaves(root);
        for (List<Integer> tmp: res) {
            for (int i = 0; i < tmp.size(); i ++) {
                System.out.print(tmp.get(i));
            }
            System.out.print("\n");
        }
    }
}
