package com.pdg.singlylinkedlist.challenge2;

import com.pdg.singlylinkedlist.ListNode;

public class IntegerLinkedList {

    protected ListNode<Integer> head;
    protected int size;

    public ListNode<Integer> getHead() {
        return head;
    }

    public void addToFront(Integer value) {
        ListNode<Integer> node = new ListNode<Integer>(value);
        node.setNext(head);
        head = node;
        size++;
    }

    public ListNode<Integer> removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        ListNode<Integer> removedNode = head;
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public void insertSorted(Integer value) {
        ListNode<Integer> newNode = new ListNode<Integer>(value);
        if (isEmpty()) {
            head = newNode;
        } else if (head.getValue() > value) {
            newNode.setNext(head);
            head = newNode;
        } else {
            ListNode<Integer> curr = head;
            ListNode<Integer> prev = null;
            while (curr != null && value > curr.getValue()) {
                prev = curr;
                curr = curr.getNext();
            }

            prev.setNext(newNode);
            newNode.setNext(curr);
        }
        size++;

    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        ListNode<Integer> current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode<Integer> current = head;
        sb.append("HEAD -> ");
        while (current != null) {
            sb.append(current);
            sb.append(" -> ");
            current = current.getNext();
        }
        sb.append("null");
        return sb.toString();
    }
}
