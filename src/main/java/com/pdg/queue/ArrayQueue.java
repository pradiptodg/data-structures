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
        if (size() == queue.length - 1) {
            int numItems = size();
            Object[] newArray = new Object[2 * queue.length];

            System.arraycopy(queue, front, newArray, 0, queue.length - front);
            System.arraycopy(queue, 0, newArray, queue.length - front, back);

            queue = newArray;

            front = 0;
            back = numItems;
        }

        // 0   jane
        // 1    john
        // 2  -   -back
        // 3  -mike - front
        // 4   -bill

        // 0 mike
        // 1 bill
        // 2 jane
        // 3 john
        // 4 - back
        // 5
        // 9


        queue[back] = value;
        if (back < queue.length - 1) {
            back++;
        }
        else {
            back = 0;
        }
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
        } else if (front == queue.length) {
            front = 0;
        }
        return value;
    }

    @SuppressWarnings("unchecked")
    public T peek()
    {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        return (T) queue[front];
    }

    public int size() {
        if (front <= back) {
            return back - front;
        }
        else {
            return back - front + queue.length;
        }

    }

    public void printQueue() {
        if (front <= back) {
            for (int i = front; i < back; i++) {
                System.out.println(queue[i]);
            }
        }
        else {
            for (int i = front; i < queue.length; i++) {
                System.out.println(queue[i]);
            }
            for (int i = 0; i < back; i++) {
                System.out.println(queue[i]);
            }
        }
    }

}
