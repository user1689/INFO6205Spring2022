package com.northeastern.edu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class question5 {

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


    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> tmp = new ArrayList<>();
        dfs(root, 0, 0, tmp);
        Collections.sort(tmp, new Comparator<int[]>() {
            @Override
            public int compare(int[] tuple1, int[] tuple2) {
                if (tuple1[0] != tuple2[0]) {
                    return tuple1[0] - tuple2[0];
                } else if (tuple1[1] != tuple2[1]) {
                    return tuple1[1] - tuple2[1];
                } else {
                    return tuple1[2] - tuple2[2];
                }
            }
        });
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int size = 0;
        int lastcol = Integer.MIN_VALUE;

        for (int[] tuple : tmp) {
            int col = tuple[0], row = tuple[1], value = tuple[2];
            if (col != lastcol) {
                lastcol = col;
                ans.add(new ArrayList<Integer>());
                size++;
            }
            ans.get(size - 1).add(value);
        }
        return ans;
        }

        public void dfs(TreeNode root, int row, int col, List<int[]> tmp) {
            if (root == null) {
                return;
            }
            tmp.add(new int[]{col, row, root.val});
            dfs(root.left, row + 1, col - 1, tmp);
            dfs(root.right, row + 1, col + 1, tmp);
        }

//        public static void main(String[] args) {
//            TreeNode node1 = new TreeNode(3);
//            TreeNode node2 = new TreeNode(9);
//            TreeNode node3 = new TreeNode(20);
//            TreeNode node4 = new TreeNode(15);
//            TreeNode node5 = new TreeNode(7);
//            node1.left = node2;
//            node1.right = node3;
//            node3.left = node4;
//            node3.right = node5;
//            List<List<Integer>> res = verticalTraversal(node1);
//            for (List<Integer> ans : res) {
//                System.out.println(ans.toString());
//            }
//
//        }


}
