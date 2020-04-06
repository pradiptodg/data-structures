package com.pdg.queue.challenges;

import com.pdg.queue.Queue;
import com.pdg.stack.LLStack;

public class PalindromeChecker {
    public static boolean checkForPalindrome(String string) {
        if (string.length() < 2) {
            return true;
        }
        Queue<Character> queue = new SpecialQueue<>();
        LLStack<Character> stack = new LLStack<>();

        string = string.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (Character.isAlphabetic(string.charAt(i))) {
                sb.append(string.charAt(i));
            }
        }
        string = sb.toString();


        for (int i = 0; i < string.length(); i++) {
            stack.push(string.charAt(i));
            queue.add(string.charAt(i));
        }

        for (int i = 0; i < string.length(); i++) {
            if (stack.pop() != queue.remove()) {
                return false;
            }
        }

        return true;
    }
}
