package com.priyanshi.LinkedList;

public class DLL {

    private Node head;
    private int size;
    public DLL() {
        this.size = 0;
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node; // but head may be null if you are inserting it for the first time
        }
        head = node;
        size++;
    }

    public void insertLast(int val) {
        Node node = new Node(val);
        Node last = head; // start from head

        node.next = null;

        if (head == null) { // if there was no element
            node.prev = null;
            head = node;
            return;
        }

        while (last.next != null) { // at the end, last will be pointing to the last node
            last = last.next;
        }

        last.next = node;
        node.prev = last;
    }

    public void insert(int val, int index) { // insertion at given index
        if (index == 0) { // insert at first
            insertFirst(val);
            return;
        }
        if (index == size) { // insert at last
            insertLast(val);
            return;
        }

        Node temp = head; // at index 0
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(val, temp.next, temp.prev); // Node(value, next, prev)
        temp.next = node;

        size += 1;
    }

    // insertion after given node
    public void insertAfter(int after, int val) { // after refers to the node after which we need to insert
        Node p = find(after); // p refers to the "previous node"
        if (p == null) {
            System.out.println("Does not exist.");
            return;
        }

        Node node = new Node(val);

        node.next = p.next;
        p.next = node;
        node.prev = p;
        if (node.next != null) {
            node.next.prev = node; // it may give an error if new node is the last node, node.next may be null
        }
    }

    // to find the node which has this value
    public Node find(int val) {
        Node node = head; // start from head and then move ahead index times
        while (node != null) {
            if (node.val == val) {
                return node;
            }
            node = node.next;
        }
        return null; // if not found
    }

    public void display() {
        Node node = head;
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next; // reassign
        }
        System.out.println("END"); // print a newline
    }

    public void displayRev() {
        Node node = head;
        Node last = null; // to get the last node
        while (node != null) {
            System.out.print(node.val + " -> ");
            last = node; // move last till the end
            node = node.next; // reassign
        }
        System.out.println("END"); // print a newline

        System.out.println("Print in Reverse:");
        while (last != null) {
            System.out.print(last.val + " -> ");
            last = last.prev;
        }
        System.out.println("START");
    }

    private class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}