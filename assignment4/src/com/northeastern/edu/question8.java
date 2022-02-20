package com.northeastern.edu;

public class question8 {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length += 1;
            cur = cur.next;
        }
        int remains = length % k;
        int eachParts = length / k;

        ListNode tmp = head;
        ListNode[] res = new ListNode[k];
        for (int i = 0; (i < k) && (tmp != null); i++ ) {
            res[i] = tmp;
            int partSize = eachParts + (i < remains ? 1 : 0);
            for (int j = 1; j < partSize; j++ ) {
                tmp = tmp.next;
            }
            ListNode next = tmp.next;
            tmp.next = null;
            tmp = next;
        }

        return res;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(575);
        ListNode node2 = new ListNode(361);
        ListNode node3 = new ListNode(448);
        ListNode node4 = new ListNode(137);
        ListNode node5 = new ListNode(225);
        ListNode node6 = new ListNode(359);
        ListNode node7 = new ListNode(245);
        ListNode node8 = new ListNode(33);
        ListNode node9 = new ListNode(245);
        ListNode node10 = new ListNode(549);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;

        int k = 3;
        ListNode[] res = splitListToParts(node1, k);
        for (ListNode node : res) {
            ListNode cur = node;
            while (cur != null) {
                System.out.print(cur.val);
                System.out.print(" ");
                cur = cur.next;
            }
            System.out.println("\n");
        }
    }

}
