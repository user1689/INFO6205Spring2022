package com.northeastern.edu;

public class question8 {
    public static class Node{
        int val;
        Node next;
        public Node() {}
        public Node(int x) { this.val = x; }
        public Node(int x, Node next) {
            this.val = x;
            this.next = next;
        }
    }

    public static Node insert(Node head, int insertVal){
        //Your code
        //case1
        //no node
        if (head == null) {
            Node newNode = new Node(insertVal);
            newNode.next = newNode;
            return newNode;
        }
        //case2
        //node can be inserted into circle
        Node prev = head;
        Node cur = head.next;
        boolean toInsert = false;

        do {
            if (insertVal >= prev.val && insertVal <= cur.val) {
                toInsert = true;
            } else if (prev.val > cur.val) {
                if (insertVal >= prev.val || insertVal <= cur.val) {
                    toInsert = true;
                }
            }
            if (toInsert) {
                prev.next = new Node(insertVal, cur);
                return head;
            }
            prev = cur;
            cur = cur.next;
        } while (prev != head);

        //case3
        //each node has same val in circle, it also can be inserted into circle
        prev.next = new Node(insertVal, cur);
        return head;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(6);
        Node node5 = new Node(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node1;
        Node ans = insert(node1, 5);
        Node cur = node1;
        do {
            System.out.println(cur.val);
            cur = cur.next;
        } while (cur != node1);
    }
}
