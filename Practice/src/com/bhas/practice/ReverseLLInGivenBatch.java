package com.bhas.practice;

public class ReverseLLInGivenBatch {

    class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head1;

    public static void main(String[] args) {
        Node head = new ReverseLLInGivenBatch().getLinkedList();
        printLL(head);
        System.out.println();
        System.out.println("Reversing LL ");
        Node node = reverseLinkedList(head);
        printLL(node);
        Node node1 = reverseLinkedListRecursively(head, null);
        printLL(node1);

        System.out.println(Math.round(Double.parseDouble("1.0")));
//        reverseLinkListInK(new ReverseLLInGivenBatch().getLinkedList(), 2);

    }

    private static Node reverseLinkListInK(Node head, int k) {
        if (head == null) {
            return null;
        }
        Node prev = null;
        Node curr = head;
        Node next = head;
        while (k > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head.next = reverseLinkListInK(next, k);
        return head;
    }

    private static Node reverseLinkedListRecursively(Node current, Node prev) {
        //Recursion reached to end...make current node as head
        if (current.next == null) {
            head1 = current;

            current.next = prev;

            return head1;
        }


        Node next = current.next;
        current.next = prev;
        reverseLinkedListRecursively(next, prev);

        return current;
    }

    private static void printLL(Node node) {
        Node curr = node;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
    }

    private static Node reverseLinkedList(Node head) {

        if (head == null) {
            return head;
        }

        Node current = head;
        Node prev = null;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private Node getLinkedList() {
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        return node;
    }

}
