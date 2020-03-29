package com.pdg.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Written by Sudipta
 */
public class NewSort {
    public static void main(String[] args) {
        Integer[] radixArray = { 4725, 4586, 1330, 8792, 1594, 5729 };
        List<Integer> sortedArray = newSort(Arrays.asList(radixArray), 3);

        for (int n: sortedArray) {
            System.out.println(n);
        }
    }

    public static List<Integer> newSort(List<Integer> input, int power) {
        if (power < 0) return input;

        List<Integer>[] counter = new List[10];
        for (int i = 0; i < 10; i++) {
            counter[i] = new ArrayList<>();
        }
        List<Integer> sorted = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            int x = input.get(i);
            int key = (x / (int)Math.pow(10, power)) % 10;
            counter[key].add(x);
        }

        for (int i = 0; i < 10; i++) {
            if (counter[i].size() > 0) {
                sorted.addAll(newSort(counter[i], power - 1));
            }
        }

        return sorted;
    }
}
