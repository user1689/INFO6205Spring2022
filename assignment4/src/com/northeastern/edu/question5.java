package com.northeastern.edu;

public class question5 {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    public static ListNode mergeSort(ListNode head) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tmp = slow.next;
        slow.next = null;
        ListNode lhead = mergeSort(head);
        ListNode rhead = mergeSort(tmp);
        return merge(lhead, rhead);
    }


    public static ListNode merge(ListNode lhead, ListNode rhead) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode tmp1 = lhead;
        ListNode tmp2 = rhead;
        while (tmp1 != null && tmp2 != null) {
            if (tmp1.val < tmp2.val) {
                cur.next = tmp1;
                tmp1 = tmp1.next;
            } else {
                cur.next = tmp2;
                tmp2 = tmp2.next;
            }
            cur = cur.next;
        }
        if (tmp1 != null) {
            cur.next = tmp1;
        } else if (tmp2 != null) {
            cur.next = tmp2;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(-1);
        ListNode node5 = new ListNode(8);
        ListNode node6 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        sortList(node1);
        ListNode cur = node4;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

}
