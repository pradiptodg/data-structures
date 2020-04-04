package com.pdg.sort;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int j = gap; j < arr.length; j++) {
                int newElement = arr[j];
                int i = j;
                while (i >= gap && arr[i - gap] > newElement) {
                    arr[i] = arr[i - gap];
                    i -= gap;
                }
                arr[i] = newElement;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
