package com.pdg.stack;

import java.util.EmptyStackException;

public class ArrayStack<T> {
    private Object[] stack;
    private int top;

    public ArrayStack(int capacity) {
        stack =  new Object[capacity];
    }

    public void push(T value) {

        if (top == stack.length) {
            Object[] newArray = new Object[2 * stack.length];
            int j = 0;
            for (int i = 0; i < stack.length; i++) {
                newArray[j] = stack[i];
            }
            stack = newArray;
        }

        stack[top] = value;
        top++;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        T value = (T) stack[top - 1];
        top--;
        stack[top] = null;
        return value;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return (T) stack[top - 1];
    }

    public boolean isEmpty() {
        return top == 0;
    }



    public int size() {
        return top;
    }

    public void printStack() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
