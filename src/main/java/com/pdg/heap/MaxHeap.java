package com.pdg.heap;

public class MaxHeap {

    private int[] heap;
    private int size;

    public MaxHeap(int capacity) {
        heap = new int[capacity];
    }

    public void insert(int value) {
        if (isFull()) throw new IndexOutOfBoundsException("Heap is full");

        heap[size] = value;
        size++;

        fixHeapAbove(size - 1);
    }

    public int extractMax() {
        return delete(0);
    }

    public int delete(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }
        int deletedValue = heap[index];
        swap(index, size - 1);
        size--;
        heapify(index);

        return deletedValue;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        return heap[0];
    }

    private void heapify(int index) {
        int left = getChild(index, true);
        int right = getChild(index, false);
        int largest = index;

        if (left < size && heap[largest] < heap[left]) {
            largest = left;
        }
        if (right < size && heap[largest] < heap[right]) {
            largest = right;
        }

        if (largest != index) {
            swap(largest, index);
            heapify(largest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void fixHeapAbove(int index) {
        int newValue = heap[index];
        while (index > 0 && newValue > heap[getParent(index)]) {
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }
        heap[index] = newValue;
    }

    private void fixHeapBelow(int index, int lastHeapIndex) {

    }
    public boolean isFull() {
        return size == heap.length;
    }

    public int getParent(int index) {
        return (index - 1) / 2;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getChild(int index, boolean left) {
        return 2 * index + (left ? 1 : 2);
    }
}
