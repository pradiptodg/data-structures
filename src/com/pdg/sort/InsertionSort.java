package com.pdg.sort;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < arr.length; firstUnsortedIndex++) {
            int newElement = arr[firstUnsortedIndex];
            int i = firstUnsortedIndex;
            while (i > 0 && arr[i - 1] > newElement) {
                arr[i] = arr[i - 1];
                i--;
            }
            arr[i] = newElement;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
