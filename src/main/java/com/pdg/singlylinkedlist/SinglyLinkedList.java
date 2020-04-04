package com.pdg.singlylinkedlist;

public class SinglyLinkedList<T> {
    private ListNode<T> head;
    private int size;

    public boolean isEmpty() {
        return head == null;
    }

    public ListNode<T> getHead() {
        return head;
    }

    public void addToFront(T employee) {
        ListNode<T> node = new ListNode<>(employee);
        node.setNext(head);
        head = node;
        size++;
    }

    public ListNode<T> removeFromFront() {
        if (isEmpty()) {
            return null;
        }
        ListNode<T> removedNode = head;
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public void printList() {
        ListNode<T> current = head;
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
