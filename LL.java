package com.priyanshi.LinkedList;

public class LL {

    private Node head; // by default, it will be null
    private Node tail;
    private int size;
    public LL() {
        this.size = 0;
    }

    public void insertFirst(int val) { // insertion at first
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) { // it's the first element
            tail = head;
        }

        size += 1;
    }

    public void insertLast(int val) { // insertion at last
        if (tail == null) { // if it's an empty list, call the insertFirst() function
            insertFirst(val);
            return;
        }

        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size += 1;
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

        Node node = new Node(val, temp.next); // Node(value, next)
        temp.next = node;

        // OR
//        Node node = new Node(val);
//        Node temp2 = temp.next; // points to the node that will come after inserted node
//        temp.next = node;
//        node.next = temp2;
        size += 1;
    }

    // to find the node which has this value
    public Node find(int value) {
        Node node = head; // start from head and then move ahead index times
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null; // if not found
    }

    // to get reference pointer to the node at given index
    public Node get(int index) {
        Node node = head; // start from head and then move ahead index times
        for(int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int deleteFirst() {
        int val = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val; // returning the removed value
    }

    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }

        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        return val;
    }

    public int delete(int index) { // deletion at given index
        if (index == 0) { // first index
            return deleteFirst();
        }
        if (index == size - 1) { // last index
            return deleteLast();
        }

        Node prev = get(index - 1); // previous node
        int val = prev.next.value; // value of node to be deleted

        prev.next = prev.next.next;

        return val;

    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }


    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

}
