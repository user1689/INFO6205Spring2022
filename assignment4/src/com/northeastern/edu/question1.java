package com.northeastern.edu;

public class question1 {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static  ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(0, list1);
        ListNode left = dummy;
        while (a-- > 0) {
            left = left.next;
        }
        ListNode right = list1;
        while (b-- > 0) {
            right = right.next;
        }
        ListNode nxt = right.next;
        right.next = null;

        ListNode cur = list2;
        left.next = cur;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = nxt;

        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;


        ListNode node9 = new ListNode(1000);
        ListNode node10 = new ListNode(1001);
        ListNode node11 = new ListNode(1002);

        node9.next = node10;
        node10.next = node11;

        ListNode ans = mergeInBetween(node1, 2, 5, node9);
        ListNode cur = ans;
        while (cur != null) {
            System.out.print(cur.val);
            System.out.print(" ");
            cur = cur.next;
        }

    }

}
