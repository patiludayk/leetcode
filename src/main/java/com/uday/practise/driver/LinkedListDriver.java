package com.uday.practise.driver;

import com.uday.practise.ds.LinkedList;

public class LinkedListDriver {

    public static void main(String[] args) {

        //1. add node to head of linkedlist / add element to start/front of list
        LinkedList ll = new LinkedList();
        ll.addToHead(1);
        ll.addToHead(2);
        ll.addToHead(6);
        ll.addToHead(3);
        System.out.println("size: " + ll.size() + " list:" + ll);

        //2. add node to tail of linkedlist / add element to end of list
        LinkedList ll1 = new LinkedList();
        ll1.addToTail(1);
        ll1.addToTail(2);
        ll1.addToTail(6);
        ll1.addToTail(3);
        ll1.addToTail(7);
        System.out.println("size: " + ll1.size() + " list:" + ll1);

        //3. find mid of linkedlist
        LinkedList ll2 = new LinkedList();
        ll2.addToTail(1);
        ll2.addToTail(2);
        ll2.addToTail(3);
        ll2.addToTail(4);
        ll2.addToTail(5);
        ll2.addToTail(6);
        ll2.addToTail(7);
        ll2.addToTail(8);
        //ll2.addToTail(9);
        //ll2.addToTail(10);
        //ll2.addToTail(11);
        System.out.println("size: " + ll2.size() + " list:" + ll2 + " mid of list: " + ll2.midOfList());

        //4. search element in list - unsorted list - sorting algorithms question but here it just linked list question
        LinkedList ll3 = new LinkedList();
        ll3.addToTail(1);
        ll3.addToTail(2);
        ll3.addToTail(3);
        ll3.addToTail(4);
        ll3.addToTail(5);
        ll3.addToTail(6);
        ll3.addToTail(7);
        ll3.addToTail(8);
        ll3.addToTail(9);
        System.out.println("size: " + ll3.size() + " list:" + ll3 + " contains: " + ll3.contains(1));

        //5. find loop in list
        LinkedList ll4 = new LinkedList();
        ll4.addToTail(1);
        ll4.addToTail(2);
        ll4.addToTail(3);
        ll4.addToTail(4);
        ll4.addToTail(5);
        ll4.addToTail(6);
        ll4.addToTail(7);
        ll4.addToTail(8);
        ll4.addToTail(9);
        ll4.addToTail(8);

        //ll4.head.next.next.next = ll4.head;   // this is to create a loop
        System.out.println("size: " + ll4.size() + " list:" + ll4 + " has loop: " + ll4.hasLoop());

        //5. remove head
        LinkedList ll5 = new LinkedList();
        ll5.addToTail(1);
        ll5.addToTail(2);
        ll5.addToTail(3);
        ll5.addToTail(4);
        ll5.addToTail(5);
        ll5.addToTail(6);
        ll5.addToTail(7);
        ll5.addToTail(8);
        ll5.addToTail(9);

        System.out.print("size: " + ll5.size() + " list:" + ll5);
        ll5.removeFromHead();
        System.out.println(" new list:" + ll5);

        //6. remove head
        LinkedList ll6 = new LinkedList();
        ll6.addToTail(1);
        ll6.addToTail(2);
        ll6.addToTail(3);
        ll6.addToTail(4);
        ll6.addToTail(5);
        ll6.addToTail(6);
        ll6.addToTail(7);
        ll6.addToTail(8);
        ll6.addToTail(9);

        System.out.print("size: " + ll6.size() + " list:" + ll6);
        ll6.removeFromTail();
        System.out.println(" new list:" + ll6);


    }
}
