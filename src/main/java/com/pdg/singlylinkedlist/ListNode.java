package com.pdg.singlylinkedlist;

public class ListNode<T> {
    private T value;
    private ListNode next;

    public ListNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
