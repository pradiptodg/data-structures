package com.pdg.queue;

import java.util.NoSuchElementException;

public class ArrayQueue<T> implements Queue<T>{
    private Object[] queue;
    private int back;
    private int front;

    public ArrayQueue(int capacity) {
        queue = new Object[capacity];
    }

    public void add(T value) {
        if (back == queue.length) {
            Object[] temp = new Object[2 * queue.length];
            for (int i = 0; i < queue.length; i++) {
                temp[i] = queue[i];
            }
            queue = temp;
        }

        queue[back] = value;
        back++;
    }

    @SuppressWarnings("unchecked")
    public T remove() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        T value = (T) queue[front];
        queue[front] = null;
        front++;
        if (size() == 0) {
            front = back = 0;
        }
        return value;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        T value = (T) queue[front];
        return value;
    }

    public int size() {
        return back - front;
    }

    public void printQueue() {
        for (int i = front; i < back; i++) {
            System.out.println(queue[i]);
        }
    }

}
