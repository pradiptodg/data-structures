package com.pdg.sort;

public class CountingSort {
    public static void main(String[] args) {
        int[] input = {1, 6, 9, 3, 5, 3, 10, 1};
        countingSort(input, 10);
        for (int el : input) {
            System.out.print(el + " ");
        }
    }

    public static void countingSort(int[] input, int range) {
        int[] count = new int[range];
        for (int i = 0; i < input.length; i++) {
            count[input[i] - 1]++;
        }

        int index = 0;

        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                input[index++] = i+1;
            }
        }
    }
}
