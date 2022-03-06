package com.northeastern.edu;

public class question2 {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode leftNode = dfs(root.left, p, q);
        TreeNode rightNode = dfs(root.right, p, q);

        if (leftNode == null) {
            return rightNode;
        } else if (rightNode == null) {
            return leftNode;
        } else {
            return root;
        }
    }

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
//        TreeNode ans = lowestCommonAncestor(node1, new TreeNode(2), new TreeNode(8));
//        System.out.println(ans.val);
//    }
}
