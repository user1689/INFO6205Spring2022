package com.northeastern.edu;

public class question6 {


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


        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int level = countLevel(root);

            int left = 1 << (level);
            int right = (1 << (level + 1)) - 1;
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (exist(root, level, mid)) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }

        public int countLevel(TreeNode root) {
            TreeNode node = root;
            int count = 0;
            while (node.left != null) {
                node = node.left;
                count += 1;
            }
            return count;
        }

        public boolean exist(TreeNode root, int level, int k) {
            int bits = 1 << (level - 1);
            TreeNode cur = root;
            while (bits != 0) {
                if ((bits & k) == 0) {
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
                bits >>= 1;
            }
            if (cur != null) {
                return true;
            } else {
                return false;
            }
        }


//        public static void main(String[] args) {
//            TreeNode node1 = new TreeNode(1);
//            TreeNode node2 = new TreeNode(2);
//            TreeNode node3 = new TreeNode(3);
//            TreeNode node4 = new TreeNode(4);
//            TreeNode node5 = new TreeNode(5);
//            TreeNode node6 = new TreeNode(6);
//            node1.left = node2;
//            node1.right = node3;
//            node2.left = node4;
//            node2.right = node5;
//            node3.left = node6;
//            int res = countNodes(node1);
//            System.out.println(res);
//        }
}
