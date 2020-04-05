package com.pdg.stack.challenges;

import com.pdg.stack.LLStack;

public class PalindromeChecker {
    public static boolean checkForPalindrome(String string) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {


//            if (string.charAt(i) != ',' && string.charAt(i) != ' ' && string.charAt(i) != 39 && string.charAt(i) != '?' && string.charAt(i) != '.') {
            if (Character.isAlphabetic(string.charAt(i))) {
                sb.append(string.charAt(i));
            }
        }

        String s = sb.toString().toLowerCase();

        LLStack<Character> stack = new LLStack<>();
        int mid = s.length() / 2;
        int i = 0;
        while (i < mid) {
            stack.push(s.charAt(i));
            i++;
        }

        i = s.length() % 2 != 0? i + 1 : i;
        while (i < s.length()) {
            if (stack.pop() != s.charAt(i)) {
                return false;
            }
            i++;
        }
        return true;
    }
}
