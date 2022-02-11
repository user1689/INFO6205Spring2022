package com.northeastern.edu;

import java.util.HashMap;
import java.util.Map;

public class question2 {

    // Definition for a Node.
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap();
        return dfs(head, map);
    }

    public static Node dfs(Node node, Map<Node, Node> map) {
        if (node == null) {
            return null;
        }
        if (!map.containsKey(node)){
            Node newNode = new Node(node.val);
            map.put(node, newNode);
            newNode.next = dfs(node.next, map);
            newNode.random = dfs(node.random, map);
        }

        return map.get(node);

    }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node2.random = node6;
        node3.random = node1;
        node5.random = node1;
        Node head = copyRandomList(node1);
        while (head != null) {
            if (head.random != null){
                System.out.println(head.random.val);
            }
            head = head.next;
        }
    }

}
