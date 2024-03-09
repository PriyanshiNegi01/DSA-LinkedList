package com.priyanshi.LinkedList;

public class Main {
    public static void main(String[] args) {

        // Singly Linked List
//        LL list = new LL();
//        list.insertFirst(3);
//        list.insertFirst(2);
//        list.insertFirst(8);
//        list.insertFirst(17);
//        list.insertLast(99);
//        list.insert(100, 3);
//        list.display();
//
//        System.out.println(list.deleteFirst());
//        list.display();
//
//        System.out.println(list.deleteLast());
//        list.display();
//
//        System.out.println(list.delete(2));
//        list.display();

        // Doubly Linked List
//        DLL list = new DLL();
//        list.insertFirst(4);
//        list.insertFirst(2);
//        list.insertFirst(8);
//        list.insertFirst(21);
//        list.insertLast(99);
//        list.insertAfter(8, 65);
//
////        list.display();
//        list.displayRev();

        // Circular Linked List
        CLL list = new CLL();
        list.insert(25);
        list.insert(12);
        list.insert(51);
        list.insert(82);
        list.display();

        list.delete(51);
        list.display();
    }
}
