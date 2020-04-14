package com.pdg.heap;

import com.pdg.sort.HeapSort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxHeapTest {

    MaxHeap maxHeap;

    @BeforeEach
    void setUp() {
        maxHeap = new MaxHeap(10);
    }

    @Test
    void testMaxHeap() {
        maxHeap.insert(5);
        maxHeap.insert(1);
        maxHeap.insert(4);
        maxHeap.insert(7);

        assertEquals(maxHeap.extractMax(), 7);
        assertEquals(maxHeap.extractMax(), 5);
        assertEquals(maxHeap.extractMax(), 4);
        assertEquals(maxHeap.extractMax(), 1);
        assertThrows(IndexOutOfBoundsException.class, () -> maxHeap.peek());

        maxHeap.insert(4);
        maxHeap.insert(6);
        maxHeap.insert(1);
        maxHeap.insert(10);
        assertEquals(maxHeap.peek(), 10);
        maxHeap.delete(3);
        maxHeap.insert(3);
        assertEquals(maxHeap.delete(0), 10);

    }

    @Test
    void testEmptyHeap() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            maxHeap.delete(0);
        });
    }

    @Test
    void testFullHeap() {
        maxHeap.insert(5);
        maxHeap.insert(1);
        maxHeap.insert(4);
        maxHeap.insert(7);
        maxHeap.insert(2);
        maxHeap.insert(6);
        maxHeap.insert(10);
        maxHeap.insert(9);
        maxHeap.insert(8);
        maxHeap.insert(11);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            maxHeap.insert(6);
        });
    }

    @Test
    void testSort() {
        int[] array = {10, 8, 6, 1, 2, 7, 9};
        int[] actual = {1, 2, 6, 7, 8, 9, 10};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(array);

        for (int i = 0; i < array.length; i++) {
            assertEquals(array[i], actual[i]);
        }
    }

}