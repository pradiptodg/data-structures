package com.pdg.sort;

public class MergeSort {

    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

        mergeSort(intArray, 0, intArray.length - 1);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    // { 20, 35, -15, 7, 55, 1, -22 }
    public static void mergeSort(int[] input, int start, int end) {
//        System.out.println(start + " " + end);
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(input, start, mid);
            mergeSort(input, mid+1, end);
            merge(input, start, mid, end);
        }
    }

    // { 20, 35, -15, 7, 55, 1, -22 }
    public static void merge(int[] input, int start, int mid, int end) {
        if (input[mid] <= input[mid + 1]) return;

        int i = start, j = mid + 1;
        int[] temp = new int[end - start + 1];
        int k = 0;
        while (i <= mid && j <= end) {
            if (input[i] < input[j]) {
                temp[k++] = input[i++];
            } else {
                temp[k++] = input[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = input[i++];
        }

        while (j <= end) {
            temp[k++] = input[j++];
        }

        for (k = 0; k < temp.length; k++) {
            input[start + k] = temp[k];
        }
    }

}
