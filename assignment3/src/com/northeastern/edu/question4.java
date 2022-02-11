package com.northeastern.edu;

public class question4 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }


    public static void reorderList(ListNode head) {
            //findmid
            ListNode midNode = findMid(head);
            //reverse
            ListNode l2 = reverseList(midNode.next);
            midNode.next = null;
            //merge
            ListNode l1 = head;
            while (l1 != null && l2 != null) {
                ListNode nxt1 = l1.next;
                ListNode nxt2 = l2.next;

                l1.next = l2;
                l1 = nxt1;

                l2.next = l1;
                l2 = nxt2;
            }
        }

    public static ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        return prev;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        reorderList(node1);
        ListNode cur = node1;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
