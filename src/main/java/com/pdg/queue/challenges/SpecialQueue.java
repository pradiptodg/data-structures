package com.pdg.queue.challenges;

import com.pdg.queue.Queue;

import java.util.NoSuchElementException;
import java.util.Stack;

public class SpecialQueue<T> implements Queue<T> {

    Stack<T> left = new Stack<>();
    Stack<T> right = new Stack<>();

    @Override
    public T peek() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        fillRight();
        return right.peek();
    }

    private void fillRight() {
        if (right.size() == 0) {
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
        }
    }

    @Override
    public void add(T value) {
        left.push(value);
    }

    @Override
    public T remove() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        fillRight();
        return right.pop();
    }

    @Override
    public int size() {
        return left.size() + right.size();
    }


}
