package com.northeastern.edu;

public class question3 {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static ListNode reverseEvenLengthGroups(ListNode head) {

        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode cur = head;
        // The length of the current linkedlist
        int count = 0;
        while (cur != null) {
            // the length that we expected
            ++ count;

            // the real length of the current LinkedList
            int length = 0;
            ListNode tmp = cur;
            // moving ptr until temp is null or length is equal to count.
            while (length < count && tmp != null ) {
                // measure the real length
                tmp = tmp.next;
                length += 1;
            }

            if (length % 2 == 0) {
                // reverse LinkedList using head plug
                for (int i = 0; i < length - 1; i++ ) {
                    ListNode removed = cur.next;
                    cur.next = cur.next.next;
                    removed.next = pre.next;
                    pre.next = removed;
                }
                pre = cur;
                cur = cur.next;
            } else {
                // moving pre and cur length step
                for (int i = 0; i < length; ++i) {
                    cur = cur.next;
                    pre = pre.next;
                }

            }

        }
        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode res = reverseEvenLengthGroups(node1);
        ListNode cur = res;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
