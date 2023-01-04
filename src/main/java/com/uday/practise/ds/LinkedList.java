package com.uday.practise.ds;

/**
 * making Node class and its member public to get access in driver program for some problems like detect loop
 * similarly making head of linkedlist public for same above reason
 */
public class LinkedList {

    public Node head;

    public LinkedList() {
        this.head = null;
    }

    public Node addToHead(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node temp = new Node(data);
            temp.next = head;
            head = temp;
        }

        return head;
    }

    public Node addToTail(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = new Node(data);
        }
        return head;
    }

    public int size() {
        Node temp = head;
        int length = 1;

        if (head == null) {
            return 0;
        }

        while (temp.next != null) {
            ++length;

            temp = temp.next;
        }

        return length;
    }

    public int sizeUsingRecursive(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + sizeUsingRecursive(node.next);
        }

    }

    public int midOfList() {
        //Note: 2 pointer approach
        if (head == null) {
            throw new RuntimeException("empty list");
        } else {
            Node slow = head;   //slow pointer
            Node fast = head; //or fast = head.next  //fast pointer
            while (fast != null && fast.next != null) {   //check fast pointer and its next node is not null
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow.data;
        }
    }

    public boolean contains(int element) {
        boolean found = false;
        Node temp = head;
        while (temp != null) {
            if (temp.data == element) {
                found = true;
                break;
            }
            temp = temp.next;
        }
        return found;
    }

    public boolean hasLoop() {
        if (head == null || head.next == null) {
            return false;
        }

        Node slow = head;   //slow pointer
        Node fast = head.next;   //fast pointer
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public void removeFromHead(){
        head = head.next;
    }

    public void removeFromTail(){
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    public String toString() {
        StringBuilder output = new StringBuilder("");
        if (head == null) {
            output.append("null");
        }
        Node temp = head;
        while (temp != null) {
            output.append(" ").append(temp.data);

            temp = temp.next;
        }
        return output.toString();
    }

    public class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
