package com.northeastern.edu;

public class question6 {
    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        while (n > 0) {
            cur = cur.next;
            n -= 1;
        }
        ListNode prev = dummy;
        while (cur.next != null) {
            prev = prev.next;
            cur = cur.next;
        }
        prev.next = prev.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode ans = removeNthFromEnd(node1, 2);
        ListNode cur = node1;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
