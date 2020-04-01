package com.pdg.sort.challenges;

public class StringRadix {
    public static void main(String[] args) {
        String[] arr = {"zabc", "zbac", "zbaa", "zxyz", "zghi"};

        stringRadixSort(arr, 4);

        for (String s : arr) {
            System.out.print(s + " ");
        }
    }

    public static void stringRadixSort(String[] input, int width) {
        for (int i = width - 1; i >= 0; i-- ) {
            alphaCountSort(input, i, 'a', 'z');
        }
    }

    public static void alphaCountSort(String input[], int position, char start, char end) {

        int[] count = new int[end - start + 1];
        for (int i = 0; i < input.length; i++) {
            count[input[i].charAt(position) - start]++;
        }
//        int index = 0;
//        for (int i = 0; i < count.length; i++) {
//            for (int j = 0; j < count[i]; j++) {
//                input[index++] = (char)(start + i);
//            }
//        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        String[] temp = new String[input.length];
        for (int i = temp.length - 1; i >= 0; i--) {
            int key = input[i].charAt(position) - start;
            temp[count[key] - 1] = input[i];
            count[key]--;
        }

        for (int i = 0; i < input.length; i++) {
            input[i] = temp[i];
        }

        for (String s : input) System.out.print(s + " ");
        System.out.println();
    }
}
