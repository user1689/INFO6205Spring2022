package com.northeastern.edu;

public class question2 {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode low = new ListNode(0);
        ListNode high = new ListNode(0);
        ListNode cur1 = low;
        ListNode cur2 = high;

        ListNode tmp = head;
        while(tmp != null) {
            if (tmp.val < x) {
                cur1.next = tmp;
                cur1 = cur1.next;
            } else {
                cur2.next = tmp;
                cur2 = cur2.next;
            }
            tmp = tmp.next;
        }
        cur1.next = null;
        cur2.next = null;

        cur1.next = high.next;
        return low.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode ans = partition(node1, 3);
        ListNode cur = ans;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
