package com.northeastern.edu;

import java.util.Arrays;
import java.util.Stack;

public class question9 {

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static int[] nextLargerNodes(ListNode head) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            cur = cur.next;
            length += 1;
        }
        int[] res = new int[length];
        int idx = 0;
        cur = head;
        while(cur != null) {
            while(!stack1.isEmpty() && stack1.peek().val < cur.val) {
                ListNode node = stack1.pop();
                int tmpIdx = stack2.pop();
                res[tmpIdx] = cur.val;
            }
            stack1.push(cur);
            stack2.push(idx);
            idx += 1;
            cur = cur.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(7);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        int[] res = nextLargerNodes(node1);
        System.out.println(Arrays.toString(res));
    }
}
