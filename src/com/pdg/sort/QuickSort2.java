package com.pdg.sort;

public class QuickSort2 {
    public static void main(String[] args) {
        int[] input = {20, 35, -15, 7, 55, 1, -22};

        quickSort(input, 0, input.length - 1);
//        partition(input, 0, input.length - 1);
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }

    public static void quickSort(int[] input, int start, int end) {
        if (end < start) {
            return;
        }

        int pivotIndex = partition(input, start, end);
        quickSort(input, start, pivotIndex - 1);
        quickSort(input, pivotIndex + 1, end);
    }

    private static int partition(int[] input, int start, int end) {
        int pivot = input[start];
        int i = start + 1;
        int j = end + 1;

        while (i < j) {
            if (input[i] > pivot) {
                j--;
                swap(input, i, j);
            } else {
                i++;
            }
        }


        swap(input, i - 1, start);
        return i - 1;

    }

    public static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
