package com.northeastern.edu;

public class question4 {


    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        int minDist = -1;
        int maxDist = -1;
        int first = -1;
        int last = - 1;
        int idx = 0;
        ListNode cur = head;
        while (cur.next.next != null) {
            int x = cur.val;
            int y = cur.next.val;
            int z = cur.next.next.val;
            if (y > Math.max(x, z) || y < Math.min(x, z)) {
                // calculate the minDist
                if (last != -1) {
                    if (minDist == -1) {
                        minDist = idx - last;
                    } else {
                        minDist = Math.min(minDist, idx - last);
                    }
                    maxDist = Math.max(maxDist, idx - first);
                }
                if (first == -1) {
                    first = idx;
                }
                last = idx;
            }
            cur = cur.next;
            idx += 1;
        }
        return new int[]{minDist, maxDist};

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(1);
        ListNode node7 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        int[] res = nodesBetweenCriticalPoints(node1);
        for (int a : res) {
            System.out.println(a);
        }
    }
}
