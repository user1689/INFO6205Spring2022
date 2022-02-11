package com.northeastern.edu;

import java.util.Comparator;
import java.util.PriorityQueue;

public class question3 {

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) { return null; }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode node1, ListNode node2) {
                return node1.val - node2.val;
            }
        });
        for (int i = 0; i < lists.length; i+=1) {
            if (lists[i] != null){
                pq.offer(lists[i]);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            cur.next = node;
            cur = cur.next;
            if (cur.next != null) {
                pq.offer(cur.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(7);
        node4.next = node5;
        node5.next = node6;

        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(6);
        ListNode node9 = new ListNode(9);
        node7.next = node8;
        node8.next = node9;

        ListNode[] example = new ListNode[]{node1, node4, node7};
        ListNode ans = mergeKLists(example);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }

    }

}
