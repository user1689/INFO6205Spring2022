package com.northeastern.edu;

public class question10 {

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static int pairSum(ListNode head) {

        // time O(n)
        // space O(1)
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = slow.next;
        slow.next = null;

        ListNode pre = null;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }

        int maxTwinVal = 0;
        ListNode l1 = head;
        ListNode l2 = pre;
        while (l1 != null && l2 != null) {
            maxTwinVal = Math.max(maxTwinVal, l1.val + l2.val);
            l1 = l1.next;
            l2 = l2.next;

        }

        return maxTwinVal;


    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(55);
        ListNode node2 = new ListNode(31);
        ListNode node3 = new ListNode(48);
        ListNode node4 = new ListNode(37);
        ListNode node5 = new ListNode(25);
        ListNode node6 = new ListNode(39);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        int ans = pairSum(node1);
        System.out.println(ans);

    }

        // method 2
        // time O(n)
        // space O(n)
        // ListNode cur = head;
        // int n = 0;
        // while (cur != null){
        //     n += 1;
        //     cur = cur.next;
        // }

        // int[] tmp = new int[n];
        // int idx = 0;
        // cur = head;
        // while(cur != null) {
        //     tmp[idx++] = cur.val;
        //     cur = cur.next;
        // }

        // int maxTwinVal = Integer.MIN_VALUE;
        // for (int i = 0; i <= (n / 2) - 1; i++) {
        //     maxTwinVal = Math.max(maxTwinVal, tmp[i] + tmp[n - 1 - i]);
        // }
        // return maxTwinVal;


        // method 1
        // time O(n^2)
        // space O(1)
        // int maxTwinVal = Integer.MIN_VALUE;
        // cur = head;
        // int idx = 0;
        // while (idx  <= (n / 2) - 1) {
        //     int itVal = cur.val;
        //     int itsTwinDis = (n - 1 - idx) - idx;
        //     ListNode tmp = cur;
        //     while (itsTwinDis > 0) {
        //         tmp = tmp.next;
        //         itsTwinDis -= 1;
        //     }
        //     maxTwinVal = Math.max(maxTwinVal, tmp.val + itVal);
        //     cur = cur.next;
        //     idx += 1;
        // }
        // return maxTwinVal;



}

