package com.pdg.sort;

public class HeapSort {
    public void sort(int[] arr) {
        int size = arr.length;

        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(i, size, arr);
        }

        for (int i = size - 1; i >= 0; i--) {
            swap(0, i, arr);
            heapify(0, i, arr);
        }
    }

    private void heapify(int index, int size, int[] arr) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left < size && arr[largest] < arr[left]) {
            largest = left;
        }
        if (right < size && arr[largest] < arr[right]) {
            largest = right;
        }
        if (largest != index) {
            swap(largest, index, arr);
            heapify(largest, size, arr);
        }
    }

    private void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
