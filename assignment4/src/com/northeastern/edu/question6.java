package com.northeastern.edu;

import java.util.Random;

public class question6 {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static class Solution {

        ListNode node;
        Random random;

        public Solution(ListNode head) {
            this.node = head;
            this.random = new Random();
        }

        public int getRandom() {
            int i = 1;
            int x = 0;
            ListNode cur = this.node;
            while (cur != null) {
                if (random.nextInt(i) == 0) {
                    x = cur.val;
                }
                i += 1;
                cur = cur.next;
            }
            return x;

        }
    }

        /**
         * Your Solution object will be instantiated and called as such:
         * Solution obj = new Solution(head);
         * int param_1 = obj.getRandom();
         */
        public static void main(String[] args) {
            ListNode node1 = new ListNode(1);
            ListNode node2 = new ListNode(2);
            ListNode node3 = new ListNode(3);
            node1.next = node2;
            node2.next = node3;
            Solution obj = new Solution(node1);
            for (int i = 0; i < 5; i++) {
                int param_1 = obj.getRandom();
                System.out.println(param_1);
            }
        }
}
