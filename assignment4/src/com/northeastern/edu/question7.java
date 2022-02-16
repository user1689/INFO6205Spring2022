package com.northeastern.edu;

public class question7 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        for (int i = 0; i < (left - 1); i++) {
            pre = pre.next;
        }

        // move rightPtr right - left + 1 steps from pre
        ListNode rightNode = pre;
        for (int i = 0; i < (right - left + 1); i++) {
            rightNode = rightNode.next;
        }

        // reverse linkedlist
        ListNode leftNode = pre.next;
        ListNode cur = rightNode.next;
        pre.next = null;
        rightNode.next = null;
        reverseLinkedList(leftNode);

        // merge to original linkedlist
        pre.next = rightNode;
        leftNode.next = cur;
        return dummy.next;
    }

    public static void reverseLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        reverseBetween(node1, 2, 4);
        ListNode cur =  node1;
        while (cur != null) {
            System.out.print(cur.val);
            cur = cur.next;
        }
    }
}
