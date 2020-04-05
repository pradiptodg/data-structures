package com.pdg.stack;

import com.pdg.singlylinkedlist.SinglyLinkedList;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class LLStack<T> {
    SinglyLinkedList<T> stack = new SinglyLinkedList<>();

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void push(T value) {
        stack.addToFront(value);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.removeFromFront().getValue();
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.getHead().getValue();
    }

    public int size() {
        return stack.getSize();
    }

}
