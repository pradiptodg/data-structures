package com.pdg.sort;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = { 4725, 4586, 1330, 8792, 1594, 5729 };
        radixSort(arr,4);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void radixSort(int[] input, int width) {
        for (int i = 0; i < width; i++) {
            input = countingSort(input, i);
        }
    }

    public static int[] countingSort(int[] input, int position) {
        int[] count = new int[10];

        for (int i = 0; i < input.length; i++) {
            int key = input[i] / (int) Math.pow(10, position) % 10;
            count[key]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int[] temp = new int[input.length];

        for (int i = temp.length - 1; i >= 0; i--) {
            int key = input[i] / (int) Math.pow(10, position) % 10;
            temp[count[key] - 1] = input[i];
            count[key]--;
        }

        for (int i = 0; i < temp.length; i++) {
            input[i] = temp[i];
        }

        return input;
    }
}
