package com.northeastern.edu;

public class question1 {
    //Definition for singly-linked list.
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur3 = dummy;
        int carry = 0;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int tmp = 0;
        while (cur1 != null || cur2 != null) {
            if (cur1 == null) {
                tmp = 0 + cur2.val + carry;
            } else if (cur2 == null) {
                tmp = 0 + cur1.val + carry;
            } else {
                tmp = cur1.val + cur2.val + carry;
            }
            ListNode newNode = new ListNode(tmp % 10);
            cur3.next = newNode;
            cur3 = cur3.next;
            carry = tmp / 10;
            if (cur1 != null) {
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                cur2 = cur2.next;
            }
        }
        if (carry > 0) {
            cur3.next = new ListNode(carry);
        }
        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(7);
        node4.next = node5;
        node5.next = node6;
        ListNode ans = addTwoNumbers(node1, node4);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
