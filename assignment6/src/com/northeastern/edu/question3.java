package com.northeastern.edu;

public class question3 {


    // Definition for a binary tree node.
    public class TreeNode {
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


    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        int leftDepth = 0;
        int rightDepth = 0;
        if (root.left != null && root.left.val == root.val) {
            leftDepth += left + 1 ;
        }
        if (root.right != null && root.right.val == root.val) {
            rightDepth += right + 1 ;
        }
        ans = Math.max(ans, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth);
    }


//    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(4);
//        TreeNode node3 = new TreeNode(4);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node6 = new TreeNode(5);
//        node1.left = node2;
//        node2.left = node3;
//        node2.right = node4;
//        node1.right = node5;
//        node5.right = node6;
//        int res = longestUnivaluePath(node1);
//        System.out.println(ans);
//    }
}
