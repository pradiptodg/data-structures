package com.pdg.singlylinkedlist;

public class EmployeeLinkedList {
    private ListNode<Employee> head;
    private int size;

    public boolean isEmpty() {
        return head == null;
    }

    public void addToFront(Employee employee) {
        ListNode<Employee> node = new ListNode<>(employee);
        node.setNext(head);
        head = node;
        size++;
    }

    public ListNode<Employee> removeFromFront() {
        if (isEmpty()) {
            return null;
        }
        ListNode<Employee> removedNode = head;
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public void printList() {
        ListNode<Employee> current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current + " -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public int getSize() {
        return size;
    }
}
