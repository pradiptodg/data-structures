package com.pdg.doublylinkedList;

public class ListNode<T> {
    private T value;
    private ListNode next;
    private ListNode previous;

    public ListNode(T value) {
        this.value = value;
    }

    public T getEmployee() {
        return value;
    }

    public void setEmployee(T value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getPrevious() {
        return previous;
    }

    public void setPrevious(ListNode previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
