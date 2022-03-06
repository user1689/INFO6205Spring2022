package com.northeastern.edu;

public class question1 {

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

    int cnt = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        search(root, targetSum);
        return cnt;
    }

    // record pathSum
    public void path(TreeNode root, int total, int targetSum) {
        if (total == targetSum) {
            cnt += 1;
        }
        if (root == null) {
            return;
        }

        if (root.left != null) {
            path(root.left, total + root.left.val, targetSum);
        }
        if (root.right != null) {
            path(root.right, total + root.right.val, targetSum);
        }
    }

    // preOrder
    public void search(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }

        path(root, root.val, targetSum);
        search(root.left, targetSum);
        search(root.right, targetSum);
    }


//    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(4);
//        TreeNode node2 = new TreeNode(3);
//        TreeNode node3 = new TreeNode(5);
//        TreeNode node4 = new TreeNode(2);
//        node1.left = node2;
//        node2.left = node3;
//        node3.right = node4;
//        int ans = pathSum(node1, 7);
//        System.out.println(ans);
//    }
}
