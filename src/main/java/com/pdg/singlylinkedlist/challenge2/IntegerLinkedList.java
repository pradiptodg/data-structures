package com.pdg.singlylinkedlist.challenge2;

public class IntegerLinkedList {

    protected IntegerNode head;
    protected int size;

    public void addToFront(Integer value) {
        IntegerNode node = new IntegerNode(value);
        node.setNext(head);
        head = node;
        size++;
    }

    public IntegerNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        IntegerNode removedNode = head;
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public void insertSorted(Integer value) {
        IntegerNode newNode = new IntegerNode(value);
        if (isEmpty()) {
            head = newNode;
        } else if (head.getValue() > value) {
            newNode.setNext(head);
            head = newNode;
        } else {
            IntegerNode curr = head;
            IntegerNode prev = null;
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
        IntegerNode current = head;
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
        IntegerNode current = head;
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
