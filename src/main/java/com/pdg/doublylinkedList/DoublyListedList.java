package com.pdg.doublylinkedList;

import com.pdg.model.Employee;

public class DoublyListedList<T> {
    private ListNode head;
    private ListNode tail;
    private int size;

    public boolean isEmpty() {
        return head == null;
    }

    public void addToFront(T value) {
        ListNode node = new ListNode(value);
        node.setNext(head);
        if (head == null) {
            tail = node;
        } else {
            head.setPrevious(node);
            node.setNext(head);
        }
        head = node;
        size++;
    }
    public boolean addBefore(T newValue, T existingValue) {

        // Challenge #1
        // return true if you were able to successfully add the employee
        // into the list before the existing employee. Return false
        // if the existing employee doesn't exist in the list

//        EmployeeNode node = head;
//        if (head.getEmployee().equals(newEmployee)) {
//            addToFront(newEmployee);
//            return true;
//        }
//        while (node.getNext() != null && !node.getNext().getEmployee().equals(existingEmployee) ) {
//            node = node.getNext();
//        }
//
//        if (node.getNext() == null) {
//            return false;
//        }
//
//        EmployeeNode nextNode = node.getNext();
//        EmployeeNode newNode = new EmployeeNode(existingEmployee);
//        node.setNext(newNode);
//        newNode.setPrevious(node);
//        newNode.setNext(nextNode);
//        nextNode.setPrevious(newNode);
//        size++;
//
//        return true;
        ListNode newNode = new ListNode(newValue);
        ListNode curr = head;
        while (curr != null && !curr.getEmployee().equals(existingValue)) {
            curr = curr.getNext();
        }

        if (curr == null) return false;

        ListNode prev = curr.getPrevious();
        if (prev == null) {
            addToFront(newValue);
        } else {
            prev.setNext(newNode);
            newNode.setPrevious(prev);
            newNode.setNext(curr);
            curr.setPrevious(newNode);
            size++;
        }

        return true;
    }

    public void addToEnd(T value) {
        ListNode node = new ListNode(value);
        if (tail == null) {
            head = node;
        } else {
            node.setPrevious(tail);
            tail.setNext(node);
        }
        tail = node;
        size++;
    }

    public ListNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }
        ListNode removedNode = head;

        if (head.getNext() == null) {
            tail = null;
        } else {
            ListNode temp = head.getNext();
            temp.setPrevious(null);
        }

        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public ListNode removeFromEnd() {
        if (isEmpty()) {
            return null;
        }
        ListNode removedNode = head;

        if (tail.getPrevious() == null) {
            tail = null;
        } else {
            ListNode temp = tail.getPrevious();
            temp.setNext(null);
        }
        tail = tail.getPrevious();
        size--;
        removedNode.setPrevious(null);
        return removedNode;
    }

    public void printList() {
        ListNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current + " <=> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public int getSize() {
        return size;
    }
}
