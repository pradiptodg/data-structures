package com.pdg.sort.challenges;

public class InsertionSortRecursion {
    public static void main(String[] args) {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};
        insertionSort(arr, arr.length);



        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void insertionSort(int[] input, int length) {

            if (length < 2) {
                return;
            }

            insertionSort(input, length - 1);

            int newElement = input[length - 1];
            int i = length - 1;
            while (i > 0 && input[i - 1] > newElement) {
                input[i] = input[i - 1];
                i--;
            }
            input[i] = newElement;

    }
}
