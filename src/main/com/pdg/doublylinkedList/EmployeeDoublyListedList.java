package com.pdg.doublylinkedList;

public class EmployeeDoublyListedList {
    private EmployeeNode head;
    private EmployeeNode tail;
    private int size;

    public boolean isEmpty() {
        return head == null;
    }

    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
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
    public boolean addBefore(Employee newEmployee, Employee existingEmployee) {

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
        EmployeeNode newNode = new EmployeeNode(newEmployee);
        EmployeeNode curr = head;
        while (curr != null && !curr.getEmployee().equals(existingEmployee)) {
            curr = curr.getNext();
        }

        if (curr == null) return false;

        EmployeeNode prev = curr.getPrevious();
        if (prev == null) {
            addToFront(newEmployee);
        } else {
            prev.setNext(newNode);
            newNode.setPrevious(prev);
            newNode.setNext(curr);
            curr.setPrevious(newNode);
            size++;
        }

        return true;
    }

    public void addToEnd(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        if (tail == null) {
            head = node;
        } else {
            node.setPrevious(tail);
            tail.setNext(node);
        }
        tail = node;
        size++;
    }

    public EmployeeNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }
        EmployeeNode removedNode = head;

        if (head.getNext() == null) {
            tail = null;
        } else {
            EmployeeNode temp = head.getNext();
            temp.setPrevious(null);
        }

        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public EmployeeNode removeFromEnd() {
        if (isEmpty()) {
            return null;
        }
        EmployeeNode removedNode = head;

        if (tail.getPrevious() == null) {
            tail = null;
        } else {
            EmployeeNode temp = tail.getPrevious();
            temp.setNext(null);
        }
        tail = tail.getPrevious();
        size--;
        removedNode.setPrevious(null);
        return removedNode;
    }

    public void printList() {
        EmployeeNode current = head;
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
