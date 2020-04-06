package com.pdg.queue;

public interface Queue<T> {

    T peek();
    void add(T value);
    T remove();
    int size();

}
